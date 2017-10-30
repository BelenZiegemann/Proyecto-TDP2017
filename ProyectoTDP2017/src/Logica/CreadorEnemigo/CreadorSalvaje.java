package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.Salvaje;
/**
* Clase CreadorSalvaje
* @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
*
*/
public class CreadorSalvaje extends CreadorEnemigo{

	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new Salvaje(c,m);
	}
	

}
