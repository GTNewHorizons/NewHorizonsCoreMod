package com.dreammaster.gthandler;

import com.dreammaster.gthandler.recipes.*;

public class GT_MachineRecipeLoader implements Runnable {

    @Override
    public void run() {
        new RecipeRemoval().run();

        new AlloySmelterRecipes().run();
        new ArcFurnaceRecipes().run();
        new AssemblerRecipes().run();
        new AssemblingLineRecipes().run();
        new AutoclaveRecipes().run();
        new BendingMachineRecipes().run();
        new BlastFurnaceRecipes().run();
        new BrewingMachineRecipes().run();
        new CannerRecipes().run();
        new CentrifugeRecipes().run();
        new ChemicalBathRecipes().run();
        new ChemicalReactorRecipes().run();
        new CircuitAssemblerRecipes().run();
        new CompressorRecipes().run();
        new CuttingMachineRecipes().run();
        new DistillationRecipes().run();
        new DTPFRecipes().run();
        new ElectrolyzerRecipes().run();
        new ExtractorRecipes().run();
        new ExtruderRecipes().run();
        new FermenterRecipes().run();
        new FluidCannerRecipes().run();
        new FluidExtractorRecipes().run();
        new FluidHeaterRecipes().run();
        new FluidSolidifierRecipes().run();
        new ForgeHammerRecipes().run();
        new FormingPressRecipes().run();
        new ImplosionCompressorRecipes().run();
        new LaserEngraverRecipes().run();
        new LatheRecipes().run();
        new MaceratorRecipes().run();
        new MixerRecipes().run();
        new SifterRecipes().run();
        new VacuumFreezerRecipes().run();
        new WiremillRecipes().run();
        new CrackingRecipes().run();
    }

}
