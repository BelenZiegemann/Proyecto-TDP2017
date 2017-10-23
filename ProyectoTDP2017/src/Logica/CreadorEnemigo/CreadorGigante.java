package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.Gigante;

public class CreadorGigante extends CreadorEnemigo{

	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new Gigante(c,m);
	}

}
