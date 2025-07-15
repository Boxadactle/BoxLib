package dev.boxadactle.boxlib.prompt.gui.number;

import dev.boxadactle.boxlib.prompt.gui.NumberScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

public class IntegerScreen extends NumberScreen<Integer> {

    public IntegerScreen(Screen parent, Component message) {
        super(parent, message);
    }

    @Override
    protected @Nullable Integer parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}