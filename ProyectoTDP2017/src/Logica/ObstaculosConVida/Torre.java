package Logica.ObstaculosConVida;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Celda;
import Logica.Mapa;

/**
* Clase Torre 
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class Torre extends ObstaculoConVida 
{
	
	public Torre(Celda c, Mapa m) {
		vida = 500;
		miCelda = c;
		mapa = m;
		//agrego la gr�fica a la Torre
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/torre.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
	}
	
}