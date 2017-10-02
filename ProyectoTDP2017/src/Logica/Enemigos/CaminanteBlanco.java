package Logica.Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Enemigo;
import Logica.Mapa;
import Logica.Posicion;

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
	public CaminanteBlanco(Posicion p,Mapa m)
	{
		ubicacion = p;
		mapa = m;
		puntosVida = 4 * puntosVida;
		fuerzaImpacto = 4 * fuerzaImpacto;
		puntaje = 400;
		rangoMonedas = 400;
		
		cantDesplazada = 0;	// Se usar� para controlar cu�nto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gr�fica al caminante
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/camBlanco.gif"));
		mGrafico = new JLabel(imagen);	
		desplX = 0;
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * ubicacion.getEjeY();
		mGrafico.setBounds(desplX,desplY,imagen.getIconWidth(),imagen.getIconHeight());	
	}
	
	
}