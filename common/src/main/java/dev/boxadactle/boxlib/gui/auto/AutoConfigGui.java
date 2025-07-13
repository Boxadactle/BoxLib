package dev.boxadactle.boxlib.gui.auto;

import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.function.Function2;
import dev.boxadactle.boxlib.function.Function5;
import dev.boxadactle.boxlib.function.Function6;
import dev.boxadactle.boxlib.gui.config.BOptionEntry;
import dev.boxadactle.boxlib.gui.config.BOptionHelper;
import dev.boxadactle.boxlib.gui.config.BOptionScreen;
import dev.boxadactle.boxlib.gui.config.widget.button.BBooleanButton;
import dev.boxadactle.boxlib.gui.config.widget.button.BColorPickerButton;
import dev.boxadactle.boxlib.gui.config.widget.button.BEnumButton;
import dev.boxadactle.boxlib.gui.config.widget.button.BScreenButton;
import dev.boxadactle.boxlib.gui.config.widget.field.*;
import dev.boxadactle.boxlib.gui.config.widget.label.BCenteredLabel;
import dev.boxadactle.boxlib.gui.config.widget.slider.*;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.lang.Class;
import java.lang.reflect.Field;
import java.util.function.Consumer;
import java.util.function.Function;

public class AutoConfigGui {

    public static AutoConfigGuiBuilder start(Object config, Screen parent) {
        return new AutoConfigGuiBuilder(config, parent);
    }

    public static class AutoConfigGuiBuilder implements BOptionHelper {

        Object config;

        Screen parent;

        Function2<LinearLayout, Screen, Button> footerProvider;

        protected AutoConfigGuiBuilder(Object config, Screen parent) {
            this.config = config;
            this.parent = parent;

            setFooterProvider(this::createDoneButton);
        }

        public AutoConfigGuiBuilder parent(Screen parent) {
            this.parent = parent;
            return this;
        }

        public AutoConfigGuiBuilder setFooterProvider(Function2<LinearLayout, Screen, Button> footerProvider) {
            this.footerProvider = footerProvider;
            return this;
        }

        public AutoConfigGuiBuilder setFooterProvider(Function<Screen, Button> footerProvider) {
            return setFooterProvider((layout, screen) -> layout.addChild(footerProvider.apply(screen)));
        }

        private String getKey(Field field) {
            if (field.isAnnotationPresent(CustomText.class)) {
                CustomText customKey = field.getAnnotation(CustomText.class);
                return customKey.value();
            } else {
                return "boxlib.autoconfig." + field.getName();
            }
        }

        private net.minecraft.client.gui.components.Tooltip getTooltip(Field field) {
            if (field.isAnnotationPresent(Tooltip.class)) {
                Tooltip tooltip = field.getAnnotation(Tooltip.class);
                return net.minecraft.client.gui.components.Tooltip.create(tooltip.translate() ? Component.translatable(tooltip.value()) : Component.literal(tooltip.value()));
            }
            return null;
        }

        private void intOption(Field field, Object config, Function<BOptionEntry<?>, BOptionEntry<?>> consumer, Screen thisScreen) throws IllegalAccessException {
            boolean bl = field.isAnnotationPresent(Color.class);

            if (field.isAnnotationPresent(Slider.class)) {
                Slider slider = field.getAnnotation(Slider.class);
                if (bl) {
                    Color color = field.getAnnotation(Color.class);

                    consumer.apply(new BColorPickerButton(
                            getKey(field),
                            thisScreen,
                            color.value(),
                            field.getInt(config),
                            v -> {
                                try {
                                    field.set(config, v);
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                    )).tooltip(getTooltip(field));
                } else {
                    consumer.apply(new BIntegerSlider(
                            getKey(field),
                            (int) Math.round(slider.min()), (int) Math.round(slider.max()),
                            field.getInt(config),
                            v -> {
                                try {
                                    field.set(config, v);
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                    )).tooltip(getTooltip(field));
                }
            } else {
                consumer.apply(new BCenteredLabel(Component.translatable(getKey(field))));
                if (bl) {
                    Color color = field.getAnnotation(Color.class);

                    if (color.value()) consumer.apply(new BArgbField(field.getInt(config), v -> {
                        try {
                            field.set(config, v);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    })).tooltip(getTooltip(field));
                    else consumer.apply(new BHexField(field.getInt(config), v -> {
                        try {
                            field.set(config, v);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    })).tooltip(getTooltip(field));
                } else {
                    consumer.apply(new BIntegerField(field.getInt(config), v -> {
                        try {
                            field.set(config, v);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    })).tooltip(getTooltip(field));
                }
            }
        }

        private void boolOption(Field field, Object config, Function<BOptionEntry<?>, BOptionEntry<?>> consumer) throws IllegalAccessException {
            consumer.apply(new BBooleanButton(
                    getKey(field),
                    field.getBoolean(config),
                    v -> {
                        try {
                            field.set(config, v);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
            )).tooltip(getTooltip(field));
        }

        @SuppressWarnings("unchecked")
        private <T extends Number> void fieldOption(
                Field field, Object config, Function<BOptionEntry<?>, BOptionEntry<?>> consumer,
                Function2<T, Consumer<T>, BOptionEntry<?>> fieldConstructor,
                Function6<String, T, T, T, Integer, Consumer<T>, BOptionEntry<?>> sliderConstructor,
                Function<Double, T> converter
        ) throws IllegalAccessException {
            if (field.isAnnotationPresent(Slider.class)) {
                Slider slider = field.getAnnotation(Slider.class);
                consumer.apply(sliderConstructor.accept(
                        getKey(field),
                        converter.apply(slider.min()),
                        converter.apply(slider.max()),
                        (T) field.get(config),
                        slider.decimalPlaces(),
                        v -> {
                            try {
                                field.set(config, v);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                )).tooltip(getTooltip(field));
            } else {
                consumer.apply(new BCenteredLabel(Component.translatable(getKey(field))));

                consumer.apply(fieldConstructor.accept(
                        (T) field.get(config),
                        v -> {
                            try {
                                field.set(config, v);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                )).tooltip(getTooltip(field));
            }
        }

        private <T extends Number> void fieldOption(
                Field field, Object config, Function<BOptionEntry<?>, BOptionEntry<?>> consumer,
                Function2<T, Consumer<T>, BOptionEntry<?>> fieldConstructor,
                Function5<String, T, T, T, Consumer<T>, BOptionEntry<?>> sliderConstructor,
                Function<Double, T> converter
        ) throws IllegalAccessException {
            fieldOption(
                    field, config, consumer, fieldConstructor,
                    (key, min, max, value, ignored, cons) -> sliderConstructor.accept(key, min, max, value, cons),
                    converter
            );
        }

        private void stringOption(Field field, Object config, Function<BOptionEntry<?>, BOptionEntry<?>> consumer) throws IllegalAccessException {
            consumer.apply(new BCenteredLabel(Component.translatable(getKey(field))));

            consumer.apply(new BStringField(
                    (String) field.get(config),
                    v -> {
                        try {
                            field.set(config, v);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
            )).tooltip(getTooltip(field));
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        private void enumOption(Field field, Object config, Function<BOptionEntry<?>, BOptionEntry<?>> consumer) throws IllegalAccessException {
            if (!field.getType().isEnum()) {
                throw new IllegalArgumentException("Field " + field.getName() + " is not an enum type.");
            }

            consumer.apply(new BEnumButton<>(
                    getKey(field),
                    (Enum) field.get(config),
                    (Class) field.getType(),
                    v -> {
                        try {
                            field.set(config, v);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    },
                    GuiUtils.BLUE
            )).tooltip(getTooltip(field));
        }
        
        private void customOption(Field field, Object config, Function<BOptionEntry<?>, BOptionEntry<?>> consumer, Screen thisScreen) throws IllegalAccessException {
            if (field.getType().isAnnotationPresent(Gui.class)) {
                consumer.apply(new BScreenButton(
                        Component.translatable(getKey(field)),
                        thisScreen,
                        (lastScreen) -> AutoConfigGui.start(field.get(config), lastScreen)
                                .setFooterProvider(this::createBackButton)
                                .build()
                )).tooltip(getTooltip(field));
                
                return;
            }

            // check if the field is an enum
            if (field.getType().isEnum()) {
                enumOption(field, config, consumer);
                return;
            }
            
            BoxLib.LOGGER.error("Unsupported field type {} in config class {}. Field: {}", field.getType().getSimpleName(), config.getClass().getName(), field.getName());
        }
        
        public BOptionScreen build() {
            Gui guiMetadata = config.getClass().getAnnotation(Gui.class);

            if (guiMetadata == null) {
                throw new IllegalStateException("Config class " + config.getClass().getName() + " does not have a @Gui annotation.");
            }
            
            return new BOptionScreen(parent, guiMetadata.translate() ? Component.translatable(guiMetadata.value()) : Component.literal(guiMetadata.value())) {
                @Override
                protected void initFooter(LinearLayout layout) {
                    footerProvider.accept(layout, lastScreen);
                }

                @Override
                protected void addOptions() {
                    try {
                        for (Field field : config.getClass().getDeclaredFields()) {
                            if (!field.isAnnotationPresent(HideValue.class)) {
                                field.setAccessible(true);
                                switch (field.getType().getSimpleName()) {
                                    case "int", "Integer" -> intOption(field, config, this::addConfigLine, this);
                                    case "boolean", "Boolean" -> boolOption(field, config, this::addConfigLine);
                                    case "double", "Double" -> fieldOption(field, config, this::addConfigLine, BDoubleField::new, BDoubleSlider::new, Double::valueOf);
                                    case "float", "Float" -> fieldOption(field, config, this::addConfigLine, BFloatField::new, BFloatSlider::new, Double::floatValue);
                                    case "long", "Long" -> fieldOption(field, config, this::addConfigLine, BLongField::new, BLongSlider::new, Double::longValue);
                                    case "short", "Short" -> fieldOption(field, config, this::addConfigLine, BShortField::new, BShortSlider::new, Double::shortValue);
                                    case "String" -> stringOption(field, config, this::addConfigLine);
                                    default -> customOption(field, config, this::addConfigLine, this);
                                }
                                BoxLib.LOGGER.info(field.getType().getSimpleName());
                            }
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to access field in config class " + config.getClass().getName(), e);
                    }
                }
            };
        }

    }

}
