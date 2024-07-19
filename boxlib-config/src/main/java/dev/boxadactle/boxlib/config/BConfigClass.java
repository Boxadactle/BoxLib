package dev.boxadactle.boxlib.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.boxadactle.boxlib.core.BoxLib;

import java.io.*;
import java.util.function.Supplier;

/**
 * This class is responsible for managing a configuration class that implements {@link BConfig}.
 * It provides methods to load, save, cache, and reset the configuration.
 *
 * @param <T> the type of the configuration class
 */
public class BConfigClass<T extends BConfig> implements Supplier<T> {

    Class<T> configClass;
    File filePath;
    Gson serializer;
    T config;
    T cached;

    /**
     * Constructs a new BConfigClass with the specified configuration class and file.
     *
     * @param configClass the configuration class
     * @param configFile the configuration file
     */
    public BConfigClass(Class<T> configClass, File configFile) {
        this.configClass = configClass;
        filePath = configFile;
        serializer = new GsonBuilder().setPrettyPrinting().create();

        config = BoxLib.initializeClass(configClass);
    }

    /**
     * Returns the current configuration.
     *
     * @return the current configuration
     */
    public T get() {
        return config;
    }

    /**
     * Reloads the configuration from the file.
     */
    public void reload() {
        load();
    }

    /**
     * Resets the configuration to its initial state and saves it to the file.
     */
    public void resetConfig() {
        config = BoxLib.initializeClass(configClass);

        save();
    }

    /**
     * Caches the current configuration.
     */
    public void cacheConfig() {
        try {
            cached = BConfig.copy(config);
            BoxLib.LOGGER.info("Cached config for class %s", configClass.getSimpleName());
        } catch (Exception e) {
            BoxLib.LOGGER.error("Could not cache config for class %s", configClass.getSimpleName());
            BoxLib.LOGGER.printStackTrace(e);
        }
    }


    /**
     * Clears the configuration cache.
     */
    public void clearCache() {
        cached = null;
    }

    /**
     * Restores the configuration from the cache and saves it to the file.
     *
     * @throws NullPointerException if no configuration cache was found
     */
    public void restoreCache() {
        if (cached == null) throw new NullPointerException("No config cache was found for class " + configClass.getSimpleName());

        BoxLib.LOGGER.info("Restoring cached config for class %s", config.getClass().getSimpleName());

        config = cached;
        clearCache();

        save();
    }

    /**
     * Loads the configuration from the file.
     * If the file does not exist, it initializes the configuration and saves it to the file.
     */
    public void load() {
        try {
            BufferedReader r = new BufferedReader(new FileReader(filePath));

            config = serializer.fromJson(r, configClass);

            BoxLib.LOGGER.info("Successfully loaded config class %s", configClass.getSimpleName());

            config.onConfigLoadPost();
        } catch (FileNotFoundException ignored) {
            BoxLib.LOGGER.warn("Could not find file %s so creating it", filePath.getName());

            config = BoxLib.initializeClass(configClass);

            save();
        }
    }

    /**
     * Saves the current configuration to the file.
     */
    public void save() {
        try {
            config.onConfigSavePre();

            String json = serializer.toJson(config);
            FileWriter writer = new FileWriter(filePath);
            writer.write(json);
            writer.flush();
            writer.close();

            BoxLib.LOGGER.info("Successfully saved config for class %s", configClass.getSimpleName());

            config.onConfigSavePost();
        } catch (IOException e) {
            BoxLib.LOGGER.error("Could not save config for class %s", configClass.getSimpleName());
            BoxLib.LOGGER.printStackTrace(e);
        }
    }

}
