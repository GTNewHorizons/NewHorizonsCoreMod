package com.dreammaster.thaumcraft;

import net.minecraft.util.ResourceLocation;

import thaumcraft.api.research.ResearchCategories;

public class TCLoader {

    public static final String category = "NEWHORIZONS";

    public static void run() {
        registerResearch();
    }

    private static void registerResearch() {
        ResearchCategories.registerCategory(
                "NEWHORIZONS",
                new ResourceLocation("dreamcraft:textures/thaumcraft/icon/icon_GTNH.png"),
                new ResourceLocation("dreamcraft:textures/thaumcraft/tab/tab_GTNH.png"));
    }

}
