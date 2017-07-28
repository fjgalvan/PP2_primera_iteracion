package app.levels;

import static org.junit.Assert.*;
import org.junit.Test;
import clase_properties.Principal;

public class TestManagerLevelGameMain {

	/*@Test
	public void testGetDataLevelGame()
	{
		ManagerLevelGameMain main = new ManagerLevelGameMain(new Principal());
		assertTrue(main.getDataLevelGame()!=null);
		ManagerLevelGameMain error = new ManagerLevelGameMain(null);
		assertTrue(error.getDataLevelGame()==null);
	}*/	
	
	@Test
	public void testBuildDataGame()
	{
		ManagerLevelGameMain main = new ManagerLevelGameMain(new Principal());
		assertTrue(main.buildDataGame()!=null);
		ManagerLevelGameMain error = new ManagerLevelGameMain(null);
		assertFalse(error.buildDataGame()==null);
	}
}
