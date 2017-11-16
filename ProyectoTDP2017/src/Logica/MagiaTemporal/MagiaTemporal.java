package Logica.MagiaTemporal;

import Logica.Jugador;
import Logica.PowerUp;
import Logica.VisitorPowerUp.VisitorMagiaTemporal;

/**
 * Clase abstracta MagiaTemporal
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class MagiaTemporal extends PowerUp 
{
		protected int tiempo;
		protected Jugador jugadorConMagia;
		protected String mensajeEstadoMagia;
		
		protected MagiaTemporal()
		{
			super();
			visitorPU = new VisitorMagiaTemporal(this);
			jugadorConMagia =  null;
			mensajeEstadoMagia = "";
		}
		
		public String mensajeEstadoPU()
		{
			return mensajeEstadoMagia;
		}
		
		public abstract void accion(Jugador j);
		
		public abstract void deshacerAccion();
}
