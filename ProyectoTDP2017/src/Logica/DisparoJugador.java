package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
* Clase DisparoJugador
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class DisparoJugador extends Disparo
{
	protected int desplX;
	protected int desplY;
	public DisparoJugador(Celda c,Mapa m, Visitor bala, Contenido inicio, Contenido destino)
	{
		miCelda = c;
		proyectil = bala;
		mapa = m;
		this.inicio = inicio;
		this.destino = destino;
		
		cantDesplazada = 0;	// Se usará para controlar cuánto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		
		//agrego la gráfica al disparo del Jugador
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/balaJugador.gif"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());	
		
	}
	
	public synchronized void mover()
	{
		Posicion ubicacion = miCelda.getPosCelda();
		int miX = ubicacion.getEjeX();
		if(miX - 1 >= 0)
		{
			if(cantDesplazada >= anchoRealCelda)
			{		
				cantDesplazada = 0;
				//Se actualiza la celda a la cual pertenece el disparo del jugador
				Posicion p = new Posicion(ubicacion.getEjeX() - 1, ubicacion.getEjeY());
				//mapa.obtenerCelda(ubicacion).setContenido(null);
				//mapa.obtenerCelda(p).setContenido(this);
				miCelda = mapa.obtenerCelda(p);
			}	
			else
				cantDesplazada = cantDesplazada + 8;
	
			//muevo el JLabel que representa al Disparo del Jugador
			desplX = desplX - 8;
			mGrafico.setBounds(desplX, desplY, imagen.getIconWidth(), imagen.getIconHeight());
		}
	}
	
}
