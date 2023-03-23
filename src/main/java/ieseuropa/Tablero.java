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

	public void crearBaraja() {
		for (Palo palo : Palo.values()) {
			for (Numero numero : Numero.values()) {
				mazo.add(new Carta(numero, palo));
			}
		}
	}

	public void barajarMazo() {
		ArrayList<Carta> mazoBarajado = new ArrayList<>();
		while (!mazo.isEmpty()) {
			int aleatorio = (int) (Math.random() * mazo.size());
			mazoBarajado.add(mazo.get(aleatorio));
			mazo.remove(mazo.get(aleatorio));
		}
		mazo = mazoBarajado;
	}

	public void repartirMazo() {
		while (!mazo.isEmpty()) {
			int numJ = 0;
			while (numJ < jugadores.size()) {
				jugadores.get(numJ).addCarta(mazo.get(0));
				mazo.remove(0);
				numJ++;
			}
		}
	}
	
	public ArrayList<Columna> crearColumnas() {
		for(Palo palo: Palo.values()) {
			tablero.add(new Columna(new ArrayList<>(), palo));
		}
		return tablero;
	}
	
	public Carta buscarOros(Carta carta) {
		for(Palo palo : Palo.values()) {
			for(Numero n: Numero.values()) {
				if(carta.equals(new Carta(n, palo))) {
					return new Carta(n, palo);
				}
			}
		}	
		return new Carta(null, null);
	}

	@Override
	public String toString() {
		return "Tablero [tablero=" + tablero + ", mazo=" + mazo + ", jugadores=" + jugadores + "]";
	}
}
