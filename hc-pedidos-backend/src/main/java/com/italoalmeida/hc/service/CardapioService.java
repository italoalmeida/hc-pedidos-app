package com.italoalmeida.hc.service;

import java.util.List;

import com.italoalmeida.hc.exception.LeituraArquivoJsonException;
import com.italoalmeida.hc.exception.NenhumPratoEncontradoException;
import com.italoalmeida.hc.model.Prato;

/**
 * @author Italo Almeida
 *
 */
public interface CardapioService {
	
	public List<Prato> consultar() throws NenhumPratoEncontradoException, LeituraArquivoJsonException;

}
