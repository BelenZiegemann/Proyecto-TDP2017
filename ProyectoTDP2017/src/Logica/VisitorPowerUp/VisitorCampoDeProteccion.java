package Logica.VisitorPowerUp;

import Logica.Enemigo;
import Logica.Jugador;
import Logica.MagiaTemporal.CampoDeProteccion;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase VisitorCampoDeProteccion
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
		cp.setJugadorMagia(j);
		cp.iniTimer();
		cp.setMensajeEstadoPU("C. de Protecci�n ACTIVADO");
	}
	public void afectar(Enemigo e)
	{}
	public void afectar(ObstaculoConVida o)
	{}
	public void afectar(ObstaculoPorTiempo o)
	{}	
}