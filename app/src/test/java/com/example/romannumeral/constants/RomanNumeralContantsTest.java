package com.example.romannumeral.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RomanNumeralConstantsTest {
    
    @Test
    void testConstantValues() {
        assertEquals(1, RomanNumeralConstants.MIN_VALUE);
        assertEquals(3999, RomanNumeralConstants.MAX_VALUE);
    }

    @Test
    void testRomanNumeralMapContent() {
        // Test map contains expected entries
        assertEquals("M", RomanNumeralConstants.ROMAN_NUMERAL_MAP.get(1000));
        assertEquals("CM", RomanNumeralConstants.ROMAN_NUMERAL_MAP.get(900));
        assertEquals("I", RomanNumeralConstants.ROMAN_NUMERAL_MAP.get(1));
    }

    @Test
    void testRomanNumeralMapSize() {
        assertEquals(13, RomanNumeralConstants.ROMAN_NUMERAL_MAP.size());
    }
}