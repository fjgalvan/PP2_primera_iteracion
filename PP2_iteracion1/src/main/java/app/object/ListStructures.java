package app.object;

import java.util.*;

import app.estructura.*;
import app.modelo.ObjetoGrafico;

public class ListStructures 
{
	private int lenght;
	private List<ObjetoGrafico> estructuras;
	
	public ListStructures(GraphicMap map, int lenght) throws Exception
	{
		if(lenght>Configuracion.CantidadMenorLista && lenght<Configuracion.CantidadMayorLista){
			this.lenght=lenght;
			this.estructuras = new ArrayList<ObjetoGrafico>();
			inicializarLista(map);	
		}
		else{
			throw new Exception("El largo de lista pasado por parametro no esta en el rango [0-50]");
		}
	}
	
	private void inicializarLista(GraphicMap mapa) 
	{
		for(int i=0;i<lenght;i++)
		{
			this.estructuras.add(new EstructuraAcero());
			this.estructuras.add(new EstructuraAgua());
			this.estructuras.add(new EstructuraLadrillo());
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

	public int getLenght() 
	{
		return lenght;
	}

	public List<ObjetoGrafico> getLista() {
		return estructuras;
	}
}
