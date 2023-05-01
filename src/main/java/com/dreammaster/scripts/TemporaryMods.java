package com.dreammaster.scripts;

public enum TemporaryMods {

    EnhancedLootBags("enhancedlootbags"),
    BetterBuildersWands("betterbuilderswands"),
    BinnieCore("BinnieCore"),
    BuildCraftBuilders("BuildCraft|Builders"),
    BuildCraftRobotics("BuildCraft|Robotics"),
    ProjectRedExpansion("ProjRed|Expansion"),
    ProjectRedTransportation("ProjRed|Transportation"),
    BuildCraftCompat("BuildCraft|Compat"),
    CatWalks("catwalks"),
    ProjectRedExploration("ProjRed|Exploration"),
    CompactKineticGenerators("compactkineticgenerators"),
    WirelessRedstoneCBELogic("WR-CBE|Logic"),
    WirelessRedstoneCBECore("WR-CBE|Core"),
    IronChestsMinecarts("ironchestminecarts"),
    GraviSuiteNEO("gravisuiteneo"),
    GalacticraftAmunRa("GalacticraftAmunRa"),
    TinkersMechworks("TMechworks"),
    AE2WCT("ae2wct"),
    StructureLib("structurelib"),
    ProjectRedTransmission("ProjRed|Transmission"),
    MCFrames("MCFrames"),
    LogisticsPipes("LogisticsPipes"),
    ProjectBlue("ProjectBlue"),
    ProjectRedFabrication("ProjRed|Fabrication"),
    StevesFactoryManager("StevesFactoryManager"),
    StevesAddons("StevesAddons"),
    TinkersDefence("tinkersdefense"),
    WirelessRedstoneCBEAddons("WR-CBE|Addons"),
    QuestBook("questbook"),

    ;

    TemporaryMods(String id) {
        this.ID = id;
    }

    public String ID = "";
}
