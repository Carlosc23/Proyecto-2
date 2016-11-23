
import java.util.Set;
import java.util.TreeSet;

/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 3.0
 * Clase contenedora de datos estaticos.
 */ 
public class Contenedor {
	/*Atributos*/
	private static String usuario;
	private static int conta;
	private static TreeSet<Catedratico> arreglob,arreglom;
	
	/**
	 * @return El usuario respectivo.
	 */
	public static String getUsuario() {
		return usuario;
	}
	/**
	 * Cambia el usuario de la clase.
	 * @param usuario String con el nuevo usuario a contener.
	 */
	public static void setUsuario(String usuario) {
		Contenedor.usuario = usuario;
	}
	/**
	 * @return	El contador de valoraciones.
	 */
	public static int getConta() {
		return conta;
	}
	/**
	 * @param conta	Cambiar el contador actual de la clase.
	 */
	public static void setConta(int conta) {
		Contenedor.conta = conta;
	}
	
	/**
	 * @return Treeset con las valoraciones buenas.
	 */
	public static TreeSet<Catedratico> getArreglob() {
		return arreglob;
	}
	/**
	 * @param arrayp Set para cambiar catedraticos.
	 */
	public static void setArreglob(Set<Catedratico> arrayp) {
		Contenedor.arreglob = (TreeSet<Catedratico>) arrayp;
	}
	/**
	 * @return	Treeset de catedraticos buenos.
	 */
	public static TreeSet<Catedratico> getArreglom() {
		return arreglom;
	}
	/**
	 * @param arrayn	Set con catedraticos no tan buenos.
	 */
	public static void setArreglom(Set<Catedratico> arrayn) {
		Contenedor.arreglom = (TreeSet<Catedratico>) arrayn;
	}
	
	
}
