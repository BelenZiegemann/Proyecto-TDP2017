package Logica.VisitorPowerUp;

import Logica.Enemigo;
import Logica.Jugador;
import Logica.MagiaTemporal.DuplicarVida;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase VisitorDuplciarVida
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class VisitorDuplicarVida extends VisitorPowerUp
{
	protected DuplicarVida dv;

	public VisitorDuplicarVida(DuplicarVida dv)
	{
		this.dv = dv;
	}
	
	public void afectar(Jugador j)
	{
		j.setVida(2 * j.getVida());
		dv.setJugadorMagia(j);	
		dv.iniTimer();
		dv.setMensajeEstadoPU("Vida Duplicada ACTIVADA");	
	}
	public void afectar(Enemigo e)
	{}
	public void afectar(ObstaculoConVida o)
	{}
	public void afectar(ObstaculoPorTiempo o)
	{}
}