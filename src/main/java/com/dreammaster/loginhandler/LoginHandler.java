package com.dreammaster.loginhandler;

import static com.dreammaster.config.CoreModConfig.ModPackVersion;
import static net.minecraft.util.EnumChatFormatting.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import java.util.Arrays;
import net.minecraft.util.ChatComponentText;

public class LoginHandler {
    private static final String[] LOGIN_TEXT = {
        GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------",
        BOLD + "Welcome to Gregtech: New Horizons " + GREEN + ModPackVersion,
        RED + "We are aware that in this version, ",
        RED + "pattern substitution can behave weirdly.",
        RED + "Please don't report it, thanks.",
        BLUE + "The Quest Book has a shortcut key, check your keybindings",
        BLUE + "to remove conflicts.",
        DARK_GREEN + "GTNH WIKI link https://gtnh.miraheze.org/wiki/",
        GREEN + "Please report bugs here:",
        GOLD + "https://github.com/GTNewHorizons/GT-New-Horizons-Modpack/",
        BLUE + "Visit our discord at https://discord.gg/gtnh",
        GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------"
    };

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Arrays.stream(LOGIN_TEXT).map(ChatComponentText::new).forEach(event.player::addChatMessage);
    }
}
