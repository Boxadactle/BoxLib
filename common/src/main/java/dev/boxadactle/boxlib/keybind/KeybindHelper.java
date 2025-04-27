package dev.boxadactle.boxlib.keybind;

import com.mojang.blaze3d.platform.InputConstants;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.boxadactle.boxlib.mixin.KeybindAccessor;
import net.minecraft.client.KeyMapping;
import org.apache.commons.lang3.NotImplementedException;

/**
 * The KeybindHelper class provides utility methods for working with keybindings.
 */
public class KeybindHelper {

    /**
     * Registers a keybinding.
     *
     * @param key The keybinding to register.
     */
    public static void registerKey(KeyMapping key) {
        KeybindingImpl.addKeyMapping(key);
    }

    /**
     * Retrieves the bound key for a given keybinding.
     *
     * @param key The keybinding to retrieve the bound key for.
     * @return The bound key.
     */
    public static InputConstants.Key getBoundKey(KeyMapping key) {
        return ((KeybindAccessor) key).getKey();
    }

}