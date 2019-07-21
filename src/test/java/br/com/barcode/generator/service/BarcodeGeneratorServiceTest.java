package br.com.barcode.generator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BarcodeGeneratorServiceTest {

    @Test
    void whenAValidStringIsReceivedMustReturnsANonEmptyString() {
        final BarcodeGeneratorService service = new BarcodeGeneratorService();
        final String returnedString = service.getBarcodeBase64("123");
        assertTrue(!returnedString.isEmpty());
    }
}