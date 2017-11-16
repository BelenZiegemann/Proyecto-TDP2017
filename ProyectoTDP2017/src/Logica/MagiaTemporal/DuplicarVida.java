package Logica.MagiaTemporal;

import Logica.Jugador;
import Logica.PowerUp;

public class DuplicarVida extends MagiaTemporal
{
	public DuplicarVida()
	{
		super();
		tiempo = 11;
		timer.setInitialDelay(tiempo * 1000);
	}
	
	public void accion(Jugador j)
	{
		j.setVida(2 * j.getVida());
		jugadorConMagia = j;
		iniTimer();
		mensajeEstadoMagia = "Vida Duplicada ACTIVADA";
	}
	
	public void deshacerAccion()
	{
		jugadorConMagia.setVida(jugadorConMagia.getVida() / 2);
		mensajeEstadoMagia = "Vida Duplicada DESACTIVADA";
	}
	
	public PowerUp clone()
	{
		return new DuplicarVida();
	}

}
