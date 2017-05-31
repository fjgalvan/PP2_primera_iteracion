package app.mapa;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import app.util.CargadorRecursos;

public class MapaTiled {
	private int anchoMapaEnTiles;
	private int altoMapaEnTiles;
	
	public MapaTiled(final String ruta){
		String contenido = CargadorRecursos.leerArchivoTexto(ruta);
		JSONObject globalJSON = obtenerObjetoJSON(contenido);
		anchoMapaEnTiles = obtenerIntDesdeJSON(globalJSON,"width");
		altoMapaEnTiles = obtenerIntDesdeJSON(globalJSON,"height");
	}
	
	
	private JSONObject obtenerObjetoJSON(final String codigoJSON){
		JSONParser lector = new JSONParser();
		JSONObject objetoJSON = null;
		try{
			Object recuperado = lector.parse(codigoJSON);
			objetoJSON = (JSONObject) recuperado;
		}catch(ParseException e){
			System.out.println("Posicion: " + e.getPosition());
			System.out.println(e);
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
			System.out.println("Posicion: " + e.getPosition());
			System.out.println(e);
		}
		
		return arrayJSON;
	}
	
	private int obtenerIntDesdeJSON(final JSONObject objetoJSON, final String clave){
		return Integer.parseInt(objetoJSON.get(clave).toString());
	}
}
