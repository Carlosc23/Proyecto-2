import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 1.3 
 * Clase para manejar los registros acciones de login
 */
public class MainControlador {
	private Main main;
	private boolean ingresar;
	@FXML
	private TextField user;
	public TextField getUser() {
		return user;
	}
	public void setUser(TextField user) {
		this.user = user;
	}
	@FXML
	private TextField pass;
	@FXML
	private void irRegistro() throws IOException{
		Main.showRegistro();
	}
	@FXML
	private void ingreso() throws SQLException{
		System.out.println("hola");
		Conexion con = new Conexion();
		String query = "MATCH (n:User{user:'"+user.getText()+"',password:'"+pass.getText()+"'})\n" +
				"RETURN n.user,n.password";
		ResultSet rs= con.getQuery(query);
		if (!rs.next() ) {
		    System.out.println("no data");
		} 
		else{
			if(rs.getString("n.user").equals(user.getText()) && rs.getString("n.password").equals(pass.getText())){
				ingresar=true;
			}
		}
		if (ingresar){
			 
		}
		else{
			JOptionPane.showMessageDialog(null, "Usted no ha ingresado datos validos para ingresar",
					  "INGRESO INCORRECTO", JOptionPane.WARNING_MESSAGE);
		}
		con.close();
	}
	
}
