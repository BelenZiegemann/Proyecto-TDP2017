package Grafica;

import Logica.Mapa;
import Logica.Personaje;

public class ThreadPersonaje extends Thread
{
	private Mapa mapa;
	
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private boolean Detener;

	public ThreadPersonaje(Mapa m) 
	{
		mapa = m;
		Detener = false;
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
				for(Personaje p: mapa.getListaPersonajes())
				{
					p.mover();
				}
					
			} catch (InterruptedException e)
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
