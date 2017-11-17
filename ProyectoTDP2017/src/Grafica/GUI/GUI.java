package Grafica.GUI;
 
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.ActionEvent;


import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Grafica.GUI.gMapa;
import Logica.Contenido;
import Logica.Enemigo;
import Logica.Jugador;
import Logica.Posicion;
import Logica.PowerUp;
import Logica.CreadorJugador.CreadorDothraki;
import Logica.CreadorJugador.CreadorDragon;
import Logica.CreadorJugador.CreadorGuardianNocturno;
import Logica.CreadorJugador.CreadorInmaculado;
import Logica.CreadorJugador.CreadorJonSnow;
import Logica.CreadorJugador.CreadorJugador;
import java.awt.Font;


@SuppressWarnings("serial")
/**
 * Clase GUI
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class GUI extends JFrame implements MouseListener
{
	private JPanel contentPane;	
	private gMapa mapa;	
	private JLabel lblMensajePU = new JLabel(" ");
	private LinkedList<PowerUp> objetosPreciosos = new LinkedList<PowerUp>();
	private	JLabel lblbomba= new JLabel("Bombas");
	private JButton btnbomba= new JButton();
	private	JLabel lblcantbombas = new JLabel("Cantidad");
	private JLabel lblmostrarcantbombas = new JLabel("0");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI()
	{
		setForeground(Color.BLACK);
		setTitle("GAME OF THRONES");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1020, 614);
		setLocationRelativeTo(null);	// para que la ventana se abra en el centro de la pantalla
		getContentPane().setLayout(null);
		
		//Panel para el mapa
		contentPane = new JPanel();
		contentPane.setBounds(80,178,640,384);
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		//creo el mapa gráfico
		mapa = new gMapa(this);
		
		//Label para powerup (magia temporal)
		JLabel lblMagiaTemp = new JLabel("Estado de Magia");
		lblMagiaTemp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMagiaTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagiaTemp.setBounds(762, 178 , 240, 30);
		lblMagiaTemp.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMagiaTemp.setBackground(Color.ORANGE);
		lblMagiaTemp.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblMagiaTemp);
		
		//Label mensaje powerup
		lblMensajePU.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMensajePU.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajePU.setBounds(762, 208 , 240, 30);
		lblMensajePU.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMensajePU.setBackground(Color.DARK_GRAY);
		lblMensajePU.setForeground(Color.RED);
		getContentPane().add(lblMensajePU);
		
		//Label bomba
		lblbomba.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblbomba.setHorizontalAlignment(SwingConstants.CENTER);
		lblbomba.setBounds(807, 248 , 150, 30);
		lblbomba.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblbomba.setBackground(Color.ORANGE);
		lblbomba.setForeground(Color.DARK_GRAY);
		lblbomba.setVisible(false);
		getContentPane().add(lblbomba);
		
		//JButton bomba
		Icon imagenbtnBomba = new ImageIcon(this.getClass().getResource("/Imagenes/botonBomba.png"));
		btnbomba.setIcon(imagenbtnBomba);
		btnbomba.setBounds(807, 278 , imagenbtnBomba.getIconWidth(), imagenbtnBomba.getIconHeight());
		btnbomba.setFocusPainted(false);
		btnbomba.setVisible(false);
		getContentPane().add(btnbomba);
		btnbomba.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				mapa.DeboColocarBomba(true);
			}
		});

		//Label cantidad de bombas
		lblcantbombas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcantbombas.setHorizontalAlignment(SwingConstants.CENTER);
		lblcantbombas.setBounds(882, 278 , 75, 38);
		lblcantbombas.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblcantbombas.setBackground(Color.DARK_GRAY);
		lblcantbombas.setForeground(Color.ORANGE);
		lblcantbombas.setVisible(false);
		getContentPane().add(lblcantbombas);
		
		//Label mostrar cantidad de bombas
		lblmostrarcantbombas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmostrarcantbombas.setHorizontalAlignment(SwingConstants.CENTER);
		lblmostrarcantbombas.setBounds(882, 316 , 75, 38);
		lblmostrarcantbombas.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblmostrarcantbombas.setBackground(Color.WHITE);
		lblmostrarcantbombas.setForeground(Color.DARK_GRAY);
		lblmostrarcantbombas.setVisible(false);;
		getContentPane().add(lblmostrarcantbombas);
		
		//Label Puntaje
		JLabel lblPuntaje = new JLabel("Puntaje");
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setBounds(642, 19, 87, 23);
		lblPuntaje.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblPuntaje.setBackground(Color.RED);
		lblPuntaje.setForeground(Color.WHITE);
		getContentPane().add(lblPuntaje);
		
		//Label Mostrar Puntaje
		JLabel lblMostrarPuntaje = new JLabel("");
		lblMostrarPuntaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMostrarPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarPuntaje.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMostrarPuntaje.setBackground(Color.LIGHT_GRAY);
		lblMostrarPuntaje.setForeground(Color.RED);
		lblMostrarPuntaje.setBounds(642, 42, 87, 23);
		getContentPane().add(lblMostrarPuntaje);	
		
		mapa.obtenerMapaLogico().obtenerPantalla().setMostrarPuntaje(lblMostrarPuntaje);
		mapa.obtenerMapaLogico().obtenerPantalla().getMostrarPuntaje().setText("" + mapa.obtenerMapaLogico().obtenerPantalla().getPuntaje());
		
		//Label Monedas
		JLabel lblMonedas = new JLabel("Monedas");
		lblMonedas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMonedas.setForeground(Color.WHITE);
		lblMonedas.setBackground(Color.RED);
		lblMonedas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonedas.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMonedas.setBounds(555, 19, 81, 23);
		getContentPane().add(lblMonedas);
		
		//Label Mostrar Monedas
		JLabel lblMostrarMonedas = new JLabel("");
		lblMostrarMonedas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMostrarMonedas.setBackground(Color.LIGHT_GRAY);
		lblMostrarMonedas.setForeground(Color.RED);
		lblMostrarMonedas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarMonedas.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMostrarMonedas.setBounds(555, 42, 81, 22);
		getContentPane().add(lblMostrarMonedas);
		
		mapa.obtenerMapaLogico().obtenerPantalla().setMostrarMonedas(lblMostrarMonedas);
		mapa.obtenerMapaLogico().obtenerPantalla().getMostrarMonedas().setText("" + mapa.obtenerMapaLogico().obtenerPantalla().getPresupuesto());
		
		//Label Nivel
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNivel.setBackground(Color.RED);
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblNivel.setBounds(555, 69, 174, 23);
		getContentPane().add(lblNivel);
				
		//Label mostrarNivel
		JLabel lblMostrarNivel = new JLabel("");
		lblMostrarNivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMostrarNivel.setBackground(Color.LIGHT_GRAY);
		lblMostrarNivel.setForeground(Color.RED);
		lblMostrarNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarNivel.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMostrarNivel.setBounds(555, 92, 174, 23);
		getContentPane().add(lblMostrarNivel);
				
		mapa.obtenerMapaLogico().obtenerPantalla().setMostrarNivel(lblMostrarNivel);
		mapa.obtenerMapaLogico().obtenerPantalla().getMostrarNivel().setText("" + mapa.obtenerMapaLogico().obtenerPantalla().getNivel());
		
		//Botón Vender Jugador
		JButton btnVenderJugador = new JButton("Vender Jugador");
		btnVenderJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVenderJugador.setBackground(new Color(255, 0, 0));
		btnVenderJugador.setForeground(new Color(0, 255, 0));
		btnVenderJugador.setFocusPainted(false);
		btnVenderJugador.setBounds(555, 120, 174, 40);
		getContentPane().add(btnVenderJugador);
		btnVenderJugador.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(mapa.deboVenderJugador())
				{	
					Jugador jugParaVender = mapa.getJugadorParaVender();
					if(jugParaVender.estaVivo())
					{
						int precioVenta = jugParaVender.getPrecio() / 2;
						mapa.obtenerMapaLogico().obtenerPantalla().setPresupuesto(precioVenta);
						//elimino al jugador que es vendido
						jugParaVender.setEstaVivo(false); //para que se remueva de la lista de jugadores y del mapa.
																	//Lo hace la clase ThreadJugador
						jugParaVender.getCelda().setContenido(null);
						mapa.obtenerPisoMapa().remove(jugParaVender.getGrafico());
						mapa.obtenerPisoMapa().repaint();
						mapa.obtenerMapaLogico().getListaJugadores().remove(jugParaVender);
					
						// lo hago porque debo actualizar el movimiento de algún enemigo que lo estaba atacando
						Posicion posJugVenta = jugParaVender.getCelda().getPosCelda();
						int posjugX = posJugVenta.getEjeX();
						int posjugY = posJugVenta.getEjeY();
						for(int i = 1; i<= jugParaVender.getAlcance();i++)
						{
							if((posjugX - i) >= 0)
							{
								Posicion pos = new Posicion(posjugX-i,posjugY);
								Contenido c  = mapa.obtenerMapaLogico().obtenerCelda(pos).getContenido();
								if(c != null)
								{
									Iterator<Enemigo> itEnem = mapa.obtenerMapaLogico().getListaEnemigos().iterator();
									boolean encontre = false;
									while(itEnem.hasNext() && !encontre)
									{
										Enemigo enem = itEnem.next();
										Posicion pEnem = enem.getCelda().getPosCelda();
										if(pEnem.equals(pos))
										{
											enem.setImagenEnMovimiento();
											enem.setMovimiento(true);
											enem.mover();
											encontre = true;
										}
									
									}
								
								}
							}
						}
					}	
					mapa.setDeboVenderJugador(false);
				}		
			}
		});
	
		//Label Jugadores
		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJugadores.setForeground(Color.WHITE);
		lblJugadores.setBackground(new Color(255, 140, 0));
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblJugadores.setBounds(71, 19, 480, 23);
		getContentPane().add(lblJugadores);
		
		//Label precio Guardián Nocturno
		JLabel lblPrecioGNocturno = new JLabel("125");
		lblPrecioGNocturno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioGNocturno.setForeground(new Color(255,140,0));
		lblPrecioGNocturno.setBackground(Color.WHITE);
		lblPrecioGNocturno.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioGNocturno.setOpaque(true);
		lblPrecioGNocturno.setBounds(71, 42, 96, 23);
		getContentPane().add(lblPrecioGNocturno);
				
		//Label para elegir al jugador Guardián Nocturno
		Icon imagenGNocturno = new ImageIcon(this.getClass().getResource("/Imagenes/JugGNocturno.jpg"));
		JButton btnGNocturno = new JButton(imagenGNocturno);
		btnGNocturno.setBorderPainted(false);
		btnGNocturno.setFocusPainted(false);
		btnGNocturno.setToolTipText("-GUARDIÁN NOCTURNO- Puntos de vida = 100; Alcance = 1; Fuerza de impacto = 20");
		btnGNocturno.setBounds(71, 65,imagenGNocturno.getIconWidth(),imagenGNocturno.getIconHeight());
		getContentPane().add(btnGNocturno);	
		btnGNocturno.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				CreadorJugador cj = new CreadorGuardianNocturno();
				mapa.setJugadorParaAgregar(cj);
				mapa.DeboAgregarJugador(true);
			}
		});
		
		//Label precio Jon Snow
		JLabel lblPrecioJonSnow = new JLabel("250");
		lblPrecioJonSnow.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioJonSnow.setForeground(new Color(255,140,0));
		lblPrecioJonSnow.setBackground(Color.WHITE);
		lblPrecioJonSnow.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioJonSnow.setOpaque(true);
		lblPrecioJonSnow.setBounds(167,42, 96,23);
		getContentPane().add(lblPrecioJonSnow);
		
		//Label para elegir al jugador Jon Snow
		Icon imagenJonSnow = new ImageIcon(this.getClass().getResource("/Imagenes/JugJonSnow.jpg"));
		JButton btnJonSnow = new JButton(imagenJonSnow);
		btnJonSnow.setBorderPainted(false);
		btnJonSnow.setFocusPainted(false);
		btnJonSnow.setToolTipText("-JON SNOW- Puntos de vida = 200; Alcance = 1; Fuerza de impacto = 20");
		btnJonSnow.setBounds(167, 65, imagenJonSnow.getIconWidth(), imagenJonSnow.getIconHeight());
		getContentPane().add(btnJonSnow);
		btnJonSnow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				CreadorJugador cj = new CreadorJonSnow();
				mapa.setJugadorParaAgregar(cj);
				mapa.DeboAgregarJugador(true);
			}
		});
	
		//Label precio Inmaculado
		JLabel lblPrecioInmaculado = new JLabel("300");
		lblPrecioInmaculado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioInmaculado.setForeground(new Color(255,140,0));
		lblPrecioInmaculado.setBackground(Color.WHITE);
		lblPrecioInmaculado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioInmaculado.setOpaque(true);
		lblPrecioInmaculado.setBounds(263,42, 96,23);
		getContentPane().add(lblPrecioInmaculado);
		
		//Label para elegir al jugador Inmaculado
		Icon imagenInmaculado = new ImageIcon(this.getClass().getResource("/Imagenes/JugInmaculado.jpg"));
		JButton btnInmaculado = new JButton(imagenInmaculado);
		btnInmaculado.setBorderPainted(false);
		btnInmaculado.setFocusPainted(false);
		btnInmaculado.setToolTipText("-INMACULADO- Puntos de vida = 200; Alcance = 1; Fuerza de impacto = 30");
		btnInmaculado.setBounds(263, 65,imagenInmaculado.getIconWidth(),imagenInmaculado.getIconHeight());
		getContentPane().add(btnInmaculado);	
		btnInmaculado.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				CreadorJugador cj = new CreadorInmaculado();
				mapa.setJugadorParaAgregar(cj);
				mapa.DeboAgregarJugador(true);
			}
		});
		
		//Label precio Dothraki
		JLabel lblPrecioDothraki = new JLabel("350");
		lblPrecioDothraki.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioDothraki.setForeground(new Color(255,140,0));
		lblPrecioDothraki.setBackground(Color.WHITE);
		lblPrecioDothraki.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioDothraki.setOpaque(true);
		lblPrecioDothraki.setBounds(359,42, 96,23);
		getContentPane().add(lblPrecioDothraki);
		
		//Label para elegir al jugador Dothraki
		Icon imagenDothraki = new ImageIcon(this.getClass().getResource("/Imagenes/JugDothraki.jpg"));
		JButton btnDothraki = new JButton(imagenDothraki);
		btnDothraki.setBorderPainted(false);
		btnDothraki.setFocusPainted(false);
		btnDothraki.setToolTipText("-DOTHRAKI- Puntos de vida = 200; Alcance = 2; Fuerza de impacto = 20");
		btnDothraki.setBounds(359, 65,imagenDothraki.getIconWidth(),imagenDothraki.getIconHeight());
		getContentPane().add(btnDothraki);		
		btnDothraki.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				CreadorJugador cj = new CreadorDothraki();
				mapa.setJugadorParaAgregar(cj);
				mapa.DeboAgregarJugador(true);
			}
		});
		
		//Label precio Dragón
		JLabel lblPrecioDragon = new JLabel("2000");
		lblPrecioDragon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioDragon.setForeground(new Color(255,140,0));
		lblPrecioDragon.setBackground(Color.WHITE);
		lblPrecioDragon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioDragon.setOpaque(true);
		lblPrecioDragon.setBounds(455,42, 96,23);
		getContentPane().add(lblPrecioDragon);
		
		//Label para elegir al jugador Dragon
		Icon imagenDragon = new ImageIcon(this.getClass().getResource("/Imagenes/JugDragon.jpg"));
		JButton btnDragon = new JButton(imagenDragon);
		btnDragon.setBorderPainted(false);
		btnDragon.setFocusPainted(false);
		btnDragon.setToolTipText("-DRAGÓN- Puntos de vida = 400; Alcance = 4; Fuerza de impacto = 70");
		btnDragon.setBounds(455, 65,imagenDragon.getIconWidth(),imagenDragon.getIconHeight());
		getContentPane().add(btnDragon);	
		btnDragon.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				CreadorJugador cj = new CreadorDragon();
				mapa.setJugadorParaAgregar(cj);
				mapa.DeboAgregarJugador(true);
			}
		});
		
		//Muro
		ImageIcon imagenMuro = new ImageIcon(this.getClass().getResource("/Imagenes/muro.jpg"));
		JLabel labelMuro = new JLabel(imagenMuro);
		labelMuro.setSize(imagenMuro.getIconWidth(), imagenMuro.getIconHeight());
		JPanel panelMuro = new JPanel();
		panelMuro.setBounds(contentPane.getX() + contentPane.getWidth(), contentPane.getY(), labelMuro.getWidth(), labelMuro.getHeight());
		panelMuro.setLayout(null);
		panelMuro.add(labelMuro);
		getContentPane().add(panelMuro);
		
		//Fondo para la GUI
		ImageIcon imagenFondo = new ImageIcon(this.getClass().getResource("/Imagenes/fondoGUI1.jpg"));
		JLabel labelFondo = new JLabel(imagenFondo);
		labelFondo.setSize(getWidth(), getHeight());
		JPanel panelFondo = new JPanel();
		panelFondo.setSize(getWidth(), getHeight());
		panelFondo.setLayout(null);
		panelFondo.add(labelFondo);
		getContentPane().add(panelFondo);
		
	}
	
	public JPanel getPanelMapa()
	{
		return contentPane;
	}
	
	public void mostrarSiguienteNivel()
	{
		int resp = JOptionPane.showConfirmDialog(contentPane, "GANASTE EL NIVEL: ¿SIGUIENTE NIVEL?", "GAME OF THRONES", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(resp != 1) // si la respuesta es SI
			mapa.siguienteNivel();
		else
		{	
			mapa.detener();
		}
	}
	
	public void mostrarMensajePU(String mensaje)
	{
		lblMensajePU.setText(mensaje); 
	}
	
	public void agregarObjetoPrecioso(PowerUp op)
	{
		objetosPreciosos.addLast(op);
	}
	
	public PowerUp eliminarBomba()
	{
		PowerUp eliminado = null;
		int cantBomb = objetosPreciosos.size();
		if(cantBomb >= 1)
		{
			if(cantBomb == 1)	
			{
				lblbomba.setVisible(false);
				btnbomba.setVisible(false);
				lblcantbombas.setVisible(false);
				lblmostrarcantbombas.setVisible(false);
			}
			else
			{
				lblmostrarcantbombas.setText("" + (objetosPreciosos.size()-1));
			}
			eliminado = objetosPreciosos.removeLast();
		}
		return eliminado; 	
	}
	
	public void mouseClicked(java.awt.event.MouseEvent arg0)
	{ 	
		if(objetosPreciosos.size() > 0)
		{
			PowerUp opUltimo = objetosPreciosos.getLast();
			if(opUltimo.getVisitor() == null)
			{
				//si es un huevo de Dragón
				//agrego 2000 monedas al presupuesto 
				mapa.obtenerMapaLogico().obtenerPantalla().setPresupuesto(2000);
				//elimino del piso del mapa
				mapa.obtenerPisoMapa().remove(opUltimo.getGrafico());
				mapa.obtenerPisoMapa().repaint();
				//elimino de la lista de objetos preciosos
				objetosPreciosos.removeLast();
			}
			else
			{
				//si es una bomba
				lblbomba.setVisible(true);
				btnbomba.setVisible(true);
				lblcantbombas.setVisible(true);
				lblmostrarcantbombas.setVisible(true);
				lblmostrarcantbombas.setText("" + objetosPreciosos.size());
				//elimino del piso del mapa
				mapa.obtenerPisoMapa().remove(opUltimo.getGrafico());
				mapa.obtenerPisoMapa().repaint();
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