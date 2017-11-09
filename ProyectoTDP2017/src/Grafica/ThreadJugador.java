package Grafica;

import java.util.LinkedList;

import Logica.Jugador;
import Logica.Obstaculo;

/**
 * Clase ThreadJugador
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadJugador extends Thread
{
	private LinkedList<Jugador> JugadoresParaEliminar;
	private gMapa gmapa;
	 
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private boolean Detener;

	public ThreadJugador(gMapa gm) 
	{
		gmapa = gm;
		Detener = false;
		JugadoresParaEliminar = new LinkedList<Jugador>();
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
				for(Jugador j: gmapa.obtenerMapaLogico().getListaJugadores())
				{	
					//SI EL JUGADOR ESTÁ VIVO ENTONCES MOVER, SINO LO AGREGO A LA LISTA AUXILIAR PARA LUEGO ELIMINARLO
					if(j.estaVivo())
						j.mover();
					else
					{
						JugadoresParaEliminar.addLast(j);
					}
				}
				
				for(Obstaculo o: gmapa.obtenerMapaLogico().getListaObstaculos()) 
				{
					if (!o.estaVivo()) {
						gmapa.obtenerPisoMapa().remove(o.getGrafico());
						gmapa.obtenerPisoMapa().repaint();
						gmapa.obtenerMapaLogico().getListaObstaculos().remove(o);
					}
						
				}
				
				//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS JUGADORES
				for(Jugador jElim : JugadoresParaEliminar)
				{
					gmapa.obtenerPisoMapa().remove(jElim.getGrafico());
					gmapa.obtenerPisoMapa().repaint();
					gmapa.obtenerMapaLogico().getListaJugadores().remove(jElim);
				}
			}
			catch (InterruptedException e)
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