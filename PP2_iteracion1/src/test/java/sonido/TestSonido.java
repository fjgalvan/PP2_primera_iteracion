package sonido;
//import static org.junit.Assert.*; 

import org.junit.Test;

public class TestSonido {
	//ERROR DE TEST CON MAVEN
	@Test
	public void testSonido() {
		//assertNotNull(Sonido.PacmanChomp);
		//assertNotNull(Sonido.TanqueDisparo);
		//assertNotNull(Sonido.TanqueDisparoExplocion);
		
		//Sonido sonido= new Sonido();
		Sonido.getPacmanchomp();
		Sonido.getTanquedisparo();
		Sonido.getTanquedisparoexplocion();
		Sonido.TanqueDisparo.play();
		Sonido.TanqueDisparo.stop();
		
		Sonido.PacmanChomp.stop();
		Sonido.PacmanChomp.play();
		Sonido.TanqueDisparoExplocion.stop();
		Sonido.TanqueDisparoExplocion.play();

	}
}
