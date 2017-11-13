package Logica;

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
	
	public synchronized void atacar(Jugador j)
	{}
	
	public synchronized void atacar(Enemigo e)
	{
		e.setVida(e.getVida() - j.getFuerzaImpacto());
		if (e.getVida() <= 0) 
		{
			e.setEstaVivo(false);
			e.setPuntajeMonedas();
			e.getCelda().setContenido(null);
		}
	}
	
	public synchronized void atacar(ObstaculoConVida o) 
	{}
	
	public synchronized void atacar(ObstaculoPorTiempo o)
	{}
}
