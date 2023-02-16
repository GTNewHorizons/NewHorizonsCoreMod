package com.dreammaster.coremod.transformers;

import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.*;

import com.dreammaster.coremod.DreamCoreMod;
import com.dreammaster.coremod.IDreamTransformer;

// TODO shouldn't this thing be move to the thamcraft4tweaks mod ?
public class ItemFocusWardingTransformer implements IDreamTransformer {

    @Override
    public String[] targetedClasses() {
        return new String[] { "thaumcraft.common.items.wands.foci.ItemFocusWarding" };
    }

    @Override
    public ClassNode transform(ClassNode classNode) {
        if (DreamCoreMod.patchItemFocusWarding) {
            DreamCoreMod.logger.info("Transforming ItemFocusWarding");
            for (final MethodNode methodNode : classNode.methods) {
                if (isConstructorMethod(methodNode)) {
                    /*
                     * Before: public ItemFocusWarding() { this.func_77637_a(Thaumcraft.tabTC); } After: public
                     * ItemFocusWarding() { this.func_77637_a(Thaumcraft.tabTC).setContainerItem(this); }
                     */
                    for (final AbstractInsnNode insnNode : methodNode.instructions.toArray()) {
                        if (checkInsnNode(insnNode, POP)) {
                            final InsnList list = new InsnList();
                            list.add(new VarInsnNode(ALOAD, 0));
                            list.add(
                                    new MethodInsnNode(
                                            INVOKEVIRTUAL,
                                            "net/minecraft/item/Item",
                                            DreamCoreMod.deobf ? "setContainerItem" : "func_77642_a",
                                            "(Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;",
                                            false));
                            methodNode.instructions.insertBefore(insnNode, list);
                        }
                    }
                }
            }
            // TODO This thing is broken :
            // - it doesn't use obfuscation mapping for the method name
            // - the descriptor doesn't match the method it's supposed to override
            // - the method body needs to be changed to match the descriptor of the method it's supposed to override
            MethodVisitor mv = classNode.visitMethod(
                    ACC_PUBLIC,
                    "getContainerItem",
                    "(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;",
                    null,
                    null);
            mv.visitParameter("stack", 0);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(
                    INVOKEVIRTUAL,
                    "net/minecraft/item/ItemStack",
                    DreamCoreMod.deobf ? "copy" : "func_77946_l",
                    "()Lnet/minecraft/item/ItemStack;",
                    false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 2);
            mv.visitEnd();
        }
        return classNode;
    }

}
