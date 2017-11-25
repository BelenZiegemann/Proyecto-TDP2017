package Logica;

import java.util.LinkedList;

import Logica.VisitorPersonaje.Visitor;
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
	protected boolean campoProteccion = false;
	protected Visitor proyectil;
	protected LinkedList<Celda> misCeldas;
	
	public abstract void seratacado(Visitor p);
	
	public abstract void serAfectado(VisitorPowerUp p);
	
	public abstract void mover();
	
	public abstract void controlarTamaño(); //asumo que el personaje solo podría ocupar mas de una celda en el eje X	
	
	public Visitor getProyectil()
	{
		return proyectil;
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
	
	public boolean tieneCampoProteccion()
	{
		return campoProteccion;
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
	
	public void setCampoProteccion(boolean c)
	{
		campoProteccion = c; 
	}
	
	public LinkedList<Celda> getMisCeldas()
	{
		return misCeldas;
	}
}