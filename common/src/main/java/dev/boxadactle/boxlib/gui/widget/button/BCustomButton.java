package dev.boxadactle.boxlib.gui.widget.button;

import dev.boxadactle.boxlib.gui.BOptionButton;
import net.minecraft.network.chat.Component;

public abstract class BCustomButton extends BOptionButton<Object> {
    public BCustomButton(Component message) {
        super(message, null, null);
    }

    protected abstract void buttonClicked(BOptionButton<?> button);

    @Override
    public void onClick(double mouseX, double mouseY) {
        this.buttonClicked(this);
    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }

}
