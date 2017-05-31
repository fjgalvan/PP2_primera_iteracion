package app.mapa;

import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import app.object.Coordinate;
import app.util.CargadorRecursos;

public class MapaTiled {
	private int anchoMapaEnTiles;
	private int altoMapaEnTiles;
	private Coordinate coordinatePlayer1;
	private Coordinate coordinatePlayer2;
	
	private ArrayList<CapaSprites> capasDeSprites;
	private ArrayList<CapaColisiones> capasDeColisiones;
	
	public MapaTiled(final String ruta){
		//ANCHO Y ALTO
		String contenido = CargadorRecursos.leerArchivoTexto(ruta);
		JSONObject globalJSON = obtenerObjetoJSON(contenido);
		anchoMapaEnTiles = obtenerIntDesdeJSON(globalJSON,"width");
		altoMapaEnTiles = obtenerIntDesdeJSON(globalJSON,"height");

		//players
		JSONObject player1 = obtenerObjetoJSON(globalJSON.get("player1").toString());
		coordinatePlayer1 = new Coordinate(obtenerIntDesdeJSON(player1, "x"), obtenerIntDesdeJSON(player1, "y"));
		JSONObject player2 = obtenerObjetoJSON(globalJSON.get("player2").toString());
		coordinatePlayer2 = new Coordinate(obtenerIntDesdeJSON(player2, "x"), obtenerIntDesdeJSON(player2, "y"));
		
		//CAPAS
		JSONArray capas = obtenerArrayJSON(globalJSON.get("layers").toString());
		this.capasDeSprites = new ArrayList<CapaSprites>();
		this.capasDeColisiones = new ArrayList<CapaColisiones>();
		
		//INICIAR CAPAS
		for(int i=0; i < capas.size(); i++){
			
		}
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
