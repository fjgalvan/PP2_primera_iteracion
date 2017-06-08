package app.modelo;

import java.util.List;

import app.enums.TankShot;
import app.main.Game;
import app.object.DriverEasyEnemyTank;
import app.object.DriverIntermediateEnemyTank;
import app.object.Tank;
import app.object.TankController;

public class Destructor {
	private Colisionador colisionador;
	
	public Destructor(){
		this.colisionador = Colisionador.getColisionador();
	}
	//Player
	public void destruccionTank(Tank enemyTank, List<Tank> tanks, Tank tank,TankController tControl,TankController tControlCop){
		if(colisionador.colisionBulletConTank(enemyTank.getBullet(), tanks)){
			enemyTank.setTankBullet(TankShot.NO_EXISTS);
			enemyTank.setBullet(null);
			debilitarTankPlayer(tanks, tank, tControl, tControlCop);
		}
	}
	
	private void debilitarTankPlayer(List<Tank> tankList,Tank tank,TankController tControl,TankController tControlCop) 
	{
		Tank t = colisionador.getTankADestruir();
		t.decreaseHP();
		if(t.getEnergyVal()==0)
		{
			destruirTankPlayer(tankList, tank, tControl, tControlCop);
		}
	}

	private void destruirTankPlayer(List<Tank> tanksPlayers,Tank tank,TankController tControl,TankController tControlCop) {
		tanksPlayers.remove(colisionador.getTankADestruir());
		if(!tanksPlayers.contains(tank))
			tControl.destruirTank();
		else
			tControlCop.destruirTank();
	}
	
	//ENEMIGOS
	public void destruccionTanksEnemys(Tank tank, List<Tank> tanks, List<Tank> enemysTanks,String player, Tank enemyTank,DriverEasyEnemyTank enemyTankControl,
			Tank enemyTank2, DriverEasyEnemyTank enemyTankControl2, Tank enemyTank3, DriverEasyEnemyTank enemyTankControl3,
			Tank enemyTank4, DriverIntermediateEnemyTank enemyTankControl4) {
		if(colisionador.colisionBulletConTank(tank.getBullet(), enemysTanks)){
			tank.setTankBullet(TankShot.NO_EXISTS);
			tank.setBullet(null);
			debilitarEnemyTank(enemysTanks,player, enemyTank, enemyTankControl,enemyTank2, enemyTankControl2,enemyTank3, enemyTankControl3,enemyTank4, enemyTankControl4);
			Game.sumarPuntaje(player);
		}
		tanks.remove(tank);
		if(colisionador.colisionBulletConTank(tank.getBullet(), tanks)){
			tank.setTankBullet(TankShot.NO_EXISTS);
			tank.setBullet(null);
		}
		tanks.add(tank);
	}

	private void debilitarEnemyTank(List<Tank> tankList,String player, Tank enemyTank,DriverEasyEnemyTank enemyTankControl,
			Tank enemyTank2, DriverEasyEnemyTank enemyTankControl2, Tank enemyTank3, DriverEasyEnemyTank enemyTankControl3,
			Tank enemyTank4, DriverIntermediateEnemyTank enemyTankControl4) 
	{
		Tank t = colisionador.getTankADestruir();
		t.decreaseHP();
		if(t.getEnergyVal()==0)
		{
			destruirEnemyTank(tankList,player, enemyTank, enemyTankControl,enemyTank2, enemyTankControl2,enemyTank3, enemyTankControl3,enemyTank4, enemyTankControl4);
		}
	}
	
	private void destruirEnemyTank(List<Tank> enemysTanks,String player, Tank enemyTank,DriverEasyEnemyTank enemyTankControl,
			Tank enemyTank2, DriverEasyEnemyTank enemyTankControl2, Tank enemyTank3, DriverEasyEnemyTank enemyTankControl3,
			Tank enemyTank4, DriverIntermediateEnemyTank enemyTankControl4) {
		enemysTanks.remove(colisionador.getTankADestruir());
		if(!enemysTanks.contains(enemyTank))
			enemyTankControl.destruirTank();
		if(!enemysTanks.contains(enemyTank2))
			enemyTankControl2.destruirTank();
		if(!enemysTanks.contains(enemyTank3))
			enemyTankControl3.destruirTank();
		if(!enemysTanks.contains(enemyTank4))
			enemyTankControl4.destruirTank();
		Game.sumarCantidadDeEnemigosAsesinados(player);
	}
	
	//ESTRUCTURAS
	public void destruirEstructuras(){
		
	}
	
	public Colisionador getColisionador() {
		return colisionador;
	}
}
