/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 2.0 
 * Clase para simular un catedratico
 */
public class Catedratico implements Comparable<Catedratico > {

	private String nombre;
	private int numeroValoraciones;
	public Catedratico(String nombre, int numeroValoraciones) {
		super();
		this.nombre = nombre;
		this.numeroValoraciones = numeroValoraciones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroValoraciones() {
		return numeroValoraciones;
	}
	public void setNumeroValoraciones(int numeroValoraciones) {
		this.numeroValoraciones = numeroValoraciones;
	}
	@Override
	public int compareTo(Catedratico o) {
		Integer retorno = null;
		return retorno = this.numeroValoraciones - o.numeroValoraciones;
	}
}
