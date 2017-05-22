package app.object;

public class Puntaje {
	private double puntaje;
	
	public Puntaje(double puntaje){
		this.puntaje = puntaje;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}
	
	public void agregarPuntaje(double puntaje) {
		this.puntaje = this.puntaje + puntaje;
	}
}
