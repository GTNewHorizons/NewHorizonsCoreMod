package com.dreammaster.berriespp;

import com.dreammaster.item.NHItemList;
import com.gtnewhorizons.postea.api.ItemStackReplacementManager;
import com.gtnewhorizons.postea.utility.MissingMappingHandler;

public class BPPConverter {

    public static final String BPP_MOD_ID = "berriespp";

    public static void doPostInitialization() {
        MissingMappingHandler.addIgnore(BPP_MOD_ID + ":Modifier");
        ItemStackReplacementManager
                .addSimpleReplacement(BPP_MOD_ID + ":Modifier", 2, NHItemList.NANCertificate.get(1), true);
    }
}
