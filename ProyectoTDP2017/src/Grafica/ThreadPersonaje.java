package Grafica;

import java.util.LinkedList;

import Logica.Personaje;

/**
 * Clase ThreadPersonaje
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadPersonaje extends Thread
{
	private LinkedList<Personaje> PersonajesParaEliminar;
	private gMapa gmapa;
	 
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private boolean Detener;

	public ThreadPersonaje(gMapa gm) 
	{
		gmapa = gm;
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
				for(Personaje p: gmapa.obtenerMapaLogico().getListaPersonajes())
				{	
					//SI EL PERSONAJE ESTÁ VIVO ENTONCES MOVER, SINO LO AGREGO A LA LISTA AUXILIAR PARA LUEGO ELIMINARLO
					if(p.estaVivo())
						p.mover();
					else
					{
						
						PersonajesParaEliminar.addLast(p);
					}
				}
				
				//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS PERSONAJES
				for(Personaje pElim : PersonajesParaEliminar)
				{
					//pElim.getGrafico().setEnabled(false);
					gmapa.obtenerPisoMapa().remove(pElim.getGrafico());
					gmapa.obtenerPisoMapa().repaint();
					gmapa.obtenerMapaLogico().getListaPersonajes().remove(pElim);
				}
					
			} catch (InterruptedException e)
			{}
		}
	}

	public void detener() 
	{
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt();

		// Seteamos el flag para detener su ejecución.
		Detener = true;
	}

}
