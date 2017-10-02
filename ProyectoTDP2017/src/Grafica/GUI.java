package Grafica;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Logica.Posicion;
import Logica.Jugadores.JonSnow;

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
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(150, 150, 640, 614);
		getContentPane().setLayout(null);
		
		//Panel para el mapa
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBounds(0,155,640,384);
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		//creo el mapa gráfico
		mapa = new gMapa(contentPane);
		
		//Botón agregar Enemigo
		JButton btnAgregarEnemigo = new JButton("Agregar Enemigo");
		btnAgregarEnemigo.setBackground(Color.RED);
		btnAgregarEnemigo.setForeground(Color.WHITE);
		btnAgregarEnemigo.setFocusPainted(false);
		btnAgregarEnemigo.setBounds(242, 552, 137, 23);
		getContentPane().add(btnAgregarEnemigo);
		
		//Oyente Botón agregar Enemigo
		btnAgregarEnemigo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				mapa.agregarEnemigo();
			}
		});
		
		//Label Puntaje
		JLabel lblPuntaje = new JLabel("Puntaje");
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setBounds(537, 19, 87, 23);
		lblPuntaje.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblPuntaje.setBackground(Color.RED);
		lblPuntaje.setForeground(Color.WHITE);
		getContentPane().add(lblPuntaje);
		
		//Label Mostrar Puntaje
		JLabel lblMostrarPuntaje = new JLabel("");
		lblMostrarPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarPuntaje.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMostrarPuntaje.setBackground(Color.LIGHT_GRAY);
		lblMostrarPuntaje.setForeground(Color.RED);
		lblMostrarPuntaje.setBounds(537, 42, 87, 23);
		getContentPane().add(lblMostrarPuntaje);	
		
		mapa.obtenerMapaLogico().obtenerPantalla().setMostrarPuntaje(lblMostrarPuntaje);
		mapa.obtenerMapaLogico().obtenerPantalla().getMostrarPuntaje().setText("" + mapa.obtenerMapaLogico().obtenerPantalla().getPuntaje());
		
		//Label Monedas
		JLabel lblMonedas = new JLabel("Monedas");
		lblMonedas.setForeground(Color.WHITE);
		lblMonedas.setBackground(Color.RED);
		lblMonedas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonedas.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMonedas.setBounds(450, 19, 81, 23);
		getContentPane().add(lblMonedas);
		
		
		//Label Mostrar Monedas
		JLabel lblMostrarMonedas = new JLabel("");
		lblMostrarMonedas.setBackground(Color.LIGHT_GRAY);
		lblMostrarMonedas.setForeground(Color.RED);
		lblMostrarMonedas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarMonedas.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMostrarMonedas.setBounds(450, 42, 81, 22);
		getContentPane().add(lblMostrarMonedas);
		
		mapa.obtenerMapaLogico().obtenerPantalla().setMostrarMonedas(lblMostrarMonedas);
		mapa.obtenerMapaLogico().obtenerPantalla().getMostrarMonedas().setText("" + mapa.obtenerMapaLogico().obtenerPantalla().getPresupuesto());
		
		//Label Jugadores
		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJugadores.setForeground(Color.WHITE);
		lblJugadores.setBackground(new Color(255, 140, 0));
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblJugadores.setBounds(10, 19, 435, 23);
		getContentPane().add(lblJugadores);
		
		//Label para elegir el jugador Jon Snow
		Icon imagenJonSnow = new ImageIcon(this.getClass().getResource("/Imagenes/JugJonSnow.jpg"));
		JButton btnJonSnow = new JButton(imagenJonSnow);
		btnJonSnow.setBorderPainted(false);
		btnJonSnow.setFocusPainted(false);
		btnJonSnow.setBounds(10, 42,imagenJonSnow.getIconWidth(), imagenJonSnow.getIconHeight());
		getContentPane().add(btnJonSnow);
		
		btnJonSnow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JonSnow j = new JonSnow(new Posicion(8,0), mapa.obtenerMapaLogico());
				mapa.agregarJugador(j);
			}
		});
		
		//Label Nivel
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBackground(Color.RED);
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblNivel.setBounds(450, 92, 174, 23);
		getContentPane().add(lblNivel);
		
		
		//Label mostrarNivel
		JLabel lblMostrarNivel = new JLabel("");
		lblMostrarNivel.setBackground(Color.LIGHT_GRAY);
		lblMostrarNivel.setForeground(Color.RED);
		lblMostrarNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarNivel.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMostrarNivel.setBounds(450, 115, 174, 23);
		getContentPane().add(lblMostrarNivel);
		
		mapa.obtenerMapaLogico().obtenerPantalla().setMostrarNivel(lblMostrarNivel);
		mapa.obtenerMapaLogico().obtenerPantalla().getMostrarNivel().setText("" + mapa.obtenerMapaLogico().obtenerPantalla().getNivel());
		
	}
}
