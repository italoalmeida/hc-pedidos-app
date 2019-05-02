package com.italoalmeida.hc.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Prato implements Serializable {

	private static final long serialVersionUID = 5015931862546328099L;
	
	@NotBlank
	private String nome;
	
	@NotEmpty
	private List<String> acompanhamentos;
	
	@NotBlank
	private Double preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getAcompanhamentos() {
		return acompanhamentos;
	}

	public void setAcompanhamentos(List<String> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
