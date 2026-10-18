package com.dreammaster.auxiliary;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.*;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;
import com.dreammaster.scripts.ScriptOpenComputers;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIGTNewHorizonsConfig implements IConfigureNEI {

    @Override
    public void loadConfig() {

        if (EnderIO.isModLoaded()) {
            ItemStack creativeBank = getModItem(EnderIO.ID, "blockCapBank", 1, 0);
            creativeBank.setTagInfo("type", new NBTTagString("CREATIVE"));
            creativeBank.setTagInfo("storedEnergyRF", new NBTTagInt(2500000));
        }

        if (OpenComputers.isModLoaded()) {
            for (long rate : ScriptOpenComputers.TRANSPOSER_RATES) {
                ItemStack stack = ScriptOpenComputers.getTransposer(1, rate);
                API.addItemVariant(stack.getItem(), stack);
            }
        }

        MainRegistry.LOGGER.info("Added NEI Config");
    }

    @Override
    public String getName() {
        return "GTNewHorizons-NEIConfig";
    }

    @Override
    public String getVersion() {
        return Refstrings.VERSION;
    }
}
