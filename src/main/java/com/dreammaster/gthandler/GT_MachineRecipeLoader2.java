package com.dreammaster.gthandler;

import cpw.mods.fml.common.Loader;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;


public class GT_MachineRecipeLoader2 implements Runnable {
    @Override
    public void run() {
    // Circuits and Boards
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), Materials.Glue.getFluid(576), ItemList.Circuit_Board_Coated_Basic.get(8L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), Materials.Plastic.getMolten(288L), ItemList.Circuit_Board_Coated_Basic.get(16L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), Materials.Polytetrafluoroethylene.getMolten(144L), ItemList.Circuit_Board_Coated_Basic.get(16L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), Materials.Epoxid.getMolten(144L), ItemList.Circuit_Board_Coated_Basic.get(24L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), Materials.Polybenzimidazole.getMolten(72L), ItemList.Circuit_Board_Coated_Basic.get(32L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8), GT_Utility.getIntegratedCircuit(1), Materials.Glue.getFluid(288), ItemList.Circuit_Board_Phenolic.get(8L), 2400, 16);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8), GT_Utility.getIntegratedCircuit(1), Materials.BisphenolA.getFluid(144), ItemList.Circuit_Board_Phenolic.get(16L), 2400, 16);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8), GT_Utility.getIntegratedCircuit(1), Materials.Epoxid.getMolten(144L), ItemList.Circuit_Board_Phenolic.get(24L), 2400, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Phenolic.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 4), Materials.IronIIIChloride.getFluid(100L), GT_Values.NF, ItemList.Circuit_Board_Phenolic_Good.get(1L), 600, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Phenolic.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 4), Materials.SodiumPersulfate.getFluid(200), GT_Values.NF, ItemList.Circuit_Board_Phenolic_Good.get(1L), 600, 30);

        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4), Materials.SulfuricAcid.getFluid(500), GT_Values.NF, ItemList.Circuit_Board_Plastic.get(1L), 500, 10);
        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PolyvinylChloride, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4), Materials.SulfuricAcid.getFluid(500), GT_Values.NF, ItemList.Circuit_Board_Plastic.get(2L), 500, 10);
        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polytetrafluoroethylene, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4), Materials.SulfuricAcid.getFluid(500), GT_Values.NF, ItemList.Circuit_Board_Plastic.get(4L), 500, 10);
        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polybenzimidazole, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4), Materials.SulfuricAcid.getFluid(500), GT_Values.NF, ItemList.Circuit_Board_Plastic.get(8L), 500, 10);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Plastic.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 6), Materials.IronIIIChloride.getFluid(250L), GT_Values.NF, ItemList.Circuit_Board_Plastic_Advanced.get(1L), 800, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Plastic.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 6), Materials.SodiumPersulfate.getFluid(500), GT_Values.NF, ItemList.Circuit_Board_Plastic_Advanced.get(1L), 800, 30);

        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Epoxid, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 8), Materials.SulfuricAcid.getFluid(500), GT_Values.NF, ItemList.Circuit_Board_Epoxy.get(1L), 600, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Epoxy.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8), Materials.IronIIIChloride.getFluid(500L), GT_Values.NF, ItemList.Circuit_Board_Epoxy_Advanced.get(1L), 1200, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Epoxy.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8), Materials.SodiumPersulfate.getFluid(1000L), GT_Values.NF, ItemList.Circuit_Board_Epoxy_Advanced.get(1L), 1200, 30);

        GT_Values.RA.addChemicalBathRecipe(ItemList.Circuit_Parts_GlassFiber.get(1L), Materials.Epoxid.getMolten(144L), Materials.EpoxidFiberReinforced.getPlates(1), GT_Values.NI, GT_Values.NI, new int[]{10000}, 240, 16);
        GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getIC2Item("carbonFiber", 1), Materials.Epoxid.getMolten(144L), Materials.EpoxidFiberReinforced.getPlates(1), GT_Values.NI, GT_Values.NI, new int[]{10000}, 240, 16);
        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EpoxidFiberReinforced, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 12), Materials.SulfuricAcid.getFluid(500), GT_Values.NF, ItemList.Circuit_Board_Fiberglass.get(1L), 500, 10);

        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Fiberglass.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.AnnealedCopper, 12), Materials.IronIIIChloride.getFluid(1000L), GT_Values.NF, ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_Values.NI, 1800, 30, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Fiberglass.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.AnnealedCopper, 12), Materials.SodiumPersulfate.getFluid(2000),GT_Values.NF, ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_Values.NI, 1800, 30, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Fiberglass.get(2L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 16), Materials.SulfuricAcid.getFluid(500), null, ItemList.Circuit_Board_Multifiberglass.get(1L), GT_Values.NI, 600, 480, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Multifiberglass.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 16), Materials.IronIIIChloride.getFluid(2000L), GT_Values.NF, ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), GT_Values.NI, 2400, 120, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Wetware.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32), Materials.IronIIIChloride.getFluid(5000L), GT_Values.NF, ItemList.Circuit_Board_Wetware_Extreme.get(1L), GT_Values.NI, 3000, 480, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Multifiberglass.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 16), Materials.SodiumPersulfate.getFluid(4000), GT_Values.NF, ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), GT_Values.NI, 2400, 120, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Wetware.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32), Materials.SodiumPersulfate.getFluid(10000L), GT_Values.NF, ItemList.Circuit_Board_Wetware_Extreme.get(1L), GT_Values.NI, 3000, 480, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Bio.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 48), Materials.IronIIIChloride.getFluid(7500L), GT_Values.NF, ItemList.Circuit_Board_Bio_Ultra.get(1L), GT_Values.NI, 3600, 1920, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Bio.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 48), Materials.SodiumPersulfate.getFluid(14000L), GT_Values.NF, ItemList.Circuit_Board_Bio_Ultra.get(1L), GT_Values.NI, 3600, 1920, true);

        GT_Values.RA.addChemicalRecipe(new ItemStack(Items.spawn_egg, 1,GT_Values.W), GT_ModHandler.getModItem("Genetics", "misc", 64L, 4), FluidRegistry.getFluidStack("binnie.bacteria", 1000), GT_Values.NF, CustomItemList.TheBigEgg.get(1L), GT_Values.NI, 72000, 120, true);
        GT_Values.RA.addChemicalRecipe(CustomItemList.TheBigEgg.get(1L), GT_ModHandler.getModItem("IC2", "itemUran238", 64L, 0), FluidRegistry.getFluidStack("mutagen", 1000), GT_Values.NF, CustomItemList.MutatedEgg.get(1L), GT_Values.NI, 72000, 256, true);
        GT_Values.RA.addChemicalRecipe(CustomItemList.MutatedEgg.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HeeEndium, 64), FluidRegistry.getFluidStack("ender", 1000), GT_Values.NF, CustomItemList.EnderEgg.get(1L), GT_Values.NI, 72000, 480, true);
        GT_Values.RA.addChemicalRecipe(CustomItemList.EnderEgg.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 64), FluidRegistry.getFluidStack("endergoo", 1000), GT_Values.NF, CustomItemList.DraconiumEgg.get(1L), GT_Values.NI, 72000, 1024, true);
        GT_Values.RA.addChemicalRecipe(CustomItemList.DraconiumEgg.get(1L), GT_ModHandler.getModItem("DraconicEvolution", "dragonHeart", 0L, 0), FluidRegistry.getFluidStack("enderium.molten", 1000), GT_Values.NF, new ItemStack(Blocks.dragon_egg, 1, 0), GT_Values.NI, 72000, 1920, true);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Glass_Tube.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4)}, Materials.RedAlloy.getMolten(72L), ItemList.Circuit_Parts_Vacuum_Tube.get(4L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Glass_Tube.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4)}, Materials.RedstoneAlloy.getMolten(72L), ItemList.Circuit_Parts_Vacuum_Tube.get(8L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Glass_Tube.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4)}, Materials.RedAlloy.getMolten(72L), ItemList.Circuit_Parts_Vacuum_Tube.get(8L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Glass_Tube.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4)}, Materials.RedstoneAlloy.getMolten(72L), ItemList.Circuit_Parts_Vacuum_Tube.get(16L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 4)}, Materials.Plastic.getMolten(288L), ItemList.Circuit_Parts_ResistorSMD.get(16L), 320, 96);
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1), ItemList.Shape_Mold_Ball.get(0), ItemList.Circuit_Parts_Glass_Tube.get(1L), 240, 16);
        GT_Values.RA.addAlloySmelterRecipe(new ItemStack(Blocks.obsidian, 1, 0), ItemList.Shape_Mold_Ingot.get(0L, new Object[0]), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2L), 130, 3);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1), Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Diode.get(4L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1), Materials.Glass.getMolten(288L), ItemList.Circuit_Parts_Diode.get(2L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1), FluidRegistry.getFluidStack("glass.molten", 1000), ItemList.Circuit_Parts_Diode.get(2L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), ItemList.Circuit_Silicon_Wafer.get(1L), Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Diode.get(2L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), ItemList.Circuit_Silicon_Wafer.get(1L), FluidRegistry.getFluidStack("glass.molten", 1000), ItemList.Circuit_Parts_Diode.get(1L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), ItemList.Circuit_Silicon_Wafer.get(1L), Materials.Glass.getMolten(288L), ItemList.Circuit_Parts_Diode.get(1L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1), Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Diode.get(6L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), ItemList.Circuit_Silicon_Wafer.get(1L), Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Diode.get(4L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 8), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 1)}, Materials.Plastic.getMolten(288L), ItemList.Circuit_Parts_DiodeSMD.get(32L), 600, 120);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), Materials.Plastic.getMolten(36L), ItemList.Circuit_Parts_Coil.get(2L), 320, 30);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), Materials.Plastic.getMolten(36L), ItemList.Circuit_Parts_Coil.get(4L), 320, 30);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2), Materials.Plastic.getMolten(36L), ItemList.Circuit_Parts_Coil.get(4L), 320, 60);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2), Materials.Plastic.getMolten(36L), ItemList.Circuit_Parts_Coil.get(8L), 320, 60);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 8), Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Transistor.get(6L), 320, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gallium, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 8)}, Materials.Plastic.getMolten(288L), ItemList.Circuit_Parts_TransistorSMD.get(16L), 320, 120);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2), Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Capacitor.get(8L), 320, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_CapacitorSMD.get(16L), 320, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyvinylChloride, 4), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_CapacitorSMD.get(24), 320, 120);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 0), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Copper, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 1), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 2), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Bronze, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 3), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 4), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 5), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 6), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 7), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 8), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 9), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 10), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 11), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Neutronium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 12), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.BlackPlutonium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 13), 200, 16);

        GT_Values.RA.addExtruderRecipe(Materials.BorosilicateGlass.getIngots(1), ItemList.Shape_Extruder_Wire.get(0), ItemList.Circuit_Parts_GlassFiber.get(8L), 160, 96);
        GT_Values.RA.addWiremillRecipe(Materials.BorosilicateGlass.getIngots(1), ItemList.Circuit_Parts_GlassFiber.get(4L), 200, 120);

        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer2.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)), ItemList.Circuit_Wafer_NAND.get(1L), 900, 480, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer3.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)), ItemList.Circuit_Wafer_NAND.get(4L), 600, 1920, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer2.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)), ItemList.Circuit_Wafer_NOR.get(1L), 900, 480, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer3.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)), ItemList.Circuit_Wafer_NOR.get(4L), 600, 1920, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_ILC.get(1L), ItemList.Circuit_Chip_ILC.get(8L), GT_Values.NI, 900, 64);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_Ram.get(1L), ItemList.Circuit_Chip_Ram.get(32L), GT_Values.NI, 900, 96);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_NAND.get(1L), ItemList.Circuit_Chip_NAND.get(32L), GT_Values.NI, 900, 192, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_NOR.get(1L), ItemList.Circuit_Chip_NOR.get(16L), GT_Values.NI, 900, 192, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_CPU.get(1L), ItemList.Circuit_Chip_CPU.get(8L), GT_Values.NI, 900, 120, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_Simple_SoC.get(1L), ItemList.Circuit_Chip_Simple_SoC.get(6L), GT_Values.NI, 900, 64, false);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_SoC.get(1L), ItemList.Circuit_Chip_SoC.get(6L), GT_Values.NI, 900, 480, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_SoC2.get(1L), ItemList.Circuit_Chip_SoC2.get(6L), GT_Values.NI, 900, 1024, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_ULPIC.get(1L), ItemList.Circuit_Chip_ULPIC.get(6L), GT_Values.NI, 900, 120, false);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_LPIC.get(1L), ItemList.Circuit_Chip_LPIC.get(4L), GT_Values.NI, 900, 480, false);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_PIC.get(1L), ItemList.Circuit_Chip_PIC.get(4L), GT_Values.NI, 900, 1920, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_HPIC.get(1L), ItemList.Circuit_Chip_HPIC.get(2L), GT_Values.NI, 900, 7860, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_UHPIC.get(1L), ItemList.Circuit_Chip_UHPIC.get(2L), GT_Values.NI, 900, 30720, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_NPIC.get(1L), ItemList.Circuit_Chip_NPIC.get(2L), GT_Values.NI, 900, 122880, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_PPIC.get(1L), ItemList.Circuit_Chip_PPIC.get(2L), GT_Values.NI, 900, 500000, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_QPIC.get(1L), ItemList.Circuit_Chip_QPIC.get(2L), GT_Values.NI, 900, 2000000, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_NanoCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(8L), GT_Values.NI, 900, 480, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_QuantumCPU.get(1L), ItemList.Circuit_Chip_QuantumCPU.get(4L), GT_Values.NI, 900, 1920, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_PIC.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 2), Materials.VanadiumGallium.getMolten(288L), GT_Values.NF, ItemList.Circuit_Wafer_HPIC.get(1L), GT_Values.NI, 1200, 7860, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_HPIC.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 8), Materials.Naquadah.getMolten(576L), GT_Values.NF, ItemList.Circuit_Wafer_UHPIC.get(1L), GT_Values.NI, 1200, 30720, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_NPIC.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 64), Materials.Sunnarium.getMolten(1440L), GT_Values.NF, ItemList.Circuit_Wafer_PPIC.get(1L), GT_Values.NI, 1200, 122880, true);

        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_CPU.get(1L), GT_Utility.copyAmount(16, Ic2Items.carbonFiber), Materials.Glowstone.getMolten(576L), GT_Values.NF, ItemList.Circuit_Wafer_NanoCPU.get(1L), GT_Values.NI, 1200, 1920, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_NanoCPU.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 1), Materials.Radon.getGas(50L), GT_Values.NF, ItemList.Circuit_Wafer_QuantumCPU.get(1L), GT_Values.NI, 1200, 1920, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_NanoCPU.get(1L), ItemList.QuantumEye.get(2L), Materials.GalliumArsenide.getMolten(288L), GT_Values.NF, ItemList.Circuit_Wafer_QuantumCPU.get(1L), GT_Values.NI, 900, 1920, true);

        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(Materials.Hydrogen.getCells(3)), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnetite, 0), Materials.Nitrogen.getGas(1000L), Materials.Ammonia.getGas(1000), ItemList.Cell_Empty.get(3L), 320, 384);

        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Chip_Stemcell.get(4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1), Materials.BioMediumRaw.getFluid(1000L), FluidRegistry.getFluidStack("mutagen", 250), ItemList.Circuit_Chip_Biocell.get(1L), 1200, 1920);

        GT_Values.RA.addAutoclaveSpaceRecipe(GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1), Materials.Europium.getMolten(16), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 1000, 12000, 320, true);
        GT_Values.RA.addAutoclaveSpaceRecipe(GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Olivine, 1), Materials.Europium.getMolten(16), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 1000, 12000, 320, true);

        GT_Values.RA.addForgeHammerRecipe(ItemList.Circuit_Parts_RawCrystalChip.get(1L), ItemList.Circuit_Parts_RawCrystalParts.get(9), 100, 480);
        GT_Values.RA.addAutoclaveRecipe(ItemList.Circuit_Parts_RawCrystalParts.get(1L), FluidRegistry.getFluidStack("bacterialsludge", 250), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 6000, 12000, 480);
        GT_Values.RA.addAutoclaveRecipe(ItemList.Circuit_Parts_RawCrystalParts.get(1L), FluidRegistry.getFluidStack("mutagen", 250), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 8000, 12000, 480);
        GT_Values.RA.addAutoclaveRecipe(ItemList.Circuit_Parts_RawCrystalParts.get(1L), Materials.Europium.getMolten(16), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 10000, 12000, 480);

        GT_Values.RA.addAutoclaveSpaceRecipe(GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 12), Materials.UUMatter.getFluid(250L), ItemList.Tool_DataOrb.get(1L), 10000, 12000, 960, true);
        GT_Values.RA.addAutoclaveSpaceRecipe(GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Olivine, 12), Materials.UUMatter.getFluid(250L), ItemList.Tool_DataOrb.get(1L), 10000, 12000, 960, true);
    //GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Parts_RawCrystalChip.get(9), new Object[]{ItemList.Circuit_Chip_CrystalCPU.get(1L)});
        GT_Values.RA.addBlastRecipe(ItemList.Circuit_Parts_RawCrystalChip.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1), Materials.Helium.getGas(1000), GT_Values.NF, ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L), GT_Values.NI, 900, 480, 5000);
        GT_Values.RA.addBlastRecipe(ItemList.Circuit_Parts_RawCrystalChip.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Olivine, 1), Materials.Helium.getGas(1000), GT_Values.NF, ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L), GT_Values.NI, 900, 480, 5000);
    // GC/GS Wafer
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer.get(1L), CustomItemList.ReinforcedGlassLense.get(0), GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 13), 200, 256);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer2.get(1L), CustomItemList.ReinforcedGlassLense.get(0), GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 14), 200, 480);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer3.get(1L), CustomItemList.ReinforcedGlassLense.get(0), CustomItemList.WaferTier3.get(1L), 200, 1024);

    //Field Generator
        GT_Values.RA.addAssemblerRecipe(ItemList.QuantumStar.get(1L), ItemList.Circuit_Ultimate.get(4L), Materials.HSSS.getMolten(1728), ItemList.Field_Generator_IV.get(1L), 1800, 7680);

    //Motors
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnyCopper, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)}, GT_Values.NF, ItemList.Electric_Motor_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnyCopper, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)}, GT_Values.NF, ItemList.Electric_Motor_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2L)}, GT_Values.NF, ItemList.Electric_Motor_MV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Silver, 2L)}, GT_Values.NF, ItemList.Electric_Motor_HV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.AnnealedCopper, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2L)}, GT_Values.NF, ItemList.Electric_Motor_EV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Graphene, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2L)}, GT_Values.NF, ItemList.Electric_Motor_IV.get(1L), 200, 30);

    //Pumps
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF, ItemList.Electric_Pump_LV.get(1L), 20, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF, ItemList.Electric_Pump_LV.get(1L), 20, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF, ItemList.Electric_Pump_LV.get(1L), 20, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF, ItemList.Electric_Pump_MV.get(1L), 20, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF, ItemList.Electric_Pump_MV.get(1L), 20, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF, ItemList.Electric_Pump_MV.get(1L), 20, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 20, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 20, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 20, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1)}, GT_Values.NF, ItemList.Electric_Pump_EV.get(1L), 20, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1)}, GT_Values.NF, ItemList.Electric_Pump_EV.get(1L), 20, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1)}, GT_Values.NF, ItemList.Electric_Pump_EV.get(1L), 20, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_IV.get(1L), 20, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_IV.get(1L), 20, 480);

    //Conveyors
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF, ItemList.Conveyor_Module_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF, ItemList.Conveyor_Module_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF, ItemList.Conveyor_Module_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1)}, GT_Values.NF, ItemList.Conveyor_Module_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1)}, GT_Values.NF, ItemList.Conveyor_Module_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1)}, GT_Values.NF, ItemList.Conveyor_Module_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF, ItemList.Conveyor_Module_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF, ItemList.Conveyor_Module_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF, ItemList.Conveyor_Module_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1)}, GT_Values.NF, ItemList.Conveyor_Module_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1)}, GT_Values.NF, ItemList.Conveyor_Module_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1)}, GT_Values.NF, ItemList.Conveyor_Module_IV.get(1L), 200, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1)}, GT_Values.NF, ItemList.Conveyor_Module_IV.get(1L), 200, 480);

    //Pistons
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1)}, GT_Values.NF, ItemList.Electric_Piston_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 1)}, GT_Values.NF, ItemList.Electric_Piston_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1)}, GT_Values.NF, ItemList.Electric_Piston_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 1)}, GT_Values.NF, ItemList.Electric_Piston_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenSteel, 1)}, GT_Values.NF, ItemList.Electric_Piston_IV.get(1L), 200, 480);

    //Robot Arms
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), ItemList.Electric_Piston_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 3)}, GT_Values.NF, ItemList.Robot_Arm_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), ItemList.Electric_Piston_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),  GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 3)}, GT_Values.NF, ItemList.Robot_Arm_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), ItemList.Electric_Piston_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),  GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 3)}, GT_Values.NF, ItemList.Robot_Arm_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L), ItemList.Electric_Piston_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),  GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 3)}, GT_Values.NF, ItemList.Robot_Arm_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L), ItemList.Electric_Piston_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),  GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 3)}, GT_Values.NF, ItemList.Robot_Arm_IV.get(1L), 200, 480);

    //Emitter
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2)}, GT_Values.NF, ItemList.Emitter_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2)}, GT_Values.NF, ItemList.Emitter_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2)}, GT_Values.NF, ItemList.Emitter_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumEye.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2)}, GT_Values.NF, ItemList.Emitter_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumStar.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2)}, GT_Values.NF, ItemList.Emitter_IV.get(1L), 200, 480);

    //Sensor
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),}, GT_Values.NF, ItemList.Sensor_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Emerald, 1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),}, GT_Values.NF, ItemList.Sensor_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),}, GT_Values.NF, ItemList.Sensor_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumEye.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),}, GT_Values.NF, ItemList.Sensor_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumStar.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),}, GT_Values.NF, ItemList.Sensor_IV.get(1L), 200, 480);

        GT_Values.RA.addSifterRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedPurified, Materials.Cinnabar, 1L), new ItemStack[]{Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Cinnabar.getDust(1)}, new int[]{100, 300, 500, 1000, 1000, 1500, 2300, 2500, 3500}, 7200, 30);

        if (Loader.isModLoaded("thaumicbases")) {
        GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("thaumicbases", "resource", 1L, 7), new ItemStack[]{GT_ModHandler.getModItem("thaumicbases", "tobaccoPowder", 1L, 0)}, new int[]{10000}, 10, 2);
    }

    // --- Stargates
        if (Loader.isModLoaded("GalaxySpace") && Loader.isModLoaded("SGCraft"))
                for (byte i = 0; i < 6; ++i)
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("GalaxySpace", "tcetiedandelions", 64L, i), com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS(), 3600, 262144);
        GT_Values.RA.addMixerRecipe(com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS().splitStack(64), Materials.Dolomite.getDust(64), Materials.SamariumMagnetic.getDust(21), Materials.ChromiumDioxide.getDust(64), GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 54L), GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 47L), GT_Values.NF, GT_Values.NF, com.dreammaster.item.ItemList.StargateCrystalDust.getIS(), 3600, 262144);
        GT_Values.RA.addAutoclaveSpaceRecipe(com.dreammaster.item.ItemList.StargateCrystalDust.getIS().splitStack(64), Materials.Silver.getPlasma(8000L), GT_ModHandler.getModItem("SGCraft", "sgCoreCrystal", 1L), 10000, 3600, 131000, true);

    /*Stuff from CoreMod minetweaker script
     * AlloySmelter
     */
        GT_Values.RA.addAlloySmelterRecipe(Materials.Aluminium.getIngots(2), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.AluminiumItemCasing.getIS().splitStack(3), 240, 30);
        GT_Values.RA.addAlloySmelterRecipe(Materials.StainlessSteel.getIngots(2), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.StainlessSteelItemCasing.getIS().splitStack(3), 240, 30);
        GT_Values.RA.addAlloySmelterRecipe(Materials.Titanium.getIngots(2), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.TitaniumItemCasing.getIS().splitStack(3), 480, 64);
        GT_Values.RA.addAlloySmelterRecipe(Materials.Chrome.getIngots(2), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.ChromeItemCasing.getIS().splitStack(3), 480, 64);
        GT_Values.RA.addAlloySmelterRecipe(Materials.Tungsten.getIngots(2), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.TungstenItemCasing.getIS().splitStack(3), 960, 120);
        GT_Values.RA.addAlloySmelterRecipe(Materials.TungstenSteel.getIngots(2), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.TungstenSteelItemCasing.getIS().splitStack(3), 960, 120);
        GT_Values.RA.addAlloySmelterRecipe(Materials.Iridium.getIngots(2), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.IridiumItemCasing.getIS().splitStack(3), 1200, 256);
        GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("IC2","itemPartIridium",2L), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.IridiumAlloyItemCasing.getIS().splitStack(3), 1200, 256);
        GT_Values.RA.addAlloySmelterRecipe(Materials.Osmium.getIngots(2), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.OsmiumItemCasing.getIS().splitStack(3), 1200, 256);
        GT_Values.RA.addAlloySmelterRecipe(Materials.Neutronium.getIngots(2), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.NeutroniumItemCasing.getIS().splitStack(3), 1800, 480);
    //Assembler
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.stick,Materials.Iron,1L),GT_OreDictUnificator.get(OrePrefixes.frameGt,Materials.Wood,2L)},Materials.Glue.getFluid(36L),GT_ModHandler.getModItem("Railcraft","machine.alpha",1L,14),200,8,false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.stick,Materials.IronMagnetic,1L),GT_OreDictUnificator.get(OrePrefixes.frameGt,Materials.Wood,2L)},Materials.Glue.getFluid(36L),GT_ModHandler.getModItem("Railcraft","machine.alpha",1L,14),200,8,false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.stick,Materials.WroughtIron,1L),GT_OreDictUnificator.get(OrePrefixes.frameGt,Materials.Wood,2L)},Materials.Glue.getFluid(36L),GT_ModHandler.getModItem("Railcraft","machine.alpha",1L,14),200,8,false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.bolt,Materials.Steel,4L),GT_OreDictUnificator.get(OrePrefixes.frameGt,Materials.Wood,4L)},Materials.Glue.getFluid(72L),GT_ModHandler.getModItem("Railcraft","machine.alpha",3L,14),400,30,false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.bolt,Materials.Steel,2L),GT_OreDictUnificator.get(OrePrefixes.frameGt,Materials.WoodSealed,1L)},Materials.Plastic.getMolten(36L),GT_ModHandler.getModItem("Railcraft","machine.alpha",3L,14),400,30,false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.bolt,Materials.StainlessSteel,4L),GT_OreDictUnificator.get(OrePrefixes.frameGt,Materials.WoodSealed,4L)},Materials.Plastic.getMolten(72L),GT_ModHandler.getModItem("Railcraft","machine.alpha",9L,14),400,120,false);

        for (byte i=0; i<OreDictionary.getOres("cropCotton").size();++i) {
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {new ItemStack(Items.string,4),OreDictionary.getOres("cropCotton").get(i).splitStack(3)},GT_Values.NF,GT_ModHandler.getModItem("harvestcraft","wovencottonItem",1L,0),400,30,false);
    }

        /*GT_Values.RA.addAssemblerRecipe(new ItemStack[] {new ItemStack(Blocks.cobblestone),GT_OreDictUnificator.get(OrePrefixes.gearGtSmall,Materials.AnyIron,1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.block.BlockList.PistonBlock.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {new ItemStack(Blocks.fence),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_ModHandler.getModItem("Natura","Natura.fence",1L),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_ModHandler.getModItem("Forestry","fences",1L),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_ModHandler.getModItem("ExtraTrees","fence",1L),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_ModHandler.getModItem("Forestry","fencesFireproof",1L),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        */
    //recipes for everything that uses sand
        for (byte i=0; i<OreDictionary.getOres("sand").size();++i) {
        GT_Values.RA.addPulveriserRecipe(OreDictionary.getOres("sand").get(i), new ItemStack[]{CustomItemList.SandDust.get(1L), CustomItemList.SandDust.get(1L), CustomItemList.SandDust.get(1L), CustomItemList.SandDust.get(1L)}, new int[]{10000, 2500, 2000, 1500}, 200, 8);
        GT_Values.RA.addAlloySmelterRecipe(OreDictionary.getOres("sand").get(i), new ItemStack(Items.clay_ball), com.dreammaster.item.ItemList.CokeOvenBrick.getIS().splitStack(2), 200, 8);
    }

        GT_Values.RA.addChemicalRecipe(new ItemStack(Items.ghast_tear), GT_Utility.getIntegratedCircuit(1), Materials.Water.getFluid(1000L), Materials.SaltWater.getFluid(1000L), Materials.Potassium.getDustTiny(1), Materials.Lithium.getDustTiny(1), 400, 30, false);
        GT_Values.RA.addBlastRecipe(Materials.Zincite.getDust(2), Materials.Carbon.getDust(1), GT_Values.NF, Materials.CarbonDioxide.getGas(1000L), Materials.Zinc.getIngots(3), Materials.Ash.getDustTiny(2), 240, 120, 1200);
        GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getModItem("IC2", "itemBiochaff", 1L, 0), Materials.Water.getFluid(750L), GT_ModHandler.getModItem("Forestry", "mulch", 8L, 0),  GT_ModHandler.getModItem("Forestry", "mulch", 4L, 0), GT_ModHandler.getModItem("Forestry", "mulch", 4L, 0), new int[]{10000,3300,2000}, 500, 30);

    //EnderIO Fused Quartz and Glass
        if (Loader.isModLoaded("EnderIO")){
        GT_Values.RA.addAlloySmelterRecipe(Materials.CertusQuartz.getDust(2), Materials.Glass.getDust(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 30);
        GT_Values.RA.addAlloySmelterRecipe(Materials.NetherQuartz.getDust(2), Materials.Glass.getDust(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 30);
        GT_Values.RA.addAlloySmelterRecipe(Materials.CertusQuartz.getDust(2), Materials.Quartzite.getDust(2), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 30);
        GT_Values.RA.addAlloySmelterRecipe(Materials.NetherQuartz.getDust(2), Materials.Quartzite.getDust(2), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 30);
        GT_Values.RA.addAlloySmelterRecipe(Materials.CertusQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 90);
        GT_Values.RA.addAlloySmelterRecipe(Materials.NetherQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 90);

        GT_Values.RA.addAlloySmelterRecipe(Materials.Glass.getDust(3), GT_Utility.getIntegratedCircuit(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,1), 500, 30);
        GT_Values.RA.addAlloySmelterRecipe(Materials.Quartzite.getDust(4), GT_Utility.getIntegratedCircuit(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,1), 500, 30);
        GT_Values.RA.addAlloySmelterRecipe(Materials.BorosilicateGlass.getDust(1), GT_Utility.getIntegratedCircuit(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 2L,1), 500, 90);

        GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), Materials.Glowstone.getDust(4), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,2), 500, 30);
        GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), new ItemStack(Blocks.glowstone), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,2), 500, 30);
        GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,1), Materials.Glowstone.getDust(4), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,3), 500, 30);
        GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,1), new ItemStack(Blocks.glowstone), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,3), 500, 30);

        for (int i=0; i<OreDictionary.getOres("dyeBlack").size();i++) {
            GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), OreDictionary.getOres("dyeBlack").get(i).splitStack(4), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,4), 500, 30);
            GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,1), OreDictionary.getOres("dyeBlack").get(i).splitStack(4), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,5), 500, 30);
        }

        GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,4), GT_Values.NI, GT_Values.NI, new int[]{10000}, 500, 30);
        GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,1), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L,5), GT_Values.NI, GT_Values.NI, new int[]{10000}, 500, 30);
    }

        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Wafer_SoC2.get(1L),GT_OreDictUnificator.get(OrePrefixes.lens,Materials.NetherStar,1L).copy().splitStack(0), com.dreammaster.item.ItemList.RawPicoWafer.getIS(),6000,(int)(GT_Values.V[8]-(GT_Values.V[8]/10)),true);
        GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[]{com.dreammaster.item.ItemList.RawPicoWafer.getIS(),Materials.MysteriousCrystal.getDust(2),GT_OreDictUnificator.get(OrePrefixes.dustTiny,Materials.InfinityCatalyst,1L).copy().splitStack(0), com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS(1)},new FluidStack[]{Materials.Neutronium.getMolten(100L)},new FluidStack[]{GT_Values.NF},new ItemStack[]{com.dreammaster.item.ItemList.PicoWafer.getIS()},3000,(int)(GT_Values.V[9]-(GT_Values.V[9]/10)));

        if (Loader.isModLoaded("OpenComputers")) {
        //cable
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.RedstoneAlloy, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Emerald, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 200, 120);
        //keyboard
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.stone_button, 64), new ItemStack(Blocks.stone_button, 40), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), CustomItemList.AluminiumItemCasing.get(1L)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), 200, 64);
        //case 1
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2), CustomItemList.AluminiumItemCasing.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "case1", 1, 0), 200, 120);
        //case 2
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2), CustomItemList.AluminiumItemCasing.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "case2", 1, 0), 200, 256);
        //case 3
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2), ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2), CustomItemList.AluminiumItemCasing.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "case3", 1, 0), 200, 480);
        //micro case 1
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), CustomItemList.AluminiumItemCasing.get(2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 82), 200, 120);
        //mirco case 2
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), CustomItemList.TitaniumItemCasing.get(2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 86), 200, 256);
        //drone case 1
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 82), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 4L), CustomItemList.AluminiumItemCasing.get(1L), ItemList.Electric_Motor_HV.get(4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1, 83), 300, 256);
        //drone case 2
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 86), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 4L), CustomItemList.TitaniumItemCasing.get(1L), ItemList.Electric_Motor_EV.get(4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1, 87), 300, 480);
        //Card
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 1), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), 200, 64);
        //floppy
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 4), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4), 200, 64);

        //floppys w NBT
        make_floppy("OpenOS (Operating System)","openos", 2, 1);
        make_floppy("Plan9k (Operating System)","plan9k", 1, 2);
        make_floppy("Network (Network Stack)","network", 10, 3);
        make_floppy("Data Card Software","data", 9, 4);
        make_floppy("OpenLoader (Boot Loader)","openloader", 13, 5);
        make_floppy("Builder","builder", 11, 6);
        make_floppy("Generator","generator", 5, 7);
        make_floppy("OPPM (Package Manager)","oppm", 6, 8);
        make_floppy("Digger","dig", 3, 9);
        make_floppy("Mazer","maze", 14, 10);
        make_floppy("OpenIRC (IRC Client)","irc", 12, 11);

        //HDD 1
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.AluminiumItemCasing.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 19), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5), 300, 120);
        //HDD 2
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.TitaniumItemCasing.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 19), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 2), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6), 300, 256);
        //HDD 3
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.TungstenSteelItemCasing.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 19), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 38), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7), 300, 480);
        //disk
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 4), GT_Utility.getIntegratedCircuit(1)}, Materials.Cobalt.getMolten(36L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19), 200, 120);
        //rack
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "powerDistributor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 4L), CustomItemList.AluminiumItemCasing.get(4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "rack", 1L, 0), 200, 256);
        //adapter block
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "adapter", 1L, 0), 200, 120);
        //assembler
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Robot_Arm_LV.get(3L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "assembler", 1L, 0), 200, 256);
        //disassembler
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Robot_Arm_HV.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "disassembler", 1L, 0), 200, 256);
        //capacitor
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(2L), GT_ModHandler.getModItem("IC2", "blockElectric", 1L, 7), ItemList.Circuit_Board_Plastic_Advanced.get(2L), ItemList.Circuit_Parts_Transistor.get(1L), GT_ModHandler.getModItem("OpenComputers", "cable", 2), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), 200, 120);
        //charger
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("IC2", "blockChargepad", 2L, 2), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_ModHandler.getModItem("OpenComputers", "cable", 2), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "charger", 1L, 0), 200, 256);
        //diskDrive
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 3L, 25), ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.springSmall, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), 200, 120);
        //diskDriver
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), CustomItemList.SteelBars.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 109), 200, 480);
        //geolyzer
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), ItemList.Sensor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 2)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "geolyzer", 1L, 0), 200, 120);
        //hologram1
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), GT_Utility.getIntegratedCircuit(10)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "hologram1", 1L, 0), 200, 120);
        //hologram2
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Emerald, 1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Sapphire, 1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "hologram2", 1L, 0), 200, 256);
        //motionSensor
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), new ItemStack(Blocks.daylight_detector, 2, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "motionSensor", 1L, 0), 200, 120);
        //netSplitter
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4), GT_ModHandler.getModItem("OpenComputers", "cable", 3L, 0), ItemList.Electric_Piston_LV.get(1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "netSplitter", 1L, 0), 200, 64);
        //printer
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Machine_HV_Printer.get(1L), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "printer", 1L, 0), 200, 256);
        //powerConverter
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Transformer_HV_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "powerConverter", 1L, 0), 200, 256);
        //powerDistributor
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), GT_ModHandler.getModItem("IC2", "blockElectric", 1L, 7), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "powerDistributor", 1L, 0), 200, 256);
        //raid
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "raid", 1L, 0), 200, 256);
        //redstone
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 2), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), ItemList.Cover_ActivityDetector.get(1L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "redstone", 1L, 0), 200, 120);
        //relay
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), 200, 120);
        //transposer
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Automation_ChestBuffer_LV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 61), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "transposer", 2L, 0), 400, 120);
        //waypoint
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "waypoint", 1L, 0), 200, 64);
        //cartridge empty
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Plastic, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(36L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), 200, 64);
        //cartridge full
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32420), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32425), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32427)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 95), 200, 64);
        //Interweb
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1), new ItemStack(Items.string, 8, 0), GT_Utility.getIntegratedCircuit(2)}, Materials.Glue.getFluid(576L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), 200, 64);
        //Linked Card
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 2L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), GT_Utility.getIntegratedCircuit(1)}, Materials.EnderEye.getMolten(288L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 51), 400, 480);
        //Manual
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.book, 1, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Glue.getFluid(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 98), 100, 30);
        //Nano Machine
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 2), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 42), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 18), GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 107), 400, 256);
        //Server Tier 1
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "case1", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 45), 400, 256);
        //Server Tier 2
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "case2", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 38), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 46), 400, 480);
        //Server Tier 3
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "case3", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 39), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 40), 400, 1024);
        //Tablet Case Tier 1
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 74), 400, 120);
        //Tablet Case Tier 2
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 92), 400, 256);
        //remote Monitor
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 34), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 41), 400, 120);
        //Terminal Server
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 3L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 108), 400, 480);
        //Block of Chamelium
        GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96), GT_ModHandler.getModItem("OpenComputers", "chameliumBlock", 1L, 0), 300, 2);
        //Chamelium
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 4L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), Materials.Water.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96), 200, 120);
        //Open Printers
        //Printer
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Machine_MV_Printer.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("openprinter", "openprinter.printer", 1L, 0), 300, 120);
        //Shredder
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Machine_MV_Macerator.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("openprinter", "openprinter.shredder", 1L, 0), 300, 120);
        //Paper shreds
        GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("openprinter", "openprinter.paperShreds", 1L, 0), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1L)}, new int[]{10000}, 20, 2);
        //Paper Roll
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.paper, 64, 0), new ItemStack(Items.paper, 64, 0), new ItemStack(Items.paper, 64, 0), new ItemStack(Items.paper, 64, 0), GT_Utility.getIntegratedCircuit(3)}, GT_Values.NF, GT_ModHandler.getModItem("openprinter", "openprinter.printerPaperRoll", 1L, 0), 200, 64);
        //Black Ink Cartridge
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_Utility.getIntegratedCircuit(2)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("openprinter", "openprinter.printerInkBlack", 1L, GT_Values.W), 300, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("openprinter", "openprinter.printerInkBlack", 1L, GT_Values.W), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_Utility.getIntegratedCircuit(2)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("openprinter", "openprinter.printerInkBlack", 1L, GT_Values.W), 150, 120);
        //Color Ink Cartridge
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32415), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32416), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32418), GT_Utility.getIntegratedCircuit(2)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("openprinter", "openprinter.printerInkColor", 1L, GT_Values.W), 300, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("openprinter", "openprinter.printerInkColor", 1L, GT_Values.W), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32415), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32416), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32418), GT_Utility.getIntegratedCircuit(2)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("openprinter", "openprinter.printerInkColor", 1L, GT_Values.W), 150, 120);
        //Open Security
        //Magnetic Card Reader
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "magreader", 1L, 0), 300, 256);
        //RFID Reader
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidReaderCard", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "rfidreader", 1L, 0), 300, 120);
        //Card writer
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Parts_Transistor.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "rfidwriter", 1L, 0), 300, 120);
        //Alarm
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.noteblock, 1, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "alarm", 1L, 0), 300, 120);
        //Entity Detector
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "entitydetector", 1L, 0), 300, 120);
        //Door Controler
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "doorcontroller", 1L, 0), 300, 120);
        //Data Block
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.DataBlock", 1L, 0), 300, 120);
        //swtichable Hub
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.SwitchableHub", 1L, 0), 300, 120);
        //kvm Hub
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.BlockKVM", 1L, 0), 300, 120);
        //energy turret
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("openmodularturrets", "laserTurret", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "energyTurretBlock", 1L, 0), 300, 120);
        //keypad
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "keypadLock", 1L, 0), 300, 120);
        //biometric reader
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 4L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "biometricScanner", 1L, 0), 300, 120);
        //magnetic stipe card
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 2L), ItemList.Circuit_Parts_Transistor.get(1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Glue.getMolten(144L), GT_ModHandler.getModItem("opensecurity", "opensecurity.magCard", 2L, 0), 150, 64);
        //RFID Card
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Glue.getMolten(144L), GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidCard", 2L, 0), 150, 64);
        //RFID Reader Card
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidReaderCard", 1L, 0), 300, 120);
        //Secure Network Card
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.secureNetworkCard", 1L, 0), 300, 256);
        //Secure Door
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.iron_door, 1), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Circuit_Parts_Transistor.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoor", 1L, 0), 300, 120);
        //Secure Private Door
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.iron_door, 1), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Circuit_Parts_Transistor.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L), GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF, GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoorPrivate", 1L, 0), 300, 120);
        //Damage Upgrade
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), new ItemStack(Blocks.tnt, 1, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.damageUpgrade", 1L, 0), 300, 256);
        //Cooldown upgrade
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getIC2Item("reactorCoolantSimple", 1L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.cooldownUpgrade", 1L, 0), 300, 256);
        //Energy Upgrade
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.energyUpgrade", 1L, 0), 300, 256);
        //Movement Upgrade
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Electric_Piston_MV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.movementUpgrade", 1L, 0), 300, 256);
        //Iron Noteblock
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.noteblock), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 8L), CustomItemList.SteelBars.get(1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.ironNoteBlock", 1L, 0), 200, 120);
        //Speaker
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Paper, 1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.IronMagnetic, 1L), ItemList.Electric_Motor_LV.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.speaker", 1L, 0), 300, 120);
        //Tape Drive
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L), GT_ModHandler.getModItem("computronics", "computronics.speaker", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.IronMagnetic, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L), GT_ModHandler.getModItem("computronics", "computronics.audioCable", 1L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.tapeReader", 1L, 0), 300, 120);
        //Camera
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1L), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 3L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.camera", 1L, 0), 300, 120);
        //Chat Box
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L), ItemList.Sensor_LV.get(1L), ItemList.Emitter_LV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.chatBox", 1L, 0), 300, 120);
        //Ciper Box
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L), ItemList.Robot_Arm_MV.get(1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.cipher", 1L, 0), 300, 256);
        //Advanced Ciper Box
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.cipher", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.cipher_advanced", 1L, 0), 300, 480);
        //Radar
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_HV.get(1L), ItemList.Emitter_HV.get(1L), ItemList.Sensor_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Gold, 2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.radar", 1L, 0), 300, 120);
        //Colorful Lamp
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.redstone_lamp, 1,0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 4L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.colorfulLamp", 1L, 0), 300, 120);
        //Digital Locomotive Relay
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("Railcraft", "signal", 1L, 0), GT_ModHandler.getModItem("Railcraft", "part.rail", 2L, 5), ItemList.Emitter_LV.get(1L), ItemList.Sensor_LV.get(1L),  GT_ModHandler.getModItem("Railcraft", "tool.electric.meter", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.locomotiveRelay", 1L, 0), 300, 120);
        //Digital Signal Receiver Box
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("Railcraft", "signal", 1L, 8), GT_ModHandler.getModItem("Railcraft", "part.circuit", 1L, 2), ItemList.Sensor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 6L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.digitalReceiverBox", 1L, 0), 300, 120);
        //Digital Controler Box
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("Railcraft", "signal", 1L, 9), GT_ModHandler.getModItem("Railcraft", "part.circuit", 1L, 2), ItemList.Sensor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 6L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.digitalControllerBox", 1L, 0), 300, 120);
        //Digital Detector
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("Railcraft", "detector", 1L, 9),  GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 8L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Gold, 1L),  GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.detector", 1L, 0), 300, 120);
        //Digital Ticket Machine
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L), GT_ModHandler.getModItem("Railcraft", "routing.ticket.gold", 1L, 0), ItemList.Electric_Piston_LV.get(1L), ItemList.Electric_Motor_LV.get(1L),  ItemList.Cover_Screen.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.ticketMachine", 1L, 0), 300, 120);
        //Digital Speech Box
        //GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.speaker", 1L, 0), ItemList.Hull_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Gold, 2L),  GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("computronics", "computronics.speechBox", 1L, 0), 300, 120);
    }

        if (Loader.isModLoaded("OpenBlocks")){

        ItemStack[] trophies = {
                GT_ModHandler.getModItem("OpenBlocks", "trophy", 1L),
                GT_ModHandler.getModItem("OpenBlocks", "trophy", 1L),
                GT_ModHandler.getModItem("OpenBlocks", "trophy", 1L),
                GT_ModHandler.getModItem("OpenBlocks", "trophy", 1L),
        };

        NBTTagCompound[] tag = {
                new NBTTagCompound(),
                new NBTTagCompound(),
                new NBTTagCompound(),
                new NBTTagCompound(),
        };

        tag[0].setString("entity", "Bat");
        tag[1].setString("entity", "Cow");
        tag[2].setString("entity", "Chicken");
        tag[3].setString("entity", "Sheep");

        ItemStack flightpotion = GT_ModHandler.getModItem("AWWayofTime","alchemyFlask",1L);
        NBTTagCompound flighttag = new NBTTagCompound();
        NBTTagList flighsubtag = new NBTTagList();
        NBTTagCompound temp;

        temp = new NBTTagCompound();
        temp.setInteger("concentration", 0);
        temp.setInteger("durationFactor", 2);
        temp.setInteger("potionID", 104);
        temp.setInteger("tickDuration", 1200);
        flighsubtag.appendTag(temp);

        flighttag.setTag("CustomFlaskEffects", flighsubtag);
        flightpotion.setTagCompound(flighttag);

        for (int i =0; i<4;++i)
            trophies[i].setTagCompound(tag[i]);

        GT_Values.RA.addAssemblerRecipe(trophies[0], new ItemStack(Items.golden_carrot), new ItemStack(Items.potionitem, 1 ,8262), 120, 120);
        GT_Values.RA.addAssemblerRecipe(trophies[1], new ItemStack(Items.iron_sword), new ItemStack(Items.leather,64), 120, 120);
        GT_Values.RA.addAssemblerRecipe(trophies[2], new ItemStack(Items.feather), flightpotion, 120, 120);
        GT_Values.RA.addAssemblerRecipe(trophies[3], new ItemStack(Items.shears), new ItemStack(Blocks.wool,64), 120, 120);
    }

    //Rocket Circuits
    final int[] EUperRecipe = new int[]{
            480,                //t2 = HV
            1920,                //t3 = EV
            7680,                //t4 = IV
            30720,                //t5 = LuV (Gated behind Assline)
            30720,                //t6 = LuV
            130870,                //t7 = ZPM
            520400,                //t8 = UV
    };

    ItemStack[] RocketMaterial = new ItemStack[8];
    RocketMaterial[0] = GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L);
    RocketMaterial[1] = GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3);
    RocketMaterial[2] = GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L);
    RocketMaterial[3] = CustomItemList.HeavyDutyPlateTier4.get(1L);
    RocketMaterial[4] = CustomItemList.HeavyDutyPlateTier5.get(1L);
    RocketMaterial[5] = CustomItemList.HeavyDutyPlateTier6.get(1L);
    RocketMaterial[6] = CustomItemList.HeavyDutyPlateTier7.get(1L);
    RocketMaterial[7] = CustomItemList.HeavyDutyPlateTier8.get(1L);

    ItemStack[] RocketChip = new ItemStack[8];
    RocketChip[0] = CustomItemList.SchematicsTier1.get(1L);
    RocketChip[1] = CustomItemList.SchematicsTier2.get(1L);
    RocketChip[2] = CustomItemList.SchematicsTier3.get(1L);
    RocketChip[3] = CustomItemList.SchematicsTier4.get(1L);
    RocketChip[4] = CustomItemList.SchematicsTier5.get(1L);
    RocketChip[5] = CustomItemList.SchematicsTier6.get(1L);
    RocketChip[6] = CustomItemList.SchematicsTier7.get(1L);
    RocketChip[7] = CustomItemList.SchematicsTier8.get(1L);

    ItemStack[] ExtraChips = new ItemStack[3];
    ExtraChips[0] = CustomItemList.SchematicsMoonBuggy.get(1L);
    ExtraChips[1] = CustomItemList.SchematicsCargoRocket.get(1L);
    ExtraChips[2] = CustomItemList.SchematicsAstroMiner.get(1L);

        for (Materials tMat : Materials.values()) {//TODO dream things using soldering go in here!
        if (tMat.mStandardMoltenFluid != null && tMat.contains(SubTag.SOLDERING_MATERIAL) && !(GregTech_API.mUseOnlyGoodSolderingMaterials && !tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD))) {
            int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1 : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

            //Rocket Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {ItemList.Circuit_Quantumprocessor.get(1L), RocketMaterial[0],GT_Utility.getIntegratedCircuit(1)},tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {ItemList.Circuit_Data.get(1L), RocketMaterial[0],GT_Utility.getIntegratedCircuit(1)},tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {ItemList.Circuit_Nanocomputer.get(1L), RocketMaterial[0],GT_Utility.getIntegratedCircuit(1)},tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);

            for (byte i=2;i<9;++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) i ));
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[(i-1)],ItemList.Circuit_Elite.get(1L),DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i-1)], 9000, EUperRecipe[(i-2)], true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[(i-1)],ItemList.Circuit_Elitenanocomputer.get(1L),DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i-1)], 9000, EUperRecipe[(i-2)], true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[(i-1)],ItemList.Circuit_Quantumcomputer.get(1L),DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i-1)], 9000, EUperRecipe[(i-2)], true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[(i-1)],ItemList.Circuit_Crystalprocessor.get(1L),DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i-1)], 9000, EUperRecipe[(i-2)], true);
            }

            for (byte i=0;i<3;++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) (i+100)));
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[i],ItemList.Circuit_Quantumprocessor.get(1L),DataStickWScheme.splitStack(0)},tMat.getMolten(576L * tMultiplier / 2L),ExtraChips[i], 9000, EUperRecipe[i], true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[i],ItemList.Circuit_Data.get(1L),DataStickWScheme.splitStack(0)},tMat.getMolten(576L * tMultiplier / 2L),ExtraChips[i], 9000, EUperRecipe[i], true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[] {RocketMaterial[i],ItemList.Circuit_Nanocomputer.get(1L),DataStickWScheme.splitStack(0)},tMat.getMolten(576L * tMultiplier / 2L),ExtraChips[i], 9000, EUperRecipe[i], true);
            }
            //Primitive Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Chip_Simple_SoC.get(1L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2),  GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.NandChip.get(4L), 300, 120);

            //Basic Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2), ItemList.Circuit_Parts_Vacuum_Tube.get(2L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0), 200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2), ItemList.Circuit_Parts_Vacuum_Tube.get(2L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0), 200, 16);

            //Good Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0), ItemList.Circuit_Parts_Diode.get(2L),  GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Good.get(1L), 300, 30);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0), ItemList.Circuit_Parts_DiodeSMD.get(2L),  GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Good.get(1L), 300, 30);

            //Integraded Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Diode.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Diode.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Diode.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Diode.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);

            //Advanced circuit
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L), ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getIC2Item("advancedCircuit", 1L), 800, 30, false);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L), ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getIC2Item("advancedCircuit", 1L), 800, 30, false);

            //Integrated Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),ItemList.Circuit_Chip_CPU.get(1L),ItemList.Circuit_Parts_Resistor.get(2L),ItemList.Circuit_Parts_Capacitor.get(2L),ItemList.Circuit_Parts_Transistor.get(2L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),ItemList.Circuit_Chip_CPU.get(1L),ItemList.Circuit_Parts_ResistorSMD.get(2L),ItemList.Circuit_Parts_Capacitor.get(2L),ItemList.Circuit_Parts_Transistor.get(2L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),ItemList.Circuit_Chip_CPU.get(1L),ItemList.Circuit_Parts_Resistor.get(2L),ItemList.Circuit_Parts_CapacitorSMD.get(2L),ItemList.Circuit_Parts_Transistor.get(2L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),ItemList.Circuit_Chip_CPU.get(1L),ItemList.Circuit_Parts_Resistor.get(2L),ItemList.Circuit_Parts_Capacitor.get(2L),ItemList.Circuit_Parts_TransistorSMD.get(2L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),ItemList.Circuit_Chip_CPU.get(1L),ItemList.Circuit_Parts_ResistorSMD.get(2L),ItemList.Circuit_Parts_CapacitorSMD.get(2L),ItemList.Circuit_Parts_Transistor.get(2L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),ItemList.Circuit_Chip_CPU.get(1L),ItemList.Circuit_Parts_ResistorSMD.get(2L),ItemList.Circuit_Parts_Capacitor.get(2L),ItemList.Circuit_Parts_TransistorSMD.get(2L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),ItemList.Circuit_Chip_CPU.get(1L),ItemList.Circuit_Parts_Resistor.get(2L),ItemList.Circuit_Parts_CapacitorSMD.get(2L),ItemList.Circuit_Parts_TransistorSMD.get(2L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);

            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L), ItemList.Circuit_Parts_Capacitor.get(8L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Computer.get(1L), 400, 120, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(2L), ItemList.Circuit_Chip_NAND.get(32L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4)}, tMat.getMolten(144L * tMultiplier), ItemList.Tool_DataStick.get(1L), 400, 90, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_Diode.get(4L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Data.get(1L), 400, 120, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Data.get(2L), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_Capacitor.get(24), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Elite.get(1L), 1600, 480, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),ItemList.Circuit_Chip_CPU.get(1L),ItemList.Circuit_Parts_ResistorSMD.get(2L),ItemList.Circuit_Parts_CapacitorSMD.get(2L),ItemList.Circuit_Parts_TransistorSMD.get(2L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Computer.get(1L), 400, 96, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(4L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Data.get(1L), 400, 120, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Data.get(2L), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorSMD.get(16L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Elite.get(1L), 1600, 480, true);

            //Nanotech Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(8L), ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Parts_TransistorSMD.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Nanoprocessor.get(1L), 200, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(8L), ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Nanocomputer.get(1L), 400, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Chip_Ram.get(4L), ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32)},tMat.getMolten(144L * tMultiplier), ItemList.Tool_DataOrb.get(1L), 400, 1200, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Elitenanocomputer.get(1L), 400, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_Coil.get(16L), ItemList.Circuit_Parts_CapacitorSMD.get(32L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Master.get(1L), 1600, 1920, true);

            //Quantum Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorSMD.get(12L), ItemList.Circuit_Parts_TransistorSMD.get(12L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Quantumprocessor.get(1L), 200, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorSMD.get(16L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Quantumcomputer.get(1L), 400, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Masterquantumcomputer.get(1L), 400, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_Coil.get(24), ItemList.Circuit_Parts_CapacitorSMD.get(48L), ItemList.Circuit_Chip_Ram.get(24), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Quantummainframe.get(1L), 1600, 7680, true);

            //Crystallized Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(24), ItemList.Circuit_Parts_TransistorSMD.get(24), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Crystalprocessor.get(1L), 200, 9600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Crystalprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(24), ItemList.Circuit_Parts_CapacitorSMD.get(32L), ItemList.Circuit_Chip_Ram.get(24), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Crystalcomputer.get(1L), 400, 9600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Crystalcomputer.get(2L), ItemList.Circuit_Chip_Ram.get(4L), ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Ultimatecrystalcomputer.get(1L), 400, 9600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Ultimatecrystalcomputer.get(2L), ItemList.Circuit_Parts_Coil.get(32L), ItemList.Circuit_Parts_CapacitorSMD.get(64L), ItemList.Circuit_Chip_Ram.get(32L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Crystalmainframe.get(1L), 1600, 30720, true);                //Wetware Circuits

            //Wetware Boards
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_NeuroCPU.get(1L),ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorSMD.get(32L),ItemList.Circuit_Parts_TransistorSMD.get(32L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Neuroprocessor.get(1L), 400, 38400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(1L), ItemList.Circuit_Neuroprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(32L), ItemList.Circuit_Parts_CapacitorSMD.get(48L), ItemList.Circuit_Chip_Ram.get(24L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Wetwarecomputer.get(1L), 600, 38400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(2L), ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(32L), ItemList.Circuit_Chip_NOR.get(16L), ItemList.Circuit_Chip_Ram.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Wetwaresupercomputer.get(1L), 600, 38400, true);

            //Bio Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_BioCPU.get(1L),ItemList.Circuit_Chip_CrystalSoC2.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(48L),ItemList.Circuit_Parts_TransistorSMD.get(48L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Bioprocessor.get(1L), 600, 153600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(48L), ItemList.Circuit_Parts_CapacitorSMD.get(64L), ItemList.Circuit_Chip_Ram.get(32L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Biowarecomputer.get(1L), 800, 153600, true);

            //SoC
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_SoC.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 50, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_SoC.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 50, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_SoC2.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Nanoprocessor.get(1L), 50, 9600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_SoC2.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NiobiumTitanium, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Quantumprocessor.get(1L), 50, 38400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Chip_CrystalSoC.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Crystalprocessor.get(1L), 50, 153600, true);

            //Lapoorbs
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_PIC.get(4L), ItemList.Circuit_Parts_Crystal_Chip_Master.get(24L), ItemList.Circuit_Chip_NanoCPU.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Energy_LapotronicOrb.get(1L), 512, 1024, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_HPIC.get(4L), ItemList.Energy_LapotronicOrb.get(8L), ItemList.Circuit_Chip_QuantumCPU.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Europium, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Energy_LapotronicOrb2.get(1L), 1024, 4096, true);

            //Wetware Board
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass.get(1L), ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Electric_Pump_HV.get(1L),  ItemList.Sensor_HV.get(1L),  GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 4)},  Materials.GrowthMediumSterilized.getFluid(250L), ItemList.Circuit_Board_Wetware.get(1L), 600, 1920, true);

            //Bio Board
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass.get(1L), ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Electric_Pump_EV.get(1L),  ItemList.Sensor_EV.get(1L), ItemList.Circuit_Data.get(2L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 8)},  Materials.BioMediumSterilized.getFluid(500L), ItemList.Circuit_Board_Bio.get(1L), 1200, 7680, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass.get(1L), ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Electric_Pump_EV.get(1L),  ItemList.Sensor_EV.get(1L), ItemList.Circuit_Nanocomputer.get(2L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 8)},  Materials.BioMediumSterilized.getFluid(500L), ItemList.Circuit_Board_Bio.get(1L), 1200, 7680, true);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass.get(1L), ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Electric_Pump_EV.get(1L),  ItemList.Sensor_EV.get(1L),ItemList.Circuit_Quantumprocessor.get(2L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 8)},  Materials.BioMediumSterilized.getFluid(500L), ItemList.Circuit_Board_Bio.get(1L), 1200, 7680, true);

            //Railcraft Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), ItemList.Cover_Controller.get(1L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("Railcraft", "part.circuit", 1L, 0), 1200, 30);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), ItemList.Sensor_LV.get(1L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("Railcraft", "part.circuit", 1L, 1), 1200, 30);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), GT_ModHandler.getModItem("Railcraft", "part.signal.lamp", 1L, 0)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("Railcraft", "part.circuit", 1L, 2), 1200, 30);

            //PCBs Steve Carts
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8),  GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 9), 200, 30);
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 2L, 9), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),  GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 16), 400, 30);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8),  GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 9), 200, 30);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 2L, 9), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),  GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 16), 200, 120);

            //Energy Flow Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Chip_UHPIC.get(4L), ItemList.Circuit_Chip_QuantumCPU.get(2L), ItemList.Circuit_Chip_NanoCPU.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 64)},  tMat.getMolten(576L * tMultiplier / 2L), CustomItemList.HighEnergyFlowCircuit.get(1L), 2400, 7680, true);

            // --- Advanced Solar Panel
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L),ItemList.Cover_SolarPanel_LV.get(1L), ItemList.Robot_Arm_LV.get(1L), ItemList.Battery_RE_LV_Lithium.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 0), 800, 120);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MV.get(1L),ItemList.Cover_SolarPanel_MV.get(1L), ItemList.Robot_Arm_MV.get(1L), ItemList.Battery_RE_MV_Lithium.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(576L * tMultiplier / 2L), GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 1), 1000, 480);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_HV.get(1L),ItemList.Cover_SolarPanel_HV.get(1L), ItemList.Robot_Arm_HV.get(1L), ItemList.Battery_RE_HV_Lithium.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(864L * tMultiplier / 2L), GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 2), 1200, 1920);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_EV.get(1L),ItemList.Cover_SolarPanel_EV.get(1L), ItemList.Robot_Arm_EV.get(1L), CustomItemList.BatteryHull_EV_Full.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(1152L * tMultiplier / 2L), GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 3), 1400, 7860);
            // --- Super Solar Panel
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1L),ItemList.Cover_SolarPanel_IV.get(1L), ItemList.Robot_Arm_IV.get(1L), CustomItemList.BatteryHull_IV_Full.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(1440 * tMultiplier / 2L), GT_ModHandler.getModItem("supersolarpanel", "SpectralSolarPanel", 1L, 0), 1600, 30720);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1L),ItemList.Cover_SolarPanel_LuV.get(1L), ItemList.Robot_Arm_LuV.get(1L), CustomItemList.BatteryHull_LuV_Full.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(1728 * tMultiplier / 2L), GT_ModHandler.getModItem("supersolarpanel", "SingularSolarPanel", 1L, 0), 1800, 122880);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1L),ItemList.Cover_SolarPanel_ZPM.get(1L), ItemList.Robot_Arm_ZPM.get(1L), CustomItemList.BatteryHull_ZPM_Full.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(2016 * tMultiplier / 2L), GT_ModHandler.getModItem("supersolarpanel", "AdminSolarPanel", 1L, 0), 2000, 500000);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1L),ItemList.Cover_SolarPanel_UV.get(1L), ItemList.Robot_Arm_UV.get(1L), CustomItemList.BatteryHull_UV_Full.get(1L),GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(2304 * tMultiplier / 2L), GT_ModHandler.getModItem("supersolarpanel", "PhotonicSolarPanel", 1L, 0), 2200, 2000000);

            if(Loader.isModLoaded("OpenComputers")) {
                //display t1
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Cover_Screen.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), 240, 64);
                //display t2
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L), ItemList.Circuit_Parts_Transistor.get(4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), 240, 120);
                //display t3
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L), ItemList.Circuit_Parts_Transistor.get(8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), 240, 256);
                //ALU
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_ILC.get(16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27), 400, 64);
                //CU
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), 200, 30);
                //anylyser
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Tool_Scanner.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_Transistor.get(2L), ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), 300, 120);
                //CPU 1
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), CustomItemList.AluminiumItemCasing.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29), 200, 120);
                //CPU 2
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 12L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), CustomItemList.AluminiumItemCasing.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), 200, 120);
                //CPU 3
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), CustomItemList.AluminiumItemCasing.get(1L), GT_Utility.getIntegratedCircuit(3)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), 200, 120);
                //Graphics Card 1
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 8), 400, 120);
                //Graphics Card 2
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 9), 400, 256);
                //Graphics Card 3
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 10), 400, 480);
                //Internet Crad
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lightbutton", 1L, 14), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 44), 400, 480);
                //APU T1
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), CustomItemList.AluminiumItemCasing.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 101), 200, 256);
                //APU T2
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 64L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1), CustomItemList.AluminiumItemCasing.get(1L), GT_Utility.getIntegratedCircuit(3)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 102), 200, 480);
                //EEPROM
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(6L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0), 200, 120);
                make_lua_bios();
                //RAM 1
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(16L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), 250, 64);
                //RAM 1.5
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(32L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 24), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 50), 250, 120);
                //RAM 2
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), 250, 256);
                //RAM 2.5
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(16L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3), 250, 480);
                //RAM 3
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(32L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), 250, 1024);
                //RAM 3.5
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(64L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 39), 250, 1920);
                //Circuit 1
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 300, 120);
                //Circuit 2
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), ItemList.Circuit_Parts_Transistor.get(8L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 300, 256);
                //Circuit 3
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), ItemList.Circuit_Parts_Transistor.get(16L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), 300, 480);
                //network card
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), 200, 120);
                //wlan card1
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Emitter_LV.get(1L), ItemList.Sensor_LV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 113), 200, 120);
                //wlan card2
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), ItemList.Emitter_HV.get(1L), ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), 200, 256);
                //World sensor card
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 89), 200, 120);
                //redstone card 1
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Chip_ILC.get(4L), new ItemStack(Blocks.redstone_torch, 2), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), 200, 120);
                //redstone card 2
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Chip_ILC.get(16L), new ItemStack(Blocks.redstone_torch, 4), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 12), 200, 256);
                //data card 1
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 4, 27), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104), 300, 120);
                //data card 2
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1, 29), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 105), 300, 156);
                //data card 3
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1, 42), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 32L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 106), 300, 480);
                //angel upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), CustomItemList.AluminiumItemCasing.get(2L), GT_ModHandler.getModItem("ExtraUtilities", "angelBlock", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 49), 250, 256);
                //hover upgrade Tier 1
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), CustomItemList.AluminiumItemCasing.get(2L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 4L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Electric_Motor_MV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 99), 250, 256);
                //hover upgrade Tier 2
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), CustomItemList.AluminiumItemCasing.get(4L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 8L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), ItemList.Electric_Motor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100), 250, 480);
                //battery upgrade 1
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), CustomItemList.AluminiumItemCasing.get(2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), 250, 120);
                //battery upgrade 2
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), CustomItemList.TitaniumItemCasing.get(2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 2L, 0), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64), 250, 256);
                //battery upgrade 3
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), CustomItemList.TungstenSteelItemCasing.get(2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0), ItemList.Circuit_Parts_Transistor.get(8L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), 250, 480);
                //chunkloader upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), CustomItemList.AluminiumItemCasing.get(2L), GT_ModHandler.getModItem("Railcraft", "machine.alpha", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 62), 250, 256);
                //inventory upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), CustomItemList.AluminiumItemCasing.get(2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53), 300, 120);
                //inventory controller upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53), CustomItemList.AluminiumItemCasing.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 61), 300, 256);
                //tank upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), CustomItemList.AluminiumItemCasing.get(2L), GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76), 300, 120);
                //tank controller upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76), CustomItemList.AluminiumItemCasing.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77), 300, 256);
                //card container 1
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), CustomItemList.AluminiumItemCasing.get(2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 57), 250, 120);
                //card container 2
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), CustomItemList.TitaniumItemCasing.get(2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 58), 250, 256);
                //card container 3
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), CustomItemList.TungstenSteelItemCasing.get(2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 59), 250, 480);
                //upgrade container 1
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), CustomItemList.AluminiumItemCasing.get(2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.StainlessSteel, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 54), 250, 120);
                //upgrade container 2
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), CustomItemList.TitaniumItemCasing.get(2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 55), 250, 256);
                //upgrade container 3
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), CustomItemList.TungstenSteelItemCasing.get(2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 56), 250, 480);
                //component bus t1
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70), 250, 120);
                //component bus t2
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71), 250, 256);
                //component bus t3
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 16), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), 250, 480);
                //database upgrade 1
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 78), 250, 120);
                //database upgrade 2
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 79), 250, 256);
                //database upgrade 3
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 80), 250, 480);
                //experience upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 52), 250, 120);
                //crafting component
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Cover_Crafting.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 14), 250, 120);
                //generator upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("EnderIO", "blockStirlingGenerator", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), CustomItemList.AluminiumItemCasing.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 15), 250, 120);
                //leash upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), new ItemStack(Items.lead, 4), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 85), 250, 120);
                //mfu upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "adapter", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 51), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 96), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 112), 250, 480);
                //navigation upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), new ItemStack(Items.compass, 1), new ItemStack(Items.filled_map, 1), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 36), 250, 256);
                //piston upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Electric_Piston_MV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), CustomItemList.AluminiumItemCasing.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 75), 250, 120);
                //sing IO upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), CustomItemList.AluminiumItemCasing.get(2L), ItemList.Dye_SquidInk.get(1L), new ItemStack(Items.sign, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 35), 250, 120);
                //solar upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), ItemList.Cover_SolarPanel_LV.get(1L), CustomItemList.TitaniumItemCasing.get(2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 34), 250, 256);
                //tractor beam upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), ItemList.Electric_Piston_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 16L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 67), 250, 480);
                //trading upgrade
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 3L, 25), CustomItemList.AluminiumItemCasing.get(3L), ItemList.Electric_Piston_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 110), 250, 256);
                //hover Boots
                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 83), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100), CustomItemList.AluminiumItemCasing.get(4L), ItemList.Electric_Piston_MV.get(2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "hoverBoots", 1L, GT_Values.W), 350, 256);
            }
            if (Loader.isModLoaded("harvestcraft")) {
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "catfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "jellyfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "mudfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "greenheartfishItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "catfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "anchovyrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "bassrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "carprawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "octopusrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "charrrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "clamrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "crabrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "eelrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "frograwItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "grouperrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "herringrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "perchrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "scalloprawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "shrimprawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "snailrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "snapperrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "tilapiarawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "troutrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "tunarawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "turtlerawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "walleyerawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
            }
        }
    }

    run3();
}

    private void run3() {
        GT_Values.RA.addAssemblylineRecipe(com.dreammaster.item.ItemList.PicoWafer.getIS(), 72000, new ItemStack[]{
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                com.dreammaster.item.ItemList.PicoWafer.getIS(4),
                ItemList.Circuit_Parts_TransistorSMD.get(64L),
                ItemList.Circuit_Parts_ResistorSMD.get(64L),
                ItemList.Circuit_Parts_CapacitorSMD.get(64L),
                ItemList.Circuit_Parts_DiodeSMD.get(64L),
                ItemList.Circuit_Chip_UHPIC.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Osmium, 32),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 16),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64)
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(3760L),
                Materials.UUMatter.getFluid(8000L),
                Materials.Osmium.getMolten(1152L)
        }, com.dreammaster.item.ItemList.PikoCircuit.getIS(), 1200, (int)(GT_Values.V[9]-(GT_Values.V[9]/10)));

        GT_Values.RA.addAssemblylineRecipe(com.dreammaster.item.ItemList.PikoCircuit.getIS(), 144000, new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.frameGt,Materials.Neutronium, 16),
                com.dreammaster.item.ItemList.PikoCircuit.getIS(8),
                ItemList.Circuit_Parts_CapacitorSMD.get(64L),
                ItemList.Circuit_Parts_DiodeSMD.get(64L),
                ItemList.Circuit_Parts_TransistorSMD.get(64L),
                ItemList.Circuit_Parts_ResistorSMD.get(64L),
                ItemList.Circuit_Chip_UHPIC.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 64),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Indium, 64),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Bedrockium, 8),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64)
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(3760L),
                Materials.UUMatter.getFluid(24000L),
                Materials.Osmium.getMolten(2304L)
        }, com.dreammaster.item.ItemList.QuantumCircuit.getIS(), 2400, (int)(GT_Values.V[9]-(GT_Values.V[9]/10)));

        //Main Frame Circuits and Neuro CPU
        GT_Values.RA.addAssemblylineRecipe(ItemList.Circuit_Crystalmainframe.get(1L), 72000, new ItemStack[]{
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                ItemList.Circuit_Chip_Stemcell.get(16L),
                ItemList.Circuit_Parts_Glass_Tube.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Plastic, 16),
                ItemList.IC2_Item_Casing_Gold.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 32),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.StainlessSteel, 32),
        }, new FluidStack[]{
                GregTech_API.mIC2Classic ? Materials.Water.getFluid(250L) : Materials.GrowthMediumSterilized.getFluid(250L),
                Materials.UUMatter.getFluid(250L),
                GregTech_API.mIC2Classic ? Materials.Lava.getFluid(1000L) : new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000)
        }, ItemList.Circuit_Chip_NeuroCPU.get(1L), 1200, 80000);

        GT_Values.RA.addAssemblylineRecipe(ItemList.Circuit_Chip_NeuroCPU.get(1L), 144000, new ItemStack[]{
                ItemList.Circuit_Board_Bio_Ultra.get(1L),
                ItemList.Circuit_Chip_Biocell.get(32L),
                ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 16),
                CustomItemList.TungstenItemCasing.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 64),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 32),
        }, new FluidStack[]{
                GregTech_API.mIC2Classic ? Materials.Water.getFluid(500L) : Materials.BioMediumSterilized.getFluid(500L),
                Materials.UUMatter.getFluid(500L),
                GregTech_API.mIC2Classic ? Materials.Lava.getFluid(2000L) : new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000)
        }, ItemList.Circuit_Chip_BioCPU.get(1L), 2400, 160000);

        GT_Values.RA.addAssemblylineRecipe(ItemList.Circuit_Wetwaresupercomputer.get(1L), 288000, new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 2),
                ItemList.Circuit_Wetwaresupercomputer.get(2L),
                ItemList.Circuit_Parts_Coil.get(64L),
                ItemList.Circuit_Parts_CapacitorSMD.get(64L),
                ItemList.Circuit_Parts_ResistorSMD.get(64L),
                ItemList.Circuit_Parts_TransistorSMD.get(64L),
                ItemList.Circuit_Parts_DiodeSMD.get(64L),
                ItemList.Circuit_Chip_Ram.get(48L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUHV, 64),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 64)
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(2880L),
                GregTech_API.mIC2Classic ? Materials.Water.getFluid(10000L) : new FluidStack(FluidRegistry.getFluid("ic2coolant"), 10000)
        }, ItemList.Circuit_Wetwaremainframe.get(1L), 2000, 300000);

        GT_Values.RA.addAssemblylineRecipe(ItemList.Energy_LapotronicOrb.get(1L), 288000, new ItemStack[]{
                ItemList.Circuit_Board_Multifiberglass.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Europium, 32L),
                ItemList.Circuit_Neuroprocessor.get(4L),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                ItemList.Circuit_Chip_HPIC.get(64L),
                ItemList.Circuit_Parts_DiodeSMD.get(32L),
                ItemList.Circuit_Parts_CapacitorSMD.get(32L),
                ItemList.Circuit_Parts_ResistorSMD.get(32L),
                ItemList.Circuit_Parts_TransistorSMD.get(32L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 64),
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(720L)
        }, ItemList.Energy_LapotronicOrb2.get(1L), 1000, 80000);



        //Quantum Chip
        GT_Values.RA.addAssemblylineRecipe(ItemList.Circuit_Wetwaremainframe.get(1L), 576000, new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 4),
                ItemList.Circuit_Wetwaremainframe.get(2L),
                ItemList.Circuit_Parts_Coil.get(64L),
                ItemList.Circuit_Parts_CapacitorSMD.get(64L),
                ItemList.Circuit_Parts_ResistorSMD.get(64L),
                ItemList.Circuit_Parts_TransistorSMD.get(64L),
                ItemList.Circuit_Parts_DiodeSMD.get(64L),
                ItemList.Circuit_Chip_Ram.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Draconium, 64),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 64),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 64)
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(3760L),
                Materials.Naquadria.getMolten(4032L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20000)
        }, CustomItemList.NanoCircuit.get(1L), 4000, 500000);

        //Quantum Armor and Gravichest
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumHelmet", 1, GT_Values.W));
        GT_Values.RA.addAssemblylineRecipe(CustomItemList.QuantumPartHelmet.get(1L), 144000, new Object[]{
                CustomItemList.QuantumPartHelmet.get(1L),
                CustomItemList.QuantumCrystal.get(1L),
                new Object[]{OrePrefixes.circuit.get(Materials.Master), 2},
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                ItemList.Energy_LapotronicOrb.get(1L),
                ItemList.Sensor_IV.get(1L),
                ItemList.Field_Generator_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4)
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(2304L),
                Materials.Titanium.getMolten(1440L),
                Materials.Glowstone.getMolten(288L)
        }, GT_ModHandler.getIC2Item("quantumHelmet", 1, 26), 1500, 4096);

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBodyarmor", 1, GT_Values.W));
        GT_Values.RA.addAssemblylineRecipe(CustomItemList.QuantumPartChestplate.get(1L), 144000, new Object[]{
                CustomItemList.QuantumPartChestplate.get(1L),
                CustomItemList.QuantumCrystal.get(1L),
                new Object[]{OrePrefixes.circuit.get(Materials.Master), 2},
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                ItemList.Energy_LapotronicOrb.get(1L),
                ItemList.Field_Generator_EV.get(3L),
                ItemList.Electric_Motor_IV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4)
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(2304L),
                Materials.Titanium.getMolten(1440L),
                Materials.Glowstone.getMolten(288L)
        }, GT_ModHandler.getIC2Item("quantumBodyarmor", 1, 26), 1500, 4096);

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumLeggings", 1, GT_Values.W));
        GT_Values.RA.addAssemblylineRecipe(CustomItemList.QuantumPartLeggings.get(1L), 144000, new Object []{
                CustomItemList.QuantumPartLeggings.get(1L),
                CustomItemList.QuantumCrystal.get(1L),
                new Object[]{OrePrefixes.circuit.get(Materials.Master), 2},
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                ItemList.Energy_LapotronicOrb.get(1L),
                ItemList.Field_Generator_EV.get(2L),
                ItemList.Electric_Motor_IV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4)
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(2304L),
                Materials.Titanium.getMolten(1440L),
                Materials.Glowstone.getMolten(288L)
        }, GT_ModHandler.getIC2Item("quantumLeggings", 1, 26), 1500, 4096);

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBoots", 1, GT_Values.W));
        GT_Values.RA.addAssemblylineRecipe(CustomItemList.QuantumPartBoots.get(1L), 144000, new Object[]{
                CustomItemList.QuantumPartBoots.get(1L),
                CustomItemList.QuantumCrystal.get(1L),
                new Object[]{OrePrefixes.circuit.get(Materials.Master), 2},
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                ItemList.Energy_LapotronicOrb.get(1L),
                ItemList.Field_Generator_EV.get(1L),
                ItemList.Electric_Piston_IV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4)
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(2304L),
                Materials.Titanium.getMolten(1440L),
                Materials.Glowstone.getMolten(288L)
        }, GT_ModHandler.getIC2Item("quantumBoots", 1, 26), 1500, 4096);

        if (Loader.isModLoaded("GraviSuite")) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "graviChestPlate", 1, GT_Values.W));
            GT_Values.RA.addAssemblylineRecipe(GT_ModHandler.getIC2Item("quantumBodyarmor", 1L,  GT_Values.W), 144000, new ItemStack[]{
                    GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, 1),
                    ItemList.Transformer_ZPM_LuV.get(1L),
                    GT_ModHandler.getModItem("GraviSuite", "ultimateLappack", 1, 1),
                    GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 6, 1),
                    GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 2, 2),
                    GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 2, 3),
                    ItemList.Circuit_Ultimatecrystalcomputer.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Duranium, 2),
                    ItemList.Energy_LapotronicOrb2.get(1L),
                    ItemList.Field_Generator_IV.get(2L),
                    ItemList.Electric_Motor_ZPM.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Duranium, 4)
            }, new FluidStack[]{
                    Materials.SolderingAlloy.getMolten(2304L),
                    Materials.Tritanium.getMolten(1440L)
            }, GT_ModHandler.getModItem("GraviSuite", "graviChestPlate", 1, 26), 1500, 16388);
        }

        if (Loader.isModLoaded("eternalsingularity")&&Loader.isModLoaded("SGCraft")) {
            GT_Values.RA.addAssemblylineRecipe(GT_OreDictUnificator.get(OrePrefixes.foil,Materials.Infinity,1L), 72000,
                    new ItemStack[] {
                            GT_ModHandler.getModItem("eternalsingularity","eternal_singularity",1L),
                            ItemList.Sensor_UV.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.block,Materials.Infinity,16L),
                            GT_OreDictUnificator.get(OrePrefixes.block,Materials.CosmicNeutronium,16L),
                            GT_OreDictUnificator.get(OrePrefixes.block,Materials.NaquadahAlloy,64L),
                            GT_OreDictUnificator.get(OrePrefixes.block,Materials.NaquadahAlloy,64L),
                            GT_OreDictUnificator.get(OrePrefixes.block,Materials.NaquadahAlloy,64L),
                            com.dreammaster.item.ItemList.NanoCircuit.getIS().splitStack(16)
                    },
                    new FluidStack[] {
                            Materials.Neutronium.getMolten(36864L),
                            Materials.Tritanium.getMolten(36864L),
                            Materials.Tetranaquadahdiindiumhexaplatiumosminid.getMolten(36864L),
                            Materials.Silver.getPlasma(36864L)
                    },
                    com.dreammaster.item.ItemList.StargateShieldingFoil.getIS(), 72000, 2097152);

            GT_Values.RA.addAssemblylineRecipe(com.dreammaster.item.ItemList.StargateShieldingFoil.getIS(), 72000,
                    new ItemStack[] {
                            ItemList.Electric_Piston_UV.get(16L),
                            ItemList.Electric_Motor_UV.get(64L),
                            GT_OreDictUnificator.get(OrePrefixes.block,Materials.Infinity,16L),
                            GT_OreDictUnificator.get(OrePrefixes.block,Materials.NaquadahAlloy,64L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense,Materials.Ardite,8L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense,Materials.Ardite,8L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense,Materials.Ardite,8L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense,Materials.Ardite,8L),
                            GT_OreDictUnificator.get(OrePrefixes.gemExquisite,Materials.Ruby,64L),
                            GT_OreDictUnificator.get(OrePrefixes.gemExquisite,Materials.Jasper,64L),
                            com.dreammaster.item.ItemList.NanoCircuit.getIS().splitStack(32)
                    },
                    new FluidStack[] {
                            Materials.Neutronium.getMolten(9216L),
                            Materials.Tritanium.getMolten(9216L),
                            Materials.Tetranaquadahdiindiumhexaplatiumosminid.getMolten(9216L),
                            Materials.Silver.getPlasma(9216L)
                    },
                    com.dreammaster.item.ItemList.StargateChevron.getIS(), 72000, 2097152);

            GT_Values.RA.addAssemblylineRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt,Materials.Neutronium,1L), 72000,
                    new ItemStack[] {
                            GT_OreDictUnificator.get(OrePrefixes.stickLong,Materials.Infinity,64L),
                            GT_OreDictUnificator.get(OrePrefixes.stickLong,Materials.NaquadahAlloy,64L),
                            GT_OreDictUnificator.get(OrePrefixes.stickLong,Materials.CosmicNeutronium,64L),
                            GT_OreDictUnificator.get(OrePrefixes.stickLong,Materials.Neutronium,64L),
                            GT_OreDictUnificator.get(OrePrefixes.stickLong,Materials.Osmiridium,64L)
                    },
                    new FluidStack[] {
                            Materials.Neutronium.getMolten(73728L),
                            Materials.Tritanium.getMolten(73728L),
                            Materials.Concrete.getMolten(73728L)
                    },
                    com.dreammaster.item.ItemList.StargateFramePart.getIS(), 72000, 2097152);
            //Bio Chips
            GT_Values.RA.addAssemblylineRecipe(ItemList.Circuit_Biowarecomputer.get(1L), 576000, new ItemStack[]{
                            ItemList.Circuit_Board_Bio_Ultra.get(2L),
                            ItemList.Circuit_Biowarecomputer.get(2L),
                            ItemList.Circuit_Parts_DiodeSMD.get(48L),
                            ItemList.Circuit_Parts_ResistorSMD.get(16L),
                            ItemList.Circuit_Parts_TransistorSMD.get(16L),
                            ItemList.Circuit_Parts_DiodeSMD.get(16L),
                            ItemList.Circuit_Chip_NOR.get(32L),
                            ItemList.Circuit_Chip_Ram.get(64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 16L),
                    }, new FluidStack[]{
                            Materials.SolderingAlloy.getMolten(1440L),
                            Materials.BioMediumSterilized.getFluid(1440L),
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 10000)
                    },
                    ItemList.Circuit_Biowaresupercomputer.get(1L), 4000, 500000);

            GT_Values.RA.addAssemblylineRecipe(ItemList.Circuit_Biowaresupercomputer.get(1L), 576000, new ItemStack[]{
                    GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 4L),
                    ItemList.Circuit_Biowaresupercomputer.get(2L),
                    ItemList.Circuit_Parts_Coil.get(64L),
                    ItemList.Circuit_Parts_Coil.get(64L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(64L),
                    ItemList.Circuit_Parts_ResistorSMD.get(64L),
                    ItemList.Circuit_Parts_TransistorSMD.get(64L),
                    ItemList.Circuit_Parts_DiodeSMD.get(64L),
                    ItemList.Circuit_Chip_Ram.get(64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUHV, 64),
                    GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 64),
                    GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 64)
            }, new FluidStack[]{
                    Materials.SolderingAlloy.getMolten(2880L),
                    Materials.BioMediumSterilized.getFluid(2880L),
                    new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20000)
            }, ItemList.Circuit_Biomainframe.get(1L), 8000, 2000000);
        }

    }

    private final static boolean make_floppy(String displayname,String name,int color, int circuit) {
        ItemStack floppy = GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4);
        NBTTagCompound tag = new NBTTagCompound(),
                subtag = new NBTTagCompound();
        subtag.setString("Name", displayname);
        tag.setTag("display", subtag);
        subtag = new NBTTagCompound();
        subtag.setString("oc:fs.label", name);
        tag.setTag("oc:data", subtag);
        tag.setInteger("oc:color", color);
        tag.setString("oc:lootFactory","OpenComputers:"+name);
        floppy.setTagCompound(tag);
        return GT_Values.RA.addLaserEngraverRecipe(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4), GT_Utility.getIntegratedCircuit(circuit), floppy, 200, 120);
    }

    private final static boolean make_lua_bios() {
        ItemStack lua = GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0);
        NBTTagCompound tag = new NBTTagCompound(),
                subtag = new NBTTagCompound();
        subtag.setString("oc:label", "EEPROM (Lua Bios)");
        subtag.setBoolean("oc:readonly", false);
        final byte[] b = {
                108, 111, 99, 97, 108, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 95, 105, 110, 118, 111, 107,
                101, 32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 105, 110, 118, 111, 107, 101, 10, 102, 117,
                110, 99, 116, 105, 111, 110, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97, 100, 100, 114,
                101, 115, 115, 44, 32, 109, 101, 116, 104, 111, 100, 44, 32, 46, 46, 46, 41, 10, 32, 32, 108, 111, 99, 97,
                108, 32, 114, 101, 115, 117, 108, 116, 32, 61, 32, 116, 97, 98, 108, 101, 46, 112, 97, 99, 107, 40, 112, 99,
                97, 108, 108, 40, 99, 111, 109, 112, 111, 110, 101, 110, 116, 95, 105, 110, 118, 111, 107, 101, 44, 32, 97,
                100, 100, 114, 101, 115, 115, 44, 32, 109, 101, 116, 104, 111, 100, 44, 32, 46, 46, 46, 41, 41, 10, 32, 32,
                105, 102, 32, 110, 111, 116, 32, 114, 101, 115, 117, 108, 116, 91, 49, 93, 32, 116, 104, 101, 110, 10, 32, 32,
                32, 32, 114, 101, 116, 117, 114, 110, 32, 110, 105, 108, 44, 32, 114, 101, 115, 117, 108, 116, 91, 50, 93, 10,
                32, 32, 101, 108, 115, 101, 10, 32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 116, 97, 98, 108, 101, 46,
                117, 110, 112, 97, 99, 107, 40, 114, 101, 115, 117, 108, 116, 44, 32, 50, 44, 32, 114, 101, 115, 117, 108, 116,
                46, 110, 41, 10, 32, 32, 101, 110, 100, 10, 101, 110, 100, 10, 10, 45, 45, 32, 98, 97, 99, 107, 119, 97, 114,
                100, 115, 32, 99, 111, 109, 112, 97, 116, 105, 98, 105, 108, 105, 116, 121, 44, 32, 109, 97, 121, 32, 114, 101,
                109, 111, 118, 101, 32, 108, 97, 116, 101, 114, 10, 108, 111, 99, 97, 108, 32, 101, 101, 112, 114, 111, 109, 32,
                61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 101, 101, 112, 114, 111, 109,
                34, 41, 40, 41, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 103, 101, 116, 66, 111, 111, 116, 65, 100, 100,
                114, 101, 115, 115, 32, 61, 32, 102, 117, 110, 99, 116, 105, 111, 110, 40, 41, 10, 32, 32, 114, 101, 116, 117,
                114, 110, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 101, 101, 112, 114, 111, 109, 44, 32, 34,
                103, 101, 116, 68, 97, 116, 97, 34, 41, 10, 101, 110, 100, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 115,
                101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 32, 61, 32, 102, 117, 110, 99, 116, 105, 111, 110,
                40, 97, 100, 100, 114, 101, 115, 115, 41, 10, 32, 32, 114, 101, 116, 117, 114, 110, 32, 98, 111, 111, 116, 95,
                105, 110, 118, 111, 107, 101, 40, 101, 101, 112, 114, 111, 109, 44, 32, 34, 115, 101, 116, 68, 97, 116, 97, 34,
                44, 32, 97, 100, 100, 114, 101, 115, 115, 41, 10, 101, 110, 100, 10, 10, 100, 111, 10, 32, 32, 108, 111, 99, 97,
                108, 32, 115, 99, 114, 101, 101, 110, 32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115,
                116, 40, 34, 115, 99, 114, 101, 101, 110, 34, 41, 40, 41, 10, 32, 32, 108, 111, 99, 97, 108, 32, 103, 112, 117,
                32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 103, 112, 117, 34, 41,
                40, 41, 10, 32, 32, 105, 102, 32, 103, 112, 117, 32, 97, 110, 100, 32, 115, 99, 114, 101, 101, 110, 32, 116, 104,
                101, 110, 10, 32, 32, 32, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 103, 112, 117, 44, 32, 34,
                98, 105, 110, 100, 34, 44, 32, 115, 99, 114, 101, 101, 110, 41, 10, 32, 32, 101, 110, 100, 10, 101, 110, 100, 10,
                108, 111, 99, 97, 108, 32, 102, 117, 110, 99, 116, 105, 111, 110, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114,
                111, 109, 40, 97, 100, 100, 114, 101, 115, 115, 41, 10, 32, 32, 108, 111, 99, 97, 108, 32, 104, 97, 110, 100, 108,
                101, 44, 32, 114, 101, 97, 115, 111, 110, 32, 61, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97,
                100, 100, 114, 101, 115, 115, 44, 32, 34, 111, 112, 101, 110, 34, 44, 32, 34, 47, 105, 110, 105, 116, 46, 108, 117,
                97, 34, 41, 10, 32, 32, 105, 102, 32, 110, 111, 116, 32, 104, 97, 110, 100, 108, 101, 32, 116, 104, 101, 110, 10,
                32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 110, 105, 108, 44, 32, 114, 101, 97, 115, 111, 110, 10, 32, 32,
                101, 110, 100, 10, 32, 32, 108, 111, 99, 97, 108, 32, 98, 117, 102, 102, 101, 114, 32, 61, 32, 34, 34, 10, 32, 32,
                114, 101, 112, 101, 97, 116, 10, 32, 32, 32, 32, 108, 111, 99, 97, 108, 32, 100, 97, 116, 97, 44, 32, 114, 101, 97,
                115, 111, 110, 32, 61, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97, 100, 100, 114, 101, 115, 115,
                44, 32, 34, 114, 101, 97, 100, 34, 44, 32, 104, 97, 110, 100, 108, 101, 44, 32, 109, 97, 116, 104, 46, 104, 117, 103,
                101, 41, 10, 32, 32, 32, 32, 105, 102, 32, 110, 111, 116, 32, 100, 97, 116, 97, 32, 97, 110, 100, 32, 114, 101, 97,
                115, 111, 110, 32, 116, 104, 101, 110, 10, 32, 32, 32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 110, 105, 108,
                44, 32, 114, 101, 97, 115, 111, 110, 10, 32, 32, 32, 32, 101, 110, 100, 10, 32, 32, 32, 32, 98, 117, 102, 102, 101,
                114, 32, 61, 32, 98, 117, 102, 102, 101, 114, 32, 46, 46, 32, 40, 100, 97, 116, 97, 32, 111, 114, 32, 34, 34, 41, 10,
                32, 32, 117, 110, 116, 105, 108, 32, 110, 111, 116, 32, 100, 97, 116, 97, 10, 32, 32, 98, 111, 111, 116, 95, 105, 110,
                118, 111, 107, 101, 40, 97, 100, 100, 114, 101, 115, 115, 44, 32, 34, 99, 108, 111, 115, 101, 34, 44, 32, 104, 97, 110,
                100, 108, 101, 41, 10, 32, 32, 114, 101, 116, 117, 114, 110, 32, 108, 111, 97, 100, 40, 98, 117, 102, 102, 101, 114, 44,
                32, 34, 61, 105, 110, 105, 116, 34, 41, 10, 101, 110, 100, 10, 108, 111, 99, 97, 108, 32, 105, 110, 105, 116, 44, 32,
                114, 101, 97, 115, 111, 110, 10, 105, 102, 32, 99, 111, 109, 112, 117, 116, 101, 114, 46, 103, 101, 116, 66, 111, 111,
                116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 32, 116, 104, 101, 110, 10, 32, 32, 105, 110, 105, 116, 44, 32, 114, 101,
                97, 115, 111, 110, 32, 61, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114, 111, 109, 40, 99, 111, 109, 112, 117, 116, 101,
                114, 46, 103, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 41, 10, 101, 110, 100, 10, 105, 102,
                32, 110, 111, 116, 32, 105, 110, 105, 116, 32, 116, 104, 101, 110, 10, 32, 32, 99, 111, 109, 112, 117, 116, 101, 114, 46,
                115, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 10, 32, 32, 102, 111, 114, 32, 97, 100, 100,
                114, 101, 115, 115, 32, 105, 110, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 102,
                105, 108, 101, 115, 121, 115, 116, 101, 109, 34, 41, 32, 100, 111, 10, 32, 32, 32, 32, 105, 110, 105, 116, 44, 32, 114,
                101, 97, 115, 111, 110, 32, 61, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114, 111, 109, 40, 97, 100, 100, 114, 101, 115,
                115, 41, 10, 32, 32, 32, 32, 105, 102, 32, 105, 110, 105, 116, 32, 116, 104, 101, 110, 10, 32, 32, 32, 32, 32, 32, 99,
                111, 109, 112, 117, 116, 101, 114, 46, 115, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 97, 100,
                100, 114, 101, 115, 115, 41, 10, 32, 32, 32, 32, 32, 32, 98, 114, 101, 97, 107, 10, 32, 32, 32, 32, 101, 110, 100, 10,
                32, 32, 101, 110, 100, 10, 101, 110, 100, 10, 105, 102, 32, 110, 111, 116, 32, 105, 110, 105, 116, 32, 116, 104, 101,
                110, 10, 32, 32, 101, 114, 114, 111, 114, 40, 34, 110, 111, 32, 98, 111, 111, 116, 97, 98, 108, 101, 32, 109, 101, 100,
                105, 117, 109, 32, 102, 111, 117, 110, 100, 34, 32, 46, 46, 32, 40, 114, 101, 97, 115, 111, 110, 32, 97, 110, 100, 32,
                40, 34, 58, 32, 34, 32, 46, 46, 32, 116, 111, 115, 116, 114, 105, 110, 103, 40, 114, 101, 97, 115, 111, 110, 41, 41, 32,
                111, 114, 32, 34, 34, 41, 44, 32, 48, 41, 10, 101, 110, 100, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 98, 101, 101,
                112, 40, 49, 48, 48, 48, 44, 32, 48, 46, 50, 41, 10, 105, 110, 105, 116, 40, 41
        };
        subtag.setByteArray("oc:eeprom", b);
        tag.setTag("oc:data", subtag);
        lua.setTagCompound(tag);
        return GT_Values.RA.addLaserEngraverRecipe(GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0),GT_Utility.getIntegratedCircuit(1),lua,200,120);
    }
}