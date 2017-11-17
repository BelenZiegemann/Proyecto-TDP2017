package Logica.VisitorPowerUp;

import Logica.Enemigo;
import Logica.Jugador;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase abstracta VisitorPowerUp
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public abstract class VisitorPowerUp 
{
	public abstract void afectar(Jugador j);
	public abstract void afectar(Enemigo e);
	public abstract void afectar(ObstaculoConVida o);
	public abstract void afectar(ObstaculoPorTiempo o);
}
