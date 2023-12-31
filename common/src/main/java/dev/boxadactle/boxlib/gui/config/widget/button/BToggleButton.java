package dev.boxadactle.boxlib.gui.config.widget.button;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import dev.boxadactle.boxlib.function.Converter;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.function.Consumer;

public abstract class BToggleButton<T> extends BOptionButton<T> implements Converter<T, Component> {

    protected List<T> list;
    protected int index;
    protected String key;

    public BToggleButton(String key, T value, List<T> list, Consumer<T> function) {
        super(null, value, function);

        index = list.indexOf(value);
        this.list = list;

        if (index == -1) throw new RuntimeException("Provided value is not registered in provided list.");

        super.setMessage(Component.translatable(key, from(value)));

        this.key = key;
    }

    private void incrementIndex() {
        if (!(index == list.size() - 1)) index++;
        else index = 0;
    }

    @Override
    protected T changeValue(T input) {
        incrementIndex();
        T a = list.get(index);
        super.setMessage(Component.translatable(key, from(a)));
        return a;
    }
}
