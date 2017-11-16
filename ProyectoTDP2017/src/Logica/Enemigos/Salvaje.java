
package Logica.Enemigos;

import javax.swing.ImageIcon;
import Logica.Celda;
import javax.swing.JLabel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.VisitorContenido.VisitorEnemigo;

/**
 * Clase Salvaje
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Salvaje extends Enemigo 
{

	/*
	 * Constructor
	 */
	public Salvaje(Celda c, Mapa m)
	{
		mapa = m;
		miCelda = c;
		puntosVida = 2 * puntosVida;
		fuerzaImpacto = 3 * fuerzaImpacto;
		puntaje = 150;
		rangoMonedas = 225;
		velocidad=3;
		
		cantDesplazada = 0;	// Se usará para controlar cuánto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gráfica al salvaje
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Salvaje.gif"));
		mGrafico = new JLabel(imagen);	
		desplX = 0;
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();
		mGrafico.setBounds(desplX,desplY,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorEnemigo(this);
	}
	
	public void setImagenEnMovimiento()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Salvaje.gif"));
		mGrafico.setIcon(imagen);
	}
	public void setImagenQuieto()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/SalvajeQuieto.png"));
		mGrafico.setIcon(imagen);	
	}
}