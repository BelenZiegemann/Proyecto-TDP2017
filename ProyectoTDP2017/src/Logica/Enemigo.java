package Logica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import Logica.MagiaTemporal.CampoDeProteccion;
import Logica.MagiaTemporal.DuplicarFuerza;
import Logica.MagiaTemporal.DuplicarVida;
import Logica.ObjetoPrecioso.Bomba;
import Logica.ObjetoPrecioso.HuevoDeDragon;
import Logica.VisitorPersonaje.Visitor;
import Logica.VisitorPowerUp.VisitorPowerUp;

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
	protected int cantDesplazada;
	protected int anchoRealCelda;
	protected boolean estaEnMovimiento = true;
	protected boolean deboPerder = false;
	protected int alcance = 2;
	
	//Se debe invocar cuando se muere.
	public void setPuntajeMonedas() 
	{
		mapa.obtenerPantalla().incrementarPuntaje(puntaje);
		mapa.obtenerPantalla().setPresupuesto(rangoMonedas);
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
	
	public void serAfectado(VisitorPowerUp p)
	{
		p.afectar(this);
	}
	
	public void setVelocidad(int v)
	{
		velocidad = v;
	}
	
	/**
	 * Modifica la ubicación del enemigo y actualiza su posición en el mapa
	 */
	public void mover()
	{			
		Posicion ubicacion = miCelda.getPosCelda();
		int miX = ubicacion.getEjeX();
		int miY = ubicacion.getEjeY();
		//Intento mover hacia la derecha
		if(miX + 1 < mapa.obtenerAncho())
		{
			int i = 1;
			boolean encontre = false;
			//verifico si hay alguien a mi alcance para atacar  
			while(i <= alcance && !encontre) 
			{
				if((miX + misCeldas.size() - 1 + i) < mapa.obtenerAncho()) 
				{
					Celda celdaSiguiente = mapa.obtenerCelda(new Posicion(miX + misCeldas.size() - 1 + i, miY));
					Contenido contenidoSiguiente = celdaSiguiente.getContenido();
					if(contenidoSiguiente != null) 
					{	
						estaEnMovimiento = false;
						setImagenQuieto();
						encontre = true;
						contenidoSiguiente.seratacado(this.proyectil);
					}	
				}
				i++;
			}
			
			if (estaEnMovimiento)
			{
				if(cantDesplazada >= anchoRealCelda)
				{		
					cantDesplazada = 0;
					//se actualiza la posición del enemigo en la matriz de celdas
					LinkedList<Celda> listaAux = new LinkedList<Celda>();
					int despl = 1;
					for(Celda c : misCeldas)
					{
						Posicion posc = c.getPosCelda();
						if(posc.getEjeX() + 1 < mapa.obtenerAncho())
						{
							Posicion p = new Posicion(miX + despl, miY);
							mapa.obtenerCelda(posc).setContenido(null);
							mapa.obtenerCelda(p).setContenido(this);
							listaAux.addLast(mapa.obtenerCelda(p));
							despl++;
						}
					}
					misCeldas.clear();
					for(Celda cAux : listaAux)
					{
						misCeldas.addLast(cAux);
					}
					miCelda = misCeldas.getFirst();
				}	
				else
					cantDesplazada = (int) (cantDesplazada + Math.pow(2, velocidad+1));
					
				//muevo el JLabel que representa al enemigo
				desplX = (int) (desplX + Math.pow(2,velocidad+1));
				mGrafico.setBounds(desplX, desplY, imagen.getIconWidth(), imagen.getIconHeight());
			}
		}
		else // significa que el enemigo ya atravesó el mapa (se debe perder el juego) 
		{ 		
			estaVivo = false; 
			miCelda.setContenido(null);
			deboPerder = true;		
		}		
	}
	
	public PowerUp generarPowerUp()
	{
		PowerUp puObtenido = null;
		double x = Math.random();
		if (x<=0.50)
		{
			HashMap<Integer,PowerUp> mapeoPowerUp = new HashMap<Integer,PowerUp>();
			mapeoPowerUp.put(0, new DuplicarFuerza());	
			mapeoPowerUp.put(1, new DuplicarVida());
			mapeoPowerUp.put(2, new CampoDeProteccion());
			mapeoPowerUp.put(3, new Bomba(miCelda,mapa));
			mapeoPowerUp.put(4, new HuevoDeDragon(miCelda,mapa));
			Random generador = new Random(System.currentTimeMillis());
			puObtenido = mapeoPowerUp.get(generador.nextInt(mapeoPowerUp.size()));
			generador.setSeed(generador.nextLong());//refresco datos aleatorios
			puObtenido = puObtenido.clone();
		}
		return puObtenido; 
	}
	
	public void generarCampoDeProteccion()
	{
		double x = Math.random();
		if(x <= 0.33)
		{
			CampoDeProteccion campoProteccion = new CampoDeProteccion();
			this.serAfectado(campoProteccion.getVisitor());
			this.getMapa().agregarPowerUp(campoProteccion);		
		}
	}
	
	public void controlarTamaño()
	{
		misCeldas.addLast(miCelda); //desde la posición de miCelda comenzaría el jlabel del enemigo (mGrafico)
		int cantCeldasAOcupar = imagen.getIconWidth() / (mapa.obtenerAnchoReal() / mapa.obtenerAncho());
		if(cantCeldasAOcupar > 1)
		{
			for(int i = 1; i <= cantCeldasAOcupar - 1; i++)
			{
				Posicion posNuevaCelda = new Posicion(miCelda.getPosCelda().getEjeX() + i, miCelda.getPosCelda().getEjeY());
				Celda nuevaCelda = new Celda(posNuevaCelda);	
				misCeldas.addLast(nuevaCelda);
			}
		}
	}
	
	public abstract void setImagenEnMovimiento();
	
	public abstract void setImagenQuieto();
}