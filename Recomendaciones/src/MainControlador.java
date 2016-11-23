import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 3.0 
 * Clase para manejar los registros acciones de login.
 */
public class MainControlador {
	/*Atributos*/
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
	/**
	 * Mostrar la ventana registro.
	 * @throws IOException
	 */
	@FXML
	private void irRegistro() throws IOException{
		Main.showRegistro();
	}
	/**
	 * Mostrar la ventana de opiniones.
	 * @throws IOException
	 */
	@FXML
	private void irOp() throws IOException{
		Main.showOp();
	}
	/**
	 * Metodo para validar ingresos del usuario ya registrado.
	 * @throws SQLException
	 * @throws IOException
	 */
	@FXML
	private void ingreso() throws SQLException, IOException{
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
			 Contenedor.setUsuario(user.getText());
			 irOp();
		}
		else{
			JOptionPane.showMessageDialog(null, "Usted no ha ingresado datos validos para ingresar",
					  "INGRESO INCORRECTO", JOptionPane.WARNING_MESSAGE);
		}
		con.close();
	}
	
}
