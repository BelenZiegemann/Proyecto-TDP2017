package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	protected boolean estaEnMovimiento = true;
	
	//Se debe invocar cuando se muere.
	public void setPuntajeMonedas() {
		mapa.obtenerPantalla().incrementarPuntaje(puntaje);
		mapa.obtenerPantalla().setPresupuesto(rangoMonedas);
	}
	
	public void setProyectil(VisitorEnemigo proyEnem)
	{
		proyectil = proyEnem;
	}
	
	/**
	 * Modifica la ubicación del enemigo y actualiza su posición en el mapa
	 */
	public void mover()
	{		
			System.out.print("v: " + velocidad);
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
			System.out.println("miX" + miX );
			while(i <= alcance && !encontre) {
				
				if (miX+i < mapa.obtenerAncho() ) {
					System.out.println("miX: " + miX + "i: "+i);
					System.out.println("obtenerAncho: " + mapa.obtenerAncho());
					Celda celdaSiguiente = mapa.obtenerCelda(new Posicion(miX+i,miY));
					Contenido contenidoSiguiente = celdaSiguiente.getContenido();
					if (contenidoSiguiente != null) {
						estaEnMovimiento = false;
						encontre = true;
						setImagenQuieto();
						contenidoSiguiente.seratacado(this.getProyectil());
						System.out.print("Entro");
					}
					
					}
					i++;
			}
			
			//
			if (estaEnMovimiento) {
				////////////////////////////////
				if(velocidad > 0) {
					if(cantDesplazada >= anchoRealCelda)
					{		
						setImagenEnMovimiento();
						cantDesplazada = 0;
						//se actualiza la posición del enemigo en la matriz de celdas
						Posicion p = new Posicion(ubicacion.getEjeX() + 1, ubicacion.getEjeY());
						mapa.obtenerCelda(ubicacion).setContenido(null);
						mapa.obtenerCelda(p).setContenido(this);
						miCelda = mapa.obtenerCelda(p);
					}	
					else
						cantDesplazada = cantDesplazada + 8;
					
					//muevo el JLabel que representa al enemigo
					desplX = desplX + velocidad;
					mGrafico.setBounds(desplX, desplY, imagen.getIconWidth(), imagen.getIconHeight());
					System.out.println("estaEnMov: " + estaEnMovimiento);
				}
			}
			
		
		}
	}
	
	public void setMovimiento(boolean m) {
		estaEnMovimiento = m;
	}
	
	public void seratacado(Visitor p)
	{
		p.atacar(this);
	}
	
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	public abstract void setImagenEnMovimiento();
	
	public abstract void setImagenQuieto();
}