package com.dreammaster.gthandler;

import static gregtech.api.enums.Mods.*;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.ItemList;
import com.dreammaster.item.food.QuantumBread;
import com.dreammaster.modfixes.biomesoplenty.BlockHarvestToolFix;
import com.dreammaster.modfixes.enderIO.FrankenskullFix;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;

/**
 * How to add new Stuff: Ask Namikon
 */
public class GT_CustomLoader {

    public enum AdvancedGTMaterials {

        LuV(OrePrefixes.circuit.get(Materials.LuV), OrePrefixes.wireGt02.get(Materials.YttriumBariumCuprate),
                Materials.VanadiumGallium, OrePrefixes.wireGt02.get(Materials.HSSG),
                OrePrefixes.gemExquisite.get(Materials.Diamond), gregtech.api.enums.ItemList.Gravistar, "blockGlassLuV",
                Materials.get("Rhodium-PlatedPalladium"), Materials.Enderium),

        ZPM(OrePrefixes.circuit.get(Materials.ZPM), OrePrefixes.wireGt04.get(Materials.YttriumBariumCuprate),
                Materials.Naquadah, OrePrefixes.wireGt02.get(Materials.Naquadah),
                OrePrefixes.gemExquisite.get(Materials.GarnetYellow), ItemList.MysteriousCrystal.getIS(),
                "blockGlassZPM", Materials.Iridium, Materials.Naquadah),

        UV(OrePrefixes.circuit.get(Materials.UV), OrePrefixes.wireGt08.get(Materials.YttriumBariumCuprate),
                Materials.ElectrumFlux, OrePrefixes.wireGt02.get(Materials.NaquadahAlloy),
                OrePrefixes.gemExquisite.get(Materials.GarnetRed), new ItemStack(Blocks.dragon_egg, 1), "blockGlassUV",
                Materials.Osmium, Materials.Neutronium),

        UHV(OrePrefixes.circuit.get(Materials.UHV), OrePrefixes.wireGt16.get(Materials.YttriumBariumCuprate),
                Materials.Bedrockium, OrePrefixes.wireGt02.get(Materials.Bedrockium), null, null, "blockGlassUHV",
                Materials.Neutronium, Materials.Neutronium),

        UEV(OrePrefixes.circuit.get(Materials.UEV), OrePrefixes.wireGt04.get(Materials.Bedrockium), Materials.Draconium,
                OrePrefixes.wireGt02.get(Materials.Draconium), null, null, "blockGlassUEV", Materials.Bedrockium,
                Materials.Infinity),

        UIV(OrePrefixes.circuit.get(Materials.UIV), OrePrefixes.wireGt08.get(Materials.Bedrockium),
                Materials.NetherStar, OrePrefixes.wireGt02.get(Materials.NetherStar), null, null, "blockGlassUIV",
                Materials.CosmicNeutronium, MaterialsUEVplus.TranscendentMetal),

        UMV(OrePrefixes.circuit.get(Materials.UMV), OrePrefixes.wireGt16.get(Materials.Bedrockium), Materials.Quantium,
                OrePrefixes.wireGt02.get(Materials.Quantium), null, null, "blockGlassUMV",
                MaterialsUEVplus.TranscendentMetal, MaterialsUEVplus.SpaceTime);

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

        AdvancedGTMaterials(Object pCircuit, Object pHeatingCoil, Materials pCable, Object pCoilWire, Object pGem,
                Object pPowerGem, Object glass, Materials pPlateMaterial, Materials pPipe) {
            _mCircuit = pCircuit;
            _mHeatingCoil = pHeatingCoil;
            _mCoilWire = pCoilWire;
            _mMachineCable = OrePrefixes.cableGt01.get(pCable);
            _mMachineCable4 = OrePrefixes.cableGt04.get(pCable);
            _mGem = pGem;
            _mPowerGem = pPowerGem;
            _mPlate = OrePrefixes.plate.get(pPlateMaterial);
            _mReinfGlass = glass;
            _mPipe = OrePrefixes.pipeMedium.get(pPipe);
            _mPipeL = OrePrefixes.pipeLarge.get(pPipe);
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
        GameRegistry.registerItem(QuantumBread.Instance(), "itemQuantumToast");
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
    }
}
