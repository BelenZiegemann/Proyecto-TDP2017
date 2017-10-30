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
	protected int altoReal;
	protected int anchoReal;
	protected Celda[][] matrizCeldas;
	protected Pantalla miPantalla;
	protected LinkedList<Jugador> misJugadores;
	protected LinkedList<Enemigo> misEnemigos;
	protected LinkedList<Obstaculo> misObstaculos;
	
	public Mapa(int alto, int ancho, int altoReal, int anchoReal)
	{
		this.alto = alto;
		this.ancho = ancho;
		this.altoReal = altoReal;	//Es el alto del panel que contiene al mapa gráfico
		this.anchoReal = anchoReal;	//Es el ancho del panel que contiene al mapa gráfico
		matrizCeldas = new Celda[ancho][alto];
		
		//Inicializo cada celda de la matriz
		for (int i = 0; i < ancho; i++) 
		{	for (int j = 0; j < alto; j++) 
				matrizCeldas[i][j] = new Celda(new Posicion(i, j));
		}
			
		misJugadores = new LinkedList<Jugador>(); 
		misEnemigos = new LinkedList<Enemigo>();
		misObstaculos = new LinkedList<Obstaculo>();
		miPantalla = new Pantalla(this);
	}
	
	public LinkedList<Jugador> getListaJugadores() 
	{
		return misJugadores;
	}
	
	public LinkedList<Enemigo> getListaEnemigos() 
	{
		return misEnemigos;
	}
	
	public LinkedList<Obstaculo> getListaObstaculos() 
	{
		return misObstaculos;
	}
	
	public Pantalla obtenerPantalla()
	{
		return miPantalla;
	}
	
	public Celda obtenerCelda(Posicion p)
	{
		return matrizCeldas[p.getEjeX()][p.getEjeY()];
		
	}
	
	public int obtenerAncho()
	{
		return ancho;
	}
	
	public int obtenerAlto()
	{
		return alto;
	}
	
	public int obtenerAltoReal()
	{
		return altoReal;
	}
		
	public int obtenerAnchoReal()
	{
		return anchoReal;
	}
	
	public JLabel agregarEnemigo(Enemigo enem)
	{
		if(obtenerCelda(enem.getCelda().getPosCelda()).getContenido() == null)
		{	
			Celda miCelda = obtenerCelda(enem.getCelda().getPosCelda());
			miCelda.setContenido(enem);
			misEnemigos.addLast(enem);
			return enem.getGrafico();
		}
		else
			return null;
	}
	
	
	public JLabel agregarJugador(Jugador j)
	{
		//Debo verificar si dispongo de la cantidad de monedas suficientes para comprar al jugador.
		//También debo verificar que la celda donde agregaré al jugador no esté ocupada
		if((miPantalla.getPresupuesto() >= j.getPrecio()) && (obtenerCelda(j.getCelda().getPosCelda()).getContenido() == null))
		{
			
			miPantalla.setPresupuesto(- j.getPrecio());
			obtenerCelda(j.getCelda().getPosCelda()).setContenido(j);
			misJugadores.addLast(j);
			return j.getGrafico();
		}
		else
			return null;
	}
	
	public JLabel agregarObstaculo(Obstaculo o) {
		obtenerCelda(o.getCelda().getPosCelda()).setContenido(o);
		misObstaculos.addLast(o);
		return o.getGrafico();		
	}
	
}
