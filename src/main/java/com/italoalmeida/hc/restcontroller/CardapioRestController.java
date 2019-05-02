package com.italoalmeida.hc.restcontroller;

import static com.italoalmeida.hc.utils.Endpoint.CARDAPIO;
import static com.italoalmeida.hc.utils.Endpoint.RAIZ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoalmeida.hc.exception.repository.LeituraArquivoJsonException;
import com.italoalmeida.hc.exception.restcontroller.NenhumPratoEncontradoException;
import com.italoalmeida.hc.model.Prato;
import com.italoalmeida.hc.service.CardapioService;

@RestController
@RequestMapping(value = RAIZ)
public class CardapioRestController {
	
	@Autowired
	CardapioService cardapioService;
	
	@GetMapping(CARDAPIO)
	private ResponseEntity<Object> cardapio() 
			throws NenhumPratoEncontradoException, LeituraArquivoJsonException {
		
		List<Prato> cardapio = cardapioService.consultar();
		
		// Response
		return ResponseEntity.ok().body(cardapio);
	}

}
