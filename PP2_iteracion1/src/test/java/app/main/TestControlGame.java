package app.main;

//import java.awt.event.ActionEvent;
import static org.junit.Assert.*;
import org.junit.Test;
import app.vistas.Menu;

public class TestControlGame {
	Menu menu= new Menu();
	ControlGame control= new ControlGame();
	
/*	@Test
	public void testIniciar() {
		control.iniciar();
		ActionEvent e= new ActionEvent(control.getMenu(), 10, "", 10);//ActionEvent(menu, 10, "");
		control.actionPerformed(e);
		control.getMenu().getRdbtnTank().setSelected(true);
		control.getMenu().getRdbtnTank().setSelected(true);
		control.getMenu().getRdbtnBomberman().setSelected(true);
		control.getMenu().getBtnAceptar().setSelected(true);
		assertNotNull(control.getMenu().getRdbtnTank());
	}*/

	@Test
	public void testMenu() {
		control.iniciar();
		control.setTankEleccionMenu();
		assertNotNull(control.getMenu());
	}
}
