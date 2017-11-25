package Logica.VisitorPersonaje;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Jugador;
import Logica.Posicion;
import Logica.PowerUp;
import Logica.Disparo.DisparoJugador;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase VisitorJugador
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class VisitorJugador extends Visitor
{
	protected Jugador j;
	
	public VisitorJugador(Jugador j)
	{
		this.j = j;
	}
	
	public void atacar(Jugador j)
	{}
	
	public void atacar(Enemigo e)
	{
		//lanzo el disparo
		Posicion posJug = j.getCelda().getPosCelda();
		int miX = posJug.getEjeX();
		int miY = posJug.getEjeY();
		Celda celdaDisparo = j.getMapa().obtenerCelda(new Posicion(miX - j.getMisCeldas().size(), miY));
		DisparoJugador disparoJug = new DisparoJugador(celdaDisparo, j.getMapa(),e);
		j.getMapa().agregarDisparo(disparoJug);	
		//realizo el ataque
		if(j.tieneCampoProteccion()) //si es true entonces debe matar al enemigo
		{							//mientras el enemigo no tenga campo de protección activado
			if(!e.tieneCampoProteccion())
			{
				e.setVida(0);
				PowerUp PU = e.generarPowerUp();
				if(PU != null) 
				{
					if(PU.getGrafico() == null)
					{	//entonces ataco diractamente porque es de magia temporal
						j.serAfectado(PU.getVisitor());
					}
					j.getMapa().agregarPowerUp(PU);
				}
				e.setPuntajeMonedas();
				for(Celda cell : e.getMisCeldas())
				{
					j.getMapa().obtenerCelda(cell.getPosCelda()).setContenido(null);
					cell.setContenido(null);
				}
				e.setEstaVivo(false);
			}
		}
		else
		{
			if(!e.tieneCampoProteccion())
			{	
				e.setVida(e.getVida() - j.getFuerzaImpacto());
				if (e.getVida() <= 0) 
				{	
					PowerUp PU = e.generarPowerUp();
					if(PU != null) 
					{
						if(PU.getGrafico() == null)
						{	//entonces ataco diractamente porque es de magia temporal
							j.serAfectado(PU.getVisitor());
						}
						j.getMapa().agregarPowerUp(PU);
					}
					e.setPuntajeMonedas();
					for(Celda cell : e.getMisCeldas())
					{
						j.getMapa().obtenerCelda(cell.getPosCelda()).setContenido(null);
						cell.setContenido(null);
					}
					e.setEstaVivo(false);	
				}	
			}		
		}
	}
	
	public void atacar(ObstaculoConVida o) 
	{}
	
	public void atacar(ObstaculoPorTiempo o)
	{}
}
