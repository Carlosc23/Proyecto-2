import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class DesplegarControlador {
	@FXML
	private TextArea area;
	@FXML
	private  void initialize(){
		this.area.setText(desplegar());
	}
	private String desplegar(){
		String s="En base a lo parametros que usted indico, estos catedraticos son los que le recomendamos:\n";
		for (Catedratico c: Contenedor.getArreglob()){
			s+=c.getNombre()+"\n";
		}
		for (Catedratico c: Contenedor.getArreglom()){
			s+=c.getNombre()+"\n";
		}
		return s;
		
	}
}
