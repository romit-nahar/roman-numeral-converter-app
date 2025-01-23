package com.example.romannumeral.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.romannumeral.constants.RomanNumeralConstants;
import com.example.romannumeral.service.RomanNumeralService;

/**
 * Service implementation for converting decimal numbers to Roman numerals.
 * Supports conversion for integers between 1 and 3999.
 */
@Service
public class RomanNumeralServiceImpl implements RomanNumeralService {
    private static final Logger logger = LoggerFactory.getLogger(RomanNumeralServiceImpl.class);

    /**
     * Converts a decimal number to its Roman numeral representation.
     * 
     * @param number Integer to be converted (must be between 1 and 3999)
     * @return Roman numeral string representation of the input
     * @throws IllegalArgumentException If number is outside valid range
     */
    @Override
    public String convertToRoman(int number) {
        logger.debug("Starting conversion for number: {}", number);
        validateInput(number);

        StringBuilder result = new StringBuilder();
        int remaining = number;

        for (Map.Entry<Integer, String> entry : RomanNumeralConstants.ROMAN_NUMERAL_MAP.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();
            
            if (remaining >= value) {
                int count = remaining / value;
                result.append(symbol.repeat(count));
                remaining = remaining % value;
            }
        }

        logger.debug("Completed conversion: {} -> {}", number, result.toString());
        return result.toString();
    }

    /**
     * Validates input number against allowed range.
     * 
     * @param number Input number to validate
     * @throws IllegalArgumentException If number is outside valid range
     */
    private void validateInput(int number) {
        logger.debug("Validating input number: {}", number);
        if (number < RomanNumeralConstants.MIN_VALUE || number > RomanNumeralConstants.MAX_VALUE) {
            logger.error("Invalid input: {} (must be between {} and {})", 
                number, RomanNumeralConstants.MIN_VALUE, RomanNumeralConstants.MAX_VALUE);
            throw new IllegalArgumentException(
                String.format("Number must be between %d and %d", 
                    RomanNumeralConstants.MIN_VALUE, RomanNumeralConstants.MAX_VALUE)
            );
        }
    }
}