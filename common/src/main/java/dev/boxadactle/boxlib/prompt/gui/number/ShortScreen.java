package dev.boxadactle.boxlib.prompt.gui.number;

import dev.boxadactle.boxlib.prompt.gui.NumberScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

public class ShortScreen extends NumberScreen<Short> {
    public ShortScreen(Screen parent, Component message) {
        super(parent, message);
    }

    @Override
    protected @Nullable Short parse(String value) {
        try {
            return Short.parseShort(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
