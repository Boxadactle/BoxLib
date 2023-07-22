package dev.boxadactle.boxlib.config;

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
