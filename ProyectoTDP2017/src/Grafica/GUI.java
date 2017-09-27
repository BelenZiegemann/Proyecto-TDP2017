package Grafica;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
		
		
		JButton btnAgregarEnemigo = new JButton("Agregar Enemigo");
		btnAgregarEnemigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				
			
				
			}
		});
		
		btnAgregarEnemigo.setBounds(64, 11, 141, 23);
		
		getContentPane().add(btnAgregarEnemigo);
		
		
		
	}
	
}
