package dev.boxadactle.boxlib.gui.config.widget.button;

import com.google.common.collect.ImmutableList;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.network.chat.Component;

import java.util.Locale;
import java.util.function.Consumer;

/**
 * A button widget that represents an enum value.
 *
 * @param <T> the type of the enum
 */
public class BEnumButton<T extends Enum<T>> extends BToggleButton<T> {

    protected int valColor;

    /**
     * Constructs a new BEnumButton.
     *
     * @param key      the translation key for the button's label
     * @param value    the initial value of the button
     * @param tEnum    the class object representing the enum type
     * @param function the consumer function to be called when the button is clicked
     * @param valColor the color of the enum value text
     */
    public BEnumButton(String key, T value, Class<T> tEnum, Consumer<T> function, int valColor) {
        super(key, value, ImmutableList.copyOf(tEnum.getEnumConstants()), function);

        this.valColor = valColor;

        super.setMessage(Component.translatable(key, from(value)));
    }

    /**
     * Converts the given Component input to the corresponding enum value.
     *
     * @param input the input component
     * @return the corresponding enum value
     */
    @Override
    public T to(Component input) {
        return this.list.get(index);
    }

    /**
     * Converts the given enum value to a colored Component.
     *
     * @param input the input enum value
     * @return the colored Component representing the enum value
     */
    @Override
    public Component from(T input) {
        return GuiUtils.colorize(Component.translatable(key + "." + input.name().toLowerCase(Locale.ROOT)), valColor);
    }
}
