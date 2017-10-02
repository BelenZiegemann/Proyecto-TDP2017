package Logica;

/**
 * Clase Abstracta Jugador 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
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
	
	public abstract void mover();
	
}