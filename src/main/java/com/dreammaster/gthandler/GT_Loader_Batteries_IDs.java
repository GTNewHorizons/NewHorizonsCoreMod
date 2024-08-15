package com.dreammaster.gthandler;

public enum GT_Loader_Batteries_IDs {
    BatteryHull_EV(503),
    BatteryHull_IV(504),
    BatteryHull_LuV(505),
    BatteryHull_ZPM(506),
    BatteryHull_UV(507),
    BatteryHull_EV_Full(540),
    BatteryHull_IV_Full(545),
    BatteryHull_LuV_Full(550),
    BatteryHull_ZPM_Full(555),
    BatteryHull_UV_Full(560),
    BatteryHull_UHV_Full(570),
    BatteryHull_UEV_Full(575),
    BatteryHull_UIV_Full(580),
    BatteryHull_UMV_Full(585),
    BatteryHull_UxV_Full(590),
    BatteryHull_UHV(561),
    BatteryHull_UEV(562),
    BatteryHull_UIV(563),
    BatteryHull_UMV(564),
    BatteryHull_UxV(565),
    ;

    public final int ID;

    GT_Loader_Batteries_IDs (int ID) {
        this.ID = ID;
    }
}
