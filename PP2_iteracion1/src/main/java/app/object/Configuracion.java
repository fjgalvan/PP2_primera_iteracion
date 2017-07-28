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
	public static final int MaximoY = 560;
	public static final String rutaProperties = "src/main/resources/properties/archivo.properties";//"src/main/java/properties/archivo.properties";
	public static String IMGFANTASMA = "imagen/fantasma"+String.valueOf((new Random().nextInt(4)+1))+".png";
	public static String MapaTank = "/mapas/MapaTank0" + String.valueOf((new Random().nextInt(5)+1))+".csv";
	public static String MapaBomberman = "/mapas/Bomberman01.csv";
	public static String MapaPacman = "/mapas/Pacman01.csv";
	
	public static final int MinCoordinateX = 20;
	public static final int MaxCoordinateX = 946;
	public static final int MinCoordinateY = 20;
	public static final int MaxCoordinateY = 547;
}
