package mapas;

import static org.junit.Assert.assertNotNull;

import java.awt.Image;

import javax.swing.ImageIcon;

import app.mapa.MapaTiled;

public class CargarMapas {
	public CargarMapas( )
	{
	}
	
	public  void cargarMapa(String archivo) 
	{
		MapaTiled mapa = new MapaTiled(archivo);
		mapa.inicializar();
		assertNotNull(mapa);
	}
}
