package Grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import Logica.Mapa;


/**
 * Clase gMapa
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class gMapa 
{
	protected Mapa m;
	protected ThreadPersonaje enemigos;
	protected Icon pisoNieve;
	protected JPanel gui;
	protected JLabel grafPiso;
	protected final int anchoLabel = 64;
	protected final int altoLabel= 64;
	protected final int anchoMapa = 10;
	protected final int altoMapa = 6;
	
	
	public gMapa(JPanel gui)
	{		
		this.gui = gui;
		m = new Mapa(altoMapa,anchoMapa);
		
		//Creo imagen
		pisoNieve = new ImageIcon(this.getClass().getResource("/Imagenes/PisoNieve.jpg"));
		grafPiso =  new JLabel(pisoNieve);
		grafPiso.setBounds(0,0, anchoMapa * anchoLabel, altoMapa * altoLabel);
		gui.add(grafPiso);
		
		//Creo un ThreadEnemigo 
		enemigos = new ThreadPersonaje(m);
		enemigos.start();	
	}
	
	public void agregarEnemigo()
	{
		JLabel grafEnemigo = m.agregarEnemigo();
		if(grafEnemigo != null)
			grafPiso.add(grafEnemigo);
	}
	
}