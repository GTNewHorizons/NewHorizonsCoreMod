package com.dreammaster.command;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedHashSet;
import java.util.List;

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
 * (`/sgcalc csv`) or as MediaWiki tables (`/sgcalc wiki`). Behaviour is driven entirely by `config/sgcalc.json`.
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
        if (!mode.equals("csv") && !mode.equals("wiki")) {
            throw new WrongUsageException(getCommandUsage(sender));
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

    private void run(ICommandSender sender, String mode) throws Exception {
        SGCalcConfig config = SGCalcConfig.loadOrCreate(new File("config", "sgcalc.json"));
        if (config.loadWarning != null) {
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.YELLOW + config.loadWarning));
        }
        RecipeIndex index = RecipeIndex.build();
        CostResolver resolver = new CostResolver(index, config.selector());

        List<CostResolver.Root> roots = config.roots();
        CostResolver.PassResult high = resolver.resolve(roots, config.highLevelFrontier(), config.boldFrontier());
        CostResolver.PassResult low = resolver.resolve(roots, config.lowLevelFrontier(), config.boldFrontier());

        File dir = new File(config.outputDir);
        dir.mkdirs();
        writeTrace(dir, resolver.trace());

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
                                + " outputs. Unresolved leaves: high="
                                + high.unresolvedCount
                                + ", low="
                                + low.unresolvedCount
                                + " (see sgcalc-trace.log)."));
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
            return getListOfStringsMatchingLastWord(args, "csv", "wiki");
        }
        return null;
    }
}
