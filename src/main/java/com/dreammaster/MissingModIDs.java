package com.dreammaster;

import cpw.mods.fml.common.Loader;

public enum MissingModIDs {

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
    DraconicEvolution("DraconicEvolution"),
    ExtraBees("ExtraBees"),
    ExtraTrees("ExtraTrees"),
    EnderZoo("EnderZoo"),
    FloodLights("FloodLights"),
    ForgeMicroblocks("ForgeMicroblock"),
    GalactiGreg("galacticgreg"),
    Gadomancy("gadomancy"),
    Genetics("Genetics"),
    HoloInventory("holoinventory"),
    JABBA("JABBA"),
    MineAndBladeBattleGear2("battlegear2"),
    NEIOrePlugin("gtneioreplugin"),
    OpenBlocks("OpenBlocks"),
    OpenPrinters("openprinter"),
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
    Witchery("witchery"),
    ZTones("Ztones")
    ;

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


