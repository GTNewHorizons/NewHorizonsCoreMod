package com.dreammaster.gthandler;

import gregtech.api.enums.*;
import gregtech.api.interfaces.IMaterialHandler;
import gregtech.api.objects.MaterialStack;

import java.util.Arrays;

import static gregtech.api.enums.Materials.RedAlloy;

public class GT_CoreModSupport implements IMaterialHandler {

    // public MaterialBuilder addDustItems() {
    //        this.types |= 1;
    //        return this;
    //    }
    //
    //    public MaterialBuilder addMetalItems() {
    //        this.types |= 2;
    //        return this;
    //    }
    //
    //    public MaterialBuilder addGemItems() {
    //        this.types |= 4;
    //        return this;
    //    }
    //
    //    public MaterialBuilder addOreItems() {
    //        this.types |= 8;
    //        return this;
    //    }
    //
    //    public MaterialBuilder addCell() {
    //        this.types |= 16;
    //        return this;
    //    }
    //
    //    public MaterialBuilder addPlasma() {
    //        this.types |= 32;
    //        return this;
    //    }
    //
    //    public MaterialBuilder addToolHeadItems() {
    //        this.types |= 64;
    //        return this;
    //    }
    //
    //    public MaterialBuilder addGearItems() {
    //        this.types |= 128;
    //        return this;
    //    }


    public static Materials RawRadox = new MaterialBuilder(-1,TextureSet.SET_DULL,"Raw Radox").setRGB(80, 30, 80).addFluid().constructMaterial();
    public static Materials RadoxSuperLight = new MaterialBuilder(-1,TextureSet.SET_DULL,"Super Light Radox").setRGB(155, 0, 155).addGas().constructMaterial();
    public static Materials RadoxLight = new MaterialBuilder(-1,TextureSet.SET_DULL,"Light Radox").setRGB(140, 0, 140).addGas().constructMaterial();
    public static Materials RadoxHeavy = new MaterialBuilder(-1,TextureSet.SET_DULL,"Heavy Radox").setRGB(115, 0, 115).addFluid().constructMaterial();
    public static Materials RadoxSuperHeavy = new MaterialBuilder(-1,TextureSet.SET_DULL,"Super Heavy Radox").setRGB(100, 0, 100).addFluid().constructMaterial();
    public static Materials Xenoxene = new MaterialBuilder(-1,TextureSet.SET_DULL,"Xenoxene").setRGB(133, 130, 128).addFluid().constructMaterial();
    public static Materials DelutedXenoxene = new MaterialBuilder(-1,TextureSet.SET_DULL,"Diluted Xenoxene").setRGB(206, 200, 196).addFluid().constructMaterial();
    public static Materials RadoxCracked = new MaterialBuilder(-1,TextureSet.SET_DULL,"Cracked Radox").setRGB(180,130,180).addGas().constructMaterial();
    public static Materials RadoxGas = new MaterialBuilder(-1,TextureSet.SET_DULL,"Radox Gas").setRGB(255,130,255).addGas().constructMaterial();
    public static Materials RadoxPolymer = new Materials(
            979, //Material ID was choosen randomly
            TextureSet.SET_DULL,
            8.0F,346,3,
            1|2|16,
            133, 0, 128,0,
            "RadoxPoly","Radox Polymer",
            0,0,
            6203,
            0,true, false,
            1,   1,   1,
            Dyes.dyePurple,0,
            Arrays.asList(
                    new MaterialStack(Materials.Carbon, 14),
                    new MaterialStack(Materials.Osmium, 11),
                    new MaterialStack(Materials.Oxygen, 7),
                    new MaterialStack(Materials.Silver, 3),
                    new MaterialStack(Materials.CallistoIce, 1)
            ),
            Arrays.asList(
                    new TC_Aspects.TC_AspectStack(TC_Aspects.HUMANUS, 2)
            )
    ).setHasCorrespondingGas(true).setGasTemperature(12406);

    public GT_CoreModSupport() {
        Materials.add(this);
    }

    @Override
    public void onMaterialsInit() {
        /** This is just left here as an example of how to add new materials. **/
        /*
        int i = 0;
        for (int j = GregTech_API.sMaterialProperties.get("general", "AmountOfCustomMaterialSlots", 16); i < j; i++) {
            String aID = (i < 10 ? "0" : "") + i;
            new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 0, 0, 255, 255, 255, 0, "CustomMat" + aID, "CustomMat" + aID, 0, 0, 0, 0, false, false, 1, 1, 1, Dyes._NULL, "custom", true, aID);
        }
        */
    }

    @Override
    public void onComponentInit() {
        for(OrePrefixes ore:OrePrefixes.values()){
            ore.enableComponent(RedAlloy);
            //ore.enableComponent(SomeMaterial);
        }

        /** This is just left here as an example of how to add components. **/
        /*
        //Enabling specific components:
        OrePrefixes.spring.enableComponent(Materials.Cobalt);
        OrePrefixes.ingotDouble.enableComponent(Materials.Cobalt);
        OrePrefixes.ingotTriple.enableComponent(Materials.Cobalt);
        OrePrefixes.ingotQuadruple.enableComponent(Materials.Cobalt);
        OrePrefixes.ingotQuintuple.enableComponent(Materials.Cobalt);
        OrePrefixes.plateDouble.enableComponent(Materials.Cobalt);
        OrePrefixes.plateTriple.enableComponent(Materials.Cobalt);
        OrePrefixes.plateQuadruple.enableComponent(Materials.Cobalt);
        OrePrefixes.plateQuintuple.enableComponent(Materials.Cobalt);
        OrePrefixes.plateDense.enableComponent(Materials.Cobalt);
        */
    }

    @Override
    public void onComponentIteration(Materials aMaterial) {
        /** This is just left here as an example of how to add components. **/
        /*
        //Enabling/Disabling components depending on the current Materials values:
        if ((aMaterial.mTypes & 0x40) != 0) { //This material can be made into tool heads
            OrePrefixes.plateQuadruple.mDisabledItems.remove(aMaterial);
        }
        */
    }
}
