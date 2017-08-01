package app.object;

public class Player {
	private double puntaje;
	private int cantidadDeEnemigosAsesinados;
	private KeyEventListener listener;

	public Player(double puntaje, int cantidadDeEnemigosAsesinados, KeyEventListener listener) {
		this.puntaje = puntaje;
		this.cantidadDeEnemigosAsesinados = cantidadDeEnemigosAsesinados;
		this.listener = listener; }

	public double getPuntaje() { return this.puntaje;}
	public int getCantidadDeEnemigosAsesinados() { return this.cantidadDeEnemigosAsesinados;}
	public void setPuntaje(double puntaje) {this.puntaje += puntaje;}
	public void setCantidadDeEnemigosAsesinados(int cantidadDeEnemigosAsesinados) {this.cantidadDeEnemigosAsesinados += cantidadDeEnemigosAsesinados;}
    public KeyEventListener getListener() { return listener;}
}
