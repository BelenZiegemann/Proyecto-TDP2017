package Grafica;

import java.util.LinkedList;
import java.util.Random;
import Logica.Celda;
import Logica.Fuego;
import Logica.Lago;
import Logica.ObstaculoPorTiempo;
import Logica.Posicion;

/**
 * Clase ThreadObstaculosPorTiempo
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class ThreadObstaculosPorTiempo extends Thread
{
	protected LinkedList<ObstaculoPorTiempo> obsPorTiempoAEliminar;
	protected gMapa gmapa;
	// Flag que indica cuando debe detenerse la ejecuci�n del hilo.
	protected boolean Detener;
	protected Random aleatorio;
	
	public ThreadObstaculosPorTiempo(gMapa gm) 
	{
		obsPorTiempoAEliminar = new LinkedList<ObstaculoPorTiempo>();
		gmapa = gm;
		Detener = false;
		aleatorio =  new Random(System.currentTimeMillis());	
	}	
	
	public void run() 
	{
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!Detener) 
		{
			try
			{
				int tiempoAleatorio = aleatorio.nextInt(6) + 5; // n�mero aleatorio entre 5 y 10			
				Thread.sleep(tiempoAleatorio * 1000);
			}
			catch (InterruptedException e)
			{}
			synchronized(gmapa.obtenerMapaLogico().getListaObstaculosPorTiempo())
			{
				agregarObstaculosPorTiempo(); // Cada cierto tiempo aleatorio se intentar�n agregar obst�culos
											  // que estar�n en el mapa durante un tiempo (ese tiempo var�a de
											  // acuerdo al tipo de obst�culo (lago o fuego)			
				for(ObstaculoPorTiempo obsTiempo : gmapa.obtenerMapaLogico().getListaObstaculosPorTiempo())
				{
					if(obsTiempo.estaVivo())
						obsTiempo.iniTimerDuracionObstaculo();
					else
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