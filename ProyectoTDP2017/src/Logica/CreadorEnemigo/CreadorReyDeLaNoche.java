package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.ReyDeLaNoche;

public class CreadorReyDeLaNoche extends CreadorEnemigo{

	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new ReyDeLaNoche(c,m);
	}

}
