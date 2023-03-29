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
	
	public void moverCarta(int numJugador , int opcionCarta) {
		
		boolean encontrado = false;

		for (int k = 0; k <tablero.size() && !encontrado; k++) {

			if (jugadores.get(numJugador).getCartas().get(opcionCarta)
					.equals(new Carta(Numero.Cinco, tablero.get(k).getPalo()))) {

				tablero.get(k).getCartas()
						.add(new Carta(jugadores.get(numJugador).getCartas().get(opcionCarta).getNumero(),
								jugadores.get(numJugador).getCartas().get(opcionCarta).getPalo()));

				jugadores.get(numJugador).getCartas().remove(opcionCarta);

				encontrado = true;
			}

			for (int m = 0; m < tablero.get(k).getCartas().size() && !encontrado; m++) {

				if (((jugadores.get(numJugador).getCartas().get(opcionCarta).getNumero()
						.ordinal() == tablero.get(k).getCartas().get(m).getNumero().ordinal() - 1
						&& jugadores.get(numJugador).getCartas().get(opcionCarta).getPalo() == tablero
								.get(k).getCartas().get(m).getPalo())
						|| jugadores.get(numJugador).getCartas().get(opcionCarta).getNumero()
								.ordinal() == tablero.get(k).getCartas().get(m).getNumero().ordinal() + 1
								&& jugadores.get(numJugador).getCartas().get(opcionCarta)
										.getPalo() == tablero.get(k).getCartas().get(m).getPalo())) {

					tablero.get(k).getCartas()
							.add(new Carta(jugadores.get(numJugador).getCartas().get(opcionCarta).getNumero(),
									jugadores.get(numJugador).getCartas().get(opcionCarta).getPalo()));

					jugadores.get(numJugador).getCartas().remove(opcionCarta);

					System.out.println("Si se puede hacer la jugada");

					encontrado = true;

				}

			}

		}
		
		
		
		
		
	}
	

	@Override
	public String toString() {
		return "Tablero [tablero=" + tablero + ", mazo=" + mazo + ", jugadores=" + jugadores + "]";
	}

}
