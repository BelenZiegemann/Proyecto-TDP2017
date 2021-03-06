package Logica.VisitorPowerUp;

import Logica.Enemigo;
import Logica.Jugador;
import Logica.MagiaTemporal.DuplicarFuerza;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase VisitorDuplicarFuerza
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
		df.setPersonajeMagia(j);
		df.iniTimer();
		df.setMensajeEstadoPU("<html><body>Fuerza Duplicada<br>De JUGADOR: ACTIVADA</body></html>");
	}
	public void afectar(Enemigo e)
	{}
	public void afectar(ObstaculoConVida o)
	{}
	public void afectar(ObstaculoPorTiempo o)
	{}
}