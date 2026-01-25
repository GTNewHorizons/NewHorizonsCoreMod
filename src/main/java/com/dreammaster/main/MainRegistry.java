package com.dreammaster.main;

import static gregtech.api.enums.Dyes.MACHINE_METAL;
import static gregtech.api.enums.Mods.AmazingTrophies;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.DetravScannerMod;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TravellersGear;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.enums.Mods.ZTones;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidContainerRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dreammaster.NHTradeHandler.NHTradeHandler;
import com.dreammaster.TwilightForest.TF_Loot_Chests;
import com.dreammaster.amazingtrophies.AchievementHandler;
import com.dreammaster.bartworksHandler.BW_RadHatchMaterial;
import com.dreammaster.bartworksHandler.BacteriaRegistry;
import com.dreammaster.bartworksHandler.BioItemLoader;
import com.dreammaster.bartworksHandler.PyrolyseOvenLoader;
import com.dreammaster.block.BlockList;
import com.dreammaster.client.util.GTNHPauseScreen;
import com.dreammaster.command.CustomDropsCommand;
import com.dreammaster.command.CustomFuelsCommand;
import com.dreammaster.command.CustomToolTipsCommand;
import com.dreammaster.command.HazardousItemsCommand;
import com.dreammaster.config.CoreModConfig;
import com.dreammaster.coremod.DreamCoreMod;
import com.dreammaster.creativetab.ModTabList;
import com.dreammaster.detrav.ScannerTools;
import com.dreammaster.fluids.FluidList;
import com.dreammaster.gthandler.GT_CustomLoader;
import com.dreammaster.gthandler.recipes.CircuitAssemblyLineRecipes;
import com.dreammaster.gthandler.recipes.DTPFRecipes;
import com.dreammaster.iguana.IguanaProxy;
import com.dreammaster.item.ItemBucketList;
import com.dreammaster.item.NHItemList;
import com.dreammaster.item.baubles.OvenGlove;
import com.dreammaster.lib.Refstrings;
import com.dreammaster.loginhandler.LoginHandler;
import com.dreammaster.modbabychest.BlockBabyChest;
import com.dreammaster.modbabychest.ItemBlockBabyChest;
import com.dreammaster.modbabychest.TileEntityBabyChest;
import com.dreammaster.modctt.CustomToolTipsHandler;
import com.dreammaster.modcustomdrops.CustomDropsHandler;
import com.dreammaster.modcustomfuels.CustomFuelsHandler;
import com.dreammaster.modfixes.ModFixesMaster;
import com.dreammaster.modfixes.avaritia.SkullFireSwordDropFix;
import com.dreammaster.modfixes.minetweaker.MinetweakerFurnaceFix;
import com.dreammaster.modfixes.oilgen.OilGeneratorFix;
import com.dreammaster.modhazardousitems.HazardousItemsHandler;
import com.dreammaster.network.msg.CTTClientSyncMessage;
import com.dreammaster.network.msg.ZZClientOnlySyncMessage;
import com.dreammaster.oredict.OreDictHandler;
import com.dreammaster.railcraftStones.NH_GeodePopulator;
import com.dreammaster.railcraftStones.NH_QuarryPopulator;
import com.dreammaster.recipes.RecipeRemover;
import com.dreammaster.scripts.ScriptLoader;
import com.dreammaster.thaumcraft.TCLoader;
import com.dreammaster.tinkersConstruct.SmelteryFluidTypes;
import com.dreammaster.tinkersConstruct.TiCoLoader;
import com.dreammaster.travellersgear.TGConverter;
import com.dreammaster.witchery.WitcheryPlugin;

import bartworks.system.material.WerkstoffLoader;
import betterquesting.api.storage.BQ_Settings;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import eu.usrv.yamcore.auxiliary.IngameErrorLog;
import eu.usrv.yamcore.client.NotificationTickHandler;
import eu.usrv.yamcore.creativetabs.CreativeTabsManager;
import eu.usrv.yamcore.fluids.ModFluidManager;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.common.items.MetaGeneratedItem01;

@Mod(
        modid = Refstrings.MODID,
        name = Refstrings.NAME,
        version = Refstrings.VERSION,
        dependencies = "required-before:gregtech;" + "required-after:Forge@[10.13.2.1291,);"
                + "required-after:gtnhlib@[0.5.15,);"
                + "required-after:YAMCore@[0.5.76,);"
                + "required-after:Baubles@[1.0.1.10,);"
                + "after:EnderIO;"
                + "after:HardcoreEnderExpansion;"
                + "after:Thaumcraft;"
                + "after:amazingtrophies;"
                + "after:backhand@[1.6.9,);"
                + "after:betterquesting")
public class MainRegistry {

    @SidedProxy(clientSide = Refstrings.CLIENTSIDE, serverSide = Refstrings.SERVERSIDE)
    public static CommonProxy proxy;

    @Mod.Instance(Refstrings.MODID)
    public static MainRegistry instance;

    public static CreativeTabsManager TabManager;
    public static ModFluidManager FluidManager;
    public static HazardousItemsHandler Module_HazardousItems;
    public static CustomToolTipsHandler Module_CustomToolTips;
    public static CustomFuelsHandler Module_CustomFuels;
    public static CustomDropsHandler Module_CustomDrops;
    public static IngameErrorLog Module_AdminErrorLogs;
    public static GT_CustomLoader GTCustomLoader;
    public static CoreModConfig CoreConfig;
    public static SimpleNetworkWrapper dispatcher;
    public static Random Rnd;
    public static Logger Logger = LogManager.getLogger(Refstrings.MODID);
    private static BacteriaRegistry BacteriaRegistry;
    private static boolean handleAchievements;

    public static void AddLoginError(String pMessage) {
        if (Module_AdminErrorLogs != null) {
            Module_AdminErrorLogs.AddErrorLogOnAdminJoin(pMessage);
        }
    }

    /**
     * Returns true on a client
     */
    public static boolean isClient() {
        return proxy.isClient();
    }

    /**
     * Returns true on a dedicated server
     */
    public static boolean isServer() {
        return !isClient();
    }

    public MainRegistry() {
        if (DetravScannerMod.isModLoaded()) GregTechAPI.sAfterGTPreload.add(ScannerTools::new);

        GregTechAPI.sGTCompleteLoad.add(new CircuitAssemblyLineRecipes());
    }

    @Mod.EventHandler
    public void PreLoad(FMLPreInitializationEvent PreEvent) {
        Rnd = new Random(System.currentTimeMillis());

        // ------------------------------------------------------------
        // Init coremod config file. Create it if it's not there
        CoreConfig = new CoreModConfig(
                PreEvent.getModConfigurationDirectory(),
                Refstrings.COLLECTIONID,
                Refstrings.MODID);
        if (!CoreConfig.LoadConfig()) {
            Logger.error("{} could not load its config file. Things are going to be weird!", Refstrings.MODID);
        }
        // ------------------------------------------------------------

        if (CoreConfig.ModAdminErrorLogs_Enabled) {
            Logger.debug("Module_AdminErrorLogs is enabled");
            Module_AdminErrorLogs = new IngameErrorLog();
        }

        // ------------------------------------------------------------
        Logger.debug("PRELOAD Init TexturePage");
        File tFile = new File(new File(PreEvent.getModConfigurationDirectory(), "GregTech"), "GregTech.cfg");
        Configuration tMainConfig = new Configuration(tFile);
        tMainConfig.load();

        GregTechAPI.sUseMachineMetal = tMainConfig.get("machines", "use_machine_metal_tint", true).getBoolean(true);
        if (GregTechAPI.sUseMachineMetal) {
            // use default in GregTech Dyes enum.
        } else {
            // Override MACHINE_METAL dye color with white
            MACHINE_METAL.mRGBa[0] = 255;
            MACHINE_METAL.mRGBa[1] = 255;
            MACHINE_METAL.mRGBa[2] = 255;
        }

        proxy.addTexturePage();
        // ------------------------------------------------------------

        // ------------------------------------------------------------
        Logger.debug("PRELOAD Init NetworkChannel");
        dispatcher = new SimpleNetworkWrapper(Refstrings.MODID);
        dispatcher.registerMessage(
                CTTClientSyncMessage.CTTClientSyncMessageHandler.class,
                CTTClientSyncMessage.class,
                0,
                Side.CLIENT);
        dispatcher.registerMessage(
                ZZClientOnlySyncMessage.ZZClientOnlySyncMessageHandler.class,
                ZZClientOnlySyncMessage.class,
                1,
                Side.CLIENT);
        // ------------------------------------------------------------

        // ------------------------------------------------------------
        Logger.debug("PRELOAD Init Tabmanager");
        TabManager = new CreativeTabsManager();
        ModTabList.InitModTabs(TabManager);
        // ------------------------------------------------------------

        // ------------------------------------------------------------
        // FIXME: Move bio-items to Bartworks and remove this whole section.
        Logger.debug("PRELOAD Create Items");
        if (!BioItemLoader.preInit()) {
            Logger.warn("Some items failed to register. Check the logfile for details");
            AddLoginError("[CoreMod-Items] Some items failed to register. Check the logfile for details");
        }
        // ------------------------------------------------------------

        // ------------------------------------------------------------
        // Init Modules
        Logger.debug("PRELOAD Init Modules");

        if (CoreConfig.ModHazardousItems_Enabled) {
            Logger.debug("Module_HazardousItems is enabled");
            Module_HazardousItems = new HazardousItemsHandler();
        }

        if (CoreConfig.ModCustomToolTips_Enabled) {
            Logger.debug("Module_CustomToolTips is enabled");
            Module_CustomToolTips = new CustomToolTipsHandler();
            proxy.registerResourceReload();
        }

        if (CoreConfig.ModCustomFuels_Enabled) {
            Logger.debug("Module_CustomFuels is enabled");
            Module_CustomFuels = new CustomFuelsHandler();
        }

        if (CoreConfig.ModCustomDrops_Enabled) {
            Logger.debug("Module_CustomDrops is enabled");
            Module_CustomDrops = new CustomDropsHandler(PreEvent.getModConfigurationDirectory());
        }

        // ------------------------------------------------------------

        // ------------------------------------------------------------
        Logger.debug("PRELOAD Create Fluids");
        FluidManager = new ModFluidManager(Refstrings.MODID);
        if (!FluidList.AddToItemManager(FluidManager)) {
            Logger.warn("Some fluids failed to register. Check the logfile for details");
            AddLoginError("[CoreMod-Fluids] Some fluids failed to register. Check the logfile for details");
        }
        // ------------------------------------------------------------

        // register final list with valid items to forge
        Logger.debug("LOAD Register Items");
        NHItemList.registerAll();

        Logger.debug("LOAD Register Blocks");
        BlockList.registerAll();

        Logger.debug("LOAD Register Fluids");
        FluidManager.RegisterItems(TabManager);

        if (PreEvent.getSide() == Side.CLIENT) {
            FMLCommonHandler.instance().bus().register(new NotificationTickHandler());
        }

        BacteriaRegistry = new BacteriaRegistry();

        if (Witchery.isModLoaded()) {
            new WitcheryPlugin();
        }

        if (CoreModConfig.ModLoginMessage_Enabled) {
            FMLCommonHandler.instance().bus().register(new LoginHandler());
        }
        Logger.warn("==================================================");
        Logger.warn("Welcome to Gregtech:New Horizons {}", CoreModConfig.ModPackVersion);
        Logger.warn("Please bring comments to " + "https://discord.gg/gtnh");
        Logger.warn("==================================================");

        MinecraftForge.EVENT_BUS.register(new OvenGlove.EventHandler());

        if (TinkerConstruct.isModLoaded()) {
            GregTechAPI.sAfterGTPreload.add(SmelteryFluidTypes::registerGregtechFluidTypes);
        }
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        // register events in modules
        RegisterModuleEvents();

        if (CoreConfig.ModBabyChest_Enabled) {
            InitAdditionalBlocks();
        }

        // Register additional OreDictionary Names
        if (CoreConfig.OreDictItems_Enabled) OreDictHandler.register_all();

        GregTechAPI.sAfterGTPostload.add(() -> {
            Logger.debug("Add Runnable to GT to create pyrolyse oven logWood recipes");
            PyrolyseOvenLoader.registerRecipes();
        });

        if (TwilightForest.isModLoaded()) {
            TF_Loot_Chests.init();
        }

        if (CoreConfig.gtnhPauseMenuButtons && event.getSide().isClient()) {
            MinecraftForge.EVENT_BUS.register(new GTNHPauseScreen());
        }

        VillagerRegistry.instance().registerVillageTradeHandler(2, new NHTradeHandler());

        if (TinkerConstruct.isModLoaded()) {
            TiCoLoader.doInitialization();
        }

        if (IguanaTweaksTinkerConstruct.isModLoaded()) {
            IguanaProxy.doInitialization();
        }
    }

    public static Block blockBabyChest = new BlockBabyChest();

    private void InitAdditionalBlocks() {
        GameRegistry.registerBlock(blockBabyChest, ItemBlockBabyChest.class, "BabyChest");
        blockBabyChest.setCreativeTab(ModTabList.BLOCKS);

        GameRegistry.addShapelessRecipe(new ItemStack(blockBabyChest, 9), new ItemStack(Blocks.chest, 1, 0));
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(blockBabyChest, 9))
                .itemOutputs(new ItemStack(Blocks.chest, 1, 0)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);

        GameRegistry.registerTileEntity(TileEntityBabyChest.class, "teBabyChest");

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        proxy.registerRenderInfo();
    }

    private void RegisterModuleEvents() {
        if (CoreConfig.ModAdminErrorLogs_Enabled) {
            FMLCommonHandler.instance().bus().register(Module_AdminErrorLogs);
        }

        if (CoreConfig.ModHazardousItems_Enabled) {
            FMLCommonHandler.instance().bus().register(Module_HazardousItems);
        }

        if (CoreConfig.ModCustomToolTips_Enabled) {
            MinecraftForge.EVENT_BUS.register(Module_CustomToolTips);
            FMLCommonHandler.instance().bus().register(Module_CustomToolTips);
        }

        if (CoreConfig.ModCustomFuels_Enabled) {
            GameRegistry.registerFuelHandler(Module_CustomFuels);
        }

        if (CoreConfig.ModCustomDrops_Enabled) {
            MinecraftForge.EVENT_BUS.register(Module_CustomDrops);
        }

        if (Railcraft.isModLoaded()) {
            MinecraftForge.EVENT_BUS.register(NH_GeodePopulator.instance()); // instead of RC
            MinecraftForge.EVENT_BUS.register(NH_QuarryPopulator.instance()); // instead of RC
        }
    }

    @Mod.EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent) {
        ItemBucketList.SodiumPotassium.set(
                FluidContainerRegistry
                        .fillFluidContainer(FluidList.SodiumPotassium.getFluidStack(), new ItemStack(Items.bucket)));
        ItemBucketList.NitricAcid.set(
                FluidContainerRegistry
                        .fillFluidContainer(FluidList.NitricAcid.getFluidStack(), new ItemStack(Items.bucket)));
        ItemBucketList.RadioactiveBacterialSludge.set(
                FluidContainerRegistry.fillFluidContainer(
                        FluidList.EnrichedBacterialSludge.getFluidStack(),
                        new ItemStack(Items.bucket)));
        ItemBucketList.FermentedBacterialSludge.set(
                FluidContainerRegistry.fillFluidContainer(
                        FluidList.FermentedBacterialSludge.getFluidStack(),
                        new ItemStack(Items.bucket)));
        ItemBucketList.Concrete.set(
                FluidContainerRegistry
                        .fillFluidContainer(FluidList.Concrete.getFluidStack(), new ItemStack(Items.bucket)));
        ItemBucketList.Pollution.set(
                FluidContainerRegistry
                        .fillFluidContainer(FluidList.Pollution.getFluidStack(), new ItemStack(Items.bucket)));

        if (CoreConfig.ModHazardousItems_Enabled) {
            Module_HazardousItems.LoadConfig();
        }

        if (CoreConfig.ModCustomToolTips_Enabled) {
            Module_CustomToolTips.LoadConfig();
        }

        if (CoreConfig.ModCustomFuels_Enabled) {
            Module_CustomFuels.LoadConfig();
        }

        if (CoreConfig.ModCustomDrops_Enabled) {
            Module_CustomDrops.LoadConfig();
        }

        GTCustomLoader = new GT_CustomLoader();
        GTCustomLoader.run();

        registerModFixes();

        // Register modfixes in registerModFixes()
        // Don't call enableModFixes() yourself
        // Don't register fixes after enableModFixes() has been executed
        ModFixesMaster.enableModFixes();

        Logger.debug("Add Bacteria Stuff to BartWorks");
        BacteriaRegistry.runAllPostinit();

        Logger.debug("Nerf Platinum Metal Cauldron Cleaning");
        MetaGeneratedItem01
                .registerCauldronCleaningFor(Materials.Platinum, WerkstoffLoader.PTMetallicPowder.getBridgeMaterial());
        MetaGeneratedItem01
                .registerCauldronCleaningFor(Materials.Osmium, WerkstoffLoader.IrOsLeachResidue.getBridgeMaterial());
        MetaGeneratedItem01
                .registerCauldronCleaningFor(Materials.Iridium, WerkstoffLoader.IrLeachResidue.getBridgeMaterial());
        MetaGeneratedItem01
                .registerCauldronCleaningFor(Materials.Palladium, WerkstoffLoader.PDMetallicPowder.getBridgeMaterial());

        if (Thaumcraft.isModLoaded()) TCLoader.run();

        if (TinkerConstruct.isModLoaded()) TiCoLoader.doPostInitialization();

        if (!TravellersGear.isModLoaded()) TGConverter.doPostInitialization();
    }

    @Mod.EventHandler
    public void CompleteLoad(FMLLoadCompleteEvent event) {
        RecipeRemover.run();
        ScriptLoader.run();
        new DTPFRecipes().run();

        BW_RadHatchMaterial.runRadHatchAdder();

        if (Thaumcraft.isModLoaded()) TCLoader.checkRecipeProblems();
        if (AmazingTrophies.isModLoaded() && BloodMagic.isModLoaded()
                && Avaritia.isModLoaded()
                && SGCraft.isModLoaded()
                && TinkerConstruct.isModLoaded()) {
            AchievementHandler.init();
            AchievementHandler handler = new AchievementHandler();
            MinecraftForge.EVENT_BUS.register(handler);
            FMLCommonHandler.instance().bus().register(handler);
            handleAchievements = true;
        }
    }

    /**
     * Register your mod-fixes here
     */
    private void registerModFixes() {
        if (CoreConfig.AvaritiaFixEnabled) {
            ModFixesMaster.registerModFix(new SkullFireSwordDropFix());
        }
        if (CoreConfig.OilFixConfig.OilFixEnabled) {
            ModFixesMaster.registerModFix(new OilGeneratorFix());
        }
        if (CoreConfig.MinetweakerFurnaceFixEnabled) {
            ModFixesMaster.registerModFix(new MinetweakerFurnaceFix());
        }
        if (ZTones.isModLoaded()) {
            final Block block = GameRegistry.findBlock(ZTones.ID, "tile.glaxx");
            if (block != null) {
                block.setHardness(0.3F);
            }
        }
    }

    /**
     * Do some stuff once the server starts
     *
     * @param event
     */
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        if (CoreConfig.ModHazardousItems_Enabled) {
            event.registerServerCommand(new HazardousItemsCommand());
        }
        if (CoreConfig.ModCustomToolTips_Enabled) {
            event.registerServerCommand(new CustomToolTipsCommand());
        }
        if (CoreConfig.ModCustomFuels_Enabled) {
            event.registerServerCommand(new CustomFuelsCommand());
        }
        if (CoreConfig.ModCustomDrops_Enabled) {
            event.registerServerCommand(new CustomDropsCommand());
        }
        if (Mods.BetterQuesting.isModLoaded()) {
            if (!bqConfig$ReloadOnStartup() && DreamCoreMod.modpackHasUpdated()) {
                Logger.info("Modpack has been updated, loading default quest database");
                final long l = System.currentTimeMillis();
                event.getServer().getCommandManager().executeCommand(event.getServer(), "/bq_admin default load");
                Logger.info("Loading quest data base took {}ms", System.currentTimeMillis() - l);
            }
        }
    }

    @Mod.EventHandler
    public void serverUnload(FMLServerStoppingEvent event) {
        if (handleAchievements) {
            AchievementHandler.cleanup();
        }
    }

    @Mod.EventHandler
    public void onMissingMappings(FMLMissingMappingsEvent event) {
        HashMap<String, Item> itemListRemaps = null;
        HashMap<String, Block> blockListRemaps = null;

        for (FMLMissingMappingsEvent.MissingMapping mapping : event.get()) {
            // Remap all the old Yamcl names (for Blocks & their ItemBlocks)
            if (mapping.name.startsWith("dreamcraft:tile.")) {
                if (blockListRemaps == null) {
                    blockListRemaps = createBlockListRemaps();
                }

                final Block newBlockID = blockListRemaps.get(mapping.name.substring(16));
                if (mapping.type == GameRegistry.Type.ITEM) {
                    mapping.remap(Item.getItemFromBlock(newBlockID));
                } else {
                    mapping.remap(newBlockID);
                }
                continue;
            }

            if (mapping.type != GameRegistry.Type.ITEM) continue;

            // Remap all the old Yamcl names (for Items)
            if (mapping.name.startsWith("dreamcraft:item.")) {
                if (itemListRemaps == null) {
                    itemListRemaps = createNHItemListRemaps();
                }

                mapping.remap(itemListRemaps.get(mapping.name.substring(16)));
                continue;
            }

            if ("dreamcraft:itemQuantumToast".equals(mapping.name)) {
                // Replace the old Quantum Bread declaration with the new one.
                mapping.remap(NHItemList.QuantumBread.item);
            }
        }
    }

    private static HashMap<String, Item> createNHItemListRemaps() {
        final HashMap<String, Item> itemListData = new HashMap<>();

        // Remap all the old Yamcl names to the new names.
        for (var entry : NHItemList.values()) {
            itemListData.put(entry.name, entry.item);
        }

        // Remaps the old "UnfiredSlimeSoulBrick" (with a typo) to the new, correct "UnfiredSlimeSoilBrick".
        itemListData.put("UnfiredSlimeSoulBrick", NHItemList.UnfiredSlimeSoilBrick.item);

        return itemListData;
    }

    private static HashMap<String, Block> createBlockListRemaps() {
        final HashMap<String, Block> blockListData = new HashMap<>();

        for (var entry : BlockList.values()) {
            blockListData.put(entry.name, entry.block);
        }

        // Remaps MysteriousCrystal to MysteriousCrystalBlock in order to not conflict with the item
        blockListData.put("MysteriousCrystal", BlockList.MysteriousCrystalBlock.block);

        return blockListData;
    }

    @Optional.Method(modid = Mods.ModIDs.BETTER_QUESTING)
    private static boolean bqConfig$ReloadOnStartup() {
        return BQ_Settings.loadDefaultsOnStartup;
    }
}
