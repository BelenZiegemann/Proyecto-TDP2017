package Logica.Visitor;

import Logica.Enemigo;
import Logica.Jugador;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

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
	public abstract void atacar(ObstaculoPorTiempo o);	
}
