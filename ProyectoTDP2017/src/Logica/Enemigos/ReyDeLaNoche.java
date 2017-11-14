package Logica.Enemigos;

import javax.swing.ImageIcon;
import Logica.Celda;
import javax.swing.JLabel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.Visitor.VisitorEnemigo;

/**
 * Clase ReyDeLaNoche
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class ReyDeLaNoche extends Enemigo 
{

	/*
	 * Constructor
	 */
	public ReyDeLaNoche(Celda c, Mapa m)
	{
		mapa = m;
		miCelda = c;
		puntosVida = 4 * puntosVida;
		fuerzaImpacto = 5 * fuerzaImpacto;
		puntaje = 550;
		rangoMonedas = 500;
		velocidad=3;
		alcance=3;
		
		cantDesplazada = 0;	// Se usará para controlar cuánto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gráfica al Rey de la Noche
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/ReyDeLaNoche.gif"));
		mGrafico = new JLabel(imagen);	
		desplX = 0;
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();
		mGrafico.setBounds(desplX,desplY,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorEnemigo(this);
	}
	
	public void setImagenEnMovimiento()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/ReyDeLaNoche.gif"));
		mGrafico.setIcon(imagen);
	}
	public void setImagenQuieto()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/ReyDeLaNocheQuieto.png"));
		mGrafico.setIcon(imagen);	
	}
}