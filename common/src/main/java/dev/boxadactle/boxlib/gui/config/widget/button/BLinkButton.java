package dev.boxadactle.boxlib.gui.config.widget.button;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.network.chat.Component;

/**
 * A button that opens a link when clicked.
 */
public class BLinkButton extends BOptionButton<Object> {

    protected String link;

    /**
     * Constructs a new BLinkButton with the specified message and link.
     *
     * @param message the message to display on the button
     * @param link the link to open when the button is clicked
     */
    public BLinkButton(Component message, String link) {
        super(message, null, null);

        this.link = link;
    }

    /**
     * Opens the link when the button is clicked.
     *
     * @param mouseX the x-coordinate of the mouse when clicked
     * @param mouseY the y-coordinate of the mouse when clicked
     */
    @Override
    public void onClick(double mouseX, double mouseY) {
        ClientUtils.openLinkConfirmScreen(link, ClientUtils.getCurrentScreen());
    }

    /**
     * This method is not used in BLinkButton.
     *
     * @param input the input value
     * @return always returns null
     */
    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
