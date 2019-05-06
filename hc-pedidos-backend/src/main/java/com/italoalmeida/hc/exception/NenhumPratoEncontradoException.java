package com.italoalmeida.hc.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Italo Almeida
 *
 */
public class NenhumPratoEncontradoException extends Exception {

	private static final long serialVersionUID = -1212464647991667807L;
	
	@Override
	public String getMessage() {
		return "No momento não existem pratos disponíveis.";
	}
	
	public int getCodigo() {
		return HttpStatus.NOT_FOUND.value();
	}
	
	public HttpStatus getHttpStatus() {
		return HttpStatus.NOT_FOUND;
	}

}
