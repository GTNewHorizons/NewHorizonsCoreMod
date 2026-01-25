package com.dreammaster.command;

import java.util.Arrays;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.potion.Potion;

import com.dreammaster.main.MainRegistry;

import net.minecraft.util.ChatComponentTranslation;

public class HazardousItemsCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "hazarditems";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/hazarditems <action> [<parm1>, <parm2>, ..]";
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("hazarditems", "hazit");
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            throw new WrongUsageException(getCommandUsage(sender));
        } else if ("save".equalsIgnoreCase(args[0])) {
            if (MainRegistry.Module_HazardousItems.SaveHazardousItems()) {
                sender.addChatMessage(new ChatComponentTranslation("dreamcraft.command.hazarditems.save.success"));
            } else {
                sender.addChatMessage(new ChatComponentTranslation("dreamcraft.command.hazarditems.save.failure"));
            }
        } else if ("listdamagesources".equalsIgnoreCase(args[0])) {
            sender.addChatMessage(new ChatComponentTranslation("dreamcraft.command.hazarditems.damage_source_list"));
        } else if ("listpotions".equalsIgnoreCase(args[0])) {
            sendPotionsToPlayer(sender);
        } else if ("reload".equalsIgnoreCase(args[0])) {
            boolean force = args.length == 2 && "force".equalsIgnoreCase(args[1]);

            if (MainRegistry.Module_HazardousItems.HasConfigChanged() && !force) {
                sender.addChatMessage(new ChatComponentTranslation("dreamcraft.command.hazarditems.reload.unsafe"));
            } else if (MainRegistry.Module_HazardousItems.ReloadHazardousItems()) {
                sender.addChatMessage(new ChatComponentTranslation("dreamcraft.command.reload.success"));
            } else {
                sender.addChatMessage(new ChatComponentTranslation("dreamcraft.command.reload.failure"));
            }
        } else {
            throw new WrongUsageException(getCommandUsage(sender));
        }
    }

    /**
     * Send a list of all valid potions to the command sender
     *
     */
    private void sendPotionsToPlayer(ICommandSender sender) {
        sender.addChatMessage(new ChatComponentTranslation("dreamcraft.command.hazarditems.potion.header"));

        for (Potion potion : Potion.potionTypes) {
            if (potion == null) continue;

            sender.addChatMessage(new ChatComponentTranslation(
                    "dreamcraft.command.hazarditems.potion.entry",
                    new ChatComponentTranslation(potion.getName()),
                    potion.id));
        }
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            return getListOfStringsMatchingLastWord(args, "reload", "save", "listpotions", "listdamagesources");
        } else if (args.length == 2 && "reload".equalsIgnoreCase(args[0])) {
            return getListOfStringsMatchingLastWord(args, "force");
        }
        return null;
    }
}
