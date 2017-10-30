package Logica.CreadorEnemigo;
import Logica.*;

/**
* Clase abstracta CreadorEnemigo
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public abstract class CreadorEnemigo {
	public abstract Enemigo crearEnemigo(Celda c, Mapa m);
	
}