package Logica;

import java.util.LinkedList;

import javax.swing.JLabel;

import Logica.Enemigos.CaminanteBlanco;

/**
 * Clase Mapa
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
	protected LinkedList<Personaje> misPersonajes;
	protected LinkedList<Obstaculo> misObstaculos;
	
	//protected LinkedList<Proyectil> misProyectiles;
	//protected LinkedList<Objeto> misObjetos;
	protected int posYenemigo;
	
	public void eliminarContenido(Personaje j) {
		
	}
	
	public Mapa(int alto, int ancho, int altoReal, int anchoReal)
	{
		this.alto = alto;
		this.ancho = ancho;
		this.altoReal = altoReal;	//Es el alto del panel que contiene al mapa gr�fico
		this.anchoReal = anchoReal;	//Es el ancho del panel que contiene al mapa gr�fico
		matrizCeldas = new Celda[ancho][alto];
		
		//Inicializo cada celda de la matriz
		for (int i = 0; i < ancho; i++) 
		{	for (int j = 0; j < alto; j++) 
				matrizCeldas[i][j] = new Celda(new Posicion(i, j));
		}
			
		posYenemigo = 0;
		misPersonajes = new LinkedList<Personaje>(); 
		misObstaculos = new LinkedList<Obstaculo>();
		miPantalla = new Pantalla(this);
	}
	
	public LinkedList<Personaje> getListaPersonajes() 
	{
		return misPersonajes;
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
	
	public JLabel agregarEnemigo()
	{
		Posicion posEnem = new Posicion(0,posYenemigo);
		if((posYenemigo <= alto - 1) && (obtenerCelda(posEnem).getContenido() == null))
		{	
			Celda miCelda = obtenerCelda(posEnem);
			Enemigo caminante = new CaminanteBlanco(miCelda,this);
			miCelda.setContenido(caminante);
			misPersonajes.addLast(caminante);
			posYenemigo = posYenemigo + 2;
			return caminante.getGrafico();
		}
		else
		{
			posYenemigo = posYenemigo + 2;
			return null;
		}
	}
	
	public JLabel agregarJugador(Jugador j)
	{
		//Debo verificar si dispongo de la cantidad de monedas suficientes para comprar al jugador.
		//Tambi�n debo verificar que la celda donde agregar� al jugador no est� ocupada
		if((miPantalla.getPresupuesto() >= j.getPrecio()) && (obtenerCelda(j.getCelda().getPosCelda()).getContenido() == null))
		{
			
			miPantalla.setPresupuesto(- j.getPrecio());
			obtenerCelda(j.getCelda().getPosCelda()).setContenido(j);
			misPersonajes.addLast(j);
			//agrego un proyectil al jugador
			//j.setProyectil(new VisitorJugador(j)); ////increment� la fuerza de impacto para
																		//que el enemigo se muera de un solo impacto
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
