package com.dreammaster.coremod;

import static org.objectweb.asm.Opcodes.ASM5;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

@SuppressWarnings("unused")
public class BibliocraftTransformer implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if ("jds.bibliocraft.blocks.BlockLoader".equals(transformedName)
                || "jds.bibliocraft.items.ItemLoader".equals(transformedName)
                || "jds.bibliowood.forestrywood.WoodsLoader".equals(transformedName)
                || "jds.bibliowood.naturawood.WoodsLoader".equals(transformedName)
                || "jds.bibliowood.bopwood.WoodsLoader".equals(transformedName)) {
            DreamCoreMod.logger.info("Patching Bibliocraft {}", transformedName);
            final ClassReader cr = new ClassReader(basicClass);
            final ClassWriter cw = new ClassWriter(0);
            final ClassNode cn = new ClassNode(ASM5);
            cr.accept(cn, 0);
            for (MethodNode m : cn.methods) {
                if ("addRecipies".equals(m.name) || "initRecipes".equals(m.name)) {
                    DreamCoreMod.logger.info("Taking a sledgehammer to {}.{}()", transformedName, m.name);
                    // Replace the body with a RETURN opcode
                    InsnList insnList = new InsnList();
                    insnList.add(new InsnNode(Opcodes.RETURN));
                    m.instructions = insnList;
                    m.localVariables.clear();
                    m.maxStack = 0;
                    m.maxLocals = 0;
                }
            }
            cn.accept(cw);
            return cw.toByteArray();
        } else {
            return basicClass;
        }
    }
}
