package br.com.barcode.generator.service;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.barcode.generator.dto.BarcodeDTO;
import br.com.barcode.generator.service.impl.BarcodeGeneratorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BarcodeGeneratorServiceTest {

    @InjectMocks
    private BarcodeGeneratorServiceImpl barcodeGeneratorService;

    @Test
    @DisplayName("Dado um valor válido deve retornar um BarcodeDTO")
    void dadoUmValorDeveRetornarUmBarcode() {
        // Arrange
        String valor = "meu codigo de barras";

        // Act
        BarcodeDTO barcode = this.barcodeGeneratorService.getBarcodeBase64(valor);

        // Assert
        assertThat(barcode.getValue()).isEqualTo(valor);
        assertThat(barcode.getBase64().lastIndexOf("=")).isGreaterThan(0);
    }
}