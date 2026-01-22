package dev.boxadactle.boxlib.test.keybind;

import com.mojang.blaze3d.platform.InputConstants;
import dev.boxadactle.boxlib.keybind.KeybindHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class Keybindings {

    public static final KeyMapping.Category BOXLIBTESTMOD = KeyMapping.Category.register(Identifier.fromNamespaceAndPath("boxlib", "testmod"));

    public static final KeyMapping TEST_KEYBIND = new KeyMapping("key.boxlibtestmod.test_keybind", InputConstants.Type.KEYSYM, 81, BOXLIBTESTMOD);
    public static final KeyMapping TEST_KEYBIND_2 = new KeyMapping("key.boxlibtestmod.test_keybind2", InputConstants.Type.KEYSYM, 82, BOXLIBTESTMOD);
    public static final KeyMapping TEST_KEYBIND_3 = new KeyMapping("key.boxlibtestmod.test_keybind3", InputConstants.Type.KEYSYM, 83, BOXLIBTESTMOD);
    public static final KeyMapping TEST_KEYBIND_4 = new KeyMapping("key.boxlibtestmod.test_keybind4", InputConstants.Type.KEYSYM, 84, BOXLIBTESTMOD);
    public static final KeyMapping TEST_KEYBIND_5 = new KeyMapping("key.boxlibtestmod.test_keybind5", InputConstants.Type.KEYSYM, 85, BOXLIBTESTMOD);

    public static void init() {
        // Register all keybinds like this
        KeybindHelper.registerKey(TEST_KEYBIND);
        KeybindHelper.registerKey(TEST_KEYBIND_2);
        KeybindHelper.registerKey(TEST_KEYBIND_3);
        KeybindHelper.registerKey(TEST_KEYBIND_4);
        KeybindHelper.registerKey(TEST_KEYBIND_5);
    }


}
