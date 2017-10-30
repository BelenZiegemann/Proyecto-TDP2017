package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
* Clase Piedra 
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class Piedra extends ObstaculoConVida {
	protected int desplX;
	protected int desplY;
	
	public Piedra(Celda c, Mapa m) {
		vida = 400;
		miCelda = c;
		mapa = m;
	
		//agrego la gr�fica a Piedra
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/piedra.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
		estaVivo = true;
	}
	
}
