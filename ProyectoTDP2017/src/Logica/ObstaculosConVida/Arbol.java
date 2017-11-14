package Logica.ObstaculosConVida;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Celda;
import Logica.Mapa;

/**
* Clase Arbol
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class Arbol extends ObstaculoConVida 
{
	protected int desplX;
	protected int desplY;
	
	public Arbol(Celda c, Mapa m) 
	{
		vida = 250;
		miCelda = c;
		mapa = m;
		//agrego la gráfica al Árbol
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/arbol.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
	}
}