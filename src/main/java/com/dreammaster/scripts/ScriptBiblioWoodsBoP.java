package com.dreammaster.scripts;

import net.minecraft.item.ItemStack;

import java.util.Arrays;


import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptBiblioWoodsBoP implements IScriptLoader{

    public ScriptBiblioWoodsBoP(){
        scriptName.append("BiblioWoodsBoP");
        dependencies.addAll(Arrays.asList("BiomesOPlenty", "BiblioWoodsBoP", "BiblioCraft"));
    }
    @Override
    public void loadRecipes(){
        ItemStack[] BOBwood= new ItemStack[]{
                getModItem("BiomesOPlenty", "woodenSingleSlab1", 1),
                getModItem("BiomesOPlenty", "woodenSingleSlab1", 1, 1),
                getModItem("BiomesOPlenty", "woodenSingleSlab1", 1, 2),
                getModItem("BiomesOPlenty", "woodenSingleSlab1", 1, 3),
                getModItem("BiomesOPlenty", "woodenSingleSlab2", 1, 3),
                getModItem("BiomesOPlenty", "woodenSingleSlab1", 1, 4),
                getModItem("BiomesOPlenty", "woodenSingleSlab2", 1, 4),
                getModItem("BiomesOPlenty", "woodenSingleSlab1", 1, 5),
                getModItem("BiomesOPlenty", "woodenSingleSlab1", 1, 6),
                getModItem("BiomesOPlenty", "woodenSingleSlab1", 1, 7),
                getModItem("BiomesOPlenty", "woodenSingleSlab2", 1, 2),
                getModItem("BiomesOPlenty", "woodenSingleSlab2", 1),
                getModItem("BiomesOPlenty", "woodenSingleSlab2", 1, 1),
                getModItem("BiomesOPlenty", "woodenSingleSlab2", 1, 5)};

        ItemStack[] BOPplanks = new ItemStack[]{
                getModItem("BiomesOPlenty", "planks", 1, 0),
                getModItem("BiomesOPlenty", "planks", 1, 1),
                getModItem("BiomesOPlenty", "planks", 1, 2),
                getModItem("BiomesOPlenty", "planks", 1, 3),
                getModItem("BiomesOPlenty", "planks", 1, 12),
                getModItem("BiomesOPlenty", "planks", 1, 4),
                getModItem("BiomesOPlenty", "planks", 1, 13),
                getModItem("BiomesOPlenty", "planks", 1, 5),
                getModItem("BiomesOPlenty", "planks", 1, 6),
                getModItem("BiomesOPlenty", "planks", 1, 7),
                getModItem("BiomesOPlenty", "planks", 1, 11),
                getModItem("BiomesOPlenty", "planks", 1, 8),
                getModItem("BiomesOPlenty", "planks", 1, 9),
                getModItem("BiomesOPlenty", "planks", 1, 14)
        };

        ItemStack[] FClockBOP= new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodClock", 1, 13)};

        ItemStack[] PaintingBOP= new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT0", 1, 13)};

        ItemStack[] BOBPT1= new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT1", 1, 13)};

        ItemStack[] BOBPT2= new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT2", 1, 13)};

        ItemStack[] BOBPT3= new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT3", 1, 13)};

        ItemStack[] BOBPT4= new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodPaintingT4", 1, 13)};

        ItemStack[] FrameBOP= new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, 13)};

        ItemStack[] LableBOP= new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodlabel", 1, 13)
        };

        ItemStack[] fancySignBOP = new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodFancySign", 1, 13)
        };

        ItemStack[] bookCaseBOP = new ItemStack[]{
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 1),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 2),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 3),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 4),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 5),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 6),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 7),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 8),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 9),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 10),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 11),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 12),
                getModItem("BiblioWoodsBoP", "BiblioWoodBookcase", 1, 13)
        };

        ItemStack torch = getModItem("minecraft", "torch", 1);
        ItemStack feather = getModItem("minecraft", "feather", 1);
        ItemStack ink = getModItem("minecraft", "dye", 1);
        ItemStack craftingTable = getModItem("minecraft", "crafting_table",1);
        ItemStack emptyBottle = getModItem("minecraft", "glass_bottle", 1);
        ItemStack ironIngot = getModItem("minecraft", "iron_ingot", 1);
        ItemStack glass = getModItem("minecraft", "glass", 1);
        ItemStack whiteWool = getModItem("minecraft", "wool", 1);
        ItemStack stick = getModItem("minecraft", "stick", 1);
        ItemStack woodenPressurePlate = getModItem("minecraft", "wooden_pressure_plate", 1);


        for (int i=0;i<14;i++){
            addShapedRecipe(FClockBOP[i], new Object[]{
                    BOBwood[i], getModItem("minecraft", "clock", 1), BOBwood[i],
                    BOBwood[i], "stickWood", BOBwood[i],
                    BOBwood[i], "plateGold", BOBwood[i]});
            addShapedRecipe(PaintingBOP[i], new Object[]{
                    BOBwood[i], BOBwood[i], BOBwood[i],
                    BOBwood[i], getModItem("BiblioCraft", "item.PaintingCanvas", 1), BOBwood[i],
                    BOBwood[i], BOBwood[i], BOBwood[i]});
            addShapedRecipe(BOBPT1[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", PaintingBOP[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            addShapedRecipe(BOBPT2[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", BOBPT1[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            addShapedRecipe(BOBPT3[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", BOBPT2[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            addShapedRecipe(BOBPT4[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", BOBPT3[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            addShapedRecipe(LableBOP[i], new Object[]{
                    "stickWood", "stickWood", "stickWood",
                    "stickWood", FrameBOP[i], "stickWood",
                    "stickWood", "stickWood", "stickWood"});
            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWoodtable", 1, i),
                    new Object[]{
                            BOBwood[i], BOBwood[i], BOBwood[i],
                            null, BOPplanks[i], null,
                            null, BOPplanks[i], null
                    });
            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWooddesk", 1, i),
                    new Object[]{
                            torch, null, feather,
                            BOBwood[i], BOBwood[i], BOBwood[i],
                            BOPplanks[i], null, BOPplanks[i]
                    });
            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWoodFancyWorkbench", 1, i),
                    new Object[]{
                            ink, craftingTable, feather,
                            BOBwood[i], bookCaseBOP[i], BOBwood[i],
                            BOBwood[i], null, BOBwood[i]
                    });

            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWoodFancyWorkbench", 1, i),
                    new Object[]{
                            feather, craftingTable, ink,
                            BOBwood[i], bookCaseBOP[i], BOBwood[i],
                            BOBwood[i], BOBwood[i], BOBwood[i]
                    });

            addShapedRecipe(bookCaseBOP[i],
                    new Object[]{
                            BOPplanks[i], BOBwood[i], BOPplanks[i],
                            BOPplanks[i], BOBwood[i], BOPplanks[i],
                            BOPplanks[i], BOBwood[i], BOPplanks[i],
                    });

            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWoodpotshelf", 1, i),
                    new Object[]{
                            BOBwood[i], BOBwood[i], BOBwood[i],
                            BOPplanks[i], emptyBottle, BOPplanks[i],
                            BOBwood[i], BOBwood[i], BOBwood[i],
                    });

            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWoodshelf", 1, i),
                    new Object[]{
                            BOBwood[i], BOBwood[i], BOBwood[i],
                            null, BOPplanks[i], null,
                            BOBwood[i], BOBwood[i], BOBwood[i],
                    });

            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWoodrack", 1, i),
                    new Object[]{
                            BOBwood[i], BOBwood[i], BOBwood[i],
                            BOBwood[i], ironIngot, BOBwood[i],
                            BOBwood[i], BOBwood[i], BOBwood[i],
                    });

            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWoodcase", 1, i),
                    new Object[]{
                            BOBwood[i], glass, BOBwood[i],
                            BOBwood[i], whiteWool, BOBwood[i],
                            BOBwood[i], BOBwood[i], BOBwood[i],
                    });

            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWoodMapFrame", 1, i),
                    new Object[]{
                            stick, stick, stick,
                            stick, BOBwood[i], stick,
                            stick, stick, stick
                    });

            addShapedRecipe(getModItem("BiblioWoodsBoP", "BiblioWoodSeat", 1, i),
                    new Object[]{
                            null, whiteWool, null,
                            null, BOBwood[i], null,
                            stick, woodenPressurePlate, stick
                    });

            addShapedRecipe(getModItem("BiblioWoodsBoP", "seatBack1", 1, i),
                    new Object[]{
                            null, whiteWool, null,
                            null, BOBwood[i], null,
                            stick, null, stick
                    });


            addShapedRecipe(getModItem("BiblioWoodsBoP", "seatBack2", 1, i),
                    new Object[]{
                            stick, whiteWool, stick,
                            stick, BOBwood[i], stick,
                            stick, null, stick
                    });

            addShapedRecipe(getModItem("BiblioWoodsBoP", "seatBack4", 1, i),
                    new Object[]{
                            null, whiteWool, null,
                            null, BOBwood[i], null,
                            null, null, null
                    });

            addShapelessCraftingRecipe(
                    getModItem("BiblioWoodsBoP", "seatBack3", 1, i),
                    new Object[]{
                            BOBwood[i],
                            getModItem("BiblioWoodsBoP", "seatBack2", 1, i),
                    });

            addShapelessCraftingRecipe(
                    getModItem("BiblioWoodsBoP", "seatBack5", 1, i),
                    new Object[]{
                            BOBwood[i], BOBwood[i],
                            getModItem("BiblioWoodsBoP", "seatBack2", 1, i),
                    });

            addShapelessCraftingRecipe(
                    fancySignBOP[i],
                    new Object[]{
                            getModItem("minecraft", "paper", 1),
                            getModItem("minecraft", "sign", 1),
                            LableBOP[i]
                    });
        }
    }

}


