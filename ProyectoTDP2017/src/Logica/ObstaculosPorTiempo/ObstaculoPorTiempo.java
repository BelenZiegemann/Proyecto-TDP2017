package Logica.ObstaculosPorTiempo;

import javax.swing.Timer;

import Logica.Obstaculo;
import Logica.VisitorPersonaje.Visitor;
import Logica.VisitorPowerUp.VisitorPowerUp;

/**
* Clase abstracta ObstaculoPorTiempo
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public abstract class ObstaculoPorTiempo extends Obstaculo 
{
	protected int tiempo;
	protected Timer DuracionObstaculo;
	
	public void setTiempo(int t)
	{
		this.tiempo = t;
	}
	
	public int getTiempo()
	{
		return tiempo;
	}
	
	public void iniTimerDuracionObstaculo()
	{
		DuracionObstaculo.start();	
	}
	
	public Timer getTimerDuracionObstaculo()
	{
		return DuracionObstaculo;
	}
	
	public void seratacado(Visitor p)
	{ 	
		p.atacar(this);
	}
	
	public void serAfectado(VisitorPowerUp p)
	{
		p.afectar(this);
	}
	
}