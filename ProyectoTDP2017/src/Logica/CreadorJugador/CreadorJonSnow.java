package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.JonSnow;

/**
* Clase CreadorJonSnow
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class CreadorJonSnow extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new JonSnow(c,m);
	}
}
