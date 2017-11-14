package Logica;

import javax.swing.Icon;
import javax.swing.JLabel;

import Logica.Visitor.Visitor;

/**
 * Clase abstracta Contenido 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Contenido
{
	protected Celda miCelda;	
	protected Mapa mapa;
	protected Visitor proyectil;
	protected Icon imagen;
	protected JLabel mGrafico;
	
	public abstract void seratacado(Visitor p);

	public Mapa getMapa()
	{
		return mapa;
	}
	
	public Visitor getProyectil()
	{
		return proyectil;
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
