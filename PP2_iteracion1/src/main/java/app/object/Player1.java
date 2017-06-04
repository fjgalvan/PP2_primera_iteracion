package app.object;

public class Player1 {
	private Puntaje puntaje;
	private KeyEventListener listener;
	
	public Player1(Puntaje puntaje,Draftsman dibujador){
		this.puntaje = puntaje;
		this.listener = new KeyEventListener(dibujador.getEntorno());
	}

	public Puntaje getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Puntaje puntaje) {
		this.puntaje.setPuntaje(this.puntaje.getPuntaje() + puntaje.getPuntaje());
		this.puntaje.setCantidadDeEnemigosAsesinados(this.puntaje.getCantidadDeEnemigosAsesinados() + puntaje.getCantidadDeEnemigosAsesinados());
	}

	public KeyEventListener getListener() {
		return listener;
	}
}
