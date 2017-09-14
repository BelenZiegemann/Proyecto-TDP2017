package Logica;

/**
 * Clase Posicion 
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
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
	 * Permite establecer la posici�n en eje x
	 * @param int x 
	 */
	public void setEjeX(int x)
	{
		ejeX = x;
	}

	/**
	 * Permite establecer la posici�n en eje y
	 * @param int y
	 */
	public void setEjeY(int y) 
	{
		ejeY = y;
	}

	/**
	 * retorna la posici�n en eje x
	 * @return la posici�n en eje x
	 */
	public int getEjeX() 
	{
		return ejeX;
	}

	/**
	 * Retorna la posici�n en eje y
	 * @return la posici�n en eje y
	 */
	public int getEjeY() 
	{
		return ejeY;
	}

	/**
	 * @param p Posici�n a comparar
	 * @return true si es igual el estado interno de la posici�n pasada por
	 *         par�metro con el que recibi� el mensaje , false en caso contrario
	 */
	public boolean equals(Posicion p) 
	{
		return ejeX == p.getEjeX() && ejeY == p.getEjeY();
	}
}