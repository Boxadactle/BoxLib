package dev.boxadactle.boxlib.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Decorator for BoxLib config files
 * make sure to specify value, so the file is saved correctly
 * <p>
 * Config classes MUST implement {@link dev.boxadactle.boxlib.config.BConfig} to be
 * registered as a config class
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BConfigFile {

    /**
     * The name of the file to be saved/loaded
     *
     * @apiNote File extensions must not be included, as they will be appended by a different property
     */
    String value() default "";

    /**
     * Only specify this value if you don't want to use the default .json extension
     *
     * @apiNote "." is optional, it will be appended if you don't specify it
     */
    String filetype() default ".json";
}
