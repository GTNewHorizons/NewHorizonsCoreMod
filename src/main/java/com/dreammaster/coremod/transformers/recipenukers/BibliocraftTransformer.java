package com.dreammaster.coremod.transformers.recipenukers;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import com.dreammaster.coremod.DreamCoreMod;
import com.dreammaster.coremod.IDreamTransformer;

public class BibliocraftTransformer implements IDreamTransformer {

    @Override
    public String[] targetedClasses() {
        return new String[] { "jds.bibliocraft.blocks.BlockLoader", "jds.bibliocraft.items.ItemLoader",
                "jds.bibliowood.forestrywood.WoodsLoader", "jds.bibliowood.naturawood.WoodsLoader",
                "jds.bibliowood.bopwood.WoodsLoader" };
    }

    @Override
    public ClassNode transform(ClassNode classNode) {
        for (final MethodNode methodNode : classNode.methods) {
            if ("addRecipies".equals(methodNode.name) || "initRecipes".equals(methodNode.name)) {
                DreamCoreMod.logger
                        .info("Taking a sledgehammer to {}.{}{}", classNode.name, methodNode.name, methodNode.desc);
                emptyTheMethodNode(methodNode);
            }
        }
        return classNode;
    }

}
