package com.tp2.roman;

public class RomanNumerals {

    private static final int[] NUMERICALS = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    private static final String[] ROMAN = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public String convert(int number) {
        if (number <= 0 || number >= 4000) {
            throw new IllegalArgumentException("Must be between 1 and 3999.");
        }

        StringBuilder roman = new StringBuilder();
        int remaining = number;

        for (int i = 0; i < NUMERICALS.length; i++) {
            while (remaining >= NUMERICALS[i]) {
                roman.append(ROMAN[i]);
                remaining -= NUMERICALS[i];
            }
        }

        return roman.toString();
    }
}