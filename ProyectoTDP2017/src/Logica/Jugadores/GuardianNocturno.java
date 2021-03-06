package Logica.Jugadores;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import Logica.VisitorPersonaje.VisitorJugador;
import Logica.*;

/**
 * Clase GuardianNocturno
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class GuardianNocturno extends Jugador
{
	
	/*
	 * Constructor
	 */
	public GuardianNocturno(Celda c, Mapa m)
	{
		miCelda = c;
		mapa = m;
		fuerzaImpacto = 2 * fuerzaImpacto;
		//agrego la gr�fica a GuardianNocturno
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/GuardianNocturno.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());	
		//veo si el Guardi�n Nocturno ocupa mas de una celda
		misCeldas = new LinkedList<Celda>();
		controlarTama�o();
		
		proyectil = new VisitorJugador(this);
	}	
}