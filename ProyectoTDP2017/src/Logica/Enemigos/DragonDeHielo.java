package Logica.Enemigos;

import javax.swing.ImageIcon;
import Logica.Celda;
import javax.swing.JLabel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.VisitorContenido.VisitorEnemigo;

/**
 * Clase DragonDeHielo
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
		alcance= 4;
		velocidad=5;
		puntaje = 1000;
		rangoMonedas = 1500;
		
		cantDesplazada = 0;	// Se usar� para controlar cu�nto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gr�fica al Drag�n de Hielo
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
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/DragonDeHieloQuieto.png"));
		mGrafico.setIcon(imagen);	
		
	}
	
}