package com.machine.dominio;

public class Refresco {
	// Atributos
	private String tipo="";
	private Double precio=0.0;
	
	// Contructores
	public Refresco(String tipo, Double precio) {
		super();
		this.tipo = tipo;
		this.precio = precio;
	}
	
	public Refresco() {
	}
	
	//Getters y Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	// Metodos
	/**
	 * Metodo sobreescrito para visualizar los refrescos.
	 * @author Jon Mateo Bengoetxea
	 */
	@Override
	public String toString() {
		return tipo + " - " + precio + "\u20AC";
	}
}
