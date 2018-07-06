package br.com.barcode.generator.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BarcodeGeneratorService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 291805557689468643L;

	private static final Logger LOGGER = LoggerFactory.getLogger(BarcodeGeneratorService.class);

	public String getBarcodeBase64(final String oficioControle) {
		LOGGER.debug("Gerando código de barra para o Ofício " + oficioControle);

		final Code39Bean bean = new Code39Bean();
		final int dpi = 150;

		// Configure the barcode generator
		bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); // makes the narrow bar
		// width exactly one pixel
		bean.setWideFactor(3);
		bean.doQuietZone(false);

		// Open output file
		OutputStream out = new ByteArrayOutputStream();

		try {
			// Set up the canvas provider for monochrome PNG output
			final BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, "image/x-png", dpi,
					BufferedImage.TYPE_BYTE_BINARY, false, 0);

			// Generate the barcode
			bean.generateBarcode(canvas, oficioControle);

			// Signal end of generation
			canvas.finish();

			byte[] data = ((ByteArrayOutputStream) out).toByteArray();

			final String imgString = java.util.Base64.getEncoder().encodeToString(data);

			LOGGER.debug(imgString);

			out.close();

			return imgString;
		} catch (final IOException e) {
			e.printStackTrace();
			LOGGER.error("" + e);
		} finally {
			try {
				out.close();
			} catch (final IOException e) {
				e.printStackTrace();
				LOGGER.error("" + e);
			}
		}

		return "";
	}

}