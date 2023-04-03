package com.dreammaster;

import cpw.mods.fml.common.Loader;

public enum MissingModIDs {
    Aroma1997Core("Aroma1997Core"),

    AdventureBackpack("adventurebackpack"),
    ArchitectureCraft("ArchitectureCraft"),
    AFSU("AFSU"),
    Backpack("Backpack"),
    Baubles("Baubles"),
    BetterQuesting("betterquesting"),
    BiblioCraft("BiblioCraft"),
    BiblioWoodsBoPEdition("BiblioWoodsBoP"),
    BiblioWoodsForestryEdition("BiblioWoodsForestry"),
    BiblioWoodsNaturaEdition("BiblioWoodsNatura"),
    BloodArsenal("BloodArsenal"),
    BloodMagic("AWWayofTime"),
    Botania("Botania"),
    Botany("Botany"),
    BuildCraftCore("BuildCraft|Core"),
    Chisel("chisel"),
    DraconicEvolution("DraconicEvolution"),
    ExtraBees("ExtraBees"),
    ExtraTrees("ExtraTrees"),
    EnderZoo("EnderZoo"),
    FloodLights("FloodLights"),
    ForgeMicroblocks("ForgeMicroblock"),
    ForgeRelocation("ForgeRelocation"),
    GalactiGreg("galacticgreg"),
    Gadomancy("gadomancy"),
    Genetics("Genetics"),
    HoloInventory("holoinventory"),
    JABBA("JABBA"),
    Mantle("Mantle"),
    MalisisDoors("malisisdoors"),
    MineAndBladeBattleGear2("battlegear2"),
    NEIOrePlugin("gtneioreplugin"),
    NaturesCompass("naturescompass"),
    OpenBlocks("OpenBlocks"),
    OpenGlasses("openglasses"),
    OpenPrinters("openprinter"),
    OpenModularTurrets("openmodularturrets"),
    OpenSecurity("opensecurity"),
    PamsHarvestTheNether("harvestthenether"),
    ProjectRedIllumination("ProjRed|Illumination"),
    ProjectRedCore("ProjRed|Core"),
    RandomThings("RandomThings"),
    SGCraft("SGCraft"),
    SleepingBags("sleepingbag"),
    SpiceOfLife("SpiceOfLife"),
    StevesCarts2("StevesCarts"),
    SuperSolarPanels("supersolarpanel"),
    TravellersGear("TravellersGear"),
    ThaumicEnergistics("thaumicenergistics"),
    ThaumicHorizons("ThaumicHorizons"),
    ThaumicMachina("ThaumicMachina"),
    Witchery("witchery"),
    WarpTheory("WarpTheory"),
    ZTones("Ztones");

    public final String modID;
    private Boolean modLoaded;

    MissingModIDs(String modID) {
        this.modID = modID;
    }

    public boolean isModLoaded() {
        if (this.modLoaded == null) {
            this.modLoaded = Loader.isModLoaded(modID);
        }
        return this.modLoaded;
    }
}
