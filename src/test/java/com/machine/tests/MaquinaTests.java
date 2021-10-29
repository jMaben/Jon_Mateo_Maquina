package com.machine.tests;

import static org.junit.Assert.*;

import org.junit.Before;
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
	Maquina m;

	/**
	 * Este metodo es para predefinir la maquina para realizar las pruebas.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Before
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
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testMostrarEstadoDeLaMaquina() {
		try {
			m.mostrarEstadoActual();
		} catch (Exception e) {
			fail(e.getMessage() + " || Error al mostrar el estado de la maquina.");
		}
	}

	/**
	 * Comprueba el añadir un refresco nuevo a la maquina.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testAddUnRefrescoEnLaMaquina() {
		try {
			m.añadirRefresco(gatorade);
		} catch (Exception e) {
			fail(e.getMessage() + " || Error al añadir un refresco en la maquina.");
		}
	}

	/**
	 * Comprueba el metodo para generar un informe de los productos vendidos de la
	 * maquina.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testGenerarInformeDeLaMaquina() {
		try {
			m.mostrarInformeVendidos();
		} catch (Exception e) {
			fail(e.getMessage() + " || Error al generar un informe de los productos vendidos\r\n"
					+ "	 * de la maquina.");
		}
	}

	/**
	 * Comprueba el metodo para generar un informe de los refrescos disponibles.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test()
	public void testInformeDeRefresco() {
		try {
			m.informeDeRefresco(fanta);
		} catch (Exception e) {
			fail(e.getMessage() + " || Error al generar un informe de los refrescos.");
		}
	}

	/**
	 * Comprueba el metodo de buscar refresco, en este caso si no lo encuentra.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testSiEncuentraUnRefresco() {
		// Se espera un numero mayor que cero, ya que
		// ese numero sera su posicion en el array.
		int resultado = m.buscarPosicionDeRefresco(fanta);

		if (resultado > 0) {
			System.out.println("Se ha encontrado el refresco, su posicion: " + resultado);
		} else {
			fail("Error al buscar los refrescos.");
		}

	}

	/**
	 * Comprueba el metodo de buscar refresco, en este caso si no lo encuentra.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testNoEncuentraUnRefresco() {
		int esperado = -1;
		Refresco pepsi = new Refresco("Pepsi", 1.23);
		int resultado = m.buscarPosicionDeRefresco(pepsi);

		if (esperado == resultado) {
			System.out.println("No se ha encontrado el refresco: " + pepsi.getTipo());
		} else {
			fail("Error al buscar los refrescos.");
		}

	}

	/**
	 * Comprueba la compra de un refresco, cuando tiene que realizarse
	 * correctamente.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testComprarUnRefrescoEnLaMaquinaConExito() {
		int esperado = 1;
		int resultado = m.comprarRefresco(cocaCola, 5.0);

		if (esperado == resultado) {
			System.out.println("Compra realizada con exito, producto seleccionado: " + cocaCola.getTipo());
		} else {
			fail("Error al realizar la compra.");
		}
	}

	/**
	 * Comprueba la compra de un refresco, cuando no tiene suficientes cambios.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testComprarUnRefrescoEnLaMaquinaSinCambiosDisponibles() {
		int esperado = 2;
		int resultado = m.comprarRefresco(cocaCola, 45.0);

		if (esperado == resultado) {
			System.out.println("La maquina no tiene cambios, producto seleccionado: " + cocaCola.getTipo());
		} else {
			fail("Error al realizar la compra.");
		}
	}

	/**
	 * Comprueba la compra de un refresco, cuando no dispone de un refresco.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testComprarUnRefrescoEnLaMaquinaSinRefrescoSeleccionado() {
		int esperado = 3;
		Refresco pepsi = new Refresco("Pepsi", 1.23);
		int resultado = m.comprarRefresco(pepsi, 5.0);

		if (esperado == resultado) {
			System.out.println("La maquina no tiene ese producto, producto seleccionado: " + pepsi.getTipo());
		} else {
			fail("Error al realizar la compra.");
		}
	}

	/**
	 * Comprueba la compra de un refresco, cuando no se tiene el suficiente dinero
	 * para comprarlo.
	 * 
	 * @author Jon Mateo Bengoetxea
	 */
	@Test
	public void testComprarUnRefrescoEnLaMaquinaCon() {
		int esperado = 4;
		int resultado = m.comprarRefresco(cocaCola, 0.5);

		if (esperado == resultado) {
			System.out.println(
					"No hay suficiente dinero para comprar el producto, producto seleccionado: " + cocaCola.getTipo());
		} else {
			fail("Error al realizar la compra.");
		}
	}

}
