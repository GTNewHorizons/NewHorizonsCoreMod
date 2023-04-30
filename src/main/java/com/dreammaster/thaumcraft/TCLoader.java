package com.dreammaster.thaumcraft;

import net.minecraft.util.ResourceLocation;

import com.dreammaster.lib.Refstrings;

import thaumcraft.api.research.ResearchCategories;

public class TCLoader {

    public static final String category = "NEWHORIZONS";

    public static void run() {
        ResearchCategories.registerCategory(
                category,
                new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/icon/icon_GTNH.png"),
                new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/tab/tab_GTNH.png"));
    }

}
