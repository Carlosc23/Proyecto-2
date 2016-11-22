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
 *@version 1.4
 * Clase para manejar los registros de usuario.
 */
public class RegControlador {
	private Main main;
	//Listas 
	private ObservableList<String> listaCarreras =  FXCollections.observableArrayList("Bioinformatica ","Biotecnologia Industrial ",
			"Ciencia de la Administracion","Ciencias de Alimentos","Ciencia de la Computacion y TI","Civil","Civil Ambiental","Civil Arquitectonica",
			"Civil Industrial","Electronica","Industrial","Mecanica","Mecanica Industrial","Mecatronica","Quimica",
			"Quimica Industrial");
	private ObservableList<String> listaPerfiles =  FXCollections.observableArrayList("Pragmatico","Reflexivo",
			"Teorico","Activo");
	private ObservableList<String> listaPrefiere =  FXCollections.observableArrayList("Recibir teoria","Recibir ejemplos");
	private ObservableList<String> listaTarea =  FXCollections.observableArrayList("Me gusta","No me molesta","No me gustan");
	
	final int initialValue = 85;
	//Textfields
	@FXML
	private TextField usuarioTxt;
	@FXML
	private TextField contraTxt;
	@FXML
	private TextField nombreTxt;
	@FXML
	private TextField coleTxt;
	//ComboBox
	@FXML
	private ComboBox<String> carreras;
	@FXML
	private ComboBox<String> perfiles;
	@FXML
	private ComboBox<String> prefiere;
	@FXML
	private ComboBox<String> tarea;
	//SpinnerBox
	@FXML
	private Spinner<Integer> promedio = new Spinner<Integer>();
	@FXML
	private Spinner<Integer> nivel = new Spinner<Integer>();
	//CheckBox
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
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, 1);
        this.nivel.setValueFactory(valueFactory); 
	}
	@FXML
	private void regresarRegistro() throws IOException{
		main = new Main(); 
		main.showMainView();
	}
	@FXML
	private void insertarDatos(){
		Conexion con = new Conexion();
		con.insertarUsuario(usuarioTxt.getText(), nombreTxt.getText(), contraTxt.getText());
		con.relacionarCarrera(usuarioTxt.getText(),this.carreras.getValue());
		con.relacionarColegio(this.usuarioTxt.getText(), this.coleTxt.getText());
		System.out.println(this.prefiere.getValue());
		System.out.println( this.nivel.getValue());
		if(this.nivel.getValue()==1){
			con.relacionarDatos(usuarioTxt.getText(), this.prefiere.getValue(), this.tarea.getValue(), "Nada");
			
		}
		else if(this.nivel.getValue()==2){
			con.relacionarDatos(usuarioTxt.getText(), this.prefiere.getValue(), this.tarea.getValue(), "Poco");
			
		}
		else if(this.nivel.getValue()==3){
			con.relacionarDatos(usuarioTxt.getText(), this.prefiere.getValue(), this.tarea.getValue(), "Promedio");
			
		}
		else if(this.nivel.getValue()==4){
			con.relacionarDatos(usuarioTxt.getText(), this.prefiere.getValue(), this.tarea.getValue(), "Estudioso");
			
		}
		if(lectura.isSelected()){
			System.out.println("entre");
			con.relacionarPasatiempo(usuarioTxt.getText(), "Lectura");
		}
		if(videojuegos.isSelected()){
			con.relacionarPasatiempo(usuarioTxt.getText(), "Videojuegos");
		}
		if(arte.isSelected()){
			con.relacionarPasatiempo(usuarioTxt.getText(), "Arte");
		}
		if(musica.isSelected()){
			con.relacionarPasatiempo(usuarioTxt.getText(), "Musica");
		}
		if(peliculas.isSelected()){
			con.relacionarPasatiempo(usuarioTxt.getText(), "Peliculas");
		}
		if(anime.isSelected()){
			con.relacionarPasatiempo(usuarioTxt.getText(), "Anime");
		}
		if(fiestas.isSelected()){
			con.relacionarPasatiempo(usuarioTxt.getText(), "Fiestas");
		}
		if(deportes.isSelected()){
			con.relacionarPasatiempo(usuarioTxt.getText(), "Deportes");
		}
		if(otros.isSelected()){
			con.relacionarPasatiempo(usuarioTxt.getText(), "Otros");
		}
		if(this.promedio.getValue()>=90){
			con.relacionarPromedio(this.usuarioTxt.getText(), "Honor");
		}
		else if(this.promedio.getValue()>=85 && this.promedio.getValue()<90){
			con.relacionarPromedio(this.usuarioTxt.getText(), "Distinguido");
		}
		else if(this.promedio.getValue()>=80 && this.promedio.getValue()<85){
			con.relacionarPromedio(this.usuarioTxt.getText(), "Mencion");
		}
		else if(this.promedio.getValue()>=70 && this.promedio.getValue()<80){
			
			con.relacionarPromedio(this.usuarioTxt.getText(), "Promedio");
		}
		else if(this.promedio.getValue()>=65 && this.promedio.getValue()<70){
			con.relacionarPromedio(this.usuarioTxt.getText(), "Bajo");
		}
		con.close();
	}
}
 