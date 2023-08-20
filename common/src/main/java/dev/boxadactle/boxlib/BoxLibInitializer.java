package dev.boxadactle.boxlib;

import org.apache.commons.compress.utils.Lists;

import dev.boxadactle.boxlib.base.BoxLib;
import dev.boxadactle.boxlib.base.ModConstants;
import dev.boxadactle.boxlib.config.BConfigClass;
import dev.boxadactle.boxlib.config.BConfigHandler;
import dev.boxadactle.boxlib.example.ExampleConfigClass;

public class BoxLibInitializer {

	public static BConfigClass<ExampleConfigClass> CONFIG;

	public static void init() {
		BoxLib.init();

		// make sure to register your config class like this
		CONFIG = BConfigHandler.registerConfig(ExampleConfigClass.class);

		BoxLib.LOGGER.info("Initialized %s", ModConstants.MOD_NAME + " v" + ModConstants.VERSION);
    }

}
