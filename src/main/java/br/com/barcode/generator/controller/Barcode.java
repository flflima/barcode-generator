package br.com.barcode.generator.controller;

import java.io.Serializable;

public class Barcode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9120426054921954883L;

	private String value;

	private String valueBase64;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValueBase64() {
		return valueBase64;
	}

	public void setValueBase64(String valueBase64) {
		this.valueBase64 = valueBase64;
	}

}
