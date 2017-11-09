package Grafica;

import java.util.LinkedList;

import Logica.Enemigo;
import Logica.Obstaculo;

/**
 * Clase ThreadEnemigo
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadEnemigo extends Thread
{
	private LinkedList<Enemigo> EnemigosParaEliminar;
	private gMapa gmapa;
	 
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private boolean Detener;

	public ThreadEnemigo(gMapa gm) 
	{
		gmapa = gm;
		Detener = false;
		EnemigosParaEliminar = new LinkedList<Enemigo>();
	}	
	
	public void run() 
	{
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!Detener) 
		{
			try 
			{
				Thread.sleep(400);
				
				if(gmapa.getNivel().estaLeido() && gmapa.obtenerMapaLogico().getListaEnemigos().isEmpty())
				{
					gmapa.Ganar();
				}
				else
				{
					// Realizo el movimiento
					for(Enemigo e: gmapa.obtenerMapaLogico().getListaEnemigos())
					{	
						//SI EL ENEMIGO ESTÁ VIVO ENTONCES MOVER, SINO LO AGREGO A LA LISTA AUXILIAR PARA LUEGO ELIMINARLO
						if(e.estaVivo())
						{
							e.mover();
							if(e.deboPerderJuego())
							{
								gmapa.Perder();
								gmapa.obtenerMapaLogico().getListaEnemigos().clear();
								detener();
							}
						}
						else
						{
							EnemigosParaEliminar.addLast(e);
						}
					}
						
				
					for(Obstaculo o: gmapa.obtenerMapaLogico().getListaObstaculos()) 
					{
						if (!o.estaVivo())
						{
							gmapa.obtenerPisoMapa().remove(o.getGrafico());
							gmapa.obtenerPisoMapa().repaint();
							gmapa.obtenerMapaLogico().getListaObstaculos().remove(o);
						}	
					}
				
					//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS ENEMIGOS
					for(Enemigo eElim : EnemigosParaEliminar)
					{
						gmapa.obtenerPisoMapa().remove(eElim.getGrafico());
						gmapa.obtenerPisoMapa().repaint();
						gmapa.obtenerMapaLogico().getListaEnemigos().remove(eElim);
					}
				}	
		} 
		catch (InterruptedException e)
		{}
	
		}
	}

	public void detener() 
	{
		//gmapa.obtenerMapaLogico().getListaEnemigos().clear();
		//gmapa.obtenerPisoMapa().removeAll();
		//gmapa.obtenerPisoMapa().repaint();
		
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt();
		// Seteamos el flag para detener su ejecución.
		Detener = true;
	}
}