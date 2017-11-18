package Grafica.Threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.Timer;

import Grafica.GUI.gMapa;
import Logica.PowerUp;

/**
 * Clase ThreadMagiaTemporal
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ThreadPowerUp extends Thread
{

	private LinkedList<PowerUp> powerupsParaEliminar;
	private LinkedList<PowerUp> powerupsAuxiliar;
	private gMapa gmapa;
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private volatile boolean Detener;
	 
	private LinkedList<JLabel> explosionParaEliminar;
	private LinkedList<JLabel> explosionAuxiliar;
	protected Timer timerExplosion;
	
	public ThreadPowerUp(gMapa gm)
	{
		gmapa = gm;
		Detener = false;
		powerupsParaEliminar = new LinkedList<PowerUp>();
		powerupsAuxiliar = new LinkedList<PowerUp>(); 
		
		explosionParaEliminar = new LinkedList<JLabel>();
		explosionAuxiliar = new LinkedList<JLabel>();
		
		timerExplosion = new Timer(0, new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				eliminarExplosion();
			}
		});
		timerExplosion.setRepeats(false);
		timerExplosion.setInitialDelay(1000); //la explosión durará un segundo
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
			powerupsAuxiliar = new LinkedList<PowerUp>(gmapa.obtenerMapaLogico().getListaPowerUp());
			for(PowerUp pu : powerupsAuxiliar)
			{
				gmapa.getGUI().mostrarMensajePU(pu.mensajeEstadoPU());
				if(pu.getGrafico() != null)
				{
					gmapa.obtenerPisoMapa().add(pu.getGrafico());
					gmapa.obtenerPisoMapa().repaint();
					pu.getGrafico().addMouseListener(gmapa.getGUI()); // agrego el oyente al jlabel del powerup (de tipo objeto precioso)
					gmapa.getGUI().agregarObjetoPrecioso(pu);
					powerupsParaEliminar.addLast(pu);
				}
				else
					if(!pu.getTimer().isRunning())
						powerupsParaEliminar.addLast(pu);
			}
			//RECORRO LA LISTA AUXILIAR Y VOY ELIMINANDO LOS POWERUPS
			for(PowerUp puElim : powerupsParaEliminar)
			{
				gmapa.obtenerMapaLogico().getListaPowerUp().remove(puElim);
			}
			powerupsParaEliminar.clear();	
			
			/////////////////////////////////////////////////////////////////////////////
			//copio la lista de explosión
			explosionAuxiliar = new LinkedList<JLabel>(gmapa.obtenerMapaLogico().getListaExplosion());
			for(JLabel lbl : explosionAuxiliar)
			{
				gmapa.obtenerPisoMapa().add(lbl);
				gmapa.obtenerPisoMapa().repaint();
				explosionParaEliminar.addLast(lbl);
			}	

			timerExplosion.start();
		}
	}
	
	public void stopTimer()
	{
		timerExplosion.stop();
	}
	
	public void eliminarExplosion()
	{
		for(JLabel lblElim : explosionParaEliminar)
		{
			gmapa.obtenerPisoMapa().remove(lblElim);
			gmapa.obtenerPisoMapa().repaint();
			gmapa.obtenerMapaLogico().getListaExplosion().remove(lblElim);
		}
		explosionParaEliminar.clear();
	}
	
	public void detener() 
	{
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt();
		// Seteamos el flag para detener su ejecución.
		Detener = true;
	}	
	
}