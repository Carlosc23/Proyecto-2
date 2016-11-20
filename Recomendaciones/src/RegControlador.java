import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 1.1 
 * Clase para manejar los registros de usuario.
 */
public class RegControlador {
	private Main main;
	//Listas 
	private ObservableList<String> listaCarreras =  FXCollections.observableArrayList("Bioinformatica ","Biotecnología Industrial ",
			"Ciencia de la Administracion","Ciencias de Alimentos","Ciencia de la Computacion y TI","Civil","Civil Ambiental","Civil Arquitectonica",
			"Civil Industrial","Electronica","Industrial","Mecanica","Mecanica Industrial","Mecatronica","Quimica",
			"Quimica Industrial");
	private ObservableList<String> listaPerfiles =  FXCollections.observableArrayList("Pragmatico","Reflexivo",
			"Teorico","Activo");
	private ObservableList<String> listaPrefiere =  FXCollections.observableArrayList("Recibir teoria","Recibir ejemplos");
	private ObservableList<String> listaTarea =  FXCollections.observableArrayList("Me gusta","No me molesta","No me gustan");
	
	final int initialValue = 85;
	@FXML
	private TextField usuarioTxt;
	@FXML
	private TextField contraTxt;
	@FXML
	private TextField nombreTxt;
	@FXML
	private TextField coleTxt;
	@FXML
	private ComboBox carreras;
	@FXML
	private ComboBox perfiles;
	@FXML
	private ComboBox prefiere;
	@FXML
	private ComboBox tarea;
	@FXML
	private Spinner promedio = new Spinner();
	@FXML
	private Spinner nivel = new Spinner();
	@FXML
	private CheckBox lectura;
	@FXML
	private CheckBox videojuegos;
	@FXML
	private CheckBox arte;
	@FXML
	private CheckBox musica;
	@FXML
	private CheckBox peliculas;
	@FXML
	private CheckBox anime;
	@FXML
	private CheckBox fiestas; 
	@FXML
	private CheckBox deportes; 
	@FXML
	private CheckBox otros;
	@FXML
	private  void initialize(){
		//this.carreras.setValue("Carreras");
		this.carreras.setItems(listaCarreras);
		this.perfiles.setItems(listaPerfiles);
		this.prefiere.setItems(listaPrefiere);
		this.tarea.setItems(listaTarea);
		// Value factory.
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(65, 100, initialValue);
        this.promedio.setValueFactory(valueFactory);
       valueFactory = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        this.nivel.setValueFactory(valueFactory); 
	}
	@FXML
	private void regresarRegistro() throws IOException{
		main = new Main(); 
		main.showMainView();
	}
}
