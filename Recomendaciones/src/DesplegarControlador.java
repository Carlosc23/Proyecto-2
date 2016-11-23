
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public final class DesplegarControlador {
	@FXML
	private TextArea area;
	@FXML
	private void initialize(){
		System.out.println("mmm");
		System.out.println("mm"+desplegar());
		this.area.setText(desplegar());
	}
	@FXML
	private String desplegar(){
		String s="En base a lo parametros que usted indico, estos catedraticos son los que le recomendamos:\n";
		for (Catedratico c: Contenedor.getArreglob()){
			s+=c.getNombre()+"\n";
			
		}
		System.out.println("nn"+s);
		for (Catedratico c: Contenedor.getArreglom()){
			s+=c.getNombre()+"\n";
		}
		System.out.println("m"+s);
		return s;
	}
	
}
