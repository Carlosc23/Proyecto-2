import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *  @author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *  @version 1.4
 *  Clase para hacer procesos.
 */
public class Procesos {
	private Conexion con = new Conexion();
	private ObservableList<String> listaCarreras =  FXCollections.observableArrayList("Bioinformatica","BiotecnologiaIndustrial ",
			"CienciadelaAdministracion","CienciasdeAlimentos","CienciadelaComputacionyTI","Civil","CivilAmbiental","CivilArquitectonica",
			"CivilIndustrial","Electronica","Industrial","Mecanica","MecanicaIndustrial","Mecatronica","Quimica",
			"QuimicaIndustrial");
	private ObservableList<String> listaCarrerass =  FXCollections.observableArrayList("Bioinformatica ","Biotecnologia Industrial ",
			"Ciencia de la Administracion","Ciencias de Alimentos","Ciencia de la Computacion y TI","Civil","Civil Ambiental","Civil Arquitectonica",
			"Civil Industrial","Electronica","Industrial","Mecanica","Mecanica Industrial","Mecatronica","Quimica",
			"Quimica Industrial");
	private ObservableList<String> listaPerfiles =  FXCollections.observableArrayList("Pragmatico","Reflexivo",
			"Teorico","Activo");
	private ObservableList<String> listaPrefiere =  FXCollections.observableArrayList("Recibirteoria","Recibirejemplos");
	private ObservableList<String> listaPrefieres =  FXCollections.observableArrayList("Recibir teoria","Recibir ejemplos");
	private ObservableList<String> listaTarea =  FXCollections.observableArrayList("Megusta","Nomemolesta","Nomegustan");
	private ObservableList<String> listaTareas =  FXCollections.observableArrayList("Me gusta","No me molesta","No me gustan");
	public Procesos(){}
	
	public void llenar(){
		int conta=0;
		for (String i: listaCarreras){
			con.insertar("MERGE ("+i+":Carrera {name:'"+listaCarrerass.get(conta)+"'})");
			conta++;
		}
		for (String i: listaPerfiles){
			con.insertar("MERGE ("+i+":Perfil {name:'"+i+"'})");
		}
		conta=0;
		for (String i: listaPrefiere){
			con.insertar("MERGE ("+i+":Preferencia {name:'"+listaPrefieres.get(conta)+"'})");
			conta++;
		}
		conta=0;
		for (String i: listaTarea){
			con.insertar("MERGE ("+i+":Tarea {name:'"+listaTareas.get(conta)+"'})");
			conta++;
		}
		con.close();
		
	}
}
