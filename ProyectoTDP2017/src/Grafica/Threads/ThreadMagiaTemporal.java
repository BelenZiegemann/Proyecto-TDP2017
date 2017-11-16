package Grafica.Threads;

import java.util.LinkedList;

import Grafica.gMapa;
import Logica.PowerUp;

/**
 * Clase ThreadMagiaTemporal
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadMagiaTemporal extends Thread
{

	private LinkedList<PowerUp> magiaParaEliminar;
	private LinkedList<PowerUp> magiaAuxiliar;
	private gMapa gmapa;
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private volatile boolean Detener;
	
	
	public ThreadMagiaTemporal(gMapa gm)
	{
		gmapa = gm;
		Detener = false;
		magiaParaEliminar = new LinkedList<PowerUp>();
		magiaAuxiliar = new LinkedList<PowerUp>(); 	
	}
	
	public void run() 
	{
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!Detener) 
		{
			try 
			{
				Thread.sleep(800);
			}
			catch (InterruptedException e)
			{}
			//copio la lista de powerups
			magiaAuxiliar = new LinkedList<PowerUp>(gmapa.obtenerMapaLogico().getListaPowerUp());
			for(PowerUp pu : magiaAuxiliar)
			{
				gmapa.getGUI().mostrarMensajeMagiaTemporal(pu.mensajeEstadoPU());
				if(!pu.getTimer().isRunning())
					magiaParaEliminar.addLast(pu);
			}
			//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS POWERUPS
			for(PowerUp puElim : magiaParaEliminar)
			{
				gmapa.obtenerMapaLogico().getListaPowerUp().remove(puElim);
			}
			magiaParaEliminar.clear();	
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