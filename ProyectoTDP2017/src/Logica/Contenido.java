package Logica;

import javax.swing.Icon;
import javax.swing.JLabel;

import Logica.VisitorPersonaje.Visitor;
import Logica.VisitorPowerUp.VisitorPowerUp;

/**
 * Clase abstracta Contenido 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Contenido
{
	protected Celda miCelda;	
	protected Mapa mapa;
	protected Icon imagen;
	protected JLabel mGrafico;
	protected int desplX;
	protected int desplY;
	
	public abstract void seratacado(Visitor p);
	public abstract void serAfectado(VisitorPowerUp p);

	public Mapa getMapa()
	{
		return mapa;
	}
	
	public JLabel getGrafico()
	{
		return mGrafico;
	}
	
	public Celda getCelda() {
		return miCelda;
	}
	
	public void setCelda(Celda c) {
		miCelda = c;
	}
}
