package dev.boxadactle.boxlib.test.prompts;

import dev.boxadactle.boxlib.gui.config.BOptionScreen;
import dev.boxadactle.boxlib.gui.config.widget.button.BCustomButton;
import dev.boxadactle.boxlib.prompt.Prompts;
import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

public class PromptTestingScreen extends BOptionScreen {
    public PromptTestingScreen(Screen parent) {
        super(parent);
    }

    @Override
    protected String getName() {
        return "Prompt Testing";
    }

    @Override
    protected void initFooter(int startX, int startY) {
        addButton(createDoneButton(startX, startY, parent));
    }

    @Override
    protected void initConfigButtons() {
        addConfigLine(BCustomButton.create("Test Alert", () -> {
            Prompts.alert(this, new TextComponent("This is a test alert!"));
        }));

        addConfigLine(BCustomButton.create("Test Confirm", () -> {
            Prompts.confirm(this, new TextComponent("This is a test confirm!"), (b) -> {
                ClientUtils.showToast(new TextComponent("Response"), new TextComponent("Confirmed: " + b));
            });
        }));

        addConfigLine(BCustomButton.create("Test Prompt", () -> {
            Prompts.prompt(this, new TextComponent("This is a test prompt!"), (s) -> {
                ClientUtils.showToast(new TextComponent("Response"), new TextComponent("Responded with: " + s));
            });
        }));

        addConfigLine(BCustomButton.create("Test Integer Prompt", () -> {
            Prompts.promptInteger(this, new TextComponent("This is a test integer prompt!"), (i) -> {
                ClientUtils.showToast(new TextComponent("Response"), new TextComponent("Responded with: " + i));
            });
        }));
    }
}
