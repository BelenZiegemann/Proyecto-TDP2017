package Logica;

import Logica.VisitorPersonaje.Visitor;
import Logica.VisitorPowerUp.VisitorPowerUp;

/**
* Clase abstracta Obstaculo
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public abstract class Obstaculo extends Contenido 
{	
	public abstract void seratacado(Visitor p);
	public abstract void serAfectado(VisitorPowerUp p);
}
