package app.object;

import java.util.Random;
import entorno.Entorno;

public class Configuracion 
{
	public static Entorno ENTORNO = null;
	
	public static final double VelocidadTanque = 2;
	public static final int CantidadMayorLista = 50;
	public static final int CantidadMenorLista = 0;
	
	public static final int MinimoX = 40;
	public static final int MaximoX = 880;
	public static final int MinimoY = 40;
	public static final int MaximoY = 520;

	public static String IMGFANTASMA = "imagen/fantasma"+String.valueOf((new Random().nextInt(4)+1))+".png";
}
