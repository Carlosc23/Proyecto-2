/**
 *@author Carlos Calderon , Marisol Barillas , Jorge Azmitia
 *@version 3.0 
 * Clase para simular un catedratico.
 */
public class Catedratico implements Comparable<Catedratico > {
	/*Atributos*/
	private String nombre;
	private int numeroValoraciones;
	/**
	 * @param nombre	nombre del catedratico
	 * @param numeroValoraciones	numero de Valoraciones positivas o o negativas
	 */
	public Catedratico(String nombre, int numeroValoraciones) {
		super();
		this.nombre = nombre;
		this.numeroValoraciones = numeroValoraciones;
	}
	/**
	 * @return	nombre del catedratico
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre	cadena con el nombre a cambiar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return	el numero de valoraciones del catedratico.
	 */
	public int getNumeroValoraciones() {
		return numeroValoraciones;
	}
	/**
	 * @param numeroValoraciones numero de valoraciones a cambiar
	 */
	public void setNumeroValoraciones(int numeroValoraciones) {
		this.numeroValoraciones = numeroValoraciones;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Catedratico o) {
		return  this.numeroValoraciones - o.numeroValoraciones;
	}
}
