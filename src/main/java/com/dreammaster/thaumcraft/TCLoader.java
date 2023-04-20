package com.dreammaster.thaumcraft;

import net.minecraft.util.ResourceLocation;

import thaumcraft.api.research.ResearchCategories;

import com.dreammaster.lib.Refstrings;

public class TCLoader {

    public static final String category = "NEWHORIZONS";

    public static void run() {
        ResearchCategories.registerCategory(
                category,
                new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/icon/icon_GTNH.png"),
                new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/tab/tab_GTNH.png"));
    }

}
