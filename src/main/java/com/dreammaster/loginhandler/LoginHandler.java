package com.dreammaster.loginhandler;

import com.dreammaster.config.CoreModConfig;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class LoginHandler {
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    	event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "=====================================================" ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.BOLD + "Welcome to Gregtech: New Horizons " + EnumChatFormatting.GREEN + CoreModConfig.ModPackVersion));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE  + "The Quest Book has a shortcut key, check your keybindings" ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE  + "to remove conflicts." ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN + "New features include: Using cells on machine GUI tanks for"));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN	+ "I/O, NEI having tabs at the top and multiple recipes on a "));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN + "page, Cooking for Blockheads addition, Logistics Pipes"));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN + "addition, Tungsten change, glowy textures (your resourcepack"));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN	+ "will need to be updated to do this), other texture work you"));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN + "probably won't notice but still looks nice, quest changes, and a"));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN + "whole bunch of other stuff, so check out the changelog."));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Please report bugs here:" ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "https://github.com/GTNewHorizons/GT-New-Horizons-Modpack/" ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Visit our discord at https://discord.gg/EXshrPV" ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "=====================================================" ));
    }
}
