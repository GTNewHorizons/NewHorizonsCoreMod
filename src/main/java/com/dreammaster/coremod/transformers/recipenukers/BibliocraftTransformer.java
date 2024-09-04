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
    public void transform(ClassNode classNode) {
        for (final MethodNode mn : classNode.methods) {
            if (("addRecipies".equals(mn.name) || "initRecipes".equals(mn.name)) && "()V".equals(mn.desc)) {
                DreamCoreMod.logger.info("Taking a sledgehammer to {}.{}{}", classNode.name, mn.name, mn.desc);
                emptyMethodNode(mn);
            }
        }
    }

}
