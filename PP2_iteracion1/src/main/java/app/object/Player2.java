package app.object;

public class Player2 {
	private Puntaje puntaje;
	private KeyEventListenerCop listenerCop;
	
	public Player2(Puntaje puntaje, Draftsman dibujador){
		this.puntaje = puntaje;
		this.listenerCop = new KeyEventListenerCop(dibujador.getEntorno());
	}

	public Puntaje getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Puntaje puntaje) {
		this.puntaje.setPuntaje(this.puntaje.getPuntaje() + puntaje.getPuntaje());
		this.puntaje.setCantidadDeEnemigosAsesinados(this.puntaje.getCantidadDeEnemigosAsesinados() + puntaje.getCantidadDeEnemigosAsesinados());
	}

	public KeyEventListenerCop getListenerCop() {
		return listenerCop;
	}
}