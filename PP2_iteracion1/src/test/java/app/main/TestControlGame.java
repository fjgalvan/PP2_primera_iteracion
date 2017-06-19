package app.main;

import java.awt.event.ActionEvent;

import org.junit.Test;

public class TestControlGame {
	//Menu menu= new Menu();
	ControlGame control= new ControlGame();

	@Test
	public void testIniciar() {
		control.iniciar();
		control.getMenu();
		//NO SE QUIÉN ES e
		ActionEvent e= new ActionEvent(control.getMenu(), 10, "", 10);//ActionEvent(menu, 10, "");

		control.actionPerformed(e);
	}
}
