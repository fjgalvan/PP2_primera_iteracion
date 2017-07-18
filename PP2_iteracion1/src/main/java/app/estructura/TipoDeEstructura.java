package app.estructura;

import app.enums.TipoEstructura;

public class TipoDeEstructura {
	private TipoEstructura tipo;
	private boolean colisicionBullet;
	private boolean colisicionTank;
	
	public TipoDeEstructura(TipoEstructura tipo, boolean colisicionBullet, boolean colisicionTank){
		this.tipo = tipo;
		this.colisicionBullet = colisicionBullet;
		this.colisicionTank = colisicionTank;
	}

	public TipoEstructura getTipo() {
		return tipo;
	}

	public void setTipo(TipoEstructura tipo) {
		this.tipo = tipo;
	}

	public boolean isColisicionBullet() {
		return colisicionBullet;
	}

	public void setColisicionBullet(boolean colisicionBullet) {
		this.colisicionBullet = colisicionBullet;
	}

	public boolean isColisicionTank() {
		return colisicionTank;
	}

	public void setColisicionTank(boolean colisicionTank) {
		this.colisicionTank = colisicionTank;
	}
}
