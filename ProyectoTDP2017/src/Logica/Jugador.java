package Logica;

import Logica.VisitorPersonaje.Visitor;
import Logica.VisitorPowerUp.VisitorPowerUp;

/**
 * Clase abstracta Jugador 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Jugador extends Personaje
{
	protected int precio = 125;
	
	public void seratacado(Visitor p)
	{
		p.atacar(this);
	}
	
	public void serAfectado(VisitorPowerUp p)
	{
		p.afectar(this);
	}
	
	public int getPrecio()
	{
		return precio;
	}
	
	public void mover() 
	{	//como el jugador no se mueve solamente se intenta atacar
		Posicion miPosicion = miCelda.getPosCelda();
		int miX = miPosicion.getEjeX() - (misCeldas.size() - 1);
		int miY = miPosicion.getEjeY();
		int i = 1;
		boolean encontre = false;
		while(i <= alcance && !encontre) 
		{
			if (miX-i >= 0)
			{
				Celda celdaSiguiente = mapa.obtenerCelda(new Posicion(miX-i,miY));
				Contenido contenidoSiguiente = celdaSiguiente.getContenido();
				if (contenidoSiguiente != null)
				{
					encontre = true;
					contenidoSiguiente.seratacado(this.proyectil);		 
				}	
			}
			i++;
		}
	}	
	
	public void controlarTamaño()
	{
		misCeldas.addFirst(miCelda); //desde la posición de miCelda comenzaría el jlabel del jugador (mGrafico)
		int cantCeldasAOcupar = imagen.getIconWidth() / (mapa.obtenerAnchoReal() / mapa.obtenerAncho());
		if(cantCeldasAOcupar > 1)
		{
			for(int i = 1; i <= cantCeldasAOcupar - 1; i++)
			{
				Posicion posNuevaCelda = new Posicion(miCelda.getPosCelda().getEjeX() - i, miCelda.getPosCelda().getEjeY());
				Celda nuevaCelda = new Celda(posNuevaCelda);	
				misCeldas.addFirst(nuevaCelda);
			}
			//reacomodo la posición de mgrafico
			desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * misCeldas.getFirst().getPosCelda().getEjeX();
		 	desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * misCeldas.getFirst().getPosCelda().getEjeY();	
		 	mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());
		}
	}
}