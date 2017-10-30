package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.Inmaculado;

/**
* Clase CreadorInmaculado
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class CreadorInmaculado extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new Inmaculado(c,m);
	}
}
