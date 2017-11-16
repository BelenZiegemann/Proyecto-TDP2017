package Logica.MagiaTemporal;

import Logica.Jugador;
import Logica.PowerUp;

/**
 * Clase DuplicarFuerza
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class DuplicarFuerza extends MagiaTemporal
{

	public DuplicarFuerza()
	{
		super();
		tiempo = 9;
		timer.setInitialDelay(tiempo * 1000);
	}
	
	public void accion(Jugador j)
	{
		j.setFuerzaImpacto(2 * j.getFuerzaImpacto());
		jugadorConMagia = j;
		iniTimer();
		mensajeEstadoMagia = "Fuerza Duplicada ACTIVADA";
	}
	
	public void deshacerAccion()
	{
		jugadorConMagia.setFuerzaImpacto(jugadorConMagia.getFuerzaImpacto() / 2);
		mensajeEstadoMagia = "Fuerza Duplicada DESACTIVADA";
	}
	
	public PowerUp clone()
	{
		return new DuplicarFuerza();
	}
	
}
