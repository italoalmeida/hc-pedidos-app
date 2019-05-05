package com.italoalmeida.hc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

/**
 * @author Italo Almeida
 *
 */
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private List<Prato> pratos;
	
	public Pedido() {
		super();
		this.pratos = new ArrayList<Prato>();
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}

}
