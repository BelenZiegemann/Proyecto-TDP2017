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
	public abstract void seratacado(Visitor p);
	public abstract void serAfectado(VisitorPowerUp p);
}
