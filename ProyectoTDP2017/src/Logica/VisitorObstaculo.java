package Logica;

public class VisitorObstaculo extends Visitor
{
	protected Jugador j;
	public VisitorObstaculo(Jugador j)
	{
		this.j = j;
	}
	
	public void atacar(Jugador j)
	{
		
	}
	
	public void atacar(Enemigo e)
	{
		e.setVida(e.getVida() - j.getFuerzaImpacto() * 20);
	}
}
