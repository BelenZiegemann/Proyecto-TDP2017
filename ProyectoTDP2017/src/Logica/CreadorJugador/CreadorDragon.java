package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.Dragon;


public class CreadorDragon extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new Dragon(c,m);
	}
}

