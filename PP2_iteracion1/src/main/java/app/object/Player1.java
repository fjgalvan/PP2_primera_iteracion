package app.object;

public class Player1 {
	private double puntaje;
	private int cantidadDeEnemigosAsesinados;
	private KeyEventListener listener;

	public Player1(double puntaje, int cantidadDeEnemigosAsesinados, Draftsman dibujador) {
		this.puntaje = puntaje;
		this.cantidadDeEnemigosAsesinados = cantidadDeEnemigosAsesinados;
		this.listener = new KeyEventListener(dibujador.getEntorno());
	}

	public double getPuntaje() {
		return this.puntaje;
	}

	public int getCantidadDeEnemigosAsesinados() {
		return this.cantidadDeEnemigosAsesinados;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje += puntaje;
	}

	public void setCantidadDeEnemigosAsesinados(int cantidadDeEnemigosAsesinados) {
		this.cantidadDeEnemigosAsesinados += cantidadDeEnemigosAsesinados;
	}

	public KeyEventListener getListener() {
		return listener;
	}
}
