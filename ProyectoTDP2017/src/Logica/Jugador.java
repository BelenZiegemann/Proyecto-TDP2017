package Logica;

/**
 * Clase Abstracta Jugador 
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public abstract class Jugador extends Personaje
{
	protected int precio = 125;
	protected Mapa mapa;
	
	public void seratacado(Proyectil p)
	{
		p.atacarJugador(this);
	}
	
	public int getPrecio()
	{
		return precio;
	}
	
	public void setProyectil(ProyectilJugador proyJug)
	{
		proyectil = proyJug;
	}
	
	public abstract void mover();
	
}