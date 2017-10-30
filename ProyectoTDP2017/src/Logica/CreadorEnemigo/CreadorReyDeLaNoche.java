package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.ReyDeLaNoche;

/**
* Clase CreadorReyDeLaNoche
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class CreadorReyDeLaNoche extends CreadorEnemigo{

	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new ReyDeLaNoche(c,m);
	}

}
