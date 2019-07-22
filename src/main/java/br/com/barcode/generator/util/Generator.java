package br.com.barcode.generator.util;

public interface Generator {

    public String generateBarcodeString(final String input) throws Exception;
}
