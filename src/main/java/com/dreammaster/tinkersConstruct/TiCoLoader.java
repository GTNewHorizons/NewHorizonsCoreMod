package com.dreammaster.tinkersConstruct;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.util.GTModHandler.getModItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.MinecraftForge;

import com.dreammaster.block.BlockList;
import com.dreammaster.mantle.BookLoader;
import com.dreammaster.tinkersConstruct.worldgen.ZincGravelWorldgen;
import com.gtnewhorizons.postea.api.ItemStackReplacementManager;
import com.gtnewhorizons.postea.api.TileEntityReplacementManager;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class TiCoLoader {

    public static void doInitialization() {
        registerZincGravelOreWorldGen();
    }

    private static void registerZincGravelOreWorldGen() {
        MinecraftForge.TERRAIN_GEN_BUS.register(new ZincGravelWorldgen());
    }

    public static void doPostInitialization() {
        addTiCoManuals();
        registerAluminumBrassPosteaTransformers();
        registerGravelOrePosteaTransformers();
    }

    private static void addTiCoManuals() {
        addTiCoManual("firstday", "tconstruct.manual.beginner", "manual1.tooltip", "tinker:tinkerbook_diary");
        addTiCoManual("materials", "tconstruct.manual.toolstation", "manual2.tooltip", "tinker:tinkerbook_toolstation");
        addTiCoManual("smeltery", "tconstruct.manual.smeltery", "manual3.tooltip", "tinker:tinkerbook_smeltery");
        addTiCoManual("diary", "tconstruct.manual.diary", "manual4.tooltip", "tinker:tinkerbook_blue");
        addTiCoManual("weaponry", "tconstruct.manual.weaponry", "manual5.tooltip", "tinker:tinkerbook_green");
    }

    private static void addTiCoManual(String bookName, String unlocalizedName, String tooltip, String itemImage) {
        BookLoader.of(unlocalizedName, TinkerConstruct.ID, "/assets/dreamcraft/tinker/manuals/" + bookName + ".xml")
                .setTooltip(tooltip).setItemImage(itemImage).makeTranslatable().addToBookDataStore();
    }

    private static void registerAluminumBrassPosteaTransformers() {
        convertAluminumBrassBlock();
        convertAluminumBrassItems();
        convertMoltenAluminumBrassInSmeltery();
        convertAluminumBrassSingularity();
    }

    private static void convertAluminumBrassBlock() {
        ItemStack brassBlock = GTOreDictUnificator.get(OrePrefixes.block, Materials.Brass, 1L);
        // also applies a corresponding block transform.
        ItemStackReplacementManager.addSimpleReplacement("TConstruct:MetalBlock", 7, brassBlock, false);
    }

    private static void convertAluminumBrassItems() {
        ItemStack brassIngot = GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Brass, 1L);
        ItemStack brassNugget = GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Brass, 1L);
        ItemStack brassDust = GTOreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 1L);
        ItemStackReplacementManager.addSimpleReplacement("TConstruct:materials", 14, brassIngot);
        ItemStackReplacementManager.addSimpleReplacement("TConstruct:materials", 24, brassNugget);
        ItemStackReplacementManager.addSimpleReplacement("TConstruct:materials", 42, brassDust);
    }

    private static void convertMoltenAluminumBrassInSmeltery() {
        TileEntityReplacementManager.tileEntityTransformer("TConstruct.Smeltery", (tags, world, chunk) -> {
            NBTTagList liquidTag = tags.getTagList("Liquids", 10);
            for (int i = 0; i < liquidTag.tagCount(); i++) {
                NBTTagCompound nbt = liquidTag.getCompoundTagAt(i);
                if ("aluminumbrass.molten".equals(nbt.getString("FluidName"))) {
                    nbt.setString("FluidName", SmelteryFluidTypes.getMoltenPatternFluidName());
                }
            }
            return null;
        });
    }

    private static void convertAluminumBrassSingularity() {
        ItemStack roseGoldSingularity = getModItem(
                UniversalSingularities.ID,
                "universal.general.singularity",
                1,
                32,
                missing);
        ItemStackReplacementManager.addSimpleReplacement(
                "universalsingularities:universal.tinkersConstruct.singularity",
                0,
                roseGoldSingularity,
                true);
    }

    private static void registerGravelOrePosteaTransformers() {
        ItemStackReplacementManager.addSimpleReplacement(
                "TConstruct:GravelOre",
                Item.getItemFromBlock(BlockList.ZincGravelOre.block),
                0,
                false);
    }

}
