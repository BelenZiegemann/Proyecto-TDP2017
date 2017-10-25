package Logica.CreadorEnemigo;

import Logica.Celda;
import Logica.Enemigo;
import Logica.Mapa;
import Logica.Enemigos.Salvaje;

public class CreadorSalvaje extends CreadorEnemigo{

	public Enemigo crearEnemigo(Celda c, Mapa m) {
		return new Salvaje(c,m);
	}
	

}
