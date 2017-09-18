package Grafica;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
/**
 * Clase GUI
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
		setTitle("GAME OF THRONES");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(150, 150, 640, 434);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0,50,640,384);
		contentPane.setLayout(null);
		//setContentPane(contentPane);
		getContentPane().add(contentPane);
		
		mapa = new gMapa(contentPane);
		
	}
}
