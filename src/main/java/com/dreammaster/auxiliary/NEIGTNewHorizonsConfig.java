package com.dreammaster.auxiliary;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static gregtech.api.enums.Mods.*;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;

import codechicken.nei.api.IConfigureNEI;
import gregtech.api.util.GTModHandler;

public class NEIGTNewHorizonsConfig implements IConfigureNEI {

    @Override
    public void loadConfig() {

        if (EnderIO.isModLoaded()) {
            ItemStack creativeBank = GTModHandler.getModItem(EnderIO.ID, "blockCapBank", 1, 0, missing);
            creativeBank.setTagInfo("type", new NBTTagString("CREATIVE"));
            creativeBank.setTagInfo("storedEnergyRF", new NBTTagInt(2500000));
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
