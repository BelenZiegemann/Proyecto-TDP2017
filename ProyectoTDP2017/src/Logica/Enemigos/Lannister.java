package Logica.Enemigos;

import javax.swing.ImageIcon;
import Logica.Celda;
import javax.swing.JLabel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.VisitorEnemigo;

/**
 * Clase Lannister
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Lannister extends Enemigo 
{

	/*
	 * Constructor
	 */
	public Lannister (Celda c, Mapa m)
	{
		mapa = m;
		miCelda = c;
		fuerzaImpacto = 2 * fuerzaImpacto;
		
		cantDesplazada = 0;	// Se usará para controlar cuánto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gráfica a Lannister
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Lannister.gif"));
		mGrafico = new JLabel(imagen);	
		desplX = 0;
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();
		mGrafico.setBounds(desplX,desplY,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorEnemigo(this);
	}
	
	public void setImagenEnMovimiento()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Lannister.gif"));
		mGrafico.setIcon(imagen);
	}
	public void setImagenQuieto()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/LannisterQuieto.png"));
		mGrafico.setIcon(imagen);	
	}
	
}
