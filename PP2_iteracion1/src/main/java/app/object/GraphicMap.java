package app.object;

import java.util.*;

import app.modelo.ObjetoGrafico;

public class GraphicMap {
	
	private Map map;
	private Size sizeMarco;
	private List<Coordinate> coordenadas;
	
	public GraphicMap(Map mapa, Size marco)
	{
		this.map = mapa;
		this.sizeMarco = marco;
		this.coordenadas = new ArrayList<Coordinate>();
		this.cargarCoordenadas();
	}

	public void cargarCoordenadas() 
	{
		int filas = 0;
		int columnas = 0;
		int valorX = (int) (0 + sizeMarco.getAncho());
		int valorY = (int) (0 + sizeMarco.getAlto());
		filas = (int) ((this.getSize().getAncho() - (sizeMarco.getAncho()*2))/40);
		columnas = (int) ((this.getSize().getAlto() - (sizeMarco.getAlto()*2))/40);
		
		for(int fila=0;fila<filas;fila++)
		{
			for(int colum=0;colum<columnas;colum++){
				this.coordenadas.add(new Coordinate(valorX, valorY));
				valorY = valorY + 40;
			}
			valorY = (int) (0 + sizeMarco.getAlto());
			valorX = valorX + 40;
		}
		//int i=1;
		//for(Coordinate c : coordenadas){System.out.println(i+" "+c);i++;}
		//System.out.println("");
		//System.out.println("cant filas "+ filas + " cant columnas" +columnas);
		//System.out.println("Coordenadas cargadas: " + coordenadas.size());
	}
	
	public Coordinate getCoordenada(int posicion)
	{
		return coordenadas.get(posicion);
	}
	
	public Size getSizeMarco() 
	{
		return sizeMarco;
	}

	public void setSizeMarco(Size sizeMarco) 
	{
		this.sizeMarco = sizeMarco;
	}
	
	public List<Coordinate> listaCoordenadas()
	{
		return coordenadas;
	}
	
	public ObjetoGrafico getObjetoEnCoordenada(Coordinate coor)
	{
		return null;
	}
	
	public Size getSize()
	{
		return this.map.getSizeMap();
	}
}
