package com.dreammaster.modfixes.thaumcraft;

import com.dreammaster.modfixes.ModFixBase;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import thaumcraft.common.tiles.TileArcaneWorkbench;

public class ReuseWardFocusFix extends ModFixBase {
    private ItemStack wardedGlass, focusWard;

    public ReuseWardFocusFix() {
        super("ReuseWardFocusFix");
    }

    @Override
    public boolean needsForgeEventBus() {
        return false;
    }

    @Override
    public boolean needsFMLEventBus() {
        return true;
    }

    @Override
    public boolean getIsActive() {
        return wardedGlass != null && focusWard != null;
    }

    @Override
    public boolean init() {
        Block wardedGlassBlock = GameRegistry.findBlock("Thaumcraft", "blockCosmeticOpaque");
        if (wardedGlassBlock == null)
            return false;
        wardedGlass = new ItemStack(wardedGlassBlock, 1, 2);
        return (focusWard = GameRegistry.findItemStack("Thaumcraft", "FocusWarding", 2)) != null;
    }

    @SubscribeEvent
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent e) {
        if (getIsActive()) {
            if (e.craftMatrix instanceof TileArcaneWorkbench && wardedGlass.isItemEqual(e.crafting)) {
                for (int i = 0; i < 9; i++) {
                    if (focusWard.isItemEqual(e.craftMatrix.getStackInSlot(i))) {
                        // just a copy is enough. the max stack size is 1 and we got a stack with size 2
                        // later TC code will decrease the stack size back to one
                        // therefore setting it to this stack will be effectively the same as not consuming
                        ((TileArcaneWorkbench) e.craftMatrix).setInventorySlotContentsSoftly(i, focusWard.copy());
                    }
                }
            }
        }
    }
}
