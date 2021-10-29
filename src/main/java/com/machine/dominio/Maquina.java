package com.machine.dominio;

import java.util.*;

public class Maquina {
	// Atributos
	private Double dinero = 0.0;
	private Boolean stock = false;
	private ArrayList<Refresco> refrescos = new ArrayList<Refresco>();
	private ArrayList<Refresco> informe = new ArrayList<Refresco>();

	// Contructores
	public Maquina(Double dinero, Boolean stock, ArrayList<Refresco> refrescos, ArrayList<Refresco> informe) {
		super();
		this.dinero = dinero;
		this.stock = stock;
		this.refrescos = refrescos;
		this.informe = informe;
	}

	public Maquina() {
	}

	// Setters y Getters
	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	public Boolean getStock() {
		return stock;
	}

	public void setStock(Boolean stock) {
		this.stock = stock;
	}

	public ArrayList<Refresco> getRefrescos() {
		return refrescos;
	}

	public void setRefrescos(ArrayList<Refresco> refrescos) {
		this.refrescos = refrescos;
	}

	public ArrayList<Refresco> getInforme() {
		return informe;
	}

	public void setInforme(ArrayList<Refresco> informe) {
		this.informe = informe;
	}

	// Metodos

	/**
	 * Añade un refresco a la maquina.
	 * 
	 * @author Jon Mateo Bengoetxea
	 * @param Recibe un objeto refresco para añadirlo a la maquina.
	 */
	public void añadirRefresco(Refresco refresco) {
		if (this.stock == false) {
			this.stock = true;
		}
		this.refrescos.add(refresco);
	}

	/**
	 * Este metodo a partir de un refresco en especifico da la cantidad de ellos
	 * disponible.
	 * 
	 * @param refresco
	 * @return Devuelve un int con la cantidad de refrescos especificos que se estan
	 *         buscando.
	 * @author Jon Mateo Bengoetxea
	 */
	public int buscarCuantasPorTipo(Refresco refresco) {
		int contador = 0;

		for (int i = 0; i < this.refrescos.size(); i++) {
			String nombre = refresco.getTipo();
			if (nombre.equalsIgnoreCase(this.refrescos.get(i).getTipo())) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Visualiza un informe completo de todos los productos comprados. (Productos y
	 * cantidad de dinero ganado)
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	public void mostrarInformeVendidos() {
		System.out.println("--------- INFORME DE VENDIDOS ---------");
		System.out.println("Dinero total obtenido: " + dineroAcomuladoDeVentas() + "\u20AC");
		for (int i = 0; i < this.informe.size(); i++) {
			System.out.println(".* " + this.informe.get(i));
		}
		System.out.println("---------*---------");
	}

	/**
	 * Este metodo realiza la accion de comprar un refresco. Verifica el dinero
	 * introducido es correcto para el precio del producto y si se encuentra
	 * disponible realiza la compra. Remueve de la maquina la bebida comprada y la
	 * anota para posteriormente sacar un informe de todas las compras realizadas.
	 * 
	 * @param Recibe un objeto refresco
	 * @param Recibe el dinero que ha depositado el cliente en la maquina
	 * @author Jon Mateo Bengoetxea
	 */
	public int comprarRefresco(Refresco refresco, Double dinero) {
		int resultadoCompra = 0;
		Double precio = refresco.getPrecio();
		if (dinero >= precio) {
			if (buscarRefresco(refresco) == true) {
				if (this.dinero - dinero >= 0) {
					this.dinero = this.dinero + precio;
					this.refrescos.remove(buscarPosicionDeRefresco(refresco));
					if (this.refrescos.size() <= 0) {
						this.stock = false;
					}
					this.informe.add(refresco);
					resultadoCompra = 1;
				} else {
					resultadoCompra = 2;
				}
			} else {
				resultadoCompra = 3;
			}
		} else {
			resultadoCompra = 4;
		}
		return resultadoCompra;
	}

	/**
	 * Muestra el estado actual de la maquina al completo. (Dinero y Stock
	 * disponible)
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	public void mostrarEstadoActual() {
		System.out.println("--------- ESTADO ACTUAL ---------");
		System.out.println("Dinero actual: " + this.dinero + " || Stock: " + this.stock + " | " + getRefrescos().size()
				+ " refrescos.");
		for (int i = 0; i < this.refrescos.size(); i++) {
			System.out.println(".* " + this.refrescos.get(i));
		}
		System.out.println("---------*---------");
	}

	/**
	 * Busca en el array de los refrescos si se encuentra un refresco en especifico.
	 * 
	 * @author Jon Mateo Bengoetxea
	 * @param Se le entrega un objeto Refresco.
	 * @return Devuelve un booleano, false para indicar que no esta y true para
	 *         indicar que si esta.
	 */
	public boolean buscarRefresco(Refresco refresco) {
		Boolean ok = false;
		for (int i = 0; i < this.refrescos.size(); i++) {
			if (refresco == this.refrescos.get(i)) {
				ok = true;
			}
		}

		return ok;

	}

	/**
	 * Busca en el array de refrescos la posicion de un refresco concreto a buscar.
	 * 
	 * @author Jon Mateo Bengoetxea
	 * @param Se le entrega un objeto Refresco.
	 * @return Devuelve la posicion (int) en la que se encuentra el refresco en el
	 *         array, si el valor es negativo no se encuentra y si es positivo te da
	 *         su posicion.
	 */
	public int buscarPosicionDeRefresco(Refresco refresco) {
		int posi = -1;
		for (int i = 0; i < this.refrescos.size(); i++) {
			if (refresco == this.refrescos.get(i)) {
				posi = i;
			}
		}
		return posi;
	}

	/**
	 * Este metodo recorre los refrescos de la maquina y calcula el precio de los
	 * mismos para de esta manera saber cuanto dinero de ganancias se ha acomulado
	 * en la maquina.
	 * 
	 * @author Jon Mateo Bengoetxea
	 * @return Devuelve un double con la cantidad total (en dinero) de refrescos
	 *         vendidos.
	 */
	public Double dineroAcomuladoDeVentas() {
		Double dinero = 0.0;
		for (int i = 0; i < this.informe.size(); i++) {
			dinero += this.informe.get(i).getPrecio();
		}
		return Math.round(dinero * 100.0) / 100.0;
	}

	/**
	 * Este metodo muestra el stock y la disponibilidad de un refresco en especifico
	 * en la maquina.
	 * 
	 * @author Jon Mateo Bengoetxea
	 * @param Recibe un objeto refresco para realizar la busqueda.
	 */
	public void informeDeRefresco(Refresco refresco) {
		if (buscarRefresco(refresco) == true) {
			System.out.println("Refresco a buscar: " + refresco.getTipo());
			System.out.println("Stock del producto: " + buscarCuantasPorTipo(refresco) + " unidades.");
		}

	}

	/**
	 * Muestra la informacion de la compra en pantalla.
	 * 
	 * @param Recibe un objeto refresco
	 * @param Recibe el dinero que ha depositado el cliente en la maquina
	 * @author Jon Mateo Bengoetxea
	 */
	public void mostrarInformacionDeCompra(Refresco refresco, Double dinero) {
		int respuesta = comprarRefresco(refresco, dinero);
		Double precio = refresco.getPrecio();
		Double monedero = dinero - precio;
		String texto = "";

		// instrucción switch con tipo de datos int
		switch (respuesta) {
		case 1:
			texto = "Compra realizada, vueltas: " + monedero;
			break;
		case 2:
			texto = "No quedan vueltas en la maquina.";
			break;
		case 3:
			texto = "No queda este refresco en la maquina.";
			break;
		case 4:
			texto = "No tienes suficiente dinero!";
			break;
		default:
			texto = "Fallo en la compra!";
			break;
		}
		System.err.println(texto);
	}

}
