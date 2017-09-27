package Logica;

import java.awt.Point;

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
	
	protected Point posGrafica;
	protected Icon imagen;
	protected JLabel mGrafico;
	protected final int ancho = 32;
	protected final int alto = 32;
	
	public abstract void seratacado(Proyectil p);
	
	public int getVida()
	{
		return puntosVida;
	}

	public void setVida(int v)
	{
		puntosVida = v;
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
	
	public abstract void mover();

}