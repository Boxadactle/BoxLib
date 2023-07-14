package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigButton;
import net.minecraft.text.Text;

public abstract class BCustomButton extends BConfigButton<Object> {
    public BCustomButton(Text message) {
        super(message, null, null);
    }

    protected abstract void buttonClicked(BConfigButton<?> button);

    @Override
    public void onClick(double mouseX, double mouseY) {
        this.buttonClicked(this);
    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
