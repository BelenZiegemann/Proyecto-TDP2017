package Logica.Jugadores;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import Logica.Jugador;
import Logica.Mapa;
import Logica.*;

/**
 * Clase Inmaculado
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Inmaculado extends Jugador
{
	
	/*
	 * Constructor
	 */
	public Inmaculado(Celda c, Mapa m)
	{
		miCelda = c;
		mapa = m;
		puntosVida = 2 * puntosVida;
		fuerzaImpacto = 3 * fuerzaImpacto;
		precio = 300;

		
		//agrego la gráfica a JonSnow
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Inmaculado.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorJugador(this);
	}
	
	
}