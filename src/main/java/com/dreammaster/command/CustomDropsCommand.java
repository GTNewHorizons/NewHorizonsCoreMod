package com.dreammaster.command;

import java.util.Arrays;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;

import com.dreammaster.main.MainRegistry;

import net.minecraft.util.ChatComponentTranslation;

public class CustomDropsCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "customdrops";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "dreamcraft.command.customdrops.usage";
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("cdrops", "cdr");
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            throw new WrongUsageException(getCommandUsage(sender));
        } else if ("toggleinfo".equalsIgnoreCase(args[0])) {
            EntityPlayer targetPlayer;

            if (args.length == 2) {
                targetPlayer = getPlayer(sender, args[1]);
            } else if (sender instanceof EntityPlayer entityPlayer) {
                targetPlayer = entityPlayer;
            } else {
                throw new PlayerNotFoundException();
            }

            MainRegistry.Module_CustomDrops.toggleDeathInfoForPlayer(targetPlayer);
        } else if ("reload".equalsIgnoreCase(args[0])) {
            if (MainRegistry.Module_CustomDrops.ReloadCustomDrops()) {
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
            return getListOfStringsMatchingLastWord(args, "toggleinfo", "reload");
        }
        return null;
    }
}
