package app.main;

import java.awt.event.*;
import app.levels.DataLevelGame;
import app.levels.ManagerLevelGameMain;
import app.vistas.Menu;
import clase_properties.*;

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
	public void actionPerformed(ActionEvent e) 
	{	this.menu.getPanelTank().setVisible(this.menu.getRdbtnTank().isSelected());
		this.menu.getLblImagenBomberman().setEnabled(menu.getRdbtnBomberman().isSelected());		
		this.menu.getLblImagenPacman().setEnabled(menu.getRdbtnPacman().isSelected());
		this.menu.getLblTank().setEnabled(menu.getRdbtnTank().isSelected());
		
		if(e.getSource() == this.menu.getBtnAceptar())
		{
			this.menu.getPanelTank().setVisible(this.menu.getRdbtnTank().isSelected());
			if(this.menu.getRdbtnBomberman().isSelected()==true)
			{	this.menu.setEleccion(new EleccionMenu("facil", 0, "Bomberman", "1",1));	Principal principal= new Principal();
				principal.ModificarArchivo(this.menu.getEleccion());	}
			if(this.menu.getRdbtnPacman().isSelected())
			{	this.menu.setEleccion(new EleccionMenu("facil", 0, "pacman", "1", 1));	Principal principal= new Principal();	
				principal.ModificarArchivo(this.menu.getEleccion());	}
			//ESTO ES AL FINAL
			if(this.menu.getRdbtnTank().isSelected()){
				this.setTankEleccionMenu();
				Principal principal= new Principal();
	//			principal.ModificarArchivo(this.menu.getEleccion());
				DataLevelGame data = new ManagerLevelGameMain(principal).buildDataGame();
				Game game = new Game(data);
				game.iniciar();
			}
			else if(this.menu.getRdbtnPacman().isSelected()){	GamePacman gameP = new GamePacman();	gameP.iniciar();	}
			else if(this.menu.getRdbtnBomberman().isSelected()){	GameBomberman gameB = new GameBomberman();		gameB.iniciar();	}
			this.menu.setVisible(false);
		}
		else if(e.getSource() == this.menu.getBtnOk())
		{		this.setTankEleccionMenu();		Principal principal= new Principal();	principal.ModificarArchivo(this.menu.getEleccion());	}
		
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setTankEleccionMenu()
	{
		String comboBox_nivel =  (String) this.menu.getComboBox_NIVELES().getSelectedItem();			
		int comboBox_enemigos =  Integer.parseInt((String)this.menu.getComboBox_ENEMIGOS().getSelectedItem());
		String comboBox_dificultad =  (String) this.menu.getComboBox_DIFICULTAD().getSelectedItem();
		int comboBox_vidas =  Integer.parseInt((String)this.menu.getComboBox_VIDAS().getSelectedItem());
		this.menu.setEleccion(new EleccionMenu(comboBox_dificultad, comboBox_enemigos, "tank", comboBox_nivel, comboBox_vidas));
	}

}
