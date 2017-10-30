package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.Dragon;

/**
* Clase CreadorDragon
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class CreadorDragon extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new Dragon(c,m);
	}
}

