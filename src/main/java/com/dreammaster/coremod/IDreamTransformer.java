package com.dreammaster.coremod;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

public interface IDreamTransformer {

    /**
     * The classes that this transformer targets
     */
    String[] targetedClasses();

    /**
     * Returns the transformed ClassNode
     */
    ClassNode transform(ClassNode classNode);

    // =================================================

    /**
     * Method to empty the methodNode and replace its body with just a RETURN Opcode
     */
    default void emptyTheMethodNode(MethodNode methodNode) {
        final InsnList insnList = new InsnList();
        insnList.add(new InsnNode(Opcodes.RETURN));
        methodNode.instructions = insnList;
        methodNode.localVariables.clear();
        methodNode.maxStack = 0;
        methodNode.maxLocals = 0;
    }

}
