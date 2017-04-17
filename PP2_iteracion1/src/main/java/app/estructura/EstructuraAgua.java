package app.estructura;

import java.awt.Color;

import app.modelo.ObjetoGrafico;

//SE COMENTARON LOS @Override
public class EstructuraAgua extends ObjetoGrafico implements Estructura {
	

	public EstructuraAgua()
	{
		//this.imagen = new Imagen("/PP2/src/imagen/agua.png");
		//System.out.println("me construi , estructura agua");
		this.color = Color.BLUE;
	}
	
	
	public void colisionBala(){
		
	}


	public void destruir() {
		// TODO Auto-generated method stub
		
	}

	
}

