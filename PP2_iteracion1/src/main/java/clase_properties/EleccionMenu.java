package clase_properties;

public class EleccionMenu {
	public String dificultad_elegido;
	public int enemigos_elegido;
	public String juego_elegido;
	public String nivel_elegido;
	public int vidas_elegido;
	
	public EleccionMenu(String dificultad, int enemigos, String juego, String nivel,int vidas)
	{
		this.dificultad_elegido= dificultad;
		this.enemigos_elegido= enemigos;
		this.juego_elegido= juego;
		this.nivel_elegido= nivel;
		this.vidas_elegido= vidas;
	}

	public String getDificultad_elegido() {
		return dificultad_elegido;}

	public int getEnemigos_elegido() {
		return enemigos_elegido;}

	public String getJuego_elegido() {
		return juego_elegido;}

	public String getNivel_elegido() {
		return nivel_elegido;}

	public int getVidas_elegido() {
		return vidas_elegido;}
	
}
