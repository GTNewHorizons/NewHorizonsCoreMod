package com.dreammaster.coremod.transformers.recipenukers;

import java.util.ListIterator;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import com.dreammaster.coremod.DreamCoreMod;
import com.dreammaster.coremod.IDreamTransformer;

public class AdvancedSolarPanelTransformer implements IDreamTransformer {

    @Override
    public String[] targetedClasses() {
        return new String[] { "advsolar.common.AdvancedSolarPanel" };
    }

    @Override
    public void transform(ClassNode classNode) {
        for (MethodNode mn : classNode.methods) {
            if (mn.name.equals("afterModsLoaded")
                    && mn.desc.equals("(Lcpw/mods/fml/common/event/FMLPostInitializationEvent;)V")) {
                // changes afterModsLoaded method to :
                // public void afterModsLoaded(FMLPostInitializationEvent event) {
                // MTAPI.manager = MTRecipeManager.instance;
                // }
                mn.instructions.clear();
                mn.instructions.add(
                        new FieldInsnNode(
                                Opcodes.GETSTATIC,
                                "advsolar/utils/MTRecipeManager",
                                "instance",
                                "Ladvsolar/utils/MTRecipeManager;"));
                mn.instructions.add(
                        new FieldInsnNode(
                                Opcodes.PUTSTATIC,
                                "advsolar/api/MTAPI",
                                "manager",
                                "Ladvsolar/api/IMTRecipeManager;"));
                mn.instructions.add(new InsnNode(Opcodes.RETURN));
                DreamCoreMod.logger.info("Taking a sledgehammer to {}.{}{}", classNode.name, mn.name, mn.desc);
            } else if (mn.name.equals("preInit")
                    && mn.desc.equals("(Lcpw/mods/fml/common/event/FMLPreInitializationEvent;)V")) {
                        // deletes the 4 lines of Recipes.compressor.addRecipe.....
                        final ListIterator<AbstractInsnNode> it = mn.instructions.iterator();
                        boolean isDeleting = false;
                        int ordinal = 0;
                        while (it.hasNext()) {
                            final AbstractInsnNode insnNode = it.next();
                            if (isCompressorFieldNode(insnNode)) {
                                isDeleting = true;
                            }
                            if (isDeleting) {
                                it.remove();
                            }
                            if (isAddRecipeMethodNode(insnNode)) {
                                ordinal++;
                                if (ordinal == 4) break;
                            }
                        }
                        DreamCoreMod.logger.info("Taking a sledgehammer to {}.{}{}", classNode.name, mn.name, mn.desc);
                    }
        }
    }

    private static boolean isCompressorFieldNode(AbstractInsnNode node) {
        return node instanceof FieldInsnNode && node.getOpcode() == Opcodes.GETSTATIC
                && ((FieldInsnNode) node).owner.equals("ic2/api/recipe/Recipes")
                && ((FieldInsnNode) node).name.equals("compressor")
                && ((FieldInsnNode) node).desc.equals("Lic2/api/recipe/IMachineRecipeManager;");
    }

    private static boolean isAddRecipeMethodNode(AbstractInsnNode node) {
        return node instanceof MethodInsnNode && node.getOpcode() == Opcodes.INVOKEINTERFACE
                && ((MethodInsnNode) node).owner.equals("ic2/api/recipe/IMachineRecipeManager")
                && ((MethodInsnNode) node).name.equals("addRecipe")
                && ((MethodInsnNode) node).desc.equals(
                        "(Lic2/api/recipe/IRecipeInput;Lnet/minecraft/nbt/NBTTagCompound;[Lnet/minecraft/item/ItemStack;)V");
    }

}
