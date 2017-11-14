package Grafica;

import java.util.LinkedList;

import Logica.Jugador;

/**
 * Clase ThreadJugador
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadJugador extends Thread
{
	private LinkedList<Jugador> JugadoresParaEliminar;
	private gMapa gmapa;
	private LinkedList<Jugador> jugadoresAuxiliar;
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private volatile boolean Detener;	

	public ThreadJugador(gMapa gm) 
	{
		gmapa = gm;
		Detener = false;
		JugadoresParaEliminar = new LinkedList<Jugador>();	
		jugadoresAuxiliar = new LinkedList<Jugador>();
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
				//copio la lista de jugadores
				jugadoresAuxiliar = new LinkedList<Jugador>(gmapa.obtenerMapaLogico().getListaJugadores());
				// Realizo el movimiento
				for(Jugador j: jugadoresAuxiliar)
				{	
					//SI EL JUGADOR ESTÁ VIVO ENTONCES MOVER, SINO LO AGREGO A LA LISTA AUXILIAR PARA LUEGO ELIMINARLO
					if(j.estaVivo())
					{
						j.mover();
					}
					else
						JugadoresParaEliminar.addLast(j);
				}
				//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS JUGADORES
				for(Jugador jElim : JugadoresParaEliminar)
				{
					gmapa.obtenerPisoMapa().remove(jElim.getGrafico());
					gmapa.obtenerPisoMapa().repaint();
					gmapa.obtenerMapaLogico().getListaJugadores().remove(jElim);
				}
				JugadoresParaEliminar.clear();					
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