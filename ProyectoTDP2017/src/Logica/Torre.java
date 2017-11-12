package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
* Clase Torre 
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class Torre extends ObstaculoConVida 
{
	protected int desplX;
	protected int desplY;
	
	public Torre(Celda c, Mapa m) {
		vida = 500;
		miCelda = c;
		mapa = m;
		//agrego la gráfica a la Torre
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/torre.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
	}
	
}