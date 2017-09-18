package Grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.CaminanteBlanco;
import Logica.Enemigo;

/**
 * Clase gCaminanteBlanco
 * @author Bernabé Di Marco - Gabriel Ignacio Paez - Belén Ziegemann
 *
 */
public class gCaminanteBlanco 
{

	protected CaminanteBlanco caminanteB;
	protected Icon imagen;
	protected Point mPosicion;
	protected JLabel mGrafico;
	protected final int ancho = 32;
	protected final int alto = 32;
	
	public gCaminanteBlanco(int x, int y, Enemigo e) 
	{
		caminanteB = (CaminanteBlanco) e;
		mPosicion = new Point(x, y);
		imagen = new ImageIcon(this.getClass().getResource("/Imagenes/camBlanco.gif"));
		mGrafico = new JLabel(imagen);
		mGrafico.setBounds(mPosicion.x,mPosicion.y,ancho,alto);
	}
	
	public void mover() 
	{
		caminanteB.mover();
		mPosicion.x = mPosicion.x + 8;
		mGrafico.setBounds(mPosicion.x,mPosicion.y,ancho,alto);
	}
	
	public JLabel getGrafico()
	{
		return mGrafico;
	}
	
}
