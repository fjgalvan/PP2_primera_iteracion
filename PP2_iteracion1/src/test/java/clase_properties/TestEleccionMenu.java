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
		eleccion.dificultad_elegido= "facil";
		eleccion.enemigos_elegido= 3;
		eleccion.juego_elegido="tank";
		eleccion.nivel_elegido="1";
		eleccion.vidas_elegido=2;
		eleccion.setDificultad_elegido("facil");
		eleccion.setEnemigos_elegido(3);
		eleccion.setJuego_elegido("tank");
		eleccion.setNivel_elegido("1");
		eleccion.setVidas_elegido(2);
	}
}
