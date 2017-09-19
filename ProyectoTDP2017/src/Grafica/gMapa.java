package Grafica;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Enemigo;
import Logica.Mapa;

/**
 * Clase gMapa
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class gMapa 
{
	private Mapa m;
	private Thread Enemigos[];
	private Icon pisoNieve;
	private JPanel gui;
	protected final int anchoLabel = 32;
	protected final int altoLabel= 32;
	protected final int anchoMapa = 20;
	protected final int altoMapa= 12;
	
	
	public gMapa(JPanel gui)
	{		
		this.gui = gui;
		m = new Mapa(altoMapa,anchoMapa);
		
		//creo imagen
		pisoNieve = new ImageIcon(this.getClass().getResource("/Imagenes/PisoNieve.jpg"));
		JLabel grafPiso =  new JLabel(pisoNieve);
		grafPiso.setBounds(0,0, anchoMapa * anchoLabel, altoMapa * altoLabel);
		gui.add(grafPiso);
		
		//Creo un Enemigo y agrego a la GUI su gr�fico
		
		Enemigos= new Thread[2];
		
		// agrego los CaminantesBlancos en posiciones que coinciden con las que creo los
		// CaminatesBlancos en el mapa
		
		Enemigo enem[] = m.getEnemigos();

		gCaminanteBlanco caminante1 = new gCaminanteBlanco(enem[0].getPosicion().getEjeX() * 32, enem[0].getPosicion().getEjeY() * 32, enem[0]);
		Enemigos[0] = new CaminanteBlancoThread(caminante1);
		grafPiso.add(caminante1.getGrafico());
		
		
		gCaminanteBlanco caminante2 = new gCaminanteBlanco(enem[1].getPosicion().getEjeX() * 32, enem[1].getPosicion().getEjeY() * 32, enem[1]);
		Enemigos[1] = new CaminanteBlancoThread(caminante2);
		grafPiso.add(caminante2.getGrafico());
		
		Enemigos[0].start();
		Enemigos[1].start();
	}
	
	
}
