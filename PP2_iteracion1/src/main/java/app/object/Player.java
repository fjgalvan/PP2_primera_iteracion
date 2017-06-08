package app.object;

public class Player {
	private double puntaje;
	private int cantidadDeEnemigosAsesinados;
	private IKeyEventListener listener;

	public Player(double puntaje, int cantidadDeEnemigosAsesinados, IKeyEventListener listener) {
		this.puntaje = puntaje;
		this.cantidadDeEnemigosAsesinados = cantidadDeEnemigosAsesinados;
		this.listener = listener;
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

	public IKeyEventListener getListener() {
		return listener;
	}
}
