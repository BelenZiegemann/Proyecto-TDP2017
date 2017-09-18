package Logica;

/**
 * Clase Abstracta Enemigo
 * @author Bernab� Di Marco - Gabriel Ignacio Paez - Bel�n Ziegemann
 *
 */
public abstract class Enemigo extends Personaje
{
	protected int velocidad = 2;
	protected int puntaje = 50;
	protected int rangoMonedas = 150;
	protected Mapa mapa;
	protected Premio miPremio;
	
	public Posicion getPosicion()
	{
		return ubicacion;
	}
	
	/**
	 * Modifica la ubicaci�n del enemigo y actualiza su posici�n en el mapa
	 */
	public void mover()
	{
		//Intento mover hacia la derecha
		if(ubicacion.getEjeX() + 1 < mapa.obtenerMatrizCeldas().length)
		{
			Posicion p = new Posicion(ubicacion.getEjeX() + 1, ubicacion.getEjeY());
			mapa.obtenerCelda(ubicacion).setContenido(null);
			mapa.obtenerCelda(p).setContenido(this);//por ahora se asume que no hay obst�culos
			ubicacion = p;
		}
	}
	
}