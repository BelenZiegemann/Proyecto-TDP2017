package Logica;

import Logica.VisitorPersonaje.Visitor;
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
	
	public abstract void seratacado(Visitor p);
	public abstract void serAfectado(VisitorPowerUp p);
	
}
