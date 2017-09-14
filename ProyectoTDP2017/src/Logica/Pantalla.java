package Logica;
//import java.util.LinkedList;

/**
 * Clase Pantalla 
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public class Pantalla 
{
	protected int monedas;
	protected int puntos;
	protected int nivel;
	protected Mapa mapa;
	//protected LinkedList<Premio> listaPremiosObtenidos;
	
	/**
	 * Constructor
	 */
	public Pantalla()
	{
		monedas = 1000;
		puntos = 0;
		nivel = 1;
		//mapa = new Mapa(6,10);
		//listaPremiosObtenidos = new LinkedList<Premio>();
	}
	
	/**
	 * El premio agregado podr� ser utilizado mas tarde por el Jugador
	 * @param prem premio obtenido cuando muere un Enemigo
	 */
	/*
	public void agregarPremio(Premio prem)
	{
		listaPremiosObtenidos.addLast(prem);
	}
	*/
	
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
	
	
	/*
	public Premio usarPremio()
	{
		if(!listaPremiosObtenidos.isEmpty())	
			return listaPremiosObtenidos.removeLast();
		else
			return null;
	}
	
	
	public void comprarJugador(Jugador j)
	{
		
	}
	
	
	public void venderJugador(Jugador j)
	{
	
	}
	
	*/
	
}