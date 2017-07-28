package app.levels;

import static org.junit.Assert.*;
import org.junit.Test;
import clase_properties.Principal;

public class TestValidateFile {

	@Test	
	public void testExisteElArchivo()		// o no se puede leer
	{
		Principal con = new Principal();
		ValidateFile valida = new ValidateFile(con);
		assertTrue(valida.existeElArchivo());
		assertFalse(!valida.existeElArchivo());
		ValidateFile val = new ValidateFile(null);		
		assertFalse(val.existeElArchivo());
	}
	
	@Test	
	public void testValidacionesDeDatos()
	{
		//ValidateFile valida = new ValidateFile(new Principal());
		//assertTrue(valida.validacionesDeDatos());
		ValidateFile validaFalla = new ValidateFile(null);
		assertFalse(validaFalla.validacionesDeDatos());
	}
	
	@Test
	public void testArchivoValido()
	{
		//ValidateFile valida = new ValidateFile(new Principal());
		//assertTrue(valida.archivoValido());		
		ValidateFile validaFalla = new ValidateFile(null);
		assertFalse(validaFalla.archivoValido());
	}

}
