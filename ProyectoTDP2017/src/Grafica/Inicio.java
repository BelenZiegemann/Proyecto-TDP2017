package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class Inicio extends JFrame
{

	private static Inicio frame;
	private JLabel Image = new JLabel("");
	private JButton btnJugar = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Inicio();
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
	public Inicio() 
	{
		//ventana
		setResizable(false);
		setTitle("GAME OF THRONES");
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 500,410); // (x,y,ancho,alto)
		getContentPane().setLayout(null);
		
		//imágen de fondo
		Image.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/Fondo.gif")));
		Image.setBounds(0, 0, 500, 300);
		getContentPane().add(Image);
		
		//botón Jugar
		btnJugar.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/Boton.png")));
		btnJugar.setBackground(Color.BLACK);
		btnJugar.setBounds(149,300,202,61);
		getContentPane().add(btnJugar);
		
		btnJugar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				frame.setVisible(false);
				
				EventQueue.invokeLater(new Runnable() 
				{
					public void run() 
					{
						try 
						{
							//GUI frame = new GUI();
							frame.setVisible(true);
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