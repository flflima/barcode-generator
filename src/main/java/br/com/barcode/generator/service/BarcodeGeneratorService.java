package br.com.barcode.generator.service;

import br.com.barcode.generator.dto.BarcodeDTO;

import java.io.IOException;

public interface BarcodeGeneratorService {
	BarcodeDTO getBarcodeBase64(final String barcodeValue) throws IOException;
}
