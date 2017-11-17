package Logica.Disparo;

import javax.swing.Icon;
import javax.swing.JLabel;

import Logica.Celda;
import Logica.Contenido;
import Logica.Mapa;

/**
* Clase abstracta Disparo
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public abstract class Disparo
{
	protected Celda miCelda;
	protected Mapa mapa;
	protected Icon imagen;
	protected JLabel mGrafico;
	protected int cantDesplazada;
	protected int anchoRealCelda;
	protected Contenido destino;

	public JLabel getGrafico()
	{
		return mGrafico;
	}
	
	public Celda getCelda() 
	{
		return miCelda;
	}
	
	public void setCelda(Celda c)
	{
		miCelda = c;
	}
	
	public Contenido getDestino()
	{
		return destino;
	}
	
	public void setDestino(Contenido destino)
	{
		this.destino = destino;
	}
	
	public abstract void mover();
}