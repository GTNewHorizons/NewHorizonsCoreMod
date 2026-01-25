package com.dreammaster.command;

import java.util.Arrays;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentTranslation;

import com.dreammaster.main.MainRegistry;

public class CustomToolTipsCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "customtooltips";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "dreamcraft.command.customtooltips.usage";
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("ctooltip", "ctt");
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            throw new WrongUsageException(getCommandUsage(sender));
        } else if ("reload".equalsIgnoreCase(args[0])) {
            if (MainRegistry.Module_CustomToolTips.reload()) {
                sender.addChatMessage(new ChatComponentTranslation("dreamcraft.command.reload.success"));
            } else {
                sender.addChatMessage(new ChatComponentTranslation("dreamcraft.command.reload.failure"));
            }
        } else {
            throw new WrongUsageException(getCommandUsage(sender));
        }
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            return getListOfStringsMatchingLastWord(args, "reload");
        }
        return null;
    }
}
