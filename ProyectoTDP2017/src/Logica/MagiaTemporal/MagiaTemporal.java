package Logica.MagiaTemporal;

import Logica.Personaje;
import Logica.PowerUp;

/**
 * Clase abstracta MagiaTemporal
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public abstract class MagiaTemporal extends PowerUp 
{
		protected int tiempo;
		protected Personaje personajeConMagia;
		
		protected MagiaTemporal()
		{
			super();
			personajeConMagia =  null;
		}
		
		public void setPersonajeMagia(Personaje p)
		{
			personajeConMagia = p;
		}
		
		public abstract void accionFinTimer();
}
