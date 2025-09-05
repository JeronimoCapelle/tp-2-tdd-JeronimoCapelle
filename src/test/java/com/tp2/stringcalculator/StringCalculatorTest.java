package com.tp2.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("StringCalculator Tests")
class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        // Crea una nueva instancia antes de cada test para garantizar el aislamiento.
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("Paso 1: String vacío")
    void emptyStringShouldReturn0() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    @DisplayName("Paso 2: Un número")
    void singleNumberShouldReturnThatNumber() {
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }

    @Test
    @DisplayName("Paso 3: Dos números")
    void twoNumbersSeparatedByCommaShouldReturnTheirSum() {
        assertEquals(3, calculator.add("1,2"));
        assertEquals(15, calculator.add("10,5"));
    }

    @Test
    @DisplayName("Paso 4: Múltiples números")
    void multipleNumbersSeparatedByCommaShouldReturnTheirSum() {
        assertEquals(6, calculator.add("1,2,3"));
        assertEquals(20, calculator.add("5,5,5,5"));
    }

    @Test
    @DisplayName("Paso 5: Saltos de línea")
    void numbersSeparatedByNewlineShouldWorkAsDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("5\n5"));
    }

    @Test
    @DisplayName("Paso 6: Números negativos (excepción)")
    void negativeNumbersShouldThrowIllegalArgumentException() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> calculator.add("-1"));
        assertEquals("Negatives not allowed: -1", exception1.getMessage());

        // Verifica que se lanza la excepción para múltiples negativos.
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> calculator.add("1,-2,3,-4"));
        assertEquals("Negatives not allowed: -2, -4", exception2.getMessage());
    }
}