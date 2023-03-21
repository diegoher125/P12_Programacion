package main.java.ieseuropa;

import java.util.ArrayList;

public class Tablero {
	
	private ArrayList<Columna> tablero;
	private ArrayList<Carta> mazo;
	private ArrayList<Jugador> jugadores;
	
	public Tablero() {
		tablero = new ArrayList<>();
		mazo = new ArrayList<>();
		jugadores = new ArrayList<>();
	}

	public ArrayList<Columna> getTablero() {
		return tablero;
	}

	public void setTablero(ArrayList<Columna> tablero) {
		this.tablero = tablero;
	}

	public ArrayList<Carta> getMazo() {
		return mazo;
	}

	public void setMazo(ArrayList<Carta> mazo) {
		this.mazo = mazo;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void barajarMazo() {
		ArrayList<Carta> mazoBarajado = new ArrayList<>();
		while(!mazo.isEmpty()) {
			int aleatorio = (int) (Math.random()*mazo.size());
			mazoBarajado.add(mazo.get(aleatorio));
			mazo.remove(mazo.get(aleatorio));
		}
		mazo = mazoBarajado;
	}
	
	@Override
	public String toString() {
		return "Tablero [tablero=" + tablero + ", mazo=" + mazo + ", jugadores=" + jugadores + "]";
	}

}
