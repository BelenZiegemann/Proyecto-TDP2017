package Logica;

public class VisitorJugador extends Visitor
{
	protected Jugador j;
	public VisitorJugador(Jugador j)
	{
		this.j = j;
	}
	
	public void atacar(Jugador j)
	{
		
	}
	
	public void atacar(Enemigo e)
	{
		System.out.println("Jugador ataca a enemigo.");
		e.setVida(e.getVida() - j.getFuerzaImpacto());
		if (e.getVida() <= 0) {
			e.setEstaVivo(false);
			System.out.println("Se murio enemigo.");
			e.setPuntajeMonedas();
			e.getCelda().setContenido(null);
		}
	}
	
public void atacar(ObstaculoConVida o) {
		
	}
}
