package Logica;

public class ProyectilJugador extends Proyectil
{

	public ProyectilJugador()
	{
		
		
	}
	
	public void atacarJugador(Jugador j)
	{
		
	}
	
	public void atacarEnemigo(Enemigo e)
	{
		e.setVida(e.getVida() - e.getFuerzaImpacto());
	}
}
