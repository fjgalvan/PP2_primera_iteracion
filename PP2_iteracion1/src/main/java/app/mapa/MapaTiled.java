package app.mapa;

import java.awt.Point;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import app.object.ListStructures;
import app.util.CargadorRecursos;

public class MapaTiled {
	private String contenido;
	private JSONObject globalJSON;
	private int anchoMapaEnTiles;
	private int altoMapaEnTiles;
	private JSONArray capas;
	private JSONArray capasDeImagenes;
	private ArrayList<CapaSprites> capasDeSprites;
	
	public MapaTiled(final String ruta){
		contenido = CargadorRecursos.leerArchivoTexto(ruta);
		inicializar();
	}
	
	public void inicializar(){
		globalJSON = obtenerObjetoJSON(contenido);
		anchoMapaEnTiles = obtenerIntDesdeJSON(globalJSON,"width");
		altoMapaEnTiles = obtenerIntDesdeJSON(globalJSON,"height");

		//CAPAS
		capas = obtenerArrayJSON(globalJSON.get("layers").toString());
		capasDeImagenes = obtenerArrayJSON(globalJSON.get("tilesets").toString());
		this.capasDeSprites = new ArrayList<CapaSprites>();
		//INICIAR CAPAS
		//RECORRE TODAS LAS CAPAS
		for(int i=0; i < capas.size(); i++){
			JSONObject datosCapa = obtenerObjetoJSON(capas.get(i).toString());
			JSONObject datosCapaDeImagen = obtenerObjetoJSON(capasDeImagenes.get(i).toString());

			int anchoCapa = obtenerIntDesdeJSON(datosCapa, "width");
			int altoCapa = obtenerIntDesdeJSON(datosCapa, "height");
			int xCapa = obtenerIntDesdeJSON(datosCapa, "y");
			int yCapa = obtenerIntDesdeJSON(datosCapa, "x");
			String nombreCapa = obtenerStringDesdeJSON(datosCapa, "name");
			String imagenCapa = obtenerStringDesdeJSON(datosCapaDeImagen, "image");

			String tipo = datosCapa.get("type").toString();
			
			switch(tipo){
				case "tilelayer":
					JSONArray sprites = obtenerArrayJSON(datosCapa.get("data").toString());
					int[] spritesCapa = new int [sprites.size()];
					String[] spritesCapaDeImagenes = new String [sprites.size()];//ESTO ES PARA PACMAN
					for(int j=0; j < sprites.size();j++){
						//aca tenemos cada numero del vector de una capa
						int codigoSprite = Integer.parseInt(sprites.get(j).toString());
						spritesCapa[j] = codigoSprite -1;
						spritesCapaDeImagenes[j] = traerImagenDesdeJSON(spritesCapa[j]+1);//ESTO ES PARA PACMAN
					}
					this.capasDeSprites.add(new CapaSprites(nombreCapa, imagenCapa, new Point (anchoCapa,altoCapa),new Point (xCapa,yCapa),spritesCapa,spritesCapaDeImagenes));
					break;
			}
		}
	}
	
	private String traerImagenDesdeJSON(int spriteCapa) {//ESTO ES PARA PACMAN
		for(int i=0; i < capasDeImagenes.size(); i++){//obtengo una de las capas de imagenes
			JSONObject datosCapaDeImagen = obtenerObjetoJSON(capasDeImagenes.get(i).toString());
			if(obtenerStringDesdeJSON(datosCapaDeImagen, "firstgid").equals(""+spriteCapa)){
				return obtenerStringDesdeJSON(datosCapaDeImagen, "image");
			}
		}	
		return "-1";
	}

	private JSONObject obtenerObjetoJSON(final String codigoJSON){
		JSONParser lector = new JSONParser();
		JSONObject objetoJSON = null;
		try{
			Object recuperado = lector.parse(codigoJSON);
			objetoJSON = (JSONObject) recuperado;
		}catch(ParseException e){
			//System.out.println("Posicion: " + e.getPosition());
			//System.out.println(e);
		}
		
		return objetoJSON;
	}
	
	private JSONArray obtenerArrayJSON(final String codigoJSON){
		JSONParser lector = new JSONParser();
		JSONArray arrayJSON = null;
		try{
			Object recuperado = lector.parse(codigoJSON);
			arrayJSON = (JSONArray) recuperado;
		}catch(ParseException e){
			//System.out.println("Posicion: " + e.getPosition());
			//System.out.println(e);
		}
		
		return arrayJSON;
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
					coordenadas.add(obtenerCoordenada(40, altoMapaEnTiles, anchoMapaEnTiles, j)); //GUARDO TODAS LAS COORDENADAS
					imagenes.add(capasDeSprites.get(i).getSpritesImagenes()[j]);
				}
			}
			estructuras.inicializarListaConTiled(capasDeSprites.get(i).getNombre(), capasDeSprites.get(i).getImagenCapa(), totalTilesPorCapa,
					coordenadas,imagenes);
			coordenadas.removeAll(coordenadas);
		}
	}
	
	private int obtenerIntDesdeJSON(final JSONObject objetoJSON, final String clave){
		return Integer.parseInt(objetoJSON.get(clave).toString());
	}
	
	private String obtenerStringDesdeJSON(final JSONObject objetoJSON, final String clave){
		return (objetoJSON.get(clave).toString());
	}

	public ArrayList<CapaSprites> getCapasDeSprites() {
		return capasDeSprites;
	}
}
