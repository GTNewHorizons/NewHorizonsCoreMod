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
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED +  "Please bring comments to " + EnumChatFormatting.BLUE + "https://discord.gg/EXshrPV" ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "=================================================="));
    }
}
