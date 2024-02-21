package dev.boxadactle.boxlib.gui.widget.button;

import dev.boxadactle.boxlib.gui.BOptionButton;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class BBooleanButton extends BOptionButton<Boolean> {

    protected final String key;

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
