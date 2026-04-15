package com.dreammaster.main;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dreammaster.NHTradeHandler.NHTradeHandler;
import com.dreammaster.TwilightForest.TF_Loot_Chests;
import com.dreammaster.amazingtrophies.AchievementHandler;
import com.dreammaster.bartworksHandler.BW_RadHatchMaterial;
import com.dreammaster.bartworksHandler.BacteriaRegistry;
import com.dreammaster.bartworksHandler.BioItemLoader;
import com.dreammaster.berriespp.BPPConverter;
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
import com.dreammaster.ic2.IC2Converter;
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
import com.dreammaster.modfixes.minetweaker.MinetweakerFurnaceFix;
import com.dreammaster.modfixes.oilgen.OilGeneratorFix;
import com.dreammaster.modhazardousitems.HazardousItemsHandler;
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
import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;

import bartworks.system.material.WerkstoffLoader;
import betterquesting.api.storage.BQ_Settings;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
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
    public static GT_CustomLoader GTCustomLoader;
    public static SimpleNetworkWrapper dispatcher;
    public static Random Rnd;
    public static final Logger LOGGER = LogManager.getLogger(Refstrings.MODID);
    private static BacteriaRegistry BacteriaRegistry;
    private static boolean handleAchievements;

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
        try {
            ConfigurationManager.registerConfig(CoreModConfig.Modules.class);
            ConfigurationManager.registerConfig(CoreModConfig.ModFixes.class);
            ConfigurationManager.registerConfig(OilGeneratorFix.OilConfig.class);
        } catch (ConfigException e) {
            throw new RuntimeException(e);
        }
        // ------------------------------------------------------------

        // ------------------------------------------------------------
        LOGGER.debug("PRELOAD Init NetworkChannel");
        dispatcher = new SimpleNetworkWrapper(Refstrings.MODID);
        dispatcher.registerMessage(
                ZZClientOnlySyncMessage.ZZClientOnlySyncMessageHandler.class,
                ZZClientOnlySyncMessage.class,
                1,
                Side.CLIENT);
        // ------------------------------------------------------------

        // ------------------------------------------------------------
        LOGGER.debug("PRELOAD Init Tabmanager");
        TabManager = new CreativeTabsManager();
        ModTabList.InitModTabs(TabManager);
        // ------------------------------------------------------------

        BioItemLoader.preInit();

        // ------------------------------------------------------------
        // Init Modules
        LOGGER.debug("PRELOAD Init Modules");

        if (CoreModConfig.Modules.HazardousItems) {
            LOGGER.debug("Module_HazardousItems is enabled");
            Module_HazardousItems = new HazardousItemsHandler();
        }

        if (CoreModConfig.Modules.CustomToolTips) {
            LOGGER.debug("Module_CustomToolTips is enabled");
            Module_CustomToolTips = new CustomToolTipsHandler();
            proxy.registerResourceReload();
        }

        if (CoreModConfig.Modules.CustomFuels) {
            LOGGER.debug("Module_CustomFuels is enabled");
            Module_CustomFuels = new CustomFuelsHandler();
        }

        if (CoreModConfig.Modules.CustomDrops) {
            LOGGER.debug("Module_CustomDrops is enabled");
            Module_CustomDrops = new CustomDropsHandler(PreEvent.getModConfigurationDirectory());
        }

        // ------------------------------------------------------------

        // ------------------------------------------------------------
        LOGGER.debug("PRELOAD Create Fluids");
        FluidManager = new ModFluidManager(Refstrings.MODID);
        if (!FluidList.AddToItemManager(FluidManager)) {
            LOGGER.error("Some fluids failed to register. Check the logfile for details");
        }
        // ------------------------------------------------------------

        // register final list with valid items to forge
        LOGGER.debug("LOAD Register Items");
        NHItemList.registerAll();

        LOGGER.debug("LOAD Register Blocks");
        BlockList.registerAll();

        LOGGER.debug("LOAD Register Fluids");
        FluidManager.RegisterItems(TabManager);

        BacteriaRegistry = new BacteriaRegistry();

        if (Witchery.isModLoaded()) {
            new WitcheryPlugin();
        }

        if (CoreModConfig.Modules.LoginMessage) {
            FMLCommonHandler.instance().bus().register(new LoginHandler());
        }
        LOGGER.warn("==================================================");
        LOGGER.warn("Welcome to Gregtech:New Horizons {}", CoreModConfig.Modules.ModPackVersion);
        LOGGER.warn("Please bring comments to " + "https://discord.gg/gtnh");
        LOGGER.warn("==================================================");

        MinecraftForge.EVENT_BUS.register(new OvenGlove.EventHandler());

        if (TinkerConstruct.isModLoaded()) {
            GregTechAPI.sAfterGTPreload.add(SmelteryFluidTypes::registerGregtechFluidTypes);
        }
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        // register events in modules
        RegisterModuleEvents();

        if (CoreModConfig.Modules.BabyChest) {
            InitAdditionalBlocks();
        }

        // Register additional OreDictionary Names
        if (CoreModConfig.Modules.OreDictItems) OreDictHandler.register_all();

        if (TwilightForest.isModLoaded()) {
            TF_Loot_Chests.init();
        }

        if (CoreModConfig.Modules.gtnhPauseMenuButtons && event.getSide().isClient()) {
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

        // Baby chest burns for 33 ticks (prevents fuel dupe)
        GameRegistry.registerFuelHandler(fuel -> {
            if (Block.getBlockFromItem(fuel.getItem()) instanceof BlockBabyChest) return 33;
            return 0;
        });
    }

    private void RegisterModuleEvents() {
        if (CoreModConfig.Modules.HazardousItems) {
            FMLCommonHandler.instance().bus().register(Module_HazardousItems);
        }

        if (CoreModConfig.Modules.CustomToolTips) {
            MinecraftForge.EVENT_BUS.register(Module_CustomToolTips);
            FMLCommonHandler.instance().bus().register(Module_CustomToolTips);
        }

        if (CoreModConfig.Modules.CustomFuels) {
            GameRegistry.registerFuelHandler(Module_CustomFuels);
        }

        if (CoreModConfig.Modules.CustomDrops) {
            MinecraftForge.EVENT_BUS.register(Module_CustomDrops);
        }

        if (Railcraft.isModLoaded()) {
            MinecraftForge.EVENT_BUS.register(NH_GeodePopulator.instance()); // instead of RC
            MinecraftForge.EVENT_BUS.register(NH_QuarryPopulator.instance()); // instead of RC
        }
    }

    @Mod.EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent) {
        ItemBucketList.Concrete.set(
                FluidContainerRegistry
                        .fillFluidContainer(FluidList.Concrete.getFluidStack(), new ItemStack(Items.bucket)));

        if (CoreModConfig.Modules.HazardousItems) {
            Module_HazardousItems.LoadConfig();
        }

        if (CoreModConfig.Modules.CustomToolTips) {
            Module_CustomToolTips.LoadConfig();
        }

        if (CoreModConfig.Modules.CustomFuels) {
            Module_CustomFuels.LoadConfig();
        }

        if (CoreModConfig.Modules.CustomDrops) {
            Module_CustomDrops.LoadConfig();
        }

        GTCustomLoader = new GT_CustomLoader();
        GTCustomLoader.run();

        registerModFixes();

        // Register modfixes in registerModFixes()
        // Don't call enableModFixes() yourself
        // Don't register fixes after enableModFixes() has been executed
        ModFixesMaster.enableModFixes();

        LOGGER.debug("Add Bacteria Stuff to BartWorks");
        BacteriaRegistry.runAllPostinit();

        LOGGER.debug("Nerf Platinum Metal Cauldron Cleaning");
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

        if (!Loader.isModLoaded(BPPConverter.BPP_MOD_ID)) BPPConverter.doPostInitialization();

        if (IndustrialCraft2.isModLoaded()) IC2Converter.doPostInitialization();
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
        if (CoreModConfig.ModFixes.GenerateOil) {
            ModFixesMaster.registerModFix(new OilGeneratorFix());
        }
        if (CoreModConfig.ModFixes.MinetweakerFurnaceFixEnabled) {
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
        if (CoreModConfig.Modules.HazardousItems) {
            event.registerServerCommand(new HazardousItemsCommand());
        }
        if (CoreModConfig.Modules.CustomToolTips) {
            event.registerServerCommand(new CustomToolTipsCommand());
        }
        if (CoreModConfig.Modules.CustomFuels) {
            event.registerServerCommand(new CustomFuelsCommand());
        }
        if (CoreModConfig.Modules.CustomDrops) {
            event.registerServerCommand(new CustomDropsCommand());
        }
        if (Mods.BetterQuesting.isModLoaded()) {
            if (!bqConfig$ReloadOnStartup() && DreamCoreMod.modpackHasUpdated()) {
                LOGGER.info("Modpack has been updated, loading default quest database");
                final long l = System.currentTimeMillis();
                event.getServer().getCommandManager().executeCommand(event.getServer(), "/bq_admin default load");
                LOGGER.info("Loading quest data base took {}ms", System.currentTimeMillis() - l);
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
        List<FMLMissingMappingsEvent.MissingMapping> missingMappings = event.get();
        for (int i = 0, size = missingMappings.size(); i < size; i++) {
            FMLMissingMappingsEvent.MissingMapping mapping = missingMappings.get(i);
            if (mapping.name.startsWith("dreamcraft:")) {
                NHRemapper.remapAll(missingMappings, i);
                break;
            }
        }
    }

    @Optional.Method(modid = Mods.ModIDs.BETTER_QUESTING)
    private static boolean bqConfig$ReloadOnStartup() {
        return BQ_Settings.loadDefaultsOnStartup;
    }
}
