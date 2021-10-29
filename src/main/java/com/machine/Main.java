package com.machine;

import com.machine.dominio.Maquina;
import com.machine.dominio.Refresco;

public class Main {

	public static void main(String[] args) {
	//Refrescos
	Refresco cocaCola = new Refresco("Cola-Cola", 1.5);
	Refresco fanta = new Refresco("Fanta", 1.78);
	Refresco aqua = new Refresco("Aquarius", 1.23);
	Refresco kas = new Refresco("Kas", 1.13);
	Refresco gatorade = new Refresco("Gatorade", 2.4);
	Refresco monster = new Refresco("Monster", 2.5);
	Refresco redBull = new Refresco("RedBull", 2.75);
	
	//La Maquina
	Maquina m = new Maquina();
	m.setDinero(10.50);
	
	//Añadimos los refrescos
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
	
	m.mostrarEstadoActual();
	
	//Metodos con la maquina
	m.mostrarInformacionDeCompra(cocaCola, 5.0);
	m.mostrarEstadoActual();
	
	m.mostrarInformeVendidos();
	m.informeDeRefresco(cocaCola);
	m.informeDeRefresco(fanta);

	}
}
