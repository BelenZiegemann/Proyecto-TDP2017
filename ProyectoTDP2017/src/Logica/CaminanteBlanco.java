package Logica;

/**
 * Clase CaminanteBlanco
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
