package app.object;

import java.util.*;

import app.estructura.*;
import app.modelo.ObjetoGrafico;

public class ListStructures 
{
	private int lenght;
	private List<ObjetoGrafico> estructuras;
	private boolean listaLenghtValidate;
	
	public ListStructures(GraphicMap map, int length)
	{
		this.setLenght(length);
		this.estructuras = new ArrayList<ObjetoGrafico>();
		//this.inicializarLista(map);
	}
	public ListStructures()
	{
		this.estructuras = new ArrayList<ObjetoGrafico>();
	}
	
	public void inicializarLista(GraphicMap mapa) 
	{
		if(listaLenghtValidate)
		{
			for(int i=0;i<lenght;i++)
			{
				this.estructuras.add((ObjetoGrafico)new EstructuraAcero());
				this.estructuras.add((ObjetoGrafico)new EstructuraAgua());
				this.estructuras.add((ObjetoGrafico)new EstructuraLadrillo());
			}
		}
		for(ObjetoGrafico o : estructuras)
		{
			Random ale = new Random();
			List<Coordinate> lista = mapa.listaCoordenadas();
			int pos = ale.nextInt(lista.size());
			Coordinate azar = mapa.getCoordenada(pos);
			o.setCoordinate(azar);
			o.setSize(new Size(40,40));
			lista.remove(pos);
		}
	}
	
	public void inicializarListaConTiled(String tipoEstructura, int totalDePaneles, ArrayList<Coordinate> coordenadas){
		for(int i=0;i<totalDePaneles;i++){
			if(tipoEstructura.equals("Fondo"))
				this.estructuras.add((ObjetoGrafico)new EstructuraFondo());
			if(tipoEstructura.equals("Panel"))
				this.estructuras.add((ObjetoGrafico)new EstructuraPanel());
			if(tipoEstructura.equals("Acero")){
				this.estructuras.add((ObjetoGrafico)new EstructuraAcero());
				
			}
			if(tipoEstructura.equals("Agua"))
				this.estructuras.add((ObjetoGrafico)new EstructuraAgua());
			if(tipoEstructura.equals("Ladrillo"))
				this.estructuras.add((ObjetoGrafico)new EstructuraLadrillo());
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

	public void setLenght(int lenght) 
	{
		this.lenght = lenght;
		this.listaLenghtValidate = lenght>0 && lenght<50;
	}

	public List<ObjetoGrafico> getLista() {
		return estructuras;
	}
		
}
