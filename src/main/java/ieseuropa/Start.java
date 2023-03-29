package main.java.ieseuropa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Start {

	public static void imprimir(ArrayList<Columna> cuatroCol) {

		for (int i = 0; i < cuatroCol.size(); i++) {

			for (int j = 0; j < cuatroCol.get(i).getCartas().size(); j++) {

				Collections.sort(cuatroCol.get(i).getCartas());

				System.out.println(cuatroCol.get(i).getCartas().get(j).getNumero() + " "
						+ cuatroCol.get(i).getCartas().get(j).getPalo());

			}

			System.out.println();

		}

	}

	public static void imprimirCartas(ArrayList<Jugador> jugadores, int numJug) {

		for (int j = 0; j < jugadores.get(numJug).getCartas().size(); j++) {

			System.out.print(jugadores.get(numJug).getCartas().get(j).getNumero() + " "
					+ jugadores.get(numJug).getCartas().get(j).getPalo() + "  ");

		}

	}

	public static boolean ganar(ArrayList<Jugador> jugadores, int numJugador) {

		if (jugadores.get(numJugador).getCartas().size() == 0) {

			return true;

		}

		return false;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		Tablero tablero = new Tablero();

		if (tablero.getTablero().isEmpty()) {
			tablero.crearColumnas();
		} else {
			System.out.println("Tablero con columnas no es posible agregar nuevas");
		}

		ArrayList<Jugador> jugadores = new ArrayList<>();
		jugadores.add(new Jugador("j1"));
		jugadores.add(new Jugador("j2"));
		jugadores.add(new Jugador("j3"));
		jugadores.add(new Jugador("j4"));
		tablero.setJugadores(jugadores);
		tablero.crearBaraja();
		tablero.barajarMazo();
		tablero.repartirMazo();

		for (int i = 0; i < jugadores.size(); i++) {

			for (int j = 0; j < jugadores.get(i).getCartas().size(); j++) {

				if (tablero.getJugadores().get(i).getCartas().get(j).equals(new Carta(Numero.Cinco, Palo.Oros))) {

					tablero.getTablero().get(tablero.getTablero().indexOf(new Columna(null, Palo.Oros))).getCartas()
							.add(new Carta(tablero.getJugadores().get(i).getCartas().get(j).getNumero(), Palo.Oros));

				}

			}

		}

		int opcion = 1;

		int ganador = 0;
		
		boolean terminado = false;

		while (!terminado) {

			for (int i = 0; i < tablero.getJugadores().size() && !terminado;) {

				System.out.print("Tu turno " + tablero.getJugadores().get(i).getNombre() + " \nElige tu carta\n");

				imprimirCartas(tablero.getJugadores(), i);

				opcion = in.nextInt();

				int a = tablero.getJugadores().get(i).getCartas().size();

				if (opcion < 0 || opcion >= tablero.getJugadores().get(i).getCartas().size()) {

					System.out.println("No valido!!!!");

				}

				else {

					tablero.moverCarta(i, opcion);

					System.out.println("\nBaraja del centro \n-------------\n");

					imprimir(tablero.getTablero());
					
					terminado = ganar(tablero.getJugadores(), i);
					
					ganador = i;
					
					i++;

				}

			}

		}

		System.out.print("El ganador es " + tablero.getJugadores().get(ganador).getNombre());
		
	}
}