package com.dreammaster.lwjgl3ify;

import static org.lwjgl.sdl.SDLMessageBox.*;

import java.nio.IntBuffer;

import net.minecraft.util.StatCollector;

import org.lwjgl.sdl.SDLError;
import org.lwjgl.sdl.SDL_MessageBoxButtonData;
import org.lwjgl.sdl.SDL_MessageBoxData;
import org.lwjgl.system.MemoryStack;
import org.lwjglx.opengl.Display;

import com.dreammaster.coremod.DreamCoreMod;
import com.dreammaster.lib.Refstrings;

import me.eigenraven.lwjgl3ify.api.Lwjgl3Aware;

@Lwjgl3Aware
public class ConfirmExitSdl {

    // Keep as static final ints to avoid adding a classloading dependency when used
    public static final int BUTTON_YES = 0;
    public static final int BUTTON_NO = 1;
    public static final int BUTTON_NEVER = 2;

    private static String translateOrDefault(String key, String defaultValue) {
        return StatCollector.canTranslate(key) ? StatCollector.translateToLocal(key) : defaultValue;
    }

    /**
     * @return 0 for Yes, 1 for No,
     */
    @SuppressWarnings("resource")
    public static int showExitDialog() {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            final IntBuffer selectedOption = stack.ints(1);
            final SDL_MessageBoxData box = SDL_MessageBoxData.calloc(stack);

            // This dialog might get shown in a situation where localization isn't loaded, so this allows us to set a
            // hardcoded default.
            // See the corresponding mixin for the Minecraft class for more details.
            final String yesText = translateOrDefault("dreamcraft.gui.quitmessage.yes", "Yes");
            final String noText = translateOrDefault("dreamcraft.gui.quitmessage.no", "No");
            final String neverText = translateOrDefault("dreamcraft.gui.quitmessage.never", "Don't Show Again!");
            final String messageText = translateOrDefault(
                    "dreamcraft.gui.quitmessage",
                    "Are you sure you want to exit the game?");

            box.flags(SDL_MESSAGEBOX_WARNING);
            box.window(Display.getWindow());
            box.title(stack.UTF8(Refstrings.NAME));
            box.message(stack.UTF8(messageText));

            final SDL_MessageBoxButtonData.Buffer buttons = SDL_MessageBoxButtonData.calloc(3, stack);
            buttons.get(BUTTON_YES).set(SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT, BUTTON_YES, stack.UTF8(yesText));
            buttons.get(BUTTON_NO).set(SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT, BUTTON_NO, stack.UTF8(noText));
            buttons.get(BUTTON_NEVER).set(0, BUTTON_NEVER, stack.UTF8(neverText));
            box.buttons(buttons);

            if (!SDL_ShowMessageBox(box, selectedOption)) {
                DreamCoreMod.logger
                        .error("Could not create exit confirmation message box: {}", SDLError.SDL_GetError());
                // Assume it's ok to quit in case the message box cannot be spawned
                return BUTTON_YES;
            }
            return selectedOption.get(0);
        }
    }
}
