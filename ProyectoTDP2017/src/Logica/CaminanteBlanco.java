package Logica;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase CaminanteBlanco
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
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
		
		//agrego la gráfica al caminante
		posGrafica = new Point(ubicacion.getEjeX(),ubicacion.getEjeY());
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/camBlanco.gif"));
		mGrafico = new JLabel(imagen);
		mGrafico.setBounds(ubicacion.getEjeX() * 32, ubicacion.getEjeY() * 32,ancho,alto);	
		
	}
	
	
}