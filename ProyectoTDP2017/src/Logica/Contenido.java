package Logica;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase abstracta Contenido 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Contenido
{
	protected int puntosVida = 100;
	protected Celda miCelda;	
	protected Mapa mapa;
	protected Visitor proyectil;
	protected Icon imagen;
	protected JLabel mGrafico;
	
	public abstract void seratacado(Visitor p);

	
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
