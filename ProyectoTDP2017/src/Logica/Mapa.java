package Logica;

import java.util.LinkedList;

import javax.swing.JLabel;

/**
 * Clase Mapa
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Mapa 
{
	protected int alto;
	protected int ancho;
	protected Celda[][] matrizCeldas;
	protected Pantalla miPantalla;
	protected LinkedList<Personaje> misPersonajes;
	//protected LinkedList<Objeto> misObjetos;
	protected int posYenemigo;
	
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
			
		posYenemigo = 0;
		misPersonajes = new LinkedList<Personaje>(); 
	}
	
	public Celda[][] obtenerMatrizCeldas() 
	{
		return matrizCeldas;
	}
	
	public LinkedList<Personaje> getListaPersonajes() 
	{
		return misPersonajes;
	}
	
	public Celda obtenerCelda(Posicion p)
	{
		return matrizCeldas[p.getEjeX()][p.getEjeY()];
		
	}
	
	public JLabel agregarEnemigo()
	{
	
		if(posYenemigo <= alto - 1)
		{	
			Enemigo caminante = new CaminanteBlanco(new Posicion(0, posYenemigo), this);
			obtenerCelda(caminante.getPosicion()).setContenido(caminante);
			misPersonajes.addLast(caminante);
			posYenemigo = posYenemigo + 2;
			return caminante.getGrafico();
			
		}
		else
			return null;
	}
	
	public void eliminarEnemigo()
	{
		//cuando el jugador lo ataca al enemigo asumimos que lo mata de una sola vez
		
		
		
		
	}
}
