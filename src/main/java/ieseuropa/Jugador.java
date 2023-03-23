package main.java.ieseuropa;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private ArrayList<Carta> baraja;
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.baraja = new ArrayList<>();
	}
	
	public Jugador(String nombre, ArrayList<Carta> baraja) {

		this.nombre = nombre;
		this.baraja = baraja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Carta> getBaraja() {
		return baraja;
	}

	public void setBaraja(ArrayList<Carta> baraja) {
		this.baraja = baraja;
	}

	public void addCarta(Carta carta) {
		baraja.add(carta);
	}
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", baraja=" + baraja + "]";
	}

}
