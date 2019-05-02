package com.italoalmeida.hc.service;

import static com.italoalmeida.hc.utils.Diretorio.DIRETORIO_ARQUIVOS_CARDAPIO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoalmeida.hc.exception.repository.LeituraArquivoJsonException;
import com.italoalmeida.hc.exception.restcontroller.NenhumPratoEncontradoException;
import com.italoalmeida.hc.model.Prato;
import com.italoalmeida.hc.repository.PratoRepository;

@Service
public class CardapioServiceImpl implements CardapioService {

	@Autowired
	PratoRepository pratoRepository;
	
	@Override
	public List<Prato> consultar() 
			throws NenhumPratoEncontradoException, LeituraArquivoJsonException {
		
		List<Prato> cardapio = pratoRepository.ler(DIRETORIO_ARQUIVOS_CARDAPIO, "pratos");
		
		if (cardapio == null || cardapio.isEmpty()) throw new NenhumPratoEncontradoException(); 
		
		return cardapio;
	}

}
