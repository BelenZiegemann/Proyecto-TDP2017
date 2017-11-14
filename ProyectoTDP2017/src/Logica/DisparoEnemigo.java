package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
* Clase DisparoEnemigo
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class DisparoEnemigo extends Disparo
{
	protected int desplX;
	protected int desplY;
	
	public DisparoEnemigo(Celda c, Mapa m, Contenido destino)
	{
		miCelda = c;
		mapa = m;
		this.destino = destino;
		
		cantDesplazada = 0;	// Se usará para controlar cuánto se mueve el JLabel dentro del ancho real de la celda
		anchoRealCelda = mapa.obtenerAnchoReal() / mapa.obtenerAncho();	
		//agrego la gráfica al disparo del Enemigo
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/balaEnemigo.gif"));
		mGrafico = new JLabel(imagen);			
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());	
	}
	
	public void mover()
	{
		Posicion ubicacion = miCelda.getPosCelda();
		int miX = ubicacion.getEjeX();
		if(miX + 1 < mapa.obtenerAncho())
		{
		
			if(cantDesplazada >= anchoRealCelda)
			{		
				cantDesplazada = 0;
				//Se actualiza la celda a la cual pertenece el disparo del enemigo
				Posicion p = new Posicion(ubicacion.getEjeX() + 1, ubicacion.getEjeY());
				miCelda = mapa.obtenerCelda(p);
			}	
			else
				cantDesplazada = cantDesplazada + 8;
	
			//muevo el JLabel que representa al Disparo del Enemigo
			desplX = desplX + 8;
			mGrafico.setBounds(desplX, desplY, imagen.getIconWidth(), imagen.getIconHeight());
		}
	}

}
