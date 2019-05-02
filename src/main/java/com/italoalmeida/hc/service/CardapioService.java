package com.italoalmeida.hc.service;

import java.util.List;

import com.italoalmeida.hc.exception.repository.LeituraArquivoJsonException;
import com.italoalmeida.hc.exception.restcontroller.NenhumPratoEncontradoException;
import com.italoalmeida.hc.model.Prato;

public interface CardapioService {
	
	public List<Prato> consultar() throws NenhumPratoEncontradoException, LeituraArquivoJsonException;

}
