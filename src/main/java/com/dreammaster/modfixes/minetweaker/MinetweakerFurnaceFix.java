package com.dreammaster.modfixes.minetweaker;

import net.minecraftforge.event.FuelBurnTimeEvent;

import com.dreammaster.modfixes.ModFixBase;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Rio on 4/8/2018.
 */
public class MinetweakerFurnaceFix extends ModFixBase {

    public MinetweakerFurnaceFix() {
        super("MinetweakerFurnaceFix");
    }

    @Override
    public boolean needsForgeEventBus() {
        return true;
    }

    @Override
    public boolean needsFMLEventBus() {
        return false;
    }

    @Override
    public boolean getIsActive() {
        return true;
    }

    @Override
    public boolean init() {
        return true;
    }

    @SubscribeEvent
    public void onFuelBurnTime(FuelBurnTimeEvent event) {
        /*
         * Minetweaker's feature to change fuel burn values is implemented through an `IFuelHandler` which is forcibly
         * registered with GameRegistry as the only fuel handler. However, the vanilla Furnace code always checks a
         * small hardcoded list of fuels (including a check for `material == WOOD`) before calling the `IFuelHandler`.
         * Before checking the hardcoded list, the Furnace is patched by Forge to obey any result returned by a
         * `FuelBurnTimeEvent`, allowing the event handler to override the vanilla handling. This event handler simply
         * delegates the fuel value to Minetweaker's `IFuelHandler`, which will be the only fuel handler registered, by
         * simply calling `GameRegistry.getFuelValue`. In turn, this fuel handler will delegate to this mod's
         * `CustomFuelsHandler` if no MT script changes the fuel value for the item.
         */
        int burnTime = GameRegistry.getFuelValue(event.fuel);
        if (burnTime > 0) {
            event.burnTime = burnTime;
            event.setResult(Event.Result.ALLOW);
        }
    }
}
