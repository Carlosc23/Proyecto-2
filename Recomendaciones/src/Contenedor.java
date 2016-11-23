import java.util.ArrayList;
import java.util.TreeSet;

/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 2.0
 * Clase contenedora.
 */ 
public class Contenedor {
	private static String usuario;
	private static int conta;
	private static TreeSet<Catedratico> arreglob,arreglom;
	public static String getUsuario() {
		return usuario;
	}
	public static void setUsuario(String usuario) {
		Contenedor.usuario = usuario;
	}
	public static int getConta() {
		return conta;
	}
	public static void setConta(int conta) {
		Contenedor.conta = conta;
	}
	public static TreeSet<Catedratico> getArreglob() {
		return arreglob;
	}
	public static void setArreglob(TreeSet<Catedratico> arreglob) {
		Contenedor.arreglob = arreglob;
	}
	public static TreeSet<Catedratico> getArreglom() {
		return arreglom;
	}
	public static void setArreglom(TreeSet<Catedratico> arreglom) {
		Contenedor.arreglom = arreglom;
	}
	
	
}
