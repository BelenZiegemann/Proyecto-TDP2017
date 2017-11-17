package Logica;

import java.util.LinkedList;
import javax.swing.JLabel;

import Logica.Disparo.Disparo;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosPorTiempo.ObstaculoPorTiempo;

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
	protected LinkedList<ObstaculoConVida> misObstaculosConVida;
	protected LinkedList<ObstaculoPorTiempo> misObstaculosPorTiempo;
	protected LinkedList<Disparo> misDisparos;
	protected LinkedList<PowerUp> misPowerUps;
	protected LinkedList<JLabel> explosion;
	
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
		misObstaculosConVida = new LinkedList<ObstaculoConVida>();
		misObstaculosPorTiempo = new LinkedList<ObstaculoPorTiempo>();
		misDisparos = new LinkedList<Disparo>();
		misPowerUps = new LinkedList<PowerUp>();
		explosion = new LinkedList<JLabel>();
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
	
	public LinkedList<ObstaculoConVida> getListaObstaculosConVida() 
	{
		return misObstaculosConVida;
	}
	
	public LinkedList<ObstaculoPorTiempo> getListaObstaculosPorTiempo() 
	{
		return misObstaculosPorTiempo;
	}
	
	public LinkedList<Disparo> getListaDisparos()
	{
		return misDisparos;
	}	
	
	public LinkedList<PowerUp> getListaPowerUp()
	{
		return misPowerUps;
	}
	
	public LinkedList<JLabel> getListaExplosion()
	{
		return explosion;
	}
	
	public Pantalla obtenerPantalla()
	{
		return miPantalla;
	}
	
	public Celda[][] getMatrizCeldas()
	{
		return matrizCeldas;
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
	
	public JLabel agregarObstaculoConVida(ObstaculoConVida o) 
	{
		if(obtenerCelda(o.getCelda().getPosCelda()).getContenido() == null)
		{
			obtenerCelda(o.getCelda().getPosCelda()).setContenido(o);
			misObstaculosConVida.addLast(o);
			return o.getGrafico();
		}
		else
			return null;
	}
	
	public JLabel agregarObstaculoPorTiempo(ObstaculoPorTiempo o) 
	{
		if(obtenerCelda(o.getCelda().getPosCelda()).getContenido() == null)
		{
			obtenerCelda(o.getCelda().getPosCelda()).setContenido(o);
			misObstaculosPorTiempo.addLast(o);
			return o.getGrafico();
		}
		else
			return null;
	}	
	
	public void agregarDisparo(Disparo d)
	{
		if(obtenerCelda(d.getCelda().getPosCelda()).getContenido() == null)
		{
			misDisparos.addLast(d);	
		}
		
	}
	
	public void agregarPowerUp(PowerUp PU)
	{
		misPowerUps.addLast(PU);
	}
	
	public void agregarAExplosion(JLabel jExplosion)
	{
		explosion.addLast(jExplosion);
	}
}