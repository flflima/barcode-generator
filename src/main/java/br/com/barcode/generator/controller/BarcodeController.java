package br.com.barcode.generator.controller;

import br.com.barcode.generator.dto.BarcodeDTO;
import br.com.barcode.generator.service.BarcodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("generate-barcode")
public class BarcodeController {

	@Autowired
	private BarcodeGeneratorService barcodeGeneratorService;

	@GetMapping(path = "{value}")
	public ResponseEntity<?> getBarcode(@PathVariable final String value) {
		try {
			final BarcodeDTO barcode = this.barcodeGeneratorService.getBarcodeBase64(value);
			return new ResponseEntity<>(barcode, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}