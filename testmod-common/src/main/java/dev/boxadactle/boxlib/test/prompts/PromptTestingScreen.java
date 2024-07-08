package dev.boxadactle.boxlib.test.prompts;

import dev.boxadactle.boxlib.gui.config.BOptionScreen;
import dev.boxadactle.boxlib.gui.config.widget.button.BCustomButton;
import dev.boxadactle.boxlib.prompt.Prompts;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class PromptTestingScreen extends BOptionScreen {
    public PromptTestingScreen(Screen parent) {
        super(parent);
    }

    @Override
    protected Component getName() {
        return Component.literal("Prompt Testing");
    }

    @Override
    protected void initFooter(int startX, int startY) {
        addRenderableWidget(createDoneButton(startX, startY, parent));
    }

    @Override
    protected void initConfigButtons() {
        addConfigLine(BCustomButton.create(Component.literal("Test Alert"), () -> {
            Prompts.alert(this, Component.literal("This is a test alert!"));
        }));

        addConfigLine(BCustomButton.create(Component.literal("Test Confirm"), () -> {
            Prompts.confirm(this, Component.literal("This is a test confirm!"), (b) -> {
                ClientUtils.showToast(Component.literal("Response"), Component.literal("Confirmed: " + b));
            });
        }));

        addConfigLine(BCustomButton.create(Component.literal("Test Prompt"), () -> {
            Prompts.prompt(this, Component.literal("This is a test prompt!"), (s) -> {
                ClientUtils.showToast(Component.literal("Response"), Component.literal("Responded with: " + s));
            });
        }));

        addConfigLine(BCustomButton.create(Component.literal("Test Integer Prompt"), () -> {
            Prompts.promptInteger(this, Component.literal("This is a test integer prompt!"), (i) -> {
                ClientUtils.showToast(Component.literal("Response"), Component.literal("Responded with: " + i));
            });
        }));
    }
}
