package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
* Clase abstracta ObstaculoPorTiempo
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public abstract class ObstaculoPorTiempo extends Obstaculo 
{
	protected int tiempo;
	Timer DuracionObstaculo = new Timer(tiempo * 1000 ,  new ActionListener () 
	{ 
	    public void actionPerformed(ActionEvent e) 
	    {   
	    	setEstaVivo(false);
	    } 
	}); 

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
	
	public void seratacado(Visitor p)
	{
		p.atacar(this);
	}
	
}