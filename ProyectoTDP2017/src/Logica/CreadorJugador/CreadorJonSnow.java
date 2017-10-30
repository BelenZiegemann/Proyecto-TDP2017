package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.JonSnow;

/**
* Clase CreadorJonSnow
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class CreadorJonSnow extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new JonSnow(c,m);
	}
}
