package com.dreammaster.gthandler;

import static gregtech.api.enums.OrePrefixes.screw;
import static gregtech.api.util.GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES;

import com.dreammaster.main.NHItems;
import com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader;
import cpw.mods.fml.common.Loader;
import gregtech.api.enums.*;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.common.GT_Proxy;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GT_CraftingRecipeLoader extends gregtech.loaders.postload.GT_CraftingRecipeLoader implements Runnable {
    private static final String aTextRailcraft = "Railcraft";
    private static final String aTextMachineBeta = "machine.beta";
    private static final String aTextMachineAlpha = "machine.alpha";
    private static final String aTextIron1 = "X X";
    private static final String aTextIron2 = "XXX";
    private static final String aTextForestry = "Forestry";
    private static final String aTextTConstruct = "TConstruct";
    private static final String aTextGraviSuite = "GraviSuite";
    private static final long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE
            | GT_ModHandler.RecipeBits.REVERSIBLE
            | GT_ModHandler.RecipeBits.DISMANTLEABLE
            | GT_ModHandler.RecipeBits.BUFFERED;
    private static final long bits2 = GT_ModHandler.RecipeBits.NOT_REMOVABLE
            | GT_ModHandler.RecipeBits.REVERSIBLE
            | GT_ModHandler.RecipeBits.DISMANTLEABLE
            | GT_ModHandler.RecipeBits.BUFFERED
            | DELETE_ALL_OTHER_RECIPES;
    private static final long bits3 = GT_ModHandler.RecipeBits.NOT_REMOVABLE
            | GT_ModHandler.RecipeBits.DISMANTLEABLE
            | GT_ModHandler.RecipeBits.BUFFERED;
    private static final long bits4 = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED;
    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED
            | GT_ModHandler.RecipeBits.NOT_REMOVABLE
            | GT_ModHandler.RecipeBits.REVERSIBLE;

    @Override
    public void run() {
        // UEV, UIV, UMV casings
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Casing_UEV.get(1L),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] {"PPP", "PwP", "PPP", 'P', OrePrefixes.plate.get(Materials.Bedrockium)});
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Casing_UIV.get(1L),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] {"PPP", "PwP", "PPP", 'P', OrePrefixes.plate.get(Materials.BlackPlutonium)});
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Casing_UMV.get(1L),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] {"PPP", "PwP", "PPP", 'P', OrePrefixes.plate.get(Materials.SpaceTime)});

        // Mine and Blade Battlegear remove recipes NBT?
        Object[] o = new Object[0];

        GT_ModHandler.addCraftingRecipe(ItemList.Generator_Naquadah_Mark_I.get(1L), bits, new Object[] {
            "UCU",
            "FMF",
            "WCW",
            'M',
            ItemList.Hull_EV,
            'F',
            ItemList.Field_Generator_EV,
            'C',
            OrePrefixes.circuit.get(Materials.Elite),
            'W',
            OrePrefixes.cableGt04.get(Materials.Aluminium),
            'U',
            OrePrefixes.stick.get(Materials.Uranium235)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Generator_Naquadah_Mark_II.get(1L), bits, new Object[] {
            "PCP",
            "FMF",
            "WCW",
            'M',
            ItemList.Hull_IV,
            'F',
            ItemList.Field_Generator_IV,
            'C',
            OrePrefixes.circuit.get(Materials.Master),
            'W',
            OrePrefixes.cableGt04.get(Materials.Tungsten),
            'P',
            OrePrefixes.stick.get(Materials.Plutonium241)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Generator_Naquadah_Mark_III.get(1L), bits, new Object[] {
            "NCN",
            "FMF",
            "WCW",
            'M',
            ItemList.Hull_LuV,
            'F',
            ItemList.Field_Generator_LuV,
            'C',
            OrePrefixes.circuit.get(Materials.Ultimate),
            'W',
            OrePrefixes.cableGt04.get(Materials.HSSG),
            'N',
            OrePrefixes.stick.get(Materials.Europium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Generator_Naquadah_Mark_IV.get(1L), bits, new Object[] {
            "NCN",
            "FMF",
            "WCW",
            'M',
            ItemList.Hull_ZPM,
            'F',
            ItemList.Field_Generator_ZPM,
            'C',
            OrePrefixes.circuit.get(Materials.Superconductor),
            'W',
            OrePrefixes.cableGt04.get(Materials.Naquadah),
            'N',
            OrePrefixes.stick.get(Materials.Americium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Generator_Naquadah_Mark_V.get(1L), bits, new Object[] {
            "NCN",
            "FMF",
            "WCW",
            'M',
            ItemList.Hull_UV,
            'F',
            ItemList.Field_Generator_UV,
            'C',
            OrePrefixes.circuit.get(Materials.Infinite),
            'W',
            OrePrefixes.cableGt04.get(Materials.ElectrumFlux),
            'N',
            OrePrefixes.stick.get(Materials.NaquadahAlloy)
        });

        GT_ModHandler.addCraftingRecipe(ItemList.LargeHPSteamTurbine.get(1L), bits, new Object[] {
            "CPC",
            "PMP",
            "BPB",
            'M',
            ItemList.Hull_IV,
            'B',
            OrePrefixes.pipeLarge.get(Materials.TungstenSteel),
            'C',
            OrePrefixes.circuit.get(Materials.Master),
            'P',
            OrePrefixes.gearGt.get(Materials.TungstenSteel)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.LargePlasmaTurbine.get(1L), bits, new Object[] {
            "CPC",
            "PMP",
            "BPB",
            'M',
            ItemList.Hull_UV,
            'B',
            OrePrefixes.pipeHuge.get(Materials.Naquadah),
            'C',
            OrePrefixes.circuit.get(Materials.Ultimate),
            'P',
            OrePrefixes.gearGt.get(Materials.NaquadahAlloy)
        });

        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_LV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_MV,
            'M',
            ItemList.Casing_Tank_1,
            'G',
            OrePrefixes.plate.get(Materials.PulsatingIron),
            'D',
            OrePrefixes.circuit.get(Materials.Basic),
            'P',
            OrePrefixes.plate.get(Materials.Aluminium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_MV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_HV,
            'M',
            ItemList.Casing_Tank_2,
            'G',
            OrePrefixes.plate.get(Materials.VibrantAlloy),
            'D',
            OrePrefixes.circuit.get(Materials.Good),
            'P',
            OrePrefixes.plate.get(Materials.StainlessSteel)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_HV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_HV,
            'M',
            ItemList.Casing_Tank_3,
            'G',
            ItemList.Field_Generator_LV,
            'D',
            OrePrefixes.circuit.get(Materials.Advanced),
            'P',
            OrePrefixes.plate.get(Materials.StainlessSteel)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_EV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_EV,
            'M',
            ItemList.Casing_Tank_4,
            'G',
            ItemList.Field_Generator_MV,
            'D',
            OrePrefixes.circuit.get(Materials.Data),
            'P',
            OrePrefixes.plate.get(Materials.Titanium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_IV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_EV,
            'M',
            ItemList.Casing_Tank_5,
            'G',
            ItemList.Field_Generator_HV,
            'D',
            OrePrefixes.circuit.get(Materials.Elite),
            'P',
            OrePrefixes.plate.get(Materials.Titanium)
        });

        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_LV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_IV,
            'M',
            ItemList.Casing_Tank_6,
            'G',
            ItemList.Field_Generator_EV,
            'D',
            OrePrefixes.circuit.get(Materials.Master),
            'P',
            OrePrefixes.plate.get(Materials.TungstenSteel)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_MV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_IV,
            'M',
            ItemList.Casing_Tank_7,
            'G',
            ItemList.Field_Generator_IV,
            'D',
            OrePrefixes.circuit.get(Materials.Ultimate),
            'P',
            OrePrefixes.plate.get(Materials.HSSG)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_HV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_LuV,
            'M',
            ItemList.Casing_Tank_8,
            'G',
            ItemList.Field_Generator_LuV,
            'D',
            OrePrefixes.circuit.get(Materials.Superconductor),
            'P',
            OrePrefixes.plate.get(Materials.HSSS)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_EV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_ZPM,
            'M',
            ItemList.Casing_Tank_9,
            'G',
            ItemList.Field_Generator_ZPM,
            'D',
            OrePrefixes.circuit.get(Materials.Infinite),
            'P',
            OrePrefixes.plate.get(Materials.Europium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_IV.get(1L), bits, new Object[] {
            "DGD",
            "PMP",
            "DUD",
            'U',
            ItemList.Electric_Pump_UV,
            'M',
            ItemList.Casing_Tank_10,
            'G',
            ItemList.Field_Generator_UV,
            'D',
            OrePrefixes.circuit.get(Materials.Bio),
            'P',
            OrePrefixes.plate.get(Materials.Americium)
        });

        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_LV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            ItemList.Automation_ChestBuffer_LV,
            'G',
            OrePrefixes.plate.get(Materials.PulsatingIron),
            'D',
            OrePrefixes.circuit.get(Materials.Basic),
            'P',
            OrePrefixes.plateDense.get(Materials.Iron)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_MV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            ItemList.Automation_ChestBuffer_MV,
            'G',
            OrePrefixes.plate.get(Materials.VibrantAlloy),
            'D',
            OrePrefixes.circuit.get(Materials.Good),
            'P',
            OrePrefixes.plateDense.get(Materials.Steel)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_HV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            ItemList.Automation_ChestBuffer_HV,
            'G',
            ItemList.Field_Generator_LV,
            'D',
            OrePrefixes.circuit.get(Materials.Advanced),
            'P',
            OrePrefixes.plateQuintuple.get(Materials.Aluminium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_EV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            ItemList.Automation_ChestBuffer_EV,
            'G',
            ItemList.Field_Generator_MV,
            'D',
            OrePrefixes.circuit.get(Materials.Data),
            'P',
            OrePrefixes.plateQuintuple.get(Materials.StainlessSteel)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_IV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            ItemList.Automation_ChestBuffer_IV,
            'G',
            ItemList.Field_Generator_HV,
            'D',
            OrePrefixes.circuit.get(Materials.Elite),
            'P',
            OrePrefixes.plateQuadruple.get(Materials.Titanium)
        });

        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_LV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            ItemList.Automation_ChestBuffer_LuV,
            'G',
            ItemList.Field_Generator_EV,
            'D',
            OrePrefixes.circuit.get(Materials.Master),
            'P',
            OrePrefixes.plateQuadruple.get(Materials.TungstenSteel)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_MV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            ItemList.Automation_ChestBuffer_ZPM,
            'G',
            ItemList.Field_Generator_IV,
            'D',
            OrePrefixes.circuit.get(Materials.Ultimate),
            'P',
            OrePrefixes.plateTriple.get(Materials.HSSG)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_HV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            ItemList.Automation_ChestBuffer_UV,
            'G',
            ItemList.Field_Generator_LuV,
            'D',
            OrePrefixes.circuit.get(Materials.Superconductor),
            'P',
            OrePrefixes.plateTriple.get(Materials.HSSS)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_EV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            ItemList.Automation_ChestBuffer_MAX,
            'G',
            ItemList.Field_Generator_ZPM,
            'D',
            OrePrefixes.circuit.get(Materials.Infinite),
            'P',
            OrePrefixes.plateDouble.get(Materials.Europium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_IV.get(1L), bits, new Object[] {
            "DPD",
            "PMP",
            "DGD",
            'M',
            CustomItemList.Automation_ChestBuffer_UEV,
            'G',
            ItemList.Field_Generator_UV,
            'D',
            OrePrefixes.circuit.get(Materials.Bio),
            'P',
            OrePrefixes.plate.get(Materials.Americium)
        });

        // Hermetic casings
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_1.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.Steel),
            'I',
            OrePrefixes.pipeLarge.get(Materials.Plastic)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_2.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.Aluminium),
            'I',
            OrePrefixes.pipeLarge.get(Materials.PolyvinylChloride)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_3.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.StainlessSteel),
            'I',
            OrePrefixes.pipeLarge.get(Materials.Polytetrafluoroethylene)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_4.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.Titanium),
            'I',
            OrePrefixes.pipeLarge.get(Materials.StainlessSteel)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_5.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.TungstenSteel),
            'I',
            OrePrefixes.pipeLarge.get(Materials.Titanium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_6.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.Chrome),
            'I',
            OrePrefixes.pipeLarge.get(Materials.TungstenSteel)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_7.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.Iridium),
            'I',
            OrePrefixes.pipeLarge.get(Materials.NiobiumTitanium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_8.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.Osmium),
            'I',
            OrePrefixes.pipeLarge.get(Materials.Enderium)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_9.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.Neutronium),
            'I',
            OrePrefixes.pipeLarge.get(Materials.Naquadah)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_10.get(1L), bits, new Object[] {
            "PPP",
            "PIP",
            "PPP",
            'P',
            OrePrefixes.plate.get(Materials.Bedrockium),
            'I',
            OrePrefixes.pipeLarge.get(Materials.MysteriousCrystal)
        });

        GT_ModHandler.addCraftingRecipe(
                ItemList.Field_Generator_LV.get(1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
                new Object[] {
                    "WCW",
                    "CGC",
                    "WCW",
                    'G',
                    OrePrefixes.plate.get(Materials.EnderPearl),
                    'C',
                    OrePrefixes.circuit.get(Materials.Advanced),
                    'W',
                    OrePrefixes.plate.get(Materials.RedSteel)
                });
        GT_ModHandler.addCraftingRecipe(
                ItemList.Field_Generator_MV.get(1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
                new Object[] {
                    "WCW",
                    "CGC",
                    "WCW",
                    'G',
                    OrePrefixes.plate.get(Materials.EnderEye),
                    'C',
                    OrePrefixes.circuit.get(Materials.Data),
                    'W',
                    OrePrefixes.plate.get(Materials.TungstenSteel)
                });
        GT_ModHandler.addCraftingRecipe(
                ItemList.Field_Generator_HV.get(1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
                new Object[] {
                    "WCW",
                    "CGC",
                    "WCW",
                    'G',
                    ItemList.QuantumEye.get(1L),
                    'C',
                    OrePrefixes.circuit.get(Materials.Elite),
                    'W',
                    OrePrefixes.plateDouble.get(Materials.NiobiumTitanium)
                });
        GT_ModHandler.addCraftingRecipe(
                ItemList.Field_Generator_EV.get(1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
                new Object[] {
                    "WCW",
                    "CGC",
                    "WCW",
                    'G',
                    OrePrefixes.gem.get(Materials.NetherStar),
                    'C',
                    OrePrefixes.circuit.get(Materials.Master),
                    'W',
                    OrePrefixes.plateDouble.get(Materials.HSSG)
                });
        GT_ModHandler.addCraftingRecipe(
                ItemList.Field_Generator_IV.get(1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
                new Object[] {
                    "WCW",
                    "CGC",
                    "WCW",
                    'G',
                    ItemList.QuantumStar.get(1L),
                    'C',
                    OrePrefixes.circuit.get(Materials.Ultimate),
                    'W',
                    OrePrefixes.plateTriple.get(Materials.HSSS)
                });

        // Solar Panels 1-8 EU. Higher tier ones are in script because they're DCT crafts
        GT_ModHandler.addCraftingRecipe(
                ItemList.Cover_SolarPanel.get(1L, o),
                GT_ModHandler.RecipeBits.DISMANTLEABLE
                        | GT_ModHandler.RecipeBits.NOT_REMOVABLE
                        | GT_ModHandler.RecipeBits.REVERSIBLE,
                new Object[] {
                    "SGS",
                    "CPC",
                    "TRT",
                    'C',
                    OrePrefixes.circuit.get(Materials.Basic),
                    'G',
                    GT_ModHandler.getIC2Item("reinforcedGlass", 1L),
                    'P',
                    OrePrefixes.plateAlloy.get(Materials.Carbon),
                    'S',
                    ItemList.Circuit_Silicon_Wafer,
                    'T',
                    OrePrefixes.wireGt01.get(Materials.RedAlloy),
                    'R',
                    CustomItemList.AluminiumIronPlate
                });
        GT_ModHandler.addCraftingRecipe(
                ItemList.Cover_SolarPanel_8V.get(1L, o),
                GT_ModHandler.RecipeBits.DISMANTLEABLE
                        | GT_ModHandler.RecipeBits.NOT_REMOVABLE
                        | GT_ModHandler.RecipeBits.REVERSIBLE,
                new Object[] {
                    "GSG",
                    "CRC",
                    "PAP",
                    'C',
                    OrePrefixes.circuit.get(Materials.Good),
                    'G',
                    ItemList.Cover_SolarPanel.get(1L, o),
                    'P',
                    OrePrefixes.wireGt01.get(Materials.Tin),
                    'S',
                    ItemList.Circuit_Silicon_Wafer,
                    'R',
                    OrePrefixes.plate.get(Materials.GalliumArsenide),
                    'A',
                    CustomItemList.ReinforcedAluminiumIronPlate
                });

        // LV+1st MV circuit/parts
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Board_Coated.get(1, o), new Object[] {
            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
            ItemList.IC2_Resin.get(1, o),
            ItemList.IC2_Resin.get(1, o)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Board_Coated.get(3, o), new Object[] {
            "RRR",
            "PPP",
            "RRR",
            'P',
            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
            'R',
            ItemList.IC2_Resin.get(1, o)
        });
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Board_Coated.get(1, o), new Object[] {
            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
            new ItemStack(Items.slime_ball, 1),
            new ItemStack(Items.slime_ball, 1)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Board_Coated.get(3, o), new Object[] {
            "RRR",
            "PPP",
            "RRR",
            'P',
            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
            'R',
            new ItemStack(Items.slime_ball, 1)
        });
        if (Loader.isModLoaded("TConstruct")) {
            GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Board_Coated.get(1, o), new Object[] {
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                GT_ModHandler.getModItem("TConstruct", "materials", 1, 36),
                GT_ModHandler.getModItem("TConstruct", "materials", 1, 36)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Board_Coated.get(3, o), new Object[] {
                "RRR",
                "PPP",
                "RRR",
                'P',
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                'R',
                GT_ModHandler.getModItem("TConstruct", "materials", 1, 36)
            });
            GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Board_Coated.get(1, o), new Object[] {
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 0),
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 0)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Board_Coated.get(3, o), new Object[] {
                "RRR",
                "PPP",
                "RRR",
                'P',
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                'R',
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 0)
            });
            GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Board_Coated.get(1, o), new Object[] {
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 1),
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 1)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Board_Coated.get(3, o), new Object[] {
                "RRR",
                "PPP",
                "RRR",
                'P',
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                'R',
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 1)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
                "RPR",
                "FCF",
                " P ",
                'F',
                OrePrefixes.wireGt01.get(Materials.Copper),
                'P',
                OrePrefixes.wireFine.get(Materials.Copper),
                'C',
                OrePrefixes.dust.get(Materials.Coal),
                'R',
                GT_ModHandler.getModItem("TConstruct", "materials", 1, 36)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
                "RPR",
                "FCF",
                " P ",
                'F',
                OrePrefixes.wireGt01.get(Materials.Copper),
                'P',
                OrePrefixes.wireFine.get(Materials.Copper),
                'C',
                OrePrefixes.dust.get(Materials.Carbon),
                'R',
                GT_ModHandler.getModItem("TConstruct", "materials", 1, 36)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
                "RPR",
                "FCF",
                " P ",
                'F',
                OrePrefixes.wireGt01.get(Materials.Copper),
                'P',
                OrePrefixes.wireFine.get(Materials.Copper),
                'C',
                OrePrefixes.dust.get(Materials.Charcoal),
                'R',
                GT_ModHandler.getModItem("TConstruct", "materials", 1, 36)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
                "RPR",
                "FCF",
                " P ",
                'F',
                OrePrefixes.wireGt01.get(Materials.Copper),
                'P',
                OrePrefixes.wireFine.get(Materials.Copper),
                'C',
                OrePrefixes.dust.get(Materials.Coal),
                'R',
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 0)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
                "RPR",
                "FCF",
                " P ",
                'F',
                OrePrefixes.wireGt01.get(Materials.Copper),
                'P',
                OrePrefixes.wireFine.get(Materials.Copper),
                'C',
                OrePrefixes.dust.get(Materials.Carbon),
                'R',
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 0)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
                "RPR",
                "FCF",
                " P ",
                'F',
                OrePrefixes.wireGt01.get(Materials.Copper),
                'P',
                OrePrefixes.wireFine.get(Materials.Copper),
                'C',
                OrePrefixes.dust.get(Materials.Charcoal),
                'R',
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 0)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
                "RPR",
                "FCF",
                " P ",
                'F',
                OrePrefixes.wireGt01.get(Materials.Copper),
                'P',
                OrePrefixes.wireFine.get(Materials.Copper),
                'C',
                OrePrefixes.dust.get(Materials.Coal),
                'R',
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 1)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
                "RPR",
                "FCF",
                " P ",
                'F',
                OrePrefixes.wireGt01.get(Materials.Copper),
                'P',
                OrePrefixes.wireFine.get(Materials.Copper),
                'C',
                OrePrefixes.dust.get(Materials.Carbon),
                'R',
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 1)
            });
            GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
                "RPR",
                "FCF",
                " P ",
                'F',
                OrePrefixes.wireGt01.get(Materials.Copper),
                'P',
                OrePrefixes.wireFine.get(Materials.Copper),
                'C',
                OrePrefixes.dust.get(Materials.Charcoal),
                'R',
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1, 1)
            });
        }
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Board_Coated_Basic.get(1, o), new Object[] {
            "FFF",
            "FCF",
            "FFF",
            'C',
            ItemList.Circuit_Board_Coated.get(1, o),
            'F',
            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 1)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Good.get(1, o), new Object[] {
            "PAP",
            "CBC",
            "DCD",
            'D',
            ItemList.Circuit_Parts_Diode.get(1, o),
            'C',
            Ic2Items.electronicCircuit,
            'A',
            ItemList.IC2_Item_Casing_Steel.get(1, o),
            'P',
            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 1),
            'B',
            ItemList.Circuit_Board_Phenolic_Good.get(1, o)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Board_Phenolic_Good.get(1, o), new Object[] {
            "FFF",
            "FCF",
            "FFF",
            'C',
            ItemList.Circuit_Board_Phenolic.get(1, o),
            'F',
            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Gold, 1)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
            "RPR",
            "FCF",
            " P ",
            'F',
            OrePrefixes.wireGt01.get(Materials.Copper),
            'P',
            OrePrefixes.wireFine.get(Materials.Copper),
            'C',
            OrePrefixes.dust.get(Materials.Coal),
            'R',
            ItemList.IC2_Resin.get(1, o)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
            "RPR",
            "FCF",
            " P ",
            'F',
            OrePrefixes.wireGt01.get(Materials.Copper),
            'P',
            OrePrefixes.wireFine.get(Materials.Copper),
            'C',
            OrePrefixes.dust.get(Materials.Carbon),
            'R',
            ItemList.IC2_Resin.get(1, o)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
            "RPR",
            "FCF",
            " P ",
            'F',
            OrePrefixes.wireGt01.get(Materials.Copper),
            'P',
            OrePrefixes.wireFine.get(Materials.Copper),
            'C',
            OrePrefixes.dust.get(Materials.Charcoal),
            'R',
            ItemList.IC2_Resin.get(1, o)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
            "RPR",
            "FCF",
            " P ",
            'F',
            OrePrefixes.wireGt01.get(Materials.Copper),
            'P',
            OrePrefixes.wireFine.get(Materials.Copper),
            'C',
            OrePrefixes.dust.get(Materials.Lignite),
            'R',
            ItemList.IC2_Resin.get(1, o)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
            "RPR",
            "FCF",
            " P ",
            'F',
            OrePrefixes.wireGt01.get(Materials.Copper),
            'P',
            OrePrefixes.wireFine.get(Materials.Copper),
            'C',
            OrePrefixes.dust.get(Materials.Coal),
            'R',
            new ItemStack(Items.slime_ball, 1)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
            "RPR",
            "FCF",
            " P ",
            'F',
            OrePrefixes.wireGt01.get(Materials.Copper),
            'P',
            OrePrefixes.wireFine.get(Materials.Copper),
            'C',
            OrePrefixes.dust.get(Materials.Carbon),
            'R',
            new ItemStack(Items.slime_ball, 1)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
            "RPR",
            "FCF",
            " P ",
            'F',
            OrePrefixes.wireGt01.get(Materials.Copper),
            'P',
            OrePrefixes.wireFine.get(Materials.Copper),
            'C',
            OrePrefixes.dust.get(Materials.Charcoal),
            'R',
            new ItemStack(Items.slime_ball, 1)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Resistor.get(1, o), new Object[] {
            "RPR",
            "FCF",
            " P ",
            'F',
            OrePrefixes.wireGt01.get(Materials.Copper),
            'P',
            OrePrefixes.wireFine.get(Materials.Copper),
            'C',
            OrePrefixes.dust.get(Materials.Lignite),
            'R',
            new ItemStack(Items.slime_ball, 1)
        });
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Parts_Vacuum_Tube.get(1, o), new Object[] {
            "WWW",
            "FGF",
            "SAS",
            'G',
            ItemList.Circuit_Parts_Glass_Tube.get(1, o),
            'F',
            OrePrefixes.wireFine.get(Materials.Copper),
            'W',
            OrePrefixes.wireGt01.get(Materials.Copper),
            'S',
            OrePrefixes.stick.get(Materials.Steel),
            'A',
            OrePrefixes.bolt.get(Materials.RedAlloy)
        });

        // Filter Machine Casing for cleanroom
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Vent.get(1L), bits, new Object[] {
            "PPP",
            "SSS",
            "MFV",
            'P',
            CustomItemList.SteelBars.get(1, o),
            'F',
            OrePrefixes.frameGt.get(Materials.StainlessSteel),
            'M',
            ItemList.Electric_Motor_MV,
            'V',
            OrePrefixes.rotor.get(Materials.Aluminium),
            'S',
            ItemList.Component_Filter
        });

        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Firebricks.get(1L), tBitMask, new Object[] {
            "BCB",
            "BWB",
            "BCB",
            'B',
            ItemList.Firebrick.get(1),
            'C',
            OrePrefixes.dust.get(Materials.Gypsum),
            'W',
            GT_ModHandler.getModItem("dreamcraft", "dreamcraft_Concrete_bucket", 1L)
        });

        // Air filter multi blocks
        GT_ModHandler.addCraftingRecipe(CustomItemList.Casing_AirFilter_Vent_T1.get(1L), bits, new Object[] {
            "ThT", "TFT", "TwT", 'T', CustomItemList.SteelBars, 'F', OrePrefixes.frameGt.get(Materials.Steel)
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.Casing_AirFilter_Turbine_T1.get(1L), bits, new Object[] {
            "SSS",
            "RVR",
            "MSM",
            'V',
            CustomItemList.Casing_AirFilter_Vent_T1,
            'S',
            OrePrefixes.stickLong.get(Materials.Steel),
            'R',
            OrePrefixes.rotor.get(Materials.Steel),
            'M',
            ItemList.Electric_Motor_LV,
            'R',
            OrePrefixes.screw.get(Materials.Steel)
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_Multi_AirFilterT1.get(1L), bits, new Object[] {
            "RPR",
            "MBM",
            "CGC",
            'B',
            ItemList.Hull_LV,
            'R',
            OrePrefixes.rotor.get(Materials.Steel),
            'P',
            ItemList.Electric_Pump_LV,
            'M',
            ItemList.Electric_Motor_LV,
            'C',
            OrePrefixes.cableGt01.get(Materials.Copper),
            'G',
            ItemList.Casing_Turbine
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.Casing_AirFilter_Vent_T2.get(1L), bits, new Object[] {
            "ThT", "TFT", "TwT", 'T', CustomItemList.TitaniumBars, 'F', OrePrefixes.frameGt.get(Materials.Titanium)
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.Casing_AirFilter_Turbine_T2.get(1L), bits, new Object[] {
            "SSS",
            "RVR",
            "MSM",
            'V',
            CustomItemList.Casing_AirFilter_Vent_T2,
            'S',
            OrePrefixes.stickLong.get(Materials.Titanium),
            'R',
            OrePrefixes.rotor.get(Materials.Titanium),
            'M',
            ItemList.Electric_Motor_HV,
            'R',
            OrePrefixes.screw.get(Materials.Titanium)
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_Multi_AirFilterT2.get(1L), bits, new Object[] {
            "RPR",
            "MBM",
            "CGC",
            'B',
            ItemList.Hull_HV,
            'R',
            OrePrefixes.rotor.get(Materials.Titanium),
            'P',
            ItemList.Electric_Pump_HV,
            'M',
            ItemList.Electric_Motor_HV,
            'C',
            OrePrefixes.cableGt01.get(Materials.Gold),
            'G',
            ItemList.Casing_Turbine2
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.Casing_AirFilter_Vent_T3.get(1L), bits, new Object[] {
            "ThT",
            "TFT",
            "TwT",
            'T',
            CustomItemList.TungstenSteelBars,
            'F',
            OrePrefixes.frameGt.get(Materials.TungstenSteel)
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.Casing_AirFilter_Turbine_T3.get(1L), bits, new Object[] {
            "SSS",
            "RVR",
            "MSM",
            'V',
            CustomItemList.Casing_AirFilter_Vent_T3,
            'S',
            OrePrefixes.stickLong.get(Materials.TungstenSteel),
            'R',
            OrePrefixes.rotor.get(Materials.TungstenSteel),
            'M',
            ItemList.Electric_Motor_IV,
            'R',
            OrePrefixes.screw.get(Materials.TungstenSteel)
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_Multi_AirFilterT3.get(1L), bits, new Object[] {
            "RPR",
            "MBM",
            "CGC",
            'B',
            ItemList.Hull_IV,
            'R',
            OrePrefixes.rotor.get(Materials.TungstenSteel),
            'P',
            ItemList.Electric_Pump_IV,
            'M',
            ItemList.Electric_Motor_IV,
            'C',
            OrePrefixes.cableGt01.get(Materials.Tungsten),
            'G',
            ItemList.Casing_Turbine3
        });

        GT_ModHandler.addCraftingRecipe(CustomItemList.Casing_Pyrolyse.get(1L), bits, new Object[] {
            "PhP",
            "SFS",
            "PwP",
            'P',
            OrePrefixes.plate.get(Materials.Steel),
            'S',
            OrePrefixes.plate.get(Materials.Iron),
            'F',
            ItemList.Casing_BronzePlatedBricks
        });

        // For making bee houses
        GT_ModHandler.addCraftingRecipe(CustomItemList.WoodenCasing.get(1L), bits, new Object[] {
            "SSS",
            "UCU",
            "SDS",
            'S',
            OrePrefixes.slab.get(Materials.Wood),
            'D',
            ToolDictNames.craftingToolScrewdriver,
            'U',
            OrePrefixes.screw.get(Materials.Iron),
            'C',
            OrePrefixes.frameGt.get(Materials.Wood)
        });
        // For making gendustry upgrades
        GT_ModHandler.addCraftingRecipe(CustomItemList.IndustryFrame.get(1L), bits, new Object[] {
            "PPP",
            "SBS",
            "SSS",
            'P',
            OrePrefixes.plate.get(Materials.Palladium),
            'S',
            OrePrefixes.stick.get(Materials.Osmium),
            'B',
            CustomItemList.IridiumBars.get(1)
        });

        // BM raw orbs
        GT_ModHandler.addCraftingRecipe(CustomItemList.RawOrbTier1.get(1L), bits, new Object[] {
            "XTX",
            "POP",
            "PPP",
            'X',
            OrePrefixes.screw.get(Materials.Aluminium),
            'T',
            ToolDictNames.craftingToolScrewdriver,
            'P',
            OrePrefixes.plate.get(Materials.AnnealedCopper),
            'O',
            CustomItemList.ReinforcedGlassLense.get(1L)
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.RawOrbTier2.get(1L), bits, new Object[] {
            "XTX",
            "POP",
            "PPP",
            'X',
            OrePrefixes.screw.get(Materials.StainlessSteel),
            'T',
            ToolDictNames.craftingToolScrewdriver,
            'P',
            OrePrefixes.plate.get(Materials.RoseGold),
            'O',
            CustomItemList.ReinforcedGlassLense.get(1L)
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.RawOrbTier3.get(1L), bits, new Object[] {
            "XTX",
            "POP",
            "PPP",
            'X',
            OrePrefixes.screw.get(Materials.Titanium),
            'T',
            ToolDictNames.craftingToolScrewdriver,
            'P',
            OrePrefixes.plate.get(Materials.PulsatingIron),
            'O',
            CustomItemList.ReinforcedGlassLense.get(1L)
        });
        GT_ModHandler.addCraftingRecipe(CustomItemList.RawOrbTier4.get(1L), bits, new Object[] {
            "XTX",
            "POP",
            "PPP",
            'X',
            OrePrefixes.screw.get(Materials.TungstenSteel),
            'T',
            ToolDictNames.craftingToolScrewdriver,
            'P',
            OrePrefixes.plate.get(Materials.EnergeticAlloy),
            'O',
            CustomItemList.ReinforcedGlassLense.get(1L)
        });
        if (Loader.isModLoaded("bartworks"))
            GT_ModHandler.addCraftingRecipe(CustomItemList.RawOrbTier5.get(1L), bits, new Object[] {
                "XTX",
                "POP",
                "PPP",
                'X',
                WerkstoffLoader.LuVTierMaterial.get(screw),
                'T',
                ToolDictNames.craftingToolScrewdriver,
                'P',
                OrePrefixes.plate.get(Materials.FierySteel),
                'O',
                CustomItemList.ReinforcedGlassLense.get(1L)
            });
        GT_ModHandler.addCraftingRecipe(CustomItemList.RawOrbTier6.get(1L), bits, new Object[] {
            "XTX",
            "POP",
            "PPP",
            'X',
            OrePrefixes.screw.get(Materials.Iridium),
            'T',
            ToolDictNames.craftingToolScrewdriver,
            'P',
            OrePrefixes.plate.get(Materials.Plutonium241),
            'O',
            CustomItemList.ReinforcedGlassLense.get(1L)
        });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.UnfiredClayBrick.get(8L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {
                    "CCC",
                    "CFC",
                    "CCC",
                    'C',
                    new ItemStack(Items.clay_ball, 1, 0),
                    'F',
                    new ItemStack(NHItems.WOODEN_BRICK_FORM.get(), 1, 0)
                });
        GT_ModHandler.addShapelessCraftingRecipe(
                CustomItemList.UnfiredClayBrick.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {
                    new ItemStack(Items.clay_ball, 1, 0), new ItemStack(NHItems.WOODEN_BRICK_FORM.get(), 1, 0)
                });
        if (Loader.isModLoaded(aTextTConstruct)) {
            GT_ModHandler.addShapelessCraftingRecipe(
                    new ItemStack(NHItems.WOODEN_BRICK_FORM.get(), 1, 0),
                    GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                    new Object[] {
                        ToolDictNames.craftingToolKnife,
                        GT_ModHandler.getModItem(aTextTConstruct, "blankPattern", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.UnfiredSearedBrick.get(8L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {
                        "GGG",
                        "GFG",
                        "GGG",
                        'G',
                        GT_ModHandler.getModItem(aTextTConstruct, "CraftedSoil", 1L, 1),
                        'F',
                        new ItemStack(NHItems.WOODEN_BRICK_FORM.get(), 1, 0)
                    });
            GT_ModHandler.addShapelessCraftingRecipe(
                    CustomItemList.UnfiredSearedBrick.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {
                        GT_ModHandler.getModItem(aTextTConstruct, "CraftedSoil", 1L, 1),
                        new ItemStack(NHItems.WOODEN_BRICK_FORM.get(), 1, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.UnfiredSlimeSoulBrick.get(8L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {
                        "SSS",
                        "SFS",
                        "SSS",
                        'S',
                        GT_ModHandler.getModItem(aTextTConstruct, "CraftedSoil", 1L, 6),
                        'F',
                        new ItemStack(NHItems.WOODEN_BRICK_FORM.get(), 1, 0)
                    });
            GT_ModHandler.addShapelessCraftingRecipe(
                    CustomItemList.UnfiredSlimeSoulBrick.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {
                        GT_ModHandler.getModItem(aTextTConstruct, "CraftedSoil", 1L, 6),
                        new ItemStack(NHItems.WOODEN_BRICK_FORM.get(), 1, 0)
                    });
        }
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.UnfiredCokeOvenBrick.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {
                    "CCC",
                    "SFS",
                    "SSS",
                    'C',
                    new ItemStack(Items.clay_ball, 1, 0),
                    'S',
                    GT_OreDictUnificator.get("sand", 1L),
                    'F',
                    new ItemStack(NHItems.WOODEN_BRICK_FORM.get(), 1, 0)
                });

        GT_ModHandler.addCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
                new Object[] {"S", "m", 'S', new ItemStack(Blocks.sand, 1, 32767)});
        GT_ModHandler.addCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Flint, 1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
                new Object[] {"F", "m", 'F', new ItemStack(Items.flint, 1, 0)});

        GT_ModHandler.addShapelessCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
                new Object[] {OrePrefixes.dust.get(Materials.QuartzSand), OrePrefixes.dustTiny.get(Materials.Flint)});
        GT_ModHandler.addShapelessCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 8L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
                new Object[] {
                    OrePrefixes.dust.get(Materials.QuartzSand),
                    OrePrefixes.dust.get(Materials.QuartzSand),
                    OrePrefixes.dust.get(Materials.QuartzSand),
                    OrePrefixes.dust.get(Materials.QuartzSand),
                    OrePrefixes.dust.get(Materials.QuartzSand),
                    OrePrefixes.dust.get(Materials.QuartzSand),
                    OrePrefixes.dust.get(Materials.QuartzSand),
                    OrePrefixes.dust.get(Materials.QuartzSand),
                    OrePrefixes.dust.get(Materials.Flint)
                });

        GT_ModHandler.addCraftingRecipe(
                new ItemStack(Blocks.iron_bars, 3, 0),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
                new Object[] {
                    " h ", "SSS", "SSS", 'S', GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1)
                });
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SteelBars.get(3L, o),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
                new Object[] {" h ", "SSS", "SSS", 'S', GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1)
                });
        GT_ModHandler.addCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Steel, 1L), GT_Proxy.tBits, new Object[] {
                    "PIh",
                    "f  ",
                    'P',
                    OrePrefixes.plate.get(Materials.Steel),
                    'I',
                    OrePrefixes.ingot.get(Materials.Steel)
                });

        GT_ModHandler.addShapelessCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
                new Object[] {
                    ToolDictNames.craftingToolMortar, new ItemStack(Blocks.stained_hardened_clay, 1, GT_Values.W)
                });
        GT_ModHandler.addShapelessCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
                new Object[] {ToolDictNames.craftingToolMortar, new ItemStack(Blocks.hardened_clay, 1)});

        GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem("IC2", "itemArmorBatpack", 1, GT_Values.W), bits, new Object[] {
                    "RCR",
                    "RAR",
                    "RTR",
                    'R',
                    GT_ModHandler.getModItem("IC2", "itemBatREDischarged", 1, 0),
                    'C',
                    OrePrefixes.circuit.get(Materials.Basic),
                    'A',
                    OrePrefixes.itemCasing.get(Materials.Aluminium),
                    'T',
                    OrePrefixes.wireGt02.get(Materials.Tin)
                });
        GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem("IC2", "itemArmorAdvBatpack", 1, GT_Values.W), bits, new Object[] {
                    "RCR",
                    "RAR",
                    "RTR",
                    'R',
                    GT_ModHandler.getModItem("IC2", "itemAdvBat", 1, GT_Values.W),
                    'C',
                    OrePrefixes.circuit.get(Materials.Good),
                    'A',
                    GT_ModHandler.getModItem("IC2", "itemArmorBatpack", 1, GT_Values.W),
                    'T',
                    OrePrefixes.wireGt04.get(Materials.AnnealedCopper)
                });
        GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem("IC2", "itemArmorEnergypack", 1, GT_Values.W), bits, new Object[] {
                    "CSC",
                    "EXE",
                    "STS",
                    'E',
                    GT_ModHandler.getModItem("IC2", "itemBatCrystal", 1, GT_Values.W),
                    'C',
                    OrePrefixes.circuit.get(Materials.Advanced),
                    'X',
                    GT_ModHandler.getModItem("IC2", "itemArmorAdvBatpack", 1, GT_Values.W),
                    'T',
                    OrePrefixes.wireGt08.get(Materials.Gold),
                    'S',
                    OrePrefixes.itemCasing.get(Materials.StainlessSteel)
                });
        GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem("IC2", "itemAdvBat", 1, GT_Values.W), bits, new Object[] {
                    "WdW",
                    "HBH",
                    "HXH",
                    'W',
                    OrePrefixes.wireGt02.get(Materials.Copper),
                    'H',
                    OrePrefixes.itemCasing.get(Materials.Copper),
                    'X',
                    OrePrefixes.itemCasing.get(Materials.Lead),
                    'B',
                    ItemList.Battery_Hull_MV
                });
        if (Loader.isModLoaded("GalacticraftCore"))
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem("IC2", "itemNightvisionGoggles", 1, GT_Values.W), bits, new Object[] {
                        "AXA",
                        "RBR",
                        "SdS",
                        'A',
                        GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1, 1),
                        'X',
                        OrePrefixes.screw.get(Materials.StainlessSteel),
                        'B',
                        OrePrefixes.bolt.get(Materials.StainlessSteel),
                        'R',
                        OrePrefixes.ring.get(Materials.StainlessSteel),
                        'S',
                        GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 1, 0)
                    });
        GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem("IC2", "itemTreetapElectric", 1, GT_Values.W), bits, new Object[] {
                    "dRD",
                    "RPB",
                    "ECS",
                    'R',
                    OrePrefixes.stickLong.get(Materials.Steel),
                    'D',
                    OrePrefixes.toolHeadDrill.get(Materials.Steel),
                    'P',
                    ItemList.Electric_Pump_LV,
                    'B',
                    GT_ModHandler.getModItem("IC2", "itemBatRE", 1, GT_Values.W),
                    'E',
                    GT_ModHandler.getModItem("IC2", "itemRecipePart", 1, 3),
                    'C',
                    OrePrefixes.cableGt01.get(Materials.Tin),
                    'S',
                    screw.get(Materials.Steel)
                });
        GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem("IC2", "itemToolHoe", 1, GT_Values.W), bits, new Object[] {
                    "dPH",
                    "PGB",
                    "ECS",
                    'S',
                    screw.get(Materials.Steel),
                    'H',
                    OrePrefixes.toolHeadHoe.get(Materials.Steel),
                    'G',
                    OrePrefixes.gearGtSmall.get(Materials.Steel),
                    'B',
                    GT_ModHandler.getModItem("IC2", "itemBatRE", 1, GT_Values.W),
                    'E',
                    GT_ModHandler.getModItem("IC2", "itemRecipePart", 1, 3),
                    'P',
                    OrePrefixes.plate.get(Materials.Steel)
                });

        if (Loader.isModLoaded("OpenComputers"))
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem("OpenComputers", "wrench", 1, 0), GT_Proxy.tBits, new Object[] {
                        "IWI",
                        "ICI",
                        " I ",
                        'W',
                        ToolDictNames.craftingToolWrench,
                        'I',
                        OrePrefixes.ingot.get(Materials.Iron),
                        'C',
                        GT_ModHandler.getModItem("OpenComputers", "item", 1, 24)
                    });

        if (Loader.isModLoaded("openprinter"))
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem("openprinter", "openprinter.folder", 1L, 0), GT_Proxy.tBits, new Object[] {
                        "PGP", " P ", 'P', new ItemStack(Items.paper, 1, 0), 'G', new ItemStack(Items.slime_ball, 1, 0)
                    });

        GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem("dreamcraft", "dreamcraft_Concrete_bucket", 1, 0), bits, new Object[] {
                    "CBS",
                    "CWA",
                    " Y ",
                    'C',
                    OrePrefixes.dust.get(Materials.Calcite),
                    'S',
                    OrePrefixes.dust.get(Materials.Stone),
                    'Y',
                    OrePrefixes.dust.get(Materials.Clay),
                    'A',
                    OrePrefixes.dust.get(Materials.QuartzSand),
                    'W',
                    new ItemStack(Items.water_bucket, 1, 0),
                    'B',
                    new ItemStack(Items.bucket, 1, 0)
                });
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.clay_ball, 3, 0), GT_Proxy.tBits, new Object[] {
            "CCC",
            "CBC",
            "CCC",
            'C',
            OrePrefixes.dustSmall.get(Materials.Clay),
            'B',
            new ItemStack(Items.water_bucket, 1, 0)
        });
        if (Loader.isModLoaded("IguanaTweaksTConstruct")) {
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "dreamcraft_Concrete_bucket", 1, 0), bits, new Object[] {
                        "CBS",
                        "CWA",
                        " Y ",
                        'C',
                        OrePrefixes.dust.get(Materials.Calcite),
                        'S',
                        OrePrefixes.dust.get(Materials.Stone),
                        'Y',
                        OrePrefixes.dust.get(Materials.Clay),
                        'A',
                        OrePrefixes.dust.get(Materials.QuartzSand),
                        'W',
                        GT_ModHandler.getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0),
                        'B',
                        new ItemStack(Items.bucket, 1, 0)
                    });
            GT_ModHandler.addCraftingRecipe(new ItemStack(Items.clay_ball, 3, 0), GT_Proxy.tBits, new Object[] {
                "CCC",
                "CBC",
                "CCC",
                'C',
                OrePrefixes.dustSmall.get(Materials.Clay),
                'B',
                GT_ModHandler.getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0)
            });
        }

        if (Loader.isModLoaded(aTextForestry)) {
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextForestry, "engine", 1L, 0), bits2, new Object[] {
                        "BLB",
                        "SPS",
                        "GCG",
                        'B',
                        OrePrefixes.plate.get(Materials.StainlessSteel),
                        'L',
                        OrePrefixes.plate.get(Materials.Lapis),
                        'S',
                        OrePrefixes.spring.get(Materials.StainlessSteel),
                        'P',
                        OreDictNames.craftingPiston,
                        'G',
                        OrePrefixes.circuit.get(Materials.Basic),
                        'C',
                        GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextForestry, "engine", 1L, 1), bits2, new Object[] {
                        "BLB",
                        "SPS",
                        "GCG",
                        'B',
                        OrePrefixes.plate.get(Materials.Iron),
                        'L',
                        OrePrefixes.plate.get(Materials.Lapis),
                        'S',
                        OrePrefixes.spring.get(Materials.Iron),
                        'P',
                        OreDictNames.craftingPiston,
                        'G',
                        OrePrefixes.gearGt.get(Materials.Iron),
                        'C',
                        GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextForestry, "engine", 1L, 2), bits2, new Object[] {
                        "BLB",
                        "SPS",
                        "GCG",
                        'B',
                        OrePrefixes.plate.get(Materials.Bronze),
                        'L',
                        OrePrefixes.plate.get(Materials.Lapis),
                        'S',
                        OrePrefixes.spring.get(Materials.Bronze),
                        'P',
                        OreDictNames.craftingPiston,
                        'G',
                        OrePrefixes.gearGt.get(Materials.Bronze),
                        'C',
                        GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextForestry, "engine", 1L, 4), bits2, new Object[] {
                        "BLB",
                        "SPS",
                        "GCG",
                        'B',
                        OrePrefixes.plate.get(Materials.Gold),
                        'L',
                        OrePrefixes.plate.get(Materials.Lapis),
                        'S',
                        OrePrefixes.spring.get(Materials.WroughtIron),
                        'P',
                        OreDictNames.craftingPiston,
                        'G',
                        OrePrefixes.gearGt.get(Materials.WroughtIron),
                        'C',
                        GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)
                    });
        }

        // Rocket parts
        if ((Loader.isModLoaded("GalacticraftCore"))
                && (Loader.isModLoaded("GalacticraftMars"))
                && (Loader.isModLoaded("GalaxySpace"))) {
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem("GalaxySpace", "item.ModuleSmallCanister", 1L, 0), bits, new Object[] {
                        "PPP",
                        "PCP",
                        "PPP",
                        'P',
                        OrePrefixes.compressed.get(Materials.Steel),
                        'C',
                        GT_ModHandler.getModItem("GalacticraftCore", "item.oilCanisterPartial", 1L, 1001)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem("GalaxySpace", "item.ModuleSmallFuelCanister", 1L, 0), bits, new Object[] {
                        "SRS",
                        "TCD",
                        "SHS",
                        'S',
                        OrePrefixes.screw.get(Materials.StainlessSteel),
                        'R',
                        ToolDictNames.craftingToolScrewdriver,
                        'T',
                        GT_ModHandler.getModItem("GalaxySpace", "item.CompressedDualBronze", 1L, 0),
                        'D',
                        GT_ModHandler.getModItem("GalaxySpace", "item.CompressedDualAluminium", 1L, 0),
                        'C',
                        GT_ModHandler.getModItem("GalaxySpace", "item.ModuleSmallCanister", 1L, 0),
                        'H',
                        ToolDictNames.craftingToolHardHammer
                    });
            GT_ModHandler.addCraftingRecipe(CustomItemList.MediumFuelCanister.get(1L), bits, new Object[] {
                "SRS",
                "TCD",
                "SHS",
                'S',
                OrePrefixes.screw.get(Materials.Titanium),
                'R',
                ToolDictNames.craftingToolScrewdriver,
                'T',
                CustomItemList.TitaniumDualCompressedPlates.get(1),
                'D',
                CustomItemList.DeshDualCompressedPlates.get(1),
                'C',
                GT_ModHandler.getModItem("GalaxySpace", "item.ModuleSmallFuelCanister", 1L, 0),
                'H',
                ToolDictNames.craftingToolHardHammer
            });
            GT_ModHandler.addCraftingRecipe(CustomItemList.LargeFuelCanister.get(1L), bits, new Object[] {
                "SRS",
                "TCD",
                "SHS",
                'S',
                OrePrefixes.screw.get(Materials.Chrome),
                'R',
                ToolDictNames.craftingToolScrewdriver,
                'T',
                CustomItemList.QuantinumDualCompressedPlates.get(1),
                'D',
                CustomItemList.IceDualCompressedPlates.get(1),
                'C',
                CustomItemList.MediumFuelCanister.get(1),
                'H',
                ToolDictNames.craftingToolHardHammer
            });
            GT_ModHandler.addCraftingRecipe(CustomItemList.ExtraLargeFuelCanister.get(1L), bits, new Object[] {
                "SRS",
                "TCD",
                "SHS",
                'S',
                OrePrefixes.screw.get(Materials.Iridium),
                'R',
                ToolDictNames.craftingToolScrewdriver,
                'T',
                CustomItemList.MytrylDualCompressedPlates.get(1),
                'D',
                CustomItemList.MysteriousCrystalDualCompressedPlates.get(1),
                'C',
                CustomItemList.LargeFuelCanister.get(1),
                'H',
                ToolDictNames.craftingToolHardHammer
            });

            GT_ModHandler.addCraftingRecipe(CustomItemList.HeavyDutyRocketEngineTier3.get(1L), bits, new Object[] {
                "BPB",
                "PPP",
                "EPE",
                'B',
                CustomItemList.Tier2Booster.get(1),
                'P',
                CustomItemList.HeavyDutyPlateTier5.get(1),
                'E',
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 1)
            });
            GT_ModHandler.addCraftingRecipe(CustomItemList.HeavyDutyRocketEngineTier4.get(1L), bits, new Object[] {
                "BPB",
                "PPP",
                "EPE",
                'B',
                CustomItemList.Tier3Booster.get(1),
                'P',
                CustomItemList.HeavyDutyPlateTier7.get(1),
                'E',
                CustomItemList.HeavyDutyRocketEngineTier3.get(1)
            });

            GT_ModHandler.addCraftingRecipe(CustomItemList.HeavyDutyNoseConeTier3.get(1L), bits, new Object[] {
                "SNH",
                "CPC",
                "PPP",
                'N',
                GT_ModHandler.getModItem("GalacticraftMars", "item.heavyNoseCone", 1L, 0),
                'P',
                CustomItemList.HeavyDutyPlateTier5.get(1),
                'C',
                OrePrefixes.screw.get(Materials.TungstenSteel),
                'S',
                ToolDictNames.craftingToolScrewdriver,
                'H',
                ToolDictNames.craftingToolHardHammer
            });
            GT_ModHandler.addCraftingRecipe(CustomItemList.HeavyDutyNoseConeTier4.get(1L), bits, new Object[] {
                "SNH",
                "CPC",
                "PPP",
                'N',
                CustomItemList.HeavyDutyNoseConeTier3.get(1),
                'P',
                CustomItemList.HeavyDutyPlateTier7.get(1),
                'C',
                OrePrefixes.screw.get(Materials.NaquadahAlloy),
                'S',
                ToolDictNames.craftingToolScrewdriver,
                'H',
                ToolDictNames.craftingToolHardHammer
            });

            GT_ModHandler.addCraftingRecipe(CustomItemList.HeavyDutyRocketFinsTier3.get(1L), bits, new Object[] {
                "HPF",
                "QPQ",
                "QSQ",
                'P',
                CustomItemList.HeavyDutyPlateTier4.get(1),
                'Q',
                CustomItemList.HeavyDutyPlateTier5.get(1),
                'S',
                GT_ModHandler.getModItem("GalaxySpace", "item.CompressedSDHD120", 1L, 0),
                'F',
                ToolDictNames.craftingToolFile,
                'H',
                ToolDictNames.craftingToolHardHammer
            });
            GT_ModHandler.addCraftingRecipe(CustomItemList.HeavyDutyRocketFinsTier4.get(1L), bits, new Object[] {
                "HPF",
                "QPQ",
                "QSQ",
                'P',
                CustomItemList.HeavyDutyPlateTier6.get(1),
                'Q',
                CustomItemList.HeavyDutyPlateTier7.get(1),
                'S',
                GT_ModHandler.getModItem("GalaxySpace", "item.CompressedSDHD120", 1L, 0),
                'F',
                ToolDictNames.craftingToolFile,
                'H',
                ToolDictNames.craftingToolHardHammer
            });

            GT_ModHandler.addCraftingRecipe(CustomItemList.Tier2Booster.get(1L), bits, new Object[] {
                "LLL",
                "PBP",
                "PVP",
                'L',
                CustomItemList.LedoxCompressedPlate.get(1),
                'P',
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 0),
                'B',
                GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L, 1),
                'V',
                GT_ModHandler.getModItem("GalaxySpace", "item.CompressedSDHD120", 1L, 0)
            });
            GT_ModHandler.addCraftingRecipe(CustomItemList.Tier3Booster.get(1L), bits, new Object[] {
                "LLL",
                "PBP",
                "PVP",
                'L',
                CustomItemList.MytrylCompressedPlate.get(1),
                'P',
                CustomItemList.HeavyDutyPlateTier5.get(1),
                'B',
                CustomItemList.Tier2Booster.get(1),
                'V',
                GT_ModHandler.getModItem("GalaxySpace", "item.CompressedSDHD120", 1L, 0)
            });
            GT_ModHandler.addCraftingRecipe(CustomItemList.Tier4Booster.get(1L), bits, new Object[] {
                "LLL",
                "PBP",
                "PVP",
                'L',
                CustomItemList.BlackPlutoniumCompressedPlate.get(1),
                'P',
                CustomItemList.HeavyDutyPlateTier7.get(1),
                'B',
                CustomItemList.Tier3Booster.get(1),
                'V',
                GT_ModHandler.getModItem("GalaxySpace", "item.CompressedSDHD120", 1L, 0)
            });
        }

        if (Loader.isModLoaded(aTextGraviSuite)) {
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem("IC2", "itemArmorJetpackElectric", 1, GT_Values.W), bits, new Object[] {
                        "SCS",
                        "MBM",
                        "EWE",
                        'S',
                        OrePrefixes.itemCasing.get(Materials.StainlessSteel),
                        'C',
                        OrePrefixes.circuit.get(Materials.Advanced),
                        'M',
                        ItemList.Electric_Motor_HV,
                        'B',
                        GT_ModHandler.getModItem("IC2", "itemArmorBatpack", 1, GT_Values.W),
                        'W',
                        OrePrefixes.wireGt04.get(Materials.AnnealedCopper),
                        'E',
                        GT_ModHandler.getModItem(aTextGraviSuite, "itemSimpleItem", 1, 6)
                    });
            if ((Loader.isModLoaded("BuildCraft|Factory")) && (Loader.isModLoaded("adventurebackpack")))
                GT_ModHandler.addCraftingRecipe(
                        GT_ModHandler.getModItem("IC2", "itemArmorJetpack", 1, GT_Values.W), bits, new Object[] {
                            "SXS",
                            "TCT",
                            "EZE",
                            'S',
                            OrePrefixes.itemCasing.get(Materials.StainlessSteel),
                            'X',
                            OrePrefixes.circuit.get(Materials.Advanced),
                            'T',
                            GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1, 0),
                            'C',
                            GT_ModHandler.getModItem("IC2", "reactorCoolantSix", 1, 1),
                            'Z',
                            GT_ModHandler.getModItem("adventurebackpack", "backpackComponent", 1, 5),
                            'E',
                            GT_ModHandler.getModItem(aTextGraviSuite, "itemSimpleItem", 1, 6)
                        });

            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextGraviSuite, "itemSimpleItem", 1, 3));
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextGraviSuite, "itemSimpleItem", 1, 3), new Object[] {
                        "OCO",
                        "XWX",
                        "OCO",
                        'C',
                        OrePrefixes.wireGt12.get(Materials.SuperconductorLuV),
                        'X',
                        GT_ModHandler.getModItem(aTextGraviSuite, "itemSimpleItem", 1, 2),
                        'O',
                        GT_ModHandler.getModItem("IC2", "blockMachine2", 1, 1),
                        'W',
                        ItemList.Transformer_LuV_IV.get(1, o)
                    });
        }

        if (Loader.isModLoaded(aTextRailcraft)) {
            GT_Log.out.println("GT_Mod: Replacing Railcraft recipes with slightly more Oredicted variants");

            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 2L, 0), bits4, new Object[] {
                        "SPS",
                        "PdP",
                        "SPS",
                        'P',
                        OrePrefixes.plate.get(Materials.AnyIron),
                        'S',
                        OrePrefixes.screw.get(Materials.AnyIron)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 2L, 1), bits4, new Object[] {
                        "SPS",
                        "LdL",
                        "SPS",
                        'P',
                        OrePrefixes.plate.get(Materials.AnyIron),
                        'S',
                        OrePrefixes.screw.get(Materials.AnyIron),
                        'L',
                        new ItemStack(Blocks.glass_pane, 1, 32767)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 2L, 1), bits4, new Object[] {
                        "SPS",
                        "LdL",
                        "SPS",
                        'P',
                        OrePrefixes.plate.get(Materials.AnyIron),
                        'S',
                        OrePrefixes.screw.get(Materials.AnyIron),
                        'L',
                        GT_ModHandler.getModItem(aTextTConstruct, "GlassPane", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 2), bits4, new Object[] {
                        "SPS",
                        "BdB",
                        "SPS",
                        'S',
                        OrePrefixes.screw.get(Materials.AnyIron),
                        'B',
                        new ItemStack(Blocks.iron_bars, 1, 0),
                        'P',
                        OrePrefixes.pipeLarge.get(Materials.Bronze)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 3), bits4, new Object[] {
                        "PPP",
                        "ShS",
                        "PPP",
                        'P',
                        OrePrefixes.itemCasing.get(Materials.Iron),
                        'S',
                        OrePrefixes.screw.get(Materials.AnyIron)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 4), bits4, new Object[] {
                        "PPP",
                        "ShS",
                        "PPP",
                        'P',
                        OrePrefixes.itemCasing.get(Materials.Steel),
                        'S',
                        OrePrefixes.screw.get(Materials.Steel)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 5), bits, new Object[] {
                        "PCP",
                        "BFB",
                        "PUP",
                        'B',
                        new ItemStack(Blocks.brick_block),
                        'P',
                        OrePrefixes.plate.get(Materials.AnyIron),
                        'U',
                        OreDictNames.craftingIronFurnace,
                        'C',
                        new ItemStack(Items.cauldron, 1, 0),
                        'F',
                        ItemList.Casing_Firebox_Bronze
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 6), bits, new Object[] {
                        "PCP",
                        "BFB",
                        "PUP",
                        'B',
                        CustomItemList.SteelBars,
                        'P',
                        OrePrefixes.plate.get(Materials.Steel),
                        'U',
                        OreDictNames.craftingIronFurnace,
                        'C',
                        new ItemStack(Items.cauldron, 1, 0),
                        'F',
                        ItemList.Casing_Firebox_Bronze
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 7), bits4, new Object[] {
                        "BLB",
                        "SPS",
                        "GCG",
                        'B',
                        OrePrefixes.plate.get(Materials.AnyCopper),
                        'L',
                        OrePrefixes.plate.get(Materials.Lapis),
                        'S',
                        OrePrefixes.spring.get(Materials.AnyCopper),
                        'P',
                        OreDictNames.craftingPiston,
                        'G',
                        OrePrefixes.gearGt.get(Materials.AnyCopper),
                        'C',
                        GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 8), bits4, new Object[] {
                        "BLB",
                        "SPS",
                        "GCG",
                        'B',
                        OrePrefixes.plate.get(Materials.Steel),
                        'L',
                        OrePrefixes.plate.get(Materials.Lapis),
                        'S',
                        OrePrefixes.spring.get(Materials.Steel),
                        'P',
                        OreDictNames.craftingPiston,
                        'G',
                        OrePrefixes.gearGt.get(Materials.Steel),
                        'C',
                        GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 9), bits4, new Object[] {
                        "BLB",
                        "SPS",
                        "GCG",
                        'B',
                        OrePrefixes.plate.get(Materials.Aluminium),
                        'L',
                        OrePrefixes.plate.get(Materials.Lapis),
                        'S',
                        OrePrefixes.spring.get(Materials.Aluminium),
                        'P',
                        OreDictNames.craftingPiston,
                        'G',
                        OrePrefixes.gearGt.get(Materials.Aluminium),
                        'C',
                        GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 10), bits, new Object[] {
                        "PEP",
                        "GOG",
                        "OOO",
                        'P',
                        OrePrefixes.plate.get(Materials.Obsidian),
                        'E',
                        OrePrefixes.gem.get(Materials.EnderPearl),
                        'O',
                        OrePrefixes.stone.get(Materials.Obsidian),
                        'G',
                        OrePrefixes.plate.get(Materials.Gold),
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 11), bits4, new Object[] {
                        "SPS",
                        "PRP",
                        "SPS",
                        'S',
                        OrePrefixes.screw.get(Materials.Steel),
                        'P',
                        OrePrefixes.plate.get(Materials.Obsidian),
                        'R',
                        GT_ModHandler.getModItem("ExtraUtilities", "trashcan", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 2L, 13), bits4, new Object[] {
                        "SPS",
                        "PdP",
                        "SPS",
                        'P',
                        OrePrefixes.plate.get(Materials.Steel),
                        'S',
                        OrePrefixes.screw.get(Materials.Steel)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 2L, 14), bits4, new Object[] {
                        "SPS",
                        "LdL",
                        "SPS",
                        'P',
                        OrePrefixes.plate.get(Materials.Steel),
                        'S',
                        OrePrefixes.screw.get(Materials.Steel),
                        'L',
                        new ItemStack(Blocks.glass_pane, 1, 32767)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 2L, 14), bits4, new Object[] {
                        "SPS",
                        "LdL",
                        "SPS",
                        'P',
                        OrePrefixes.plate.get(Materials.Steel),
                        'S',
                        OrePrefixes.screw.get(Materials.Steel),
                        'L',
                        GT_ModHandler.getModItem(aTextTConstruct, "GlassPane", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 15), bits4, new Object[] {
                        "SPS",
                        "BdB",
                        "SPS",
                        'S',
                        OrePrefixes.screw.get(Materials.Steel),
                        'B',
                        CustomItemList.SteelBars,
                        'P',
                        OrePrefixes.pipeLarge.get(Materials.Steel)
                    });

            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 2L, 1), bits, new Object[] {
                        "CSC",
                        "SwS",
                        "CSC",
                        'S',
                        ItemList.Casing_SolidSteel,
                        'C',
                        GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 4)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 2), bits, new Object[] {
                        "IOI",
                        "GEG",
                        "IOI",
                        'G',
                        OrePrefixes.plateDouble.get(Materials.Gold),
                        'I',
                        OrePrefixes.plate.get(Materials.Emerald),
                        'E',
                        OrePrefixes.gem.get(Materials.EnderPearl),
                        'O',
                        OrePrefixes.plate.get(Materials.Obsidian)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 4L, 3), bits, new Object[] {
                        "CSC",
                        "SHS",
                        "CSC",
                        'C',
                        GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 4),
                        'S',
                        ItemList.Casing_Firebox_Steel,
                        'H',
                        ItemList.Machine_HP_Furnace
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 5), bits, new Object[] {
                        "PBP",
                        "PwP",
                        "LHW",
                        'P',
                        OrePrefixes.plate.get(Materials.Steel),
                        'H',
                        GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 4),
                        'B',
                        new ItemStack(Blocks.iron_bars, 1, 0),
                        'L',
                        new ItemStack(Items.lava_bucket, 1, 0),
                        'W',
                        new ItemStack(Items.water_bucket, 1, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 6), bits, new Object[] {
                        "SGS",
                        "EDE",
                        "SGS",
                        'E',
                        OrePrefixes.plate.get(Materials.Emerald),
                        'S',
                        OrePrefixes.plate.get(Materials.Steel),
                        'G',
                        new ItemStack(Blocks.glass_pane, 1, 32767),
                        'D',
                        new ItemStack(Blocks.dispenser, 1, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 8), bits, new Object[] {
                        "GPG",
                        "PXP",
                        "hCf",
                        'P',
                        OreDictNames.craftingPiston,
                        'G',
                        OrePrefixes.gear.get(Materials.Iron),
                        'C',
                        GT_ModHandler.getModItem(aTextForestry, "factory2", 1L, 2),
                        'X',
                        GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 9), bits, new Object[] {
                        "PBP",
                        "PDP",
                        "PPP",
                        'B',
                        new ItemStack(Blocks.iron_bars, 1, 0),
                        'P',
                        OrePrefixes.plate.get(Materials.Steel),
                        'D',
                        new ItemStack(Blocks.dispenser, 1, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 10), bits, new Object[] {
                        " h ",
                        "SHS",
                        "PDP",
                        'S',
                        OrePrefixes.stick.get(Materials.RedAlloy),
                        'H',
                        GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 9),
                        'D',
                        GT_ModHandler.getModItem(aTextRailcraft, "detector", 1L, 1),
                        'P',
                        OrePrefixes.plate.get(Materials.Steel)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 11), bits, new Object[] {
                        "PCP",
                        "CSC",
                        "PCP",
                        'P',
                        OrePrefixes.plate.get(Materials.Wood),
                        'S',
                        OrePrefixes.plate.get(Materials.Steel),
                        'C',
                        new ItemStack(Items.golden_carrot, 1, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 13), bits, new Object[] {
                        "IOI",
                        "GEG",
                        "IOI",
                        'G',
                        OrePrefixes.plateDouble.get(Materials.Steel),
                        'I',
                        OrePrefixes.plate.get(Materials.Diamond),
                        'E',
                        OrePrefixes.gem.get(Materials.EnderPearl),
                        'O',
                        OrePrefixes.plateDense.get(Materials.Obsidian)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 14), bits, new Object[] {
                        "PPP",
                        "IhI",
                        "PSP",
                        'P',
                        OrePrefixes.plank.get(Materials.Wood),
                        'I',
                        OrePrefixes.stick.get(Materials.AnyIron),
                        'S',
                        ItemList.IC2_Resin.get(1L, o)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 2L, 14), bits4, new Object[] {
                        "PPP",
                        "IhI",
                        "PSP",
                        'P',
                        OrePrefixes.plank.get(Materials.Wood),
                        'I',
                        OrePrefixes.stick.get(Materials.Steel),
                        'S',
                        GT_ModHandler.getModItem(aTextTConstruct, "slime.gel", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 2L, 14), bits4, new Object[] {
                        "PPP",
                        "IhI",
                        "PSP",
                        'P',
                        OrePrefixes.plank.get(Materials.Wood),
                        'I',
                        OrePrefixes.stick.get(Materials.Steel),
                        'S',
                        GT_ModHandler.getModItem(aTextTConstruct, "slime.gel", 1L, 1)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 4L, 14), bits4, new Object[] {
                        "PPP",
                        "IhI",
                        "PSP",
                        'P',
                        OrePrefixes.plank.get(Materials.Wood),
                        'I',
                        OrePrefixes.stick.get(Materials.StainlessSteel),
                        'S',
                        GT_ModHandler.getModItem(aTextTConstruct, "slime.gel", 1L, 2)
                    });

            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "tool.crowbar", 1L, 0),
                    bits,
                    new Object[] {"hDS", "DSD", "SDf", 'S', OrePrefixes.stick.get(Materials.Iron), 'D', Dyes.dyeRed});
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "tool.crowbar.reinforced", 1L, 0),
                    bits,
                    new Object[] {"hDS", "DSD", "SDf", 'S', OrePrefixes.stick.get(Materials.Steel), 'D', Dyes.dyeRed});
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "tool.whistle.tuner", 1L, 0),
                    bits | GT_ModHandler.RecipeBits.MIRRORED,
                    new Object[] {"ShS", "SSS", " Sh", 'S', OrePrefixes.stick.get(Materials.Iron)});
            GT_ModHandler.addShapelessCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "part.turbine.blade", 1L, 0),
                    bits,
                    new Object[] {GT_ModHandler.getIC2Item("steelshaft", 1)});
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "part.turbine.disk", 1L, 0), bits, new Object[] {
                        "SSS",
                        "SBS",
                        "SSS",
                        'B',
                        OrePrefixes.block.get(Materials.Steel),
                        'S',
                        GT_ModHandler.getModItem(aTextRailcraft, "part.turbine.blade", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "part.turbine.rotor", 1L, 0), bits, new Object[] {
                        "SSS", " w ", 'S', GT_ModHandler.getModItem(aTextRailcraft, "part.turbine.disk", 1L, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "borehead.iron", 1L, 0), bits, new Object[] {
                        "GPG",
                        "PBP",
                        "GPG",
                        'B',
                        OrePrefixes.block.get(Materials.Iron),
                        'G',
                        OrePrefixes.gear.get(Materials.Iron),
                        'P',
                        OrePrefixes.plate.get(Materials.Iron)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "borehead.steel", 1L, 0), bits, new Object[] {
                        "GPG",
                        "PBP",
                        "GPG",
                        'B',
                        OrePrefixes.block.get(Materials.Steel),
                        'G',
                        OrePrefixes.gear.get(Materials.Steel),
                        'P',
                        OrePrefixes.plate.get(Materials.Steel)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "borehead.diamond", 1L, 0),
                    bits,
                    new Object[] {"DD ", 'D', ItemList.Component_Grinder_Diamond});
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "cart.loco.steam.solid", 1L, 0), bits, new Object[] {
                        "TTh",
                        "TTX",
                        "BCZ",
                        'C',
                        new ItemStack(Items.minecart, 1),
                        'X',
                        ItemList.Machine_Steel_Boiler,
                        'Z',
                        new ItemStack(Items.chest_minecart, 1),
                        'T',
                        GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 4),
                        'F',
                        GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 5),
                        'B',
                        new ItemStack(Blocks.iron_bars, 1, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "cart.loco.electric", 1L, 0), bits, new Object[] {
                        "LFB",
                        "MCM",
                        "WTW",
                        'L',
                        GT_ModHandler.getModItem("computronics", "computronics.colorfulLamp", 1L, 0),
                        'F',
                        GT_ModHandler.getModItem(aTextRailcraft, "machine.epsilon", 1L, 0),
                        'B',
                        ItemList.Casing_SolidSteel,
                        'M',
                        ItemList.Electric_Motor_MV,
                        'C',
                        GT_ModHandler.getIC2Item("coil", 1L),
                        'W',
                        ItemList.Component_Minecart_Wheels_Steel,
                        'T',
                        new ItemStack(Items.minecart, 1, 0)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "cart.bore", 1L, 0), bits, new Object[] {
                        "FCF",
                        "BCB",
                        "hTw",
                        'C',
                        new ItemStack(Items.minecart, 1),
                        'T',
                        new ItemStack(Items.chest_minecart, 1),
                        'F',
                        ItemList.Hull_HP,
                        'B',
                        ItemList.Machine_Steel_Boiler
                    });

            GT_ModHandler.addRollingMachineRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "post.metal.light.blue", 8L), new Object[] {
                        aTextIron2,
                        " X ",
                        aTextIron2,
                        'X',
                        OrePrefixes.stick.get(Materials.Aluminium).toString()
                    });
            GT_ModHandler.addRollingMachineRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "post.metal.purple", 64L), new Object[] {
                        aTextIron2,
                        " X ",
                        aTextIron2,
                        'X',
                        OrePrefixes.stick.get(Materials.Titanium).toString()
                    });
            GT_ModHandler.addRollingMachineRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "post.metal.black", 64L), new Object[] {
                        aTextIron2,
                        " X ",
                        aTextIron2,
                        'X',
                        OrePrefixes.stick.get(Materials.Tungsten).toString()
                    });
            GT_ModHandler.addRollingMachineRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "post.metal.light.blue", 8L), new Object[] {
                        aTextIron1,
                        aTextIron2,
                        aTextIron1,
                        'X',
                        OrePrefixes.stick.get(Materials.Aluminium).toString()
                    });
            GT_ModHandler.addRollingMachineRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "post.metal.purple", 64L), new Object[] {
                        aTextIron1,
                        aTextIron2,
                        aTextIron1,
                        'X',
                        OrePrefixes.stick.get(Materials.Titanium).toString()
                    });
            GT_ModHandler.addRollingMachineRecipe(
                    GT_ModHandler.getModItem(aTextRailcraft, "post.metal.black", 64L), new Object[] {
                        aTextIron1,
                        aTextIron2,
                        aTextIron1,
                        'X',
                        OrePrefixes.stick.get(Materials.Tungsten).toString()
                    });
        }

        if (Loader.isModLoaded("Ztones")) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 8L, 0), bits, new Object[] {
                "SSS", "STS", "SSS", 'S', new ItemStack(Blocks.stone_slab, 1), 'T', new ItemStack(Blocks.stone, 1)
            });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem("Ztones", "auroraBlock", 8L, 0), bits, new Object[] {
                        "GGG",
                        "GDG",
                        "GGG",
                        'G',
                        new ItemStack(Blocks.glass, 1),
                        'D',
                        new ItemStack(Items.dye, 1, GT_Values.W)
                    });
            GT_ModHandler.addCraftingRecipe(
                    GT_ModHandler.getModItem("Ztones", "minicharcoal", 7L, 0), bits, new Object[] {
                        "T  ",
                        "C  ",
                        "   ",
                        'T',
                        ToolDictNames.craftingToolSoftHammer,
                        'C',
                        OrePrefixes.dust.get(Materials.Charcoal)
                    });
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "minicoal", 7L, 0), bits, new Object[] {
                "T  ",
                "C  ",
                "   ",
                'T',
                ToolDictNames.craftingToolSoftHammer,
                'C',
                OrePrefixes.dust.get(Materials.Coal)
            });
        }
    }
}
