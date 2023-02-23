package com.dreammaster.coremod.transformers.recipenukers;

import java.util.ListIterator;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import com.dreammaster.coremod.DreamCoreMod;
import com.dreammaster.coremod.IDreamTransformer;

public class TravellersGearTransformer implements IDreamTransformer {

    @Override
    public String[] targetedClasses() {
        return new String[] { "travellersgear.TravellersGear" };
    }

    @Override
    public ClassNode transform(ClassNode classNode) {
        for (MethodNode methodNode : classNode.methods) {
            if (checkMethodNode(methodNode, "init", "(Lcpw/mods/fml/common/event/FMLInitializationEvent;)V")) {
                /*
                 * // spotless:off
                 * This deletes all the instructions from :
                 * [EXCLUDED] ChestGenHooks.getInfo("strongholdLibrary").addItem(new WeightedRandomChestContent(new ItemStack(simpleGear, 1, 6), 1, 1, 8));
                 * To :
                 * [EXCLUDED] OreDictionary.registerOre("baubleRingGold", new ItemStack(simpleGear, 1, 2));
                 */// spotless:on
                int addItemCallsCount = 0;
                final ListIterator<AbstractInsnNode> iterator = methodNode.instructions.iterator();
                while (iterator.hasNext()) {
                    final AbstractInsnNode insnNode = iterator.next();
                    if (checkMethodInsnNode(
                            insnNode,
                            Opcodes.INVOKEVIRTUAL,
                            "net/minecraftforge/common/ChestGenHooks",
                            "addItem",
                            "(Lnet/minecraft/util/WeightedRandomChestContent;)V")) {
                        addItemCallsCount++;
                    } else if (checkLdcInsnNode(insnNode, "baubleRingGold")) {
                        DreamCoreMod.logger.info(
                                "Taking a sledgehammer to {}.{}{}",
                                classNode.name,
                                methodNode.name,
                                methodNode.desc);
                        return classNode;
                    } else if (addItemCallsCount == 5) {
                        iterator.remove();
                    }
                }
            }
        }
        return classNode;
    }

}
