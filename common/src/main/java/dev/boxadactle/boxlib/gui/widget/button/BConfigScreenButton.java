package dev.boxadactle.boxlib.gui.widget.button;

import dev.boxadactle.boxlib.gui.BOptionButton;
import dev.boxadactle.boxlib.gui.BOptionScreen;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class BConfigScreenButton extends BOptionButton<Screen> {

    protected BOptionScreen.Provider<?> function;

    public BConfigScreenButton(Component message, Screen parent, BOptionScreen.Provider<?> function) {
        super(message, parent, s -> {});

        this.function = function;
    }

    @Override
    protected Screen changeValue(Screen input) {
        return ClientUtils.setScreen(function.createScreen(input));
    }
}
