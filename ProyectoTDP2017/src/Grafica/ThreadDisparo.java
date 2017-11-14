package Grafica;


import java.util.LinkedList;
import Logica.Disparo;

/**
 * Clase ThreadDisparo
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadDisparo extends Thread
{
	private LinkedList<Disparo> DisparosParaEliminar;
	private gMapa gmapa; 
	private LinkedList<Disparo> disparosAuxiliar;
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private volatile boolean Detener;
	
	public ThreadDisparo(gMapa gm) 
	{
		gmapa = gm;
		Detener = false;
		DisparosParaEliminar = new LinkedList<Disparo>();
		disparosAuxiliar = new LinkedList<Disparo>();	
	}	
	
	public void run()
	{
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!Detener) 
		{
			try 
			{
				Thread.sleep(40);	
			}
			catch (InterruptedException e)
			{}	
			
				//copio la lista de disparos
				disparosAuxiliar = new LinkedList<Disparo>(gmapa.obtenerMapaLogico().getListaDisparos());	
				for(Disparo d:  disparosAuxiliar)
				{
					//agregp el disparo al piso del mapa
					gmapa.obtenerPisoMapa().add(d.getGrafico());
					gmapa.obtenerPisoMapa().validate();
					gmapa.obtenerPisoMapa().repaint();
					
					d.mover();
					//veo si el disparo llega al destino
					if(d.getDestino().getCelda().getPosCelda().equals(d.getCelda().getPosCelda()))
					{
						DisparosParaEliminar.addLast(d);
					}
				
				}
				
				//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS DISPAROS
				for(Disparo dElim: DisparosParaEliminar)
				{
					gmapa.obtenerPisoMapa().remove(dElim.getGrafico());
					gmapa.obtenerPisoMapa().validate();
					gmapa.obtenerPisoMapa().repaint();
					gmapa.obtenerMapaLogico().getListaDisparos().remove(dElim);
				}
				DisparosParaEliminar.clear();		
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
