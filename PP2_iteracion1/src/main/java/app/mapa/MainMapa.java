package app.mapa;

import java.util.ArrayList;

import app.object.Coordinate;

public class MainMapa {
	
	public static void main(String[] args) 
	{
		MapaTiled mapa = new MapaTiled("/mapas/MapaTank01.csv");
		
		for(int i =0; i<mapa.getCapasDeSprites().size();i++){
			int contador = 0;
			ArrayList<Coordinate> coordenadas = new ArrayList<>();
			for(int j = 0; j < mapa.getCapasDeSprites().get(i).getSprites().length;j++){
				if(mapa.getCapasDeSprites().get(i).getSprites()[j]!=-1){
					contador = contador +1;
					coordenadas.add(mapa.obtenerCoordenada(40, 25, 15, mapa.getCapasDeSprites().get(i).getSprites()[j]));
				}
//				if(mapa.getCapasDeSprites().get(i).getNombre().equals("panel") && mapa.getCapasDeSprites().get(i).getSprites()[j]!=-1){
//				}
//				if(mapa.getCapasDeSprites().get(i).getNombre().equals("acero") && mapa.getCapasDeSprites().get(i).getSprites()[j]!=-1)
//					System.out.println("dibujarAcero");
//				if(mapa.getCapasDeSprites().get(i).getNombre().equals("ladrillo") && mapa.getCapasDeSprites().get(i).getSprites()[j]!=-1)
//					System.out.println("dibujarLadrillo");
//				if(mapa.getCapasDeSprites().get(i).getNombre().equals("agua") && mapa.getCapasDeSprites().get(i).getSprites()[j]!=-1)
//					System.out.println("dibujarAgua");
			}
			//CREAR ESTRUCTURA
		}
	}

}
