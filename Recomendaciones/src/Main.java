 
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 1.3 
 * Clase encargada de dar interfaz.   
 */  
public class Main extends Application {
	/*Atributos*/
	private static Stage primaryStage;
	//private static Stage  primary2Stage;
	private VBox mainLayout;
	private Procesos p = new Procesos();
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("RECUVG");
		p.llenar();
		showMainView();
	}
	public void showMainView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("LoginView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show(); 
	}
	public static void showRegistro() throws IOException{  
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("RegView.fxml")); 
		BorderPane regPane = loader.load(); 
		Scene scene2 = new Scene(regPane);
		primaryStage.setScene(scene2);
		primaryStage.show();  
	}
	public static void showOp() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("OpView.fxml")); 
		BorderPane regPane = loader.load();
		Scene scene2 = new Scene(regPane);
		primaryStage.setScene(scene2);
		primaryStage.show(); 
	}

	public static void main(String[] args) {
		launch(args);
	}
}
