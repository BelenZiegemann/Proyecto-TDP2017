package Logica.ObjetoPrecioso;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Celda;
import Logica.Mapa;
import Logica.PowerUp;

/**
* Clase HuevoDeDragon
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class HuevoDeDragon extends ObjetoPrecioso
{
	public HuevoDeDragon(Celda c, Mapa m)
	{
		super();
		visitorPU = null;
		miCelda = c;
		mapa = m;
		//agrego la gráfica al huevo de Dragón
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/huevoDragon.png"));
		mGrafico = new JLabel(imagen);
		actualizarPosGrafico();
	}

	public void accionFinTimer()
	{
		//en este caso el timer no se usa
	}

	public PowerUp clone()
	{
		return new HuevoDeDragon(miCelda, mapa);
	}
}
