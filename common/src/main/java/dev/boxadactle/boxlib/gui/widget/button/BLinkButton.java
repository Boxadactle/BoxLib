package dev.boxadactle.boxlib.gui.widget.button;

import dev.boxadactle.boxlib.gui.BOptionButton;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.network.chat.Component;

public class BLinkButton extends BOptionButton<Object> {

    protected String link;

    public BLinkButton(Component message, String link) {
        super(message, null, null);

        this.link = link;
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        ClientUtils.openLinkConfirmScreen(link, ClientUtils.getCurrentScreen());
    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
