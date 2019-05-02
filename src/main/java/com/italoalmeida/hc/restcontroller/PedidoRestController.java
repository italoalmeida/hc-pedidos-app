package com.italoalmeida.hc.restcontroller;

import static com.italoalmeida.hc.utils.Endpoint.PEDIDO;
import static com.italoalmeida.hc.utils.Endpoint.RAIZ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoalmeida.hc.exception.repository.GravacaoArquivoJsonException;
import com.italoalmeida.hc.exception.restcontroller.PedidoVazioException;
import com.italoalmeida.hc.model.Prato;
import com.italoalmeida.hc.service.PedidoService;

@RestController
@RequestMapping(value = RAIZ)
public class PedidoRestController {

	@Autowired
	PedidoService pedidoService;
	
	@PostMapping(PEDIDO)
	private ResponseEntity<Object> pedir(@RequestBody List<Prato> pedido) 
			throws PedidoVazioException, GravacaoArquivoJsonException {
		
		pedidoService.pedir(pedido);
		
		// Response
		return ResponseEntity.ok().build();
	}
	
}
