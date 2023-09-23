package dev.boxadactle.boxlib.gui.widget.button;

import com.google.common.collect.ImmutableList;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.network.chat.Component;

import java.util.Locale;
import java.util.function.Consumer;

public class BEnumButton<T extends Enum<T>> extends BToggleButton<T> {

    int valColor;

    public BEnumButton(String key, T value, Class<T> tEnum, Consumer<T> function, int valColor) {
        super(key, value, ImmutableList.copyOf(tEnum.getEnumConstants()), function);

        this.valColor = valColor;

        super.setMessage(Component.translatable(key, from(value)));
    }

    @Override
    public T to(Component input) {
        return this.list.get(index);
    }

    @Override
    public Component from(T input) {
        return GuiUtils.colorize(Component.translatable(key + "." + input.name().toLowerCase(Locale.ROOT)), valColor);
    }
}
