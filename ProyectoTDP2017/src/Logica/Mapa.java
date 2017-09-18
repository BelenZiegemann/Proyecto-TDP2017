package Logica;

import java.util.LinkedList;

/**
 * Clase Mapa
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class Mapa 
{
	protected int alto;
	protected int ancho;
	protected Celda[][] matrizCeldas;
	protected Pantalla miPantalla;
	protected LinkedList<Jugador> misJugadores;
	protected Enemigo[] misEnemigos;
	//protected LinkedList<Objeto> misObjetos;
	
	public Mapa(int alto, int ancho)
	{
		this.alto = alto;
		this.ancho = ancho;
		matrizCeldas = new Celda[ancho][alto];
		
		//Inicializo cada celda de la matriz
		for (int i = 0; i < ancho; i++) 
		{	for (int j = 0; j < alto; j++) 
				matrizCeldas[i][j] = new Celda(new Posicion(i, j));
		}
		
		// ENEMIGOS
		Enemigo caminante1 = new CaminanteBlanco(new Posicion(0, 1), this);
		obtenerCelda(caminante1.getPosicion()).setContenido(caminante1);
		
		
		Enemigo caminante2 = new CaminanteBlanco(new Posicion(0, 3), this);
		obtenerCelda(caminante2.getPosicion()).setContenido(caminante2);
		
		// lleno el arreglo de enemigos
		misEnemigos = new Enemigo[2];
		misEnemigos[0] = caminante1;
		misEnemigos[1] = caminante2;
	}
	
	public Celda[][] obtenerMatrizCeldas() 
	{
		return matrizCeldas;
	}
	
	public Enemigo[] getEnemigos() 
	{
		return misEnemigos;
	}
	
	public Celda obtenerCelda(Posicion p)
	{
		return matrizCeldas[p.getEjeX()][p.getEjeY()];
		
	}
}
