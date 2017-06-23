package app.modelo;

import java.util.List;
import app.object.Bullet;
import app.object.Tank;
import app.util.Util;
import app.modelo.ObjetoGrafico;

public class Colisionador {
	private Tank tankADestruir;
	private ObjetoGrafico objetoADestruir;
	private static Colisionador colisionador;
	
	public static Colisionador getInstance(){
		if(colisionador==null){
			return colisionador = new Colisionador();
		}
		return colisionador;
	}

	/**BULLET*/
	public boolean colisionBullet(Bullet bullet, List<ObjetoGrafico> objetos){
		if(bullet!=null){
		if(Util.estaEnElLimiteDeTablero(bullet.getOrientation(), bullet.getCoordinate())){
			return true;
		}
		return bulletHayColisionConUnObjeto(bullet, objetos);
		}
		return false;
	}
	
	public boolean bulletHayColisionConUnObjeto(ObjetoGrafico objeto,List<ObjetoGrafico> lista)
	{
		boolean ret = false;
		for(ObjetoGrafico obj : lista)
		{
			if(!obj.getClass().getName().equals("app.estructura.EstructuraAgua") 
					&& !obj.getClass().getName().equals("app.estructura.EstructuraFondo")){
				ret = ret || bulletChocaConEstructura(objeto, obj); // dependiendo el estado va atener una colision !=
			}
			if(ret && objetoADestruir==null){
				objetoADestruir = obj;
			}
		}
		return ret;
	}
	
	public boolean bulletChocaConEstructura(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2) {  
    	if (objGraf2 == null)
    		return false;
        double dX = Math.abs(objGraf1.getCoordinate().getX() - (objGraf2.getCoordinate().getX()+20));
        double dY = Math.abs(objGraf1.getCoordinate().getY() - (objGraf2.getCoordinate().getY()+20));
        return (dX <= 25 && dY <= 25);
    }

	//BULLET CON TANK
	public boolean colisionBulletConTank(Bullet bullet, List<Tank> enemysTanks){
		if(bullet!=null){
			return bulletHayColisionConUnTank(bullet, enemysTanks);
		}
		return false;
	}
	
	public boolean bulletHayColisionConUnTank(ObjetoGrafico objeto,List<Tank> enemysTanks)
	{
		boolean ret = false;
		for(Tank enemyTank : enemysTanks)
		{
			ret = ret || bulletChocaConEstructura(objeto, enemyTank);
			if(bulletChocaConEstructura(objeto, enemyTank)){
				tankADestruir = enemyTank;
			}
		}
		return ret;
	}
	

	public Tank getTankADestruir() {
		return tankADestruir;
		
	}
	
	public void setObjetoADestruir(ObjetoGrafico objetoADestruir) {
		this.objetoADestruir = objetoADestruir;
	}

	public ObjetoGrafico getObjetoADestruir() {
		return objetoADestruir;
	}

	/**FIN DE BULLET*/

	public boolean colisiona(List<ObjetoGrafico> lista) {
		boolean ret = false;
		for (ObjetoGrafico obj : lista) {
			if (obj != null) {
				lista.remove(obj);
				for (ObjetoGrafico obj2 : lista) {
					if (obj2 != null) {
						if (!obj.getClass().getName().equals("estructura.EstructuraAgua")) {
							// dependiendo el estado va a tener una colision !=
							ret = ret || bulletChocaConEstructura(obj, obj2);
						}
						if (ret) {
							objetoADestruir = obj;
						}
					}
				}
			}
		}
		return ret;
	}

	// PARA TANQUE
	public boolean chocaConEstructuraTank(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2) {
		if (objGraf2 == null)
			return false;
		double dX = Math.abs(objGraf1.getCoordinate().getX() - (objGraf2.getCoordinate().getX()));
		double dY = Math.abs(objGraf1.getCoordinate().getY() - (objGraf2.getCoordinate().getY()));
		return (dX <= 40 && dY <= 40);
	}

	public boolean hayColision(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2) {
		// izquierda
		boolean colisionIzq = objGraf1.getCoordinate().getX() == objGraf2.getCoordinate().getX()
				+ objGraf2.getSize().getX()
				&& objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY() + objGraf2.getSize().getY()
				&& objGraf1.getCoordinate().getY() + objGraf2.getSize().getY() > objGraf2.getCoordinate().getY();

		// derecha
		boolean colisionDer = objGraf1.getCoordinate().getX() + objGraf1.getSize().getX() == objGraf2.getCoordinate()
				.getX() && objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY() + objGraf2.getSize().getY()
				&& objGraf1.getCoordinate().getY() + objGraf1.getSize().getY() > objGraf2.getCoordinate().getY();
		// arriba
		boolean colisionArr = objGraf1.getCoordinate().getY() == objGraf2.getCoordinate().getY()
				+ objGraf2.getSize().getY()
				&& objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX() + objGraf2.getSize().getX()
				&& objGraf1.getCoordinate().getX() + objGraf1.getSize().getX() > objGraf2.getCoordinate().getX();

		// abajo
		boolean colisionAbj = objGraf1.getCoordinate().getY() + objGraf1.getSize().getY() == objGraf2.getCoordinate()
				.getY() && objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX() + objGraf2.getSize().getX()
				&& objGraf1.getCoordinate().getX() + objGraf1.getSize().getX() > objGraf2.getCoordinate().getX();

		return (colisionIzq || colisionDer || colisionArr || colisionAbj);
	}

	public boolean hayColisionArriba(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2) {
		boolean colisionArr = objGraf1.getCoordinate().getY() == objGraf2.getCoordinate().getY()
				+ objGraf2.getSize().getY()
				&& objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX() + objGraf2.getSize().getX()
				&& objGraf1.getCoordinate().getX() + objGraf1.getSize().getX() > objGraf2.getCoordinate().getX();
		return colisionArr;
	}

	public boolean hayColisionAbajo(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2) {
		boolean colisionAbj = objGraf1.getCoordinate().getY() + objGraf1.getSize().getY() == objGraf2.getCoordinate()
				.getY() && objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX() + objGraf2.getSize().getX()
				&& objGraf1.getCoordinate().getX() + objGraf1.getSize().getX() > objGraf2.getCoordinate().getX();
		return colisionAbj;
	}

	public boolean hayColisionDerecha(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2) {
		boolean colisionDer = objGraf1.getCoordinate().getX() + objGraf1.getSize().getX() == objGraf2.getCoordinate()
				.getX() && objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY() + objGraf2.getSize().getY()
				&& objGraf1.getCoordinate().getY() + objGraf1.getSize().getY() > objGraf2.getCoordinate().getY();

		return colisionDer;
	}

	public boolean hayColisionIzquierda(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2) {
		boolean colisionIzq = objGraf1.getCoordinate().getX() == objGraf2.getCoordinate().getX()
				+ objGraf2.getSize().getX()
				&& objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY() + objGraf2.getSize().getY()
				&& objGraf1.getCoordinate().getY() + objGraf1.getSize().getY() > objGraf2.getCoordinate().getY();
		return colisionIzq;
	}

	/** PARA COLOCAR LAS ESTRUCTURAS */
	// public void posicionar(Plataforma[] plataformas, Entorno unEntorno) {
	// boolean setocan;
	// int i, k;
	//
	// do {
	// // Posiciono al azar
	// posicionAlAzar(unEntorno);
	//
	// setocan = false;
	// i = 0;
	// k = 0;
	// do {
	// // Validar que no se toque con ningÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Âºn otro
	// if (!this.posicionado
	// && this.seTocan(plataformas[i], this.separacion)) {
	// k++;
	// if (k == 2)
	// // Se toca consigo y uno mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¡s
	// setocan = true;
	// }
	// i++;
	// } while (i < plataformas.length && !setocan);
	//
	// } while (setocan);
	//
	// }
	//
	// private void posicionAlAzar(Entorno unEntorno) {
	// Random azar = new Random();
	//
	// this.x = this.ancho
	// + azar.nextInt(unEntorno.ancho() - ((int) this.ancho * 2));
	//
	// this.y = unEntorno.alto() * 0.1
	// + azar.nextInt((int) (unEntorno.alto() * 0.75));
	// }
	//
	// private boolean seTocan(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2,
	// double unaSeparacion) {
	// double dX = objGraf1.getCoordinate().getX() -
	// objGraf2.getCoordinate().getX();
	// double dY = objGraf1.getCoordinate().getY() -
	// objGraf2.getCoordinate().getY();
	// boolean enX = (Math.abs(dX) < (objGraf1.getSize().getAncho() / 2 +
	// objGraf2.getSize().getAncho() / 2)
	// + unaSeparacion);
	// boolean enY = (Math.abs(dY) < (objGraf1.getSize().getAlto() / 2 +
	// objGraf2.getSize().getAlto() / 2)
	// + unaSeparacion);
	// return (enX && enY);
	// }
	//
}
