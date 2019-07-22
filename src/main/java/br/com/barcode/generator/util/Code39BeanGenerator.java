package br.com.barcode.generator.util;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Code39BeanGenerator implements Generator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Code39BeanGenerator.class);

    @Override
    public String generateBarcodeString(final String input) throws IOException {
        final Code39Bean bean = new Code39Bean();
        final int dpi = 150;

        bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi));
        bean.setWideFactor(3);
        bean.doQuietZone(false);

        // create output file
        final OutputStream out = new ByteArrayOutputStream();

        try {
            // Set up the canvas provider for monochrome PNG output
            final BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, "image/x-png", dpi,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);

            bean.generateBarcode(canvas, input);
            canvas.finish();

            // generate output array data
            byte[] data = ((ByteArrayOutputStream) out).toByteArray();

            // convert to base 64 string
            final String imgString = java.util.Base64.getEncoder().encodeToString(data);
            LOGGER.info(imgString);

            // close outputstream
            out.close();

            return imgString;
        } catch (final IOException e) {
            e.printStackTrace();
            LOGGER.error("" + e);
            throw e;
        } finally {
            try {
                out.close();
            } catch (final IOException e) {
                e.printStackTrace();
                LOGGER.error("" + e);
            }
        }
    }
}