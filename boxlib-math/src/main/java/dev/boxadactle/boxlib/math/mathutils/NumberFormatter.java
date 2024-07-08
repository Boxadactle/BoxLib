package dev.boxadactle.boxlib.math.mathutils;

import java.text.DecimalFormat;
import java.util.Currency;

/**
 * The NumberFormatter class provides utility methods for formatting numbers.
 *
 * @param <T> the type of number to format
 */
public class NumberFormatter<T extends Number> {
    private final DecimalFormat decimalFormat;

    /**
     * Constructs a NumberFormatter with the default format pattern, which includes 10 decimal places.
     */
    public NumberFormatter() {
        this.decimalFormat = new DecimalFormat("#.##########");
    }

    /**
     * Constructs a NumberFormatter with a custom format pattern based on the specified decimal places.
     *
     * @param decimalPlaces the number of decimal places to include in the format pattern
     * @throws IllegalArgumentException if decimalPlaces is less than zero
     */
    public NumberFormatter(int decimalPlaces) {
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("Decimal places must be at least zero.");
        }
        StringBuilder formatPattern = new StringBuilder("#");
        if (decimalPlaces != 0) formatPattern.append(".");
        for (int i = 0; i < decimalPlaces; i++) {
            formatPattern.append("#");
        }
        this.decimalFormat = new DecimalFormat(formatPattern.toString());
    }

    /**
     * Formats the specified number as a decimal using the configured format pattern.
     *
     * @param number the number to format
     * @return the formatted decimal as a string
     */
    public String formatDecimal(T number) {
        return decimalFormat.format(number.doubleValue());
    }

    /**
     * Formats the specified number in scientific notation.
     *
     * @param number the number to format
     * @return the formatted number in scientific notation as a string
     */
    public String formatScientific(T number) {
        return String.format("%e", number.doubleValue());
    }

    /**
     * Formats the specified number as currency using the specified currency.
     *
     * @param number   the number to format
     * @param currency the currency to use for formatting
     * @return the formatted number as currency as a string
     */
    public String formatCurrency(T number, Currency currency) {
        DecimalFormat currencyFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        currencyFormat.setCurrency(currency);
        return currencyFormat.format(number.doubleValue());
    }

    /**
     * Formats the specified number as a percentage.
     *
     * @param number the number to format
     * @return the formatted number as a percentage as a string
     */
    public String formatPercentage(T number) {
        double value = number.doubleValue() * 100;
        return decimalFormat.format(value) + "%";
    }

    /**
     * Formats the specified number with grouping separators.
     *
     * @param number the number to format
     * @return the formatted number with grouping separators as a string
     */
    public String formatWithGrouping(T number) {
        DecimalFormat groupedDecimalFormat = (DecimalFormat) DecimalFormat.getInstance();
        groupedDecimalFormat.setGroupingUsed(true);
        return groupedDecimalFormat.format(number.doubleValue());
    }

    /**
     * Checks if the specified number is within the specified range (inclusive).
     *
     * @param number the number to check
     * @param min    the minimum value of the range
     * @param max    the maximum value of the range
     * @return true if the number is within the range, false otherwise
     */
    public boolean isWithinRange(T number, T min, T max) {
        double value = number.doubleValue();
        return value >= min.doubleValue() && value <= max.doubleValue();
    }
}