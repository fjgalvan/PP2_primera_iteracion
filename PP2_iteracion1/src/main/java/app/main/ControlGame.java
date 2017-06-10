package app.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.vistas.Menu;
import clase_properties.EleccionMenu;
import clase_properties.Principal;

public class ControlGame implements ActionListener{
	private Menu menu;
	
	public ControlGame(){
		this.menu = new Menu();
		this.menu.getBtnAceptar().addActionListener(this);
		this.menu.getBtnOk().addActionListener(this);
		this.menu.getRdbtnTank().addActionListener(this);
		this.menu.getRdbtnPacman().addActionListener(this);
		this.menu.getRdbtnBomberman().addActionListener(this);
	}

	public void iniciar(){
		this.menu.setVisible(true);
		this.menu.getFrmMenu().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.menu.getRdbtnTank().isSelected()){
			System.out.println("selecciono tank!");
			this.menu.getPanelTank().setVisible(true);
		}else{
			this.menu.getPanelTank().setVisible(false);
		}
		
		if(this.menu.getRdbtnBomberman().isSelected())
			this.menu.getPanelTank().setVisible(false);
		if(this.menu.getRdbtnPacman().isSelected())
			this.menu.getPanelTank().setVisible(false);
	
		if(e.getSource() == this.menu.getBtnAceptar()){
			if(this.menu.getRdbtnTank().isSelected()==true){
				System.out.println("selecciono tank!");
				this.menu.getPanelTank().setVisible(true);
			}
			else{
				this.menu.getPanelTank().setVisible(false);
			}
			
			if(this.menu.getRdbtnBomberman().isSelected()==true){
				System.out.println("selecciono Bomberman!");
				
				this.menu.setEleccion(new EleccionMenu("facil", "0", "Bomberman", "1", "1"));
				Principal principal= new Principal();
				principal.ModificarArchivo(this.menu.getEleccion());
			}
			
			if(this.menu.getRdbtnPacman().isSelected()==true){
				System.out.println("selecciono Pacman!");
				this.menu.setEleccion(new EleccionMenu("facil", "0", "pacman", "1", "1"));
				Principal principal= new Principal();
				principal.ModificarArchivo(this.menu.getEleccion());
			}
			//ESTO ES AL FINAL
			if(this.menu.getRdbtnTank().isSelected()){
				Game game = new Game();
				game.iniciar();
			}
			else if(this.menu.getRdbtnPacman().isSelected()){
				GamePacman gameP = new GamePacman();
				gameP.iniciar();
			}
			else if(this.menu.getRdbtnBomberman().isSelected()){
				GameBomberman gameB = new GameBomberman();
				gameB.iniciar();
			}
			this.menu.setVisible(false);
		}
		else if(e.getSource() == this.menu.getBtnOk()){
			String comboBox_nivel =  (String) this.menu.getComboBox_NIVELES().getSelectedItem();
			System.out.println("comboBox_nivel: "+comboBox_nivel);
			
			String comboBox_enemigos =  (String) this.menu.getComboBox_ENEMIGOS().getSelectedItem();
			System.out.println("comboBox_enemigos: "+comboBox_enemigos);
			
			String comboBox_dificultad =  (String) this.menu.getComboBox_DIFICULTAD().getSelectedItem();
			System.out.println("comboBox_nivel: "+comboBox_dificultad);
			
			String comboBox_vidas =  (String) this.menu.getComboBox_VIDAS().getSelectedItem();
			System.out.println("comboBox_nivel: "+comboBox_vidas);
			
			this.menu.setEleccion(new EleccionMenu(comboBox_dificultad, comboBox_enemigos, "tank", comboBox_nivel, comboBox_vidas));
			
			Principal principal= new Principal();
			principal.ModificarArchivo(this.menu.getEleccion());
		}
	}
}
