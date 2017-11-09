package Grafica;
import Logica.CreadorJugador.*;

import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	protected GUI gui;
	protected JLabel grafPiso;
	protected boolean deboAgregar;
	protected boolean deboVenderJugador;
	protected CreadorJugador jugadorParaAgregar;
	protected Jugador jugadorParaVender;
	protected final int anchoMapa = 10;
	protected final int altoMapa = 6;
	
	public gMapa(GUI gui)
	{		
		this.gui = gui;
		
		//inicialmente no se agrega o quita ningún Jugador
		deboAgregar = false;
		jugadorParaAgregar = null;
		deboVenderJugador = false;
		jugadorParaVender = null;
		
		//Para agregar el piso al mapa
		pisoNieve = new ImageIcon(this.getClass().getResource("/Imagenes/PisoNieve.jpg"));
		grafPiso =  new JLabel(pisoNieve);
		grafPiso.setBounds(0,0, gui.getPanelMapa().getWidth(), gui.getPanelMapa().getHeight());
		gui.getPanelMapa().add(grafPiso);
		grafPiso.addMouseListener(this); //para detectar el click que agregará o quitará a un Jugador
	
		m = new Mapa(altoMapa, anchoMapa, gui.getPanelMapa().getHeight(), gui.getPanelMapa().getWidth());
		
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
	
	public void Perder()
	{
		level.detener();
		jugadores.detener();
		gui.mostrarMensajePerder();	
	}

	public void Ganar()
	{
		gui.mostrarMensajeGanar();
	}
	
	public void siguienteNivel()
	{
		level = new Nivel(level.getNumNivel() + 1,"src\\Logica\\Nivel2.txt",this);
		level.start();
	}
	
	public void DeboAgregarJugador(boolean deboAgregar)
	{
		this.deboAgregar = deboAgregar;
	}
	
	public void setDeboVenderJugador(boolean deboVenderJugador)
	{
		this.deboVenderJugador = deboVenderJugador;
	}
	
	
	public void setJugadorParaAgregar(CreadorJugador j)
	{
		jugadorParaAgregar = j;
	}
	
	public boolean deboVenderJugador()
	{
		return deboVenderJugador;
	}
	
	public Jugador getJugadorParaVender()
	{
		return jugadorParaVender;
	}
	
	public Mapa obtenerMapaLogico()
	{
		return m;
	}
	
	public JLabel obtenerPisoMapa()
	{
		return grafPiso;
	}

	public Nivel getNivel()
	{
		return level;
	}

	public void mouseClicked(java.awt.event.MouseEvent arg0)
	{
	
		int PosX = (grafPiso.getMousePosition().x) / (gui.getPanelMapa().getWidth() / anchoMapa);
		int PosY = (grafPiso.getMousePosition().y) / (gui.getPanelMapa().getHeight() / altoMapa);
		if(PosX == anchoMapa)
		{
			PosX--;
		}
		if(PosX == altoMapa)
		{
			PosY--;
		}
		Posicion posClickeada = new Posicion(PosX,PosY);
		if(deboAgregar)
		{
			Celda miCelda = m.obtenerCelda(posClickeada);
			Jugador j = jugadorParaAgregar.crearJugador(miCelda, m);
			agregarJugador(j);  //posición en la cual se agregará al jugador
		}
		deboAgregar = false;
		 ///////////////////////////////////////////////////////////////////
		// Recorro la lista de Jugadores del mapa para ver si la posición clickeada corresponde a la posición
		// de un Jugador en el mapa. Entonces ese Jugador podrá ser vendido.
		Iterator<Jugador> itJugador = m.getListaJugadores().iterator();
		boolean encontre = false;
		while(itJugador.hasNext() && !encontre)
		{
			Jugador jug = itJugador.next();
			Posicion pJug = jug.getCelda().getPosCelda();
			if(posClickeada.equals(pJug))
			{
				jugadorParaVender = jug;
				deboVenderJugador = true;
				encontre = true;
			}	
		}		
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