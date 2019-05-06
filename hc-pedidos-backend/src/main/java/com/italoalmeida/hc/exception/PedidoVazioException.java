package com.italoalmeida.hc.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Italo Almeida
 *
 */
public class PedidoVazioException extends Exception {

	private static final long serialVersionUID = 4643303700417287305L;

	@Override
	public String getMessage() {
		return "Informe ao menos um prato para realizar seu pedido.";
	}
	
	public int getCodigo() {
		return HttpStatus.NOT_ACCEPTABLE.value();
	}
	
	public HttpStatus getHttpStatus() {
		return HttpStatus.NOT_ACCEPTABLE;
	}

}
