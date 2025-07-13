package dev.boxadactle.boxlib.gui.auto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to indicate that a value should be hidden in the GUI.
 * This can be used to prevent certain values from being displayed
 * in the user interface, such as sensitive information or internal data.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface HideValue {
}
