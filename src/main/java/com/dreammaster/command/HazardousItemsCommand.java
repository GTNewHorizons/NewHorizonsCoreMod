package com.dreammaster.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;

import com.dreammaster.main.MainRegistry;

import eu.usrv.yamcore.auxiliary.PlayerChatHelper;

public class HazardousItemsCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "hazarditems";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/hazarditems <action> [<parm1>, <parm2>, ..]";
    }

    @Override
    public List<String> getCommandAliases() {
        ArrayList<String> aliases = new ArrayList<>();
        aliases.add("hazarditems");
        aliases.add("hazit");
        return aliases;
    }

    @Override
    public void processCommand(ICommandSender pCmdSender, String[] pArgs) {
        if (pArgs.length == 0) {
            if (inGame(pCmdSender)) {
                PlayerChatHelper.SendError(pCmdSender, "Syntax error. Type /hazarditems help for help");
            } else {
                PlayerChatHelper.SendPlain(pCmdSender, "[HAZIT] Syntax error. Type /hazarditems help for help");
            }
        } else if ("help".equalsIgnoreCase(pArgs[0])) {
            sendHelpToPlayer(pCmdSender);
        } else if ("save".equalsIgnoreCase(pArgs[0])) {
            boolean tResult = MainRegistry.Module_HazardousItems.SaveHazardousItems();
            if (!inGame(pCmdSender)) {
                if (tResult) {
                    PlayerChatHelper.SendPlain(pCmdSender, "[OK] Config has been saved");
                } else {
                    PlayerChatHelper.SendPlain(pCmdSender, "[ERROR] Config could not be saved. Check your logfiles");
                }
            } else {
                if (tResult) {
                    PlayerChatHelper.SendInfo(pCmdSender, "Config has been saved");
                } else {
                    PlayerChatHelper.SendError(pCmdSender, "Config could not be saved. Check your logfiles");
                }
            }

        } else if ("listdamagesources".equalsIgnoreCase(pArgs[0])) {
            if (!inGame(pCmdSender)) {
                PlayerChatHelper.SendPlain(pCmdSender, "[HAZIT] Valid DamageTypes are:");
                PlayerChatHelper
                        .SendPlain(pCmdSender, "[HAZIT] inFire, onFire, lava, inWall, drown, starve, cactus, fall");
                PlayerChatHelper
                        .SendPlain(pCmdSender, "[HAZIT] outOfWorld, generic, magic, wither, anvil, fallingBlock");
            } else {
                PlayerChatHelper.SendInfo(pCmdSender, "Valid DamageTypes are:");
                PlayerChatHelper.SendInfo(pCmdSender, "inFire, onFire, lava, inWall, drown, starve, cactus, fall");
                PlayerChatHelper.SendInfo(pCmdSender, "outOfWorld, generic, magic, wither, anvil, fallingBlock");
            }
        } else if ("listpotions".equalsIgnoreCase(pArgs[0])) {
            sendPotionsToPlayer(pCmdSender);
        } else if ("reload".equalsIgnoreCase(pArgs[0])) {
            boolean bForce = false;
            if (pArgs.length == 2) {
                String pSecondArg = pArgs[1];
                if ("force".equalsIgnoreCase(pSecondArg)) {
                    bForce = true;
                }
            }

            if (MainRegistry.Module_HazardousItems.HasConfigChanged() && !bForce) {
                if (!inGame(pCmdSender)) {
                    PlayerChatHelper.SendPlain(pCmdSender, "[HAZIT] Config file has changed and was not saved yet.");
                    PlayerChatHelper.SendPlain(pCmdSender, "[HAZIT] To confirm the reload, type");
                    PlayerChatHelper.SendPlain(pCmdSender, "[HAZIT] /hazarditems reload force");
                } else {
                    PlayerChatHelper.SendWarn(pCmdSender, "Config file has changed and was not saved yet.");
                    PlayerChatHelper.SendWarn(pCmdSender, "To confirm the reload, type");
                    PlayerChatHelper.SendWarn(pCmdSender, "/hazarditems reload force");
                }

            } else {
                boolean tFlag = MainRegistry.Module_HazardousItems.ReloadHazardousItems();
                if (!tFlag) {
                    if (!inGame(pCmdSender)) {
                        PlayerChatHelper
                                .SendPlain(pCmdSender, "[HAZIT] Reload failed. Check your log for syntax errors");
                    } else {
                        PlayerChatHelper.SendWarn(pCmdSender, "Reload failed. Check your log for syntax errors");
                    }
                } else {
                    if (!inGame(pCmdSender)) {
                        PlayerChatHelper.SendPlain(pCmdSender, "[HAZIT] Reload done. New config is activated");
                    } else {
                        PlayerChatHelper.SendInfo(pCmdSender, "Reload done. New config is activated");
                    }
                }
            }
        }
        // Commands for ingame only >>
        else {
            sendHelpToPlayer(pCmdSender);
        }
    }

    private boolean inGame(ICommandSender pCmdSender) {
        return pCmdSender instanceof EntityPlayer;
    }

    /**
     * Send a list of all valid potions to the command sender
     *
     */
    private void sendPotionsToPlayer(ICommandSender pCmdSender) {
        if (!inGame(pCmdSender)) {
            PlayerChatHelper.SendPlain(pCmdSender, "[HAZIT] List of known Potions; Name(ID)");
        } else {
            PlayerChatHelper.SendInfo(pCmdSender, "List of known Potions; Name(ID)");
        }

        StringBuilder tMsg = new StringBuilder(32);
        for (Potion p : Potion.potionTypes) {
            if (p == null) {
                continue;
            }

            if (tMsg.length() > 0) {
                tMsg.append(", ");
            }
            String t = String.format("%s(%d)", p.getName(), p.id);
            if (tMsg.length() + t.length() > 50) {
                if (!inGame(pCmdSender)) {
                    PlayerChatHelper.SendPlain(pCmdSender, tMsg.toString());
                } else {
                    PlayerChatHelper.SendInfo(pCmdSender, tMsg.toString());
                }
                tMsg = new StringBuilder(t);
            } else {
                tMsg.append(t);
            }
        }
        if (!inGame(pCmdSender)) {
            PlayerChatHelper.SendPlain(pCmdSender, "[HAZIT] End of list");
        } else {
            PlayerChatHelper.SendInfo(pCmdSender, "End of list");
        }
    }

    private void sendHelpToPlayer(ICommandSender pCmdSender) {
        if (!inGame(pCmdSender)) {
            PlayerChatHelper
                    .SendPlain(pCmdSender, "[HAZIT] Valid options are: reload|save|listdamagesources|listpotions");
        } else {
            PlayerChatHelper.SendInfo(pCmdSender, "/hazarditems reload|save|listdamagesources|listpotions");
        }
    }

    /*
     * Make sure only an op/admin can execute this command
     */
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender pCommandSender) {
        if (pCommandSender instanceof EntityPlayerMP tEP) {
            return MinecraftServer.getServer().getConfigurationManager().func_152596_g(tEP.getGameProfile());
        } else {
            return pCommandSender instanceof MinecraftServer;
        }
    }
}
