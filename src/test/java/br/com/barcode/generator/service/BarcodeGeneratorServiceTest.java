package br.com.barcode.generator.service;

import br.com.barcode.generator.util.Code39BeanGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class BarcodeGeneratorServiceTest {

    @Test
    void whenAValidStringIsReceivedMustReturnsANonEmptyString() {
        try {
            //TODO mockar parametro
            final BarcodeGeneratorService service = new BarcodeGeneratorService(new Code39BeanGenerator());
            final String returnedString = service.getBarcodeBase64("123");
            assertTrue(!returnedString.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error: " + e);
        }
    }
}