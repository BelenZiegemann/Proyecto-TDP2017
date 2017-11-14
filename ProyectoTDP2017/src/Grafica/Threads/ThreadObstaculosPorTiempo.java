package Grafica.Threads;

import java.util.LinkedList;
import java.util.Random;

import Grafica.gMapa;
import Logica.Celda;
import Logica.Posicion;
import Logica.ObstaculosPorTiempo.Fuego;
import Logica.ObstaculosPorTiempo.Lago;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase ThreadObstaculosPorTiempo
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadObstaculosPorTiempo extends Thread
{
	private LinkedList<ObstaculoPorTiempo> obsPorTiempoAEliminar;
	private gMapa gmapa;
	private Random aleatorio;
	private LinkedList<ObstaculoPorTiempo> obsAuxiliar;
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private volatile boolean Detener;
	
	public ThreadObstaculosPorTiempo(gMapa gm) 
	{
		obsPorTiempoAEliminar = new LinkedList<ObstaculoPorTiempo>();
		gmapa = gm;
		Detener = false;
		aleatorio =  new Random(System.currentTimeMillis());	
		obsAuxiliar = new LinkedList<ObstaculoPorTiempo>();
	}	
	
	public void run() 
	{
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!Detener) 	
		{
			try    
			{		
				Thread.sleep(600);
			}
			catch (InterruptedException e)
			{}
			
				int tiempoAleatorio = aleatorio.nextInt(6) + 5; // número aleatorio entre 5 y 10
				if(tiempoAleatorio == 5)
					agregarObstaculosPorTiempo(); // Cada cierto tiempo aleatorio se intentarán agregar obstáculos
											  	// que estarán en el mapa durante un tiempo (ese tiempo varía de
											  	// acuerdo al tipo de obstáculo (lago o fuego)			

				//copio la lista de obstáculos por tiempo
				obsAuxiliar = new LinkedList<ObstaculoPorTiempo>(gmapa.obtenerMapaLogico().getListaObstaculosPorTiempo());
				for(ObstaculoPorTiempo obsTiempo : obsAuxiliar)
				{
					if(!obsTiempo.estaVivo())
						obsTiempo.iniTimerDuracionObstaculo();
					else
						if(!obsTiempo.getTimerDuracionObstaculo().isRunning())
							obsPorTiempoAEliminar.addLast(obsTiempo);	
				}
				//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS OBSTÁCULOS
				for(ObstaculoPorTiempo obsElim : obsPorTiempoAEliminar)
				{
					obsElim.getCelda().setContenido(null);
					gmapa.obtenerPisoMapa().remove(obsElim.getGrafico());
					gmapa.obtenerPisoMapa().repaint();
					gmapa.obtenerMapaLogico().getListaObstaculosPorTiempo().remove(obsElim);
				}	
				obsPorTiempoAEliminar.clear();
		}	
	}
	
	public void agregarObstaculosPorTiempo()
	{
		int cantObstaculos = aleatorio.nextInt(3) + 1; // número aleatorio entre 1 y 3
		int posX, posY, obstaculoElegido;
		//Refresco datos aleatorios 
		aleatorio.setSeed(aleatorio.nextLong());
		for(int i=1; i <= cantObstaculos; i++)
		{
			posX = aleatorio.nextInt(8)+1; //número aleatorio entre 1 y 8
			aleatorio.setSeed(aleatorio.nextLong());//refresco datos aleatorios
			posY = aleatorio.nextInt(6); //número aleatorio entre 0 y 5
			aleatorio.setSeed(aleatorio.nextLong());//refresco datos aleatorios
			obstaculoElegido = aleatorio.nextInt(2); //número aleatorio entre 0 y 1
			Posicion posObs = new Posicion(posX,posY);
			Celda celdaObs = gmapa.obtenerMapaLogico().obtenerCelda(posObs);
			ObstaculoPorTiempo obsTiempo; 
			if(obstaculoElegido == 0)
			{
				obsTiempo = new Lago(celdaObs, gmapa.obtenerMapaLogico());
				gmapa.agregarObstaculoPorTiempo(obsTiempo);	
			}
			else
			{
				obsTiempo = new Fuego(celdaObs, gmapa.obtenerMapaLogico());
				gmapa.agregarObstaculoPorTiempo(obsTiempo);
			}	
			aleatorio.setSeed(aleatorio.nextLong());//refresco datos aleatorios
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