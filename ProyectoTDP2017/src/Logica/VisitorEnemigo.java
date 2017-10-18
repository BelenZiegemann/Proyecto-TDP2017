package Logica;

public class VisitorEnemigo extends Visitor
{
	Enemigo e;
	public VisitorEnemigo(Enemigo e)
	{
		this.e = e;
	}
	
	public void atacar(Jugador j)
	{
		System.out.println("Enemigo ataca a jugador.");
		j.setVida(j.getVida() - e.getFuerzaImpacto()*20);
		if (j.getVida() <= 0) {
			j.setEstaVivo(false);
			System.out.println("Se murio jugador.");
		}
	}
	
	public void atacar(Enemigo e)
	{
		
	}
}
