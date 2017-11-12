package Logica;

/**
 * Clase abstracta Enemigo
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Enemigo extends Personaje
{
	protected int velocidad = 2;
	protected int puntaje = 50;
	protected int rangoMonedas = 150;
	protected Premio miPremio;
	protected int cantDesplazada;
	protected int anchoRealCelda;
	protected boolean estaEnMovimiento = true;
	protected boolean deboPerder = false;
	
	//Se debe invocar cuando se muere.
	public void setPuntajeMonedas() 
	{
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
			//System.out.print("v: " + velocidad);
			Posicion ubicacion = miCelda.getPosCelda();
			int miX = ubicacion.getEjeX();
			int miY = ubicacion.getEjeY();
			
			//System.out.println("miX " + miX);
			//Intento mover hacia la derecha
			if(miX + 1 < mapa.obtenerAncho())
			{
				int i = 1;
				boolean encontre = false;
				//	System.out.println("miX " + miX);
				//verifico si hay alguien a mi alcance para atacar  
				while(i <= alcance && !encontre) 
				{
					if(miX+i < mapa.obtenerAncho()) 
					{
						//System.out.println("miX: " + miX + "i: "+i);
						//System.out.println("obtenerAncho: " + mapa.obtenerAncho());
						Celda celdaSiguiente = mapa.obtenerCelda(new Posicion(miX+i,miY));
						Contenido contenidoSiguiente = celdaSiguiente.getContenido();
						if(contenidoSiguiente != null) 
						{
							estaEnMovimiento = false;
							setImagenQuieto();
							encontre = true;
							contenidoSiguiente.seratacado(this.getProyectil());
							//System.out.print("Entro");
							
						}	
					}
					i++;
				}
			
				if (estaEnMovimiento)
				{
				////////////////////////////////
					//if(velocidad > 0) 
					//{
						if(cantDesplazada >= anchoRealCelda)
						{		
						//	setImagenEnMovimiento();
							cantDesplazada = 0;
							//se actualiza la posición del enemigo en la matriz de celdas
							Posicion p = new Posicion(ubicacion.getEjeX() + 1, ubicacion.getEjeY());
							mapa.obtenerCelda(ubicacion).setContenido(null);
							mapa.obtenerCelda(p).setContenido(this);
							miCelda = mapa.obtenerCelda(p);
						}	
						else
							cantDesplazada = (int) (cantDesplazada + Math.pow(2, velocidad+1));
					
						//muevo el JLabel que representa al enemigo
						desplX = (int) (desplX + Math.pow(2,velocidad+1));
						mGrafico.setBounds(desplX, desplY, imagen.getIconWidth(), imagen.getIconHeight());
						//System.out.println("estaEnMov: " + estaEnMovimiento);
					//}
				}
		
			}
			else // significa que el enemigo ya atravesó el mapa 
			{ 		
				estaVivo = false; 				//lo hago para que ThreadEnemigo no lo haga mover y lo remueva
				miCelda.setContenido(null);		// de la lista de enemigos
				//ACÁ SE PERDERÍA EL JUEGO
				deboPerder = true;		
			}		
	}
	
	public boolean deboPerderJuego()
	{
		return deboPerder;
	}

	public void setMovimiento(boolean m) 
	{
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