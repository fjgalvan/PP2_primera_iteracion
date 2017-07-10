package app.mapa;

import java.awt.Point;
import java.util.ArrayList;
import app.object.ListStructures;
import app.util.CargadorRecursos;

public class MapaTiled {
	private String contenido;
	private ArrayList<CapaSprites> capasDeSprites;
	private JsonTiled jsonTiled;
	
	public MapaTiled(final String ruta){
		contenido = CargadorRecursos.leerArchivoTexto(ruta);
		jsonTiled = new JsonTiled(contenido);
		this.capasDeSprites = new ArrayList<CapaSprites>();
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
			estructuras.inicializarListaConTiled(capasDeSprites.get(i).getNombre(), capasDeSprites.get(i).getImagenCapa(), totalTilesPorCapa,
					coordenadas,imagenes);
			coordenadas.removeAll(coordenadas);
		}
	}
}