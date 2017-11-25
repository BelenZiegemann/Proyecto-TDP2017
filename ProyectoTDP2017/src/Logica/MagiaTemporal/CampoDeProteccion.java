package Logica.MagiaTemporal;

import Logica.PowerUp;
import Logica.VisitorPowerUp.VisitorCampoDeProteccion;

/**
 * Clase CampoDeProteccion
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
		mensajeEstadoPU = "<html><body>Campo de Protecci�n: <br>DESACTIVADO</body></html>";
	}

	public PowerUp clone() 
	{
		return new CampoDeProteccion();
	}
}
