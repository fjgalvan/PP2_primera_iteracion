package app.levels;

import javax.swing.JOptionPane;

import clase_properties.EleccionMenu;
import clase_properties.Principal;

public class ValidateFile 
{
	private Principal configuracion;
	
	public ValidateFile (Principal archivo)
	{
		this.configuracion = archivo;
	}
	
	public boolean existeElArchivo()		// o no se puede leer
	{
		return configuracion.leerArchivo()!=null;
	}
	
	public boolean validacionesDeDatos()
	{
		boolean ret = true;
		if(existeElArchivo())
		{
			EleccionMenu e = configuracion.leerArchivo();
			ret = ret && (e.getDificultad_elegido().equals("facil") || e.getDificultad_elegido().equals("intermedio"));
			ret = ret && e.getEnemigos_elegido()>1 && e.getEnemigos_elegido()<5;
			ret = ret && e.getVidas_elegido()>0 && e.getVidas_elegido()<3;
			ret = ret && (e.getNivel_elegido().equals("1") || e.getNivel_elegido().equals("2"));
			return ret;
		}
		JOptionPane.showMessageDialog(null, "No existe el archivo o no se puede leer - clase validate");
		JOptionPane.showMessageDialog(null, "QUe hacer , se ccrea o se juega por default");
		return false;
	}
	
	public boolean archivoValido()
	{
		return validacionesDeDatos();
	}
	
}
