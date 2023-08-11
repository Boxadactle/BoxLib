package dev.boxadactle.boxlib.config;

/**
 * Class for BoxLib config files
 * <p>
 * Config classes MUST annotate {@link dev.boxadactle.boxlib.config.BConfigFile} to be
 * registered as a config class
 */
public interface BConfig {

    default void onConfigLoadPre() {}
    default void onConfigLoadPost() {}

    default void onConfigSavePre() {}
    default void onConfigSavePost() {}

    class ConfigException extends RuntimeException {
        public ConfigException(String message) {
            super(message);
        }

        public ConfigException(Throwable cause) {
            super(cause);
        }
    }

}
