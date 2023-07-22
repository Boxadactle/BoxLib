package dev.boxadactle.boxlib.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.boxadactle.boxlib.BoxLib;

import java.io.*;
import java.util.function.Supplier;

public class BConfigClass<T extends BConfig> implements Supplier<T> {

    Class<T> configClass;
    File filePath;
    Gson serializer;
    T config;
    T cached;

    public BConfigClass(Class<T> configClass, File configFile) {
        this.configClass = configClass;
        filePath = configFile;
        serializer = new GsonBuilder().setPrettyPrinting().create();
    }

    public T get() {
        return config;
    }

    public void reload() {
        load();
    }

    public void resetConfig() {
        config = BoxLib.initializeClass(configClass);

        save();
    }

    public void cacheConfig() {
        cached = config;
    }

    public void clearCache() {
        cached = null;
    }

    public void restoreCache() {
        if (cached == null) throw new NullPointerException("No config cache was found for class " + configClass.getName());

        config = cached;
        clearCache();

        save();
    }

    public void load() {
        try {
            BufferedReader r = new BufferedReader(new FileReader(filePath));

            config = serializer.fromJson(r, configClass);

            BoxLib.LOGGER.info("Successfully loaded config class %s" + configClass.getName());

            config.onConfigLoad();
        } catch (FileNotFoundException ignored) {
            BoxLib.LOGGER.warn("Could not find file %s so creating it" + filePath.getName());

            config = BoxLib.initializeClass(configClass);

            save();
        }
    }

    public void save() {
        try {
            String json = serializer.toJson(config);
            FileWriter writer = new FileWriter(filePath);
            writer.write(json);
            writer.flush();
            writer.close();

            BoxLib.LOGGER.info("Successfully saved config for class %s", configClass.getName());

            config.onConfigSave();
        } catch (IOException e) {
            BoxLib.LOGGER.error("Could not save config for class %s", configClass.getName());
            BoxLib.LOGGER.printStackTrace(e);
        }
    }

}
