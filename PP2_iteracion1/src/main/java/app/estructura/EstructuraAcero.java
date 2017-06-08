package app.estructura;

import java.awt.Color;

import app.interfaces.Estructura;
import app.modelo.ObjetoGrafico;

//SE COMENTARON LOS @Override
public class EstructuraAcero extends ObjetoGrafico implements Estructura{

	
	public EstructuraAcero()
	{
		super.imagen = "imagen/acero.png";
		//this.imagen = new Imagen("agua.png");
		//System.out.println("me construi, estructura acero ");
		this.color = Color.ORANGE;
	}
	
	public void colisionBala()
	{

	}

	public void destruir() {
		// TODO Auto-generated method stub
		
	}

	
}
