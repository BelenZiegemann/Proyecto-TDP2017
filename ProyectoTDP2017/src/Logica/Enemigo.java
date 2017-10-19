package Logica;


/**
 * Clase Abstracta Enemigo
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Enemigo extends Personaje
{
	protected int velocidad = 2;
	protected int puntaje = 50;
	protected int rangoMonedas = 150;
	protected Mapa mapa;
	protected Premio miPremio;
	protected int cantDesplazada;
	protected int anchoRealCelda;
	
	public void setProyectil(VisitorEnemigo proyEnem)
	{
		proyectil = proyEnem;
	}
	
	/**
	 * Modifica la ubicación del enemigo y actualiza su posición en el mapa
	 */
	public void mover()
	{				
			Posicion ubicacion = miCelda.getPosCelda();
			//Intento mover hacia la derecha
			if(ubicacion.getEjeX() + 1 < mapa.obtenerAncho())
			{
			//////////////////////////
			Posicion miPosicion = miCelda.getPosCelda();
			int miX = miPosicion.getEjeX();
			int miY = miPosicion.getEjeY();
			int i = 1;
			boolean encontre = false;
			while(i <= alcance && !encontre) {
				if (miX+i <= mapa.obtenerAncho()) {
					Celda celdaSiguiente = mapa.obtenerCelda(new Posicion(miX+i,miY));
					Contenido contenidoSiguiente = celdaSiguiente.getContenido();
					if (contenidoSiguiente != null) {
						encontre = true;
						contenidoSiguiente.seratacado(this.getProyectil());
						System.out.print("Entro");
					}	
				}
				i++;
			}
			////////////////////////////////
				if(cantDesplazada == anchoRealCelda)
				{	
					
					
					
					cantDesplazada = 0;
					//se actualiza la posición del enemigo en la matriz de celdas
					Posicion p = new Posicion(ubicacion.getEjeX() + 1, ubicacion.getEjeY());
					mapa.obtenerCelda(ubicacion).setContenido(null);
					mapa.obtenerCelda(p).setContenido(this);
				}	
				else
					cantDesplazada = cantDesplazada + 8;
				
				//muevo el JLabel que representa al enemigo
				desplX = desplX + 4 * velocidad;
				mGrafico.setBounds(desplX, desplY, imagen.getIconWidth(), imagen.getIconHeight());
			}
		
	
	}
	
	public void seratacado(Visitor p)
	{
		p.atacar(this);
	}
}