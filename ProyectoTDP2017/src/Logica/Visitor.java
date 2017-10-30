package Logica;

/**
 * Clase abstracta Visitor
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Visitor 
{
	
	public abstract void atacar(Jugador j);
	public abstract void atacar(Enemigo e);
	public abstract void atacar(ObstaculoConVida o);
	
}
