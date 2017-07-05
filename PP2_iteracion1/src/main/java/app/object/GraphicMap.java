package app.object;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GraphicMap {
	private Map map;
	private Point sizeMarco;
	private List<Point> coordenadas;

	public GraphicMap(Map mapa, Point marco) {
		this.map = mapa;
		this.sizeMarco = marco;
		this.coordenadas = new ArrayList<Point>();
		this.cargarCoordenadas();
	}

	public void cargarCoordenadas() {
		int filas = 0;
		int columnas = 0;
		int valorX = (int) (0 + sizeMarco.getX());
		int valorY = (int) (0 + sizeMarco.getY());
		filas = (int) ((this.getSize().getX() - (sizeMarco.getX() * 2)) / 40);
		columnas = (int) ((this.getSize().getY() - (sizeMarco.getY() * 2)) / 40);

		for (int fila = 0; fila < filas; fila++) {
			for (int colum = 0; colum < columnas; colum++) {
				this.coordenadas.add(new Point(valorX, valorY));
				valorY = valorY + 40;
			}
			valorY = (int) (0 + sizeMarco.getY());
			valorX = valorX + 40;
		}
	}

	public Point getSizeMarco() {
		return sizeMarco;
	}

	public Point getSize() {
		return this.map.getSizeMap();
	}
}
