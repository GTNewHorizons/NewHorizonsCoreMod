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

import gregtech.api.enums.SubTag;
import gregtech.common.items.MetaGeneratedItem01;

public class GT_Loader_Items {

    public void run() {
        registerTooltips();
    }

    private void registerTooltips() {
        registerTieredTooltip(NHItemList.PikoCircuit.get(), UMV);
        registerTieredTooltip(NHItemList.QuantumCircuit.get(), UXV);

        // FIXME: Implement these tooltips in a way that will be correctly translated if the language changes mid-game.
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
    }
}
