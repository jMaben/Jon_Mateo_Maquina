package com.machine.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.machine.dominio.Maquina;
import com.machine.dominio.Refresco;

public class MaquinaTests {

	// Refrescos
	Refresco cocaCola = new Refresco("Cola-Cola", 1.5);
	Refresco fanta = new Refresco("Fanta", 1.78);
	Refresco aqua = new Refresco("Aquarius", 1.23);
	Refresco kas = new Refresco("Kas", 1.13);
	Refresco gatorade = new Refresco("Gatorade", 2.4);
	Refresco monster = new Refresco("Monster", 2.5);
	Refresco redBull = new Refresco("RedBull", 2.75);

	// La Maquina
	Maquina m = new Maquina();
	
	/**
	 * Este metodo es para predefinir la maquina para realizar las pruebas.
	 * @author Jon Mateo Bengoetxea
	 */
	public void setUp() {
		try {
			// La Maquina
			m = new Maquina();
			m.setDinero(10.50);

			// Añadimos los refrescos
			m.añadirRefresco(cocaCola);
			m.añadirRefresco(cocaCola);
			m.añadirRefresco(fanta);
			m.añadirRefresco(aqua);
			m.añadirRefresco(kas);
			m.añadirRefresco(gatorade);
			m.añadirRefresco(monster);
			m.añadirRefresco(redBull);
			m.añadirRefresco(cocaCola);
			m.añadirRefresco(fanta);
			m.añadirRefresco(fanta);
			m.añadirRefresco(fanta);
		} catch (Exception e) {
			System.err.println(e.getMessage() + " Error en el set up.");
		}

	}

	/**
	 * Comprueba que el estado de la maquina se muestre.
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testMostrarEstadoDeLaMaquina() {
		try {
			setUp();
			m.mostrarEstadoActual();
		} catch (Exception e) {
			fail(e.getMessage()+" || Error al mostrar el estado de la maquina.");
		}
	}
	
	/**
	 * Comprueba la compra de un refresco.
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testComprarUnRefrescoEnLaMaquina() {
		try {
			setUp();
			m.comprarRefresco(cocaCola, 5.0);
		} catch (Exception e) {
			fail(e.getMessage()+" || Error al comprar en la maquina.");
		}
	}
	
	/**
	 * Comprueba el añadir un refresco nuevo a la maquina.
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testAddUnRefrescoEnLaMaquina() {
		try {
			setUp();
			m.añadirRefresco(gatorade);
		} catch (Exception e) {
			fail(e.getMessage()+" || Error al añadir un refresco en la maquina.");
		}
	}
	
	/**
	 * Comprueba el metodo para generar un informe de los productos vendidos
	 * de la maquina.
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testGenerarInformeDeLaMaquina() {
		try {
			setUp();
			m.mostrarInformeVendidos();
		} catch (Exception e) {
			fail(e.getMessage()+" || Error al generar un informe de los productos vendidos\r\n"
					+ "	 * de la maquina.");
		}
	}
	
	
	/**
	 * Comprueba el metodo para generar un informe de los refrescos disponibles.
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testInformeDeRefresco() {
		try {
			setUp();
			m.informeDeRefresco(fanta);
		} catch (Exception e) {
			fail(e.getMessage()+" || Error al generar un informe de los refrescos.");
		}
	}
	
}
