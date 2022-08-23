package com.dreammaster.command;

import com.dreammaster.main.MainRegistry;
import eu.usrv.yamcore.auxiliary.PlayerChatHelper;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CustomToolTipsCommand implements ICommand {
    private List aliases;

    public CustomToolTipsCommand() {
        aliases = new ArrayList();
        aliases.add("ctooltip");
        aliases.add("ctt");
    }

    @Override
    public int compareTo(Object arg0) {
        return 0;
    }

    @Override
    public String getCommandName() {
        return "customtooltips";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/customtooltips reload";
    }

    @Override
    public List getCommandAliases() {

        return aliases;
    }

    @Override
    public void processCommand(ICommandSender pCmdSender, String[] pArgs) {
        if (pArgs.length == 0) {
            if (InGame(pCmdSender)) {
                PlayerChatHelper.SendError(pCmdSender, "Syntax error. Type /customtooltips help for help");
            } else {
                PlayerChatHelper.SendPlain(pCmdSender, "[CTT] Syntax error. Type /customtooltips help for help");
            }
            return;
        } else if ("help".equalsIgnoreCase(pArgs[0])) {
            SendHelpToPlayer(pCmdSender);
        } else if ("reload".equalsIgnoreCase(pArgs[0])) {
            boolean tFlag = MainRegistry.Module_CustomToolTips.reload();
            if (!tFlag) {
                if (!InGame(pCmdSender)) {
                    PlayerChatHelper.SendPlain(pCmdSender, "[CTT] Reload failed. Check your log for syntax errors");
                } else {
                    PlayerChatHelper.SendWarn(pCmdSender, "Reload failed. Check your log for syntax errors");
                }
            } else {
                if (!InGame(pCmdSender)) {
                    PlayerChatHelper.SendPlain(pCmdSender, "[CTT] Reload done. New config is activated");
                } else {
                    PlayerChatHelper.SendInfo(pCmdSender, "Reload done. New config is activated");
                }
            }
        } else {
            SendHelpToPlayer(pCmdSender);
        }
    }

    private boolean InGame(ICommandSender pCmdSender) {
        return pCmdSender instanceof EntityPlayer;
    }

    private void SendHelpToPlayer(ICommandSender pCmdSender) {
        if (!InGame(pCmdSender)) {
            PlayerChatHelper.SendPlain(pCmdSender, "[CTT] Valid options are: reload");
        } else {
            PlayerChatHelper.SendInfo(pCmdSender, "/customtooltips reload");
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender pCommandSender) {
        if (pCommandSender instanceof EntityPlayerMP) {
            EntityPlayerMP tEP = (EntityPlayerMP) pCommandSender;
            boolean tPlayerOpped =
                    MinecraftServer.getServer().getConfigurationManager().func_152596_g(tEP.getGameProfile());
            // boolean tIncreative = tEP.capabilities.isCreativeMode;
            return tPlayerOpped; // && tIncreative;
        } else {
            return pCommandSender instanceof MinecraftServer;
        }
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
        return false;
    }
}
