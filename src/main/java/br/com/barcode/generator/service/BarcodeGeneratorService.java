package br.com.barcode.generator.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import br.com.barcode.generator.util.Generator;
import org.krysalis.barcode4j.BarcodeGenerator;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BarcodeGeneratorService implements Serializable {

	private static final long serialVersionUID = 291805557689468643L;

	private static final Logger LOGGER = LoggerFactory.getLogger(BarcodeGeneratorService.class);

	private Generator barcodeGenerator;

	public BarcodeGeneratorService(Generator barcodeGenerator) {
		this.barcodeGenerator = barcodeGenerator;
	}

	public String getBarcodeBase64(final String barcodeValue) throws Exception {
		LOGGER.info("BarcodeValue " + barcodeValue);

		return this.barcodeGenerator.generateBarcodeString(barcodeValue);
	}

}
