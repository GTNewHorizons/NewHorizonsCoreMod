package com.dreammaster.command;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.sgcalc.CostResolver;
import com.dreammaster.sgcalc.CsvWriter;
import com.dreammaster.sgcalc.RecipeIndex;
import com.dreammaster.sgcalc.SGCalcConfig;
import com.dreammaster.sgcalc.WikiWriter;

/**
 * Resolves the full crafting cost of one Stargate and writes a high-level and low-level breakdown, either as CSV
 * (`/sgcalc csv`) or as MediaWiki tables (`/sgcalc wiki`). `/sgcalc reload` re-reads and validates the config without
 * resolving. Behaviour is driven entirely by `config/sgcalc.json`.
 */
public class SGCalcCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "sgcalc";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "dreamcraft.command.sgcalc.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length != 1) {
            throw new WrongUsageException(getCommandUsage(sender));
        }
        String mode = args[0].toLowerCase();
        if (!mode.equals("csv") && !mode.equals("wiki") && !mode.equals("reload")) {
            throw new WrongUsageException(getCommandUsage(sender));
        }

        if (mode.equals("reload")) {
            reload(sender);
            return;
        }

        sender.addChatMessage(
                new ChatComponentText(EnumChatFormatting.GRAY + "Resolving Stargate cost, please wait..."));
        try {
            run(sender, mode);
        } catch (Exception e) {
            MainRegistry.LOGGER.error("sgcalc failed", e);
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "sgcalc failed: " + e.getMessage()));
        }
    }

    /**
     * Re-reads `config/sgcalc.json` and reports whether it parsed, without running the resolver. The config is read
     * fresh on every {@code csv}/{@code wiki} run anyway, so this is a quick way to validate edits in place.
     */
    private void reload(ICommandSender sender) {
        try {
            SGCalcConfig config = SGCalcConfig.loadOrCreate(new File("config", "sgcalc.json"));
            if (config.loadWarning != null) {
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.YELLOW + config.loadWarning));
                return;
            }
            sender.addChatMessage(
                    new ChatComponentText(
                            EnumChatFormatting.GREEN + "Reloaded config/sgcalc.json: "
                                    + EnumChatFormatting.WHITE
                                    + config.composition.size()
                                    + " composition, "
                                    + config.highLevelSet.size()
                                    + " high-level, "
                                    + config.lowLevelSet.size()
                                    + " low-level, "
                                    + config.overrides.size()
                                    + " overrides, "
                                    + config.denySources.size()
                                    + " denied, "
                                    + config.rawSources.size()
                                    + " raw sources."));
        } catch (Exception e) {
            MainRegistry.LOGGER.error("sgcalc reload failed", e);
            sender.addChatMessage(
                    new ChatComponentText(EnumChatFormatting.RED + "sgcalc reload failed: " + e.getMessage()));
        }
    }

    private void run(ICommandSender sender, String mode) throws Exception {
        SGCalcConfig config = SGCalcConfig.loadOrCreate(new File("config", "sgcalc.json"));
        if (config.loadWarning != null) {
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.YELLOW + config.loadWarning));
        }
        RecipeIndex index = RecipeIndex.build(config.rawSources, config.rawProviders);
        CostResolver resolver = new CostResolver(index, config.selector(index));

        List<CostResolver.Root> roots = config.roots();
        // Raw-source outputs stop recursing in both passes; the low-level pass counts them as raws, while the
        // high-level pass treats them as below-frontier leaves diverted to the unresolved list.
        Set<String> rawStops = index.rawOutputs();
        CostResolver.PassResult high = resolver
                .resolve(roots, config.highLevelFrontier(), config.boldFrontier(), rawStops, false);
        CostResolver.PassResult low = resolver
                .resolve(roots, config.lowLevelFrontier(), config.boldFrontier(), rawStops, true);

        File dir = new File(config.outputDir);
        dir.mkdirs();
        writeTrace(dir, resolver.trace());
        reply(sender, CsvWriter.write(dir, "unresolved-high.csv", high.unresolved));
        reply(sender, CsvWriter.write(dir, "unresolved-low.csv", low.unresolved));

        if (mode.equals("csv")) {
            reply(sender, CsvWriter.write(dir, "high-level.csv", high.entries));
            reply(sender, CsvWriter.write(dir, "low-level.csv", low.entries));
        } else {
            reply(sender, WikiWriter.write(dir, "wiki-tables.txt", high.entries, low.entries));
        }

        sender.addChatMessage(
                new ChatComponentText(
                        EnumChatFormatting.GRAY + "Indexed "
                                + index.recipeCount()
                                + " recipes across "
                                + index.indexedOutputs()
                                + " outputs ("
                                + index.inputlessCount()
                                + " inputless recipes excluded). Below-frontier leaves: high="
                                + high.unresolvedCount()
                                + ", low="
                                + low.unresolvedCount()
                                + " (see unresolved-*.csv to extend the config)."));
    }

    private void reply(ICommandSender sender, File file) {
        sender.addChatMessage(
                new ChatComponentText(
                        EnumChatFormatting.GREEN + "Wrote " + EnumChatFormatting.WHITE + file.getAbsolutePath()));
    }

    private void writeTrace(File dir, List<String> trace) throws Exception {
        LinkedHashSet<String> lines = new LinkedHashSet<>(trace);
        Files.write(
                new File(dir, "sgcalc-trace.log").toPath(),
                String.join("\n", lines).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            return getListOfStringsMatchingLastWord(args, "csv", "wiki", "reload");
        }
        return null;
    }
}
