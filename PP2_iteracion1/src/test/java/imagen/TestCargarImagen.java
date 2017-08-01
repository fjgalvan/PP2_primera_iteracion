package imagen;

import org.junit.Test;

public class TestCargarImagen {
	@Test
	public void testCargarImagen() 
	{
		String archivoImagen= "imagen/tank.png";
		CargarImagen cargarI= new CargarImagen();
		cargarI.cargarImagen(archivoImagen);
	}
}
