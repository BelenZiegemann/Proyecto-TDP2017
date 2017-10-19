package Logica;

public class VisitorObstaculo extends Visitor
{
	protected Obstaculo o;
	public VisitorObstaculo(Jugador j)
	{
		this.o = o;
	}
	
	public void atacar(Jugador o)
	{
		
	}
	
	public void atacar(Enemigo o)
	{
		o.setVida(o.getVida() - o.getFuerzaImpacto() * 20);
	}
	
	public void atacar(ObstaculoConVida o) {
		
	}
}
