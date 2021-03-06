package Logica.Jugadores;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import Logica.VisitorPersonaje.VisitorJugador;
import Logica.*;

/**
 * Clase Dragon
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
		//agrego la gr�fica a Dragon
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Dragon.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
		//veo si el Drag�n ocupa mas de una celda
		misCeldas = new LinkedList<Celda>();
		controlarTama�o();
		
		proyectil = new VisitorJugador(this);
	}
}
