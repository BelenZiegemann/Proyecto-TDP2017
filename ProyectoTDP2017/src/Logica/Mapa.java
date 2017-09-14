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
	protected LinkedList<Enemigo> misEnemigos;
	//protected LinkedList<Objeto> misObjetos;
	
	public Mapa(int alto, int ancho)
	{
		this.alto = alto;
		this.ancho = ancho;
		matrizCeldas = new Celda[ancho][alto];
		
		//Inicializo cada celda de la matriz
		for (int i = 0; i < ancho; i++) 
		{	for (int j = 0; j < alto; j++) 
				matrizCeldas[i][j] = new Celda(new Posicion(i, j), this);
		}
		
		//falta
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
