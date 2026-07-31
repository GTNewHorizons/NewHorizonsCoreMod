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
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.material.MU;

/**
 * How to add new Stuff: Ask Namikon
 */
public class GT_CustomLoader {

    public enum AdvancedGTMaterials {

        LuV(Circuits.LuV.getIngredient(), OrePrefixes.wireGt02.get(Materials2Materials.YttriumBariumCuprate),
                Materials2Materials.VanadiumGallium, OrePrefixes.wireGt02.get(Materials2Materials.HSSG),
                OrePrefixes.gemExquisite.get(Materials2Materials.Diamond), gregtech.api.enums.ItemList.Gravistar,
                "blockGlassLuV", Materials2Materials.RhodiumPlatedPalladium, Materials2Materials.Enderium),

        ZPM(Circuits.ZPM.getIngredient(), OrePrefixes.wireGt04.get(Materials2Materials.YttriumBariumCuprate),
                Materials2Materials.Naquadah, OrePrefixes.wireGt02.get(Materials2Materials.Naquadah),
                OrePrefixes.gemExquisite.get(Materials2Materials.GarnetYellow), NHItemList.MysteriousCrystal.get(),
                "blockGlassZPM", Materials2Materials.Iridium, Materials2Materials.Naquadah),

        UV(Circuits.UV.getIngredient(), OrePrefixes.wireGt08.get(Materials2Materials.YttriumBariumCuprate),
                Materials2Materials.ElectrumFlux, OrePrefixes.wireGt02.get(Materials2Materials.NaquadahAlloy),
                OrePrefixes.gemExquisite.get(Materials2Materials.GarnetRed), new ItemStack(Blocks.dragon_egg, 1),
                "blockGlassUV", Materials2Materials.Osmium, Materials2Materials.Neutronium),

        UHV(Circuits.UHV.getIngredient(), OrePrefixes.wireGt16.get(Materials2Materials.YttriumBariumCuprate),
                Materials2Materials.Bedrockium, OrePrefixes.wireGt02.get(Materials2Materials.Bedrockium), null, null,
                "blockGlassUHV", Materials2Materials.Neutronium, Materials2Materials.Neutronium),

        UEV(Circuits.UEV.getIngredient(), OrePrefixes.wireGt04.get(Materials2Materials.Bedrockium),
                Materials2Materials.Draconium, OrePrefixes.wireGt02.get(Materials2Materials.Draconium), null, null,
                "blockGlassUEV", Materials2Materials.Bedrockium, Materials2Materials.Infinity),

        UIV(Circuits.UIV.getIngredient(), OrePrefixes.wireGt08.get(Materials2Materials.Bedrockium),
                Materials2Materials.NetherStar, OrePrefixes.wireGt02.get(Materials2Materials.NetherStar), null, null,
                "blockGlassUIV", Materials2Materials.CosmicNeutronium, Materials2Materials.TranscendentMetal),

        UMV(Circuits.UMV.getIngredient(), OrePrefixes.wireGt16.get(Materials2Materials.Bedrockium),
                Materials2Materials.Quantium, OrePrefixes.wireGt02.get(Materials2Materials.Quantium), null, null,
                "blockGlassUMV", Materials2Materials.TranscendentMetal, Materials2Materials.SpaceTime);

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
            _mMachineCable = MU.craftIngredient(OrePrefixes.cableGt01, pCable);
            _mMachineCable4 = MU.craftIngredient(OrePrefixes.cableGt04, pCable);
            _mGem = pGem;
            _mPowerGem = pPowerGem;
            _mPlate = MU.craftIngredient(OrePrefixes.plate, pPlateMaterial);
            _mReinfGlass = glass;
            _mPipe = MU.craftIngredient(OrePrefixes.pipeMedium, pPipe);
            _mPipeL = MU.craftIngredient(OrePrefixes.pipeLarge, pPipe);
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
    private static final GT_Loader_Wires WireLoader = new GT_Loader_Wires();
    private static final GT_MachineRecipeLoader MachineRecipeLoader = new GT_MachineRecipeLoader();
    private static final GT_CraftingRecipeLoader CraftingRecipeLoader = new GT_CraftingRecipeLoader();
    private static final GT_Loader_OreDictionary OreDictionary = new GT_Loader_OreDictionary();
    private static final GT_Recipe_Remover Remover = new GT_Recipe_Remover();

    public void run() {
        if (EnderIO.isModLoaded()) {
            FrankenskullFix.fixEnderIO();
        }
        if (BiomesOPlenty.isModLoaded()) {
            BlockHarvestToolFix.fixBOPHarvestTools();
        }
        MaterialLoader.run();
        WireLoader.run();
        ItemLoader.run();
        MachineLoader.run();
        Remover.run();
        OreDictionary.run();
        MachineRecipeLoader.run();
        CraftingRecipeLoader.run();
        MechanicalArmorRecipes.run();
    }
}
