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
	
	
	/**
	 * Modifica la ubicaci�n del enemigo y actualiza su posici�n en el mapa
	 */
	public void mover()
	{
		//Intento mover hacia la derecha
		if(ubicacion.getEjeX() + 1 < mapa.obtenerMatrizCeldas().length)
		{
			//se actualiza la posici�n del enemigo en la matriz de celdas
			Posicion p = new Posicion(ubicacion.getEjeX() + 1, ubicacion.getEjeY());
			mapa.obtenerCelda(ubicacion).setContenido(null);
			mapa.obtenerCelda(p).setContenido(this);//por ahora se asume que no hay obst�culos
			ubicacion = p;
				
			//muevo el JLabel que representa al enemigo
			
			posGrafica.x = posGrafica.x + 8;
			mGrafico.setBounds(posGrafica.x, ubicacion.getEjeY() * 64, ancho, alto);
		}
	}
	
	public void seratacado(Proyectil p)
	{
		p.atacarEnemigo(this);
	}
	
	
	
}