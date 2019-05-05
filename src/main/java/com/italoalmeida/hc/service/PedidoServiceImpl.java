package com.italoalmeida.hc.service;

import static com.italoalmeida.hc.utils.Diretorio.DIRETORIO_ARQUIVOS_PEDIDOS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoalmeida.hc.exception.GravacaoArquivoJsonException;
import com.italoalmeida.hc.exception.PedidoNaoEncontradoException;
import com.italoalmeida.hc.exception.PedidoVazioException;
import com.italoalmeida.hc.model.Pedido;
import com.italoalmeida.hc.model.Prato;
import com.italoalmeida.hc.repository.PedidoRepository;

/**
 * @author Italo Almeida
 *
 */
@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Override
	public String pedir(List<Prato> pedido) 
			throws PedidoVazioException, GravacaoArquivoJsonException {

		if (pedido == null || pedido.isEmpty()) throw new PedidoVazioException();
		
		return pedidoRepository.gravar(pedido, DIRETORIO_ARQUIVOS_PEDIDOS, Pedido.class.getSimpleName());
	}
	
	@Override
	public List<Prato> consultar(String codigoPedido) 
			throws PedidoNaoEncontradoException {
		try {
			
			return pedidoRepository.ler(DIRETORIO_ARQUIVOS_PEDIDOS, Pedido.class.getSimpleName() + codigoPedido);
			
		} catch (Exception e) {
			throw new PedidoNaoEncontradoException();
		} 
	}

}
