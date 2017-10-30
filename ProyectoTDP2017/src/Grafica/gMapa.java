package Grafica;
import Logica.CreadorJugador.*;

import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.*;

/**
 * Clase gMapa
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class gMapa implements MouseListener
{
	protected Mapa m;
	protected ThreadJugador jugadores;
	protected ThreadEnemigo enemigos;
	
	
	protected Nivel level;
	protected Icon pisoNieve;
	protected JPanel gui;
	protected JLabel grafPiso;
	protected boolean deboAgregar;
	protected CreadorJugador jugadorParaAgregar;
	protected final int anchoMapa = 10;
	protected final int altoMapa = 6;
	
	
	public gMapa(JPanel gui)
	{		
		this.gui = gui;
		m = new Mapa(altoMapa, anchoMapa, gui.getHeight(), gui.getWidth());
		
		//inicialmente no se agrega ningún Jugador
		deboAgregar = false;
		jugadorParaAgregar = null;
		
		//Para agregar el piso al mapa
		pisoNieve = new ImageIcon(this.getClass().getResource("/Imagenes/PisoNieve.jpg"));
		grafPiso =  new JLabel(pisoNieve);
		grafPiso.setBounds(0,0, gui.getWidth(), gui.getHeight());
		gui.add(grafPiso);
		grafPiso.addMouseListener(this); //para detectar el click que agregará a un Jugador
				
		//agrego un obstáculo
		JLabel grafPiedra = m.agregarObstaculo(new Piedra(m.obtenerCelda(new Posicion(3,4)),m));
		grafPiso.add(grafPiedra);
		grafPiso.repaint();
		
		//Creo un Thread para el Nivel
		level = new Nivel(1,"src\\Logica\\Nivel1.txt",this);
		level.start();
		
		//Creo un ThreadJugador
		jugadores = new ThreadJugador(this);
		jugadores.start();
		
		//Creo un ThreadJugador
		enemigos = new ThreadEnemigo(this);
		enemigos.start();	
	}
	
	
	public void agregarEnemigo(Enemigo e)
	{	
	
		JLabel grafEnemigo = m.agregarEnemigo(e);
		if(grafEnemigo != null)
		{	
			grafPiso.add(grafEnemigo);
			grafPiso.repaint();
		}
	}
	
	
	public void agregarJugador(Jugador j)
	{

			JLabel grafJugador = m.agregarJugador(j);
			if(grafJugador != null)
			{
				grafPiso.add(grafJugador);
				grafPiso.repaint();
			}
	}
	
	public void DeboAgregarJugador(boolean deboAgregar)
	{
		this.deboAgregar = deboAgregar;
	}
	
	public void setJugadorParaAgregar(CreadorJugador j)
	{
		jugadorParaAgregar = j;
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
		if(deboAgregar)
		{
			
			Posicion posClickeada = new Posicion(PosX,PosY);
			Celda miCelda = m.obtenerCelda(posClickeada);
			Jugador j = jugadorParaAgregar.crearJugador(miCelda, m);
			agregarJugador(j);  //posición en la cual se agregará al jugador
		}
		
		deboAgregar = false;	
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