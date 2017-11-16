package Logica.VisitorPowerUp;

import Logica.Enemigo;
import Logica.Jugador;
import Logica.Obstaculo;

/**
 * Clase abstracta VisitorPowerUp
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public abstract class VisitorPowerUp 
{
	public abstract void afectar(Jugador j);
	public abstract void afectar(Enemigo e);
	public abstract void afectar(Obstaculo o);
}
