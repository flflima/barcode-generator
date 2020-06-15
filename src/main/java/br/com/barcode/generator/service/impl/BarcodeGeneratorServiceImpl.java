package br.com.barcode.generator.service.impl;

import static java.util.Base64.getEncoder;

import br.com.barcode.generator.dto.BarcodeDTO;
import br.com.barcode.generator.service.BarcodeGeneratorService;
import lombok.extern.log4j.Log4j2;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@Log4j2
public class BarcodeGeneratorServiceImpl implements BarcodeGeneratorService {

    private static final String MIME_TYPE = "image/x-png";
    private static final Integer DPI = 150;

    @Override
    public BarcodeDTO getBarcodeBase64(final String value) {
        // create output file
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        log.info("Gerando código de barras");

        try {
            // Set up the canvas provider for monochrome PNG output
            buildCanvas(value, out);

            String imgString = getEncoder().encodeToString(out.toByteArray());
            log.debug(imgString);

            return new BarcodeDTO(value, imgString);
        } catch (final IOException e) {
            log.error("Error: {}", e.getMessage());
        } finally {
            try {
                out.close();
            } catch (final IOException e) {
                log.error("Error: {}", e.getMessage());
            }
        }

        return new BarcodeDTO();
    }

    private void buildCanvas(String value, ByteArrayOutputStream out) throws IOException {
        Code39Bean bean = getCode39Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, MIME_TYPE, DPI,
            BufferedImage.TYPE_BYTE_BINARY, false, 0);
        bean.generateBarcode(canvas, value);
        canvas.finish();
    }

    private Code39Bean getCode39Bean() {
        Code39Bean bean = new Code39Bean();

        bean.setModuleWidth(UnitConv.in2mm(1.0f / DPI));
        bean.setWideFactor(3);
        bean.doQuietZone(false);

        return bean;
    }
}
