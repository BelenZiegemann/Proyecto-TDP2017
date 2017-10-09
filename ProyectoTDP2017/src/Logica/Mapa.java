package Logica;

import java.util.LinkedList;

import javax.swing.JLabel;

import Logica.Enemigos.CaminanteBlanco;

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
	protected LinkedList<Personaje> misPersonajes;
	
	//protected LinkedList<Proyectil> misProyectiles;
	//protected LinkedList<Objeto> misObjetos;
	protected int posYenemigo;
	
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
			
		posYenemigo = 0;
		misPersonajes = new LinkedList<Personaje>(); 
		miPantalla = new Pantalla(this);
	}
	
	public LinkedList<Personaje> getListaPersonajes() 
	{
		return misPersonajes;
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
			Enemigo caminante = new CaminanteBlanco(posEnem, this);
			obtenerCelda(caminante.getPosicion()).setContenido(caminante);
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
		//También debo verificar que la celda donde agregaré al jugador no esté ocupada
		if((miPantalla.getPresupuesto() >= j.getPrecio()) && (obtenerCelda(j.getPosicion()).getContenido() == null))
		{
			
			miPantalla.setPresupuesto(miPantalla.getPresupuesto() - j.getPrecio());
			obtenerCelda(j.getPosicion()).setContenido(j);
			misPersonajes.addLast(j);
			//agrego un proyectil al jugador
			j.setProyectil(new ProyectilJugador(j.getFuerzaImpacto() * 20)); ////incrementé la fuerza de impacto para
																		//que el enemigo se muera de un solo impacto
			return j.getGrafico();
		}
		else
			return null;
		
		
	}
}
