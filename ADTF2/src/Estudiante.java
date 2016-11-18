import java.util.ArrayList;

public class Estudiante {
	String nombre;
	String Carrera;
	String Colegio;
	ArrayList intereses_cualidades;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}

	public String getColegio() {
		return Colegio;
	}

	public void setColegio(String colegio) {
		Colegio = colegio;
	}

	public ArrayList getIntereses_cualidades() {
		return intereses_cualidades;
	}

	public void setIntereses_cualidades(ArrayList intereses_cualidades) {
		this.intereses_cualidades = intereses_cualidades;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", Carrera=" + Carrera
				+ ", Colegio=" + Colegio + ", intereses_cualidades="
				+ intereses_cualidades + "]";
	}

	public Estudiante(String nombre, String carrera, String colegio,
			ArrayList intereses_cualidades) {
		super();
		this.nombre = nombre;
		Carrera = carrera;
		Colegio = colegio;
		this.intereses_cualidades = intereses_cualidades;
	}

}
