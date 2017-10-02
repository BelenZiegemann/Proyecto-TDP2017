package Logica;

public class ProyectilEnemigo extends Proyectil
{
	public ProyectilEnemigo(int fImpacto)
	{
		fuerzaImpacto = fImpacto;
	}
	
	public void atacarJugador(Jugador j)
	{
		j.setVida(j.getVida() - fuerzaImpacto);
	}
	
	public void atacarEnemigo(Enemigo e)
	{
		
	}
}
