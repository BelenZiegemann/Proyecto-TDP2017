package Logica.Enemigos;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import Logica.Celda;
import javax.swing.JLabel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.VisitorPersonaje.VisitorEnemigo;

/**
 * Clase CaminanteBlanco
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class CaminanteBlanco extends Enemigo 
{

	/*
	 * Constructor
	 */
	public CaminanteBlanco(Celda c, Mapa m)
	{
		mapa = m;
		miCelda = c;
		puntosVida = 4 * puntosVida;
		fuerzaImpacto = 2 * fuerzaImpacto;
		puntaje = 400;
		rangoMonedas = 400;
		cantDesplazada = 0;	// Se usar� para controlar cu�nto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gr�fica al caminante
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/camBlanco.gif"));
		mGrafico = new JLabel(imagen);	
		desplX = 0;
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();
		mGrafico.setBounds(desplX,desplY,imagen.getIconWidth(),imagen.getIconHeight());	
		//veo si el caminante ocupa mas de una celda
		misCeldas = new LinkedList<Celda>();
		controlarTama�o();
		//agrego proyectil
		proyectil = new VisitorEnemigo(this);
	}
	public void setImagenEnMovimiento()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/camBlanco.gif"));
		mGrafico.setIcon(imagen);
	}
	public void setImagenQuieto()
	{
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/camBlancoQuieto.png"));
		mGrafico.setIcon(imagen);	
	}
	
}