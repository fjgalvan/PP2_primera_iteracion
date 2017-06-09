package app.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.vistas.Menu;

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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.menu.getBtnAceptar()){
			System.out.println("si");
			if(this.menu.getRdbtnTank().isSelected()){
				System.out.println("no");
				Game game = new Game();
				game.iniciar();
			}
			if(this.menu.getRdbtnPacman().isSelected()){
				GamePacman gameP = new GamePacman();
				gameP.iniciar();
			}
			if(this.menu.getRdbtnBomberman().isSelected()){
				GameBomberman gameB = new GameBomberman();
				gameB.iniciar();
			}
		}
	}
}
