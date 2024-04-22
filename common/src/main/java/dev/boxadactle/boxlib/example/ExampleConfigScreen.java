package dev.boxadactle.boxlib.example;

import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.core.ModConstants;
import dev.boxadactle.boxlib.gui.BOptionScreen;
import dev.boxadactle.boxlib.gui.widget.BCustomRenderingEntry;
import dev.boxadactle.boxlib.gui.widget.BSpacingEntry;
import dev.boxadactle.boxlib.gui.widget.button.*;
import dev.boxadactle.boxlib.gui.widget.field.*;
import dev.boxadactle.boxlib.gui.widget.label.*;
import dev.boxadactle.boxlib.gui.widget.slider.*;
import dev.boxadactle.boxlib.layouts.RenderingLayout;
import dev.boxadactle.boxlib.layouts.component.LayoutContainerComponent;
import dev.boxadactle.boxlib.layouts.component.ParagraphComponent;
import dev.boxadactle.boxlib.layouts.layout.ColumnLayout;
import dev.boxadactle.boxlib.layouts.layout.RowLayout;
import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * Here is a super basic example config screen.
 * Config screens must extend {@link BOptionScreen} to access the methods
 * Config values can be accessed/saved with config classes.
 * You can use an external library such as Cloth Config, but BoxLib already handles config
 * @see dev.boxadactle.boxlib.config.BConfig
 * @see dev.boxadactle.boxlib.config.BConfigFile
 */
public class ExampleConfigScreen extends BOptionScreen {

    public ExampleConfigScreen(Screen parent) {
        super(parent);

        // this is required (you can also do this yourself if you want) for using a cancel button
        BoxLib.CONFIG.cacheConfig();
    }

    @Override
    protected int getRowWidth() {
        return super.getRowWidth() + 100;
    }

    @Override
    protected int getRowHeight() {
        return super.getRowHeight() + 20;
    }

    @Override
    protected int getScrollbarPosition() {
        return this.width - 15;
    }

    @Override
    protected int getScrollingWidgetStart() {
        return super.getScrollingWidgetStart() + 20;
    }

    @Override
    protected int getScrollingWidgetEnd() {
        return super.getScrollingWidgetEnd() - 20;
    }

    // using this method because I'm too lazy
    private ExampleConfigClass config() {
        return BoxLib.CONFIG.get();
    }

    @Override
    protected Component getName() {
        return Component.translatable("boxlib.exampleconfigscreen");
    }

    // initialize the config screen save and cancel buttons like this
    @Override
    protected void initFooter(int startX, int startY) {
        // here is where we restore the reload the config to undo all the changes to the config
        addRenderableWidget(createHalfCancelButton(startX, startY, (b) -> {
            ClientUtils.setScreen(parent);
            BoxLib.CONFIG.restoreCache();
        }));

        // the half save button method will put the button next to the cancel button
        // make sure to add the save button like this, or the save button won't be disabled
        // when an incorrect value is entered
        setSaveButton(createHalfSaveButton(startX, startY, (b) -> {
            BoxLib.CONFIG.save();
            ClientUtils.setScreen(parent);
        }));

        // here's how you would set the wiki
        // I don't have a wiki, so I'll just
        // be setting it to the BoxLib GitHub repo
        setWiki(Component.translatable("boxlib.wiki"), ModConstants.WIKI);
    }

    @Override
    protected void initConfigButtons() {

        // here's how you would make an argb field
        // since they don't initialize with a label, I recommend adding one
        addConfigLine(new BCenteredLabel(Component.translatable("boxlib.anArgbField")));

        addConfigLine(new BArgbField(
                config().anArgbColor,
                newVal -> config().anArgbColor = newVal
        ));

        // you can add 2 entries in 1 line by passing 2 entries into the method
        addConfigLine(
            // here's how you would make a boolean button
            // since this one is a button, we don't need to add a label
            new BBooleanButton(
                "boxlib.aBoolean",
                config().aBoolean,
                newVal -> config().aBoolean = newVal
        ),
            // here's how you would make a toggle button out of an enum
            // you can make your own toggle buttons by extending the BToggleButton class
            new BEnumButton<>(
                "boxlib.anEnum",
                config().anEnum,
                ExampleConfigClass.ExampleEnum.class,
                newVal -> config().anEnum = newVal,
                GuiUtils.BLUE // this value will set the color of the generated text
        ));

        // here's how we would create a "double widget" using a widget container
        // this will allow us to have 2 values right text to each other

        // add this first so the labels can be above the fields
        addConfigLine(
                new BCenteredLabel(Component.translatable("boxlib.aDouble")),
                new BCenteredLabel(Component.translatable("boxlib.aFloat"))
        );

        // add the two fields
        addConfigLine(
                new BDoubleField(
                        config().aDouble,
                        newVal -> config().aDouble = newVal
                ),
                new BFloatField(
                        config().aFloat,
                        newVal -> config().aFloat = newVal
                )
        );

        // the rest is pretty much the same as the previous
        addConfigLine(new BCenteredLabel(Component.translatable("boxlib.aHexColor")));

        addConfigLine(new BHexField(
                config().aHexColor,
                newVal -> config().aHexColor = newVal
        ));

        // here's how we would add an integer
        addConfigLine(new BCenteredLabel(Component.translatable("boxlib.anInt")));

        addConfigLine(new BIntegerField(
                config().anInt,
                newVal -> config().anInt = newVal
        ));

        // here's how we would add a string
        addConfigLine(new BCenteredLabel(Component.translatable("boxlib.aString")));

        addConfigLine(new BStringField(
                config().aString,
                newVal -> config().aString = newVal
        ));

        // here's how we would add a long
        addConfigLine(new BCenteredLabel(Component.translatable("boxlib.aLong")));

        addConfigLine(new BLongField(
                config().aLong,
                newVal -> config().aLong = newVal
        ));

        // here's how we would add a long
        addConfigLine(new BCenteredLabel(Component.translatable("boxlib.aLong")));

        addConfigLine(new BLongField(
                config().aLong,
                newVal -> config().aLong = newVal
        ));

        // here's how we would add a short
        addConfigLine(new BCenteredLabel(Component.translatable("boxlib.aShort")));

        addConfigLine(new BShortField(
                config().aShort,
                newVal -> config().aShort = newVal
        ));

        // here is how we would add all of those values as sliders
        addConfigLine(
                new BDoubleSlider(
                        "boxlib.anotherDouble",
                        0.0D, 100.0D,
                        config().anotherDouble, 5,
                        newVal -> config().anotherDouble = newVal
                ),
                new BFloatSlider(
                        "boxlib.anotherFloat",
                        0.0F, 50.0F,
                        config().anotherFloat, 3,
                        newVal -> config().anotherFloat = newVal
                )
        );

        addConfigLine(
                new BIntegerSlider(
                        "boxlib.anotherInt",
                        0, 10,
                        config().anotherInt,
                        newVal -> config().anotherInt = newVal
                )
        );

        addConfigLine(
                new BLongSlider(
                        "boxlib.anotherLong",
                        100L, 5000L,
                        config().anotherLong,
                        newVal -> config().anotherLong = newVal
                )
        );

        addConfigLine(
                new BShortSlider(
                        "boxlib.anotherShort",
                        (short) 10, (short) 1000,
                        config().anotherShort,
                        newVal -> config().anotherShort = newVal
                )
        );

        RenderingLayout layout = createLayout();
        addConfigLine(
                new BCustomRenderingEntry(
                        (guiGraphics, x, y, width, height, mouseX, mouseY, tickDelta) -> {
                            layout.setPosition(x, y);

                            layout.render(guiGraphics);
                        }
                )
        );

        for (int i = 0; i < 10; i++) {
            addConfigLine(new BSpacingEntry());
        }

        /* remember that you can create your own config
         * entries by extending the BConfigButton,
         * BConfigTextField, or BConfigSlider classes */

    }

    private RenderingLayout createLayout() {
        RowLayout layout = new RowLayout(0, 0, 10);

        layout.addComponent(new ParagraphComponent(
                2,
                Component.literal("This is a paragraph component. "),
                Component.literal("It's a simple way to add text to a layout."),
                Component.literal("You can add as many components as you want."),
                Component.literal("And it will render them all in a line.")
        ));

        ColumnLayout verticalLayout = new ColumnLayout(0, 0, 10);

        for (int i = 0; i < 5; i++) {
            verticalLayout.addComponent(new ParagraphComponent(
                    2,
                    Component.literal("This is a paragraph component. "),
                    Component.literal("It's a simple way to add text to a layout.")
            ));
        }

        layout.addComponent(new LayoutContainerComponent(verticalLayout));

        return layout;
    }
}
