package br.com.barcode.generator.model;

import java.io.Serializable;

public class Barcode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1200597339226745158L;

	private String barcodeValue;
	private String base64Barcode;

	public String getBarcodeValue() {
		return barcodeValue;
	}

	public void setBarcodeValue(String barcodeValue) {
		this.barcodeValue = barcodeValue;
	}

	public String getBase64Barcode() {
		return base64Barcode;
	}

	public void setBase64Barcode(String base64Barcode) {
		this.base64Barcode = base64Barcode;
	}

}
