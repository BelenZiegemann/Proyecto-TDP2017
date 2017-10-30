package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.Dothraki;

/**
* Clase CreadorDothraki
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class CreadorDothraki extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new Dothraki(c,m);
	}
}
