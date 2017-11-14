package Logica;

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
		Posicion posInicialDisparo = new Posicion(miX+1, miY);
		Celda celdaDisparo = e.mapa.obtenerCelda(posInicialDisparo);
		DisparoEnemigo disparoEnem = new DisparoEnemigo(celdaDisparo, e.mapa, j);
		e.mapa.agregarDisparo(disparoEnem);
		
		//realizo el ataque
		j.setVida(j.getVida() - e.getFuerzaImpacto());
		if (j.getVida() <= 0) 
		{
			j.setEstaVivo(false);
			j.getCelda().setContenido(null);
			e.setMovimiento(true);	
			e.setImagenEnMovimiento();
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
		Posicion posInicialDisparo = new Posicion(miX+1, miY);
		Celda celdaDisparo = e.mapa.obtenerCelda(posInicialDisparo);
		DisparoEnemigo disparoEnem = new DisparoEnemigo(celdaDisparo, e.mapa, o);
		e.mapa.agregarDisparo(disparoEnem);
		
		//realizo el ataque
		o.setVida(o.getVida() - e.getFuerzaImpacto());
		if (o.getVida() <= 0)
		{
			o.setEstaVivo(false);
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