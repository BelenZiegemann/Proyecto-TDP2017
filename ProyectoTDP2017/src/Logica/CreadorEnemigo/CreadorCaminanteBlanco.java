package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.CaminanteBlanco;

/**
* Clase CreadorCaminanteBlanco
* @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
*
*/
public class CreadorCaminanteBlanco extends CreadorEnemigo{
		
	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new CaminanteBlanco(c, m);
	}

}
