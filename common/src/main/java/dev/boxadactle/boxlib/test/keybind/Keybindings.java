package dev.boxadactle.boxlib.test.keybind;

import dev.boxadactle.boxlib.keybind.KeybindHelper;
import net.minecraft.client.KeyMapping;

public class Keybindings {

    public static final KeyMapping TEST_KEYBIND = new KeyMapping("key.boxlibtestmod.test_keybind", 81, "key.categories.boxlibtestmod");
    public static final KeyMapping TEST_KEYBIND_2 = new KeyMapping("key.boxlibtestmod.test_keybind2", 82, "key.categories.boxlibtestmod");
    public static final KeyMapping TEST_KEYBIND_3 = new KeyMapping("key.boxlibtestmod.test_keybind3", 83, "key.categories.boxlibtestmod");
    public static final KeyMapping TEST_KEYBIND_4 = new KeyMapping("key.boxlibtestmod.test_keybind4", 84, "key.categories.boxlibtestmod");
    public static final KeyMapping TEST_KEYBIND_5 = new KeyMapping("key.boxlibtestmod.test_keybind5", 85, "key.categories.boxlibtestmod");

    public static void init() {
        // Register all keybinds like this
        KeybindHelper.registerKey(TEST_KEYBIND);
        KeybindHelper.registerKey(TEST_KEYBIND_2);
        KeybindHelper.registerKey(TEST_KEYBIND_3);
        KeybindHelper.registerKey(TEST_KEYBIND_4);
        KeybindHelper.registerKey(TEST_KEYBIND_5);
    }


}
