package dev.boxadactle.boxlib.gui.config.widget.button;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

/**
 * A button widget that represents a boolean value.
 */
public class BBooleanButton extends BOptionButton<Boolean> {

    protected final String key;

    /**
     * Constructs a new BBooleanButton with the specified key, initial value, and function.
     *
     * @param key      the translation key for the button's label
     * @param value    the initial value of the button
     * @param function the function to be called when the button is clicked
     */
    public BBooleanButton(String key, Boolean value, Consumer<Boolean> function) {
        super(Component.translatable(key, value ? GuiUtils.TRUE : GuiUtils.FALSE), value, function);

        this.key = key;
    }

    @Override
    protected Boolean changeValue(Boolean input) {

        this.currentValue = !this.currentValue;
        super.setMessage(Component.translatable(key, currentValue ? GuiUtils.TRUE : GuiUtils.FALSE));

        return currentValue;
    }
}
