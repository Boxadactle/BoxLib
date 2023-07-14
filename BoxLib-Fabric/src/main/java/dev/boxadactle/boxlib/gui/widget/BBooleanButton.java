package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigButton;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.text.Text;

import java.util.function.Consumer;

public class BBooleanButton extends BConfigButton<Boolean> {

    private String key;

    public BBooleanButton(String key, Boolean value, Consumer<Boolean> function) {
        super(Text.translatable(key, value ? GuiUtils.TRUE : GuiUtils.FALSE), value, function);

        this.key = key;
    }

    @Override
    protected Boolean changeValue(Boolean input) {

        this.currentValue = !this.currentValue;
        super.setMessage(Text.translatable(key, currentValue ? GuiUtils.TRUE : GuiUtils.FALSE));

        return currentValue;
    }
}
