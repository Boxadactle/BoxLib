package dev.boxadactle.boxlib.gui.auto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to mark a field as a color.
 * This can be used for automatic GUI generation or configuration.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Color {

    /**
     * Whether to allow alpha
     * This is used for display purposes in the GUI.
     */
    boolean value() default false;

}
