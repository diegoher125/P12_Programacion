package main.java.ieseuropa;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private ArrayList<Carta> cartas;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cartas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public void anadirCarta(Carta carta) {
		cartas.add(carta);
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", cartas=" + cartas + "]";
	}

}
