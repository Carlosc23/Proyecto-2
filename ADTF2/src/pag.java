import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class pag {
	private Conexion con = new Conexion();
	private JFrame jpag;
	private JTextField txtNombre;
	private JTextField txtCarrera;
	private JTextField txtColegio;
	private JCheckBox chckbxTecnologia;
	private JCheckBox chckbxMusica;
	private JCheckBox chckbxArte;
	private JCheckBox chckbxDeportes;
	private JCheckBox chckbxOrganizacion;
	private JCheckBox chckbxAnalitico;
	private JCheckBox chckbxEstudioso;
	private JCheckBox chckbxTrabajoIndividual;
	private JLabel lblBusquedaDeCatedraticos;
	private JComboBox cursos;
	private JButton btnCrear;
	private JComboBox nombres;
	private JButton btnBuscar;
	private JCheckBox chckbxVideojuegos;
	private JCheckBox chckbxLectura;
	private JLabel lblCursosLlevados;
	private JComboBox <String> nombresc;
	private JComboBox cursosc;
	private JButton btnGuardar;
	ArrayList nombress = new ArrayList();
	private JComboBox <String> cmbCatedratico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new pag();

	}

	/**
	 * Create the application.
	 */
	public pag() {
		initialize();
		jpag.setVisible(true);
		con.insertar("tecnologia", "tecnologia");
		con.insertar("arte", "arte");
		con.insertar("deporte", "deporte");
		con.insertar("musica", "musica");
		con.insertar("videojuegos", "videojuegos");
		con.insertar("analitico", "analitico");
		con.insertar("estudioso", "estudioso");
		con.insertar("trabajoindividual", "trabajoindividual");
		con.insertar("lectura", "lectura");
		con.insertar("organizacion", "organizacion");

	}

	/*
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		jpag = new JFrame();
		jpag.setBounds(100, 100, 610, 324);
		jpag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jpag.getContentPane().setLayout(null);

		JLabel lblCreacionDePerfil = new JLabel("Creacion de Perfil");
		lblCreacionDePerfil.setBounds(10, 11, 101, 14);
		jpag.getContentPane().add(lblCreacionDePerfil);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 46, 14);
		jpag.getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(66, 36, 132, 20);
		jpag.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(10, 61, 55, 14);
		jpag.getContentPane().add(lblCarrera);

		txtCarrera = new JTextField();
		txtCarrera.setBounds(66, 58, 132, 20);
		jpag.getContentPane().add(txtCarrera);
		txtCarrera.setColumns(10);

		JLabel lblIntereses = new JLabel("Intereses y cualidades");
		lblIntereses.setBounds(10, 105, 108, 14);
		jpag.getContentPane().add(lblIntereses);

		chckbxTecnologia = new JCheckBox("Tecnologia");
		chckbxTecnologia.setBounds(10, 117, 97, 23);
		jpag.getContentPane().add(chckbxTecnologia);

		chckbxArte = new JCheckBox("Arte");
		chckbxArte.setBounds(10, 143, 97, 23);
		jpag.getContentPane().add(chckbxArte);

		chckbxDeportes = new JCheckBox("Deportes");
		chckbxDeportes.setBounds(10, 169, 97, 23);
		jpag.getContentPane().add(chckbxDeportes);

		JLabel lblColegio = new JLabel("Colegio");
		lblColegio.setBounds(10, 86, 55, 14);
		jpag.getContentPane().add(lblColegio);

		txtColegio = new JTextField();
		txtColegio.setBounds(66, 86, 132, 20);
		jpag.getContentPane().add(txtColegio);
		txtColegio.setColumns(10);

		chckbxOrganizacion = new JCheckBox("Organizacion");
		chckbxOrganizacion.setBounds(113, 117, 97, 23);
		jpag.getContentPane().add(chckbxOrganizacion);

		chckbxAnalitico = new JCheckBox("Analitico");
		chckbxAnalitico.setBounds(113, 143, 97, 23);
		jpag.getContentPane().add(chckbxAnalitico);

		chckbxEstudioso = new JCheckBox("Estudioso");
		chckbxEstudioso.setBounds(113, 169, 97, 23);
		jpag.getContentPane().add(chckbxEstudioso);

		chckbxMusica = new JCheckBox("Musica");
		chckbxMusica.setBounds(10, 195, 97, 23);
		jpag.getContentPane().add(chckbxMusica);

		chckbxTrabajoIndividual = new JCheckBox("Trabajo individual");
		chckbxTrabajoIndividual.setBounds(113, 195, 126, 23);
		jpag.getContentPane().add(chckbxTrabajoIndividual);

		lblBusquedaDeCatedraticos = new JLabel("Busqueda de Catedraticos");
		lblBusquedaDeCatedraticos.setBounds(265, 149, 188, 14);
		jpag.getContentPane().add(lblBusquedaDeCatedraticos);

		btnCrear = new JButton("Crear");
		btnCrear.setBounds(10, 250, 89, 23);
		jpag.getContentPane().add(btnCrear);

		cursos = new JComboBox();
		cursos.setBounds(265, 196, 319, 20);
		jpag.getContentPane().add(cursos);
		cursos.addItem("Cursos");

		cursos.addItem("Algoritmos y Estructuras de Datos");

		nombres = new JComboBox();
		nombres.setBounds(265, 171, 188, 20);
		jpag.getContentPane().add(nombres);
		nombres.addItem("nombre");

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(265, 220, 89, 23);
		jpag.getContentPane().add(btnBuscar);

		chckbxVideojuegos = new JCheckBox("Videojuegos");
		chckbxVideojuegos.setBounds(10, 220, 97, 23);
		jpag.getContentPane().add(chckbxVideojuegos);

		chckbxLectura = new JCheckBox("Lectura");
		chckbxLectura.setBounds(113, 220, 97, 23);
		jpag.getContentPane().add(chckbxLectura);

		lblCursosLlevados = new JLabel("Cursos Llevados");
		lblCursosLlevados.setBounds(265, 11, 226, 14);
		jpag.getContentPane().add(lblCursosLlevados);

		nombresc = new JComboBox();
		nombresc.setBounds(265, 33, 170, 20);
		jpag.getContentPane().add(nombresc);
		nombresc.addItem("Nombre");
		cursosc = new JComboBox();
		cursosc.setBounds(265, 58, 319, 20);
		jpag.getContentPane().add(cursosc);
		cursosc.addItem("Curso");
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(265, 105, 89, 20);
		jpag.getContentPane().add(btnGuardar);
		
		cmbCatedratico = new JComboBox();
		cmbCatedratico.setBounds(265, 83, 319, 20);
		jpag.getContentPane().add(cmbCatedratico);

		chckbxTecnologia.addActionListener(new ManejadorEventos());
		chckbxMusica.addActionListener(new ManejadorEventos());
		chckbxArte.addActionListener(new ManejadorEventos());
		chckbxDeportes.addActionListener(new ManejadorEventos());
		chckbxOrganizacion.addActionListener(new ManejadorEventos());
		chckbxAnalitico.addActionListener(new ManejadorEventos());
		chckbxEstudioso.addActionListener(new ManejadorEventos());
		chckbxTrabajoIndividual.addActionListener(new ManejadorEventos());
		cursos.addActionListener(new ManejadorEventos());
		btnCrear.addActionListener(new ManejadorEventos());
		nombres.addActionListener(new ManejadorEventos());
		btnBuscar.addActionListener(new ManejadorEventos());
		chckbxVideojuegos.addActionListener(new ManejadorEventos());
		chckbxLectura.addActionListener(new ManejadorEventos());
		nombresc.addActionListener(new ManejadorEventos());
		cursosc.addActionListener(new ManejadorEventos());
		btnGuardar.addActionListener(new ManejadorEventos());
		cmbCatedratico.addActionListener(new ManejadorEventos());
		// btnV.addActionListener(new ManejadorEventos());
cmbCatedratico.addItem(" Catedratico ");
nombresc.addItem("nombre");
	}

	private class ManejadorEventos implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnCrear) {

				//
				con.insertar(txtNombre.getText(), txtNombre.getText());
				con.insertar(txtColegio.getText(), txtColegio.getText());
				nombress.add(txtNombre.getText());
				//
				if (e.getSource() == chckbxTecnologia) {
					con.relacionar(txtNombre.getText(), "tecnologia", "1");
				}
				if (e.getSource() == chckbxMusica) {
					con.relacionar(txtNombre.getText(), "musica", "1");

				}
				if (e.getSource() == chckbxArte) {
					con.relacionar(txtNombre.getText(), "arte", "1");

				}
				if (e.getSource() == chckbxDeportes) {
					con.relacionar(txtNombre.getText(), "deportes", "1");

				}
				if (e.getSource() == chckbxOrganizacion) {
					con.relacionar(txtNombre.getText(), "organizacion", "1");

				}
				if (e.getSource() == chckbxAnalitico) {
					con.relacionar(txtNombre.getText(), "analitico", "1");

				}
				if (e.getSource() == chckbxEstudioso) {
					con.relacionar(txtNombre.getText(), "estudioso", "1");

				}
				if (e.getSource() == chckbxTrabajoIndividual) {
					con.relacionar(txtNombre.getText(), "trabajoindividual",
							"1");

				}
			}

			if (e.getSource() == btnBuscar) {

			}
			
			if(e.getSource()==btnGuardar){
				con.insertar(cmbCatedratico.getSelectedItem().toString(), cmbCatedratico.getSelectedItem().toString());
				con.relacionar(nombresc.getSelectedItem().toString(),cmbCatedratico.getSelectedItem().toString(),"1");
			}

		}
	}
}
