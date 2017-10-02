package Logica;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase Abstracta Personaje
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Personaje extends Contenido 
{

	protected int fuerzaImpacto = 10;
	protected int alcance = 1;
	protected Posicion ubicacion;	
	protected boolean estaVivo = true;
	protected int desplX;
	protected int desplY;
	protected Icon imagen;
	protected JLabel mGrafico;
	
	public abstract void seratacado(Proyectil p);
	
	public int getVida()
	{
		return puntosVida;
	}

	public int getAlcance()
	{
		return alcance;
	}
	
	public int getFuerzaImpacto()
	{
		return fuerzaImpacto;
	}
	
	public Posicion getPosicion()
	{
		return ubicacion;
	}
	
	public JLabel getGrafico()
	{
		return mGrafico;
	}
	
	public boolean estaVivo()
	{
		return estaVivo;
	}
	
	public void setVida(int v)
	{
		puntosVida = v;
	}
	
	
	public abstract void mover();

}