
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 3.0
 * Clase encargada  de desplegar los catedraticos recomendados.
 */  
public final class DesplegarControlador {
	/*Atributos*/
	@FXML
	private TextArea area;
	/**
	 * Metodo para inicializar componentes.
	 */
	@FXML
	private void initialize(){
		String s="En base a lo parametros que usted indico,\n estos catedraticos son los que le recomendamos:\n";
		s+="Recomendados:\n";
		for (Catedratico c: Contenedor.getArreglob()){
			s+=c.getNombre()+"\n";
			
		}
		s+="No tan Recomendados:\n";
		for (Catedratico c: Contenedor.getArreglom()){
			s+=c.getNombre()+"\n";
		}
		System.out.println("m"+s);
		this.area.setText(s);
	}
}
