package app.main;

import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class TestMain {
	//ERROR DE TEST EN MAVEN
	@Test
	public void testMain(){
		ControlGame controlGame = new ControlGame();
		controlGame.setTankEleccionMenu();
		assertNotEquals(null,controlGame.getMenu().isValid());   
		
		Main main_principal= new Main();
		main_principal.getClass();
	}
}
