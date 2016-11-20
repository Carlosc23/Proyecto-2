import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 1.3
 * Clase para hacer manejos con neo4j.
 */
public class Conexion {
	/*Atributos*/
	private Connection con;
	private Statement stmt;
	private final String USER="neo4j";
	private final String PASSWORD= "4jneo";
	static final String  _URL = "jdbc:neo4j:bolt://localhost";
	/**
	 * Metodo constructor
	 */
	public Conexion(){
		try{
			con = DriverManager.getConnection(_URL, USER,PASSWORD);	
			stmt = con.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @param _query el query para consultar.
	 * @return la coleccion
	 * Metodo para consultar en la db.
	 */
	public ResultSet getQuery(String _query){
		Statement state = null;
		ResultSet resultado = null;
		try{
			state = (Statement) con.createStatement();
			resultado = state.executeQuery(_query);
		}
		catch(SQLException e){
			System.out.println("naaaa");
			e.printStackTrace();

		}
		return resultado;
	}
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertar(String req){
		try {
			stmt.executeUpdate(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param nodo Nombre del nodo.
	 * @param id   Nombre del usuario.
	 * Metodo para insertar un nodo en la db.
	 */
	public void insertarUsuario(String nodo,String id,String contra){
		try {
			stmt.executeUpdate("CREATE ("+nodo+": User{user:'"+nodo+"',name:'"+ id+"',password:'"+contra+"'})");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param name1	Nombre del nodo origen
	 * @param name2 Nombre del nodo destino
	 * @param peso	Cantidad de correos representada con length.
	 * Metodo para hacer las relaciones entre nodos.
	 */
	public void relacionarColegio(String user1, String user2){
		try {
			stmt.executeUpdate("MERGE ("+user2+":Colegio {name:'"+user2+"'})");
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Colegio {name:'" + user2 + "'})" +
					"MERGE (n)-[:ESTUDIO]->(m)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void relacionarCarrera(String user1, String user2){
		try {
			
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Carrera {name:'" + user2 + "'})" +
					"MERGE (n)-[:ESTUDIA]->(m)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void relacionarPasatiempo(String user1, String user2){
		try {
			stmt.executeUpdate("MERGE ("+user2+":Pasatiempo {name:'"+user2+"'})");
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Pasatiempo {name:'" + user2 + "'})" +
					"MERGE (n)-[:GUSTADE]->(m)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	public void relacionarDatos(String user1, String prefe, String tare,int nive){
		try {
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Preferencia {name:'" + prefe + "'})" +
					"MERGE (n)-[:PREFIERE]->(m)");
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Tarea {name:'" + tare + "'})" +
					"MERGE (n)-[:TAREA]->(m)");
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Nivel {name:" + nive + "})" +
					"MERGE (n)-[:NIVELESTUDIO]->(m)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para limpiar la base de datos.
	 */
	public void eliminar(){
		try {
			stmt.executeUpdate("MATCH (n) " +
					"OPTIONAL MATCH (n)-[r]-()"+" delete n,r" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
