package app.vistas;

//import java.awt.BorderLayout; 
import java.awt.EventQueue; 
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import clase_properties.EleccionMenu;
import clase_properties.Principal;

import java.awt.Color;


public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup bg ;
	
	private ImageIcon imagen_Tank;
	private ImageIcon icono_Tank;
	private ImageIcon imagen_Bomberman;
	private ImageIcon icono_Bomberman;
	private ImageIcon imagen_Pacman;
	private ImageIcon icono_Pacman;
	private JPanel panelTank;
	private JRadioButton rdbtnTank;
	private JRadioButton rdbtnBomberman;
	private JRadioButton rdbtnPacman;
	private JButton btnOk;
	private JButton btnAceptar;
	
	public EleccionMenu eleccion= null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					
					
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bg= new ButtonGroup();
		
		rdbtnTank = new JRadioButton("TANK");
		rdbtnTank.setBackground(Color.ORANGE);
		rdbtnTank.setBounds(43, 38, 109, 23);
		contentPane.add(rdbtnTank);
		rdbtnTank.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(rdbtnTank.isSelected())
					panelTank.setVisible(true);
				else
					panelTank.setVisible(false);
			}
		});

		bg.add(rdbtnTank);
		
		rdbtnBomberman = new JRadioButton("BOMBERMAN");
		rdbtnBomberman.setBackground(new Color(255, 102, 51));
		rdbtnBomberman.setBounds(43, 123, 109, 23);
		contentPane.add(rdbtnBomberman);
		rdbtnBomberman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(rdbtnBomberman.isSelected())
					panelTank.setVisible(false);
			}
		});
		bg.add(rdbtnBomberman);
		
		rdbtnPacman = new JRadioButton("PACMAN");
		rdbtnPacman.setBackground(new Color(255, 255, 0));
		rdbtnPacman.setBounds(43, 203, 109, 23);
		contentPane.add(rdbtnPacman);
		rdbtnPacman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(rdbtnBomberman.isSelected())
					panelTank.setVisible(false);
			}
		});
		bg.add(rdbtnPacman);
		
		//final JPanel panelTank = new JPanel();
		panelTank = new JPanel();
		panelTank.setBackground(Color.ORANGE);
		panelTank.setBounds(223, 11, 450, 105);
		contentPane.add(panelTank);
		panelTank.setLayout(null);
		panelTank.setVisible(false);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setForeground(new Color(0, 0, 0));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnTank.isSelected()==true){
					System.out.println("selecciono tank!");
					panelTank.setVisible(true);
				}
				else{
					panelTank.setVisible(false);
				}
				
				if(rdbtnBomberman.isSelected()==true){
					System.out.println("selecciono Bomberman!");
					eleccion= new EleccionMenu("facil", "0", "Bomberman", "1", "1");
					Principal principal= new Principal();
					principal.ModificarArchivo(eleccion);
				}
				
				if(rdbtnPacman.isSelected()==true){
					System.out.println("selecciono Pacman!");
					eleccion= new EleccionMenu("facil", "0", "pacman", "1", "1");
					Principal principal= new Principal();
					principal.ModificarArchivo(eleccion);
				}
			}
		});
		btnAceptar.setBounds(42, 292, 156, 23);
		contentPane.add(btnAceptar);
		
		
		
		
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
		
		final JComboBox<String> comboBox_NIVELES = new JComboBox<String>();
		comboBox_NIVELES.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2"}));
		comboBox_NIVELES.setBounds(10, 36, 89, 20);
		panelTank.add(comboBox_NIVELES);
		
		final JComboBox<String> comboBox_ENEMIGOS = new JComboBox<String>();
		comboBox_ENEMIGOS.setModel(new DefaultComboBoxModel<String>(new String[] {"2", "3", "4"}));
		comboBox_ENEMIGOS.setBounds(118, 36, 89, 20);
		panelTank.add(comboBox_ENEMIGOS);
		
		final JComboBox<String> comboBox_DIFICULTAD = new JComboBox<String>();
		comboBox_DIFICULTAD.setModel(new DefaultComboBoxModel<String>(new String[] {"facil", "intermedio"}));
		comboBox_DIFICULTAD.setBounds(237, 36, 89, 20);
		panelTank.add(comboBox_DIFICULTAD);
		
		final JComboBox<String> comboBox_VIDAS = new JComboBox<String>();
		comboBox_VIDAS.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3"}));
		comboBox_VIDAS.setBounds(348, 36, 92, 20);
		panelTank.add(comboBox_VIDAS);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comboBox_nivel =  (String) comboBox_NIVELES.getSelectedItem();
				System.out.println("comboBox_nivel: "+comboBox_nivel);
				
				String comboBox_enemigos =  (String) comboBox_ENEMIGOS.getSelectedItem();
				System.out.println("comboBox_enemigos: "+comboBox_enemigos);
				
				String comboBox_dificultad =  (String) comboBox_DIFICULTAD.getSelectedItem();
				System.out.println("comboBox_nivel: "+comboBox_dificultad);
				
				String comboBox_vidas =  (String) comboBox_VIDAS.getSelectedItem();
				System.out.println("comboBox_nivel: "+comboBox_vidas);
				
				eleccion= new EleccionMenu(comboBox_dificultad, comboBox_enemigos, "tank", comboBox_nivel, comboBox_vidas);
				
				Principal principal= new Principal();
				principal.ModificarArchivo(eleccion);
			}
		});
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setBounds(10, 72, 89, 23);
		panelTank.add(btnOk);
		
		JLabel lblTank = new JLabel("");
		lblTank.setBounds(53, 68, 145, 48);
		contentPane.add(lblTank);
		
		imagen_Tank= new ImageIcon(getClass().getResource("/imagen/tank.png")); 
		icono_Tank= new ImageIcon(imagen_Tank.getImage().getScaledInstance(lblTank.getWidth()-150, lblTank.getHeight() -10, Image.SCALE_DEFAULT));
		lblTank.setIcon(icono_Tank);
		
		
		
		JLabel lblImagenBomberman = new JLabel("");
		lblImagenBomberman.setBounds(53, 148, 145, 48);
		contentPane.add(lblImagenBomberman);
		
		imagen_Bomberman= new ImageIcon(getClass().getResource("/imagen/Bomberman.png")); 
		icono_Bomberman= new ImageIcon(imagen_Bomberman.getImage().getScaledInstance(lblImagenBomberman.getWidth()-150, lblImagenBomberman.getHeight() -10, Image.SCALE_DEFAULT));
		lblImagenBomberman.setIcon(icono_Bomberman);
		
		
		
		JLabel lblImagenPacman = new JLabel("");
		lblImagenPacman.setBounds(53, 233, 145, 48);
		contentPane.add(lblImagenPacman);
		
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
}
