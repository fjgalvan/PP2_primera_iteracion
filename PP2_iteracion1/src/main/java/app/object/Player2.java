package app.object;

public class Player2 {
	private double puntaje;
	private int cantidadDeEnemigosAsesinados;
	private KeyEventListenerCop listenerCop;

	/*public Player2(double puntaje, int cantidadDeEnemigosAsesinados, Draftsman dibujador) {
		this.puntaje = puntaje;
		this.cantidadDeEnemigosAsesinados = cantidadDeEnemigosAsesinados;
		this.listenerCop = new KeyEventListenerCop(dibujador.getEntorno());
	}*/

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

	public KeyEventListenerCop getListenerCop() {
		return listenerCop;
	}
}