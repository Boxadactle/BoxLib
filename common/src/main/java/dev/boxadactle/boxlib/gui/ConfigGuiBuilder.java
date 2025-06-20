package dev.boxadactle.boxlib.gui;

import dev.boxadactle.boxlib.function.Function2;
import dev.boxadactle.boxlib.gui.config.BConfigList;
import dev.boxadactle.boxlib.gui.config.BOptionEntry;
import dev.boxadactle.boxlib.gui.config.BOptionScreen;
import dev.boxadactle.boxlib.gui.config.widget.button.BCustomButton;
import dev.boxadactle.boxlib.gui.config.widget.field.BStringField;
import dev.boxadactle.boxlib.gui.config.widget.label.BCenteredLabel;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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

        List<BConfigList.ConfigEntry> entries = new ArrayList<>();

        Function2<LinearLayout, Screen, Button> footerProvider;

        public Builder(Screen parent, Component name) {
            this.parent = parent;
            this.name = name;
        }

        public Builder addEntry(BOptionEntry<?> entry) {
            this.entries.add(new BConfigList.SingleEntry(entry));
            return this;
        }

        public Builder addDoubleEntry(BOptionEntry<?> entry1, BOptionEntry<?> entry2) {
            this.entries.add(new BConfigList.DoubleEntry(entry1, entry2));
            return this;
        }

        public Builder addButton(Component message, Runnable onClick) {
            entries.add(new BConfigList.SingleEntry(BCustomButton.create(message, onClick)));
            return this;
        }

        public Builder addLabel(Component message) {
            entries.add(new BConfigList.SingleEntry(new BCenteredLabel(message)));
            return this;
        }

        public Builder addInput(String value, Consumer<String> consumer) {
            entries.add(new BConfigList.SingleEntry(new BStringField(value, consumer)));
            return this;
        }

        public Builder setFooterProvider(Function2<LinearLayout, Screen, Button> footerProvider) {
            this.footerProvider = footerProvider;
            return this;
        }

        public Builder setFooterProvider(Function<Screen, Button> footerProvider) {
            return setFooterProvider((layout, screen) -> layout.addChild(footerProvider.apply(screen)));
        }

        public BOptionScreen build() {
            return new BOptionScreen(parent, name) {
                @Override
                protected void initFooter(LinearLayout layout) {
                    if (footerProvider != null) {
                        footerProvider.accept(layout, parent);
                    } else {
                        layout.addChild(createDoneButton(parent));
                    }
                }

                @Override
                protected void addOptions() {
                    entries.forEach(this::addConfigLine);
                }
            };
        }
    }

}
