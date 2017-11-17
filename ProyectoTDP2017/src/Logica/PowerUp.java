package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JLabel;
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
	protected String mensajeEstadoPU;
	protected Icon imagen;
	protected JLabel mGrafico;
	protected Celda miCelda;
	protected Mapa mapa;
	protected int desplX;
	protected int desplY;

	protected PowerUp()
	{
		timer = new Timer(0, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				accionFinTimer();
			}
		});
		timer.setRepeats(false);
		mensajeEstadoPU = "";
		imagen = null;
		mGrafico = null;
		miCelda = null;
		mapa = null;
		desplX = 0;
		desplY = 0;	
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

	public void setMensajeEstadoPU(String mensaje)
	{
		mensajeEstadoPU = mensaje;
	}
	
	public String mensajeEstadoPU()
	{
		return mensajeEstadoPU;
	}

	public JLabel getGrafico()
	{
		return mGrafico;
	}
	
	public Celda getCelda() 
	{
		return miCelda;
	}
	
	public void setCelda(Celda c)
	{
		miCelda = c;
	}
	
	public void actualizarPosGrafico()
	{	
		desplX = (mapa.obtenerAnchoReal() / mapa.obtenerAncho()) * miCelda.getPosCelda().getEjeX();
		desplY = (mapa.obtenerAltoReal() / mapa.obtenerAlto()) * miCelda.getPosCelda().getEjeY();						
		mGrafico.setBounds(desplX, desplY ,imagen.getIconWidth(),imagen.getIconHeight());		
	}

	public abstract void accionFinTimer();
	
	@Override
	public abstract PowerUp clone();
}