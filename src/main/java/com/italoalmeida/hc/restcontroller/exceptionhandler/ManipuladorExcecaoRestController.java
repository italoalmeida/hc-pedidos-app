package com.italoalmeida.hc.restcontroller.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.italoalmeida.hc.exception.NenhumPratoEncontradoException;
import com.italoalmeida.hc.exception.PedidoNaoEncontradoException;
import com.italoalmeida.hc.exception.PedidoVazioException;

/**
 * @author Italo Almeida
 *
 */
@RestControllerAdvice
public class ManipuladorExcecaoRestController {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> manipularException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ExcecaoRestDetalhe("Desculpe! Não foi possível realizar a operação, tente recarregar sua página. Caso o erro persista, contate a equipe técnica.", 
						HttpStatus.INTERNAL_SERVER_ERROR.value()));
	}
	
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<Object> manipularHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return ResponseEntity.badRequest().body(new ExcecaoRestDetalhe("JSON inválido", HttpStatus.BAD_REQUEST.value()));
	}

	@ExceptionHandler(value = NenhumPratoEncontradoException.class)
	public ResponseEntity<Object> manipularEmailAlreadyExistsException(NenhumPratoEncontradoException e) {
		return ResponseEntity.status(e.getHttpStatus()).body(new ExcecaoRestDetalhe(e.getMessage(), e.getCodigo()));
	}

	@ExceptionHandler(value = PedidoVazioException.class)
	public ResponseEntity<Object> manipularPedidoVazioException(PedidoVazioException e) {
		return ResponseEntity.status(e.getHttpStatus()).body(new ExcecaoRestDetalhe(e.getMessage(), e.getCodigo()));
	}
	
	@ExceptionHandler(value = PedidoNaoEncontradoException.class)
	public ResponseEntity<Object> manipularPedidoNaoEncontradoException(PedidoNaoEncontradoException e) {
		return ResponseEntity.status(e.getHttpStatus()).body(new ExcecaoRestDetalhe(e.getMessage(), e.getCodigo()));
	}
	
}
