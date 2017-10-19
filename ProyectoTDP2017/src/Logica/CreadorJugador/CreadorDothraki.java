package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.Dothraki;


public class CreadorDothraki extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new Dothraki(c,m);
	}
}
