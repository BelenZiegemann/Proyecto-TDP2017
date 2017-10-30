package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.GuardianNocturno;

/**
* Clase CreadorGuardianNocturno
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class CreadorGuardianNocturno extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new GuardianNocturno(c,m);
	}
}