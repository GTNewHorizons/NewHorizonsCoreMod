package com.dreammaster.gthandler.tileEntities;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofChain;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.withChannel;
import static gregtech.api.enums.GT_HatchElement.Energy;
import static gregtech.api.enums.GT_HatchElement.InputBus;
import static gregtech.api.enums.GT_HatchElement.InputHatch;
import static gregtech.api.enums.GT_HatchElement.Maintenance;
import static gregtech.api.enums.GT_HatchElement.OutputBus;
import static gregtech.api.util.GT_StructureUtility.buildHatchAdder;
import static gregtech.api.util.GT_StructureUtility.ofCoil;
import static gregtech.api.util.GT_Utility.filterValidMTEs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;

import com.github.bartimaeusnek.bartworks.API.BorosilicateGlass;
import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import gregtech.api.GregTech_API;
import gregtech.api.enums.HeatingCoilLevel;
import gregtech.api.enums.TAE;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_ExtendedPowerMultiBlockBase;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Input;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_InputBus;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_OverclockCalculator;
import gregtech.api.util.GT_Recipe;
import gtPlusPlus.api.objects.minecraft.BlockPos;
import gtPlusPlus.core.lib.CORE;
import gtPlusPlus.core.util.reflect.ReflectionUtils;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Steam_BusInput;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.base.GT_MetaTileEntity_Hatch_CustomFluidBase;
import gtPlusPlus.xmod.gregtech.common.blocks.textures.TexturesGtBlock;

public class GregtechMetaTileEntity_Mega_Adv_EBF
        extends GT_MetaTileEntity_ExtendedPowerMultiBlockBase<GregtechMetaTileEntity_Mega_Adv_EBF>
        implements ISurvivalConstructable {

    public static int CASING_TEXTURE_ID;

    public byte glassTier = 0;
    public static String mHotFuelName = "Blazing Pyrotheum";
    public static String mCasingName = "Volcanus Casing";
    public static String mHatchName = "Pyrotheum Hatch";
    private static IStructureDefinition<GregtechMetaTileEntity_Mega_Adv_EBF> STRUCTURE_DEFINITION = null;
    private int mCasing;
    private final ArrayList<GT_MetaTileEntity_Hatch_CustomFluidBase> mPyrotheumHatches = new ArrayList<>();

    private HeatingCoilLevel mHeatingCapacity = HeatingCoilLevel.None;

    public GregtechMetaTileEntity_Mega_Adv_EBF(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        CASING_TEXTURE_ID = TAE.getIndexFromPage(2, 11);
    }

    public GregtechMetaTileEntity_Mega_Adv_EBF(String aName) {
        super(aName);
        CASING_TEXTURE_ID = TAE.getIndexFromPage(2, 11);
    }

    public String getMachineType() {
        return "Blast Furnace";
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GregtechMetaTileEntity_Mega_Adv_EBF(this.mName);
    }

    @Override
    protected GT_Multiblock_Tooltip_Builder createTooltip() {
        GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType(getMachineType()).addInfo("Universe Grade Advanced Blast Furnace")
                .addInfo("Speed: +1000% | EU Usage: 65% | Parallel: 8192")
                .addInfo("Consumes 20,000L of " + mHotFuelName + " per second during operation")
                .addInfo("Has 10x boost to heat temperature!").addSeparator().addController("Bottom center")
                .addCasingInfoMin(mCasingName, 8, false).addInputHatch("Any Casing", 1).addInputBus("Any Casing", 1)
                .addOutputBus("Any Casing", 1).addOutputHatch("Any Casing", 1).addEnergyHatch("Any Casing", 1)
                .addMaintenanceHatch("Any Casing", 1).addOtherStructurePart(mHatchName, "Any Casing", 1)
                .toolTipFinisher(CORE.GT_Tooltip_Builder.get());
        return tt;
    }

    @Override
    public IStructureDefinition<GregtechMetaTileEntity_Mega_Adv_EBF> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<GregtechMetaTileEntity_Mega_Adv_EBF>builder()
                    .addShape(
                            mName,
                            transpose(
                                    new String[][] {
                                            { "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "             EEE             ", "            EBBBE            ",
                                                    "            EBBBE            ", "            EBBBE            ",
                                                    "             EEE             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             " },
                                            { "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "            DDDDD            ", "           DDDDDDD           ",
                                                    "          DDDDDDDDD          ", "          DDDDDDDDD          ",
                                                    "          DDDDDDDDD          ", "          DDDDDDDDD          ",
                                                    "          DDDDDDDDD          ", "           DDDDDDD           ",
                                                    "            DDDDD            ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             " },
                                            { "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "            DDDDD            ",
                                                    "          DDDDDDDDD          ", "          DDDDDDDDD          ",
                                                    "         DDDDDDDDDDD         ", "         DDDDDDDDDDD         ",
                                                    "         DDDDDDDDDDD         ", "         DDDDDDDDDDD         ",
                                                    "         DDDDDDDDDDD         ", "          DDDDDDDDD          ",
                                                    "          DDDDDDDDD          ", "            DDDDD            ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             " },
                                            { "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "            DDDDD            ", "          DDDDDDDDD          ",
                                                    "         DDDDDDDDDDD         ", "         DDDDDDDDDDD         ",
                                                    "        DDDDDDDDDDDDD        ", "        DDDDDDDDDDDDD        ",
                                                    "        DDDDDDDDDDDDD        ", "        DDDDDDDDDDDDD        ",
                                                    "        DDDDDDDDDDDDD        ", "         DDDDDDDDDDD         ",
                                                    "         DDDDDDDDDDD         ", "          DDDDDDDDD          ",
                                                    "            DDDDD            ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             " },
                                            { "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "            DDDDD            ",
                                                    "          DDDDDDDDD          ", "         DDDDDDDDDDD         ",
                                                    "        DDDDDDDDDDDDD        ", "        DDDDDDDDDDDDD        ",
                                                    "       DDDDDDDDDDDDDDD       ", "       DDDDDDDDDDDDDDD       ",
                                                    "       DDDDDDDDDDDDDDD       ", "       DDDDDDDDDDDDDDD       ",
                                                    "       DDDDDDDDDDDDDDD       ", "        DDDDDDDDDDDDD        ",
                                                    "        DDDDDDDDDDDDD        ", "         DDDDDDDDDDD         ",
                                                    "          DDDDDDDDD          ", "            DDDDD            ",
                                                    "                             ", "                             ",
                                                    "                             " },
                                            { "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "             E E             ",
                                                    "             EEE             ", "           EEDDDEE           ",
                                                    "         EEDDDDDDDEE         ", "        EDDDDDDDDDDDD        ",
                                                    "       EEDDDDDDDDDDDD        ", "       DDDDDDDDDDDDDDDE      ",
                                                    "       DDDDDDDDDDDDDDD       ", "       DDDDDDDDDDDDDDD       ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "       DDDDDDDDDDDDDDD       ",
                                                    "       DDDDDDDDDDDDDDD       ", "       DDDDDDDDDDDDDDD       ",
                                                    "        DDDDDDDDDDDDD        ", "        DDDDDDDDDDDDD        ",
                                                    "         DDDDDDDDDDD         ", "           DDDDDDD           ",
                                                    "              D              ", "                             ",
                                                    "                             " },
                                            { "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "                             ", "    E                   E    ",
                                                    "   EEE                 EEE   ", "    E                   E    ",
                                                    "                             ", "            EB~BE            ",
                                                    "           DDDDDDD           ", "          DDDDDDDDD          ",
                                                    "        DDDDDDDDDDDDE        ", "        DDDDDDDDDDDDDE       ",
                                                    "      EDDDDDDDDDDDDDDDE      ", "      EDDDDDDDDDDDDDDDB      ",
                                                    "      DDDDDDDDDDDDDDDDE      ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "       DDDDDDDDDDDDDDD       ", "        DDDDDDDDDDDDD        ",
                                                    "        DDDDDDDDDDDDD        ", "          DDDDDDDDD          ",
                                                    "           DDDDDDD           ", "                             ",
                                                    "                             " },
                                            { "                             ", "                             ",
                                                    "                             ", "                             ",
                                                    "    E                   E    ", "  EEEEE               EEEEE  ",
                                                    "  EEEEE               EEEEE  ", "   EBE                 EBE   ",
                                                    "    B                   B    ", "    B       EBBBE       B    ",
                                                    "    B     DDDDDDDDD     B    ", "    B    DDDDDDDDDDD    B    ",
                                                    "    B   DDDDDDDDDDDDD   B    ", "    B EDDDDDDDDDDDDDDDE B    ",
                                                    "    BBDDDDDDDDDDDDDDDDB B    ", "      EDDDDDDDDDDDDDDDDBB    ",
                                                    "      DDDDDDDDDDDDDDDDB      ", "      DDDDDDDDDDDDDDDDDE     ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "       DDDDDDDDDDDDDDD       ",
                                                    "        DDDDDDDDDDDDD        ", "         DDDDDDDDDDD         ",
                                                    "          DDDDDDDDD          ", "                             ",
                                                    "                             " },
                                            { " EE   EE             EE   EE ", "EDDE EDDE           EDDE EDDE",
                                                    "EDBDEDBDE           EDBDEDBDE", "EDBBDBBDE           EDBBDBBDE",
                                                    "EDBEBEBDE           EDBEBEBDE", "EDBEEEBDE           EDBEEEBDE",
                                                    "EDBBBBBDE           EDBBBBBDE", " EDDEDDE             EDDEDDE ",
                                                    "  EEEEE               EEEEE  ", "            DEBED            ",
                                                    "          DDDDDDDDD          ", "        DDDDDDDDDDDD         ",
                                                    "       DDDDDDDDDDDDDD        ", "      EDDDDDDDDDDDDDDDE      ",
                                                    "     EDDDDDDDDDDDDDDDDDE     ", "     EDDDDDDDDDDDDDDDDDE     ",
                                                    "     DDDDDDDDDDDDDDDDDDE     ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "       DDDDDDDDDDDDDDD       ",
                                                    "       DDDDDDDDDDDDDDD       ", "        DDDDDDDDDDDDD        ",
                                                    "          DDDDDDDDD          ", "            DDDDD            ",
                                                    "                             " },
                                            { " AA   AA             AA   AA ", "A  A A  A           A  A A  A",
                                                    "A C A C A           A C A C A", "A CC CC A           A CC CC A",
                                                    "A C C C A           A C C C A", "A C   C A           A C   C A",
                                                    "A CCCCC A           A CCCCC A", " A     A             A     A ",
                                                    "  AAAAA               AAAAA  ", "           DDDEDDD           ",
                                                    "         DDDDDDDDDDD         ", "        DDDDDDDDDDDDD        ",
                                                    "       DDDDDDDDDDDDDDD       ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "     EDDDDDDDDDDDDDDDDD      ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "       DDDDDDDDDDDDDDD       ", "        DDDDDDDDDDDDD        ",
                                                    "         DDDDDDDDDDD         ", "           DDDDDDD           ",
                                                    "                             " },
                                            { " AA   AA             AA   AA ", "A  A A  A           A  A A  A",
                                                    "A C A C A           A C A C A", "A CC CC A           A CC CC A",
                                                    "A C C C A           A C C C A", "A C   C A           A C   C A",
                                                    "A CCCCC A           A CCCCC A", " A     A             A     A ",
                                                    "  AAAAA               AAAAA  ", "          DDDDDDDDD          ",
                                                    "         DDDDDDDDDDD         ", "       DDDDDDDDDDDDDDD       ",
                                                    "       DDDDDDDDDDDDDDD       ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "     DDDDDDDDDDDDDDDDDDD     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "      DDDDDDDDDDDDDDDDD      ",
                                                    "       DDDDDDDDDDDDDDD       ", "       DDDDDDDDDDDDDDD       ",
                                                    "         DDDDDDDDDDD         ", "          DDDDDDDDD          ",
                                                    "                             " },
                                            { " AA   AA             AA   AA ", "A  A A  A           A  A A  A",
                                                    "A  CA  CA           A  CA  CA", "A  CC CCA           A  CC CCA",
                                                    "A  CCCCCA           A  CCCCCA", "A  C  CCA           A  C  CCA",
                                                    "A  CCCCCA           A  CCCCCA", " A     A             A     A ",
                                                    "  AAAAA    EEEEEEE    AAAAA  ", "         EDDDDDDDDDE         ",
                                                    "        DDDDDDDDDDDDD        ", "       DDDDDDDDDDDDDDD       ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "     EDDDDDDDDDDDDDDDDDE     ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "    EDDDDDDDDDDDDDDDDDDDE    ",
                                                    "    EDDDDDDDDDDDDDDDDDDDE    ", "    DDDDDDDDDDDDDDDDDDDDD    ",
                                                    "    DDDDDDDDDDDDDDDDDDDDD    ", "    DDDDDDDDDDDDDDDDDDDDD    ",
                                                    "    EDDDDDDDDDDDDDDDDDDDE    ", "    EDDDDDDDDDDDDDDDDDDDE    ",
                                                    "     DDDDDDDDDDDDDDDDDDD     ", "     EDDDDDDDDDDDDDDDDDE     ",
                                                    "      DDDDDDDDDDDDDDDDD      ", "       DDDDDDDDDDDDDDD       ",
                                                    "        DDDDDDDDDDDDD        ", "         EDDDDDDDDDE         ",
                                                    "           EEDDDEE           " },
                                            { " AA   AA             AA   AA ", "A  A A  A           A  A A  A",
                                                    "A  CA  CA           A  CA  CA", "A  CC CCA           A  CC CCA",
                                                    "A  CCCCCA           A  CCCCCA", "A  C  CCA           A  C  CCA",
                                                    "A  CCCCCA           A  CCCCCA", " A     A             A     A ",
                                                    "  AAAAA    AAAAAAA    AAAAA  ", "         AA       AA         ",
                                                    "        A   CDCDC   A        ", "       A  DCCCCCCCD  A       ",
                                                    "      A  CCCCCCCCCCC  A      ", "     A  CCCCCCCCCCCCC  A     ",
                                                    "     A DCCCCCCCCCCCCCD A     ", "    A  CCCCCCCCCCCCCCC  A    ",
                                                    "    A CCCCCCCCCCCCCCCCC A    ", "    A DCCCCCCCCCCCCCCCD A    ",
                                                    "    A CCCCCCCCCCCCCCCCC A    ", "    A DCCCCCCCCCCCCCCCD A    ",
                                                    "    A CCCCCCCCCCCCCCCCC A    ", "    A  CCCCCCCCCCCCCCC  A    ",
                                                    "     A DCCCCCCCCCCCCCD A     ", "     A  CCCCCCCCCCCCC  A     ",
                                                    "      A  CCCCCCCCCCC  A      ", "       A  DCCCCCCCD  A       ",
                                                    "        A   CDCDC   A        ", "         AA       AA         ",
                                                    "           AAAAAAA           " },
                                            { " AA   AA             AA   AA ", "A  A A  A           A  A A  A",
                                                    "A C A C A           A C A C A", "A CC CC A           A CC CC A",
                                                    "A C C C A           A C C C A", "A C   C A           A C   C A",
                                                    "A CCCCC A           A CCCCC A", " A     A             A     A ",
                                                    "  AAAAA    AAAAAAA    AAAAA  ", "         AA       AA         ",
                                                    "        A   CDCDC   A        ", "       A  DCCCCCCCD  A       ",
                                                    "      A  CCCCCCCCCCC  A      ", "     A  CCCCCCCCCCCCC  A     ",
                                                    "     A DCCCCCCCCCCCCCD A     ", "    A  CCCCCCCCCCCCCCC  A    ",
                                                    "    A CCCCCCCCCCCCCCCCC A    ", "    A DCCCCCCCCCCCCCCCD A    ",
                                                    "    A CCCCCCCCCCCCCCCCC A    ", "    A DCCCCCCCCCCCCCCCD A    ",
                                                    "    A CCCCCCCCCCCCCCCCC A    ", "    A  CCCCCCCCCCCCCCC  A    ",
                                                    "     A DCCCCCCCCCCCCCD A     ", "     A  CCCCCCCCCCCCC  A     ",
                                                    "      A  CCCCCCCCCCC  A      ", "       A  DCCCCCCCD  A       ",
                                                    "        A   CDCDC   A        ", "         AA       AA         ",
                                                    "           AAAAAAA           " },
                                            { " AA   AA             AA   AA ", "A  A A  A           A  A A  A",
                                                    "A C A C A           A C A C A", "A CC CC A           A CC CC A",
                                                    "A C C C A           A C C C A", "A C   C A           A C   C A",
                                                    "A CCCCC A           A CCCCC A", " A     A             A     A ",
                                                    "  AAAAA    AAAAAAA    AAAAA  ", "         AA       AA         ",
                                                    "        A   CDCDC   A        ", "       A  DCCCCCCCD  A       ",
                                                    "      A  CCCCCCCCCCC  A      ", "     A  CCCCCCCCCCCCC  A     ",
                                                    "     A DCCCCCCCCCCCCCD A     ", "    A  CCCCCCCCCCCCCCC  A    ",
                                                    "    A CCCCCCCCCCCCCCCCC A    ", "    A DCCCCCCCCCCCCCCCD A    ",
                                                    "    A CCCCCCCCCCCCCCCCC A    ", "    A DCCCCCCCCCCCCCCCD A    ",
                                                    "    A CCCCCCCCCCCCCCCCC A    ", "    A  CCCCCCCCCCCCCCC  A    ",
                                                    "     A DCCCCCCCCCCCCCD A     ", "     A  CCCCCCCCCCCCC  A     ",
                                                    "      A  CCCCCCCCCCC  A      ", "       A  DCCCCCCCD  A       ",
                                                    "        A   CDCDC   A        ", "         AA       AA         ",
                                                    "           AAAAAAA           " },
                                            { " EE   EE             EE   EE ", "EEEE EEEE           EEEE EEEE",
                                                    "EEEEEEEEE           EEEEEEEEE", "EEEEEEEEE           EEEEEEEEE",
                                                    "EEEEEEEEE           EEEEEEEEE", "EEEEEEEEE           EEEEEEEEE",
                                                    "EEEEEEEEE           EEEEEEEEE", " EEEEEEE             EEEEEEE ",
                                                    "  EEEEE    EEEEEEE    EEEEE  ", "         EEEEEEEEEEE         ",
                                                    "        EEEEEEEEEEEEE        ", "       EEEEEEEEEEEEEEE       ",
                                                    "      EEEEEEEEEEEEEEEEE      ", "     EEEEEEEEEEEEEEEEEEE     ",
                                                    "     EEEEEEEEEEEEEEEEEEE     ", "    EEEEEEEEEEEEEEEEEEEEE    ",
                                                    "    EEEEEEEEEEEEEEEEEEEEE    ", "    EEEEEEEEEEEEEEEEEEEEE    ",
                                                    "    EEEEEEEEEEEEEEEEEEEEE    ", "    EEEEEEEEEEEEEEEEEEEEE    ",
                                                    "    EEEEEEEEEEEEEEEEEEEEE    ", "    EEEEEEEEEEEEEEEEEEEEE    ",
                                                    "     EEEEEEEEEEEEEEEEEEE     ", "     EEEEEEEEEEEEEEEEEEE     ",
                                                    "      EEEEEEEEEEEEEEEEE      ", "       EEEEEEEEEEEEEEE       ",
                                                    "        EEEEEEEEEEEEE        ", "         EEEEEEEEEEE         ",
                                                    "           EEEEEEE           " } }))
                    .addElement(
                            'E',
                            ofChain(
                                    buildHatchAdder(GregtechMetaTileEntity_Mega_Adv_EBF.class)
                                            .adder(GregtechMetaTileEntity_Mega_Adv_EBF::addPyrotheumHatch).hatchId(968)
                                            .casingIndex(CASING_TEXTURE_ID).dot(1).build(),
                                    buildHatchAdder(GregtechMetaTileEntity_Mega_Adv_EBF.class)
                                            .atLeast(InputBus, OutputBus, Maintenance, Energy, InputHatch)
                                            .casingIndex(CASING_TEXTURE_ID).dot(1).build()))
                    .addElement(
                            'C',
                            ofCoil(
                                    GregtechMetaTileEntity_Mega_Adv_EBF::setCoilLevel,
                                    GregtechMetaTileEntity_Mega_Adv_EBF::getCoilLevel))
                    .addElement(
                            'A',
                            withChannel(
                                    "glass",
                                    BorosilicateGlass
                                            .ofBoroGlass((byte) -1, (te, t) -> te.glassTier = t, te -> te.glassTier)))
                    .addElement('B', ofBlock(GregTech_API.sBlockCasings1, 14))
                    .addElement('D', ofBlock(GregTech_API.sBlockCasings1, 13)).build();
        }
        return STRUCTURE_DEFINITION;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(mName, stackSize, hintsOnly, 14, 6, 9);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivialBuildPiece(mName, stackSize, 14, 6, 9, elementBudget, env, false, true);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        mCasing = 0;
        mPyrotheumHatches.clear();
        setCoilLevel(HeatingCoilLevel.None);
        boolean pieceCheck = checkPiece(mName, 14, 6, 9);
        boolean coilCheck = getCoilLevel() != HeatingCoilLevel.None;
        boolean hatchCheck = checkHatch();
        return pieceCheck && coilCheck && hatchCheck;
    }

    public boolean checkHatch() {
        return mMaintenanceHatches.size() <= 1 && !mPyrotheumHatches.isEmpty();
    }

    private boolean addPyrotheumHatch(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        if (aTileEntity == null) {
            return false;
        } else {
            IMetaTileEntity aMetaTileEntity = aTileEntity.getMetaTileEntity();
            if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_CustomFluidBase
                    && aMetaTileEntity.getBaseMetaTileEntity().getMetaTileID() == 968) {
                return addToMachineListInternal(mPyrotheumHatches, aTileEntity.getMetaTileEntity(), aBaseCasingIndex);
            }
        }
        return false;
    }

    @Override
    public void updateSlots() {
        for (GT_MetaTileEntity_Hatch_CustomFluidBase tHatch : filterValidMTEs(mPyrotheumHatches)) tHatch.updateSlots();
        super.updateSlots();
    }

    protected IIconContainer getActiveOverlay() {
        return TexturesGtBlock.Overlay_Machine_Controller_Advanced_Active;
    }

    protected IIconContainer getInactiveOverlay() {
        return TexturesGtBlock.Overlay_Machine_Controller_Advanced;
    }

    protected int getCasingTextureId() {
        return CASING_TEXTURE_ID;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return RecipeMaps.blastFurnaceRecipes;
    }

    @Override
    public int getRecipeCatalystPriority() {
        return -1;
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return true;
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic() {

            @NotNull
            @Override
            protected CheckRecipeResult validateRecipe(@NotNull GT_Recipe recipe) {
                return recipe.mSpecialValue <= getCoilLevel().getHeat() ? CheckRecipeResultRegistry.SUCCESSFUL
                        : CheckRecipeResultRegistry.insufficientHeat(recipe.mSpecialValue);
            }

            @NotNull
            @Override
            protected GT_OverclockCalculator createOverclockCalculator(@NotNull GT_Recipe recipe) {
                return super.createOverclockCalculator(recipe).setHeatOC(true).setHeatDiscount(true)
                        .setRecipeHeat(recipe.mSpecialValue).setMachineHeat((int) getCoilLevel().getHeat() * 10);
            }
        }.setSpeedBonus(1F / 10F).setEuModifier(0.65F).setMaxParallelSupplier(this::getMaxParallelRecipes);
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public int getPollutionPerSecond(ItemStack aStack) {
        return 0;
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        return 0;
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return false;
    }

    private int mGraceTimer = 2;

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
        // Try dry Pyrotheum after all other logic
        if (this.mStartUpCheck < 0) {
            if (this.mMaxProgresstime > 0 && this.mProgresstime != 0
                    || this.getBaseMetaTileEntity().hasWorkJustBeenEnabled()) {
                if (aTick % 10 == 0 || this.getBaseMetaTileEntity().hasWorkJustBeenEnabled()) {
                    if (!this.depleteInputFromRestrictedHatches(this.mPyrotheumHatches, 10_000)) {
                        if (mGraceTimer-- == 0) {
                            this.causeMaintenanceIssue();
                            this.stopMachine();
                            mGraceTimer = 2;
                        }
                    }
                }
            }
        }
    }

    public int getMaxParallelRecipes() {
        return 8192;
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        if (!aNBT.hasKey(INPUT_SEPARATION_NBT_KEY)) {
            inputSeparation = aNBT.getBoolean("isBussesSeparate");
        }
    }

    protected ITexture getCasingTexture() {
        return Textures.BlockIcons.getCasingTextureForId(getCasingTextureId());
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection facing,
            int aColorIndex, boolean aActive, boolean aRedstone) {
        if (side == facing) {
            if (aActive) return new ITexture[] { getCasingTexture(),
                    TextureFactory.builder().addIcon(getActiveOverlay()).extFacing().build() };
            return new ITexture[] { getCasingTexture(),
                    TextureFactory.builder().addIcon(getInactiveOverlay()).extFacing().build() };
        }
        return new ITexture[] { getCasingTexture() };
    }

    public HeatingCoilLevel getCoilLevel() {
        return mHeatingCapacity;
    }

    public void setCoilLevel(HeatingCoilLevel aCoilLevel) {
        mHeatingCapacity = aCoilLevel;
    }

    @Override
    public boolean supportsInputSeparation() {
        return true;
    }

    public <E> boolean addToMachineListInternal(ArrayList<E> aList, final IMetaTileEntity aTileEntity,
            final int aBaseCasingIndex) {
        if (aTileEntity == null) {
            return false;
        }

        // Check type
        /*
         * Class <?> aHatchType = ReflectionUtils.getTypeOfGenericObject(aList); if
         * (!aHatchType.isInstance(aTileEntity)) { return false; }
         */

        // Try setRecipeMap

        try {
            if (aTileEntity instanceof GT_MetaTileEntity_Hatch_Input) {
                resetRecipeMapForHatch((GT_MetaTileEntity_Hatch) aTileEntity, getRecipeMap());
            }
            if (aTileEntity instanceof GT_MetaTileEntity_Hatch_InputBus) {
                resetRecipeMapForHatch((GT_MetaTileEntity_Hatch) aTileEntity, getRecipeMap());
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        if (aList.isEmpty()) {
            if (aTileEntity instanceof GT_MetaTileEntity_Hatch) {
                updateTexture(aTileEntity, aBaseCasingIndex);
                return aList.add((E) aTileEntity);
            }
        } else {
            IGregTechTileEntity aCur = aTileEntity.getBaseMetaTileEntity();
            if (aList.contains(aTileEntity)) {
                return false;
            }
            BlockPos aCurPos = new BlockPos(aCur);
            boolean aExists = false;
            for (E m : aList) {
                IGregTechTileEntity b = ((IMetaTileEntity) m).getBaseMetaTileEntity();
                if (b != null) {
                    BlockPos aPos = new BlockPos(b);
                    if (aPos != null) {
                        if (aCurPos.equals(aPos)) {
                            return false;
                        }
                    }
                }
            }
            if (aTileEntity instanceof GT_MetaTileEntity_Hatch) {
                updateTexture(aTileEntity, aBaseCasingIndex);
                return aList.add((E) aTileEntity);
            }
        }
        return false;
    }

    public boolean updateTexture(final IMetaTileEntity aTileEntity, int aCasingID) {
        try { // gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch.updateTexture(int)

            final IMetaTileEntity aMetaTileEntity = aTileEntity;
            if (aMetaTileEntity == null) {
                return false;
            }
            Method mProper = ReflectionUtils.getMethod(GT_MetaTileEntity_Hatch.class, "updateTexture", int.class);
            if (mProper != null) {
                if (GT_MetaTileEntity_Hatch.class.isInstance(aMetaTileEntity)) {
                    mProper.setAccessible(true);
                    mProper.invoke(aMetaTileEntity, aCasingID);
                    // log("Good Method Call for updateTexture.");
                    return true;
                }
            } else {

                if (GT_MetaTileEntity_Hatch.class.isInstance(aMetaTileEntity)) {
                    if (aCasingID <= Byte.MAX_VALUE) {
                        ((GT_MetaTileEntity_Hatch) aTileEntity).updateTexture(aCasingID);
                        return true;
                    }
                }
            }
            return false;
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean resetRecipeMapForHatch(GT_MetaTileEntity_Hatch aTileEntity, RecipeMap<?> aMap) {
        if (aTileEntity == null) {
            return false;
        }
        final IMetaTileEntity aMetaTileEntity = aTileEntity;
        if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_Input
                || aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_InputBus
                || aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_Steam_BusInput) {
            if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_Input) {
                ((GT_MetaTileEntity_Hatch_Input) aMetaTileEntity).mRecipeMap = null;
                ((GT_MetaTileEntity_Hatch_Input) aMetaTileEntity).mRecipeMap = aMap;
            } else if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_InputBus) {
                ((GT_MetaTileEntity_Hatch_InputBus) aMetaTileEntity).mRecipeMap = null;
                ((GT_MetaTileEntity_Hatch_InputBus) aMetaTileEntity).mRecipeMap = aMap;
            } else {
                ((GT_MetaTileEntity_Hatch_Steam_BusInput) aMetaTileEntity).mRecipeMap = null;
                ((GT_MetaTileEntity_Hatch_Steam_BusInput) aMetaTileEntity).mRecipeMap = aMap;
            }
            return true;
        } else {
            return false;
        }
    }

    protected boolean depleteInputFromRestrictedHatches(Collection<GT_MetaTileEntity_Hatch_CustomFluidBase> aHatches,
            int aAmount) {
        for (final GT_MetaTileEntity_Hatch_CustomFluidBase tHatch : filterValidMTEs(aHatches)) {
            FluidStack tLiquid = tHatch.getFluid();
            if (tLiquid == null || tLiquid.amount < aAmount) {
                continue;
            }
            tLiquid = tHatch.drain(aAmount, false);
            if (tLiquid != null && tLiquid.amount >= aAmount) {
                tLiquid = tHatch.drain(aAmount, true);
                return tLiquid != null && tLiquid.amount >= aAmount;
            }
        }
        return false;
    }

    public boolean causeMaintenanceIssue() {
        boolean b = false;
        switch (this.getBaseMetaTileEntity().getRandomNumber(6)) {
            case 0 -> {
                this.mWrench = false;
                b = true;
            }
            case 1 -> {
                this.mScrewdriver = false;
                b = true;
            }
            case 2 -> {
                this.mSoftHammer = false;
                b = true;
            }
            case 3 -> {
                this.mHardHammer = false;
                b = true;
            }
            case 4 -> {
                this.mSolderingTool = false;
                b = true;
            }
            case 5 -> {
                this.mCrowbar = false;
                b = true;
            }
        }
        return b;
    }

}
