package clase_properties;

import org.junit.Test;

public class TestPrincipal {
	@Test
	public void testPrincipal(){
		Principal principal= new Principal();
		principal.leerArchivo();
		EleccionMenu eleccion= new EleccionMenu("facil", 3, "tank", "1", 2); 
		principal.ModificarArchivo(eleccion);
		
	}
}
