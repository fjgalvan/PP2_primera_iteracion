package app.vistas;

//import java.awt.BorderLayout; 
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
		
		rdbtnTank = new JRadioButton("TANK");
		rdbtnTank.setBackground(Color.ORANGE);
		rdbtnTank.setBounds(43, 38, 109, 23);
		frmMenu.getContentPane().add(rdbtnTank);
		bg.add(rdbtnTank);
		
		rdbtnBomberman = new JRadioButton("BOMBERMAN");
		rdbtnBomberman.setBackground(new Color(255, 102, 51));
		rdbtnBomberman.setBounds(43, 123, 109, 23);
		frmMenu.getContentPane().add(rdbtnBomberman);
		bg.add(rdbtnBomberman);
		
		rdbtnPacman = new JRadioButton("PACMAN");
		rdbtnPacman.setBackground(new Color(255, 255, 0));
		rdbtnPacman.setBounds(43, 203, 109, 23);
		frmMenu.getContentPane().add(rdbtnPacman);
		bg.add(rdbtnPacman);
		
		panelTank = new JPanel();
		panelTank.setBackground(Color.ORANGE);
		panelTank.setBounds(223, 11, 450, 105);
		frmMenu.getContentPane().add(panelTank);
		panelTank.setLayout(null);
		panelTank.setVisible(false);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.setBounds(42, 292, 156, 23);
		frmMenu.getContentPane().add(btnAceptar);
		
		JLabel lblNIVELES = new JLabel("NIVELES");
		lblNIVELES.setBounds(10, 11, 68, 14);
		panelTank.add(lblNIVELES);
		
		JLabel lblENEMIGOS = new JLabel("ENEMIGOS");
		lblENEMIGOS.setBounds(118, 11, 68, 14);
		panelTank.add(lblENEMIGOS);
		
		JLabel lblNewLabel = new JLabel("DIFICULTAD");
		lblNewLabel.setBounds(237, 11, 68, 14);
		panelTank.add(lblNewLabel);
		
		JLabel lblVidas = new JLabel("VIDAS");
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
		comboBox_VIDAS.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3"}));
		comboBox_VIDAS.setBounds(348, 36, 92, 20);
		panelTank.add(comboBox_VIDAS);
		
		btnOk = new JButton("OK");
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setBounds(10, 72, 89, 23);
		panelTank.add(btnOk);
		
		JLabel lblTank = new JLabel("");
		lblTank.setBounds(53, 68, 145, 48);
		frmMenu.getContentPane().add(lblTank);
		
		imagen_Tank= new ImageIcon(getClass().getResource("/imagen/tank.png")); 
		icono_Tank= new ImageIcon(imagen_Tank.getImage().getScaledInstance(lblTank.getWidth()-150, lblTank.getHeight() -10, Image.SCALE_DEFAULT));
		lblTank.setIcon(icono_Tank);
		
		
		
		JLabel lblImagenBomberman = new JLabel("");
		lblImagenBomberman.setBounds(53, 148, 145, 48);
		frmMenu.getContentPane().add(lblImagenBomberman);
		
		imagen_Bomberman= new ImageIcon(getClass().getResource("/imagen/Bomberman.png")); 
		icono_Bomberman= new ImageIcon(imagen_Bomberman.getImage().getScaledInstance(lblImagenBomberman.getWidth()-150, lblImagenBomberman.getHeight() -10, Image.SCALE_DEFAULT));
		lblImagenBomberman.setIcon(icono_Bomberman);
		
		
		JLabel lblImagenPacman = new JLabel("");
		lblImagenPacman.setBounds(53, 233, 145, 48);
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ButtonGroup getBg() {
		return bg;
	}

	public ImageIcon getImagen_Tank() {
		return imagen_Tank;
	}

	public ImageIcon getIcono_Tank() {
		return icono_Tank;
	}

	public ImageIcon getImagen_Bomberman() {
		return imagen_Bomberman;
	}

	public ImageIcon getIcono_Bomberman() {
		return icono_Bomberman;
	}

	public ImageIcon getImagen_Pacman() {
		return imagen_Pacman;
	}

	public ImageIcon getIcono_Pacman() {
		return icono_Pacman;
	}

	public JPanel getPanelTank() {
		return panelTank;
	}

	public void setImagen_Tank(ImageIcon imagen_Tank) {
		this.imagen_Tank = imagen_Tank;
	}

	public void setIcono_Tank(ImageIcon icono_Tank) {
		this.icono_Tank = icono_Tank;
	}

	public void setImagen_Bomberman(ImageIcon imagen_Bomberman) {
		this.imagen_Bomberman = imagen_Bomberman;
	}

	public void setIcono_Bomberman(ImageIcon icono_Bomberman) {
		this.icono_Bomberman = icono_Bomberman;
	}

	public void setImagen_Pacman(ImageIcon imagen_Pacman) {
		this.imagen_Pacman = imagen_Pacman;
	}

	public void setIcono_Pacman(ImageIcon icono_Pacman) {
		this.icono_Pacman = icono_Pacman;
	}

	public void setPanelTank(JPanel panelTank) {
		this.panelTank = panelTank;
	}

	public void setRdbtnTank(JRadioButton rdbtnTank) {
		this.rdbtnTank = rdbtnTank;
	}

	public void setRdbtnBomberman(JRadioButton rdbtnBomberman) {
		this.rdbtnBomberman = rdbtnBomberman;
	}

	public void setRdbtnPacman(JRadioButton rdbtnPacman) {
		this.rdbtnPacman = rdbtnPacman;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
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

	public void setComboBox_VIDAS(JComboBox<String> comboBox_VIDAS) {
		this.comboBox_VIDAS = comboBox_VIDAS;
	}

	public void setComboBox_DIFICULTAD(JComboBox<String> comboBox_DIFICULTAD) {
		this.comboBox_DIFICULTAD = comboBox_DIFICULTAD;
	}

	public void setComboBox_ENEMIGOS(JComboBox<String> comboBox_ENEMIGOS) {
		this.comboBox_ENEMIGOS = comboBox_ENEMIGOS;
	}

	public void setComboBox_NIVELES(JComboBox<String> comboBox_NIVELES) {
		this.comboBox_NIVELES = comboBox_NIVELES;
	}

	public JFrame getFrmMenu() {
		return frmMenu;
	}

	public void setFrmMenu(JFrame frmMenu) {
		this.frmMenu = frmMenu;
	}
}
