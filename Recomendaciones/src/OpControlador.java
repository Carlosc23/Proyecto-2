import java.sql.ResultSet;
import java.sql.SQLException;

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
	private TextField cursocTxt;
	@FXML
	private RadioButton exp;
	@FXML
	private  void initialize(){
	}
	@FXML
	private void enviar(){
		Conexion con = new Conexion();
		con.insertar("MERGE ("+this.cateTxt.getText().replaceAll("\\s+","")+":Catedratico {name:'"+this.cateTxt.getText()+"'})");
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
		con.close();
	}
	@FXML
	private void buscarPorColegio() throws SQLException{ 
		Conexion con = new Conexion();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:ESTUDIO]->(m)<-[:ESTUDIO]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name,c.name";
		ResultSet rs= con.getQuery(s);
		while(rs.next()){
			System.out.println(rs.getString("m2.name")+", "+rs.getString("c.name"));
		}
	}
	@FXML
	private void buscarPorCarrera() throws SQLException{
		Conexion con = new Conexion();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:ESTUDIA]->(m)<-[:ESTUDIA]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name,c.name";
		ResultSet rs= con.getQuery(s);
		while(rs.next()){
			System.out.println(rs.getString("m2.name")+", "+rs.getString("c.name"));
		}
		con.close();
	}
	@FXML
	private void buscarPorPromedio() throws SQLException{
		Conexion con = new Conexion();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:CON]->(m)<-[:CON]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name,c.name";
		ResultSet rs= con.getQuery(s);
		int contador=0;
		while(rs.next()){
			contador ++;
			System.out.println(rs.getString("m2.name")+", "+rs.getString("c.name")+"cc");
		}
		System.out.println(""+contador);
		con.close();
	}
	@FXML
	private void buscarPordatos() throws SQLException{
		
		Conexion con = new Conexion();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:PREFIERE]->(m)<-[:PREFIERE]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name,c.name";
		ResultSet rs= con.getQuery(s);
		int contador=0;
		while(rs.next()){
			contador ++;
			System.out.println(rs.getString("m2.name")+", "+rs.getString("c.name")+"cc");
		}
		System.out.println(""+contador);
		con.close();
		
	}
	@FXML
	private void buscarPorInteres() throws SQLException{
		Conexion con = new Conexion();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:GUSTADE]->(m)<-[:GUSTADE]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name,c.name";
		ResultSet rs= con.getQuery(s);
		while(rs.next()){
			System.out.println(rs.getString("m2.name")+", "+rs.getString("c.name")+"cc");
		}
		
		con.close();
	}
	
}
