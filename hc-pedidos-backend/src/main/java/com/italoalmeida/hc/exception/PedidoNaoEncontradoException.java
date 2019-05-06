package com.italoalmeida.hc.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Italo Almeida
 *
 */
public class PedidoNaoEncontradoException extends Exception {

	private static final long serialVersionUID = -6348689942209751457L;

	@Override
	public String getMessage() {
		return "Pedido não encontrado.";
	}
	
	public int getCodigo() {
		return HttpStatus.NOT_FOUND.value();
	}
	
	public HttpStatus getHttpStatus() {
		return HttpStatus.NOT_FOUND;
	}

}
