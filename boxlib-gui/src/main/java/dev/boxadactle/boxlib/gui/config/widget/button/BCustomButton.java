package dev.boxadactle.boxlib.gui.config.widget.button;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import net.minecraft.network.chat.Component;

/**
 * An abstract class representing a custom button in a graphical user interface.
 * Extends the BOptionButton class.
 */
public abstract class BCustomButton extends BOptionButton<Object> {

    /**
     * Creates a new BCustomButton with the specified message and action to perform when clicked.
     *
     * @param message the component representing the message of the button
     * @param onClick the action to perform when the button is clicked
     * @return the created BCustomButton
     */
    public static BCustomButton create(Component message, Runnable onClick) {
        return new BCustomButton(message) {
            @Override
            protected void buttonClicked(BOptionButton<?> button) {
                onClick.run();
            }
        };
    }

    /**
     * Constructs a new BCustomButton with the specified message.
     *
     * @param message the component representing the message of the button
     */
    public BCustomButton(Component message) {
        super(message, null, null);
    }

    /**
     * Called when the button is clicked.
     *
     * @param button the button that was clicked
     */
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
