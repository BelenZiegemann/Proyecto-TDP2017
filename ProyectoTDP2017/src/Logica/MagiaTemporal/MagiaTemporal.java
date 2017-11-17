package Logica.MagiaTemporal;

import Logica.Jugador;
import Logica.PowerUp;

/**
 * Clase abstracta MagiaTemporal
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public abstract class MagiaTemporal extends PowerUp 
{
		protected int tiempo;
		protected Jugador jugadorConMagia;
		
		protected MagiaTemporal()
		{
			super();
			jugadorConMagia =  null;
		}
		
		public void setJugadorMagia(Jugador j)
		{
			jugadorConMagia = j;
		}
		
		public abstract void accionFinTimer();
}
