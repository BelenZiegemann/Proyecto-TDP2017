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
		j.setVida(j.getVida() - e.getFuerzaImpacto());
		if (j.getVida() <= 0) {
			j.setEstaVivo(false);
			System.out.println("Se murio jugador.");
			j.getCelda().setContenido(null);
			e.setMovimiento(true);;
		}
	}
	
	public void atacar(Enemigo e)
	{
		
	}
	
	public void atacar(ObstaculoConVida o) {
		System.out.println("Enemigo ataca a obstaculo");
		e.setVelocidad(0);
		o.setVida(o.getVida() - e.getFuerzaImpacto());
		if (o.getVida() <= 0) {
			o.getCelda().setContenido(null);
			o.setEstaVivo(false);
			e.setVelocidad(2);
		}
	}
}
