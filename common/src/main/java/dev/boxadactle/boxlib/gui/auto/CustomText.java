package dev.boxadactle.boxlib.gui.auto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to mark a field with a custom translation key
 * This can be used to identify classes that represent custom keys in the application.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomText {

    /**
     * The custom translation key.
     * This should be a unique identifier for the key.
     *
     * @return The translation key as a string.
     */
    String value();

}
