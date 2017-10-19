package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.JonSnow;


public class CreadorJonSnow extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new JonSnow(c,m);
	}
}
