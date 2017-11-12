package Grafica;

import java.util.LinkedList;
import Logica.Enemigo;
import Logica.ObstaculoConVida;

/**
 * Clase ThreadEnemigo
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class ThreadEnemigo extends Thread
{
	private LinkedList<Enemigo> EnemigosParaEliminar;
	private LinkedList<ObstaculoConVida> ObstaculosParaEliminar;
	private gMapa gmapa;
	// Flag que indica cuando debe detenerse la ejecuci�n del hilo.
	private boolean Detener;

	public ThreadEnemigo(gMapa gm) 
	{
		gmapa = gm;
		Detener = false;
		EnemigosParaEliminar = new LinkedList<Enemigo>();
		ObstaculosParaEliminar = new LinkedList<ObstaculoConVida>();
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
					gmapa.Ganar();
				else
				{
					// Realizo el movimiento
					for(Enemigo e: gmapa.obtenerMapaLogico().getListaEnemigos())
					{	
						//SI EL ENEMIGO EST� VIVO ENTONCES MOVER, SINO LO AGREGO A LA LISTA AUXILIAR PARA LUEGO ELIMINARLO
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
					for(ObstaculoConVida o: gmapa.obtenerMapaLogico().getListaObstaculosConVida()) 
					{
						if (!o.estaVivo())
							ObstaculosParaEliminar.addLast(o);
					}
				
					//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS OBST�CULOS
					for(ObstaculoConVida oElim : ObstaculosParaEliminar)
					{
						gmapa.obtenerPisoMapa().remove(oElim.getGrafico());
						gmapa.obtenerPisoMapa().repaint();
						gmapa.obtenerMapaLogico().getListaObstaculosConVida().remove(oElim);
					}
					ObstaculosParaEliminar.clear();
				}	
		} 
		catch (InterruptedException e)
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