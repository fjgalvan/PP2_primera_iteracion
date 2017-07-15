package app.mapa;

import java.awt.Point;
import java.util.ArrayList;
import app.estructura.Estructura;
import app.object.ListStructures;
import app.util.CargadorRecursos;

public class MapaTiled {
	private String contenido;
	private ArrayList<CapaSprites> capasDeSprites;
	private JsonTiled jsonTiled;
	private Point[][] estructurasMapa; 
	private ArrayList<String> tiposDeEstructuras;
	private String[][] imagenes;
	
	public MapaTiled(final String ruta){
		contenido = CargadorRecursos.leerArchivoTexto(ruta);
		jsonTiled = new JsonTiled(contenido);
		this.capasDeSprites = new ArrayList<CapaSprites>();
		this.tiposDeEstructuras = new ArrayList<>();
	}
	
/*	public void controlarCargaDeMapa(final String ruta){
		try{
			contenido = CargadorRecursos.leerArchivoTexto(ruta);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"El mapa no existe o no es del formato .csv","Error!! Mapa invalido", JOptionPane.WARNING_MESSAGE);
		}
	}*/
	
	public void inicializar(){
		jsonTiled.obtenerCapas(capasDeSprites);
	}
	
		
	public Point obtenerCoordenada(int tamañoDeTiles, int altoMapa, int anchoMapa, int lugarDelSprite){
		int contador = 0;
		for(int y=0; y < altoMapa;y++){
			for(int x=0; x < anchoMapa; x++){
				if(contador == lugarDelSprite){
					return new Point (x*tamañoDeTiles,y*tamañoDeTiles);
				}
				contador = contador + 1 ;
			}
		}
		return null;
	}
	
	public void crearEstructuras(ListStructures estructuras){
		this.estructurasMapa = new Point[capasDeSprites.size()][];
		this.imagenes = new String [capasDeSprites.size()][];
		for (int i = 0; i < capasDeSprites.size(); i++) {//RECORRO LAS CAPAS
			int totalTilesPorCapa = 0;
			ArrayList<Point> coordenadas = new ArrayList<>();
			ArrayList<String> imagenes = new ArrayList<>();
			for (int j = 0; j < capasDeSprites.get(i).getSprites().length; j++) {//RECORRO LOS TILES DE CADA CAPA
				if (capasDeSprites.get(i).getSprites()[j] != -1) {
					totalTilesPorCapa = totalTilesPorCapa + 1; //GUARDO EL TOTAL DE TILES DE LA CAPA
					coordenadas.add(obtenerCoordenada(40, jsonTiled.getAltoMapaEnTiles(), jsonTiled.getAnchoMapaEnTiles(), j)); //GUARDO TODAS LAS COORDENADAS
					imagenes.add(capasDeSprites.get(i).getSpritesImagenes()[j]);
				}
			}
			insertarCoordenadasEnLaMatriz(i, coordenadas);
			insertarImagenesEnLaMatriz(i, imagenes);
			this.tiposDeEstructuras.add(capasDeSprites.get(i).getNombre());
			coordenadas.removeAll(coordenadas);
		}
		adaptarMatrizAEstructuraYCrearlas(this.tiposDeEstructuras, this.imagenes, this.estructurasMapa, estructuras);
	}

	private void insertarImagenesEnLaMatriz(int i, ArrayList<String> imagenes) {
		this.imagenes[i] = new String [imagenes.size()];
		for (int img=0; img < imagenes.size();img++){
			this.imagenes[i][img] = imagenes.get(img);
		}
	}

	private void insertarCoordenadasEnLaMatriz(int i, ArrayList<Point> coordenadas) {
		estructurasMapa[i] = new Point [coordenadas.size()];
		for (int cor=0; cor < coordenadas.size();cor++){
			estructurasMapa[i][cor] = coordenadas.get(cor);
		}
	}

	private void adaptarMatrizAEstructuraYCrearlas(ArrayList<String> tipoEstructura, String[][] imagen, Point[][] coordenadas, ListStructures estructuras){
		for(int i = 0; i < coordenadas.length; i++){
			for(int j=0; j < coordenadas[i].length; j++){
				estructuras.add(new Estructura(coordenadas[i][j], new Point(40,40), tipoEstructura.get(i),imagen[i][j]));
			}
		}
	}
}