package Logica.MagiaTemporal;

import Logica.PowerUp;
import Logica.VisitorPowerUp.VisitorDuplicarFuerza;

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
		visitorPU = new VisitorDuplicarFuerza(this);
		tiempo = 9;
		timer.setInitialDelay(tiempo * 1000);
	}
	
	public void accionFinTimer()
	{
		jugadorConMagia.setFuerzaImpacto(jugadorConMagia.getFuerzaImpacto() / 2);
		mensajeEstadoPU = "Fuerza Duplicada DESACTIVADA";
	}
	
	public PowerUp clone()
	{
		return new DuplicarFuerza();
	}
	
}
