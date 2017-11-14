package Logica.Visitor;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Jugador;
import Logica.Posicion;
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
		Celda celdaDisparo = j.getMapa().obtenerCelda(new Posicion(miX-1, miY));
		DisparoJugador disparoJug = new DisparoJugador(celdaDisparo, j.getMapa(),e);
		j.getMapa().agregarDisparo(disparoJug);	
		
		//realizo el ataque
		e.setVida(e.getVida() - j.getFuerzaImpacto());
		if (e.getVida() <= 0) 
		{
			e.setEstaVivo(false);
			e.setPuntajeMonedas();
			e.getCelda().setContenido(null);
		}
	}
	
	public void atacar(ObstaculoConVida o) 
	{}
	
	public void atacar(ObstaculoPorTiempo o)
	{}
}
