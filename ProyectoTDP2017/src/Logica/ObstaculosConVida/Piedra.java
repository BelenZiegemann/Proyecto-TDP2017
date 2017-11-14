package Logica.ObstaculosConVida;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Celda;
import Logica.Mapa;

/**
* Clase Piedra 
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class Piedra extends ObstaculoConVida 
{
	protected int desplX;
	protected int desplY;
	
	public Piedra(Celda c, Mapa m) 
	{
		vida = 400;
		miCelda = c;
		mapa = m;
		//agrego la gráfica a Piedra
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/piedraConNieve.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
	}
	
}