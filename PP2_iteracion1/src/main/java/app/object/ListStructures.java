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
	
	public void inicializarListaConTiled(String tipoEstructura, String imagen, int totalDePaneles, ArrayList<Coordinate> coordenadas){
		for(int i=0;i<totalDePaneles;i++){
			if(tipoEstructura.equals("Fondo"))
				this.estructuras.add((ObjetoGrafico)new EstructuraFondo(imagen));
			if(tipoEstructura.equals("Panel"))
				this.estructuras.add((ObjetoGrafico)new EstructuraPanel(imagen));
			if(tipoEstructura.equals("Acero"))
				this.estructuras.add((ObjetoGrafico)new EstructuraAcero(imagen));
			if(tipoEstructura.equals("Agua"))
				this.estructuras.add((ObjetoGrafico)new EstructuraAgua(imagen));
			if(tipoEstructura.equals("Ladrillo"))
				this.estructuras.add((ObjetoGrafico)new EstructuraLadrillo(imagen));
		}
		for(int est=0; est < this.estructuras.size(); est++){
			for(int j=0; j < coordenadas.size(); j++){
				if(this.estructuras.get(est).getClass().getName().equals("app.estructura.Estructura"+tipoEstructura)){
					this.estructuras.get(est).setCoordinate(coordenadas.get(j));
					this.estructuras.get(est).setSize(new Size(40,40));
					coordenadas.remove(coordenadas.get(j));
					break;
				}
			}
		}
	}
	
	public int getLenght() 
	{
		return lenght;
	}

	public List<ObjetoGrafico> getLista() {
		return estructuras;
	}
		
}
