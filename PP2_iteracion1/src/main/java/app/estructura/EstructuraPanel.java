package app.estructura;

import java.awt.Color;

import app.modelo.ObjetoGrafico;

//SE COMENTARON LOS @Override
public class EstructuraPanel extends ObjetoGrafico implements Estructura{

	
	public EstructuraPanel()
	{
		super.imagen = "imagen/panel.png";
		this.color = Color.ORANGE;
	}
	
	public void colisionBala()
	{

	}

	public void destruir() {
	}

	
}
