package Grafica.GUI;
import Logica.CreadorJugador.*;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

import java.awt.event.MouseListener;
import java.util.Iterator;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.Threads.Nivel;
import Grafica.Threads.ThreadDisparo;
import Grafica.Threads.ThreadEnemigo;
import Grafica.Threads.ThreadJugador;
import Grafica.Threads.ThreadPowerUp;
import Grafica.Threads.ThreadObstaculos;
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
	protected ThreadDisparo disparos;
	protected ThreadObstaculos obstaculos;
	protected ThreadPowerUp powerups;
	protected Nivel level;
	protected Icon pisoNieve;
	protected GUI gui;
	protected JLabel grafPiso;
	protected boolean deboAgregar;
	protected boolean deboPonerBomba;
	protected boolean deboVenderJugador;
	protected boolean finJuego;
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
		deboPonerBomba = false;
		finJuego= false;
		jugadorParaVender = null;
		
		//Para agregar el piso al mapa
		pisoNieve = new ImageIcon(this.getClass().getResource("/Imagenes/PisoNieve.jpg"));
		grafPiso =  new JLabel(pisoNieve);
		grafPiso.setSize(gui.getPanelMapa().getWidth(), gui.getPanelMapa().getHeight());
		gui.getPanelMapa().add(grafPiso);
		grafPiso.addMouseListener(this); //para detectar el click que agregará o quitará a un Jugador
	
		m = new Mapa(altoMapa, anchoMapa, gui.getPanelMapa().getHeight(), gui.getPanelMapa().getWidth());
		
		//Creo un Thread para el Nivel
		level = new Nivel(1,"Logica/Niveles/Nivel1.txt",this);
		level.start();
		
		//Creo un ThreadJugador
		jugadores = new ThreadJugador(this);
		jugadores.start();
		
		//Creo un ThreadEnemigo
		enemigos = new ThreadEnemigo(this);
		enemigos.start();	
		
		//Creo un ThreadDisparo
		disparos = new ThreadDisparo(this);
		disparos.start();
		
		//Creo un ThreadObstaculos
		obstaculos = new ThreadObstaculos(this);
		obstaculos.start();	
		
		//Creo un ThreadPowerUp
		powerups = new ThreadPowerUp(this);
		powerups.start();
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
	
	public void  agregarJugador(Jugador j)
	{
		JLabel grafJugador = m.agregarJugador(j);
		if(grafJugador != null)
		{
			grafPiso.add(grafJugador);
			grafPiso.repaint();
		}
	}
	
	public  void agregarObstaculoConVida(ObstaculoConVida obsVida)
	{
		JLabel grafObstaculoVida = m.agregarObstaculoConVida(obsVida);
		if(grafObstaculoVida!= null)
		{
			grafPiso.add(grafObstaculoVida);
			grafPiso.repaint();
		}
	}
	
	public void agregarObstaculoPorTiempo(ObstaculoPorTiempo obsTiempo)
	{
		JLabel grafObstaculoTiempo = m.agregarObstaculoPorTiempo(obsTiempo);
		if(grafObstaculoTiempo!= null)
		{
			grafPiso.add(grafObstaculoTiempo);
			grafPiso.repaint();
		}
	}
	
	public void detener()
	{
		finJuego = true;
		jugadorParaVender = null;
		deboVenderJugador = false;
		gui.mostrarMensajePU("");
		level.detener();
		jugadores.detener();
		enemigos.detener();
		disparos.detener();
		obstaculos.detener();
		powerups.detener();
		m.getListaEnemigos().clear();
		m.getListaJugadores().clear();
		m.getListaDisparos().clear();
		m.getListaObstaculosConVida().clear();
		m.getListaObstaculosPorTiempo().clear();
		m.getListaPowerUp().clear();
		m.getListaExplosion().clear();
		grafPiso.removeAll();
		grafPiso.repaint();
	}
	
	public void Perder()
	{	
		gui.getSonido().stop();
		//sonido game over
		gui.setSonidoFin("/Sonidos/Game Over.wav");
		setImagenPerderJuego();
		detener();
	}

	public void Ganar()
	{
		if(getNivel().getNumNivel() == 2) //acá ya gané el juego
		{
			gui.getSonido().stop();
			//sonido you win
			gui.setSonidoFin("/Sonidos/You Win.wav");
			setImagenGanarJuego();	
			detener();
		}
		else //sino muestro el mensaje para pasar de nivel
			gui.mostrarSiguienteNivel();
	}
	
	public void setFinJuego(boolean fin)
	{
		finJuego = fin;
	}
	
	public void setImagenGanarJuego()
	{
		grafPiso.setVisible(false);
		grafPiso.setEnabled(false);
		Icon imagenGanar = new ImageIcon(this.getClass().getResource("/Imagenes/ganar.png"));
		JLabel lblGanar = new JLabel(imagenGanar);
		lblGanar.setSize(gui.getPanelMapa().getWidth(), gui.getPanelMapa().getHeight());
		gui.getPanelMapa().add(lblGanar);
		gui.getPanelMapa().repaint();
	}
	 
	public void setImagenPerderJuego()
	{
		grafPiso.setVisible(false);
		grafPiso.setEnabled(false);
		Icon imagenPerder = new ImageIcon(this.getClass().getResource("/Imagenes/perder.jpg"));
		JLabel lblPerder = new JLabel(imagenPerder);
		lblPerder.setSize(gui.getPanelMapa().getWidth(), gui.getPanelMapa().getHeight());
		gui.getPanelMapa().add(lblPerder);
		gui.getPanelMapa().repaint();		
	}
	
	public void siguienteNivel()
	{
		jugadorParaVender = null;
		deboVenderJugador = false;
		gui.mostrarMensajePU("");
		powerups.stopTimer();
		powerups.eliminarExplosion();
		level = new Nivel(level.getNumNivel() + 1,"Logica/Niveles/Nivel2.txt",this);
		Thread tl = new Thread(level);
		tl.start();
		level.start();
	}
	
	public GUI getGUI()
	{
		return gui;
	}
	
	public void DeboColocarBomba(boolean deboPonerBomba)
	{
		this.deboPonerBomba = deboPonerBomba;
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
		if(!finJuego)
		{
			int PosX = (grafPiso.getMousePosition().x) / (gui.getPanelMapa().getWidth() / anchoMapa);
			int PosY = (grafPiso.getMousePosition().y) / (gui.getPanelMapa().getHeight() / altoMapa);
			if(PosX == anchoMapa)
				PosX--;
			if(PosY == altoMapa)
				PosY--;
			Posicion posClickeada = new Posicion(PosX,PosY);
			Celda miCelda = m.obtenerCelda(posClickeada);
			if(deboAgregar)
			{	
				Jugador j = jugadorParaAgregar.crearJugador(miCelda, m);
				agregarJugador(j);  //posición en la cual se agregará al jugador
			}
			deboAgregar = false;
			if(deboPonerBomba)
			{
				PowerUp bomba = gui.eliminarBomba();
				bomba.setCelda(miCelda);
				bomba.actualizarPosGrafico();
				grafPiso.add(bomba.getGrafico());
				grafPiso.repaint();
				//inicio retardo de timepo antes de la explosión
				bomba.iniTimer();	
			}
			deboPonerBomba = false;
			///////////////////////////////////////////////////////////////////
			// Recorro la lista de Jugadores del mapa para ver si la posición clickeada corresponde a la posición
			// de un Jugador en el mapa. Entonces ese Jugador podrá ser vendido.
			jugadorParaVender = null;
			deboVenderJugador = false;
			Iterator<Jugador> itJugador = m.getListaJugadores().iterator();
			boolean encontre = false;
			boolean encontrePosCelda = false;
			while(itJugador.hasNext() && !encontre)
			{
				Jugador jug = itJugador.next();
				Iterator<Celda> itCeldasJug = jug.getMisCeldas().iterator();
				while(itCeldasJug.hasNext() && !encontrePosCelda)
				{
					Celda cellJug = itCeldasJug.next();
					Posicion pJug = cellJug.getPosCelda();
					if(posClickeada.equals(pJug))
					{
						jugadorParaVender = jug;
						deboVenderJugador = true;
						encontre = true;
						encontrePosCelda = true;
					}
				}	
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