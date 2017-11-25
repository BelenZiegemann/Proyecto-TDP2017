package Logica.VisitorPowerUp;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Jugador;
import Logica.ObjetoPrecioso.Bomba;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase VisitorBomba
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class VisitorBomba extends VisitorPowerUp
{
	protected Bomba bomb;
	
	public VisitorBomba(Bomba b)
	{
		bomb = b;
	}
	
	public void afectar(Jugador j)
	{
		j.setVida(0);
		j.setEstaVivo(false);
		for(Celda cell : j.getMisCeldas())
		{
			bomb.getMapa().obtenerCelda(cell.getPosCelda()).setContenido(null);
			cell.setContenido(null);
		}
	}
	public void afectar(Enemigo e)
	{
		e.setVida(0);
		e.setEstaVivo(false);
		for(Celda cell : e.getMisCeldas())
		{
			bomb.getMapa().obtenerCelda(cell.getPosCelda()).setContenido(null);
			cell.setContenido(null);
		}
	}
	public void afectar(ObstaculoConVida o)
	{
		o.setVida(0);
		o.setEstaVivo(false);
		bomb.getMapa().obtenerCelda(o.getCelda().getPosCelda()).setContenido(null);
		o.getCelda().setContenido(null);
	}
	public void afectar(ObstaculoPorTiempo o)
	{}
}