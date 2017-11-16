package Logica;

import Logica.VisitorPowerUp.VisitorPowerUp;

/**
* Clase abstracta Obstaculo
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public abstract class Obstaculo extends Contenido 
{	
	protected boolean estaVivo = true;
	
	public boolean estaVivo() 
	{
		return estaVivo;
	}
	
	public void setEstaVivo(boolean b)
	{
		estaVivo = b;
	}
	
	public void serAfectado(VisitorPowerUp p)
	{
		p.afectar(this);
	}
	
}
