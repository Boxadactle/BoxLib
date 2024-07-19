package dev.boxadactle.boxlib.test.config;

import dev.boxadactle.boxlib.core.ModConstants;
import dev.boxadactle.boxlib.config.BConfig;
import dev.boxadactle.boxlib.config.BConfigFile;
import dev.boxadactle.boxlib.test.TestMod;

/**
 * Here is a super basic example config class.
 * You can copy+paste from this if you want.
 * All the values specified in a config file are the default values.
 * A config class must annotate BConfigFile and specify the name of the file,
 * and must implement BConfig
 */
@BConfigFile(ModConstants.MOD_ID)
public class ExampleConfigClass implements BConfig {

    public int anArgbColor = 0x405c5c5c;

    public boolean aBoolean = true;

    public double aDouble = 0.56;

    public ExampleEnum anEnum = ExampleEnum.NORMAL;

    public float aFloat = 1.3f;

    public int aHexColor = 0x6796c7;

    public int anInt = 42;

    public long aLong = 1938;

    public short aShort = 10;

    public String aString = "Basic string value";

    public double anotherDouble = 3.432;

    public float anotherFloat = 1.02f;

    public int anotherInt = 5;

    public long anotherLong = 1938;

    public short anotherShort = 25;

    @Override
    public void onConfigLoadPost() {
        TestMod.LOGGER.info("This will be logged every time this config class successfully gets loaded with values.");
    }

    @Override
    public void onConfigSavePre() {
        TestMod.LOGGER.info("This will be logged every time this config class successfully gets saved.");
        TestMod.LOGGER.info("Might be a good idea to make some final config changes here.");
    }

    @Override
    public void onConfigSavePost() {
        TestMod.LOGGER.info("This method will run after the config saves.");
    }

    public enum ExampleEnum {
        BIG,
        SMALL,
        TINY,
        NORMAL,
        GIGANTIC
    }

}
