package app.levels;

import static org.junit.Assert.*;

import org.junit.Test;

import clase_properties.Principal;

public class TestManagerLevelGameDefault {

	@Test
	public void getDataLevelGame() 
	{
		ManagerLevelGameDefault manager = new ManagerLevelGameDefault();
		assertTrue(manager.getDataLevelGame()!=null);
		assertFalse(manager.getDataLevelGame()==null);		
	}

	@Test
	public void testBuildDataGame()
	{
		ManagerLevelGameDefault manager = new ManagerLevelGameDefault();
		assertTrue(manager.buildDataGame()!=null);
		ManagerLevelGameDefault error = new ManagerLevelGameDefault();		
		error.setNext(null);
		assertTrue(manager.buildDataGame()!=null);
		assertFalse(error.buildDataGame()==null);
	}

}
