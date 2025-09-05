package com.tp2.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] stringNumbers = numbers.split("[,\n]");

        List<Integer> parsedNumbers = new ArrayList<>();
        List<Integer> negNumbers = new ArrayList<>();

        for (String s : stringNumbers) {
            if (!s.trim().isEmpty()) {
                int num = Integer.parseInt(s.trim());
                if (num < 0) {
                    negNumbers.add(num);
                }
                parsedNumbers.add(num);
            }
        }

        if (!negNumbers.isEmpty()) {
            String negList = negNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("Negatives not allowed: " + negList);
        }

        return parsedNumbers.stream().mapToInt(Integer::intValue).sum();
    }
}