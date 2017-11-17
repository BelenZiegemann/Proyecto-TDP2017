package Logica.Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Celda;
import Logica.Contenido;
import Logica.Mapa;
import Logica.Posicion;

/**
* Clase DisparoJugador
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class DisparoJugador extends Disparo
{
	protected int desplX;
	protected int desplY;
	public DisparoJugador(Celda c,Mapa m, Contenido destino)
	{
		miCelda = c;
		mapa = m;
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
	
	public void mover()
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