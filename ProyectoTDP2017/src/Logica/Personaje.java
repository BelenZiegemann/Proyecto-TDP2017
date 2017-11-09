package Logica;

/**
 * Clase Abstracta Personaje
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class Personaje extends Contenido 
{

	protected int fuerzaImpacto = 10;
	protected int alcance = 1;
	protected boolean estaVivo = true;
	protected int desplX;
	protected int desplY;
	
	
	public abstract void seratacado(Visitor p);
	
	public int getVida()
	{
		return puntosVida;
	}

	public int getAlcance()
	{
		return alcance;
	}
	
	public int getFuerzaImpacto()
	{
		return fuerzaImpacto;
	}
	
	public boolean estaVivo()
	{
		return estaVivo;
	}
	
	public void setVida(int v)
	{
		puntosVida = v;
	}
	
	public abstract void mover();
	
	public void setEstaVivo(boolean b) {
		
		estaVivo = b;
	}

}