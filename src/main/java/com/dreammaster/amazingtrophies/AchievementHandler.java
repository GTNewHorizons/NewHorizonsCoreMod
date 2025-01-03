package com.dreammaster.amazingtrophies;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import WayofTime.alchemicalWizardry.ModItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import fox.spiteful.avaritia.DamageSourceInfinitySword;
import fox.spiteful.avaritia.items.LudicrousItems;
import tconstruct.library.tools.ToolCore;

public class AchievementHandler {

    private static final Map<UUID, Integer> LAST_DEATHCOUNT = new HashMap<>();
    private static final Map<UUID, Float> LAST_DAMAGE = new HashMap<>();

    private static StatBase infinityArmorAchievement;
    private static StatBase omegaArmorAchievement;
    private static StatBase damageAchievement;
    public static StatBase eternityBeaconAchievement;
    private static StatBase allEffects;
    private static StatBase hearts;
    private static StatBase unbreakableTool;
    private static int numberPotions = 0;

    public static void init() {
        infinityArmorAchievement = StatList.func_151177_a("infinity_armor");
        omegaArmorAchievement = StatList.func_151177_a("omega_armor");
        damageAchievement = StatList.func_151177_a("10k_damage");
        eternityBeaconAchievement = StatList.func_151177_a("eternity_beacon");
        allEffects = StatList.func_151177_a("all_effects");
        hearts = StatList.func_151177_a("100_hearts");
        unbreakableTool = StatList.func_151177_a("unbreakable_tconstruct_tool");

        for (Potion potion : Potion.potionTypes) {
            if (potion != null && !potion.isInstant()) {
                numberPotions++;
            }
        }
    }

    @SubscribeEvent
    public void onEntityUpdate(PlayerTickEvent event) {
        if (event.side == Side.CLIENT || event.phase == Phase.START) {
            return;
        }

        EntityPlayer player = event.player;
        UUID uuid = player.getUniqueID();
        int currentDeathCount = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager()
                .func_152602_a(player).writeStat(StatList.deathsStat);
        Float lastDamage = LAST_DAMAGE.get(uuid);
        if (lastDamage != null && lastDamage >= 10000.0f && LAST_DEATHCOUNT.get(uuid) == currentDeathCount) {
            player.triggerAchievement(damageAchievement);
        }

        if (player.getActivePotionEffects().size() == numberPotions) {
            player.triggerAchievement(allEffects);
        }

        if (player.getMaxHealth() >= 200.0f) {
            player.triggerAchievement(hearts);
        }

        ItemStack[] armor = player.inventory.armorInventory;
        if (hasArmor(
                armor,
                LudicrousItems.infinity_helm,
                LudicrousItems.infinity_armor,
                LudicrousItems.infinity_pants,
                LudicrousItems.infinity_shoes)) {
            player.triggerAchievement(infinityArmorAchievement);
            return;
        }
        if (hasArmor(
                armor,
                ModItems.boundHelmetEarth,
                ModItems.boundPlateEarth,
                ModItems.boundLeggingsEarth,
                ModItems.boundBootsEarth)
                || hasArmor(
                        armor,
                        ModItems.boundHelmetFire,
                        ModItems.boundPlateFire,
                        ModItems.boundLeggingsFire,
                        ModItems.boundBootsFire)
                || hasArmor(
                        armor,
                        ModItems.boundHelmetWater,
                        ModItems.boundPlateWater,
                        ModItems.boundLeggingsWater,
                        ModItems.boundBootsWater)
                || hasArmor(
                        armor,
                        ModItems.boundHelmetWind,
                        ModItems.boundPlateWind,
                        ModItems.boundLeggingsWind,
                        ModItems.boundBootsWind)) {
            player.triggerAchievement(omegaArmorAchievement);
            return;
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onLivingHurt(LivingAttackEvent event) {
        if (!(event.entityLiving instanceof EntityPlayer player)) {
            return;
        }
        UUID uuid = player.getUniqueID();
        int deathCount = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager()
                .func_152602_a(player).writeStat(StatList.deathsStat);
        float amount = event.source instanceof DamageSourceInfinitySword ? Float.POSITIVE_INFINITY : event.ammount;
        LAST_DEATHCOUNT.put(uuid, deathCount);
        LAST_DAMAGE.put(uuid, amount);

    }

    @SubscribeEvent
    public void onItemPickup(ItemPickupEvent event) {
        ItemStack stack = event.pickedUp.getEntityItem();
        if (stack.getItem() instanceof ToolCore && stack.hasTagCompound()
                && stack.getTagCompound().getCompoundTag("InfiTool").getInteger("Unbreaking") >= 10) {
            event.player.triggerAchievement(unbreakableTool);
        }
    }

    private static boolean hasArmor(ItemStack[] armor, Item helmet, Item chestplate, Item leggins, Item boots) {
        ItemStack equippedHelmet = armor[3];
        ItemStack equippedChestplate = armor[2];
        ItemStack equippedLeggins = armor[1];
        ItemStack equippedBoots = armor[0];
        if (equippedHelmet == null || equippedChestplate == null || equippedLeggins == null || equippedBoots == null) {
            return false;
        }
        return equippedHelmet.getItem() == helmet && equippedChestplate.getItem() == chestplate
                && equippedLeggins.getItem() == leggins
                && equippedBoots.getItem() == boots;
    }

}
