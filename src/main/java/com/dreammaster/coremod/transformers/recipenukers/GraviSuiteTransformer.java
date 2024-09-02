package com.dreammaster.coremod.transformers.recipenukers;

import java.util.ListIterator;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;

import com.dreammaster.coremod.DreamCoreMod;
import com.dreammaster.coremod.IDreamTransformer;

public class GraviSuiteTransformer implements IDreamTransformer {

    @Override
    public String[] targetedClasses() {
        return new String[] { "gravisuite.GraviSuite" };
    }

    @Override
    public void transform(ClassNode classNode) {
        for (MethodNode mn : classNode.methods) {
            if (mn.name.equals("afterModsLoaded")
                    && mn.desc.equals("(Lcpw/mods/fml/common/event/FMLPostInitializationEvent;)V")) {
                final ListIterator<AbstractInsnNode> it = mn.instructions.iterator();
                boolean delete = false;
                while (it.hasNext()) {
                    final AbstractInsnNode insnNode = it.next();
                    if (!delete && insnNode instanceof TypeInsnNode
                            && insnNode.getOpcode() == Opcodes.NEW
                            && ((TypeInsnNode) insnNode).desc.equals("net/minecraft/item/ItemStack")) {
                        delete = true;
                    }
                    if (delete) {
                        it.remove();
                    }
                }
                mn.instructions.add(new InsnNode(Opcodes.RETURN));
                DreamCoreMod.logger.info("Taking a sledgehammer to {}.{}{}", classNode.name, mn.name, mn.desc);
            }
        }
    }

}
