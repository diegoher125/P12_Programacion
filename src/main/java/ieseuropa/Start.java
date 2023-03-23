package main.java.ieseuropa;

public class Start {

	public static void main(String[] args) {
		public static void imprimirCartas(ArrayList<Jugador> jugadores, int numJug) {
			for (int j = 0; j < jugadores.get(numJug).getBaraja().size(); j++) {
				System.out.print(jugadores.get(numJug).getBaraja().get(j).getNumero() + " "
						+ jugadores.get(numJug).getBaraja().get(j).getPalo() + "  ");
			}
		}
		
		public static int ganar(ArrayList<Jugador> jugadores) {
			for (int i = 0; i < jugadores.size(); i++) {
				if (jugadores.get(i).getBaraja().size() == 0) {
					return i;
				}
			}
			return -1;
		}

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

		public static void main(String[] args) {
			ArrayList<Columna> cuatroColumna = new ArrayList<>();
			Tablero t = new Tablero();
			if(t.getTablero().isEmpty()) {
				t.crearColumnas();
			}else {
				System.out.println("Tablero con columnas no es posible agregar nuevas");
			}
			System.out.println(t);
			ArrayList<Jugador> jugadores = new ArrayList<>();

			Scanner in = new Scanner(System.in);

			Jugador jugador1 = new Jugador("Sergio", new ArrayList<>());
			jugador1.getBaraja().add(new Carta(Numero.Cuatro, Palo.bastos));
			jugador1.getBaraja().add(new Carta(Numero.Seis, Palo.oros));
			jugador1.getBaraja().add(new Carta(Numero.Cuatro, Palo.oros));
			jugador1.getBaraja().add(new Carta(Numero.Cuatro, Palo.copas));
			Jugador jugador2 = new Jugador("Alonso", new ArrayList<>());
			jugador2.getBaraja().add(new Carta(Numero.Cinco, Palo.copas));
			jugador2.getBaraja().add(new Carta(Numero.Cinco, Palo.oros));
			jugador2.getBaraja().add(new Carta(Numero.Cinco, Palo.bastos));
			jugador2.getBaraja().add(new Carta(Numero.Seis, Palo.bastos));

			
			
			
			
			ArrayList<Carta> Centro = new ArrayList<>();
			jugadores.add(jugador1);
			jugadores.add(jugador2);
			
			t.setJugadores(jugadores);
			System.out.println(t);
			
			t.buscarOros(new Carta(Numero.Siete, Palo.espadas));
			System.out.println(t.buscarOros(new Carta(Numero.Siete, Palo.espadas)));
			
			/*
			for (int i = 0; i < jugadores.size(); i++) {
				for (int j = 0; j < jugadores.get(i).getBaraja().size(); j++) {
					if (jugadores.get(i).getBaraja().get(j).equals(new Carta(Numero.Cinco, Palo.oros))) {
						cuatroColumna.get(cuatroColumna.indexOf(new Columna(null, Palo.oros))).getCartas().add(new Carta(jugadores.get(i).getBaraja().get(j).getNumero(), Palo.oros));
					}
				}
			}*/

			int opcion = 1;
			while ((ganar(jugadores) == -1)) {

				for (int i = 0; i < jugadores.size(); i++) {

					System.out.print("Tu turno " + jugadores.get(i).getNombre() + " \nElige tu carta\n");

					imprimirCartas(jugadores, i);

					opcion = in.nextInt();

					boolean encontrado = false;

					for (int k = 0; k < cuatroColumna.size() && !encontrado; k++) {

						if (jugadores.get(i).getBaraja().get(opcion).equals(new Carta(Numero.Cinco, cuatroColumna.get(k).getPalo()))) {

							cuatroColumna.get(k).getCartas()
									.add(new Carta(jugadores.get(i).getBaraja().get(opcion).getNumero(),
											jugadores.get(i).getBaraja().get(opcion).getPalo()));

							jugadores.get(i).getBaraja().remove(opcion);

							encontrado = true;
						}

						
						/*
						for (int m = 0; m < cuatroColumna.get(k).getCartas().size() && !encontrado; m++) {

							if (((jugadores.get(i).getBaraja().get(opcion)
									.getNumero() == cuatroColumna.get(k).getCartas().get(m).getNumero() - 1
									&& jugadores.get(i).getBaraja().get(opcion).getPalo() == cuatroColumna.get(k)
											.getCartas().get(m).getPalo())
									|| (jugadores.get(i).getBaraja().get(opcion)
											.getNumero() == cuatroColumna.get(k).getCartas().get(m).getNumero() + 1
											&& jugadores.get(i).getBaraja().get(opcion).getPalo() == cuatroColumna.get(k)
													.getCartas().get(m).getPalo()))) {
								cuatroColumna.get(k).getCartas()
										.add(new Carta(jugadores.get(i).getBaraja().get(opcion).getNumero(),
												jugadores.get(i).getBaraja().get(opcion).getPalo()));
								jugadores.get(i).getBaraja().remove(opcion);
								System.out.println("Si se puede hacer la jugada");
								encontrado = true;
							}
						}*/
					}
					System.out.print("\nBaraja del centro \n-------------\n");
					imprimir(cuatroColumna);
				}
			}
			System.out.println("Gano el jugador " + jugadores.get(ganar(jugadores)).getNombre());

		}
	}

}
