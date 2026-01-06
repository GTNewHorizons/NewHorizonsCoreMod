package com.dreammaster.loginhandler;

import static com.dreammaster.config.CoreModConfig.ModPackVersion;
import static net.minecraft.util.EnumChatFormatting.*;

import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;

import com.dreammaster.lib.Refstrings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class LoginHandler {

    // spotless:off
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        final String WELCOME             = "dreamcraft.welcome.welcome";
        final String QUESTBOOK           = "dreamcraft.welcome.questbook";
        final String GTNH_WIKI           = "dreamcraft.welcome.gtnh_wiki";
        final String CLICK_WIKI          = "dreamcraft.welcome.click_wiki";
        final String REPORT_BUG          = "dreamcraft.welcome.report_bug";
        final String CLICK_GITHUB        = "dreamcraft.welcome.click_github";
        final String VISIT_DISCORD       = "dreamcraft.welcome.visitdiscord";
        final String CLICK_DISCORD       = "dreamcraft.welcome.click_discord";
        final String OPEN_TO_LAN_WARNING = "dreamcraft.welcome.open_to_lan";

        event.player.addChatMessage(new ChatComponentText(GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------"));
        event.player.addChatMessage(new ChatComponentTranslation(WELCOME).setChatStyle(new ChatStyle().setBold(true))
                .appendText(" " + GREEN + ModPackVersion));
        event.player.addChatMessage(new ChatComponentTranslation(QUESTBOOK).setChatStyle(new ChatStyle().setColor(BLUE)));
        event.player.addChatMessage(new ChatComponentTranslation(GTNH_WIKI).setChatStyle(new ChatStyle().setColor(DARK_GREEN))
                .appendSibling(new ChatComponentText(Refstrings.WIKI_LINK)
                        .setChatStyle(new ChatStyle().setColor(DARK_GREEN)
                                .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                        new ChatComponentTranslation(CLICK_WIKI).setChatStyle(new ChatStyle().setColor(YELLOW))))
                                .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Refstrings.WIKI_LINK)))));
        event.player.addChatMessage(new ChatComponentTranslation(REPORT_BUG).setChatStyle(new ChatStyle().setColor(GREEN)));
        event.player.addChatMessage(new ChatComponentText(Refstrings.ISSUE_TRACKER_LINK)
                .setChatStyle(new ChatStyle().setColor(GOLD)
                        .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                new ChatComponentTranslation(CLICK_GITHUB).setChatStyle(new ChatStyle().setColor(YELLOW))))
                        .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Refstrings.ISSUE_TRACKER_LINK))));
        event.player.addChatMessage(new ChatComponentTranslation(VISIT_DISCORD).setChatStyle(new ChatStyle().setColor(BLUE))
                .appendSibling(new ChatComponentText(Refstrings.DISCORD_LINK)
                        .setChatStyle(new ChatStyle().setColor(BLUE)
                                .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                        new ChatComponentTranslation(CLICK_DISCORD).setChatStyle(new ChatStyle().setColor(YELLOW))))
                                .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Refstrings.DISCORD_LINK)))));
        event.player.addChatMessage(new ChatComponentText(GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------"));

        MinecraftServer server = MinecraftServer.getServer();
        if (server.isSinglePlayer() && !event.player.getGameProfile().getName().equals(server.getServerOwner())) {
            event.player.addChatMessage(new ChatComponentTranslation(OPEN_TO_LAN_WARNING));
        }
    }
    // spotless:on
}
