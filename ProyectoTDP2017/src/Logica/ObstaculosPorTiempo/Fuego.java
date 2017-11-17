package Logica.ObstaculosPorTiempo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import Logica.Celda;
import Logica.Mapa;

/**
* Clase Fuego
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class Fuego extends ObstaculoPorTiempo
{
	public Fuego(Celda c, Mapa m) 
	{
		estaVivo = false; //se pone en true cuando comienza el timer
		tiempo = 8; //tiempo en segundos
		DuracionObstaculo=new Timer(tiempo * 1000 ,  new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    {   
		    	estaVivo = true;
		    } 
		}); 
		DuracionObstaculo.setRepeats(false);
		miCelda = c;
		mapa = m;
		//agrego la gráfica al Fuego
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/fuego.gif"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
		
	}

}