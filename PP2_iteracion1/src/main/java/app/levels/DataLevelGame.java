package app.levels;

import java.util.*;
import app.object.*;

public class DataLevelGame 
{
	private int players;
	private int cantEnemigos;
	private Integer energyEnemy, energyPlayer;
	private HashMap<String, DriverEnemyTank> dificultad;
	private String typeDriver;
	
	public DataLevelGame(int players,int cantEnemy, Integer energyPlayer, String typeDriver)
	{
		this.dificultad = new HashMap<String, DriverEnemyTank>();
		
		this.setPlayers(players);
		this.setCantEnemigos(cantEnemy);
		this.setEnergyEnemy(new Random().nextInt(2)+1);
		this.setEnergyPlayer(energyPlayer);
		this.typeDriver = typeDriver;
	}
	
	public DataLevelGame()
	{
		this.dificultad = new HashMap<String, DriverEnemyTank>();
		this.setPlayers(1);
		this.setCantEnemigos(3);
		this.setEnergyEnemy(1);
		this.setEnergyPlayer(2);
		this.typeDriver = "facil";
	}

	public int getCantEnemigos() 
	{
		return cantEnemigos;
	}

	public Integer getEnergyEnemy() 
	{
		return energyEnemy;
	}

	public void setEnergyEnemy(Integer energyEnemy) 
	{
		this.energyEnemy = energyEnemy;
	}

	public Integer getEnergyPlayer() 
	{
		return energyPlayer;
	}

	public void setEnergyPlayer(Integer energyPlayer) {
		this.energyPlayer = energyPlayer;
	}

	public void setCantEnemigos(int cantEnemigos) 
	{
		this.cantEnemigos = cantEnemigos;
	}

	private void cargarClavesNiveles() 
	{
		this.dificultad.put("facil", new DriverEasyEnemyTank());
		this.dificultad.put("intermedio", new DriverIntermediateEnemyTank());
	}
	
	public DriverEnemyTank getNewDriverEnemy(Tank enemy) 
	{
		cargarClavesNiveles();
		DriverEnemyTank d = dificultad.get(typeDriver);
		d.setEnemyTank(enemy);
		return d;
	}
	
//	protected void setDriverEnemy()
//	{
//	//	this.driver = getNewDriverEnemy();
//	}

	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}
	
}