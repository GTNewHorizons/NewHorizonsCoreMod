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
import gregtech.api.material.MaterialParts;

/**
 * How to add new Stuff: Ask Namikon
 */
public class GT_CustomLoader {

    public enum AdvancedGTMaterials {

        LuV(Circuits.LuV.getIngredient(),
                MaterialParts.craftIngredient(OrePrefixes.wireGt02, Materials.YttriumBariumCuprate),
                Materials.VanadiumGallium, MaterialParts.craftIngredient(OrePrefixes.wireGt02, Materials.HSSG),
                MaterialParts.craftIngredient(OrePrefixes.gemExquisite, Materials.Diamond),
                gregtech.api.enums.ItemList.Gravistar, "blockGlassLuV", Materials.RhodiumPlatedPalladium,
                Materials.Enderium),

        ZPM(Circuits.ZPM.getIngredient(),
                MaterialParts.craftIngredient(OrePrefixes.wireGt04, Materials.YttriumBariumCuprate), Materials.Naquadah,
                MaterialParts.craftIngredient(OrePrefixes.wireGt02, Materials.Naquadah),
                MaterialParts.craftIngredient(OrePrefixes.gemExquisite, Materials.GarnetYellow),
                NHItemList.MysteriousCrystal.get(), "blockGlassZPM", Materials.Iridium, Materials.Naquadah),

        UV(Circuits.UV.getIngredient(),
                MaterialParts.craftIngredient(OrePrefixes.wireGt08, Materials.YttriumBariumCuprate),
                Materials.ElectrumFlux, MaterialParts.craftIngredient(OrePrefixes.wireGt02, Materials.NaquadahAlloy),
                MaterialParts.craftIngredient(OrePrefixes.gemExquisite, Materials.GarnetRed),
                new ItemStack(Blocks.dragon_egg, 1), "blockGlassUV", Materials.Osmium, Materials.Neutronium),

        UHV(Circuits.UHV.getIngredient(),
                MaterialParts.craftIngredient(OrePrefixes.wireGt16, Materials.YttriumBariumCuprate),
                Materials.Bedrockium, MaterialParts.craftIngredient(OrePrefixes.wireGt02, Materials.Bedrockium), null,
                null, "blockGlassUHV", Materials.Neutronium, Materials.Neutronium),

        UEV(Circuits.UEV.getIngredient(), MaterialParts.craftIngredient(OrePrefixes.wireGt04, Materials.Bedrockium),
                Materials.Draconium, MaterialParts.craftIngredient(OrePrefixes.wireGt02, Materials.Draconium), null,
                null, "blockGlassUEV", Materials.Bedrockium, Materials.Infinity),

        UIV(Circuits.UIV.getIngredient(), MaterialParts.craftIngredient(OrePrefixes.wireGt08, Materials.Bedrockium),
                Materials.NetherStar, MaterialParts.craftIngredient(OrePrefixes.wireGt02, Materials.NetherStar), null,
                null, "blockGlassUIV", Materials.CosmicNeutronium, Materials.TranscendentMetal),

        UMV(Circuits.UMV.getIngredient(), MaterialParts.craftIngredient(OrePrefixes.wireGt16, Materials.Bedrockium),
                Materials.Quantium, MaterialParts.craftIngredient(OrePrefixes.wireGt02, Materials.Quantium), null, null,
                "blockGlassUMV", Materials.TranscendentMetal, Materials.SpaceTime);

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
            _mMachineCable = MaterialParts.craftIngredient(OrePrefixes.cableGt01, pCable);
            _mMachineCable4 = MaterialParts.craftIngredient(OrePrefixes.cableGt04, pCable);
            _mGem = pGem;
            _mPowerGem = pPowerGem;
            _mPlate = MaterialParts.craftIngredient(OrePrefixes.plate, pPlateMaterial);
            _mReinfGlass = glass;
            _mPipe = MaterialParts.craftIngredient(OrePrefixes.pipeMedium, pPipe);
            _mPipeL = MaterialParts.craftIngredient(OrePrefixes.pipeLarge, pPipe);
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
        MachineRecipeLoader.run();
        CraftingRecipeLoader.run();
        MoldLoader.run();
        MechanicalArmorRecipes.run();
    }
}
