package dev.boxadactle.boxlib.example;

import dev.boxadactle.boxlib.BoxLib;
import dev.boxadactle.boxlib.ModConstants;
import dev.boxadactle.boxlib.gui.BConfigScreen;
import dev.boxadactle.boxlib.gui.widget.*;
import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * Here is a super basic example config screen.
 * Config screens must extend {@link dev.boxadactle.boxlib.gui.BConfigScreen} to access the methods
 * Config values can be accessed/saved with config classes.
 * You can use an external library such as Cloth Config, but BoxLib already handles config
 * @see dev.boxadactle.boxlib.config.BConfig
 * @see dev.boxadactle.boxlib.config.BConfigFile
 */
public class ExampleConfigScreen extends BConfigScreen {

    public ExampleConfigScreen(Screen parent) {
        super(parent);

        // this is required (you can also do this yourself if you want) for using a cancel button
        BoxLib.CONFIG.cacheConfig();
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

        /* remember that you can create your own config
         * entries by extending the BConfigButton or
         * BConfigTextField classes */

    }
}
