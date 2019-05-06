package com.italoalmeida.hc.service;

import java.util.List;

import com.italoalmeida.hc.exception.GravacaoArquivoJsonException;
import com.italoalmeida.hc.exception.PedidoNaoEncontradoException;
import com.italoalmeida.hc.exception.PedidoVazioException;
import com.italoalmeida.hc.model.Prato;

/**
 * @author Italo Almeida
 *
 */
public interface PedidoService {
	
	public String pedir(List<Prato> pedido) throws PedidoVazioException, GravacaoArquivoJsonException;
	
	public List<Prato> consultar(String codigoPedido) throws PedidoNaoEncontradoException;

}
