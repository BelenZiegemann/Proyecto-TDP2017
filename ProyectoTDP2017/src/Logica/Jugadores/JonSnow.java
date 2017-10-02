package Logica.Jugadores;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Jugador;
import Logica.Mapa;
import Logica.Posicion;

/**
 * Clase JonSnow 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class JonSnow extends Jugador
{
	
	/*
	 * Constructor
	 */
	public JonSnow(Posicion p, Mapa m)
	{
		ubicacion = p;
		mapa = m;
		puntosVida = 2 * puntosVida;
		fuerzaImpacto = 2 * fuerzaImpacto;
		precio = 250;
		
		//agrego la gráfica a JonSnow
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/JonSnow.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * ubicacion.getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * ubicacion.getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());		
	}
	
	public void mover()
	{
	
		
	}
	
	
}