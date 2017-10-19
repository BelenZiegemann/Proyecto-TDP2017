package Logica;

import javax.swing.JLabel;

public abstract class Obstaculo extends Contenido {
	protected JLabel mGrafico;
	protected boolean estaVivo;
	
	public JLabel getGrafico()
	{
		return mGrafico;
	}
	
	public boolean estaVivo() {
		return estaVivo;
	}
	
	public void setEstaVivo(boolean b) {
		estaVivo = b;
	}
}
