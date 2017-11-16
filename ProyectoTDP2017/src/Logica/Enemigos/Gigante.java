package Logica.Enemigos;

import javax.swing.ImageIcon;
import Logica.Celda;
import javax.swing.JLabel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.VisitorContenido.VisitorEnemigo;

/**
 * Clase Gigante
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Gigante extends Enemigo 
{

	/*
	 * Constructor
	 */
	public Gigante(Celda c, Mapa m)
	{
		mapa = m;
		miCelda = c;
		puntosVida = 3 * puntosVida;
		fuerzaImpacto = 5 * fuerzaImpacto;
		puntaje = 250;
		rangoMonedas = 275;
		
		
		cantDesplazada = 0;	// Se usará para controlar cuánto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gráfica al Gigante
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Gigante.gif"));
		mGrafico = new JLabel(imagen);	
		desplX = 0;
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();
		mGrafico.setBounds(desplX,desplY,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorEnemigo(this);
	}
	
	public void setImagenEnMovimiento()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Gigante.gif"));
		mGrafico.setIcon(imagen);
	}
	public void setImagenQuieto()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/GiganteQuieto.png"));
		mGrafico.setIcon(imagen);	
	}
	
}
