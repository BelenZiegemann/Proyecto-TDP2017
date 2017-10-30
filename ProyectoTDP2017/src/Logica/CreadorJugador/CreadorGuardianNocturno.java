package Logica.CreadorJugador;
import Logica.*;
import Logica.Jugadores.GuardianNocturno;

/**
* Clase CreadorGuardianNocturno
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class CreadorGuardianNocturno extends CreadorJugador {
	public Jugador crearJugador(Celda c, Mapa m) {
		return new GuardianNocturno(c,m);
	}
}