package com.tp2.roman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test Roman Numerals")
class RomanNumeralsTest {

    private RomanNumerals converter;

    @BeforeEach
    void setUp() {
        converter = new RomanNumerals();
    }

    @Test
    @DisplayName("Paso 1: números básicos (1, 5, 10)")
    void convertsBasicNumbers() {
        assertEquals("I", converter.convert(1));
        assertEquals("II", converter.convert(2));
        assertEquals("V", converter.convert(5));
        assertEquals("X", converter.convert(10));
    }

    @Test
    @DisplayName("Paso 2: casos de resta (4, 9)")
    void convertsSubtractionCases() {
        assertEquals("IV", converter.convert(4));
        assertEquals("IX", converter.convert(9));
    }

    @Test
    @DisplayName("Paso 3: números medianos (40, 50, 90, 100)")
    void convertsMediumNumbers() {
        assertEquals("XL", converter.convert(40));
        assertEquals("L", converter.convert(50));
        assertEquals("XC", converter.convert(90));
        assertEquals("C", converter.convert(100));
    }

    @Test
    @DisplayName("Paso 4: números grandes (400, 500, 900, 1000)")
    void convertsLargeNumbers() {
        assertEquals("CD", converter.convert(400));
        assertEquals("D", converter.convert(500));
        assertEquals("CM", converter.convert(900));
        assertEquals("M", converter.convert(1000));
    }

    @Test
    @DisplayName("Paso 5: números complejos")
    void convertsComplexNumbers() {
        assertEquals("XXVII", converter.convert(27));
        assertEquals("MCMXCIV", converter.convert(1994));
        assertEquals("MMXXIII", converter.convert(2023) );
        assertEquals("MMMCMXCIX", converter.convert(3999) );
    }
}