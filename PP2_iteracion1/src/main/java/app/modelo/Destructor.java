package app.modelo;

import app.levels.LevelEasy;
import app.main.Game;
import app.object.*;

public class Destructor {
	private Colisionador colisionador;
	
	public Destructor(){
		this.colisionador = Colisionador.getInstance();
	}
	//Player
		public void destruccionTank(Tank enemyTank, LevelEasy level)
		{
			if(colisionador.colisionBulletConTank(enemyTank.getBullet(), level.getPlayers()))
			{
				enemyTank.impactBullet();
				Tank tank = colisionador.getTankADestruir();
				tank.decreaseHP();
				if(tank.getEnergyVal()==0)
				{
					if(level.getTankPlayer1().coordinate.equals(tank.coordinate))
						level.destruirTankPlayer1(tank);
					else
						level.destruirTankPlayer2(tank);
				}
			}
		}
		
		//ENEMIGOS
		public void destruccionTanksEnemys(Tank tank,LevelEasy level,String player) 
		{
			if(colisionador.colisionBulletConTank(tank.getBullet(), level.getEnemigos()))
			{
				tank.impactBullet();
				debilitarEnemyTank(level,player);
				Game.sumarPuntaje(player);
			}
			level.getPlayers().remove(tank);
			if(colisionador.colisionBulletConTank(tank.getBullet(), level.getPlayers()))
			{
				tank.impactBullet();
			}
			level.getPlayers().add(tank);
		}

		private void debilitarEnemyTank(LevelEasy level,String player) 
		{
			Tank t = colisionador.getTankADestruir();
			t.decreaseHP();
			if(t.getEnergyVal()==0)
			{
				level.destruirTankEnemy(t);
				Game.sumarCantidadDeEnemigosAsesinados(player);
			}
		}
	
		//ESTRUCTURAS
		public void destruirEstructuras(ListStructures estructuras){
			if(colisionador.getObjetoADestruir()!=null){
				if(colisionador.getObjetoADestruir().getNombre().equals("Ladrillo")){
					estructuras.getLista().remove(colisionador.getObjetoADestruir());
				}
				colisionador.setObjetoADestruir(null);
			}
		}
	
	public Colisionador getColisionador() {
		return colisionador;
	}
}
