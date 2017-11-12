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
	
	public void atacar(Jugador j)
	{}
	
	public void atacar(Enemigo e)
	{
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
