package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
* Clase Lago
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class Lago extends ObstaculoPorTiempo
{
	protected int desplX;
	protected int desplY;
	
	public Lago(Celda c, Mapa m) 
	{
		estaVivo = false; //se pone en true cuando comienza el timer
		
		tiempo = 4; //tiempo (en segundos)
		DuracionObstaculo.setRepeats(false);
		miCelda = c;
		mapa = m;
		//agrego la gráfica al Lago
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/lago.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
	}

}