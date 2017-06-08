package app.estructura;

import java.awt.Color;

import app.interfaces.Estructura;
import app.modelo.ObjetoGrafico;

public class EstructuraLadrillo extends ObjetoGrafico implements Estructura {

	public EstructuraLadrillo() {
		super("imagen/ladrillo.png", Color.RED);
	}

	@Override
	public void colisionBala() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruir() {
		// TODO Auto-generated method stub
		
	}


}
