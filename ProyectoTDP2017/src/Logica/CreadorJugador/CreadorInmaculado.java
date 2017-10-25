package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.Inmaculado;



public class CreadorInmaculado extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new Inmaculado(c,m);
	}
}
