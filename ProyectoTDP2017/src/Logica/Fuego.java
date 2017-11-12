package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
* Clase Fuego
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class Fuego extends ObstaculoPorTiempo
{
	protected int desplX;
	protected int desplY;
	
	public Fuego(Celda c, Mapa m) 
	{
		tiempo = 8; //tiempo en segundos
		DuracionObstaculo.setRepeats(false);
		miCelda = c;
		mapa = m;
		//agrego la gráfica al Fuego
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/fuego.gif"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
	}

}