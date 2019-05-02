package com.italoalmeida.hc.service;

import java.util.List;

import com.italoalmeida.hc.exception.repository.GravacaoArquivoJsonException;
import com.italoalmeida.hc.exception.restcontroller.PedidoVazioException;
import com.italoalmeida.hc.model.Prato;

public interface PedidoService {
	
	public void pedir(List<Prato> pedido) throws PedidoVazioException, GravacaoArquivoJsonException;

}
