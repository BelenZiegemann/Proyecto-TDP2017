package Logica.VisitorPowerUp;

import Logica.Enemigo;
import Logica.Jugador;
import Logica.MagiaTemporal.CampoDeProteccion;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase VisitorCampoDeProteccion
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class VisitorCampoDeProteccion extends VisitorPowerUp
{
	protected CampoDeProteccion cp;
	
	public VisitorCampoDeProteccion(CampoDeProteccion cp)
	{
		this.cp = cp;
	}
	
	public void afectar(Jugador j)
	{
		j.setCampoProteccion(true);
		cp.setPersonajeMagia(j);
		cp.iniTimer();
		cp.setMensajeEstadoPU("<html><body>Campo De Protección<br>De JUGADOR: ACTIVADO</body></html>");
		
	}
	public void afectar(Enemigo e)
	{
		e.setCampoProteccion(true);
		cp.setPersonajeMagia(e);
		cp.iniTimer();
		cp.setMensajeEstadoPU("<html><body>Campo De Protección<br>De ENEMIGO: ACTIVADO</body></html>");
	}
	public void afectar(ObstaculoConVida o)
	{}
	public void afectar(ObstaculoPorTiempo o)
	{}	
}