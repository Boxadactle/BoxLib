package dev.boxadactle.boxlib.prompt.gui.number;

import dev.boxadactle.boxlib.prompt.gui.NumberScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

public class FloatScreen extends NumberScreen<Float> {
    public FloatScreen(Screen parent, Component message) {
        super(parent, message);
    }

    @Override
    protected @Nullable Float parse(String value) {
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
