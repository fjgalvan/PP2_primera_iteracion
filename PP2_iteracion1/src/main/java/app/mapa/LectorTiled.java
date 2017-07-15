package app.mapa;

import java.awt.Point;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectorTiled {
	private int anchoMapaEnTiles;
	private int altoMapaEnTiles;
	private JSONObject globalJSON;
	private JSONArray capas;
	private JSONArray capasDeImagenes;
	
	public LectorTiled(String contenido){
		globalJSON = obtenerObjetoJSON(contenido);
		anchoMapaEnTiles = obtenerIntDesdeJSON(globalJSON,"width");
		altoMapaEnTiles = obtenerIntDesdeJSON(globalJSON,"height");
		capas = obtenerArrayJSON(globalJSON.get("layers").toString());
		capasDeImagenes = obtenerArrayJSON(globalJSON.get("tilesets").toString());
	}

	public void obtenerCapas(ArrayList<CapaSprites> capasDeSprites){
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
					capasDeSprites.add(new CapaSprites(nombreCapa, imagenCapa, new Point (anchoCapa,altoCapa),new Point (xCapa,yCapa),spritesCapa,spritesCapaDeImagenes));
					break;
			}
		}
	}

	public String traerImagenDesdeJSON(int spriteCapa) {//ESTO ES PARA PACMAN
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
	
	
	private int obtenerIntDesdeJSON(final JSONObject objetoJSON, final String clave){
		return Integer.parseInt(objetoJSON.get(clave).toString());
	}
	
	private String obtenerStringDesdeJSON(final JSONObject objetoJSON, final String clave){
		return (objetoJSON.get(clave).toString());
	}

	public int getAnchoMapaEnTiles() {
		return anchoMapaEnTiles;
	}

	public int getAltoMapaEnTiles() {
		return altoMapaEnTiles;
	}
}

