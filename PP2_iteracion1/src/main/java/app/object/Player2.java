package app.object;

public class Player2 {
	private Puntaje puntaje;
	
	public Player2(Puntaje puntaje){
		this.puntaje = puntaje;
	}

	public Puntaje getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Puntaje puntaje) {
		this.puntaje.setPuntaje(this.puntaje.getPuntaje() + puntaje.getPuntaje());
	}
}