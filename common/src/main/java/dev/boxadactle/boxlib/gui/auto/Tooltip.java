package dev.boxadactle.boxlib.gui.auto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to mark a field with a tooltip.
 * This can be used to provide additional information or hints for GUI elements.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Tooltip {

    /**
     * The tooltip text.
     * This should be a brief description or hint for the user.
     *
     * @return The tooltip text as a string.
     */
    String value();

    /**
     * Indicates whether the tooltip should be translated.
     * If true, the tooltip text will be processed for localization.
     * If false, the tooltip text will be used as is without translation.
     *
     * @return true if the tooltip should be translated, false otherwise.
     */
    boolean translate() default true;

}
