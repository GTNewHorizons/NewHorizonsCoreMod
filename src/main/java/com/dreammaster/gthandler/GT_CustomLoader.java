package com.dreammaster.gthandler;

import static gregtech.api.enums.Mods.*;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;
import com.dreammaster.modfixes.biomesoplenty.BlockHarvestToolFix;
import com.dreammaster.modfixes.enderIO.FrankenskullFix;
import com.ruling_0.materiallib.api.Material;

import gregtech.api.enums.Circuits;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials.Materials;

/**
 * How to add new Stuff: Ask Namikon
 */
public class GT_CustomLoader {

    public enum AdvancedGTMaterials {

        LuV(Circuits.LuV.getIngredient(), OrePrefixes.wireGt02.ingredient(Materials.YttriumBariumCuprate),
                Materials.VanadiumGallium, OrePrefixes.wireGt02.ingredient(Materials.HSSG),
                OrePrefixes.gemExquisite.ingredient(Materials.Diamond), gregtech.api.enums.ItemList.Gravistar,
                "blockGlassLuV", Materials.RhodiumPlatedPalladium, Materials.Enderium),

        ZPM(Circuits.ZPM.getIngredient(), OrePrefixes.wireGt04.ingredient(Materials.YttriumBariumCuprate),
                Materials.Naquadah, OrePrefixes.wireGt02.ingredient(Materials.Naquadah),
                OrePrefixes.gemExquisite.ingredient(Materials.GarnetYellow), NHItemList.MysteriousCrystal.get(),
                "blockGlassZPM", Materials.Iridium, Materials.Naquadah),

        UV(Circuits.UV.getIngredient(), OrePrefixes.wireGt08.ingredient(Materials.YttriumBariumCuprate),
                Materials.ElectrumFlux, OrePrefixes.wireGt02.ingredient(Materials.NaquadahAlloy),
                OrePrefixes.gemExquisite.ingredient(Materials.GarnetRed), new ItemStack(Blocks.dragon_egg, 1),
                "blockGlassUV", Materials.Osmium, Materials.Neutronium),

        UHV(Circuits.UHV.getIngredient(), OrePrefixes.wireGt16.ingredient(Materials.YttriumBariumCuprate),
                Materials.Bedrockium, OrePrefixes.wireGt02.ingredient(Materials.Bedrockium), null, null,
                "blockGlassUHV", Materials.Neutronium, Materials.Neutronium),

        UEV(Circuits.UEV.getIngredient(), OrePrefixes.wireGt04.ingredient(Materials.Infinity), Materials.Draconium,
                OrePrefixes.wireGt02.ingredient(Materials.Draconium), null, null, "blockGlassUEV", Materials.Infinity,
                Materials.Infinity),

        UIV(Circuits.UIV.getIngredient(), OrePrefixes.wireGt08.ingredient(Materials.Bedrockium), Materials.NetherStar,
                OrePrefixes.wireGt02.ingredient(Materials.NetherStar), null, null, "blockGlassUIV",
                Materials.TranscendentMetal, Materials.TranscendentMetal),

        UMV(Circuits.UMV.getIngredient(), OrePrefixes.wireGt16.ingredient(Materials.Bedrockium), Materials.Quantium,
                OrePrefixes.wireGt02.ingredient(Materials.Quantium), null, null, "blockGlassUMV", Materials.SpaceTime,
                Materials.SpaceTime);

        private Object _mCircuit;
        private Object _mHeatingCoil;
        private Object _mCoilWire;
        private Object _mMachineCable;
        private Object _mMachineCable4;
        private Object _mGem;
        private Object _mPowerGem;
        private Object _mPlate;
        private Object _mReinfGlass;
        private Object _mPipe;
        private Object _mPipeL;

        AdvancedGTMaterials(Object pCircuit, Object pHeatingCoil, Material pCable, Object pCoilWire, Object pGem,
                Object pPowerGem, Object glass, Material pPlateMaterial, Material pPipe) {
            _mCircuit = pCircuit;
            _mHeatingCoil = pHeatingCoil;
            _mCoilWire = pCoilWire;
            _mMachineCable = OrePrefixes.cableGt01.ingredient(pCable);
            _mMachineCable4 = OrePrefixes.cableGt04.ingredient(pCable);
            _mGem = pGem;
            _mPowerGem = pPowerGem;
            _mPlate = OrePrefixes.plate.ingredient(pPlateMaterial);
            _mReinfGlass = glass;
            _mPipe = OrePrefixes.pipeMedium.ingredient(pPipe);
            _mPipeL = OrePrefixes.pipeLarge.ingredient(pPipe);
        }

        public Object getPipe() {
            return _mPipe;
        }

        // A test
        public Object getGlass() {
            return _mReinfGlass;
        }

        public Object getPlate() {
            return _mPlate;
        }

        public Object getPowerGem() {
            return _mPowerGem;
        }

        public Object getGem() {
            return _mGem;
        }

        public Object getCircuit() {
            return _mCircuit;
        }

        public Object getHCoil() {
            return _mHeatingCoil;
        }

        public Object getCable() {
            return _mMachineCable;
        }

        public Object getCable4() {
            return _mMachineCable4;
        }

        public Object getWire() {
            return _mCoilWire;
        }

        public Object getPipeL() {
            return _mPipeL;
        }
    }

    /*
     * Changed to static final for performance and clear design reasons. Since these Classes arent modified anymore,
     * final is a good choice here. Final variables will help the compiler optimize the code statically, which may
     * result in faster code.
     */
    private static final GT_Loader_Items ItemLoader = new GT_Loader_Items();
    private static final GT_Loader_Machines MachineLoader = new GT_Loader_Machines();
    private static final GT_Loader_Materials MaterialLoader = new GT_Loader_Materials();
    private static final GT_MachineRecipeLoader MachineRecipeLoader = new GT_MachineRecipeLoader();
    private static final GT_CraftingRecipeLoader CraftingRecipeLoader = new GT_CraftingRecipeLoader();
    private static final GT_Loader_OreDictionary OreDictionary = new GT_Loader_OreDictionary();
    private static final GT_Recipe_Remover Remover = new GT_Recipe_Remover();
    private static final GT_Loader_Molds MoldLoader = new GT_Loader_Molds();

    public void run() {
        if (EnderIO.isModLoaded()) {
            FrankenskullFix.fixEnderIO();
        }
        if (BiomesOPlenty.isModLoaded()) {
            BlockHarvestToolFix.fixBOPHarvestTools();
        }
        MaterialLoader.run();
        ItemLoader.run();
        MachineLoader.run();
        Remover.run();
        OreDictionary.run();
        MachineRecipeLoader.run();
        CraftingRecipeLoader.run();
        MoldLoader.run();
        MechanicalArmorRecipes.run();
    }
}
