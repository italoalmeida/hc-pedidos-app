package com.italoalmeida.hc.exception.restcontroller;

import org.springframework.http.HttpStatus;

public class PedidoVazioException extends Exception {

	private static final long serialVersionUID = 4643303700417287305L;

	@Override
	public String getMessage() {
		return "Informe ao menos um prato para realizar o pedido.";
	}
	
	public int getCodigo() {
		return HttpStatus.BAD_REQUEST.value();
	}
	
	public HttpStatus getHttpStatus() {
		return HttpStatus.BAD_REQUEST;
	}

}
