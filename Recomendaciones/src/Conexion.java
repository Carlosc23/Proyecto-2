import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 3.0
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
	/**
	 * Metodo para cerrar la conexion con neo4j. 
	 */
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para ejecutar un query general.
	 * @param req query a insertar.
	 */
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
			stmt.executeUpdate("MERGE ("+nodo+": User{user:'"+nodo+"',name:'"+ id+"',password:'"+contra+"'})");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Metodo para relacionar a 2 usuarios por colegio.
	 * @param user1 id del usuario 1
	 * @param user2 id del usuario 2
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
	/**
	 * Metodo para relacionar a 2 usuarios por carrera.
	 * @param user1 id del usuario 1
	 * @param user2 id del usuario 2
	 */
	public void relacionarCarrera(String user1, String user2){
		try {
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Carrera {name:'" + user2 + "'})" +
					"MERGE (n)-[:ESTUDIA]->(m)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para relacionar a 2 usuarios por promedio.
	 * @param user1 id del usuario 1
	 * @param user2 id del usuario 2
	 */
	public void relacionarPromedio(String user1, String user2){
		try {
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Promedio {name:'" + user2 + "'})" +
					"MERGE (n)-[:CON]->(m)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para relacionar a 2 usuarios por pasatiempo.
	 * @param user1 id del usuario 1
	 * @param user2 id del usuario 2
	 */
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
	
	/**
	 * Metodo para relacionar datos estudiantiles especificos.
	 * @param user1	id del usuario a relacionar.
	 * @param prefe	Cadena con preferencia para recibir clase.
	 * @param tare  Cadena con el gusto por tareas.
	 * @param nive  Cadena con el nivel de estudioso(a) que es el usuario.
	 */
	public void relacionarDatos(String user1, String prefe, String tare,String nive){
		try {
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Preferencia {name:'" + prefe + "'})" +
					"MERGE (n)-[:PREFIERE]->(m)");
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Tarea {name:'" + tare + "'})" +
					"MERGE (n)-[:TAREA]->(m)");
			stmt.executeUpdate("MATCH (n:User {user:'" + user1 + "'})" +
					"MATCH (m:Nivel {name:'" + nive + "'})" +
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
