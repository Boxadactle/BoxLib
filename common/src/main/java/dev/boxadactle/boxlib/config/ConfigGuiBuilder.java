package dev.boxadactle.boxlib.config;

import dev.boxadactle.boxlib.function.Function3;
import dev.boxadactle.boxlib.gui.config.BOptionEntry;
import dev.boxadactle.boxlib.gui.config.BOptionScreen;
import dev.boxadactle.boxlib.gui.config.widget.button.BCustomButton;
import dev.boxadactle.boxlib.gui.config.widget.field.BStringField;
import dev.boxadactle.boxlib.gui.config.widget.label.BCenteredLabel;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConfigGuiBuilder {

    public static Builder builder(Screen parent, Component name) {
        return new Builder(parent, name);
    }

    public static Builder builder(Component name) {
        return new Builder(null, name);
    }

    public static class Builder {
        Component name;
        Screen parent;

        List<BOptionScreen.ConfigList.ConfigEntry> entries = new ArrayList<>();

        Function3<Integer, Integer, Screen, Button> footerProvider;

        public Builder(Screen parent, Component name) {
            this.parent = parent;
            this.name = name;
        }

        public Builder addEntry(BOptionEntry<?> entry) {
            this.entries.add(new BOptionScreen.ConfigList.SingleEntry(entry));
            return this;
        }

        public Builder addDoubleEntry(BOptionEntry<?> entry1, BOptionEntry<?> entry2) {
            this.entries.add(new BOptionScreen.ConfigList.DoubleEntry(entry1, entry2));
            return this;
        }

        public Builder addButton(Component message, Runnable onClick) {
            entries.add(new BOptionScreen.ConfigList.SingleEntry(BCustomButton.create(message, onClick)));
            return this;
        }

        public Builder addLabel(Component message) {
            entries.add(new BOptionScreen.ConfigList.SingleEntry(new BCenteredLabel(message)));
            return this;
        }

        public Builder addInput(String value, Consumer<String> consumer) {
            entries.add(new BOptionScreen.ConfigList.SingleEntry(new BStringField(value, consumer)));
            return this;
        }

        public Builder setFooterProvider(Function3<Integer, Integer, Screen, Button> footerProvider) {
            this.footerProvider = footerProvider;
            return this;
        }

        public BOptionScreen build() {
            return new BOptionScreen(parent) {
                @Override
                protected Component getName() {
                    return name;
                }

                @Override
                protected void initFooter(int startX, int startY) {
                    if (footerProvider != null) {
                        this.addRenderableWidget(footerProvider.accept(startX, startY, parent));
                    } else {
                        addRenderableWidget(createDoneButton(startX, startY, parent));
                    }
                }

                @Override
                protected void initConfigButtons() {
                    entries.forEach(this::addConfigLine);
                }
            };
        }
    }

}
