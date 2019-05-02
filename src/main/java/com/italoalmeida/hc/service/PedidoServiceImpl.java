package com.italoalmeida.hc.service;

import static com.italoalmeida.hc.utils.Diretorio.DIRETORIO_ARQUIVOS_PEDIDOS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoalmeida.hc.exception.repository.GravacaoArquivoJsonException;
import com.italoalmeida.hc.exception.restcontroller.PedidoVazioException;
import com.italoalmeida.hc.model.Prato;
import com.italoalmeida.hc.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Override
	public void pedir(List<Prato> pedido) 
			throws PedidoVazioException, GravacaoArquivoJsonException {

		if (pedido == null || pedido.isEmpty()) throw new PedidoVazioException();
		
		pedidoRepository.gravar(pedido, DIRETORIO_ARQUIVOS_PEDIDOS, "pedido");
	}

}
