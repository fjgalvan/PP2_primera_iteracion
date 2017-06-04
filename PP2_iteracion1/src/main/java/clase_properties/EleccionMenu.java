package clase_properties;

public class EleccionMenu {
	public String dificultad_elegido;
	public String enemigos_elegido;
	public String juego_elegido;
	public String nivel_elegido;
	public String vidas_elegido;
	
	public EleccionMenu(String dificultad, String enemigos, String juego, String nivel,String vidas){
		this.dificultad_elegido= dificultad;
		this.enemigos_elegido= enemigos;
		this.juego_elegido= juego;
		this.nivel_elegido= nivel;
		this.vidas_elegido= vidas;
	}

	public String getDificultad_elegido() {
		return dificultad_elegido;
	}

	public void setDificultad_elegido(String dificultad_elegido) {
		this.dificultad_elegido = dificultad_elegido;
	}

	public String getEnemigos_elegido() {
		return enemigos_elegido;
	}

	public void setEnemigos_elegido(String enemigos_elegido) {
		this.enemigos_elegido = enemigos_elegido;
	}

	public String getJuego_elegido() {
		return juego_elegido;
	}

	public void setJuego_elegido(String juego_elegido) {
		this.juego_elegido = juego_elegido;
	}

	public String getNivel_elegido() {
		return nivel_elegido;
	}

	public void setNivel_elegido(String nivel_elegido) {
		this.nivel_elegido = nivel_elegido;
	}

	public String getVidas_elegido() {
		return vidas_elegido;
	}

	public void setVidas_elegido(String vidas_elegido) {
		this.vidas_elegido = vidas_elegido;
	}
	
	

}
