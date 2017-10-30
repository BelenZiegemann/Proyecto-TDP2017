package Logica;

/**
 * Clase abstracta Visitor
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public abstract class Visitor 
{
	
	public abstract void atacar(Jugador j);
	public abstract void atacar(Enemigo e);
	public abstract void atacar(ObstaculoConVida o);
	
}
