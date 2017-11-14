package Logica;

import Logica.Visitor.Visitor;
import Logica.Visitor.VisitorJugador;

/**
 * Clase abstracta Jugador 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Jugador extends Personaje
{
	protected int precio = 125;
	
	public synchronized void seratacado(Visitor p)
	{
		p.atacar(this);
	}
	
	public int getPrecio()
	{
		return precio;
	}
	
	public void setProyectil(VisitorJugador proyJug)
	{
		proyectil = proyJug;
	}
	
	public void mover() 
	{	
		Posicion miPosicion = miCelda.getPosCelda();
		int miX = miPosicion.getEjeX();
		int miY = miPosicion.getEjeY();
		int i = 1;
		boolean encontre = false;
		while(i <= alcance && !encontre) 
		{
			if (miX-i >= 0)
			{
				Celda celdaSiguiente = mapa.obtenerCelda(new Posicion(miX-i,miY));
				Contenido contenidoSiguiente = celdaSiguiente.getContenido();
				if (contenidoSiguiente != null)
				{
					encontre = true;
					contenidoSiguiente.seratacado(this.proyectil);		 
				}	
			}
			i++;
		}
	}	
}