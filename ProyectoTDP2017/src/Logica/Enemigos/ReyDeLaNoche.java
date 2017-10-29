package Logica.Enemigos;

import javax.swing.ImageIcon;
import Logica.Celda;
import javax.swing.JLabel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.VisitorEnemigo;

/**
 * Clase CaminanteBlanco
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
		alcance=2*alcance;
		
		cantDesplazada = 0;	// Se usar� para controlar cu�nto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gr�fica al caminante
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/camBlanco.gif"));
		mGrafico = new JLabel(imagen);	
		desplX = 0;
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();
		mGrafico.setBounds(desplX,desplY,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorEnemigo(this);
	}
	
	public void setImagenEnMovimiento()
	{
		//imagen = new ImageIcon(this.getClass().getResource("/Imagenes/camBlanco.gif"));
	//	mGrafico.setIcon(imagen);
	}
	public void setImagenQuieto()
	{
		//imagen = new ImageIcon(this.getClass().getResource("/Imagenes/camBlancoQuieto.png"));
	//	mGrafico.setIcon(imagen);	
	}
}