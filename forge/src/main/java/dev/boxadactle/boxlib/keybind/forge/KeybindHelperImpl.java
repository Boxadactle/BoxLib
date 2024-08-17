package dev.boxadactle.boxlib.keybind.forge;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

public class KeybindHelperImpl {

    public static InputConstants.Key getBoundKey(KeyMapping key) {
        return key.getKey();
    }

}