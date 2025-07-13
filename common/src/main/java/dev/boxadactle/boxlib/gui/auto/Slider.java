package dev.boxadactle.boxlib.gui.auto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Slider {

    double min();
    double max();

    int decimalPlaces() default 2;

}
