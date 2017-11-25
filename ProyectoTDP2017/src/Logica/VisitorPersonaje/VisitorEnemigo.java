package Logica.VisitorPersonaje;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Jugador;
import Logica.Posicion;
import Logica.Disparo.DisparoEnemigo;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

/**
 * Clase VisitorEnemigo
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class VisitorEnemigo extends Visitor
{
	protected Enemigo e;
	
	public VisitorEnemigo(Enemigo e)
	{
		this.e = e;		
	}
	
	public void atacar(Jugador j)
	{
		//lanzo el disparo
		Posicion posEnem = e.getCelda().getPosCelda();
		int miX = posEnem.getEjeX();
		int miY = posEnem.getEjeY();
		Posicion posInicialDisparo = new Posicion(miX + e.getMisCeldas().size(), miY);
		Celda celdaDisparo = e.getMapa().obtenerCelda(posInicialDisparo);
		DisparoEnemigo disparoEnem = new DisparoEnemigo(celdaDisparo, e.getMapa(), j);
		e.getMapa().agregarDisparo(disparoEnem);
		//realizo el ataque
		if(!j.tieneCampoProteccion())
		{
			j.setVida(j.getVida() - e.getFuerzaImpacto());
			if (j.getVida() <= 0) 
			{
				j.setEstaVivo(false);
				for(Celda cell : j.getMisCeldas())
				{
					e.getMapa().obtenerCelda(cell.getPosCelda()).setContenido(null);
					cell.setContenido(null);
				}
				e.setMovimiento(true);	
				e.setImagenEnMovimiento();
			}
		}
	}
	
	public void atacar(Enemigo e)
	{
		this.e.setMovimiento(true);
		this.e.setImagenEnMovimiento();
	}
	
	public void atacar(ObstaculoConVida o) 
	{
		//lanzo el disparo
		Posicion posEnem = e.getCelda().getPosCelda();
		int miX = posEnem.getEjeX();
		int miY = posEnem.getEjeY();
		Posicion posInicialDisparo = new Posicion(miX + e.getMisCeldas().size(), miY);
		Celda celdaDisparo = e.getMapa().obtenerCelda(posInicialDisparo);
		DisparoEnemigo disparoEnem = new DisparoEnemigo(celdaDisparo, e.getMapa(), o);
		e.getMapa().agregarDisparo(disparoEnem);
		//realizo el ataque
		o.setVida(o.getVida() - e.getFuerzaImpacto());
		if (o.getVida() <= 0)
		{
			o.setEstaVivo(false);
			e.getMapa().obtenerCelda(o.getCelda().getPosCelda()).setContenido(null);
			o.getCelda().setContenido(null);
			this.e.setMovimiento(true);
			this.e.setImagenEnMovimiento();
		}
	}
	
	public void atacar(ObstaculoPorTiempo o)
	{
		if(o.estaVivo() && !o.getTimerDuracionObstaculo().isRunning())
		{	
			this.e.setMovimiento(true);
			this.e.setImagenEnMovimiento();
		}	
	}
}