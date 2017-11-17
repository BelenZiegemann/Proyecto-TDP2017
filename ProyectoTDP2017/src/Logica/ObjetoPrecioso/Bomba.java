package Logica.ObjetoPrecioso;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logica.Celda;
import Logica.Contenido;
import Logica.Mapa;
import Logica.Posicion;
import Logica.PowerUp;
import Logica.VisitorPowerUp.VisitorBomba;

/**
* Clase Bomba
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class Bomba extends ObjetoPrecioso
{
	protected int alcance;
	protected int tiempo;
	
	public Bomba(Celda c, Mapa m)
	{
		super();
		visitorPU = new VisitorBomba(this);
		miCelda = c;
		mapa = m;
		alcance = 2;
		tiempo = 3; //delay antes de explotar
		timer.setInitialDelay(tiempo * 1000);
		//agrego la gráfica a la bomba
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/bomba.png"));
		mGrafico = new JLabel(imagen);
		actualizarPosGrafico();
	}
	
	public void accionFinTimer() 
	{	
		explotar();
	}

	public void explotar()
	{
		Icon imagenExplosion = new ImageIcon(this.getClass().getResource("/Imagenes/bombaExplosion.gif"));
	
		mGrafico.setIcon(imagenExplosion);
		mapa.agregarAExplosion(mGrafico);
		
		int miX = miCelda.getPosCelda().getEjeX();
		int miY = miCelda.getPosCelda().getEjeY();
		
		int inicioX = miX - alcance;
		if(inicioX < 0)
			inicioX = 0;
		int finX = miX + alcance;
		if(finX >= mapa.obtenerAncho())
			finX = mapa.obtenerAncho() - 1;
		int inicioY = miY - alcance;
		if(inicioY < 0)
			inicioY = 0;
		int finY = miY + alcance;
		if(finY >= mapa.obtenerAlto())
			finY = mapa.obtenerAlto() - 1;
		
		for (int x = inicioX; x <= finX; x++) 
		{	
			for (int y = inicioY; y <= finY; y++) 
			{
				Posicion posActual = new Posicion(x,y);
				Contenido c = mapa.obtenerCelda(posActual).getContenido();
				if(c != null)	
				{	
					c.getGrafico().setIcon(imagenExplosion);
					mapa.agregarAExplosion(c.getGrafico());
					c.serAfectado(visitorPU);
				}
				else
				{	
					JLabel nuevoGraf = new JLabel(imagenExplosion);
					int desplazX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * x;
					int desplazY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * y;						
					nuevoGraf.setBounds(desplazX, desplazY ,imagenExplosion.getIconWidth(),imagenExplosion.getIconHeight());	
					mapa.agregarAExplosion(nuevoGraf);
				}		
			}
		}
	}

	public PowerUp clone() 
	{
		return new Bomba(miCelda, mapa);
	}
	
}
