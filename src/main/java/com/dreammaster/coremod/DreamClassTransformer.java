package com.dreammaster.coremod;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import com.dreammaster.coremod.transformers.recipenukers.BibliocraftTransformer;
import com.dreammaster.coremod.transformers.ItemFocusWardingTransformer;

public class DreamClassTransformer implements IClassTransformer {

    // If needed, change later with a Map<String, List<IDreamTransformer>>
    // if multiple transformers target the same class
    private final Map<String, IDreamTransformer> transformerMap = new HashMap<>();

    public DreamClassTransformer() {
        // register your transformers here
        registerTransformer(new BibliocraftTransformer());
        registerTransformer(new ItemFocusWardingTransformer());
    }

    private void registerTransformer(IDreamTransformer transformer) {
        for (String targetedClass : transformer.targetedClasses()) {
            registerTransformer(targetedClass, transformer);
        }
    }

    private void registerTransformer(String targetedClass, IDreamTransformer transformer) {
        transformerMap.put(targetedClass, transformer);
    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (basicClass == null) return null;
        final IDreamTransformer transformer = transformerMap.get(transformedName);
        if (transformer == null) return basicClass;
        final ClassReader classReader = new ClassReader(basicClass);
        final ClassNode classNode = new ClassNode();
        classReader.accept(classNode, 0);
        final ClassWriter classWriter = new ClassWriter(0);
        transformer.transform(classNode).accept(classWriter);
        return classWriter.toByteArray();
    }

}
