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
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class ThreadObstaculosPorTiempo extends Thread
{
	private LinkedList<ObstaculoPorTiempo> obsPorTiempoAEliminar;
	private gMapa gmapa;
	private Random aleatorio;
	private LinkedList<ObstaculoPorTiempo> obsAuxiliar;
	// Flag que indica cuando debe detenerse la ejecuci�n del hilo.
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
			
				int tiempoAleatorio = aleatorio.nextInt(6) + 5; // n�mero aleatorio entre 5 y 10
				if(tiempoAleatorio == 5)
					agregarObstaculosPorTiempo(); // Cada cierto tiempo aleatorio se intentar�n agregar obst�culos
											  	// que estar�n en el mapa durante un tiempo (ese tiempo var�a de
											  	// acuerdo al tipo de obst�culo (lago o fuego)			

				//copio la lista de obst�culos por tiempo
				obsAuxiliar = new LinkedList<ObstaculoPorTiempo>(gmapa.obtenerMapaLogico().getListaObstaculosPorTiempo());
				for(ObstaculoPorTiempo obsTiempo : obsAuxiliar)
				{
					if(!obsTiempo.estaVivo())
						obsTiempo.iniTimerDuracionObstaculo();
					else
						if(!obsTiempo.getTimerDuracionObstaculo().isRunning())
							obsPorTiempoAEliminar.addLast(obsTiempo);	
				}
				//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS OBST�CULOS
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
		int cantObstaculos = aleatorio.nextInt(3) + 1; // n�mero aleatorio entre 1 y 3
		int posX, posY, obstaculoElegido;
		//Refresco datos aleatorios 
		aleatorio.setSeed(aleatorio.nextLong());
		for(int i=1; i <= cantObstaculos; i++)
		{
			posX = aleatorio.nextInt(8)+1; //n�mero aleatorio entre 1 y 8
			aleatorio.setSeed(aleatorio.nextLong());//refresco datos aleatorios
			posY = aleatorio.nextInt(6); //n�mero aleatorio entre 0 y 5
			aleatorio.setSeed(aleatorio.nextLong());//refresco datos aleatorios
			obstaculoElegido = aleatorio.nextInt(2); //n�mero aleatorio entre 0 y 1
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
		// Interrumpo el hilo para que no continue con su ejecuci�n.
		this.interrupt();
		// Seteamos el flag para detener su ejecuci�n.
		Detener = true;
	}
}