package com.example.romannumeral.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.romannumeral.model.ConversionResponse;
import com.example.romannumeral.service.RomanNumeralService;

@ExtendWith(MockitoExtension.class)
class RomanNumeralControllerTest {
    @Mock
    private RomanNumeralService romanNumeralService;
    
    @InjectMocks
    private RomanNumeralController controller;
    
    @Test
    void testValidInputShouldReturnSuccessResponse() {
        String input = "42";
        String expectedRoman = "XLII";
        when(romanNumeralService.convertToRoman(42)).thenReturn(expectedRoman);
        
        ResponseEntity<?> response = controller.convertToRoman(input);
        
        assertTrue(response.getStatusCode().is2xxSuccessful());
        ConversionResponse conversionResponse = (ConversionResponse) response.getBody();
        assertNotNull(conversionResponse);
        assertEquals(input, conversionResponse.getInput());
        assertEquals(expectedRoman, conversionResponse.getOutput());
    }
    
    @Test
    void testInvalidNumberFormatShouldReturnBadRequest() {
        String input = "not_a_number";
        
        ResponseEntity<?> response = controller.convertToRoman(input);
        
        assertTrue(response.getStatusCode().is4xxClientError());
        ErrorResponse errorResponse = (ErrorResponse) response.getBody();
        assertNotNull(errorResponse);
        assertEquals("Invalid number format", errorResponse.getError());
    }
    
    @Test
    void testOutOfRangeNumberShouldReturnBadRequest() {
        String input = "4000";
        when(romanNumeralService.convertToRoman(4000))
            .thenThrow(new IllegalArgumentException("Number must be between 1 and 3999"));
        
        ResponseEntity<?> response = controller.convertToRoman(input);
        
        assertTrue(response.getStatusCode().is4xxClientError());
        ErrorResponse errorResponse = (ErrorResponse) response.getBody();
        assertNotNull(errorResponse);
        assertEquals("Number must be between 1 and 3999", errorResponse.getError());
    }
}

