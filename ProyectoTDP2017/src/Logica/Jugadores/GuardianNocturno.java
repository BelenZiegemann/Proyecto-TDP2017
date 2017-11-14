package Logica.Jugadores;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import Logica.Jugador;
import Logica.Mapa;
import Logica.Visitor.VisitorJugador;
import Logica.*;

/**
 * Clase GuardianNocturno
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
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
	
		//agrego la gráfica a GuardianNocturno
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/GuardianNocturno.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());	
		proyectil = new VisitorJugador(this);
	}
	
	
}