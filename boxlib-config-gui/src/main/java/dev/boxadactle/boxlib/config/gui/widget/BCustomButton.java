package dev.boxadactle.boxlib.config.gui.widget;

import dev.boxadactle.boxlib.config.gui.BConfigButton;
import net.minecraft.network.chat.Component;

public abstract class BCustomButton extends BConfigButton<Object> {
    public BCustomButton(Component message) {
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
