package app.modelo;

public class Colisionador {
	
		public Colisionador (){
			
		}
		
//		public boolean colisionaConEstructura(Plataforma[] plataformas) {
//	        int i = 0;
//	        boolean setocan = false;
	//
//	        do {
//	            if (plataformas[i] != null)
//	                setocan = this.sobrePlataforma(plataformas[i]);
//	            if (setocan)
//	                if (plataformas[i].getDireccion() == 0)
//	                    this.izquierda(plataformas[i]);
//	                else
//	                    this.derecha(plataformas[i]);
//	            i++;
//	        } while (i < plataformas.length && !setocan);
	//
//	        return setocan;
//	    }

		public boolean chocaConEstructura(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2) {  
	    	if (objGraf2 == null)
	    		return false;
	        double dX = Math.abs(objGraf1.getCoordinate().getX() - (objGraf2.getCoordinate().getX()+20));
	        double dY = Math.abs(objGraf1.getCoordinate().getY() - (objGraf2.getCoordinate().getY()+20));
	        return (dX <= 25 && dY <= 25);
	    }
		
		//PARA TANQUE
		public boolean chocaConEstructuraTank(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2) {  
	    	if (objGraf2 == null)
	    		return false;
	        double dX = Math.abs(objGraf1.getCoordinate().getX() - (objGraf2.getCoordinate().getX()));
	        double dY = Math.abs(objGraf1.getCoordinate().getY() - (objGraf2.getCoordinate().getY()));
	        return (dX <= 40 && dY <= 40);
	    }
		
		public boolean hayColision(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
		{
			//izquierda
			boolean colisionIzq = 	objGraf1.getCoordinate().getX() == objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&		
									objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
									objGraf1.getCoordinate().getY() + objGraf2.getSize().getAlto() > objGraf2.getCoordinate().getY();
		
			//derecha
			boolean colisionDer = 	objGraf1.getCoordinate().getX()+objGraf1.getSize().getAncho() == objGraf2.getCoordinate().getX() &&
									objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
									objGraf1.getCoordinate().getY()+objGraf1.getSize().getAlto() > objGraf2.getCoordinate().getY();		
			//arriba
			boolean colisionArr =	objGraf1.getCoordinate().getY() == objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
									objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&
									objGraf1.getCoordinate().getX()+objGraf1.getSize().getAncho() > objGraf2.getCoordinate().getX();
					
			//abajo
			boolean colisionAbj = 	objGraf1.getCoordinate().getY() + objGraf1.getSize().getAlto() == objGraf2.getCoordinate().getY() &&
									objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&
									objGraf1.getCoordinate().getX() + objGraf1.getSize().getAncho() > objGraf2.getCoordinate().getX();
								  
			return (colisionIzq || colisionDer || colisionArr || colisionAbj);
		}
		
		public boolean hayColisionArriba(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
		{
			boolean colisionArr = 	objGraf1.getCoordinate().getY() == objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
									objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&
									objGraf1.getCoordinate().getX() + objGraf1.getSize().getAncho() > objGraf2.getCoordinate().getX();
			return colisionArr;		  
		}
		
		public boolean hayColisionAbajo(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
		{
			boolean colisionAbj = 	objGraf1.getCoordinate().getY()+objGraf1.getSize().getAlto() == objGraf2.getCoordinate().getY() &&
									objGraf1.getCoordinate().getX() < objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&
									objGraf1.getCoordinate().getX()+objGraf1.getSize().getAncho() > objGraf2.getCoordinate().getX();
			return colisionAbj;		  
		}
		
		public boolean hayColisionDerecha(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
		{
			boolean colisionDer = 	objGraf1.getCoordinate().getX()+objGraf1.getSize().getAncho() == objGraf2.getCoordinate().getX() &&
									objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
									objGraf1.getCoordinate().getY()+objGraf1.getSize().getAlto() > objGraf2.getCoordinate().getY();		

			return colisionDer;
		}
		
		public boolean hayColisionIzquierda(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2)
		{
			boolean colisionIzq = 	objGraf1.getCoordinate().getX() == objGraf2.getCoordinate().getX()+objGraf2.getSize().getAncho() &&		
									objGraf1.getCoordinate().getY() < objGraf2.getCoordinate().getY()+objGraf2.getSize().getAlto() &&
									objGraf1.getCoordinate().getY()+objGraf1.getSize().getAlto() > objGraf2.getCoordinate().getY();
			return colisionIzq;
		}
		
		/** PARA COLOCAR LAS ESTRUCTURAS*/
//		 public void posicionar(Plataforma[] plataformas, Entorno unEntorno) {
//		        boolean setocan;
//		        int i, k;
	//
//		        do {
//		            // Posiciono al azar
//		            posicionAlAzar(unEntorno);
	//
//		            setocan = false;
//		            i = 0;
//		            k = 0;
//		            do {
//		                // Validar que no se toque con ningÃƒÂºn otro
//		                if (!this.posicionado
//		                        && this.seTocan(plataformas[i], this.separacion)) {
//		                    k++;
//		                    if (k == 2)
//		                        // Se toca consigo y uno mÃƒÂ¡s
//		                        setocan = true;
//		                }
//		                i++;
//		            } while (i < plataformas.length && !setocan);
	//
//		        } while (setocan);
	//
//		    }
	//
//		    private void posicionAlAzar(Entorno unEntorno) {
//		        Random azar = new Random();
	//
//		        this.x = this.ancho
//		                + azar.nextInt(unEntorno.ancho() - ((int) this.ancho * 2));
	//
//		        this.y = unEntorno.alto() * 0.1
//		                + azar.nextInt((int) (unEntorno.alto() * 0.75));
//		    }
//		    
//		private boolean seTocan(ObjetoGrafico objGraf1, ObjetoGrafico objGraf2, double unaSeparacion) {
//		        double dX = objGraf1.getCoordinate().getX() - objGraf2.getCoordinate().getX();
//		        double dY = objGraf1.getCoordinate().getY() - objGraf2.getCoordinate().getY();
//		        boolean enX = (Math.abs(dX) < (objGraf1.getSize().getAncho() / 2 + objGraf2.getSize().getAncho() / 2)
//		                + unaSeparacion);
//		        boolean enY = (Math.abs(dY) < (objGraf1.getSize().getAlto() / 2 + objGraf2.getSize().getAlto() / 2)
//		                + unaSeparacion);
//		        return (enX && enY);
//		}
	//	
	}
