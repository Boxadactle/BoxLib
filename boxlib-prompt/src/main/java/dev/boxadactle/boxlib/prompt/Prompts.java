package dev.boxadactle.boxlib.prompt;

import dev.boxadactle.boxlib.function.EmptyMethod;
import dev.boxadactle.boxlib.prompt.gui.AlertScreen;
import dev.boxadactle.boxlib.prompt.gui.ConfirmScreen;
import dev.boxadactle.boxlib.prompt.gui.InputScreen;
import dev.boxadactle.boxlib.prompt.gui.number.IntegerScreen;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class Prompts {

    public static <T> void showPrompt(
            PromptScreenProvider<T> promptScreenClass,
            Screen parent,
            Component message,
            Consumer<T> dataConsumer,
            EmptyMethod noData
    ) {
        PromptScreen<T> screen = promptScreenClass.get(parent, message);

        screen.onData((b, data) -> {
            if (b) {
                dataConsumer.accept(data);
            } else {
                noData.accept();
            }
        });

        ClientUtils.setScreen(screen);
    }

    public static void alert(Screen parent, Component message) {
        showPrompt(AlertScreen::new, parent, message, (data) -> {}, () -> {});
    }

    public static void confirm(Screen parent, Component message, Consumer<Boolean> consumer) {
        showPrompt(ConfirmScreen::new, parent, message, consumer, () -> consumer.accept(false));
    }

    public static void prompt(Screen parent, Component message, Consumer<String> consumer) {
        showPrompt(InputScreen::new, parent, message, consumer, () -> consumer.accept(""));
    }

    public static <T extends Number> void promptNumber(PromptScreenProvider<T> provider, Screen parent, Component message, Consumer<T> consumer) {
        showPrompt(provider, parent, message, consumer::accept, () -> consumer.accept(null));
    }

    public static void promptInteger(Screen parent, Component message, Consumer<Integer> consumer) {
        promptNumber(IntegerScreen::new, parent, message, consumer);
    }

    @FunctionalInterface
    public interface PromptScreenProvider<T> {
        PromptScreen<T> get(Screen parent, Component message);
    }

}
