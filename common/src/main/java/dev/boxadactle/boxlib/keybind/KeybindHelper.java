package dev.boxadactle.boxlib.keybind;

import com.mojang.blaze3d.platform.InputConstants;
import dev.boxadactle.boxlib.mixin.KeyMappingAccessor;
import net.minecraft.client.KeyMapping;

public class KeybindHelper {

    public static void registerKey(KeyMapping key) {
        KeybindingImpl.addKeyMapping(key);
    }

    public static InputConstants.Key getBoundKey(KeyMapping key) {
        return ((KeyMappingAccessor) key).getKey();
    }

}
