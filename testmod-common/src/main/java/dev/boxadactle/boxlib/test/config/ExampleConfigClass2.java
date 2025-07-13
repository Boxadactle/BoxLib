package dev.boxadactle.boxlib.test.config;

import dev.boxadactle.boxlib.config.BConfig;
import dev.boxadactle.boxlib.config.BConfigFile;
import dev.boxadactle.boxlib.gui.auto.*;

/**
 * Here is an example of a config system that
 * uses the BoxLib autoconfig system.
 */
@BConfigFile("funnyconfig")
@Gui("boxlib.autoconfigscreen")
public class ExampleConfigClass2 implements BConfig {

    // here is how you would automate a color picker field
    @Color(true)
    public int anArgbColor = 0x405c5c5c;

    // specify slider to show a color picker instead of a text field
    @Color
    @Slider(min = 0, max = 255)
    public int aColorPicker = 0x6796c7;

    // specify slider to show a color picker with alpha channel
    @Color(true)
    @Slider(min = 0, max = 255)
    public int aColorPickerwAlpha = 0x40c7c7c7;

    public boolean aBoolean = true;

    public double aDouble = 0.56;

    // you can override the default text key with the @CustomText annotation
    @CustomText("boxlib.customtext.aFloat")
    public float aFloat = 1.3f;

    // not specifying a value will not allow alpha customization
    // you can also add a tooltip with the @Tooltip annotation
    @Color
    @Tooltip("tooltip.hexcolor")
    public int aHexColor = 0x6796c7;

    public int anInt = 42;

    public long aLong = 1938;

    public short aShort = 10;

    public String aString = "Basic string value";

    public ExampleEnum anEnum = ExampleEnum.OPTION_TWO;

    // you can add sub-screens to your config
    public SlidersConfig sliders = new SlidersConfig();

    // you cna create subscreens by using
    // the @Gui annotation on a subclass
    @Gui("boxlib.autoconfigscreen.sliders")
    public static class SlidersConfig {
        // specify @Slider to render a slider for double values
        @Slider(min = 0, max = 10)
        public double anotherDouble = 3.432;

        @Slider(min = 0, max = 5)
        public float anotherFloat = 1.02f;

        @Slider(min = 0, max = 10)
        public int anotherInt = 5;

        @Slider(min = 0, max = 10000)
        public long anotherLong = 1938;

        @Slider(min = 0, max = 100)
        public short anotherShort = 25;
    }

    public enum ExampleEnum {
        OPTION_ONE,
        OPTION_TWO,
        OPTION_THREE
    }

}
