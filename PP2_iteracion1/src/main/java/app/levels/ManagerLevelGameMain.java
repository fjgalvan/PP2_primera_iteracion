package app.levels;

import javax.swing.JOptionPane;
import clase_properties.*;

public class ManagerLevelGameMain extends ManagerLevelGame
{
	private ValidateFile validator;
	private EleccionMenu eleccion;
	private Principal configuracion ;
	
	public ManagerLevelGameMain(Principal archivo)
	{
		this.configuracion = archivo;
		this.validator = new ValidateFile(configuracion);
		this.setNext(new ManagerLevelGameDefault()); 
	}

	public DataLevelGame getDataLevelGame()
	{
		if(validator.archivoValido())
		{
			this.eleccion = configuracion.leerArchivo();
			int players = Integer.parseInt(eleccion.getNivel_elegido());
			int cant = eleccion.getEnemigos_elegido();		
			Integer energyPlayer = (eleccion.getVidas_elegido());
			String typeDriver = eleccion.getDificultad_elegido();
			return new DataLevelGame(players, cant, energyPlayer, typeDriver);
		}
		JOptionPane.showMessageDialog(null, "Errores de datos en el archivo");
		return null;
	}	
	
}
