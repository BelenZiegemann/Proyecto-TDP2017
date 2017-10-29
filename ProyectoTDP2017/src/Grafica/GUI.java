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
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 800, 614);
		setLocationRelativeTo(null);	// para que la ventana se abra en el centro de la pantalla
		getContentPane().setLayout(null);

		
		//Panel para el mapa
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBounds(80,155,640,384);
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		//creo el mapa gráfico
		mapa = new gMapa(contentPane);
	
		//Botón agregar Enemigo
		JButton btnAgregarEnemigo = new JButton("Agregar Enemigo");
		btnAgregarEnemigo.setBackground(Color.RED);
		btnAgregarEnemigo.setForeground(Color.WHITE);
		btnAgregarEnemigo.setFocusPainted(false);
		btnAgregarEnemigo.setBounds(322, 552, 137, 23);
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
		lblPuntaje.setBounds(642, 19, 87, 23);
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
		lblMostrarPuntaje.setBounds(642, 42, 87, 23);
		getContentPane().add(lblMostrarPuntaje);	
		
		mapa.obtenerMapaLogico().obtenerPantalla().setMostrarPuntaje(lblMostrarPuntaje);
		mapa.obtenerMapaLogico().obtenerPantalla().getMostrarPuntaje().setText("" + mapa.obtenerMapaLogico().obtenerPantalla().getPuntaje());
		
		//Label Monedas
		JLabel lblMonedas = new JLabel("Monedas");
		lblMonedas.setForeground(Color.WHITE);
		lblMonedas.setBackground(Color.RED);
		lblMonedas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonedas.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMonedas.setBounds(555, 19, 81, 23);
		getContentPane().add(lblMonedas);
		
		//Label Mostrar Monedas
		JLabel lblMostrarMonedas = new JLabel("");
		lblMostrarMonedas.setBackground(Color.LIGHT_GRAY);
		lblMostrarMonedas.setForeground(Color.RED);
		lblMostrarMonedas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarMonedas.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMostrarMonedas.setBounds(555, 42, 81, 22);
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
		lblJugadores.setBounds(71, 19, 480, 23);
		getContentPane().add(lblJugadores);
		
		//Label para elegir al jugador Jon Snow
		Icon imagenJonSnow = new ImageIcon(this.getClass().getResource("/Imagenes/JugJonSnow.jpg"));
		JButton btnJonSnow = new JButton(imagenJonSnow);
		btnJonSnow.setBorderPainted(false);
		btnJonSnow.setFocusPainted(false);
		btnJonSnow.setBounds(71, 42,imagenJonSnow.getIconWidth(), imagenJonSnow.getIconHeight());
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
		
		//Label para elegir al jugador Guardián Nocturno
		Icon imagenGNocturno = new ImageIcon(this.getClass().getResource("/Imagenes/JugGNocturno.jpg"));
		JButton btnGNocturno = new JButton(imagenGNocturno);
		btnGNocturno.setBorderPainted(false);
		btnGNocturno.setFocusPainted(false);
		btnGNocturno.setBounds(167, 42,imagenGNocturno.getIconWidth(),imagenGNocturno.getIconHeight());
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
		
		//Label para elegir al jugador Inmaculado
		Icon imagenInmaculado = new ImageIcon(this.getClass().getResource("/Imagenes/JugInmaculado.jpg"));
		JButton btnInmaculado = new JButton(imagenInmaculado);
		btnInmaculado.setBorderPainted(false);
		btnInmaculado.setFocusPainted(false);
		btnInmaculado.setBounds(263, 42,imagenInmaculado.getIconWidth(),imagenInmaculado.getIconHeight());
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
		
		//Label para elegir al jugador Dothraki
		Icon imagenDothraki = new ImageIcon(this.getClass().getResource("/Imagenes/JugDothraki.jpg"));
		JButton btnDothraki = new JButton(imagenDothraki);
		btnDothraki.setBorderPainted(false);
		btnDothraki.setFocusPainted(false);
		btnDothraki.setBounds(359, 42,imagenDothraki.getIconWidth(),imagenDothraki.getIconHeight());
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
		
		//Label para elegir al jugador Dragon
		Icon imagenDragon = new ImageIcon(this.getClass().getResource("/Imagenes/JugDragon.jpg"));
		JButton btnDragon = new JButton(imagenDragon);
		btnDragon.setBorderPainted(false);
		btnDragon.setFocusPainted(false);
		btnDragon.setBounds(455, 42,imagenDragon.getIconWidth(),imagenDragon.getIconHeight());
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
		
		//Label Nivel
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBackground(Color.RED);
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblNivel.setBounds(555, 92, 174, 23);
		getContentPane().add(lblNivel);
		
		//Label mostrarNivel
		JLabel lblMostrarNivel = new JLabel("");
		lblMostrarNivel.setBackground(Color.LIGHT_GRAY);
		lblMostrarNivel.setForeground(Color.RED);
		lblMostrarNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarNivel.setOpaque(true);	//lo debo poner para que se muestre el color de fondo del JLabel
		lblMostrarNivel.setBounds(555, 115, 174, 23);
		getContentPane().add(lblMostrarNivel);
		
		mapa.obtenerMapaLogico().obtenerPantalla().setMostrarNivel(lblMostrarNivel);
		mapa.obtenerMapaLogico().obtenerPantalla().getMostrarNivel().setText("" + mapa.obtenerMapaLogico().obtenerPantalla().getNivel());
		
	}
	
}
