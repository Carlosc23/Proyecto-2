import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 1.4
 * Clase para manejar los registros de usuario.
 */
public final class OpControlador {
	@FXML
	private TextField cursoTxt;
	@FXML
	private TextField cateTxt;
	@FXML
	private RadioButton exp;
	@FXML
	private  void initialize(){
	}
	@FXML
	private void enviar(){
		Conexion con = new Conexion();
		con.insertar("MERGE ("+this.cateTxt.getText()+":Perfil {name:'"+this.cateTxt.getText()+"'})");
		con.insertar("MERGE ("+this.cursoTxt.getText()+":Perfil {name:'"+this.cursoTxt.getText()+"'})");
		if(exp.isSelected()){
			con.insertar("MERGE (Positiva:Opinion {name:'Positiva'})");
			con.insertar("MATCH (n:User {user:'"+Contenedor.getUsuario()+"'})" +
					"MATCH (m:Opinion {name:'Positiva'})" +
					"MERGE (n)-[:Opina]->(m)");
		}
		else{
			con.insertar("MERGE (Negativa:Opinion {name:'Negativa'})");
			con.insertar("MATCH (n:User {user:'"+Contenedor.getUsuario()+"'})" +
					"MATCH (m:Opinion {name:'Negativa'})" +
					"MERGE (n)-[:Opina]->(m)");
		}
	}
	@FXML
	private void buscarPorColegio(){
	}
	@FXML
	private void buscarPorCarrera(){
		
	}
	@FXML
	private void buscarPorPromedio(){
		
	}
	@FXML
	private void buscarPordatos(){
		
	}
	@FXML
	private void buscarPorInteres(){
		
	}
	
}
