package Grafica;

import java.util.LinkedList;

import Logica.Enemigo;
import Logica.ObstaculoConVida;

/**
 * Clase ThreadEnemigo
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadEnemigo extends Thread
{
	private LinkedList<Enemigo> EnemigosParaEliminar;
	private LinkedList<ObstaculoConVida> ObstaculosParaEliminar;
	private gMapa gmapa;
	private LinkedList<Enemigo> enemigosAuxiliar;
	private LinkedList<ObstaculoConVida> obsAuxiliar;
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private volatile boolean Detener;

	public ThreadEnemigo(gMapa gm) 
	{
		gmapa = gm;
		Detener = false;
		EnemigosParaEliminar = new LinkedList<Enemigo>();
		ObstaculosParaEliminar = new LinkedList<ObstaculoConVida>();
		enemigosAuxiliar = new LinkedList<Enemigo>();
		obsAuxiliar = new LinkedList<ObstaculoConVida>();
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
								gmapa.obtenerMapaLogico().getListaEnemigos().clear();
								detener();
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
					
					////////////////////////////////////////////////////////////////////////////////
					//copio la lista de obstáculos con vida
					obsAuxiliar = new LinkedList<ObstaculoConVida>(gmapa.obtenerMapaLogico().getListaObstaculosConVida());
					for(ObstaculoConVida o: obsAuxiliar) 
					{
						if (!o.estaVivo())
							ObstaculosParaEliminar.addLast(o);
					}
				
					//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS OBSTÁCULOS
					for(ObstaculoConVida oElim : ObstaculosParaEliminar)
					{
						gmapa.obtenerPisoMapa().remove(oElim.getGrafico());
						gmapa.obtenerPisoMapa().repaint();
						gmapa.obtenerMapaLogico().getListaObstaculosConVida().remove(oElim);
					}
					ObstaculosParaEliminar.clear();
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