package Grafica;

import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import Logica.Mapa;
import Logica.Posicion;
import Logica.Jugadores.JonSnow;

/**
 * Clase gMapa
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class gMapa implements MouseListener
{
	protected Mapa m;
	protected ThreadPersonaje enemigos;
	protected Icon pisoNieve;
	protected JPanel gui;
	protected JLabel grafPiso;
	
	protected Posicion ultimaPosClickeada;
	
	protected final int anchoMapa = 10;
	protected final int altoMapa = 6;
	
	
	public gMapa(JPanel gui)
	{		
		this.gui = gui;
		m = new Mapa(altoMapa, anchoMapa, gui.getHeight(), gui.getWidth());
		
		//Creo imagen
		pisoNieve = new ImageIcon(this.getClass().getResource("/Imagenes/PisoNieve.jpg"));
		grafPiso =  new JLabel(pisoNieve);
		grafPiso.setBounds(0,0, gui.getWidth(), gui.getHeight());
		gui.add(grafPiso);
		
		grafPiso.addMouseListener(this);
		
	
		//Creo un ThreadEnemigo 
		enemigos = new ThreadPersonaje(this);
		enemigos.start();	
	}
	
	
	public void agregarEnemigo()
	{	
	
		JLabel grafEnemigo = m.agregarEnemigo();
		if(grafEnemigo != null)
		{	
			grafPiso.add(grafEnemigo);
			grafPiso.repaint();
		}
	}
	
	public void agregarJugador()
	{
		
		if(ultimaPosClickeada != null)
		{
			JonSnow j = new JonSnow(ultimaPosClickeada,m);
			JLabel grafJugador = m.agregarJugador(j);
			if(grafJugador != null)
			{
				grafPiso.add(grafJugador);
				grafPiso.repaint();
			}
		}
	}
	
	public Mapa obtenerMapaLogico()
	{
		return m;
	}
	
	public JLabel obtenerPisoMapa()
	{
		return grafPiso;
	}


	public void mouseClicked(java.awt.event.MouseEvent arg0)
	{
	
		int PosX = (grafPiso.getMousePosition().x) / (gui.getWidth() / anchoMapa);
		int PosY = (grafPiso.getMousePosition().y) / (gui.getHeight() / altoMapa);
		
		if(PosX == anchoMapa)
		{
			PosX--;
		}
		if(PosX == altoMapa)
		{
			PosY--;
		}
		
		ultimaPosClickeada = new Posicion(PosX,PosY); //posición en la cual se agregará al jugador
		
	}


	public void mouseEntered(java.awt.event.MouseEvent arg0)
	{}


	public void mouseExited(java.awt.event.MouseEvent arg0) 
	{}


	public void mousePressed(java.awt.event.MouseEvent arg0) 
	{}


	public void mouseReleased(java.awt.event.MouseEvent arg0)
	{}
	
}