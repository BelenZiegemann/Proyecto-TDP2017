package Grafica;

/**
 * Clase CaminanteBlancoThread
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class CaminanteBlancoThread extends Thread
{
	private gCaminanteBlanco grafCaminante;
		
	// Flag que indica cuando debe detenerse la ejecuci�n del hilo.
	private boolean Detener;

	public CaminanteBlancoThread(gCaminanteBlanco grafCam) 
	{
		grafCaminante = grafCam;
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
				grafCaminante.mover();
			} catch (InterruptedException e)
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