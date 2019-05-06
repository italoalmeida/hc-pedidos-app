package com.italoalmeida.hc.restcontroller;

import static com.italoalmeida.hc.utils.Endpoint.PEDIDO;
import static com.italoalmeida.hc.utils.Endpoint.RAIZ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoalmeida.hc.exception.PedidoNaoEncontradoException;
import com.italoalmeida.hc.exception.PedidoVazioException;
import com.italoalmeida.hc.model.Prato;
import com.italoalmeida.hc.service.PedidoService;

/**
 * @author Italo Almeida
 *
 */
@RestController
@RequestMapping(value = RAIZ)
@CrossOrigin
public class PedidoRestController {

	@Autowired
	PedidoService pedidoService;
	
	@PostMapping(PEDIDO)
	private ResponseEntity<Object> pedir(@RequestBody List<Prato> pedido) 
			throws PedidoVazioException, Exception {
		
		String codigoPedido = pedidoService.pedir(pedido);
		
		// Response
		return ResponseEntity.ok().body(codigoPedido);
	}
	
	@GetMapping(PEDIDO + "/{codigoPedido}")
	private ResponseEntity<Object> consultar(@PathVariable("codigoPedido") String codigoPedido) 
			throws PedidoNaoEncontradoException, Exception {

		List<Prato> pedido = pedidoService.consultar(codigoPedido);
		
		// Response
		return ResponseEntity.ok().body(pedido);
	}
	
}
