package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.GuardianNocturno;


public class CreadorGuardianNocturno extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new GuardianNocturno(c,m);
	}
}