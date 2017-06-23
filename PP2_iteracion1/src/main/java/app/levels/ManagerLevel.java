package app.levels;

import java.util.*;
import javax.swing.JOptionPane;
import app.object.*;
import clase_properties.*;

public class ManagerLevel 
{
	private ValidateFile validator;
	private EleccionMenu eleccion;
	private HashMap<String, DriverEnemyTank> dificultad;
	private Principal configuracion ;
	
	public ManagerLevel(Principal archivo)
	{
		this.configuracion = archivo;
		this.validator = new ValidateFile(configuracion);
		this.cargarClavesNiveles();
	}
	
	private void cargarClavesNiveles() 
	{
		this.dificultad = new HashMap<String, DriverEnemyTank>();
		this.dificultad.put("facil", new DriverEasyEnemyTank());
		this.dificultad.put("intermedio", new DriverIntermediateEnemyTank());
	}

	private DataLevelGame buildLevelGame()
	{
		int players = Integer.parseInt(eleccion.getNivel_elegido());
		int cant = eleccion.getEnemigos_elegido();		
		Integer energyPlayer = (eleccion.getVidas_elegido());
		String typeDriver = eleccion.getDificultad_elegido();
		return new DataLevelGame(players, cant, energyPlayer, typeDriver); // objeto set de datos para el nivel
	}

	public DataLevelGame getDataLevelGame()
	{
		if(validator.archivoValido())
		{
			this.eleccion = configuracion.leerArchivo();
			return buildLevelGame();
		}
		JOptionPane.showMessageDialog(null, "Errores de datos en el archivo - clase manager");
		return DataLevelGame.getDefaultDataGame();
	}
	
//	private DriverEnemyTank getNewDriverEnemy() 
//	{
//		dificultad.clear();
//		cargarClavesNiveles();
//		return dificultad.get(eleccion.getDificultad_elegido());
//	}
		
	
}
