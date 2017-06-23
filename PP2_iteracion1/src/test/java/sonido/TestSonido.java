package sonido;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestSonido {

	@Test
	public void testSonido() {
		assertNotNull(Sonido.PacmanChomp);
		assertNotNull(Sonido.TanqueDisparo);
		assertNotNull(Sonido.TanqueDisparoExplocion);
	}
}
