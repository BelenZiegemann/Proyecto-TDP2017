package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.DragonDeHielo;

public class CreadorDragonDeHielo extends CreadorEnemigo{

	
	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new DragonDeHielo(c,m);
	}

}
