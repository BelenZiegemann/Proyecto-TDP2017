package Logica.Jugadores;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import Logica.VisitorPersonaje.VisitorJugador;
import Logica.*;

/**
 * Clase Dothraki
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
		alcance = 2;
		//agrego la gr�fica a Dothraki
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Dothraki.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());	
		//veo si Dothraki ocupa mas de una celda
		misCeldas = new LinkedList<Celda>();
		controlarTama�o();
		
		proyectil = new VisitorJugador(this);
	}
	
	
}