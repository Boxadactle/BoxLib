package dev.boxadactle.boxlib.prompt.gui.number;

import dev.boxadactle.boxlib.prompt.gui.NumberScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

public class LongScreen extends NumberScreen<Long> {
    public LongScreen(Screen parent, Component message) {
        super(parent, message);
    }

    @Override
    protected @Nullable Long parse(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
