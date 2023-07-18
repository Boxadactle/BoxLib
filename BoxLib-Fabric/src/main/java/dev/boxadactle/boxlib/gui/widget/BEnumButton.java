package dev.boxadactle.boxlib.gui.widget;

import com.google.common.collect.ImmutableList;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.text.Text;

import java.util.Locale;
import java.util.function.Consumer;

public class BEnumButton<T extends Enum<T>> extends BToggleButton<T> {

    int valColor;

    public BEnumButton(String key, T value, Class<T> tEnum, Consumer<T> function, int valColor) {
        super(key, value, ImmutableList.copyOf(tEnum.getEnumConstants()), function);

        this.valColor = valColor;

        super.setMessage(Text.translatable(key, from(value)));
    }

    @Override
    public T to(Text input) {
        return this.list.get(index);
    }

    @Override
    public Text from(T input) {
        return GuiUtils.colorize(Text.translatable(key + "." + input.name().toLowerCase(Locale.ROOT)), valColor);
    }
}
