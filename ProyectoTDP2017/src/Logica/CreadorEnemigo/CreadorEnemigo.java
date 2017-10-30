package Logica.CreadorEnemigo;
import Logica.*;

/**
* Clase abstracta CreadorEnemigo
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public abstract class CreadorEnemigo {
	public abstract Enemigo crearEnemigo(Celda c, Mapa m);
	
}