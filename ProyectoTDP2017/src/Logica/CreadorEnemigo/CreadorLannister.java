package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.Lannister;

/**
* Clase CreadorLannister
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class CreadorLannister extends CreadorEnemigo{

	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new Lannister(c,m);
	}

}
