package Grafica;

import java.util.LinkedList;


import Logica.Mapa;
import Logica.Personaje;

/**
 * Clase ThreadPersonaje
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class ThreadPersonaje extends Thread
{
	private Mapa mapa;
	LinkedList<Personaje> PersonajesParaEliminar;
	
	// Flag que indica cuando debe detenerse la ejecuci�n del hilo.
	private boolean Detener;

	public ThreadPersonaje(Mapa m) 
	{
		mapa = m;
		Detener = false;
		PersonajesParaEliminar = new LinkedList<Personaje>();
	}	
	
	public void run() 
	{
		
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!Detener) 
		{
			try 
			{
				Thread.sleep(400);
				// Realizo el movimiento
				for(Personaje p: mapa.getListaPersonajes())
				{	
					//SI EL PERSONAJE EST� VIVO ENTONCES MOVER, SINO LO AGREGO A LA LISTA AUXILIAR PARA LUEGO ELIMINARLO
					if(p.estaVivo() == true)
						p.mover();
					else
					{
						
						PersonajesParaEliminar.addLast(p);
					}
				}
				
				//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS PERSONAJES
				for(Personaje pElim : PersonajesParaEliminar)
				{
					pElim.getGrafico().setEnabled(false);
					mapa.getListaPersonajes().remove(pElim);
				}
					
			} catch (InterruptedException e)
			{}
		}
	}

	public void detener() 
	{
		// Interrumpo el hilo para que no continue con su ejecuci�n.
		this.interrupt();

		// Seteamos el flag para detener su ejecuci�n.
		Detener = true;
	}

}
