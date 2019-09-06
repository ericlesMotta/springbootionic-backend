package com.ericles.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	List<FieldMessage> erros = new ArrayList<>();
	
	
	public List<FieldMessage> getErrors() {
		return erros;
	}


	public void addError(String fieldName, String mensagem) {
		erros.add(new FieldMessage(fieldName,mensagem));
	}


	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}

}
