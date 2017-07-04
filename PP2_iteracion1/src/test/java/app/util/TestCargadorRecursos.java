package app.util;

import org.junit.Test;

public class TestCargadorRecursos {
	
	@Test
	public void testLeerArchivoDeTexto() {
		String mapaAJugar = "MapaTank03.csv";
		CargadorRecursos.leerArchivoTexto(mapaAJugar);
	}
}
