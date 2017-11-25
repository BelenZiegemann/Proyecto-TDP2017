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
		personajeConMagia.setCampoProteccion(false);
		mensajeEstadoPU = "<html><body>Campo de Protección: <br>DESACTIVADO</body></html>";
	}

	public PowerUp clone() 
	{
		return new CampoDeProteccion();
	}
}
