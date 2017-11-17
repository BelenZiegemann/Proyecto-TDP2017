package Logica.MagiaTemporal;

import Logica.Jugador;
import Logica.PowerUp;

/**
 * Clase abstracta MagiaTemporal
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
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
