package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
* Clase abstracta ObstaculoPorTiempo
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public abstract class ObstaculoPorTiempo extends Obstaculo 
{
	protected int tiempo;
	Timer DuracionObstaculo = new Timer(tiempo * 1000 ,  new ActionListener () 
	{ 
	    public void actionPerformed(ActionEvent e) 
	    {   
	    	estaVivo = true;
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
	
	public Timer getTimerDuracionObstaculo()
	{
		return DuracionObstaculo;
	}
	
	public synchronized void seratacado(Visitor p)
	{ 	
		p.atacar(this);
	}
	
}