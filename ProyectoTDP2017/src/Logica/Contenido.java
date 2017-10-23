package Logica;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase Abstracta Contenido 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Contenido
{
	protected int puntosVida = 100;
	protected Celda miCelda;	
	protected Visitor proyectil;
	protected Icon imagen;
	protected JLabel mGrafico;
	
	public abstract void seratacado(Visitor p);

	
	public Visitor getProyectil()
	{
		return proyectil;
	}
	
	public Celda getCelda() {
		return miCelda;
	}
	
	public void setCelda(Celda c) {
		miCelda = c;
	}
}
