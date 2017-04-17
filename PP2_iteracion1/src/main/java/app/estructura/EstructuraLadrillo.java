package app.estructura;

import java.awt.Color;

import app.modelo.ObjetoGrafico;

//SE COMENTARON LOS @Override
public class EstructuraLadrillo extends ObjetoGrafico implements Estructura{
		
	
	public EstructuraLadrillo()
	{
		//this.imagen = new Imagen("agua.png");
		//System.out.println("me construi estructura ladrillo");
		this.color = Color.RED;
	}

	public void colisionBala() {
		// TODO Auto-generated method stub
		
	}

	public void destruir() {
		// TODO Auto-generated method stub
		
	}
		
	
	
}
