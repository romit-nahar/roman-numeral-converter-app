package com.example.romannumeral.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RomanNumeralServiceImplTest {

    private RomanNumeralServiceImpl romanNumeralService;

    @BeforeEach
    void setUp() {
        romanNumeralService = new RomanNumeralServiceImpl();
    }

    @ParameterizedTest
    @CsvSource({
        "1, I",
        "4, IV",
        "5, V",
        "9, IX",
        "10, X",
        "40, XL",
        "50, L",
        "90, XC",
        "100, C",
        "400, CD",
        "500, D",
        "900, CM",
        "1000, M",
        "3999, MMMCMXCIX"
    })
    void testConvertToRoman_ValidInputs(int input, String expected) {
        assertEquals(expected, romanNumeralService.convertToRoman(input));
    }

    @Test
    void testConvertToRomanComplexNumbers() {
        assertEquals("MMMDCCCLXXXVIII", romanNumeralService.convertToRoman(3888));
        assertEquals("MMCDXLIV", romanNumeralService.convertToRoman(2444));
        assertEquals("MCMXCIX", romanNumeralService.convertToRoman(1999));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 4000, 5000})
    void testConvertToRomanInvalidInputs(int input) {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> romanNumeralService.convertToRoman(input)
        );
        
        assertTrue(exception.getMessage().contains("Number must be between"));
    }

    @Test
    void testConvertToRomanBoundaryValues() {
        // Test minimum value
        assertEquals("I", romanNumeralService.convertToRoman(1));
        
        // Test maximum value
        assertEquals("MMMCMXCIX", romanNumeralService.convertToRoman(3999));
    }

    @Test
    void testConvertToRomanRepeatingNumerals() {
        assertEquals("III", romanNumeralService.convertToRoman(3));
        assertEquals("MMM", romanNumeralService.convertToRoman(3000));
        assertEquals("CCXX", romanNumeralService.convertToRoman(220));
    }
}