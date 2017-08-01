package imagen;

import java.awt.Image;

import javax.swing.ImageIcon;

public class CargarImagen {
	public CargarImagen( )
	{
	}
	public  Image cargarImagen(String archivo) 
	{
		return new ImageIcon(ClassLoader.getSystemResource(archivo)).getImage();
		//return new ImageIcon(archivo).getImage();
	}
}
