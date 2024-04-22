package dev.boxadactle.boxlib.gui.config.widget.button;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import dev.boxadactle.boxlib.gui.config.BOptionScreen;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * A button that opens a configuration screen when clicked.
 */
public class BConfigScreenButton extends BOptionButton<Screen> {

    protected BOptionScreen.Provider<?> function;

    /**
     * Constructs a new BConfigScreenButton.
     *
     * @param message  the text displayed on the button
     * @param parent   the parent screen
     * @param function the provider function that creates the configuration screen
     */
    public BConfigScreenButton(Component message, Screen parent, BOptionScreen.Provider<?> function) {
        super(message, parent, s -> {});

        this.function = function;
    }

    @Override
    protected Screen changeValue(Screen input) {
        return ClientUtils.setScreen(function.createScreen(input));
    }
}
