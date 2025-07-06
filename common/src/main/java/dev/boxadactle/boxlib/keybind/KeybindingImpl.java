package dev.boxadactle.boxlib.keybind;

import net.minecraft.client.KeyMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * The KeybindingImpl class provides utility methods for managing keybindings in Minecraft mods.
 */
public class KeybindingImpl {

    /**
     * A list of all registered key mappings.
     */
    static List<KeyMapping> keyMappings = new ArrayList<>();

    /**
     * Adds a new key mapping to the list of registered key mappings.
     *
     * @param keyMapping The key mapping to add.
     */
    public static void addKeyMapping(KeyMapping keyMapping) {
        keyMappings.add(keyMapping);
    }

    /**
     * Registers a consumer to be called for each registered key mapping.
     *
     * @param consumer The consumer to register.
     */
    public static void register(Consumer<KeyMapping> consumer) {
        keyMappings.forEach(consumer);
    }

}
