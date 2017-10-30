package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.CaminanteBlanco;

/**
* Clase CreadorCaminanteBlanco
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class CreadorCaminanteBlanco extends CreadorEnemigo{
		
	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new CaminanteBlanco(c, m);
	}

}
