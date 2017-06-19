package app.vistas;

import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void testMenu(){
		Menu menu= new Menu();
		menu.getEleccion();
		menu.getRdbtnTank();
		menu.getRdbtnBomberman();
		menu.getRdbtnPacman();
		menu.getBtnAceptar();
		menu.getBtnOk();
		menu.getSerialversionuid();
		menu.getBg();
		menu.getIcono_Tank();
		menu.getIcono_Pacman();
		menu.getIcono_Bomberman();
		menu.getPanelTank();
		menu.getComboBox_DIFICULTAD();
		menu.getComboBox_ENEMIGOS();
		menu.getComboBox_NIVELES();
		menu.getComboBox_VIDAS();
		menu.getFrmMenu();
		menu.getImagen_Bomberman();
		menu.getImagen_Pacman();
		menu.getImagen_Tank();
		
		menu.main(null);
		
	}
	
}
