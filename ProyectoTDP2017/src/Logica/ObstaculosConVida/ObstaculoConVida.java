package Logica.ObstaculosConVida;

import Logica.Obstaculo;
import Logica.VisitorPersonaje.Visitor;
import Logica.VisitorPowerUp.VisitorPowerUp;

/**
* Clase abstracta ObstaculoConVida 
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
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
	
	public void seratacado(Visitor v) 
	{
		v.atacar(this);
	}
	
	public void serAfectado(VisitorPowerUp p)
	{
		p.afectar(this);
	}
}
