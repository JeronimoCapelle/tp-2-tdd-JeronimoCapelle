package com.tp2.leapyear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Leap Year Tests")
class LeapYearTest {

    private LeapYear leapYear;

    @BeforeEach
    void setUp() {
        leapYear = new LeapYear();
    }

    @Test
    @DisplayName("Paso 1: Caso base")
    void yearNotDivisibleBy4IsNotLeap() {
        assertFalse(leapYear.isLeap(2001));
        assertFalse(leapYear.isLeap(2003));
    }

    @Test
    @DisplayName("Paso 2: Divisible por 4")
    void yearIsLeapIfDivisibleBy4() {
        assertTrue(leapYear.isLeap(2004));
        assertTrue(leapYear.isLeap(1996));
    }

    @Test
    @DisplayName("Paso 3: Divisible por 100")
    void yearIsNotLeapIfDivisibleBy100ButNot400() {
        assertFalse(leapYear.isLeap(1900));
        assertFalse(leapYear.isLeap(1800));
    }

    @Test
    @DisplayName("Paso 4: Divisible por 400")
    void yearIsLeapIfDivisibleBy400() {
        assertTrue(leapYear.isLeap(2000));
        assertTrue(leapYear.isLeap(1600));
    }
}