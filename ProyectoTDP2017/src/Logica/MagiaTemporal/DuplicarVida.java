package Logica.MagiaTemporal;

import Logica.PowerUp;
import Logica.VisitorPowerUp.VisitorDuplicarVida;

/**
 * Clase DuplicarVida
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class DuplicarVida extends MagiaTemporal
{
	public DuplicarVida()
	{
		super();
		visitorPU = new VisitorDuplicarVida(this);
		tiempo = 11;
		timer.setInitialDelay(tiempo * 1000);
	}
	
	public void accionFinTimer()
	{
		jugadorConMagia.setVida(jugadorConMagia.getVida() / 2);
		mensajeEstadoPU = "Vida Duplicada DESACTIVADA";
	}
	
	public PowerUp clone()
	{
		return new DuplicarVida();
	}

}
