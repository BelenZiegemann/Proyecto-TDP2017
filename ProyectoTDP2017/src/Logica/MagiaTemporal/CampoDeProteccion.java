package Logica.MagiaTemporal;

import Logica.PowerUp;
import Logica.VisitorPowerUp.VisitorCampoDeProteccion;

/**
 * Clase CampoDeProteccion
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class CampoDeProteccion extends MagiaTemporal
{
	public CampoDeProteccion()
	{
		super();
		visitorPU = new VisitorCampoDeProteccion(this);
		tiempo = 8;
		timer.setInitialDelay(tiempo * 1000);
	}
	 
	public void accionFinTimer() 
	{
		jugadorConMagia.setCampoProteccion(false);
		mensajeEstadoPU = "C. de Protección DESACTIVADO";
	}

	public PowerUp clone() 
	{
		return new CampoDeProteccion();
	}
}
