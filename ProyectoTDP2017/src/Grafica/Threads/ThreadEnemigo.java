package Grafica.Threads;

import java.util.LinkedList;

import Grafica.GUI.gMapa;
import Logica.Enemigo;

/**
 * Clase ThreadEnemigo
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadEnemigo extends Thread
{
	private LinkedList<Enemigo> EnemigosParaEliminar;
	private LinkedList<Enemigo> enemigosAuxiliar;
	private gMapa gmapa;
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private volatile boolean Detener;

	public ThreadEnemigo(gMapa gm) 
	{
		gmapa = gm;
		Detener = false;
		EnemigosParaEliminar = new LinkedList<Enemigo>();
		enemigosAuxiliar = new LinkedList<Enemigo>();
	}	
	
	public void run() 
	{
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!Detener) 
		{
			try 
			{
				Thread.sleep(400);
			}
			catch (InterruptedException e)
			{}
		
				if(gmapa.getNivel().estaLeido() && gmapa.obtenerMapaLogico().getListaEnemigos().isEmpty())
					gmapa.Ganar();
				else
				{
					//copio la lista de enemigos
					enemigosAuxiliar = new LinkedList<Enemigo>(gmapa.obtenerMapaLogico().getListaEnemigos());
					// Realizo el movimiento
					for(Enemigo e: enemigosAuxiliar)
					{	
						//SI EL ENEMIGO ESTÁ VIVO ENTONCES MOVER, SINO LO AGREGO A LA LISTA AUXILIAR PARA LUEGO ELIMINARLO
						if(e.estaVivo())
						{
							e.mover();
							if(e.deboPerderJuego())
							{
								gmapa.Perder();
							}
						}
						else
						{
							EnemigosParaEliminar.addLast(e);
						}
					}
					//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS ENEMIGOS
					for(Enemigo eElim : EnemigosParaEliminar)
					{
						gmapa.obtenerPisoMapa().remove(eElim.getGrafico());
						gmapa.obtenerPisoMapa().repaint();
						gmapa.obtenerMapaLogico().getListaEnemigos().remove(eElim);
					}
					EnemigosParaEliminar.clear();
				}	
		
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