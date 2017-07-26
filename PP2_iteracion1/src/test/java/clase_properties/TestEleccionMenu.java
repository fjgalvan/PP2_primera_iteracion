package clase_properties;

import org.junit.Test;

public class TestEleccionMenu {
	@Test
	public void testEleccionMenu(){
		EleccionMenu eleccion= new EleccionMenu("facil", 3, "tank", "1", 2);
		eleccion.getDificultad_elegido();
		eleccion.getEnemigos_elegido();
		eleccion.getJuego_elegido();
		eleccion.getNivel_elegido();
		eleccion.getVidas_elegido();
	}
}
