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
        GT = MetaGeneratedItem01.INSTANCE;
        registerItems();
        registerTooltips();
    }

    private MetaGeneratedItem01 GT;

    private void registerItems() {
        // ID Range: 600 - 699
        // Ingame offset: 32000

        // 600 - 609 Motors
        // 610 - 619 Pumps
        // 620 - 629 Rotors (Unused now, but don't re-use these IDs. Might cause world corruption)
        // 630 - 639 Conveyors
        // 640 - 649 Pistons
        // 650 - 659 Robot Arms
        // 660 - 664 Fluid Regulators
        // 670 - 679 Field Generators
        // 680 - 689 Emitters
        // 690 - 699 Sensors

        // CoreMod Items
        CustomItemList.EtchedLowVoltageWiring.set(NHItemList.EtchedLowVoltageWiring.get());
        CustomItemList.EtchedInsaneVoltageWiring.set(NHItemList.EtchedInsaneVoltageWiring.get());
        CustomItemList.EtchedLudicrousVoltageWiring.set(NHItemList.EtchedLudicrousVoltageWiring.get());
        CustomItemList.SteelBars.set(NHItemList.SteelBars.get());
        CustomItemList.AluminiumBars.set(NHItemList.AluminiumBars.get());
        CustomItemList.StainlessSteelBars.set(NHItemList.StainlessSteelBars.get());
        CustomItemList.TungstenBars.set(NHItemList.TungstenBars.get());
        CustomItemList.TungstenSteelBars.set(NHItemList.TungstenSteelBars.get());
        CustomItemList.IridiumBars.set(NHItemList.IridiumBars.get());
        CustomItemList.OsmiumBars.set(NHItemList.OsmiumBars.get());
        CustomItemList.ChromeBars.set(NHItemList.ChromeBars.get());
        CustomItemList.TitaniumBars.set(NHItemList.TitaniumBars.get());
        CustomItemList.NeutroniumBars.set(NHItemList.NeutroniumBars.get());
        CustomItemList.RedstoneAlloyBars.set(NHItemList.RedstoneAlloyBars.get());
        CustomItemList.ElectricalSteelBars.set(NHItemList.ElectricalSteelBars.get());
        CustomItemList.ConductiveIronBars.set(NHItemList.ConductiveIronBars.get());
        CustomItemList.EnergeticAlloyBars.set(NHItemList.EnergeticAlloyBars.get());
        CustomItemList.VibrantAlloyBars.set(NHItemList.VibrantAlloyBars.get());
        CustomItemList.PulsatingIronBars.set(NHItemList.PulsatingIronBars.get());
        CustomItemList.SoulariumBars.set(NHItemList.SoulariumBars.get());
        CustomItemList.EnderiumBaseBars.set(NHItemList.EnderiumBaseBars.get());
        CustomItemList.EnderiumBars.set(NHItemList.EnderiumBars.get());
        CustomItemList.NagaScaleChip.set(NHItemList.NagaScaleChip.get());
        CustomItemList.NagaScaleFragment.set(NHItemList.NagaScaleFragment.get());
        CustomItemList.LichBoneChip.set(NHItemList.LichBoneChip.get());
        CustomItemList.LichBoneFragment.set(NHItemList.LichBoneFragment.get());
        CustomItemList.LichBone.set(NHItemList.LichBone.get());
        CustomItemList.FieryBloodDrop.set(NHItemList.FieryBloodDrop.get());
        CustomItemList.CarminiteChip.set(NHItemList.CarminiteChip.get());
        CustomItemList.CarminiteFragment.set(NHItemList.CarminiteFragment.get());
        CustomItemList.SnowQueenBloodDrop.set(NHItemList.SnowQueenBloodDrop.get());
        CustomItemList.SnowQueenBlood.set(NHItemList.SnowQueenBlood.get());
        CustomItemList.AdvancedBoard.set(NHItemList.AdvancedBoard.get());
        CustomItemList.AdvancedProcessorBoard.set(NHItemList.AdvancedProcessorBoard.get());
        CustomItemList.HighEnergyFlowCircuit.set(NHItemList.HighEnergyFlowCircuit.get());
        CustomItemList.NanoCircuit.set(NHItemList.NanoCircuit.get());
        CustomItemList.PikoCircuit.set(NHItemList.PikoCircuit.get());
        CustomItemList.QuantumCircuit.set(NHItemList.QuantumCircuit.get());
        CustomItemList.CarbonPartBoots.set(NHItemList.CarbonPartBoots.get());
        CustomItemList.CarbonPartChestplate.set(NHItemList.CarbonPartChestplate.get());
        CustomItemList.CarbonPartHelmet.set(NHItemList.CarbonPartHelmet.get());
        CustomItemList.CarbonPartHelmetNightVision.set(NHItemList.CarbonPartHelmetNightVision.get());
        CustomItemList.CarbonPartLeggings.set(NHItemList.CarbonPartLeggings.get());
        CustomItemList.NanoRubberBoots.set(NHItemList.NanoRubberBoots.get());
        CustomItemList.NanoChestJetPack.set(NHItemList.NanoChestJetPack.get());
        CustomItemList.NanoPlatedLeggings.set(NHItemList.NanoPlatedLeggings.get());
        CustomItemList.NanoScubaHelmet.set(NHItemList.NanoScubaHelmet.get());
        CustomItemList.QuantumPartBoots.set(NHItemList.QuantumPartBoots.get());
        CustomItemList.QuantumPartChestplate.set(NHItemList.QuantumPartChestplate.get());
        CustomItemList.QuantumPartHelmetEmpty.set(NHItemList.QuantumPartHelmetEmpty.get());
        CustomItemList.QuantumPartHelmet.set(NHItemList.QuantumPartHelmet.get());
        CustomItemList.QuantumPartLeggings.set(NHItemList.QuantumPartLeggings.get());
        CustomItemList.HeavyDutyAlloyIngotT4.set(NHItemList.HeavyDutyAlloyIngotT4.get());
        CustomItemList.HeavyDutyAlloyIngotT5.set(NHItemList.HeavyDutyAlloyIngotT5.get());
        CustomItemList.HeavyDutyAlloyIngotT6.set(NHItemList.HeavyDutyAlloyIngotT6.get());
        CustomItemList.HeavyDutyAlloyIngotT7.set(NHItemList.HeavyDutyAlloyIngotT7.get());
        CustomItemList.HeavyDutyAlloyIngotT8.set(NHItemList.HeavyDutyAlloyIngotT8.get());
        CustomItemList.HeavyDutyAlloyIngotT9.set(NHItemList.HeavyDutyAlloyIngotT9.get());
        CustomItemList.HighEnergyCircuitParts.set(NHItemList.HighEnergyCircuitParts.get());
        CustomItemList.EngravedDiamondCrystalChip.set(NHItemList.EngravedDiamondCrystalChip.get());
        CustomItemList.EngravedEnergyChip.set(NHItemList.EngravedEnergyChip.get());
        CustomItemList.NanoBoard.set(NHItemList.NanoBoard.get());
        CustomItemList.NanoCrystal.set(NHItemList.NanoCrystal.get());
        CustomItemList.NanoProcessorBoard.set(NHItemList.NanoProcessorBoard.get());
        CustomItemList.QuantumBoard.set(NHItemList.QuantumBoard.get());
        CustomItemList.QuantumProcessorBoard.set(NHItemList.QuantumProcessorBoard.get());
        CustomItemList.EngravedQuantumChip.set(NHItemList.EngravedQuantumChip.get());
        CustomItemList.IridiumAlloyItemCasing.set(NHItemList.IridiumAlloyItemCasing.get());
        CustomItemList.ReinforcedGlassPLate.set(NHItemList.ReinforcedGlassPlate.get());
        CustomItemList.ReinforcedGlassLense.set(NHItemList.ReinforcedGlassLense.get());
        CustomItemList.MarshmallowForm.set(NHItemList.MarshmallowForm.get());
        CustomItemList.MarshmallowFormMold.set(NHItemList.MarshmallowFormMold.get());
        CustomItemList.UncookedSlush.set(NHItemList.UncookedSlush.get());
        CustomItemList.MalformedSlush.set(NHItemList.MalformedSlush.get());
        CustomItemList.GlowingMarshmallow.set(NHItemList.GlowingMarshmallow.get());
        CustomItemList.Marshmallow.set(NHItemList.Marshmallow.get());
        CustomItemList.MoldHelmet.set(NHItemList.MoldHelmet.get());
        CustomItemList.MoldChestplate.set(NHItemList.MoldChestplate.get());
        CustomItemList.MoldLeggings.set(NHItemList.MoldLeggings.get());
        CustomItemList.MoldBoots.set(NHItemList.MoldBoots.get());
        CustomItemList.IchoriumCap.set(NHItemList.IchoriumCap.get());
        CustomItemList.CoinDarkWizard.set(NHItemList.CoinDarkWizard.get());
        CustomItemList.CoinDarkWizardI.set(NHItemList.CoinDarkWizardI.get());
        CustomItemList.CoinDarkWizardII.set(NHItemList.CoinDarkWizardII.get());
        CustomItemList.CoinDarkWizardIII.set(NHItemList.CoinDarkWizardIII.get());
        CustomItemList.CoinDarkWizardIV.set(NHItemList.CoinDarkWizardIV.get());
        CustomItemList.CoinTechnician.set(NHItemList.CoinTechnician.get());
        CustomItemList.CoinTechnicianI.set(NHItemList.CoinTechnicianI.get());
        CustomItemList.CoinTechnicianII.set(NHItemList.CoinTechnicianII.get());
        CustomItemList.CoinTechnicianIII.set(NHItemList.CoinTechnicianIII.get());
        CustomItemList.CoinTechnicianIV.set(NHItemList.CoinTechnicianIV.get());
        CustomItemList.CoinAdventure.set(NHItemList.CoinAdventure.get());
        CustomItemList.CoinAdventureI.set(NHItemList.CoinAdventureI.get());
        CustomItemList.CoinAdventureII.set(NHItemList.CoinAdventureII.get());
        CustomItemList.CoinAdventureIII.set(NHItemList.CoinAdventureIII.get());
        CustomItemList.CoinAdventureIV.set(NHItemList.CoinAdventureIV.get());
        CustomItemList.CoinBees.set(NHItemList.CoinBees.get());
        CustomItemList.CoinBeesI.set(NHItemList.CoinBeesI.get());
        CustomItemList.CoinBeesII.set(NHItemList.CoinBeesII.get());
        CustomItemList.CoinBeesIII.set(NHItemList.CoinBeesIII.get());
        CustomItemList.CoinBeesIV.set(NHItemList.CoinBeesIV.get());
        CustomItemList.CoinBlood.set(NHItemList.CoinBlood.get());
        CustomItemList.CoinBloodI.set(NHItemList.CoinBloodI.get());
        CustomItemList.CoinBloodII.set(NHItemList.CoinBloodII.get());
        CustomItemList.CoinBloodIII.set(NHItemList.CoinBloodIII.get());
        CustomItemList.CoinBloodIV.set(NHItemList.CoinBloodIV.get());
        CustomItemList.CoinFarmer.set(NHItemList.CoinFarmer.get());
        CustomItemList.CoinFarmerI.set(NHItemList.CoinFarmerI.get());
        CustomItemList.CoinFarmerII.set(NHItemList.CoinFarmerII.get());
        CustomItemList.CoinFarmerIII.set(NHItemList.CoinFarmerIII.get());
        CustomItemList.CoinFarmerIV.set(NHItemList.CoinFarmerIV.get());
        CustomItemList.CoinForestry.set(NHItemList.CoinForestry.get());
        CustomItemList.CoinForestryI.set(NHItemList.CoinForestryI.get());
        CustomItemList.CoinForestryII.set(NHItemList.CoinForestryII.get());
        CustomItemList.CoinForestryIII.set(NHItemList.CoinForestryIII.get());
        CustomItemList.CoinForestryIV.set(NHItemList.CoinForestryIV.get());
        CustomItemList.CoinSurvivor.set(NHItemList.CoinSurvivor.get());
        CustomItemList.CoinSurvivorI.set(NHItemList.CoinSurvivorI.get());
        CustomItemList.CoinSurvivorII.set(NHItemList.CoinSurvivorII.get());
        CustomItemList.CoinSurvivorIII.set(NHItemList.CoinSurvivorIII.get());
        CustomItemList.CoinSurvivorIV.set(NHItemList.CoinSurvivorIV.get());
        CustomItemList.CoinSpace.set(NHItemList.CoinSpace.get());
        CustomItemList.CoinSpaceI.set(NHItemList.CoinSpaceI.get());
        CustomItemList.CoinSpaceII.set(NHItemList.CoinSpaceII.get());
        CustomItemList.CoinSpaceIII.set(NHItemList.CoinSpaceIII.get());
        CustomItemList.CoinSpaceIV.set(NHItemList.CoinSpaceIV.get());
        CustomItemList.CoinChunkloaderTierI.set(NHItemList.CoinChunkloaderTierI.get());
        CustomItemList.CoinChunkloaderTierI.getItem().setMaxStackSize(4);
        CustomItemList.CoinChunkloaderTierII.set(NHItemList.CoinChunkloaderTierII.get());
        CustomItemList.CoinChunkloaderTierII.getItem().setMaxStackSize(4);
        CustomItemList.CoinChunkloaderTierIII.set(NHItemList.CoinChunkloaderTierIII.get());
        CustomItemList.CoinChunkloaderTierIII.getItem().setMaxStackSize(4);
        CustomItemList.CoinChunkloaderTierIV.set(NHItemList.CoinChunkloaderTierIV.get());
        CustomItemList.CoinChunkloaderTierIV.getItem().setMaxStackSize(4);
        CustomItemList.CoinChunkloaderTierV.set(NHItemList.CoinChunkloaderTierV.get());
        CustomItemList.CoinChunkloaderTierV.getItem().setMaxStackSize(4);
        CustomItemList.CoinChemist.set(NHItemList.CoinChemist.get());
        CustomItemList.CoinChemistI.set(NHItemList.CoinChemistI.get());
        CustomItemList.CoinChemistII.set(NHItemList.CoinChemistII.get());
        CustomItemList.CoinChemistIII.set(NHItemList.CoinChemistIII.get());
        CustomItemList.CoinChemistIV.set(NHItemList.CoinChemistIV.get());
        CustomItemList.CoinCook.set(NHItemList.CoinCook.get());
        CustomItemList.CoinCookI.set(NHItemList.CoinCookI.get());
        CustomItemList.CoinCookII.set(NHItemList.CoinCookII.get());
        CustomItemList.CoinCookIII.set(NHItemList.CoinCookIII.get());
        CustomItemList.CoinCookIV.set(NHItemList.CoinCookIV.get());
        CustomItemList.CoinBlank.set(NHItemList.CoinBlank.get());
        CustomItemList.CoinBlankI.set(NHItemList.CoinBlankI.get());
        CustomItemList.CoinBlankII.set(NHItemList.CoinBlankII.get());
        CustomItemList.CoinBlankIII.set(NHItemList.CoinBlankIII.get());
        CustomItemList.CoinBlankIV.set(NHItemList.CoinBlankIV.get());
        CustomItemList.CoinSmith.set(NHItemList.CoinSmith.get());
        CustomItemList.CoinSmithI.set(NHItemList.CoinSmithI.get());
        CustomItemList.CoinSmithII.set(NHItemList.CoinSmithII.get());
        CustomItemList.CoinSmithIII.set(NHItemList.CoinSmithIII.get());
        CustomItemList.CoinSmithIV.set(NHItemList.CoinSmithIV.get());
        CustomItemList.CoinWitch.set(NHItemList.CoinWitch.get());
        CustomItemList.CoinWitchI.set(NHItemList.CoinWitchI.get());
        CustomItemList.CoinWitchII.set(NHItemList.CoinWitchII.get());
        CustomItemList.CoinWitchIII.set(NHItemList.CoinWitchIII.get());
        CustomItemList.CoinWitchIV.set(NHItemList.CoinWitchIV.get());
        CustomItemList.CoinFlower.set(NHItemList.CoinFlower.get());
        CustomItemList.CoinFlowerI.set(NHItemList.CoinFlowerI.get());
        CustomItemList.CoinFlowerII.set(NHItemList.CoinFlowerII.get());
        CustomItemList.CoinFlowerIII.set(NHItemList.CoinFlowerIII.get());
        CustomItemList.CoinFlowerIV.set(NHItemList.CoinFlowerIV.get());
        CustomItemList.CoinDonation.set(NHItemList.CoinDonation.get());
        CustomItemList.WetTofu.set(NHItemList.WetTofu.get());
        CustomItemList.NetherStarFragment.set(NHItemList.NetherStarFragment.get());
        CustomItemList.WeakOrb.set(NHItemList.WeakOrb.get());
        CustomItemList.ApprenticeOrb.set(NHItemList.ApprenticeOrb.get());
        CustomItemList.MasterOrb.set(NHItemList.MasterOrb.get());
        CustomItemList.MagicianOrb.set(NHItemList.MagicianOrb.get());
        CustomItemList.ArchmageOrb.set(NHItemList.ArchmageOrb.get());
        CustomItemList.TranscendentOrb.set(NHItemList.TranscendentOrb.get());
        CustomItemList.ArcaneSlate.set(NHItemList.ArcaneSlate.get());
        CustomItemList.RawOrbTier1.set(NHItemList.RawOrbTier1.get());
        CustomItemList.RawOrbTier2.set(NHItemList.RawOrbTier2.get());
        CustomItemList.RawOrbTier3.set(NHItemList.RawOrbTier3.get());
        CustomItemList.RawOrbTier4.set(NHItemList.RawOrbTier4.get());
        CustomItemList.RawOrbTier5.set(NHItemList.RawOrbTier5.get());
        CustomItemList.RawOrbTier6.set(NHItemList.RawOrbTier6.get());
        CustomItemList.TeleposerFrame.set(NHItemList.TeleposerFrame.get());
        CustomItemList.MysteriousCrystal.set(NHItemList.MysteriousCrystal.get());
        CustomItemList.WoodenCasing.set(NHItemList.WoodenCasing.get());
        CustomItemList.EssentiaCircuit.set(NHItemList.EssentiaCircuit.get());
        CustomItemList.EngineeringProcessorEssentiaPulsatingCore
                .set(NHItemList.EngineeringProcessorEssentiaPulsatingCore.get());
        CustomItemList.ManyullynCrystal.set(NHItemList.ManyullynCrystal.get());
        CustomItemList.SchematicsAstroMiner.set(NHItemList.SchematicsAstroMiner.get());
        CustomItemList.SchematicsCargoRocket.set(NHItemList.SchematicsCargoRocket.get());
        CustomItemList.SchematicsMoonBuggy.set(NHItemList.SchematicsMoonBuggy.get());
        CustomItemList.SchematicsTier1.set(NHItemList.SchematicsTier1.get());
        CustomItemList.SchematicsTier2.set(NHItemList.SchematicsTier2.get());
        CustomItemList.SchematicsTier3.set(NHItemList.SchematicsTier3.get());
        CustomItemList.SchematicsTier4.set(NHItemList.SchematicsTier4.get());
        CustomItemList.SchematicsTier5.set(NHItemList.SchematicsTier5.get());
        CustomItemList.SchematicsTier6.set(NHItemList.SchematicsTier6.get());
        CustomItemList.SchematicsTier7.set(NHItemList.SchematicsTier7.get());
        CustomItemList.SchematicsTier8.set(NHItemList.SchematicsTier8.get());
        CustomItemList.RawSDHCAlloy.set(NHItemList.RawSDHCAlloy.get());
        CustomItemList.TungstenString.set(NHItemList.TungstenString.get());
        CustomItemList.MeteoricIronString.set(NHItemList.MeteoricIronString.get());
        CustomItemList.BlackPlutoniumCompressedPlate.set(NHItemList.BlackPlutoniumCompressedPlate.get());
        CustomItemList.DeshDualCompressedPlates.set(NHItemList.DeshDualCompressedPlates.get());
        CustomItemList.TitaniumDualCompressedPlates.set(NHItemList.TitaniumDualCompressedPlates.get());
        CustomItemList.IceCompressedPlate.set(NHItemList.IceCompressedPlate.get());
        CustomItemList.LedoxCompressedPlate.set(NHItemList.LedoxCompressedPlate.get());
        CustomItemList.IceDualCompressedPlates.set(NHItemList.IceDualCompressedPlates.get());
        CustomItemList.QuantinumCompressedPlate.set(NHItemList.QuantinumCompressedPlate.get());
        CustomItemList.QuantinumDualCompressedPlates.set(NHItemList.QuantinumDualCompressedPlates.get());
        CustomItemList.MytrylCompressedPlate.set(NHItemList.MytrylCompressedPlate.get());
        CustomItemList.MytrylDualCompressedPlates.set(NHItemList.MytrylDualCompressedPlates.get());
        CustomItemList.MysteriousCrystalCompressedPlate.set(NHItemList.MysteriousCrystalCompressedPlate.get());
        CustomItemList.MysteriousCrystalDualCompressedPlates
                .set(NHItemList.MysteriousCrystalDualCompressedPlates.get());
        CustomItemList.SteelDualCompressedPlates.set(NHItemList.SteelDualCompressedPlates.get());
        CustomItemList.TinDualCompressedPlates.set(NHItemList.TinDualCompressedPlates.get());
        CustomItemList.CopperDualCompressedPlates.set(NHItemList.CopperDualCompressedPlates.get());
        CustomItemList.IronDualCompressedPlates.set(NHItemList.IronDualCompressedPlates.get());
        CustomItemList.MeteoricIronDualCompressedPlates.set(NHItemList.MeteoricIronDualCompressedPlates.get());
        CustomItemList.MediumFuelCanister.set(NHItemList.MediumFuelCanister.get());
        CustomItemList.LargeFuelCanister.set(NHItemList.LargeFuelCanister.get());
        CustomItemList.ExtraLargeFuelCanister.set(NHItemList.ExtraLargeFuelCanister.get());
        CustomItemList.MytrylCrystal.set(NHItemList.MytrylCrystal.get());
        CustomItemList.CallistoIceCompressedPlate.set(NHItemList.CallistoIceCompressedPlate.get());
        CustomItemList.HeavyDutyRocketEngineTier3.set(NHItemList.HeavyDutyRocketEngineTier3.get());
        CustomItemList.HeavyDutyRocketEngineTier4.set(NHItemList.HeavyDutyRocketEngineTier4.get());
        CustomItemList.HeavyDutyNoseConeTier3.set(NHItemList.HeavyDutyNoseConeTier3.get());
        CustomItemList.HeavyDutyNoseConeTier4.set(NHItemList.HeavyDutyNoseConeTier4.get());
        CustomItemList.HeavyDutyRocketFinsTier3.set(NHItemList.HeavyDutyRocketFinsTier3.get());
        CustomItemList.HeavyDutyRocketFinsTier4.set(NHItemList.HeavyDutyRocketFinsTier4.get());
        CustomItemList.Tier2Booster.set(NHItemList.Tier2Booster.get());
        CustomItemList.Tier3Booster.set(NHItemList.Tier3Booster.get());
        CustomItemList.Tier4Booster.set(NHItemList.Tier4Booster.get());
        CustomItemList.HeavyDutyPlateTier4.set(NHItemList.HeavyDutyPlateTier4.get());
        CustomItemList.HeavyDutyPlateTier5.set(NHItemList.HeavyDutyPlateTier5.get());
        CustomItemList.HeavyDutyPlateTier6.set(NHItemList.HeavyDutyPlateTier6.get());
        CustomItemList.HeavyDutyPlateTier7.set(NHItemList.HeavyDutyPlateTier7.get());
        CustomItemList.HeavyDutyPlateTier8.set(NHItemList.HeavyDutyPlateTier8.get());
        CustomItemList.LeadNickelPlate.set(NHItemList.LeadNickelPlate.get());
        CustomItemList.LeadOriharukonPlate.set(NHItemList.LeadOriharukonPlate.get());
        CustomItemList.MoonStoneDust.set(NHItemList.MoonStoneDust.get());
        CustomItemList.MarsStoneDust.set(NHItemList.MarsStoneDust.get());
        CustomItemList.AsteroidsStoneDust.set(NHItemList.AsteroidsStoneDust.get());
        CustomItemList.PhobosStoneDust.set(NHItemList.PhobosStoneDust.get());
        CustomItemList.DeimosStoneDust.set(NHItemList.DeimosStoneDust.get());
        CustomItemList.CeresStoneDust.set(NHItemList.CeresStoneDust.get());
        CustomItemList.EuropaIceDust.set(NHItemList.EuropaIceDust.get());
        CustomItemList.EuropaStoneDust.set(NHItemList.EuropaStoneDust.get());
        CustomItemList.GanymedeStoneDust.set(NHItemList.GanymedeStoneDust.get());
        CustomItemList.CallistoStoneDust.set(NHItemList.CallistoStoneDust.get());
        CustomItemList.IoStoneDust.set(NHItemList.IoStoneDust.get());
        CustomItemList.VenusStoneDust.set(NHItemList.VenusStoneDust.get());
        CustomItemList.MercuryStoneDust.set(NHItemList.MercuryStoneDust.get());
        CustomItemList.EnceladusIceDust.set(NHItemList.EnceladusIceDust.get());
        CustomItemList.EnceladusStoneDust.set(NHItemList.EnceladusStoneDust.get());
        CustomItemList.TitanStoneDust.set(NHItemList.TitanStoneDust.get());
        CustomItemList.OberonStoneDust.set(NHItemList.OberonStoneDust.get());
        CustomItemList.ProteusStoneDust.set(NHItemList.ProteusStoneDust.get());
        CustomItemList.TritonStoneDust.set(NHItemList.TritonStoneDust.get());
        CustomItemList.PlutoIceDust.set(NHItemList.PlutoIceDust.get());
        CustomItemList.PlutoStoneDust.set(NHItemList.PlutoStoneDust.get());
        CustomItemList.HaumeaStoneDust.set(NHItemList.HaumeaStoneDust.get());
        CustomItemList.MakeMakeStoneDust.set(NHItemList.MakeMakeStoneDust.get());
        CustomItemList.MercuryCoreDust.set(NHItemList.MercuryCoreDust.get());
        CustomItemList.CentauriAStoneDust.set(NHItemList.CentauriAStoneDust.get());
        CustomItemList.CentauriASurfaceDust.set(NHItemList.CentauriASurfaceDust.get());
        CustomItemList.VegaBStoneDust.set(NHItemList.VegaBStoneDust.get());
        CustomItemList.BarnardaEStoneDust.set(NHItemList.BarnardaEStoneDust.get());
        CustomItemList.BarnardaFStoneDust.set(NHItemList.BarnardaFStoneDust.get());
        CustomItemList.IndustryFrame.set(NHItemList.IndustryFrame.get());
        CustomItemList.TCetiEStoneDust.set(NHItemList.TCetiEStoneDust.get());
        CustomItemList.AdsorptionFilterCasing.set(NHItemList.AdsorptionFilterCasing.get());
        CustomItemList.AdsorptionFilter.set(NHItemList.AdsorptionFilter.get());
        CustomItemList.AdsorptionFilterDirty.set(NHItemList.AdsorptionFilterDirty.get());
        CustomItemList.VoidSeed.set(NHItemList.VoidSeed.get());
        CustomItemList.WaferTier3.set(NHItemList.WaferTier3.get());
        CustomItemList.MirandaStoneDust.set(NHItemList.MirandaStoneDust.get());
        CustomItemList.MicaBasedPulp.set(NHItemList.MicaBasedPulp.get());
        CustomItemList.MicaBasedSheet.set(NHItemList.MicaBasedSheet.get());
        CustomItemList.MicaInsulatorSheet.set(NHItemList.MicaInsulatorSheet.get());
        CustomItemList.MicaInsulatorFoil.set(NHItemList.MicaInsulatorFoil.get());
        CustomItemList.HotNetherrackBrick.set(NHItemList.HotNetherrackBrick.get());
        CustomItemList.InfernalBrick.set(NHItemList.InfernalBrick.get());
        CustomItemList.AdvancedCokeOvenBrick.set(NHItemList.AdvancedCokeOvenBrick.get());
        CustomItemList.AdvancedCokeOvenBrickDust.set(NHItemList.AdvancedCokeOvenBrickDust.get());
        CustomItemList.CokeOvenBrick.set(NHItemList.CokeOvenBrick.get());
        CustomItemList.CokeOvenBrickDust.set(NHItemList.CokeOvenBrickDust.get());
        CustomItemList.MedalDerp.set(NHItemList.MedalDerp.get());
        CustomItemList.MedalDerp.getItem().setMaxStackSize(1);
        CustomItemList.MedalGTExplosion.set(NHItemList.MedalGTExplosion.get());
        CustomItemList.MedalGTExplosion.getItem().setMaxStackSize(1);
        CustomItemList.MedalBuilder.set(NHItemList.MedalBuilder.get());
        CustomItemList.MedalBuilder.getItem().setMaxStackSize(1);
        CustomItemList.MedalEngineer.set(NHItemList.MedalEngineer.get());
        CustomItemList.MedalEngineer.getItem().setMaxStackSize(1);
        CustomItemList.MedalWarp.set(NHItemList.MedalWarp.get());
        CustomItemList.MedalWarp.getItem().setMaxStackSize(1);
        CustomItemList.AluminoSilicateWool.set(NHItemList.AluminoSilicateWool.get());
        CustomItemList.MaceratedPlantmass.set(NHItemList.MaceratedPlantmass.get());
        CustomItemList.EngineCore.set(NHItemList.EngineCore.get());
        CustomItemList.TwilightCrystal.set(NHItemList.TwilightCrystal.get());
        CustomItemList.UnfiredClayBrick.set(NHItemList.UnfiredClayBrick.get());
        CustomItemList.UnfiredSearedBrick.set(NHItemList.UnfiredSearedBrick.get());
        CustomItemList.UnfiredCokeOvenBrick.set(NHItemList.UnfiredCokeOvenBrick.get());
        CustomItemList.UnfiredSlimeSoilBrick.set(NHItemList.UnfiredSlimeSoilBrick.get());
        CustomItemList.RawLapotronCrystal.set(NHItemList.RawLapotronCrystal.get());
        CustomItemList.LapotronDust.set(NHItemList.LapotronDust.get());
        CustomItemList.AluminiumIronPlate.set(NHItemList.AluminiumIronPlate.get());
        CustomItemList.ReinforcedAluminiumIronPlate.set(NHItemList.ReinforcedAluminiumIronPlate.get());
        CustomItemList.IrradiantReinforcedAluminiumPlate.set(NHItemList.IrradiantReinforcedAluminiumPlate.get());
        CustomItemList.IrradiantReinforcedTitaniumPlate.set(NHItemList.IrradiantReinforcedTitaniumPlate.get());
        CustomItemList.IrradiantReinforcedTungstenPlate.set(NHItemList.IrradiantReinforcedTungstenPlate.get());
        CustomItemList.IrradiantReinforcedTungstenSteelPlate
                .set(NHItemList.IrradiantReinforcedTungstenSteelPlate.get());
        CustomItemList.IrradiantReinforcedChromePlate.set(NHItemList.IrradiantReinforcedChromePlate.get());
        CustomItemList.IrradiantReinforcedNaquadriaPlate.set(NHItemList.IrradiantReinforcedNaquadriaPlate.get());
        CustomItemList.IrradiantReinforcedNeutroniumPlate.set(NHItemList.IrradiantReinforcedNeutroniumPlate.get());
        CustomItemList.IrradiantReinforcedBedrockiumPlate.set(NHItemList.IrradiantReinforcedBedrockiumPlate.get());
        CustomItemList.QuantumCrystal.set(NHItemList.QuantumCrystal.get());
        CustomItemList.MysteriousCrystalLens.set(NHItemList.MysteriousCrystalLens.get());
        CustomItemList.MysteriousCrystalGemFlawless.set(NHItemList.MysteriousCrystalGemFlawless.get());
        CustomItemList.MysteriousCrystalGemExquisite.set(NHItemList.MysteriousCrystalGemExquisite.get());
        CustomItemList.PrimordialPearlFragment.set(NHItemList.PrimordialPearlFragment.get());
        CustomItemList.SandStoneRod.set(NHItemList.SandStoneRod.get());
        CustomItemList.TheBigEgg.set(NHItemList.TheBigEgg.get());
        CustomItemList.MutatedEgg.set(NHItemList.MutatedEgg.get());
        CustomItemList.DraconiumEgg.set(NHItemList.DraconiumEgg.get());
        CustomItemList.EnderEgg.set(NHItemList.EnderEgg.get());
        CustomItemList.ChargedCertusQuartzDust.set(NHItemList.ChargedCertusQuartzDust.get());
        CustomItemList.RawPicoWafer.set(NHItemList.RawPicoWafer.get());
        CustomItemList.PicoWafer.set(NHItemList.PicoWafer.get());
        CustomItemList.StargateFramePart.set(NHItemList.StargateFramePart.get());
        CustomItemList.StargateChevron.set(NHItemList.StargateChevron.get());
        CustomItemList.StargateShieldingFoil.set(NHItemList.StargateShieldingFoil.get());
        CustomItemList.StargateCrystalDust.set(NHItemList.StargateCrystalDust.get());
        CustomItemList.TCetiESeaweedExtract.set(NHItemList.TCetiESeaweedExtract.get());
        CustomItemList.RawNeutronium.set(NHItemList.RawNeutronium.get());
        CustomItemList.NeutronReflectorSmallParts.set(NHItemList.NeutronReflectorSmallParts.get());
        CustomItemList.NeutronReflectorParts.set(NHItemList.NeutronReflectorParts.get());
        CustomItemList.Empty180SpCell.set(NHItemList.Empty180SpCell.get());
        CustomItemList.Empty360SpCell.set(NHItemList.Empty360SpCell.get());
        CustomItemList.Empty540SpCell.set(NHItemList.Empty540SpCell.get());
        CustomItemList.Empty1080SpCell.set(NHItemList.Empty1080SpCell.get());
        CustomItemList.TenKCell.set(NHItemList.TenKCell.get());
        CustomItemList.ThirtyKCell.set(NHItemList.ThirtyKCell.get());
        CustomItemList.SixtyKCell.set(NHItemList.SixtyKCell.get());
        CustomItemList.ArtificialLeather.set(NHItemList.ArtificialLeather.get());
        CustomItemList.EctoplasmaChip.set(NHItemList.EctoplasmaChip.get());
        CustomItemList.EctoplasmaFragment.set(NHItemList.EctoplasmaFragment.get());
        CustomItemList.ArcaneShardChip.set(NHItemList.ArcaneShardChip.get());
        CustomItemList.ArcaneShardFragment.set(NHItemList.ArcaneShardFragment.get());
        CustomItemList.RuneOfPowerFragment.set(NHItemList.RuneOfPowerFragment.get());
        CustomItemList.RuneOfAgilityFragment.set(NHItemList.RuneOfAgilityFragment.get());
        CustomItemList.RuneOfVigorFragment.set(NHItemList.RuneOfVigorFragment.get());
        CustomItemList.RuneOfDefenseFragment.set(NHItemList.RuneOfDefenseFragment.get());
        CustomItemList.RuneOfMagicFragment.set(NHItemList.RuneOfMagicFragment.get());
        CustomItemList.RuneOfVoidFragment.set(NHItemList.RuneOfVoidFragment.get());
        CustomItemList.NandChipBoard.set(
                GT.addItem(81, "NAND Chip Array", "Chips on Board", "circuitPrimitiveArray", SubTag.NO_UNIFICATION));
        CustomItemList.LogicProcessorItemGoldCore.set(NHItemList.LogicProcessorItemGoldCore.get());
        CustomItemList.EngineeringProcessorItemDiamondCore.set(NHItemList.EngineeringProcessorItemDiamondCore.get());
        CustomItemList.EngineeringProcessorItemEmeraldCore.set(NHItemList.EngineeringProcessorItemEmeraldCore.get());
        CustomItemList.EngineeringProcessorItemAdvEmeraldCore
                .set(NHItemList.EngineeringProcessorItemAdvEmeraldCore.get());
        CustomItemList.Display.set(NHItemList.Display.get());
        CustomItemList.TitaniumIronPlate.set(NHItemList.TitaniumIronPlate.get());
        CustomItemList.ReinforcedTitaniumIronPlate.set(NHItemList.ReinforcedTitaniumIronPlate.get());
        CustomItemList.TungstenIronPlate.set(NHItemList.TungstenIronPlate.get());
        CustomItemList.ReinforcedTungstenIronPlate.set(NHItemList.ReinforcedTungstenIronPlate.get());
        CustomItemList.TungstenSteelIronPlate.set(NHItemList.TungstenSteelIronPlate.get());
        CustomItemList.ReinforcedTungstenSteelIronPlate.set(NHItemList.ReinforcedTungstenSteelIronPlate.get());
        CustomItemList.ChromeIronPlate.set(NHItemList.ChromeIronPlate.get());
        CustomItemList.ReinforcedChromeIronPlate.set(NHItemList.ReinforcedChromeIronPlate.get());
        CustomItemList.NaquadriaIronPlate.set(NHItemList.NaquadriaIronPlate.get());
        CustomItemList.ReinforcedNaquadriaIronPlate.set(NHItemList.ReinforcedNaquadriaIronPlate.get());
        CustomItemList.NeutroniumIronPlate.set(NHItemList.NeutroniumIronPlate.get());
        CustomItemList.ReinforcedNeutroniumIronPlate.set(NHItemList.ReinforcedNeutroniumIronPlate.get());
        CustomItemList.BedrockiumIronPlate.set(NHItemList.BedrockiumIronPlate.get());
        CustomItemList.ReinforcedBedrockiumIronPlate.set(NHItemList.ReinforcedBedrockiumIronPlate.get());
        CustomItemList.BioBall.set(NHItemList.BioBall.get());
        CustomItemList.PotassiumHydroxideDust.set(NHItemList.PotassiumHydroxideDust.get());
        CustomItemList.RadoxPolymerLens.set(NHItemList.RadoxPolymerLens.get());
        CustomItemList.ChromaticLens.set(NHItemList.ChromaticLens.get());
        CustomItemList.ChromaticGem.set(NHItemList.ChromaticGem.get());
        CustomItemList.ChromaticGemFlawless.set(NHItemList.ChromaticGemFlawless.get());
        CustomItemList.ChromaticGemExquisite.set(NHItemList.ChromaticGemExquisite.get());
        CustomItemList.NanoCircuitOrigin.set(NHItemList.NanoCircuitOrigin.get());
        CustomItemList.ChevronOrigin.set(NHItemList.ChevronOrigin.get());
        CustomItemList.FramePartOrigin.set(NHItemList.FramePartOrigin.get());
        CustomItemList.GatePlateOrigin.set(NHItemList.GatePlateOrigin.get());
        CustomItemList.PikoCircuitPolychrome.set(NHItemList.PikoCircuitPolychrome.get());
        CustomItemList.QuantumCircuitPolychrome.set(NHItemList.QuantumCircuitPolychrome.get());
        CustomItemList.GatePlatePolychrome.set(NHItemList.GatePlatePolychrome.get());
        CustomItemList.ChevronPolychrome.set(NHItemList.ChevronPolychrome.get());
        CustomItemList.FramePartPolychrome.set(NHItemList.FramePartPolychrome.get());
        CustomItemList.PikoCircuitDimensional.set(NHItemList.PikoCircuitDimensional.get());
        CustomItemList.QuantumCircuitDimensional.set(NHItemList.QuantumCircuitDimensional.get());
        CustomItemList.GatePlateDimensional.set(NHItemList.GatePlateDimensional.get());
        CustomItemList.ChevronDimensional.set(NHItemList.ChevronDimensional.get());
        CustomItemList.FramePartDimensional.set(NHItemList.FramePartDimensional.get());
        CustomItemList.GatePlateHarmonic.set(NHItemList.GatePlateHarmonic.get());
        CustomItemList.ChevronHarmonic.set(NHItemList.ChevronHarmonic.get());
        CustomItemList.FramePartHarmonic.set(NHItemList.FramePartHarmonic.get());
        CustomItemList.StargateDustAncients.set(NHItemList.StargateDustAncients.get());
        CustomItemList.StargateCrystalAncients.set(NHItemList.StargateCrystalAncients.get());
    }

    private void registerTooltips() {
        registerTieredTooltip(CustomItemList.PikoCircuit.get(1), UMV);
        registerTieredTooltip(CustomItemList.QuantumCircuit.get(1), UXV);
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
