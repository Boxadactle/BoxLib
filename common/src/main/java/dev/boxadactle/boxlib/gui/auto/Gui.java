package dev.boxadactle.boxlib.gui.auto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Gui {

    /**
     * Returns the name of the GUI.
     * Must be a translation key unless specified in translate field.
     *
     * @return The name of the GUI.
     */
    String value();

    /**
     * Indicates whether the GUI name is translatable.
     * Defaults to true, meaning the name should be a translation key.
     *
     * @return true if the name is translatable, false otherwise.
     */
    boolean translate() default true;

}
