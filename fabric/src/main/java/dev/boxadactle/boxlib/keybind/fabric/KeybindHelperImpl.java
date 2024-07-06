package dev.boxadactle.boxlib.keybind.fabric;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;

public class KeybindHelperImpl {

    public static InputConstants.Key getBoundKey(KeyMapping key) {
        return KeyBindingHelper.getBoundKeyOf(key);
    }

}
