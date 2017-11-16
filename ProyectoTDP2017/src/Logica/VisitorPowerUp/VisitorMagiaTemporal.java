package Logica.VisitorPowerUp;

import Logica.Enemigo;
import Logica.Jugador;
import Logica.Obstaculo;
import Logica.MagiaTemporal.MagiaTemporal;

/**
 * Clase VisitorMagiaTemporal
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class VisitorMagiaTemporal extends VisitorPowerUp
{
	protected MagiaTemporal mg;

	public VisitorMagiaTemporal(MagiaTemporal mg)
	{
		this.mg = mg;
	}
	
	public void afectar(Jugador j)
	{
		mg.accion(j);
	}
	public void afectar(Enemigo e)
	{
		
	}
	public void afectar(Obstaculo o)
	{
		
	}
	
}
