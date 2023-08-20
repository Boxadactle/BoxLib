package dev.boxadactle.boxlib.math.mathutils;

import java.text.DecimalFormat;

public class NumberFormatter<T extends Number> {
    private final DecimalFormat decimalFormat;

    public NumberFormatter() {
        this.decimalFormat = new DecimalFormat("#.##########"); // Default format with 10 decimal places
    }

    public NumberFormatter(int decimalPlaces) {
        if (decimalPlaces <= 0) {
            throw new IllegalArgumentException("Decimal places must be greater than zero.");
        }
        StringBuilder formatPattern = new StringBuilder("#.");
        for (int i = 0; i < decimalPlaces; i++) {
            formatPattern.append("#");
        }
        this.decimalFormat = new DecimalFormat(formatPattern.toString());
    }

    public String formatDecimal(T number) {
        return decimalFormat.format(number.doubleValue());
    }

    public String formatScientific(T number) {
        return String.format("%e", number.doubleValue());
    }
}