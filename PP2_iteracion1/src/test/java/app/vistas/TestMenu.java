package app.vistas;

//import static org.junit.Assert.assertTrue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import org.junit.Test;


public class TestMenu {
	private JFrame frmMenu;
	@Test
	public void testMain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.getFrmMenu().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	//ERROR DE TEST CON MAVEN
	@Test
	public void testMenu(){
		Menu menu= new Menu();
		menu.getFrmMenu();
		menu.getEleccion();
		menu.getRdbtnTank();
		menu.getRdbtnBomberman();
		menu.getRdbtnPacman();
		menu.getBtnAceptar();
		menu.getBtnOk();
		Menu.getSerialversionuid();
		menu.getPanelTank();
		menu.getComboBox_DIFICULTAD();
		menu.getComboBox_ENEMIGOS();
		menu.getComboBox_NIVELES();
		menu.getComboBox_VIDAS();
		menu.getFrmMenu();
		
		//NUEVOS getters
		menu.getImagen_Tank();
		menu.getBg();
		menu.getImagen_Bomberman();
		menu.getIcono_Tank();
		menu.getIcono_Bomberman();
		menu.getIcono_Pacman();
		menu.getImagen_Pacman();
		
		//NUEVOS setters
		menu.setImagen_Tank(menu.getImagen_Tank());
		menu.setIcono_Tank(menu.getIcono_Tank());
		menu.setImagen_Bomberman(menu.getImagen_Bomberman());
		menu.setIcono_Bomberman(menu.getIcono_Bomberman());
		menu.setImagen_Pacman(menu.getImagen_Pacman());
		menu.setIcono_Pacman(menu.getIcono_Pacman());
		menu.setFrmMenu(menu.getFrmMenu());
		menu.setPanelTank(menu.getPanelTank());
		menu.setRdbtnTank(menu.getRdbtnTank());
		menu.setRdbtnBomberman(menu.getRdbtnBomberman());
		menu.setRdbtnPacman(menu.getRdbtnPacman());
		menu.setBtnOk(menu.getBtnOk());
		menu.setBtnAceptar(menu.getBtnAceptar());
		menu.setComboBox_VIDAS(menu.getComboBox_VIDAS());
		menu.setComboBox_DIFICULTAD(menu.getComboBox_DIFICULTAD());
		menu.setComboBox_ENEMIGOS(menu.getComboBox_ENEMIGOS());
		menu.setComboBox_NIVELES(menu.getComboBox_NIVELES());
		menu.setLblImagenBomberman(menu.getLblImagenBomberman());
		menu.setLblTank(menu.getLblTank());
		menu.setLblImagenPacman(menu.getLblImagenPacman());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//menu.main(null);
		
	}
	public JFrame getFrmMenu() {
		return frmMenu;
	}
	public void setFrmMenu(JFrame frmMenu) {
		this.frmMenu = frmMenu;
	}
	
}
