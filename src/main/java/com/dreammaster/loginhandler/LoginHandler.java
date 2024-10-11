package com.dreammaster.loginhandler;

import static com.dreammaster.config.CoreModConfig.ModPackVersion;
import static net.minecraft.util.EnumChatFormatting.*;

import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.StatCollector;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class LoginHandler {

    // spotless:off
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        final String WIKI_LINK = "https://gtnh.miraheze.org/wiki/";
        final String ISSUE_TRACKER_LINK = "https://github.com/GTNewHorizons/GT-New-Horizons-Modpack/issues";
        final String DISCORD_LINK = "https://discord.gg/gtnh";
        final String WELCOME       = StatCollector.translateToLocal("dreamcraft.welcome.welcome");
        final String QUESTBOOK     = StatCollector.translateToLocal("dreamcraft.welcome.questbook");
        final String GTNH_WIKI     = StatCollector.translateToLocal("dreamcraft.welcome.gtnh_wiki");
        final String CLICK_WIKI    = StatCollector.translateToLocal("dreamcraft.welcome.click_wiki");
        final String REPORT_BUG    = StatCollector.translateToLocal("dreamcraft.welcome.report_bug");
        final String CLICK_GITHUB  = StatCollector.translateToLocal("dreamcraft.welcome.click_github");
        final String VISIT_DISCORD = StatCollector.translateToLocal("dreamcraft.welcome.visitdiscord");
        final String CLICK_DISCORD = StatCollector.translateToLocal("dreamcraft.welcome.click_discord");
        event.player.addChatMessage(new ChatComponentText(GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------"));
        event.player.addChatMessage(new ChatComponentText(BOLD + WELCOME + " " + GREEN + ModPackVersion));
        event.player.addChatMessage(new ChatComponentText(BLUE + QUESTBOOK));
        event.player.addChatMessage(new ChatComponentText(DARK_GREEN + GTNH_WIKI + " ")
                .appendSibling(new ChatComponentText(DARK_GREEN + WIKI_LINK)
                        .setChatStyle(new ChatStyle()
                                .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(YELLOW + CLICK_WIKI)))
                                .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, WIKI_LINK)))));
        event.player.addChatMessage(new ChatComponentText(GREEN + REPORT_BUG));
        event.player.addChatMessage(new ChatComponentText(GOLD + ISSUE_TRACKER_LINK)
                .setChatStyle(new ChatStyle()
                        .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(YELLOW + CLICK_GITHUB)))
                        .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, ISSUE_TRACKER_LINK))));
        event.player.addChatMessage(new ChatComponentText(BLUE + VISIT_DISCORD + " ")
                .appendSibling(new ChatComponentText(BLUE + DISCORD_LINK)
                        .setChatStyle(new ChatStyle()
                                .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(YELLOW + CLICK_DISCORD)))
                                .setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, DISCORD_LINK)))));
        event.player.addChatMessage(new ChatComponentText(GOLD.toString() + STRIKETHROUGH + "-----------------------------------------------------"));
    }
    // spotless:on
}
