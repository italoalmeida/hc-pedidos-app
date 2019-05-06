package com.italoalmeida.hc.service;

import static com.italoalmeida.hc.utils.Constantes.NOME_ARQUIVO_CARDAPIO;
import static com.italoalmeida.hc.utils.Diretorio.DIRETORIO_ARQUIVOS_CARDAPIO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoalmeida.hc.exception.LeituraArquivoJsonException;
import com.italoalmeida.hc.exception.NenhumPratoEncontradoException;
import com.italoalmeida.hc.model.Prato;
import com.italoalmeida.hc.repository.PratoRepository;

/**
 * @author Italo Almeida
 *
 */
@Service
public class CardapioServiceImpl implements CardapioService {

	@Autowired
	PratoRepository pratoRepository;
	
	@Override
	public List<Prato> consultar() 
			throws NenhumPratoEncontradoException, LeituraArquivoJsonException {
		try {
			
			List<Prato> cardapio = pratoRepository.ler(DIRETORIO_ARQUIVOS_CARDAPIO, NOME_ARQUIVO_CARDAPIO);
			
			if (cardapio == null || cardapio.isEmpty()) throw new NenhumPratoEncontradoException();
			
			return cardapio;
			
		} catch (Exception e) {
			throw new NenhumPratoEncontradoException();
		}		
	}

}
