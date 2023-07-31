package dev.boxadactle.boxlib.example;

import dev.boxadactle.boxlib.BoxLib;
import dev.boxadactle.boxlib.ModConstants;
import dev.boxadactle.boxlib.config.BConfig;
import dev.boxadactle.boxlib.config.BConfigFile;

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

    public String aString = "Basic string value";

    @Override
    public void onConfigLoadPre() {
        BoxLib.LOGGER.info("This method will run before the config loads.");
    }

    @Override
    public void onConfigLoadPost() {
        BoxLib.LOGGER.info("This will be logged every time this config class successfully gets loaded with values.");
    }

    @Override
    public void onConfigSavePre() {
        BoxLib.LOGGER.info("This will be logged every time this config class successfully gets saved.");
        BoxLib.LOGGER.info("Might be a good idea to make some final config changes here.");
    }

    @Override
    public void onConfigSavePost() {
        BoxLib.LOGGER.info("This method will run after the config saves.");
    }

    public enum ExampleEnum {
        BIG,
        SMALL,
        TINY,
        NORMAL,
        GIGANTIC
    }

}
