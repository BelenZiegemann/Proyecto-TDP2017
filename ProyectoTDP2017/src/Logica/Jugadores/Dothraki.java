package Logica.Jugadores;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import Logica.Jugador;
import Logica.Mapa;
import Logica.*;

/**
 * Clase JonSnow 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Dothraki extends Jugador
{
	
	/*
	 * Constructor
	 */
	public Dothraki(Celda c, Mapa m)
	{
		miCelda = c;
		mapa = m;
		puntosVida = 2 * puntosVida;
		fuerzaImpacto = 2 * fuerzaImpacto;
		precio = 350;
		alcance = 2 * alcance;
		
		//agrego la gráfica a JonSnow
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Dothraki.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorJugador(this);
	}
	
	
}