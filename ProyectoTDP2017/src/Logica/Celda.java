package Logica;

/**
 * Clase Celda
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class Celda 
{
	
	protected Contenido miContenido;
	protected Posicion posicion;
	
	public Celda(Posicion p)
	{
		posicion = p;	
	}
	
	public void setContenido(Contenido c) 
	{
		miContenido = c;
	}
	
	public Contenido getContenido() 
	{
		return miContenido;
	}
	
	public Posicion getPosCelda() 
	{
		return posicion;
	}
}