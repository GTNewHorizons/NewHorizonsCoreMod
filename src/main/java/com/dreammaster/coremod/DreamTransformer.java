package com.dreammaster.coremod;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static com.dreammaster.coremod.DreamCoreMod.*;
import static org.objectweb.asm.Opcodes.*;

public class DreamTransformer implements IClassTransformer {
	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) {
		if (name.equals("thaumcraft.common.items.wands.foci.ItemFocusWarding")) {
			logger.info("Transforming ItemFocusWarding");
			ClassReader cr = new ClassReader(basicClass);
			ClassWriter cw = new ClassWriter(0);
			if (debugOutputDir != null) {
				try (PrintWriter pw = new PrintWriter(new File(debugOutputDir, name + ".txt"))) {
					cr.accept(new ItemFocusWardingVisitor(ASM5, new TraceClassVisitor(cw, pw)), ClassReader.SKIP_DEBUG);
				} catch (FileNotFoundException e) {
					logger.warn("Can't write debug output!", e);
					cr.accept(new ItemFocusWardingVisitor(ASM5, cw), ClassReader.SKIP_DEBUG);
				}
			} else {
				cr.accept(new ItemFocusWardingVisitor(ASM5, cw), ClassReader.SKIP_DEBUG);
			}
			return cw.toByteArray();
		}
		return basicClass;
	}

	private static class ItemFocusWardingVisitor extends ClassVisitor {
		private static class ConstructorVisitor extends MethodVisitor {
			public ConstructorVisitor(int api, MethodVisitor mv) {
				super(api, mv);
			}

			@Override
			public void visitInsn(int opcode) {
				if (opcode == POP) {
					logger.debug("Adding setContainerItem() call");
					mv.visitVarInsn(ALOAD, 0);
					mv.visitMethodInsn(INVOKEVIRTUAL, "net/minecraft/item/Item", deobf ? "setContainerItem" : "func_77642_a", "(Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;", false);
					mv.visitInsn(POP);
				} else {
					super.visitInsn(opcode);
				}
			}
		}

		public ItemFocusWardingVisitor(int api, ClassVisitor cv) {
			super(api, cv);
		}

		@Override
		public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
			if (name.equals("<init>")) {
				logger.debug("Patching constructor");
				return new ConstructorVisitor(api, super.visitMethod(access, name, desc, signature, exceptions));
			}
			return super.visitMethod(access, name, desc, signature, exceptions);
		}

		@Override
		public void visitEnd() {
			logger.debug("Adding getContainerItem()");
			MethodVisitor mv = cv.visitMethod(ACC_PUBLIC, "getContainerItem", "(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;", null, null);
			mv.visitParameter("stack", 0);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 1);
			mv.visitMethodInsn(INVOKEVIRTUAL, "net/minecraft/item/ItemStack", deobf ? "copy" : "func_77946_l", "()Lnet/minecraft/item/ItemStack;", false);
			mv.visitInsn(DUP);
			mv.visitInsn(ICONST_1);
			mv.visitFieldInsn(PUTFIELD, "net/minecraft/item/ItemStack", deobf ? "stackSize" : "field_77994_a", "I");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(3, 2);
			mv.visitEnd();
			super.visitEnd();
		}
	}
}
