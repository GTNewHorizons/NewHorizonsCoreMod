package com.dreammaster.loginhandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.util.ChatComponentText;

import java.util.Arrays;

import static com.dreammaster.config.CoreModConfig.ModPackVersion;
import static com.mojang.realmsclient.gui.ChatFormatting.DARK_GREEN;
import static net.minecraft.util.EnumChatFormatting.BLUE;
import static net.minecraft.util.EnumChatFormatting.BOLD;
import static net.minecraft.util.EnumChatFormatting.GOLD;
import static net.minecraft.util.EnumChatFormatting.GREEN;

public class LoginHandler {
    private static final String[] LOGIN_TEXT = {
            GOLD + "=====================================================",
            BOLD + "Welcome to Gregtech: New Horizons " + GREEN + ModPackVersion,
            BLUE + "The Quest Book has a shortcut key, check your keybindings",
            BLUE + "to remove conflicts.",
            DARK_GREEN + "New features include: Using cells on machine GUI tanks for",
            DARK_GREEN + "I/O, NEI having tabs at the top and multiple recipes on a ",
            DARK_GREEN + "page, Cooking for Blockheads addition, Logistics Pipes",
            DARK_GREEN + "addition, Tungsten change, glowy textures (your resource-pack)",
            DARK_GREEN + "will need to be updated to do this), other texture work you",
            DARK_GREEN + "probably won't notice but still looks nice, quest changes, and a",
            DARK_GREEN + "whole bunch of other stuff, so check out the changelog.",
            GREEN + "Please report bugs here:",
            GOLD + "https://github.com/GTNewHorizons/GT-New-Horizons-Modpack/",
            BLUE + "Visit our discord at https://discord.gg/gtnh",
            GOLD + "====================================================="
    };

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Arrays.stream(LOGIN_TEXT).map(ChatComponentText::new).forEach(event.player::addChatMessage);
    }
}
