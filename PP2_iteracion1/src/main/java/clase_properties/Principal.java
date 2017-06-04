package clase_properties;


import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties; 

import app.vistas.Menu;
 
/**
 * @author CHENAO
 * 
 */
public class Principal {
 
 public static void main(String arg[]) {
 
	 Principal miPrincipal = new Principal();
	  miPrincipal.leerArchivo();
 }
 
 /**
  * Lee un archivo de propiedades desde una ruta especifica
  * y se imprime en pantalla.
  */
 public void leerArchivo() {
  try {

	  /**Creamos un Objeto de tipo Properties*/
	  Properties propiedades = new Properties();
	  
	  /**Cargamos el archivo desde la ruta especificada*/
	  propiedades.load(new FileReader("src/main/java/properties/archivo.properties"));//("C:/Users/Usuario/git/PP2_primera_iteracion/PP2_iteracion1/src/main/java/properties/archivo.properties"));
	  
	  //propiedades.setProperty("cuatro", "4");
 
   /**Obtenemos los parametros definidos en el archivo*/
	  String juego = propiedades.getProperty("juego");	  
      String dificultad = propiedades.getProperty("dificultad");
      String enemigos = propiedades.getProperty("enemigos");
      String nivel = propiedades.getProperty("nivel");
      String vidas = propiedades.getProperty("vidas");
   
 
   /**Imprimimos los valores*/
      System.out.println("dificultad: "+dificultad);
      System.out.println("enemigos: "+enemigos);
      System.out.println("juego: "+juego);
      System.out.println("nivel: "+nivel);
      System.out.println("vidas: "+vidas);
       
    
  } catch (FileNotFoundException e) {
	  System.out.println("Error, El archivo no exite");
  } catch (IOException e) {
	  System.out.println("Error, No se puede leer el archivo");
  }
 }
 
 public void ModificarArchivo(EleccionMenu eleccion){
		try {
		/**Creamos un Objeto de tipo Properties*/
		  Properties propiedades = new Properties();
		  
		  /**Cargamos el archivo desde la ruta especificada*/
		  
			propiedades.load(new FileReader("src/main/java/properties/archivo.properties"));//("C:/Users/Usuario/git/PP2_primera_iteracion/PP2_iteracion1/src/main/java/properties/archivo.properties"));
			
			propiedades.setProperty("dificultad", eleccion.dificultad_elegido);
			propiedades.setProperty("enemigos", eleccion.enemigos_elegido);
			propiedades.setProperty("juego", eleccion.juego_elegido);
			propiedades.setProperty("nivel", eleccion.nivel_elegido);
			propiedades.setProperty("vidas", eleccion.vidas_elegido);
			
			/*propiedades.store(new FileWriter("out.properties"),"nueva eleccion del Menu");*/
			System.out.println("Se modifico el archivo Properties");
			
			FileOutputStream file = new FileOutputStream("src/main/java/properties/archivo.properties");//("C:/Users/Usuario/git/PP2_primera_iteracion/PP2_iteracion1/src/main/java/properties/archivo.properties");
			propiedades.store(file, "Escribiendo");			
			file.close();
			
			Principal principal= new Principal();
			principal.leerArchivo();
			
			
			
		} catch (FileNotFoundException e) {
			  System.out.println("Error, El archivo no exite");
		} catch (IOException e) {
			  System.out.println("Error, No se puede leer el archivo");
		}
	}
 
}