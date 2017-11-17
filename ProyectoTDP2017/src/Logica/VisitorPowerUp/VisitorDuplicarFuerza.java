package Logica.VisitorPowerUp;

import Logica.Enemigo;
import Logica.Jugador;
import Logica.MagiaTemporal.DuplicarFuerza;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase VisitorDuplicarFuerza
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class VisitorDuplicarFuerza extends VisitorPowerUp
{
	protected DuplicarFuerza df;

	public VisitorDuplicarFuerza(DuplicarFuerza df)
	{
		this.df = df;
	}
	
	public void afectar(Jugador j)
	{
		j.setFuerzaImpacto(2 * j.getFuerzaImpacto());
		df.setJugadorMagia(j);
		df.iniTimer();
		df.setMensajeEstadoPU("Fuerza Duplicada ACTIVADA");
	}
	public void afectar(Enemigo e)
	{}
	public void afectar(ObstaculoConVida o)
	{}
	public void afectar(ObstaculoPorTiempo o)
	{}
}