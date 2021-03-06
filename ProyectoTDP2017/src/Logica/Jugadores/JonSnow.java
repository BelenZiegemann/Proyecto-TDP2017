package Logica.Jugadores;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import Logica.VisitorPersonaje.VisitorJugador;
import Logica.*;

/**
 * Clase JonSnow 
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class JonSnow extends Jugador
{
	
	/*
	 * Constructor
	 */
	public JonSnow(Celda c, Mapa m)
	{
		miCelda = c;
		mapa = m;
		puntosVida = 2 * puntosVida;
		fuerzaImpacto = 2 * fuerzaImpacto;
		precio = 250;
		//agrego la gr�fica a JonSnow
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/JonSnow.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
		//veo si Jon Snow ocupa mas de una celda
		misCeldas = new LinkedList<Celda>();
		controlarTama�o();
		
		proyectil = new VisitorJugador(this);
	}
}