package Logica;

public class ProyectilJugador extends Proyectil
{

	public ProyectilJugador(int fImpacto)
	{
		fuerzaImpacto = fImpacto;
	}
	
	public void atacarJugador(Jugador j)
	{
		
	}
	
	public void atacarEnemigo(Enemigo e)
	{
		e.setVida(e.getVida() - fuerzaImpacto);
	}
}
