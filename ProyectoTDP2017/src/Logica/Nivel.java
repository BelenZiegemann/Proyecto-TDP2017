package Logica;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import Grafica.gMapa;
import Logica.CreadorEnemigo.CreadorEnemigo;

/**
 * Clase Nivel
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class Nivel extends Thread
{
	
	protected int numeroNivel;
	protected int retardoOleada; // en milisegundos
	protected FileReader fichero;
	protected BufferedReader br;
	protected String ruta;
	protected boolean Detener;
	protected boolean estaLeido;
	protected gMapa gmapa;
	
	public Nivel(int numeroNivel, String ruta, gMapa gm)
	{
		Detener = false;
		estaLeido = false;
		gmapa = gm;
		retardoOleada = 0;
		this.numeroNivel = numeroNivel;
		gm.obtenerMapaLogico().obtenerPantalla().setNivel(this.numeroNivel);
		this.ruta = ruta;
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
		{
			System.out.println("Ocurrió error de lectura");
		} 
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
	
}