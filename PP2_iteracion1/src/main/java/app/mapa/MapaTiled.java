package app.mapa;

import java.awt.Point;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import app.util.CargadorRecursos;

public class MapaTiled {
	private int anchoMapaEnTiles;
	private int altoMapaEnTiles;
	// private Coordinate coordinatePlayer1;
	// private Coordinate coordinatePlayer2;

	private ArrayList<CapaSprites> capasDeSprites;
	private ArrayList<CapaColisiones> capasDeColisiones;

	public MapaTiled(final String ruta) {
		// ANCHO Y ALTO
		String contenido = CargadorRecursos.leerArchivoTexto(ruta);
		JSONObject globalJSON = obtenerObjetoJSON(contenido);
		anchoMapaEnTiles = obtenerIntDesdeJSON(globalJSON, "width");
		altoMapaEnTiles = obtenerIntDesdeJSON(globalJSON, "height");

		// //players
		// JSONObject player1 =
		// obtenerObjetoJSON(globalJSON.get("player1").toString());
		// coordinatePlayer1 = new Coordinate(obtenerIntDesdeJSON(player1, "x"),
		// obtenerIntDesdeJSON(player1, "y"));
		// JSONObject player2 =
		// obtenerObjetoJSON(globalJSON.get("player2").toString());
		// coordinatePlayer2 = new Coordinate(obtenerIntDesdeJSON(player2, "x"),
		// obtenerIntDesdeJSON(player2, "y"));
		//
		// CAPAS
		JSONArray capas = obtenerArrayJSON(globalJSON.get("layers").toString());
		this.capasDeSprites = new ArrayList<CapaSprites>();
		this.capasDeColisiones = new ArrayList<CapaColisiones>();

		// INICIAR CAPAS
		// RECORRE TODAS LAS CAPAS
		for (int i = 0; i < capas.size(); i++) {
			JSONObject datosCapa = obtenerObjetoJSON(capas.get(i).toString());

			int anchoCapa = obtenerIntDesdeJSON(datosCapa, "width");
			int altoCapa = obtenerIntDesdeJSON(datosCapa, "height");
			int xCapa = obtenerIntDesdeJSON(datosCapa, "y");
			int yCapa = obtenerIntDesdeJSON(datosCapa, "x");

			String tipo = datosCapa.get("type").toString();

			switch (tipo) {
			case "tilelayer":
				JSONArray sprites = obtenerArrayJSON(datosCapa.get("data").toString());
				int[] spritesCapa = new int[sprites.size()];
				for (int j = 0; j < sprites.size(); j++) {
					// aca tenemos cada numero del vector de una capa
					int codigoSprite = Integer.parseInt(sprites.get(j).toString());
					spritesCapa[j] = codigoSprite - 1;
				}
				this.capasDeSprites
						.add(new CapaSprites(new Point(anchoCapa, altoCapa), new Point(xCapa, yCapa), spritesCapa));
				break;
			case "objectgroup":
				break;
			}
		}
	}

	private JSONObject obtenerObjetoJSON(final String codigoJSON) {
		JSONParser lector = new JSONParser();
		JSONObject objetoJSON = null;
		try {
			Object recuperado = lector.parse(codigoJSON);
			objetoJSON = (JSONObject) recuperado;
		} catch (ParseException e) {
			System.out.println("Posicion: " + e.getPosition());
			System.out.println(e);
		}

		return objetoJSON;
	}

	private JSONArray obtenerArrayJSON(final String codigoJSON) {
		JSONParser lector = new JSONParser();
		JSONArray arrayJSON = null;
		try {
			Object recuperado = lector.parse(codigoJSON);
			arrayJSON = (JSONArray) recuperado;
		} catch (ParseException e) {
			System.out.println("Posicion: " + e.getPosition());
			System.out.println(e);
		}

		return arrayJSON;
	}

	private int obtenerIntDesdeJSON(final JSONObject objetoJSON, final String clave) {
		return Integer.parseInt(objetoJSON.get(clave).toString());
	}
}
