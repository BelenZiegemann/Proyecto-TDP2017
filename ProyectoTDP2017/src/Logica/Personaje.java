package Logica;

import Logica.Visitor.Visitor;

/**
 * Clase Abstracta Personaje
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public abstract class Personaje extends Contenido 
{
	protected int puntosVida = 100;
	protected int fuerzaImpacto = 10;
	protected int alcance = 1;
	protected boolean estaVivo = true;
	protected int desplX;
	protected int desplY;
	
	public abstract void seratacado(Visitor p);
	
	public abstract void mover();
	
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
	
	public boolean estaVivo()
	{
		return estaVivo;
	}
	
	public void setVida(int v)
	{
		puntosVida = v;
	}
	
	public void setEstaVivo(boolean b) 
	{	
		estaVivo = b;
	}
}