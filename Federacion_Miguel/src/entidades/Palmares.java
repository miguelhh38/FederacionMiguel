package entidades;

import java.time.format.DateTimeFormatter;

// EJER.4 EXAM 7. Clase palmares de tipo genérico.
public class Palmares <T extends Metal, S extends Participante> {

	// Campos de la clase Palmares
	private long id;
	private T medalla;
	private S participante;
	private Prueba prueba;
	private String obsevaciones;

	// Constructor por defecto
	public Palmares() {

	}

	// Constructor que recibe todos los atributos de la clase
	public Palmares(long id, T medalla, S participante, Prueba prueba, String observaciones) {
		this.id = id;
		this.medalla = medalla;
		this.participante = participante;
		this.prueba = prueba;
		this.obsevaciones = observaciones;
	}

	// Getters y Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public T getMedalla() {
		return medalla;
	}

	public void setMedalla(T medalla) {
		this.medalla = medalla;
	}

	public S getParticipante() {
		return participante;
	}

	public void setParticipante(S participante) {
		this.participante = participante;
	}

	public Prueba getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

	public String getObsevaciones() {
		return obsevaciones;
	}

	public void setObsevaciones(String obsevaciones) {
		this.obsevaciones = obsevaciones;
	}

	// Metodo para mostrar datos
	public String mostrarDatosPalmares() {
		String ret = "";
		ret = "Palmares: Id= " + id + " Medalla= " + medalla.toString() + " Prueba= " + prueba.getNombre() + " Fecha= "
				+ prueba.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Lugar= " + prueba.getLugar()
				+ " Dorsal= " + participante.getDorsal() + " Calle= " + participante.getCalle();
		
		if (participante.getClass().getName() == //tipoEQUIPO) {
			ret += "Equipo=" + ;
		}
	
		if(participante.getClass().getName() == //tipoATLETA) {
			ret += "Equipo=" + ;
		}
		
		
		
		return ret;
	}


}
