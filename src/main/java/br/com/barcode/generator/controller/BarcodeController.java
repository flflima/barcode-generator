package br.com.barcode.generator.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barcode.generator.service.BarcodeGeneratorService;

@RestController
@RequestMapping("barcode")
public class BarcodeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8126043232634467033L;

	@Autowired
	private BarcodeGeneratorService barcodeGeneratorService;

	@GetMapping(path = "{value}")
	public ResponseEntity<?> getBarcode(@PathVariable final String value) throws Exception {
		final String barcode = this.barcodeGeneratorService.getBarcodeBase64(value);
		return new ResponseEntity<>(barcode, HttpStatus.OK);
	}

}