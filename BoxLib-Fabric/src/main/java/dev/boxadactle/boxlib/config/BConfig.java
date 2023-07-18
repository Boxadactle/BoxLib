package dev.boxadactle.boxlib.config;

public interface BConfig {

    default void onConfigLoad() {}

    default void onConfigSave() {}

    class ConfigException extends RuntimeException {
        public ConfigException(String message) {
            super(message);
        }

        public ConfigException(Throwable cause) {
            super(cause);
        }
    }

}
