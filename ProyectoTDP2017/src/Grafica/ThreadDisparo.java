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
		//protected LinkedList<Disparo> disparos;
	protected LinkedList<Disparo> DisparosParaEliminar;
	protected gMapa gmapa; 
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private volatile boolean Detener;

	public ThreadDisparo(gMapa gm) 
	{
		gmapa = gm;
		Detener = false;
		DisparosParaEliminar = new LinkedList<Disparo>();
	 //disparos = new LinkedList<Disparo>();
	}	
	
	public void run()
	{
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!Detener) 
		{
			try 
			{
				Thread.sleep(20);
				
			}
			catch (InterruptedException e)
			{}	
				synchronized(gmapa.obtenerMapaLogico().getListaDisparos())
				{
				//for(Disparo d:  disparos)
				for(Disparo d:  gmapa.obtenerMapaLogico().getListaDisparos())
				{
					
					//agregp el disparo al piso del mapa
					gmapa.obtenerPisoMapa().add(d.getGrafico());
					gmapa.obtenerPisoMapa().validate();
					gmapa.obtenerPisoMapa().repaint();
					
					
					d.mover();
					//veo si el disparo llega al destino
					if(d.getDestino().getCelda().getPosCelda().equals(d.getCelda().getPosCelda()))
					{
						System.out.println("Entre");
						System.out.println("Tipo disparo= " + d.toString());
						d.Atacar();
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
					
					//disparos.remove(dElim);
				}
				DisparosParaEliminar.clear();
				}
				
			
		}
	}
	/*
	public void agregarDisparo(Disparo disp)
	{
		//agregp el disparo al piso del mapa
		gmapa.obtenerPisoMapa().add(disp.getGrafico());
		gmapa.obtenerPisoMapa().validate();
		gmapa.obtenerPisoMapa().repaint();
		disparos.addLast(disp);;
	}
	*/
	
	public void detener() 
	{
		// Interrumpo el hilo para que no continue con su ejecución.	
		this.interrupt();
		// Seteamos el flag para detener su ejecución.
		Detener = true;
	}
}
