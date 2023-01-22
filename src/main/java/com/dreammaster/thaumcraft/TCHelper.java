package com.dreammaster.thaumcraft;

import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategoryList;
import thaumcraft.api.research.ResearchItem;

public class TCHelper {

    public static void orphanResearch(String research) {
        // TODO: Implement
    }

    public static void removeResearch(String research) {
        ResearchItem ri = ResearchCategories.getResearch(research);
        ResearchCategoryList rcl = ResearchCategories.getResearchList(ri.category);
        rcl.research.remove(research);
    }
}
