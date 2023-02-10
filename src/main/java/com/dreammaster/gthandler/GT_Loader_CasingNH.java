package com.dreammaster.gthandler;

import com.dreammaster.gthandler.casings.GT_Block_CasingsNH;
import com.dreammaster.gthandler.casings.GT_Container_CasingsNH;

/**
 * ALERT: This class, unlike all other Loaders in this package, is called from MainRegistry at INIT stage directly
 */
public class GT_Loader_CasingNH {

    public static void load() {
        GT_Container_CasingsNH.sBlockCasingsNH = new GT_Block_CasingsNH();
    }
}
