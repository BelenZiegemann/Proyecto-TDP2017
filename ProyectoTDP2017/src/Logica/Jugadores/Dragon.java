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
public class Dragon extends Jugador
{
	
	/*
	 * Constructor
	 */
	public Dragon(Celda c, Mapa m)
	{
		miCelda = c;
		mapa = m;
		puntosVida = 4 * puntosVida;
		fuerzaImpacto = 7 * fuerzaImpacto;
		precio = 2000;
		alcance=4*alcance;
		
		//agrego la gráfica a Dragon
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Dragon.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorJugador(this);
		
	}
}
