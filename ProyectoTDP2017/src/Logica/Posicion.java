package Logica;

/**
 * Clase Posicion 
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Posicion 
{
	protected int ejeX;
	protected int ejeY;

	/**
	 * Constructor
	 */
	public Posicion(int x, int y) 
	{
		ejeX = x;
		ejeY = y;
	}

	/**
	 * Permite establecer la posición en eje x
	 * @param int x 
	 */
	public void setEjeX(int x)
	{
		ejeX = x;
	}

	/**
	 * Permite establecer la posición en eje y
	 * @param int y
	 */
	public void setEjeY(int y) 
	{
		ejeY = y;
	}

	/**
	 * retorna la posición en eje x
	 * @return la posición en eje x
	 */
	public int getEjeX() 
	{
		return ejeX;
	}

	/**
	 * Retorna la posición en eje y
	 * @return la posición en eje y
	 */
	public int getEjeY() 
	{
		return ejeY;
	}

	/**
	 * @param p Posición a comparar
	 * @return true si es igual el estado interno de la posición pasada por
	 *         parámetro con el que recibió el mensaje , false en caso contrario
	 */
	public boolean equals(Posicion p) 
	{
		return ejeX == p.getEjeX() && ejeY == p.getEjeY();
	}
}