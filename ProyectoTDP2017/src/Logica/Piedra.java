package Logica;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logica.*;

public class Piedra extends ObstaculoConVida {
	protected int desplX;
	protected int desplY;
	protected Icon imagen;
	
	protected Mapa mapa;
	
	public Piedra(Celda c, Mapa m) {
		vida = 400;
		miCelda = c;
		mapa = m;
	
		//agrego la gráfica a JonSnow
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/piedra.png"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
		estaVivo = true;
	}
	
}
