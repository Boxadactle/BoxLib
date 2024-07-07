package dev.boxadactle.boxlib.config;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * This interface represents a configuration file in BoxLib.
 * <p>
 * Any class that implements this interface must be annotated with {@link dev.boxadactle.boxlib.config.BConfigFile}
 * to be registered as a configuration class.
 */
public interface BConfig {

    /**
     * This method is called before the configuration is loaded.
     */
    default void onConfigLoadPre() {}

    /**
     * This method is called after the configuration is loaded.
     */
    default void onConfigLoadPost() {}

    /**
     * This method is called before the configuration is saved.
     */
    default void onConfigSavePre() {}

    /**
     * This method is called after the configuration is saved.
     */
    default void onConfigSavePost() {}

    /**
     * This method copies the configuration object and retains all of the values
     */
    @SuppressWarnings("unchecked")
    static <T extends BConfig> T copy(T config) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends T> clazz = (Class<? extends T>) config.getClass();
        T newObject = clazz.getConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            field.set(newObject, field.get(config));
        }

        return newObject;
    }

    /**
     * This class represents an exception that can occur during configuration operations.
     */
    class ConfigException extends RuntimeException {
        /**
         * Constructs a new ConfigException with the specified detail message.
         *
         * @param message the detail message
         */
        public ConfigException(String message) {
            super(message);
        }

        /**
         * Constructs a new ConfigException with the specified cause.
         *
         * @param cause the cause
         */
        public ConfigException(Throwable cause) {
            super(cause);
        }
    }

}