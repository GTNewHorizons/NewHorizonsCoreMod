package com.dreammaster.sgcalc;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.main.MainRegistry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The `/sgcalc` configuration, stored as `config/sgcalc.json` and re-read on every command run so the recipe-selection
 * policy and frontier allowlists can be tuned against the wiki without a restart. A missing file is created from the
 * seed defaults below.
 *
 * Entries beginning with `#` are treated as comments by {@link Frontier}/{@link RecipeSelector}; they document rows
 * that still need an in-game identifier. Identifiers use the {@link Matcher} grammar.
 */
public final class SGCalcConfig {

    public List<String> composition = new ArrayList<>();
    public List<String> highLevelSet = new ArrayList<>();
    public List<String> lowLevelSet = new ArrayList<>();
    public List<String> boldSet = new ArrayList<>();
    public List<String> denySources = new ArrayList<>();
    public List<String> rawSources = new ArrayList<>();
    public List<String> rawProviders = new ArrayList<>();
    public List<String> overrides = new ArrayList<>();
    public String outputDir = "sgcalc";

    /**
     * Set when the file existed but could not be parsed, so the command can warn the player it fell back to defaults.
     */
    public transient String loadWarning;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static SGCalcConfig loadOrCreate(File file) {
        if (file.exists()) {
            try {
                String json = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                SGCalcConfig config = GSON.fromJson(json, SGCalcConfig.class);
                if (config != null) return config.normalized();
            } catch (Exception e) {
                MainRegistry.LOGGER.warn("Failed to read sgcalc config, using defaults: " + e.getMessage());
                SGCalcConfig defaults = defaults();
                defaults.loadWarning = "config/sgcalc.json could not be read (" + e.getMessage()
                        + "); using built-in defaults. Fix or delete the file.";
                return defaults;
            }
        }
        SGCalcConfig defaults = defaults();
        try {
            File parent = file.getParentFile();
            if (parent != null) parent.mkdirs();
            Files.write(file.toPath(), GSON.toJson(defaults).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            MainRegistry.LOGGER.warn("Failed to write default sgcalc config: " + e.getMessage());
        }
        return defaults;
    }

    /** Gson skips the constructor, so replace any field a partial hand-edit omitted with an empty default. */
    private SGCalcConfig normalized() {
        if (composition == null) composition = new ArrayList<>();
        if (highLevelSet == null) highLevelSet = new ArrayList<>();
        if (lowLevelSet == null) lowLevelSet = new ArrayList<>();
        if (boldSet == null) boldSet = new ArrayList<>();
        if (denySources == null) denySources = new ArrayList<>();
        if (rawSources == null) rawSources = new ArrayList<>();
        if (rawProviders == null) rawProviders = new ArrayList<>();
        if (overrides == null) overrides = new ArrayList<>();
        if (outputDir == null || outputDir.trim().isEmpty()) outputDir = "sgcalc";
        return this;
    }

    public List<CostResolver.Root> roots() {
        List<CostResolver.Root> roots = new ArrayList<>();
        for (String entry : composition) {
            if (entry == null || entry.trim().isEmpty() || entry.startsWith("#")) continue;
            try {
                int eq = entry.lastIndexOf('=');
                if (eq < 0) continue;
                ItemStack stack = Matcher.parse(entry.substring(0, eq).trim()).toStack();
                double qty = Double.parseDouble(entry.substring(eq + 1).trim());
                roots.add(new CostResolver.Root(stack, qty));
            } catch (RuntimeException e) {
                MainRegistry.LOGGER.warn("sgcalc: ignoring malformed composition entry '" + entry + "': " + e);
            }
        }
        return roots;
    }

    public Frontier highLevelFrontier() {
        return new Frontier(highLevelSet);
    }

    public Frontier lowLevelFrontier() {
        return new Frontier(lowLevelSet);
    }

    public Frontier boldFrontier() {
        return new Frontier(boldSet);
    }

    public RecipeSelector selector(RecipeIndex index) {
        return new RecipeSelector(denySources, overrides, index, index.rawOutputs());
    }

    private static SGCalcConfig defaults() {
        SGCalcConfig c = new SGCalcConfig();
        c.composition = Arrays.asList(
                "mod:SGCraft:stargateRing:0=8",
                "mod:SGCraft:stargateRing:1=7",
                "mod:SGCraft:stargateBase:0=1",
                "mod:SGCraft:rfPowerUnit:0=1",
                "mod:SGCraft:stargateController:0=1",
                "mod:SGCraft:sgChevronUpgrade:0=1",
                "mod:SGCraft:sgIrisUpgrade:0=1");
        c.highLevelSet = Arrays.asList(
                "mod:dreamcraft:StargateFramePart|Stargate Frame Part",
                "mod:dreamcraft:StargateChevron|Stargate Chevron",
                "mod:dreamcraft:StargateShieldingFoil|Stargate-Radiation-Containment-Plate",
                "prefixmat:block:Magmatter|Block of Magmatter",
                "prefixmat:plateSuperdense:Magmatter|Superdense Magmatter Plate",
                "prefixmat:nanite:Magmatter|Magmatter Nanite",
                "prefixmat:plateSuperdense:WhiteDwarfMatter|Superdense White Dwarf Matter Plate",
                "mod:GalacticraftAmunRa:tile.baseBlockRock:14|Block of Dark Matter",
                "gt:Field_Generator_UXV|UXV Field Generator",
                "gt:Electric_Piston_UXV|Electric Piston (UXV)",
                "gt:Emitter_UXV|Emitter (UXV)",
                "gt:Sensor_UXV|Sensor (UXV)",
                "gt:GigaChad|Gigachad Token",
                "gt:Transdimensional_Alignment_Matrix|Transdimensional Alignment Matrix",
                "gt:SpaceElevatorModuleAssemblerT3|Space Assembler Module Mk-III",
                "gt:MiningDroneUXV|Mining Drone MK-XIII (UXV)",
                "mod:SGCraft:sgCoreCrystal|Stargate Core Crystal",
                "mod:SGCraft:sgControllerCrystal|Stargate Controller Crystal",
                "mod:OpenComputers:keyboard|Keyboard",
                "mod:EnderIO:blockCapBank|Chaotic Capacitor Bank",
                "mod:appliedenergistics2:tile.BlockSingularityCraftingStorage|Singularity Crafting Storage",
                "mod:appliedenergistics2:item.ItemExtremeStorageCell.Universe|Artificial Universe ME Storage Cell",
                "mod:ae2fc:fluid_storage.Universe|ME Fluid Artificial Universe Storage Cell",
                "container:tectech.thing.CustomItemList.Godforge_GravitonFlowModulatorTier3|Central Graviton Flow Modulator",
                "container:tectech.thing.CustomItemList.Godforge_StellarEnergySiphonCasing|Stellar Energy Siphon Casing",
                "container:tectech.thing.CustomItemList.astralArrayFabricator|Astral Array Fabricator",
                "container:tectech.thing.CustomItemList.dataIn_Wireless_Hatch|Cloud Computation Client Hatch",
                "container:tectech.thing.CustomItemList.Machine_Multi_EyeOfHarmony|Eye of Harmony",
                "mod:GoodGenerator:compactFusionCoil:4|Compact Fusion Coil Mk-II Finaltype",
                "gt:ZPM6|Mega Ultimate Battery");
        c.lowLevelSet = Arrays.asList(
                "material:Iron|Iron|L",
                "material:Copper|Copper|L",
                "material:Tin|Tin|L",
                "material:Neutronium|Neutronium|L",
                "material:CosmicNeutronium|Cosmic Neutronium|L",
                "material:Naquadria|Naquadria|L",
                "material:Bedrockium|Bedrockium|L",
                "material:Infinity|Infinity|L",
                "material:SpaceTime|Spacetime|L",
                "material:Magmatter|Magmatter|L",
                "material:WhiteDwarfMatter|White Dwarf Matter|L",
                "material:BlackDwarfMatter|Black Dwarf Matter|L",
                "material:Eternity|Eternity|L",
                "material:Universium|Universium|L",
                "material:Creon|Creon|L",
                "material:Hypogen|Hypogen|L",
                "material:Dragonblood|Dragonblood|L",
                "material:TranscendentMetal|Transcendent Metal|L",
                "material:Mellion|Mellion|L",
                "material:Quantum|Quantum|L",
                "material:Shirabon|Shirabon|L",
                "material:Oganesson|Oganesson|L",
                "material:Titanium|Titanium",
                "material:Tungsten|Tungsten",
                "material:Tritanium|Tritanium",
                "material:Trinium|Trinium",
                "material:Naquadah|Naquadah",
                "material:Americium|Americium",
                "material:Osmium|Osmium",
                "material:Silver|Silver",
                "material:Gold|Gold",
                "material:UUMatter|UU-Matter|L",
                "material:Salt|Salt",
                "ore:circuitPrimitive|ULV Circuits",
                "ore:circuitBasic|LV Circuits",
                "ore:circuitGood|MV Circuits",
                "ore:circuitAdvanced|HV Circuits",
                "ore:circuitData|EV Circuits",
                "ore:circuitElite|IV Circuits",
                "ore:circuitMaster|LuV Circuits",
                "ore:circuitUltimate|ZPM Circuits",
                "ore:circuitSuperconductor|UV Circuits",
                "ore:circuitInfinite|UHV Circuits",
                "ore:circuitBio|UEV Circuits",
                "ore:circuitNano|UIV Circuits",
                "ore:circuitOptical|UIV Circuits",
                "ore:circuitPiko|UMV Circuits",
                "ore:circuitExotic|UMV Circuits",
                "ore:circuitQuantum|UXV Circuits",
                "ore:circuitCosmic|UXV Circuits",
                "ore:circuitTranscendent|MAX Circuits",
                "mod:minecraft:rotten_flesh|Rotten Flesh",
                "mod:minecraft:bone|Bone",
                "mod:minecraft:beef|Raw Beef",
                "mod:minecraft:skull:0|Skeleton Skull",
                "mod:minecraft:skull:2|Zombie Head",
                "# TODO add remaining low-level rows; verify material mNames in-game (Superconductor Base *,"
                        + " Six-Phased Copper, Graviton Shards, Large Chaos Fragment, etc.)");
        c.boldSet = Arrays.asList(
                "material:Infinity",
                "material:SpaceTime",
                "material:Magmatter",
                "material:WhiteDwarfMatter",
                "material:BlackDwarfMatter",
                "material:Eternity",
                "material:Universium",
                "material:Creon",
                "material:Hypogen",
                "material:Dragonblood",
                "material:TranscendentMetal",
                "material:Mellion");
        // Recipe sources never used as a producer. The replicator and UU amplifier fabricate UU-matter, which is a raw
        // (lowLevelSet) instead; the canner only moves fluids in and out of cells; the extreme heat exchanger is a fuel
        // converter rather than a crafting step; the packager and unpackager only box and unbox an existing item; and
        // vanilla crafting offers reverse/uncraft recipes that short-circuit real production chains.
        c.denySources = Arrays.asList(
                "gt:gt.recipe.replicator",
                "gt:gt.recipe.uuamplifier",
                "gt:gt.recipe.canner",
                "gt:gg.recipe.extreme_heat_exchanger",
                "gt:gt.recipe.packager",
                "gt:gt.recipe.unpackager",
                "vanilla");
        // Recipe sources whose outputs are raw ingredients: they stop recursing and are counted as-is. The Eye of
        // Harmony (rare materials), the Godforge exotic module, the Quantum Force Transformer, and the mass fabricator
        // (UU-matter) are all sources of raws rather than crafting steps.
        c.rawSources = Arrays.asList(
                "gt:gt.recipe.eyeofharmony",
                "gt:gt.recipe.fog_exotic",
                "gt:gtpp.recipe.quantumforcesmelter",
                "gt:gtpp.recipe.matterfab2");
        // Raw providers are non-RecipeMap recipe tables read reflectively (<class>#<staticField>); every ItemStack or
        // FluidStack found in the structure is a raw. The Space Pumping Module is such a table.
        c.rawProviders = Arrays.asList("gtnhintergalactic.recipe.SpacePumpingRecipes#RECIPES");
        c.overrides = Arrays
                .asList("# format: <itemId> => <sourceId>[ ; key=value ]   e.g. someBoard => gt:gt.recipe.pcbfactory");
        c.outputDir = "sgcalc";
        return c;
    }
}
