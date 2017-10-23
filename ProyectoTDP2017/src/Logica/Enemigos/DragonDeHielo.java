package Logica.Enemigos;

import javax.swing.ImageIcon;
import Logica.Celda;
import javax.swing.JLabel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.VisitorEnemigo;

/**
 * Clase CaminanteBlanco
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class DragonDeHielo extends Enemigo 
{

	/*
	 * Constructor
	 */
	public DragonDeHielo(Celda c, Mapa m)
	{
		mapa = m;
		miCelda = c;
		puntosVida = 4 * puntosVida;
		fuerzaImpacto = 10 * fuerzaImpacto;
		alcance=4*alcance;
		velocidad=5;
		puntaje = 1000;
		rangoMonedas = 1500;
		
		cantDesplazada = 0;	// Se usará para controlar cuánto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gráfica al caminante
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/DragonDeHielo.gif"));
		mGrafico = new JLabel(imagen);	
		desplX = 0;
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();
		mGrafico.setBounds(desplX,desplY,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorEnemigo(this);
	}
	
	public void setImagenEnMovimiento()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/DragonDeHielo.gif"));
		mGrafico.setIcon(imagen);
		
	}
	public void setImagenQuieto()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/dragon1.png"));
		mGrafico.setIcon(imagen);	
		
	}
	
}