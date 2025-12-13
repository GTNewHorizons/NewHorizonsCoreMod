package com.dreammaster.loginhandler;

import static com.dreammaster.config.CoreModConfig.ModPackVersion;
import static net.minecraft.util.EnumChatFormatting.*;

import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.StatCollector;

import com.dreammaster.lib.Refstrings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class LoginHandler {

    // spotless:off
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        final String WELCOME             = StatCollector.translateToLocal("dreamcraft.welcome.welcome");
        final String QUESTBOOK           = StatCollector.translateToLocal("dreamcraft.welcome.questbook");
        final String GTNH_WIKI           = StatCollector.translateToLocal("dreamcraft.welcome.gtnh_wiki");
        final String CLICK_WIKI          = StatCollector.translateToLocal("dreamcraft.welcome.click_wiki");
        final String REPORT_BUG          = StatCollector.translateToLocal("dreamcraft.welcome.report_bug");
        final String CLICK_GITHUB        = StatCollector.translateToLocal("dreamcraft.welcome.click_github");
        final String VISIT_DISCORD       = StatCollector.translateToLocal("dreamcraft.welcome.visitdiscord");
        final String CLICK_DISCORD       = StatCollector.translateToLocal("dreamcraft.welcome.click_discord");
        final String OPEN_TO_LAN_WARNING = StatCollector.translateToLocal("dreamcraft.welcome.open_to_lan");

        event.player.addChatMessage(new ChatComponentText(GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------"));
        event.player.addChatMessage(new ChatComponentText(BOLD + WELCOME + " " + GREEN + ModPackVersion));
        event.player.addChatMessage(new ChatComponentText(BLUE + QUESTBOOK));
        event.player.addChatMessage(new ChatComponentText(DARK_GREEN + GTNH_WIKI + " ")
                .appendSibling(new ChatComponentText(DARK_GREEN + Refstrings.WIKI_LINK)
                        .setChatStyle(new ChatStyle()
                                .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(YELLOW + CLICK_WIKI)))
                                .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Refstrings.WIKI_LINK)))));
        event.player.addChatMessage(new ChatComponentText(GREEN + REPORT_BUG));
        event.player.addChatMessage(new ChatComponentText(GOLD + Refstrings.ISSUE_TRACKER_LINK)
                .setChatStyle(new ChatStyle()
                        .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(YELLOW + CLICK_GITHUB)))
                        .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Refstrings.ISSUE_TRACKER_LINK))));
        event.player.addChatMessage(new ChatComponentText(BLUE + VISIT_DISCORD + " ")
                .appendSibling(new ChatComponentText(BLUE + Refstrings.DISCORD_LINK)
                        .setChatStyle(new ChatStyle()
                                .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(YELLOW + CLICK_DISCORD)))
                                .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Refstrings.DISCORD_LINK)))));
        event.player.addChatMessage(new ChatComponentText(GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------"));

        MinecraftServer server = MinecraftServer.getServer();
        if (server.isSinglePlayer() && !event.player.getGameProfile().getName().equals(server.getServerOwner())) {
            event.player.addChatMessage(new ChatComponentText(OPEN_TO_LAN_WARNING));
        }
    }
    // spotless:on
}
