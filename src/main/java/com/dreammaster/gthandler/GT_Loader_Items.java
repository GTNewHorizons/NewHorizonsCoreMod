package com.dreammaster.gthandler;

import static com.gtnewhorizon.gtnhlib.util.AnimatedTooltipHandler.addItemTooltip;
import static gregtech.client.GTTooltipHandler.Tier.*;
import static gregtech.client.GTTooltipHandler.registerTieredTooltip;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import com.dreammaster.item.NHItemList;

public class GT_Loader_Items {

    public void run() {
        registerTooltips();
    }

    private void registerTooltips() {
        registerTieredTooltip(NHItemList.PikoCircuit.get(), UMV);
        registerTieredTooltip(NHItemList.QuantumCircuit.get(), UXV);
        registerTieredTooltip(NHItemList.PlanckCircuit.get(), MAX);

        List<ItemStack> origin = Arrays.asList(
                NHItemList.ChevronOrigin.get(),
                NHItemList.FramePartOrigin.get(),
                NHItemList.GatePlateOrigin.get(),
                NHItemList.NanoCircuitOrigin.get(),
                NHItemList.StargateDustAncients.get(),
                NHItemList.StargateCrystalAncients.get());
        List<ItemStack> polychrome = Arrays.asList(
                NHItemList.PikoCircuitPolychrome.get(),
                NHItemList.QuantumCircuitPolychrome.get(),
                NHItemList.GatePlatePolychrome.get(),
                NHItemList.ChevronPolychrome.get(),
                NHItemList.FramePartPolychrome.get());
        List<ItemStack> dimensional = Arrays.asList(
                NHItemList.PikoCircuitDimensional.get(),
                NHItemList.QuantumCircuitDimensional.get(),
                NHItemList.GatePlateDimensional.get(),
                NHItemList.ChevronDimensional.get(),
                NHItemList.FramePartDimensional.get());
        List<ItemStack> harmonic = Arrays.asList(
                NHItemList.GatePlateHarmonic.get(),
                NHItemList.ChevronHarmonic.get(),
                NHItemList.FramePartHarmonic.get());
        for (ItemStack itemStack : origin) {
            addItemTooltip(
                    itemStack,
                    () -> EnumChatFormatting.YELLOW + StatCollector.translateToLocal("item.Origin.tooltip")
                            + EnumChatFormatting.RESET
                            + EnumChatFormatting.BLUE
                            + " "
                            + StatCollector.translateToLocal("item.Origin.version"));
        }

        for (ItemStack itemStack : polychrome) {
            addItemTooltip(
                    itemStack,
                    () -> EnumChatFormatting.AQUA + StatCollector.translateToLocal("item.Polychrome.tooltip")
                            + EnumChatFormatting.RESET
                            + EnumChatFormatting.BLUE
                            + " "
                            + StatCollector.translateToLocal("item.Polychrome.version"));
        }

        for (ItemStack itemStack : dimensional) {
            addItemTooltip(
                    itemStack,
                    () -> EnumChatFormatting.LIGHT_PURPLE + StatCollector.translateToLocal("item.Dimensional.tooltip")
                            + EnumChatFormatting.RESET
                            + EnumChatFormatting.BLUE
                            + " "
                            + StatCollector.translateToLocal("item.Dimensional.version"));
        }

        for (ItemStack itemStack : harmonic) {
            addItemTooltip(
                    itemStack,
                    () -> EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("item.Harmonic.tooltip")
                            + EnumChatFormatting.RESET
                            + EnumChatFormatting.BLUE
                            + " "
                            + StatCollector.translateToLocal("item.Harmonic.version"));
        }

        addItemTooltip(
                NHItemList.Compressed_Circuit_Array_Empty.get(),
                () -> StatCollector.translateToLocal("item.CircuitArray.tooltip.empty"));

        List<ItemStack> circuitArrays = Arrays.asList(
                NHItemList.Compressed_Circuit_Array_ULV.get(),
                NHItemList.Compressed_Circuit_Array_LV.get(),
                NHItemList.Compressed_Circuit_Array_MV.get(),
                NHItemList.Compressed_Circuit_Array_HV.get(),
                NHItemList.Compressed_Circuit_Array_EV.get(),
                NHItemList.Compressed_Circuit_Array_IV.get(),
                NHItemList.Compressed_Circuit_Array_LuV.get(),
                NHItemList.Compressed_Circuit_Array_ZPM.get(),
                NHItemList.Compressed_Circuit_Array_UV.get(),
                NHItemList.Compressed_Circuit_Array_UHV.get(),
                NHItemList.Compressed_Circuit_Array_UEV.get(),
                NHItemList.Compressed_Circuit_Array_UIV.get(),
                NHItemList.Compressed_Circuit_Array_UMV.get(),
                NHItemList.Compressed_Circuit_Array_UXV.get(),
                NHItemList.Compressed_Circuit_Array_MAX.get());

        for (int i = 0; i < circuitArrays.size(); i++) {
            int num = i;
            addItemTooltip(
                    circuitArrays.get(i),
                    () -> StatCollector.translateToLocal("item.CircuitArray.tooltip." + num));
        }
    }
}
