package com.example.romannumeral.constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConstants {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 3999;
    
    public static final Map<Integer, String> ROMAN_NUMERAL_MAP = new LinkedHashMap<>();
    
    static {
        ROMAN_NUMERAL_MAP.put(1000, "M");
        ROMAN_NUMERAL_MAP.put(900, "CM");
        ROMAN_NUMERAL_MAP.put(500, "D");
        ROMAN_NUMERAL_MAP.put(400, "CD");
        ROMAN_NUMERAL_MAP.put(100, "C");
        ROMAN_NUMERAL_MAP.put(90, "XC");
        ROMAN_NUMERAL_MAP.put(50, "L");
        ROMAN_NUMERAL_MAP.put(40, "XL");
        ROMAN_NUMERAL_MAP.put(10, "X");
        ROMAN_NUMERAL_MAP.put(9, "IX");
        ROMAN_NUMERAL_MAP.put(5, "V");
        ROMAN_NUMERAL_MAP.put(4, "IV");
        ROMAN_NUMERAL_MAP.put(1, "I");
    }
}
