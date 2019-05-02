package com.italoalmeida.hc.restcontroller.exceptionhandler;

import java.io.Serializable;

public class DetalhamentoExcecaoRest implements Serializable {

	private static final long serialVersionUID = 1816029731838900647L;

	private String mensagem;
	
	private int codigo;
	
	public DetalhamentoExcecaoRest(String mensagem, int codigo) {
		super();
		this.mensagem = mensagem;
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
