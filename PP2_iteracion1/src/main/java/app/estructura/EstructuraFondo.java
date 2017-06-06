package app.estructura;

import java.awt.Color;

import app.modelo.ObjetoGrafico;

public class EstructuraFondo  extends ObjetoGrafico implements Estructura{
	
	//SE COMENTARON LOS @Override
		public EstructuraFondo()
		{
			super.imagen = "imagen/fondo.png";
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