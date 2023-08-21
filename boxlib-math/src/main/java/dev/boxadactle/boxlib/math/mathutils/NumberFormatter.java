package dev.boxadactle.boxlib.math.mathutils;

import java.text.DecimalFormat;
import java.util.Currency;

public class NumberFormatter<T extends Number> {
    private final DecimalFormat decimalFormat;

    public NumberFormatter() {
        this.decimalFormat = new DecimalFormat("#.##########"); // Default format with 10 decimal places
    }

    public NumberFormatter(int decimalPlaces) {
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("Decimal places must be at least zero.");
        }
        StringBuilder formatPattern = new StringBuilder("#");
        if (decimalPlaces == 0) formatPattern.append(".");
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

    public String formatCurrency(T number, Currency currency) {
        DecimalFormat currencyFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        currencyFormat.setCurrency(currency);
        return currencyFormat.format(number.doubleValue());
    }

    public String formatPercentage(T number) {
        double value = number.doubleValue() * 100;
        return decimalFormat.format(value) + "%";
    }

    public String formatWithGrouping(T number) {
        DecimalFormat groupedDecimalFormat = (DecimalFormat) DecimalFormat.getInstance();
        groupedDecimalFormat.setGroupingUsed(true);
        return groupedDecimalFormat.format(number.doubleValue());
    }

    public boolean isWithinRange(T number, T min, T max) {
        double value = number.doubleValue();
        return value >= min.doubleValue() && value <= max.doubleValue();
    }

}