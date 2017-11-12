package Logica;

/**
* Clase abstracta Obstaculo
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
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

}
