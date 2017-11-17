package Grafica.Threads;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import Grafica.GUI.gMapa;
import Logica.Celda;
import Logica.Enemigo;
import Logica.Posicion;
import Logica.CreadorEnemigo.CreadorEnemigo;
import Logica.ObstaculosConVida.Arbol;
import Logica.ObstaculosConVida.ObstaculoConVida;
import Logica.ObstaculosConVida.Piedra;
import Logica.ObstaculosConVida.Torre;

/**
 * Clase Nivel
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Nivel extends Thread
{
	
	private int numeroNivel;
	private int retardoOleada; // en milisegundos
	private FileReader fichero;
	private BufferedReader br;
	private String ruta;
	protected volatile boolean Detener;
	private boolean estaLeido;
	private gMapa gmapa;
	
	public Nivel(int numeroNivel, String ruta, gMapa gm)
	{
		Detener = false;
		estaLeido = false;
		gmapa = gm;
		retardoOleada = 0;
		this.numeroNivel = numeroNivel;
		gm.obtenerMapaLogico().obtenerPantalla().setNivel(this.numeroNivel);
		this.ruta = ruta;
		//agrego los obstáculos con Vida
		agregarObstaculosConVida();
	}
	
	public void run()
	{	
		abrirArchivo();
		try 
		{
			String linea = br.readLine();
			while(linea != null)
			{
				if((linea.trim().length() > 0) && (linea.charAt(0) == '_'))
				{	
					String StringRetardo = linea.substring(1);
					retardoOleada = Integer.parseInt(StringRetardo.trim()) * 1000; // lo paso a milisegundos	
				}
				else 
				{
					if(linea.trim().length() == 0) // si es una linea en blanco
					{							   // es porque ya leí todos los enemigos de una oleada
						hacerRetardo();
					}
					else
					{ 	// estoy en la linea que tiene el nombre del enemigo y la posición en Y.
						// La posición en X inicialmente es cero
						int posGuion = linea.indexOf('-');
						String stringEnemigo = linea.substring(0, posGuion);
						String stringPosY = linea.substring(posGuion+1);
						int posY = Integer.parseInt(stringPosY.trim());
						
						//StringEnemigo se convertirá en una clase
						Class<?> claseEnem = Class.forName("Logica.CreadorEnemigo." + stringEnemigo);
						Constructor<?> constructor = claseEnem.getConstructor();
						Object creadorEnem = constructor.newInstance();
						
						//Creo al enemigo
						Posicion posEnem = new Posicion(0,posY);
						Celda miCelda = gmapa.obtenerMapaLogico().obtenerCelda(posEnem);
						Enemigo e = ((CreadorEnemigo) creadorEnem).crearEnemigo(miCelda, gmapa.obtenerMapaLogico());			
						gmapa.agregarEnemigo(e);					
					}
					
				}
				linea = br.readLine();
		
			}
			
		estaLeido = true;// significa que las tres tandas de enemigos ya están colocadas en el mapa	
		cerrarArchivo();	
		} 
		catch (IOException e)
		{} 
		catch (ClassNotFoundException e)
		{}
		catch (SecurityException e) 
		{} 
		catch (IllegalArgumentException e)
		{}
		catch (NoSuchMethodException e) 
		{} 
		catch (InstantiationException e) 
		{} 
		catch (IllegalAccessException e) 
		{} 
		catch (InvocationTargetException e)
		{}
	}
	
	public boolean estaLeido()
	{
		return estaLeido;		
	}

	private void hacerRetardo()
	{
		try
		{
			Thread.sleep(retardoOleada);
		} catch (InterruptedException e) 
		{}
	}
	
	private void abrirArchivo()
	{
		try
		{   
			fichero = new FileReader (new File(ruta));
			br = new BufferedReader(fichero);
		}
		catch (IOException e) 
		{
			System.out.println("Error al abrir el archivo");
	    	//si se produjo un error intento cerrar el archivo
			cerrarArchivo();
		}
	}

	private void cerrarArchivo()
	{
		try 
    	{ 
            if (fichero != null)
            {
            	fichero.close();
            	detener();
            }
            
    	}
        catch (Exception e) 
        {
            System.out.println("Error al cerrar el archivo");
		}	
	}
	
	public void detener() 
	{
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt();
		// Seteamos el flag para detener su ejecución.
		Detener = true;
	}
	
	public int getNumNivel()
	{
		return numeroNivel;
	}
	
	public void agregarObstaculosConVida()
	{
		Random aleatorio = new Random(System.currentTimeMillis());
		int cantObstaculos = aleatorio.nextInt(6) + 1; // número aleatorio entre 1 y 6
		int posX, posY, obstaculoElegido;
		//Refresco datos aleatorios 
		aleatorio.setSeed(aleatorio.nextLong());
		for(int i=1; i <= cantObstaculos; i++)
		{
			posX = aleatorio.nextInt(8)+1; //número aleatorio entre 1 y 8
			aleatorio.setSeed(aleatorio.nextLong());//refresco datos aleatorios
			posY = aleatorio.nextInt(6); //número aleatorio entre 0 y 5
			aleatorio.setSeed(aleatorio.nextLong());//refresco datos aleatorios
			obstaculoElegido = aleatorio.nextInt(3); //número aleatorio entre 0 y 2
			Posicion posObs = new Posicion(posX,posY);
			Celda celdaObs = gmapa.obtenerMapaLogico().obtenerCelda(posObs);
			ObstaculoConVida obsVida;
			if(obstaculoElegido == 0)
			{
				obsVida = new Piedra(celdaObs, gmapa.obtenerMapaLogico());
				gmapa.agregarObstaculoConVida(obsVida);
			}
			else
				if(obstaculoElegido == 1)
				{
					obsVida = new Arbol(celdaObs, gmapa.obtenerMapaLogico());
					gmapa.agregarObstaculoConVida(obsVida);
				}
				else
				{
					obsVida = new Torre(celdaObs, gmapa.obtenerMapaLogico());
					gmapa.agregarObstaculoConVida(obsVida);
				}
			aleatorio.setSeed(aleatorio.nextLong());//refresco datos aleatorios
		}
	
	}
}