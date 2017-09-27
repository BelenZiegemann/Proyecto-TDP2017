package Logica;

public class ProyectilEnemigo extends Proyectil
{
	public ProyectilEnemigo()
	{
		
	}
	
	public void atacarJugador(Jugador j)
	{
		j.setVida(j.getVida() - j.getFuerzaImpacto());
	}
	
	public void atacarEnemigo(Enemigo e)
	{
		
	}
}
