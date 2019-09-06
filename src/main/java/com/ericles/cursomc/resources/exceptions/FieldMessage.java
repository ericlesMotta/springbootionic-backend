package com.ericles.cursomc.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String nome;

	public FieldMessage() {

	}

	public FieldMessage(String fieldName, String nome) {
		super();
		this.fieldName = fieldName;
		this.nome = nome;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
