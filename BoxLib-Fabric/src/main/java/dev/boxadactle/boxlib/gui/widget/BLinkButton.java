package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigButton;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.text.Text;

public class BLinkButton extends BConfigButton<Object> {

    String link;

    public BLinkButton(Text message, String link) {
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
