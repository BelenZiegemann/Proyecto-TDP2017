package Logica.ObstaculosConVida;

import Logica.Obstaculo;
import Logica.Visitor.Visitor;

/**
* Clase abstracta ObstaculoConVida 
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public abstract class ObstaculoConVida extends Obstaculo 
{
	protected int vida;
	
	public void setVida(int v) 
	{
		vida = v;
	}
	
	public int getVida()
	{
		return vida;
	}
	
	public synchronized void seratacado(Visitor v) 
	{
		v.atacar(this);
	}
}
