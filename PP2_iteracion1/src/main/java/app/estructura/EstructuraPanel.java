package app.estructura;

import java.awt.Color;

import app.modelo.ObjetoGrafico;

//SE COMENTARON LOS @Override
public class EstructuraPanel extends ObjetoGrafico implements Estructura{

	
	public EstructuraPanel(String imagen)
	{
		super.imagen = imagen;
		this.color = Color.ORANGE;
	}
	
	public void colisionBala()
	{

	}

	public void destruir() {
	}

	
}
