package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigButton;
import dev.boxadactle.boxlib.gui.BConfigScreen;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class BConfigScreenButton extends BConfigButton<Screen> {

    BConfigScreen.Provider<?> function;

    public BConfigScreenButton(Component message, Screen parent, BConfigScreen.Provider<?> function) {
        super(message, parent, s -> {});

        this.function = function;
    }

    @Override
    protected Screen changeValue(Screen input) {
        return ClientUtils.setScreen(function.createScreen(input));
    }
}
