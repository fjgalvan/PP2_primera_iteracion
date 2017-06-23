package app.main;

import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class TestMain {
	
	@Test
	public void testMain(){
		ControlGame controlGame = new ControlGame();
		controlGame.setTankEleccionMenu();
		assertNotEquals(null,controlGame.getMenu().isValid());   
	}
}
