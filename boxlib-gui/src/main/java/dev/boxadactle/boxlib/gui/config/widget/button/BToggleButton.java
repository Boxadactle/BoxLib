package dev.boxadactle.boxlib.gui.config.widget.button;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import dev.boxadactle.boxlib.function.Converter;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.List;
import java.util.function.Consumer;

/**
 * A toggle button widget that extends the BOptionButton class and implements the Converter interface.
 * This class provides functionality for selecting a value from a list of options and toggling between them.
 *
 * @param <T> the type of the value stored in the toggle button
 */
public abstract class BToggleButton<T> extends BOptionButton<T> implements Converter<T, Component> {

    /**
     * The list of options available for selection.
     */
    protected List<T> list;

    /**
     * The index of the currently selected option in the list.
     */
    protected int index;

    /**
     * The translation key used to display the selected option.
     */
    protected String key;

    /**
     * Constructs a new BToggleButton with the specified translation key, initial value, list of options, and function to be executed when the value changes.
     *
     * @param key      the translation key used to display the selected option
     * @param value    the initial value of the toggle button
     * @param list     the list of options available for selection
     * @param function the function to be executed when the value changes
     * @throws RuntimeException if the provided value is not registered in the provided list
     */
    public BToggleButton(String key, T value, List<T> list, Consumer<T> function) {
        super("text field", value, function);

        index = list.indexOf(value);
        this.list = list;

        if (index == -1) throw new RuntimeException("Provided value is not registered in provided list.");

        super.setMessage(GuiUtils.getTranslatable(key, from(value).getColoredString()));

        this.key = key;
    }

    /**
     * Increments the index of the currently selected option.
     * If the index reaches the end of the list, it wraps around to the beginning.
     */
    private void incrementIndex() {
        if (!(index == list.size() - 1)) index++;
        else index = 0;
    }

    /**
     * Changes the value of the toggle button to the next option in the list.
     * Updates the display message with the translation key and the new selected option.
     *
     * @param input the current value of the toggle button
     * @return the new selected option
     */
    @Override
    protected T changeValue(T input) {
        incrementIndex();
        T a = list.get(index);
        super.setMessage(GuiUtils.getTranslatable(key, from(a).getColoredString()));
        return a;
    }
}
