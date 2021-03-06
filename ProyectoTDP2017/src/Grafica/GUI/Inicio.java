package Grafica.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.applet.AudioClip;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")

/**
 * Clase Inicio
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class Inicio extends JFrame
{

	private static Inicio frame;
	private JLabel Image = new JLabel("");
	private JButton btnJugar = new JButton("");
	private AudioClip sonido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{

		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() 
	{	
		//ventana
		setResizable(false);
		setTitle("GAME OF THRONES");
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 500,410); // (x,y,ancho,alto) 
		setLocationRelativeTo(null); // para que la ventana se abra en el centro de la pantalla
		getContentPane().setLayout(null);
		
		//sonido para el inicio
		sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Game-of-Thrones-Inicio.wav"));
		sonido.play();
		
		//im�gen de fondo
		Image.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/Fondo.gif")));
		Image.setBounds(0, 0, 500, 300);
		getContentPane().add(Image);
		
		//bot�n Jugar
		btnJugar.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/Boton.png")));
		btnJugar.setBackground(Color.BLACK);
		btnJugar.setBounds(149,300,202,61);
		getContentPane().add(btnJugar);
		
		btnJugar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sonido.stop();
				frame.setVisible(false);
				
				EventQueue.invokeLater(new Runnable() 
				{
					public void run() 
					{
						try 
						{
							GUI frame = new GUI();
							frame.setVisible(true);	
							dispose();
						} 
						catch (Exception e)
						{
							e.printStackTrace();
						}
						
						
					}
				});
			}
		});
	
	}
}