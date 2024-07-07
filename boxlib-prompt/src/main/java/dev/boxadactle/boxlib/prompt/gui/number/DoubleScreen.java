package dev.boxadactle.boxlib.prompt.gui.number;

import dev.boxadactle.boxlib.prompt.gui.NumberScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

public class DoubleScreen extends NumberScreen<Double> {
    public DoubleScreen(Screen parent, Component message) {
        super(parent, message);
    }

    @Override
    protected @Nullable Double parse(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
