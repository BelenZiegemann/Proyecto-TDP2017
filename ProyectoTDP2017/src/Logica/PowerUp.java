package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Logica.VisitorPowerUp.VisitorPowerUp;

/**
 * Clase Abstracta PowerUp
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public abstract class PowerUp 
{
	protected VisitorPowerUp visitorPU;
	protected Timer timer;

	protected PowerUp()
	{
		timer = new Timer(0, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				deshacerAccion();
			}
		});
		timer.setRepeats(false);
	}
	
	public void iniTimer()
	{
		timer.start();	
	}
	
	public Timer getTimer()
	{
		return timer;
	}
	
	public VisitorPowerUp getVisitor()
	{
		return visitorPU;
	}

	public abstract String mensajeEstadoPU();
	
	public abstract void deshacerAccion();
	
	@Override
	public abstract PowerUp clone();
}