package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.Dothraki;

/**
* Clase CreadorDothraki
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class CreadorDothraki extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new Dothraki(c,m);
	}
}
