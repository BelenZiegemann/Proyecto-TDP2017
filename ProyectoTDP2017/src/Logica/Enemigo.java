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
	
	
	/**
	 * Modifica la ubicación del enemigo y actualiza su posición en el mapa
	 */
	public void mover()
	{	
		
		//Primero veo si me están atacando
		int posEnXJugador;
		int posEnYJugador;
		int distancia;
				
		for(Personaje pers : mapa.getListaPersonajes()) 
		{	
					
			posEnYJugador =  pers.getPosicion().getEjeY();
			if(ubicacion.getEjeY() == posEnYJugador)
			{
				posEnXJugador =  pers.getPosicion().getEjeX();
				distancia = posEnXJugador - ubicacion.getEjeX();
				if((distancia != 0) && (distancia <= pers.getAlcance()))
				{	//entonces el enemigo debe ser atacado por el jugador
					Proyectil proy = new ProyectilJugador(pers.getFuerzaImpacto() * 20); //la incrementé para
																				//que se muera con un solo impacto
					seratacado(proy);
					if(puntosVida <= 0)
					{	//entonces el enemigo debe morir 
								
						mapa.obtenerPantalla().setPresupuesto(mapa.obtenerPantalla().getPresupuesto() + rangoMonedas);
						mapa.obtenerPantalla().incrementarPuntaje(puntaje);
						mapa.obtenerCelda(ubicacion).setContenido(null);
						estaVivo = false;
					}
							
							
						
				}		
			}
		}	
		
		
		if(estaVivo)
		{
			//Intento mover hacia la derecha
			if(ubicacion.getEjeX() + 1 < mapa.obtenerAncho())
			{
				if(cantDesplazada == anchoRealCelda)
				{	
					cantDesplazada = 0;
					//se actualiza la posición del enemigo en la matriz de celdas
					Posicion p = new Posicion(ubicacion.getEjeX() + 1, ubicacion.getEjeY());
					mapa.obtenerCelda(ubicacion).setContenido(null);
					mapa.obtenerCelda(p).setContenido(this);//por ahora se asume que no hay obstáculos
					ubicacion = p;
				}	
				else
					cantDesplazada = cantDesplazada + 4;
				
				//muevo el JLabel que representa al enemigo
				desplX = desplX + 2 * velocidad;
				mGrafico.setBounds(desplX, desplY, imagen.getIconWidth(), imagen.getIconHeight());
			}
		
		}
		
	}
	
	public void seratacado(Proyectil p)
	{
		p.atacarEnemigo(this);
	}
	
}