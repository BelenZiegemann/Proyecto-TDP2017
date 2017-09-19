package Logica;

/**
 * Clase CaminanteBlanco
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class CaminanteBlanco extends Enemigo 
{

	/*
	 * Constructor
	 */
	public CaminanteBlanco(Posicion p,Mapa m)
	{
		ubicacion = p;
		mapa = m;
		puntosVida = 4 * puntosVida;
		fuerzaImpacto = 4 * fuerzaImpacto;
		puntaje = 400;
		rangoMonedas = 400;
	}
	
}
