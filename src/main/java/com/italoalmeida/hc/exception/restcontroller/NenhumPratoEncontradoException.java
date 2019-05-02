package com.italoalmeida.hc.exception.restcontroller;

import org.springframework.http.HttpStatus;

public class NenhumPratoEncontradoException extends Exception {

	private static final long serialVersionUID = -1212464647991667807L;
	
	@Override
	public String getMessage() {
		return "No momento não existem pratos disponíveis.";
	}
	
	public int getCodigo() {
		return HttpStatus.NO_CONTENT.value();
	}
	
	public HttpStatus getHttpStatus() {
		return HttpStatus.NO_CONTENT;
	}

}
