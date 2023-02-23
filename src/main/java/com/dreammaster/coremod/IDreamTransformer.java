package com.dreammaster.coremod;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

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

    default boolean isConstructorMethod(MethodNode methodNode) {
        return methodNode.name.startsWith("<init>");
    }

    default boolean checkMethodNode(MethodNode methodNode, String name, String desc) {
        return methodNode.name.equals(name) && methodNode.desc.equals(desc);
    }

    default boolean checkInsnNode(AbstractInsnNode insnNode, int opcode) {
        return insnNode instanceof InsnNode && insnNode.getOpcode() == opcode;
    }

    default boolean checkMethodInsnNode(AbstractInsnNode insnNode, int opcode, String owner, String name, String desc) {
        return insnNode instanceof MethodInsnNode && insnNode.getOpcode() == opcode
                && ((MethodInsnNode) insnNode).owner.equals(owner)
                && ((MethodInsnNode) insnNode).name.equals(name)
                && ((MethodInsnNode) insnNode).desc.equals(desc);
    }

    default boolean checkLdcInsnNode(AbstractInsnNode insnNode, Object obj) {
        return insnNode instanceof LdcInsnNode && ((LdcInsnNode) insnNode).cst != null
                && ((LdcInsnNode) insnNode).cst.equals(obj);
    }

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
