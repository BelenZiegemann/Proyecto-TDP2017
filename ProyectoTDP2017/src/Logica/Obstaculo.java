package Logica;

/**
* Clase abstracta Obstaculo
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public abstract class Obstaculo extends Contenido {
	
	protected boolean estaVivo;
	
	public boolean estaVivo() 
	{
		return estaVivo;
	}
	
	public void setEstaVivo(boolean b)
	{
		estaVivo = b;
	}
}
