package com.dreammaster.tinkersConstruct;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.util.GTModHandler.getModItem;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.mantle.BookLoader;
import com.dreammaster.tinkersConstruct.worldgen.ZincGravelOre;
import com.dreammaster.tinkersConstruct.worldgen.ZincGravelOreItem;
import com.dreammaster.tinkersConstruct.worldgen.ZincGravelWorldgen;
import com.gtnewhorizons.postea.api.BlockReplacementManager;
import com.gtnewhorizons.postea.api.ItemStackReplacementManager;
import com.gtnewhorizons.postea.api.TileEntityReplacementManager;
import com.gtnewhorizons.postea.utility.BlockConversionInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class TiCoLoader {

    public static Block ZINC_GRAVEL_ORE;

    public static void doPreInitialization() {
        registerZincGravelOre();
    }

    private static void registerZincGravelOre() {
        ZINC_GRAVEL_ORE = new ZincGravelOre().setBlockName("block.ore.gravel.zinc");
        ZINC_GRAVEL_ORE.setHarvestLevel("shovel", 1, 0);
        GameRegistry.registerBlock(ZINC_GRAVEL_ORE, ZincGravelOreItem.class, "ZincGravelOre");
        OreDictionary.registerOre("oreZinc", new ItemStack(ZINC_GRAVEL_ORE, 1, 0));
    }

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
        String targetBlock = "TConstruct:MetalBlock";
        ItemStack brassBlock = GTOreDictUnificator.get(OrePrefixes.block, Materials.Brass, 1L);
        int brassBlockMeta = Items.feather.getDamage(brassBlock);
        BlockReplacementManager.addBlockReplacement(targetBlock, (blockConversionInfoOld, world) -> {
            if (blockConversionInfoOld.metadata == 7) {
                BlockConversionInfo blockConversionInfoNew = new BlockConversionInfo();
                blockConversionInfoNew.blockID = Item.getIdFromItem(brassBlock.getItem());
                blockConversionInfoNew.metadata = brassBlockMeta;
                return blockConversionInfoNew;
            }
            return null;
        });
        ItemStackReplacementManager.addItemReplacement(targetBlock, tag -> {
            if (tag.getShort("Damage") == 7) {
                tag.setShort("id", (short) Item.getIdFromItem(brassBlock.getItem()));
                tag.setShort("Damage", (short) brassBlockMeta);
                return tag;
            }
            return tag;
        });
    }

    private static void convertAluminumBrassItems() {
        ItemStack brassIngot = GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Brass, 1L);
        ItemStack brassNugget = GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Brass, 1L);
        ItemStack brassDust = GTOreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 1L);
        ItemStackReplacementManager.addItemReplacement("TConstruct:materials", tag -> {
            switch (tag.getShort("Damage")) {
                case 14:
                    tag.setShort("id", (short) Item.getIdFromItem(brassIngot.getItem()));
                    tag.setShort("Damage", (short) Items.feather.getDamage(brassIngot));
                    break;
                case 24:
                    tag.setShort("id", (short) Item.getIdFromItem(brassNugget.getItem()));
                    tag.setShort("Damage", (short) Items.feather.getDamage(brassNugget));
                    break;
                case 42:
                    tag.setShort("id", (short) Item.getIdFromItem(brassDust.getItem()));
                    tag.setShort("Damage", (short) Items.feather.getDamage(brassDust));
                    break;
            }
            return tag;
        });
    }

    private static void convertMoltenAluminumBrassInSmeltery() {
        TileEntityReplacementManager.tileEntityTransformer("TConstruct.Smeltery", (tags, world) -> {
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
        ItemStackReplacementManager
                .addItemReplacement("universalsingularities:universal.tinkersConstruct.singularity", tag -> {
                    if (tag.getShort("Damage") == 0) {
                        tag.setShort("id", (short) Item.getIdFromItem(roseGoldSingularity.getItem()));
                        tag.setShort("Damage", (short) roseGoldSingularity.getItemDamage());
                        return tag;
                    }
                    return tag;
                });
    }

    private static void registerGravelOrePosteaTransformers() {
        String targetBlock = "TConstruct:GravelOre";
        BlockReplacementManager.addBlockReplacement(targetBlock, (blockConversionInfoOld, world) -> {
            BlockConversionInfo blockConversionInfoNew = new BlockConversionInfo();
            blockConversionInfoNew.blockID = Block.getIdFromBlock(ZINC_GRAVEL_ORE);
            blockConversionInfoNew.metadata = 0;
            return blockConversionInfoNew;
        });
        ItemStackReplacementManager.addItemReplacement(targetBlock, tag -> {
            tag.setShort("id", (short) Block.getIdFromBlock(ZINC_GRAVEL_ORE));
            tag.setShort("Damage", (short) 0);
            return tag;
        });
    }

}
