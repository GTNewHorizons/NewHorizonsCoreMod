package com.dreammaster.loginhandler;

import com.dreammaster.config.CoreModConfig;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class LoginHandler
{
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
    {
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "=================================================="));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.BOLD + "Welcome to Gregtech:New Horizons " + EnumChatFormatting.GREEN + CoreModConfig.ModPackVersion) );
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Experimental recipe acceleration! Vanilla, Forestry Worktable, AE2." ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "May cause issues with oredicted wildcard recipes." ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Please bring comments to https://discord.gg/EXshrPV" ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "=================================================="));
    }
}
