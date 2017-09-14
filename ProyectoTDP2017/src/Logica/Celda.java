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
	protected Mapa mapa;
	
	public Celda(Posicion p, Mapa m)
	{
		posicion = p;
		mapa  = m;
		
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
	
	/*
	public Premio destruir()
	{
		
	}
	
	
	public boolean avanzar(Enemigo e) 
	{
		return contenido.avanzar(e);
	}
	
	*/
	
	
}