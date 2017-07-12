package app.object;

import java.util.*;
import app.estructura.*;
import app.modelo.ObjetoGrafico;

public class ListStructures 
{
	private int lenght;
	private List<ObjetoGrafico> estructuras;
	
	public ListStructures()
	{
		this.estructuras = new ArrayList<ObjetoGrafico>();
	}
	
//	public void inicializar(MapaTiled mapa){
//		inicializarListaConTiled(mapa.getNombre(), mapa.getImagen(), mapa.getEstructurasMapa());
//	}
	
//	public void inicializarListaConTiled(ArrayList<String> tipoEstructura, ArrayList<String> imagen, Point[][] points){
//		for(int est=0; est < tipoEstructura.size(); est++){
//			for(int j=0; j < points[est].length; j++){
//				this.estructuras.add(new Estructura(tipoEstructura.get(est),imagen.get(est)));
//				this.estructuras.get(j).setCoordinate(points[est][j]);
//				this.estructuras.get(j).setSize(new Point(40,40));
//				this.estructuras.get(j).setImagen(imagen.get(j));
//			}
//		}
//	}
	
	public int getLenght() 
	{
		return lenght;
	}

	public List<ObjetoGrafico> getLista() {
		return estructuras;
	}
	
	public void add(Estructura estructura){
		estructuras.add(estructura);
	}
}