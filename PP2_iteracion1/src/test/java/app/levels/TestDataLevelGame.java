package app.levels;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;

import org.junit.Test;

import app.enums.Orientation;
import app.object.DriverEasyEnemyTank;
import app.object.DriverEnemyTank;
import app.object.DriverIntermediateEnemyTank;
import app.object.Tank;

public class TestDataLevelGame {

	@Test
	public void testGetCantEnemigos() 
	{
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		assertTrue(data.getCantEnemigos()==4);
		assertFalse(data.getCantEnemigos()==3);
	}

	@Test
	public void testGetEnergyEnemy() 
	{
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		assertTrue(data.getEnergyEnemy()>0 && data.getEnergyEnemy()<3);
		assertFalse(data.getEnergyEnemy()==0 || data.getEnergyEnemy()==3);
	}

	@Test
	public void testSetEnergyEnemy() 
	{
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		data.setEnergyEnemy(2);
		assertTrue(data.getEnergyEnemy()==2);
		assertFalse(data.getEnergyEnemy()!=2);
	}

	@Test
	public void testGetEnergyPlayer() 
	{
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		assertTrue(data.getEnergyPlayer()==2);
		assertFalse(data.getEnergyPlayer()!=2);
	}

	@Test
	public void testSetEnergyPlayer() 
	{
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		assertTrue(data.getEnergyPlayer()==2);
		data.setEnergyPlayer(1);
		assertFalse(data.getEnergyPlayer()==2);
		assertTrue(data.getEnergyPlayer()==1);
	}

	@Test
	public void testSetCantEnemigos() 
	{
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		assertTrue(data.getCantEnemigos()==4);
		data.setCantEnemigos(1);
		assertFalse(data.getCantEnemigos()==4);
	}

	@Test
	public void testCargarClavesNiveles() 
	{
		DataLevelGame data = new DataLevelGame();
		assertTrue(data.getMapa().get("facil")==null);
		data.cargarClavesNiveles();
		assertTrue(data.getMapa().get("facil")!=null);
	}
	
	@Test
	public void testGetNewDriverEnemy() 
	{
		DataLevelGame data = new DataLevelGame();
		Tank tank = new Tank(Orientation.LEFT, new Point(300, 200), new Point(40, 40), 2);
		data.cargarClavesNiveles();
		DriverEnemyTank driver = data.getNewDriverEnemy(tank);
		assertTrue(driver!=null);
	}

	@Test
	public void testGetMapa()
	{
		DataLevelGame data = new DataLevelGame();
		assertTrue(data.getMapa()!=null);
	}
	
	@Test
	public void testGetPlayers() 
	{
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		assertTrue(data.getPlayers()==2);
		assertFalse(data.getPlayers()==1);
	}

	@Test
	public void testSetPlayers() 
	{
		DataLevelGame data = new DataLevelGame(2, 4, 2, "facil");
		assertTrue(data.getPlayers()==2);
		data.setPlayers(1);
		assertTrue(data.getPlayers()==1);
	}
	
}
