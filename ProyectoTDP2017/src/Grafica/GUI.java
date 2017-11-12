package Grafica;
 
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Logica.Enemigo;
import Logica.Jugador;
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
public class GUI extends JFrame
{
	private JPanel contentPane;	
	private gMapa mapa;	

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
		setBounds(0, 0, 800, 614);
		setLocationRelativeTo(null);	// para que la ventana se abra en el centro de la pantalla
		getContentPane().setLayout(null);
		
		//Panel para el mapa
		contentPane = new JPanel();
		contentPane.setBounds(80,178,640,384);
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		//creo el mapa gráfico
		mapa = new gMapa(this);
		
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
					int precioVenta = jugParaVender.getPrecio() / 2;
					mapa.obtenerMapaLogico().obtenerPantalla().setPresupuesto(precioVenta);
					
					//elimino al jugador que es vendido
					jugParaVender.setEstaVivo(false); //para que se remueva de la lista de jugadores y del mapa.
																	//Lo hace la clase ThreadJugador
					jugParaVender.getCelda().setContenido(null);
					mapa.obtenerPisoMapa().remove(jugParaVender.getGrafico());
					mapa.obtenerPisoMapa().repaint();
					mapa.obtenerMapaLogico().getListaJugadores().remove(jugParaVender);
					
					////////////
					try
					{	
						ThreadJugador.sleep(50);
						ThreadEnemigo.sleep(50);	
					} catch (InterruptedException e) 
					{}
				
					for(Enemigo enem : mapa.obtenerMapaLogico().getListaEnemigos())
					{
						enem.setImagenEnMovimiento();
						enem.setMovimiento(true);
						enem.mover();
					}	
					//////////////
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
	
	public void mostrarMensajePerder()
	{
		JOptionPane.showMessageDialog(contentPane, "PERDISTE: HAN LLEGADO AL MURO", "GAME OF THRONES", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajeGanar()
	{
		int resp = JOptionPane.showConfirmDialog(contentPane, "GANASTE EL NIVEL: ¿SIGUIENTE NIVEL?", "GAME OF THRONES", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(resp != 1) // si la respuesta es SI
		{
			mapa.siguienteNivel();
		}
	}
}