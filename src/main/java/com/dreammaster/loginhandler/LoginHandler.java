package com.dreammaster.loginhandler;

import static com.dreammaster.config.CoreModConfig.ModPackVersion;
import static net.minecraft.util.EnumChatFormatting.*;

import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

// spotless:off
public class LoginHandler {

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        final String WIKI_LINK = "https://gtnh.miraheze.org/wiki/";
        final String ISSUE_TRACKER_LINK = "https://github.com/GTNewHorizons/GT-New-Horizons-Modpack/issues";
        final String DISCORD_LINK = "https://discord.gg/gtnh";
        event.player.addChatMessage(new ChatComponentText(GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------"));
        event.player.addChatMessage(new ChatComponentText(BOLD + "Welcome to Gregtech: New Horizons " + GREEN + ModPackVersion));
        event.player.addChatMessage(new ChatComponentText(BLUE + "The Quest Book has a shortcut key, check your keybindings."));
        event.player.addChatMessage(new ChatComponentText(DARK_GREEN + "GTNH WIKI link : ")
                .appendSibling(new ChatComponentText(DARK_GREEN + WIKI_LINK)
                        .setChatStyle(new ChatStyle()
                                .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(YELLOW + "Click to open the wiki!")))
                                .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, WIKI_LINK)))));
        event.player.addChatMessage(new ChatComponentText(GREEN + "Please report bugs on Github :"));
        event.player.addChatMessage(new ChatComponentText(GOLD + ISSUE_TRACKER_LINK)
                .setChatStyle(new ChatStyle()
                        .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(YELLOW + "Click to open the Github!")))
                        .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, ISSUE_TRACKER_LINK))));
        event.player.addChatMessage(new ChatComponentText(BLUE + "Visit our discord at ")
                .appendSibling(new ChatComponentText(BLUE + DISCORD_LINK)
                        .setChatStyle(new ChatStyle()
                                .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(YELLOW + "Click to open discord!")))
                                .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, DISCORD_LINK)))));
        event.player.addChatMessage(new ChatComponentText(GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------"));
    }
}
// spotless:on
