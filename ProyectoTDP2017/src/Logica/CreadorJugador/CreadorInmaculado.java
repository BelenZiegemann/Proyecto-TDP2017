package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.Inmaculado;

/**
* Clase CreadorInmaculado
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class CreadorInmaculado extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new Inmaculado(c,m);
	}
}
