package Grafica;


import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.Personaje;

/**
 * Clase gMapa
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class gMapa 
{
	private Mapa m;
	private ThreadPersonaje	enemigos;
	private Icon pisoNieve;
	private JPanel gui;
	protected final int anchoLabel = 8;
	protected final int altoLabel= 8;
	protected final int anchoMapa = 80;
	protected final int altoMapa= 48;
	
	
	public gMapa(JPanel gui)
	{		
		this.gui = gui;
		m = new Mapa(altoMapa,anchoMapa);
		
		//creo imagen
		pisoNieve = new ImageIcon(this.getClass().getResource("/Imagenes/PisoNieve.jpg"));
		JLabel grafPiso =  new JLabel(pisoNieve);
		grafPiso.setBounds(0,0, anchoMapa * anchoLabel, altoMapa * altoLabel);
		gui.add(grafPiso);
		
		//agrego cada personaje(enemigo) al piso del mapa
		for(Personaje p : m.getListaPersonajes())
		{
			grafPiso.add(p.getGrafico());
		}
		
		//Creo un ThreadEnemigo 
		enemigos = new ThreadPersonaje(m);
		enemigos.start();
		
	}
	
}
