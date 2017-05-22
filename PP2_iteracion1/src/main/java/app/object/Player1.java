package app.object;

public class Player1 {
	private Puntaje puntaje;
	
	public Player1(Puntaje puntaje){
		this.puntaje = puntaje;
	}

	public Puntaje getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Puntaje puntaje) {
		this.puntaje.setPuntaje(this.puntaje.getPuntaje() + puntaje.getPuntaje());
	}
}
