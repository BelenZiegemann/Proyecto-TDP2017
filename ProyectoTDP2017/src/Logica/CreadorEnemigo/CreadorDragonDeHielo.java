package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.DragonDeHielo;

/**
* Clase CreadorDragonDeHielo
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class CreadorDragonDeHielo extends CreadorEnemigo{

	
	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new DragonDeHielo(c,m);
	}

}
