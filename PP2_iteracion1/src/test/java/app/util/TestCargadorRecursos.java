package app.util;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestCargadorRecursos {
	
	@Test
	public void testLeerArchivoDeTexto() {
		String mapaAJugar = "/mapas/MapaTank03.csv";
		CargadorRecursos.leerArchivoTexto(mapaAJugar);
		assertNotNull(mapaAJugar);
	}
}
