import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 1.2 
 * Clase para manejar los registros acciones de login
 */
public class MainControlador {
	private Main main;
	
	@FXML
	private void irRegistro() throws IOException{
		Main.showRegistro();
	}
	
	
}
