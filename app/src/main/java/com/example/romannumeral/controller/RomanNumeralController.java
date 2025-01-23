package com.example.romannumeral.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.romannumeral.model.ConversionResponse;
import com.example.romannumeral.service.RomanNumeralService;

/**
 * REST Controller for Roman numeral conversion endpoint.
 * Handles HTTP requests and delegates conversion to RomanNumeralService.
 */

@RestController
@CrossOrigin(origins = "*")
public class RomanNumeralController {
    /**
     * Converts query parameter to Roman numeral.
     * 
     * @param query Input number as string
     * @return ResponseEntity with conversion result or error
     */
    
    private static final Logger logger = LoggerFactory.getLogger(RomanNumeralController.class);
    private final RomanNumeralService romanNumeralService;
    
    public RomanNumeralController(RomanNumeralService romanNumeralService) {
        this.romanNumeralService = romanNumeralService;
    }
    
    @GetMapping("/romannumeral")
    public ResponseEntity<?> convertToRoman(@RequestParam("query") String query) {
        logger.info("Received conversion request for query: {}", query);
        try {
            int number = Integer.parseInt(query);
            logger.debug("Successfully parsed input number: {}", number);

            String romanNumeral = romanNumeralService.convertToRoman(number);
            logger.info("Successfully converted {} to Roman numeral: {}", number, romanNumeral);
            
            ConversionResponse response = new ConversionResponse(query, romanNumeral);
            return ResponseEntity.ok(response);
            
        } catch (NumberFormatException e) {
            logger.error("Invalid number format for input: {}", query, e);
            return ResponseEntity.badRequest()
                .body(new ErrorResponse("Invalid number format"));
        } catch (IllegalArgumentException e) {
            logger.error("Invalid input value: {}", query, e);
            return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage()));
        }
    }
}

class ErrorResponse {
    private final String error;
    
    public ErrorResponse(String error) {
        this.error = error;
    }
    
    public String getError() {
        return error;
    }
}