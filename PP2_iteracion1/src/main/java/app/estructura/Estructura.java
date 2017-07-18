package app.estructura;

import java.awt.Point;

import app.modelo.ObjetoGrafico;

public class Estructura extends ObjetoGrafico {
	private TipoDeEstructura tipoDeEstructura;
	
	public Estructura(Point coordinate, Point size, String imagen, TipoDeEstructura tipoDeEstructura)
	{
		super(coordinate, size, imagen);
		this.tipoDeEstructura = tipoDeEstructura;
	}

	public TipoDeEstructura getTipoDeEstructura() {
		return tipoDeEstructura;
	}

	public void setTipoDeEstructura(TipoDeEstructura tipoDeEstructura) {
		this.tipoDeEstructura = tipoDeEstructura;
	}
}
