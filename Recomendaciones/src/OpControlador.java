import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 2.0
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
		System.out.println("inicie");
	}
	@FXML
	private void irDesplegar() throws IOException{
		Main.showDesplegar();
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
	private void buscarPorColegio() throws SQLException, IOException{ 
		Conexion con = new Conexion();
		Catedratico c;
		Set<Catedratico> arrayp = new TreeSet<Catedratico>();
		Set<Catedratico> arrayn = new TreeSet<Catedratico>();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:ESTUDIO]->(m)<-[:ESTUDIO]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(c)-[re: OPINA{opinion:'Positivo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name, COUNT(c.name) as count";
		String s2="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:ESTUDIO]->(m)<-[:ESTUDIO]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(c)-[re: OPINA{opinion:'Negativo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name, COUNT(c.name) as count";
		ResultSet rs= con.getQuery(s);
		int n;
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayp.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		rs= con.getQuery(s2);
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayn.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		for (Catedratico c2: arrayp){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		for (Catedratico c2: arrayn){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		con.close();
		irDesplegar(); 
		
	}
	@FXML
	private void buscarPorCarrera() throws SQLException, IOException{
		Conexion con = new Conexion();
		Catedratico c;
		Set<Catedratico> arrayp = new TreeSet<Catedratico>();
		Set<Catedratico> arrayn = new TreeSet<Catedratico>();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:ESTUDIA]->(m)<-[:ESTUDIA]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(c)-[re: OPINA{opinion:'Positivo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name, COUNT(c.name) as count";
		String s2="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:ESTUDIA]->(m)<-[:ESTUDIA]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(c)-[re: OPINA{opinion:'Negativo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name, COUNT(c.name) as count";
		ResultSet rs= con.getQuery(s);
		int n;
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayp.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		rs= con.getQuery(s2);
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayn.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		for (Catedratico c2: arrayp){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		for (Catedratico c2: arrayn){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		con.close();
		 irDesplegar(); 
	}
	@FXML
	private void buscarPorPromedio() throws SQLException, IOException{
		Conexion con = new Conexion();
		Catedratico c;
		Set<Catedratico> arrayp = new TreeSet<Catedratico>();
		Set<Catedratico> arrayn = new TreeSet<Catedratico>();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:CON]->(m)<-[:CON]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(c)-[re: OPINA{opinion:'Positivo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name, COUNT(c.name) as count";
		String s2="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:CON]->(m)<-[:CON]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(c)-[re: OPINA{opinion:'Negativo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name, COUNT(c.name) as count";
		ResultSet rs= con.getQuery(s);
		int n;
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayp.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		rs= con.getQuery(s2);
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayn.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		for (Catedratico c2: arrayp){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		for (Catedratico c2: arrayn){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		con.close();
		 irDesplegar(); 
	}
	@FXML
	private void buscarPordatos() throws SQLException, IOException{
		Conexion con = new Conexion();
		Catedratico c;
		Set<Catedratico> arrayp = new TreeSet<Catedratico>();
		Set<Catedratico> arrayn = new TreeSet<Catedratico>();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:PREFIERE]->(m)<-[:PREFIERE]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(a)-[:TAREA]->(n)<-[:TAREA]-(c),\n"
				+"(a)-[:NIVELESTUDIO]->(t)<-[:NIVELESTUDIO]-(c),\n"
				+"(c)-[re: OPINA{opinion:'Positivo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name,COUNT(c.name) as count";
		String s2="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:PREFIERE]->(m)<-[:PREFIERE]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(a)-[:TAREA]->(n)<-[:TAREA]-(c),\n"
				+"(a)-[:NIVELESTUDIO]->(t)<-[:NIVELESTUDIO]-(c),\n"
				+"(c)-[re: OPINA{opinion:'Negativo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name,COUNT(c.name) as count";
		ResultSet rs= con.getQuery(s);
		int n=0;
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayp.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		rs= con.getQuery(s2);
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayn.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		for (Catedratico c2: arrayp){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		for (Catedratico c2: arrayn){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		con.close();
		irDesplegar(); 
		/*
		 * MATCH (a:User {user:'Carlosc23'})-[:PREFIERE]->(m)<-[:PREFIERE]-(c),
(a)-[:TAREA]->(t)<-[:TAREA]-(c),
(c)-[:RECIBIO{curso:'Fisica 1'}]->(m2),
(c)-[re: OPINA{opinion:'Positivo'}]->(m2)
WHERE NOT (a)-[:RECIBIO{curso:'Fisica 1'}]->(m2)
RETURN m2.name, COUNT(c.name) as count
		 * */	
	}
	@FXML
	private void buscarPorInteres() throws SQLException, IOException{
		Conexion con = new Conexion();
		Catedratico c;
		Set<Catedratico> arrayp = new TreeSet<Catedratico>();
		Set<Catedratico> arrayn = new TreeSet<Catedratico>();
		System.out.println(Contenedor.getUsuario());
		String s="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:GUSTADE]->(m)<-[:GUSTADE]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(c)-[re: OPINA{opinion:'Positivo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name, COUNT(c.name) as count";
		String s2="MATCH (a:User {user:'"+Contenedor.getUsuario()+"'})-[:GUSTADE]->(m)<-[:GUSTADE]-(c),\n"
				+ "(c)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2),\n "
				+"(c)-[re: OPINA{opinion:'Negativo'}]->(m2)"
				+ "WHERE NOT (a)-[:RECIBIO{curso:'"+this.cursocTxt.getText()+"'}]->(m2)\n "
				+ "RETURN m2.name, COUNT(c.name) as count";
		ResultSet rs= con.getQuery(s);
		int n;
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayp.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		rs= con.getQuery(s2);
		while(rs.next()){
			n= Integer.parseInt(rs.getString("count"));
			c = new Catedratico(rs.getString("m2.name"),n);
			arrayn.add(c);
			System.out.println(rs.getString("m2.name")+", "+rs.getString("count"));
		}
		for (Catedratico c2: arrayp){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		for (Catedratico c2: arrayn){
			System.out.println("ent"+c2.getNombre());
			System.out.println("ent"+c2.getNumeroValoraciones());
		}
		con.close();
		 irDesplegar(); 
	}
	
}
