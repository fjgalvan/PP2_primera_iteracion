package app.vistas;
 
import java.awt.EventQueue; 
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import clase_properties.EleccionMenu;
import java.awt.Color;


public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmMenu;
	private ImageIcon imagen_Tank;
	private ImageIcon icono_Tank;
	private ImageIcon imagen_Bomberman;
	private ImageIcon icono_Bomberman;
	private ImageIcon imagen_Pacman;
	private ImageIcon icono_Pacman;
	private JPanel panelTank;
	private final ButtonGroup bg ;
	private JRadioButton rdbtnTank;
	private JRadioButton rdbtnBomberman;
	private JRadioButton rdbtnPacman;
	private JButton btnOk;
	private JButton btnAceptar;
	private JComboBox<String> comboBox_VIDAS;
	private JComboBox<String> comboBox_DIFICULTAD;
	private JComboBox<String> comboBox_ENEMIGOS;
	private JComboBox<String> comboBox_NIVELES;
	public EleccionMenu eleccion = null;
	private JLabel lblImagenBomberman,lblTank,lblImagenPacman;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Menu() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Arcade");
		frmMenu.setResizable(false);
		frmMenu.setVisible(false);
		frmMenu.setBounds(100, 100, 734, 365);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.setBackground(Color.DARK_GRAY);
		frmMenu.setLocationRelativeTo(null);
		
		bg= new ButtonGroup();
		frmMenu.getContentPane().setLayout(null);
		
		rdbtnTank = new JRadioButton("TANK");
		rdbtnTank.setBackground(Color.ORANGE);
		rdbtnTank.setBounds(43, 38, 135, 23);
		frmMenu.getContentPane().add(rdbtnTank);
		bg.add(rdbtnTank);
		
		rdbtnBomberman = new JRadioButton("BOMBERMAN");
		rdbtnBomberman.setBackground(new Color(255, 102, 51));
		rdbtnBomberman.setBounds(43, 123, 135, 23);
		frmMenu.getContentPane().add(rdbtnBomberman);
		bg.add(rdbtnBomberman);
		
		rdbtnPacman = new JRadioButton("PACMAN");
		rdbtnPacman.setBackground(new Color(255, 255, 0));
		rdbtnPacman.setBounds(43, 203, 135, 23);
		frmMenu.getContentPane().add(rdbtnPacman);
		bg.add(rdbtnPacman);
		
		panelTank = new JPanel();
		panelTank.setBackground(Color.ORANGE);
		panelTank.setBounds(223, 11, 465, 105);
		frmMenu.getContentPane().add(panelTank);
		panelTank.setLayout(null);
		panelTank.setVisible(false);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.setBounds(42, 292, 156, 23);
		frmMenu.getContentPane().add(btnAceptar);
		
		JLabel lblNIVELES = new JLabel("JUGADORES");
		lblNIVELES.setBounds(10, 11, 93, 14);
		panelTank.add(lblNIVELES);
		
		JLabel lblENEMIGOS = new JLabel("ENEMIGOS");
		lblENEMIGOS.setBounds(118, 11, 92, 14);
		panelTank.add(lblENEMIGOS);
		
		JLabel lblNewLabel = new JLabel("DIFICULTAD");
		lblNewLabel.setBounds(237, 11, 96, 14);
		panelTank.add(lblNewLabel);
		
		JLabel lblVidas = new JLabel("ENERGIA");
		lblVidas.setBounds(348, 11, 68, 14);
		panelTank.add(lblVidas);
		
		comboBox_NIVELES = new JComboBox<String>();
		comboBox_NIVELES.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2"}));
		comboBox_NIVELES.setBounds(10, 36, 89, 20);
		panelTank.add(comboBox_NIVELES);
		
		comboBox_ENEMIGOS = new JComboBox<String>();
		comboBox_ENEMIGOS.setModel(new DefaultComboBoxModel<String>(new String[] {"2", "3", "4"}));
		comboBox_ENEMIGOS.setBounds(118, 36, 89, 20);
		panelTank.add(comboBox_ENEMIGOS);
		
		comboBox_DIFICULTAD = new JComboBox<String>();
		comboBox_DIFICULTAD.setModel(new DefaultComboBoxModel<String>(new String[] {"facil", "intermedio"}));
		comboBox_DIFICULTAD.setBounds(237, 36, 89, 20);
		panelTank.add(comboBox_DIFICULTAD);
		
		comboBox_VIDAS = new JComboBox<String>();
		comboBox_VIDAS.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2"}));
		comboBox_VIDAS.setBounds(348, 36, 92, 20);
		panelTank.add(comboBox_VIDAS);
		
		btnOk = new JButton("OK");
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setBounds(10, 72, 89, 23);
		panelTank.add(btnOk);
		
		lblTank = new JLabel("");
		lblTank.setBounds(80, 70, 133, 48);
		lblTank.setEnabled(false);
		frmMenu.getContentPane().add(lblTank);
		
		imagen_Tank= new ImageIcon(getClass().getResource("/imagen/tank.png")); 
		icono_Tank= new ImageIcon(imagen_Tank.getImage().getScaledInstance(lblTank.getWidth()-150, lblTank.getHeight() -10, Image.SCALE_DEFAULT));
		lblTank.setIcon(icono_Tank);
		
		
		
		lblImagenBomberman = new JLabel("");
		lblImagenBomberman.setBounds(90, 150, 145, 48);
		lblImagenBomberman.setEnabled(false);
		frmMenu.getContentPane().add(lblImagenBomberman);
		
		imagen_Bomberman= new ImageIcon(getClass().getResource("/imagen/Bomberman.png")); 
		icono_Bomberman= new ImageIcon(imagen_Bomberman.getImage().getScaledInstance(lblImagenBomberman.getWidth()-150, lblImagenBomberman.getHeight() -10, Image.SCALE_DEFAULT));
		lblImagenBomberman.setIcon(icono_Bomberman);
		
		
		lblImagenPacman = new JLabel("");
		lblImagenPacman.setBounds(80, 231, 145, 50);
		lblImagenPacman.setEnabled(false);
		frmMenu.getContentPane().add(lblImagenPacman);
		
		imagen_Pacman= new ImageIcon(getClass().getResource("/imagen/pacman.png"));
		icono_Pacman= new ImageIcon(imagen_Pacman.getImage().getScaledInstance(lblImagenPacman.getWidth()-150, lblImagenPacman.getHeight() -10, Image.SCALE_DEFAULT));
		lblImagenPacman.setIcon(icono_Pacman);
	}
	

	public EleccionMenu getEleccion() {
		return eleccion;
	}

	public void setEleccion(EleccionMenu eleccion) {
		this.eleccion = eleccion;
	}

	public JRadioButton getRdbtnTank() {
		return rdbtnTank;
	}

	public JRadioButton getRdbtnBomberman() {
		return rdbtnBomberman;
	}

	public JRadioButton getRdbtnPacman() {
		return rdbtnPacman;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JPanel getPanelTank() {
		return panelTank;
	}

	public JComboBox<String> getComboBox_VIDAS() {
		return comboBox_VIDAS;
	}

	public JComboBox<String> getComboBox_DIFICULTAD() {
		return comboBox_DIFICULTAD;
	}

	public JComboBox<String> getComboBox_ENEMIGOS() {
		return comboBox_ENEMIGOS;
	}

	public JComboBox<String> getComboBox_NIVELES() {
		return comboBox_NIVELES;
	}

	public JLabel getLblImagenBomberman() {
		return lblImagenBomberman;
	}

	public JLabel getLblTank() {
		return lblTank;
	}

	public JLabel getLblImagenPacman() {
		return lblImagenPacman;
	}

	public JFrame getFrmMenu() {
		return frmMenu;
	}
}
