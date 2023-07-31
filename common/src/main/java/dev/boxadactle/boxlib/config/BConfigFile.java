package dev.boxadactle.boxlib.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Decorator for BoxLib config files
// make sure to specify value, so the file is saved correctly
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BConfigFile {

    // the name of the file
    // Do not include the file extension, if you want to use a different one, use the filetype parameter
    String value() default "";

    // Only override if you don't want to use the default .json
    // "." is optional, it will be appended if you don't specify it
    String filetype() default ".json";
}
