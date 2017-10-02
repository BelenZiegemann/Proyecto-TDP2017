package Logica;

public abstract class Proyectil 
{
	protected int fuerzaImpacto;
	
	public abstract void atacarJugador(Jugador j);
	public abstract void atacarEnemigo(Enemigo e);
	
}
