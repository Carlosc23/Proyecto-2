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
		con.insertar("MERGE ("+this.cateTxt.getText().replaceAll("\\s+","")+":Catedratico {name:'"+this.cateTxt.getText()+"'})");
		con.insertar("MERGE ("+this.cursoTxt.getText().replaceAll("\\s+","")+":Curso {name:'"+this.cursoTxt.getText()+"'})");
		con.insertar("MATCH (n:User {user:'"+Contenedor.getUsuario()+"'})" +
				"MATCH (m:Catedratico {name:'"+this.cateTxt.getText()+"'})" +
				"MERGE (n)-[:RECIBIO{curso:'" + this.cursoTxt.getText() + "'}]->(m)");
		if(exp.isSelected()){
			con.insertar("MATCH (n:User {user:'"+Contenedor.getUsuario()+"'})" +
					"MATCH (m:Catedratico {name:'"+this.cateTxt.getText()+"'})" +
					"MERGE (n)-[:OPINA{opinion:'Positivo'}]->(m)");
		}
		else{
			con.insertar("MATCH (n:User {user:'"+Contenedor.getUsuario()+"'})" +
					"MATCH (m:Catedratico {name:'"+this.cateTxt.getText()+"'})" +
					"MERGE (n)-[:OPINA{opinion:'Negativo'}]->(m)");
		}
	}
	@FXML
	private void buscarPorColegio(){ 
	}
	@FXML
	private void buscarPorCarrera(){
		/*MATCH (a: Alumno {nombre:"Andrea"})-[:Estudia]->(m)<-[:Estudia]-(c),
	      (c)-[:Llevo{curso:'Calculo 1'}]->(m2)
	WHERE NOT (a)-[:Llevo{curso:'Calculo 1'}]->(m2)
	RETURN a,m,c*/
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
