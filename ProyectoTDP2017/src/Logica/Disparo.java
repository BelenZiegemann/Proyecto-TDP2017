package Logica;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
* Clase abstracta Disparo
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public abstract class Disparo
{
	protected Celda miCelda;
	protected Mapa mapa;
	protected Visitor proyectil;
	protected Icon imagen;
	protected JLabel mGrafico;
	protected int cantDesplazada;
	protected int anchoRealCelda;
	protected Contenido inicio;
	protected Contenido destino;

	public Visitor getProyectil()
	{
		return proyectil;
	}
	
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
	
	public Contenido getInicio()
	{
		return inicio;
	}
	
	public Contenido getDestino()
	{
		return destino;
	}
	
	public void setInicio(Contenido inicio)
	{
		this.inicio = inicio;
	}
	
	public void setDestino(Contenido destino)
	{
		this.destino = destino;
	}
	
	public void Atacar()
	{	
		destino.seratacado(proyectil);
	}
	
	public abstract void mover();
}
