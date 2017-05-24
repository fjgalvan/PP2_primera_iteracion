package app.object;

public class Puntaje {
	private double puntaje;
	private int cantidadDeEnemigosAsesinados;
	
	public Puntaje(double puntaje, int cantidadDeEnemigosAsesinados){
		this.puntaje = puntaje;
		this.cantidadDeEnemigosAsesinados = cantidadDeEnemigosAsesinados;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	public int getCantidadDeEnemigosAsesinados() {
		return cantidadDeEnemigosAsesinados;
	}

	public void setCantidadDeEnemigosAsesinados(int cantidadDeEnemigosAsesinados) {
		this.cantidadDeEnemigosAsesinados = cantidadDeEnemigosAsesinados;
	}
}
