package Logica;

import java.util.LinkedList;

import javax.swing.JLabel;

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
	
	protected JLabel mostrarMonedas;
	protected JLabel mostrarPuntaje;
	protected JLabel mostrarNivel;
	
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
		
		mostrarMonedas = new JLabel();
		mostrarPuntaje = new JLabel();
		mostrarNivel = new JLabel();
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
	
	public JLabel getMostrarMonedas()
	{
		return mostrarMonedas;
	}
	
	public JLabel getMostrarPuntaje()
	{
		return mostrarPuntaje;
	}
	
	public JLabel getMostrarNivel()
	{
		return mostrarNivel;
	}
	
	public void setPresupuesto(int coins)
	{
		monedas = monedas + coins;
		mostrarMonedas.setText("" + monedas);
	}
	
	public void incrementarPuntaje(int p)
	{
		puntos = puntos + p;
		mostrarPuntaje.setText("" + puntos);
	}
	
	public void incrementarNivel()
	{
		nivel++;
		mostrarNivel.setText("" + nivel);
	}

	public void setMostrarPuntaje(JLabel lblPuntaje)
	{
		mostrarPuntaje = lblPuntaje;
	}
	
	public void setMostrarMonedas(JLabel lblMonedas)
	{
		mostrarMonedas = lblMonedas;
	}
	
	public void setMostrarNivel(JLabel lblNivel)
	{
		mostrarNivel = lblNivel;
	}
}
