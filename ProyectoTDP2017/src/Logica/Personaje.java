package Logica;

import Logica.VisitorContenido.Visitor;
import Logica.VisitorPowerUp.VisitorPowerUp;

/**
 * Clase Abstracta Personaje
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
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
	
	public abstract void serAfectado(VisitorPowerUp p);
	
	public abstract void mover();
	
	public boolean estaVivo()
	{
		return estaVivo;
	}
	
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
	
	public void setEstaVivo(boolean b) 
	{	
		estaVivo = b;
	}
	
	public void setVida(int v)
	{
		puntosVida = v;
	}
	
	public void setFuerzaImpacto(int fuerzaI)
	{
		fuerzaImpacto = fuerzaI;
		
	}
	
	public void setAlcance(int a)
	{
		alcance = a;
	}
}