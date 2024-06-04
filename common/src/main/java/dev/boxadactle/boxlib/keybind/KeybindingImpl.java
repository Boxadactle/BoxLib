package dev.boxadactle.boxlib.keybind;

import net.minecraft.client.KeyMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class KeybindingImpl {

    static List<KeyMapping> keyMappings = new ArrayList<>();

    public static void addKeyMapping(KeyMapping keyMapping) {
        keyMappings.add(keyMapping);
    }

    public static void register(Consumer<KeyMapping> consumer) {
        keyMappings.forEach(consumer);
    }

}
