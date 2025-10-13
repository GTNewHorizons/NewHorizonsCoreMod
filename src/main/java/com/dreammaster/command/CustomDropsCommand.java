package com.dreammaster.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

import com.dreammaster.main.MainRegistry;

import eu.usrv.yamcore.auxiliary.PlayerChatHelper;

public class CustomDropsCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "customdrops";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/customdrops reload|toggleinfo";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("cdrops");
        aliases.add("cdr");
        return aliases;
    }

    @Override
    public void processCommand(ICommandSender pCmdSender, String[] pArgs) {
        if (pArgs.length == 0) {
            if (inGame(pCmdSender)) {
                PlayerChatHelper.SendError(pCmdSender, "Syntax error. Type /customdrops help for help");
            } else {
                PlayerChatHelper.SendPlain(pCmdSender, "[CDRP] Syntax error. Type /customdrops help for help");
            }
        } else if ("help".equalsIgnoreCase(pArgs[0])) {
            sendHelpToPlayer(pCmdSender);
        } else if ("toggleinfo".equalsIgnoreCase(pArgs[0])) {
            if (!inGame(pCmdSender)) {
                PlayerChatHelper.SendPlain(pCmdSender, "[CDRP] This command can only be executed in game");
            } else {
                EntityPlayer tEP = (EntityPlayer) pCmdSender;
                MainRegistry.Module_CustomDrops.toggleDeathInfoForPlayer(tEP);
            }
        } else if ("reload".equalsIgnoreCase(pArgs[0])) {
            boolean tFlag = MainRegistry.Module_CustomDrops.ReloadCustomDrops();
            if (!tFlag) {
                if (!inGame(pCmdSender)) {
                    PlayerChatHelper.SendPlain(pCmdSender, "[CDRP] Reload failed. Check your log for syntax errors");
                } else {
                    PlayerChatHelper.SendWarn(pCmdSender, "Reload failed. Check your log for syntax errors");
                }
            } else {
                if (!inGame(pCmdSender)) {
                    PlayerChatHelper.SendPlain(pCmdSender, "[CDRP] Reload done. New config is activated");
                } else {
                    PlayerChatHelper.SendInfo(pCmdSender, "Reload done. New config is activated");
                }
            }
        } else {
            sendHelpToPlayer(pCmdSender);
        }
    }

    private boolean inGame(ICommandSender pCmdSender) {
        return pCmdSender instanceof EntityPlayer;
    }

    private void sendHelpToPlayer(ICommandSender pCmdSender) {
        if (!inGame(pCmdSender)) {
            PlayerChatHelper.SendPlain(pCmdSender, "[CDRP] Valid options are: reload");
        } else {
            PlayerChatHelper.SendInfo(pCmdSender, "/customdrops reload|toggleinfo");
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender pCommandSender) {
        if (pCommandSender instanceof EntityPlayerMP tEP) {
            return MinecraftServer.getServer().getConfigurationManager().func_152596_g(tEP.getGameProfile());
        } else {
            return pCommandSender instanceof MinecraftServer;
        }
    }
}
