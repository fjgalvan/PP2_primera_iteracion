package app.levels;

import java.awt.Point;
import java.util.*;
import app.enums.Orientation;
import app.modelo.*;
import app.object.*;

public class LevelEasy 
{
	private List<Tank> enemigos,players;
	private Tank tankPlayer1,tankPlayer2;
	private List<DriverEnemyTank> drives;
	private List<Point> coordinates;
	private DataLevelGame level;
	private TankController tankController, tankCopController ;
	public static String P1 = "0";
	public static String P2 = "0";
	private int index=0;
	
	public LevelEasy(DataLevelGame plevel)
	{
		this.enemigos = new ArrayList<Tank>();
		this.players =  new ArrayList<Tank>();
		this.drives = new ArrayList<>();
		this.coordinates = new ArrayList<Point>(); 
		this.level = plevel; 
		this.crearTanquesPlayers();
		this.cargarCoordenadasValidas();
		this.cargarEnemys();
	}
	
	public void inicializar(List<ObjetoGrafico> objetos)
	{
		this.crearTanquesPlayers();
		//this.cargarCoordenadasValidas();
		this.cargarEnemys();
		this.controlTanquesEnemigos(objetos);
		//this.accionarDeEnemys(objetos);
	}

	public DriverEnemyTank crearDriverEnemyTank(Tank t)
	{
		return level.getNewDriverEnemy(t);
	}
	
	private void controlTanquesEnemigos(List<ObjetoGrafico> lista) 
	{
		for(DriverEnemyTank driver : drives)
		{
			driver.ControlTank(lista);
		}
	}

	private void cargarEnemys() 
	{
		for (int i=0; i<level.getCantEnemigos(); i++)
		{
			Tank tank_aux = new Tank(Orientation.UP,getNextCoordinate(),new Point(36,36),level.getEnergyEnemy());
			this.enemigos.add(tank_aux);		
			DriverEnemyTank driver_aux = level.getNewDriverEnemy(tank_aux);
			this.drives.add(driver_aux);
			index++;
		}
	}
	
	public void cargarCoordenadasValidas()
	{
		this.coordinates.add(new Point(40,40));
		this.coordinates.add(new Point(440,40));
		this.coordinates.add(new Point(720,40));
		this.coordinates.add(new Point(520,120));
	}
	
	public Point getNextCoordinate()
	{   if(index > 4){   index=0;}
		return coordinates.get(index);}
	public void crearTanquesPlayers()
	{
		tankPlayer1 = new Tank(Orientation.UP,new Point(560,520),new Point(40,40),level.getEnergyPlayer());
		this.players.add(tankPlayer1);
		// en el listener tiene qe ir el entorno
		tankController = new TankController(tankPlayer1, new ListenerPlayer1(Configuracion.ENTORNO), Colisionador.getInstance()); //
		P1 = "1";
		if(level.getPlayers()==2)
		{	
			P2 = "2";
			tankPlayer2 = new Tank(Orientation.UP,new Point(360,520),new Point(40,40),level.getEnergyPlayer());
			this.players.add(tankPlayer2);
			tankCopController = new TankController(tankPlayer2, new ListenerPlayer2(Configuracion.ENTORNO), Colisionador.getInstance());
		}			
	}
	public boolean isModeCopActivate()
	{
		return level.getPlayers()==2;
	}
	
	public void controlarPlayer(Player player,Player player2, List<ObjetoGrafico> objetos)
	{		
		Tank tank1 = this.players.get(Integer.parseInt(P1)-1);
 		if(this.players.contains(tank1))
 		{
    		player.getListener().seMovio(tank1);
    		this.tankController.ControlTank(objetos);
    		this.tankController.control_bullet(objetos, enemigos);
    		//destructor.destruccionTanksEnemys(tank1, this, P1);
 		}	
        //COOP
 		Tank tank2 = this.players.get(Integer.parseInt(P2)-1);
        if(this.players.contains(tank2))
        {
        	player2.getListener().seMovio(tank2);
        	this.tankCopController.ControlTank(objetos);
        	this.tankCopController.control_bullet(objetos,enemigos);
        //	destructor.destruccionTanksEnemys(tank2, this, P2);
        }
	}
	public List<Tank> getEnemigos() {    return enemigos;}
	public List<Tank> getPlayers() {    return players;}
	public void puntajes(){
//		player1 = new Player1(new Puntaje(0,0),dibujador);
//		player2 = new Player2(new Puntaje(0,0),dibujador);
	}
	public boolean finishLevel()
	{   return players.isEmpty() || enemigos.isEmpty(); }// ver si funciona estoo}
	public void destruirTankEnemy(Tank enemy)
	{   this.enemigos.remove(enemy);
		encontrarDriverDeTankEnemy(enemy);}
	public void setEnemigos(List<Tank> enemigos) {this.enemigos = enemigos;}
	public void setPlayers(List<Tank> players) {this.players = players;}
	public void encontrarDriverDeTankEnemy(Tank enemy){/** destruir drivers enemys */
		for(int i = 0; i < this.drives.size();i++){
			if(this.drives.get(i).getEnemyTank().equals(enemy))
				this.drives.remove(i);}
	}
	public void destruirDriverEnemy(DriverEnemyTank driver)
	{  this.drives.remove(driver);}/** fin de destruir drivers enemys */
	public void destruirTankPlayer(Tank player)
	{   this.tankController.destruirTank(); // ver como hacer lo del cop
		this.players.remove(player);}
	public void destruirTankPlayer1(Tank player)
	{   this.tankController.destruirTank(); // ver como hacer lo del cop
		this.players.remove(this.tankPlayer1);}
	public void destruirTankPlayer2(Tank player)
	{   this.tankCopController.destruirTank(); // ver como hacer lo del cop
		this.players.remove(this.tankPlayer2);}
	public Integer getEnergyPlayer() {return level.getEnergyPlayer();}
	public List<DriverEnemyTank> getDrives() {return drives;}
	public boolean containsPlayer1() {return players.contains(tankPlayer1);}
	public boolean containsPlayer2() {return players.contains(tankPlayer2);}
	public Tank getTankPlayer1() {return tankPlayer1;}
	public Tank getTankPlayer2() {return tankPlayer2;}
	public TankController getTankController() {return tankController;}
	public TankController getTankCopController() {return tankCopController;}

}
