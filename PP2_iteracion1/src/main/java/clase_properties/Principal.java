package clase_properties;
import java.io.*;
import java.util.Properties;
import app.object.Configuracion; 
public class Principal {//Lee un archivo de propiedades desde una ruta especifica y se imprime en pantalla.
	public Principal(){}
	public EleccionMenu leerArchivo() {
		 try {
			  Properties propiedades = new Properties();/**Creamos un Objeto de tipo Properties*/
			  propiedades.load(new FileReader(Configuracion.rutaProperties));  /**Cargamos el archivo desde la ruta especificada*/
			  String juego = propiedades.getProperty("juego");	/**Obtenemos los parametros definidos en el archivo*/  
		      String dificultad = propiedades.getProperty("dificultad");
		      int enemigos = Integer.parseInt(propiedades.getProperty("enemigos"));
		      String nivel = propiedades.getProperty("nivel");
		      int vidas = Integer.parseInt(propiedades.getProperty("vidas"));
		      return new EleccionMenu(dificultad, enemigos, juego, nivel, vidas);   } 
		  catch (IOException e) {return null;} 
	 }
	 public boolean ModificarArchivo(EleccionMenu eleccion){
			try {
			  Properties propiedades = new Properties();/**Creamos un Objeto de tipo Properties*/
				propiedades.load(new FileReader("src/main/java/properties/archivo.properties"));/**Cargamos el archivo desde la ruta especificada*/				
				propiedades.setProperty("dificultad", eleccion.dificultad_elegido);
				propiedades.setProperty("enemigos", String.valueOf(eleccion.enemigos_elegido));
				propiedades.setProperty("juego", eleccion.juego_elegido);
				propiedades.setProperty("nivel", eleccion.nivel_elegido);
				propiedades.setProperty("vidas", String.valueOf(eleccion.vidas_elegido));
				System.out.println("Se modifico el archivo Properties");		
				FileOutputStream file = new FileOutputStream("src/main/java/properties/archivo.properties");//("C:/Users/Usuario/git/PP2_primera_iteracion/PP2_iteracion1/src/main/java/properties/archivo.properties");
				propiedades.store(file, "Escribiendo");			
				file.close();	
				return true;				
			} catch (IOException e) {System.out.println("Error, El archivo no exite o no se puede leer");return false;}
	 }
}