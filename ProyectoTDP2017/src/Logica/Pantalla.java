package Logica;

import java.util.LinkedList;

/**
 * Clase Pantalla 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Pantalla 
{
	protected int monedas;
	protected int puntos;
	protected int nivel;
	protected Mapa mapa;
	protected LinkedList<Premio> listaPremiosObtenidos;
	//protected JLabel mostrarMonedas;
	
	/**
	 * Constructor
	 */
	public Pantalla(Mapa m)
	{
		monedas = 1000;
		puntos = 0;
		nivel = 1;
		mapa = m;
		listaPremiosObtenidos = new LinkedList<Premio>();
	}
	
	
	public void incrementarPresupuesto(int coins)
	{
		monedas = monedas + coins;
	}
	
	public void incrementarPuntaje(int p)
	{
		puntos = puntos + p;
	}
	
	public void incrementarNivel()
	{
		nivel++;
	}
	
	public int getPresupuesto()
	{
		return monedas;
	}
	
	public int getPuntaje()
	{
		return puntos;
	}
	
	public int getNivel()
	{
		return nivel;
	}
	
}