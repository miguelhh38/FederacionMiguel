package entidades;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Equipo extends Participante {
	private long idEquipo;
	private int anioinscripcion;
	private Manager manager;
	private Atleta[] atletas;

	public Equipo(long id, int anioinscripcion, Manager manager, Atleta[] atletas) {
		super();
		this.idEquipo = id;
		this.anioinscripcion = anioinscripcion;
		this.manager = manager;
		this.atletas = atletas;
	}

	public Equipo(long idParticipante, Equipo e, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idEquipo = e.idEquipo;
		this.anioinscripcion = e.anioinscripcion;
		this.manager = e.manager;
		this.atletas = e.atletas;
	}

	@Override
	public long getId() {
		return idEquipo;
	}

	@Override
	public void setId(long id) {
		this.idEquipo = id;
	}

	public int getAnioinscripcion() {
		return anioinscripcion;
	}

	public void setAnioinscripcion(int anioinscripcion) {
		this.anioinscripcion = anioinscripcion;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Atleta[] getAtletas() {
		return atletas;
	}

	public void setAtletas(Atleta[] atletas) {
		this.atletas = atletas;
	}

	// Ejercicio 3
	@Override
	public String toString() {
		String ret = "";
		ret += "EQ" + idEquipo + ". de " + manager.getPersona().getNombre() + " (" + manager.getDireccion() + ") "
				+ atletas.length + " componentes en el equipo:\n";
		for (Atleta a : atletas) {
			ret += a.getId() + ". " + a.getPersona().getNombre() + "("
					+ a.getPersona().getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ") "
					+ " Datos físicos:\t" + a.getPeso() + "Kgs.\t" + a.getAltura() + "m.\n";
		}
		ret += "Valido durante el " + anioinscripcion;
		return ret;
	}

	/***
	 * Ejercicio 1 EXAMEN 8
	 * 
	 * @return
	 */
	public static Equipo nuevoEquipo() {
		Equipo ret = null;
		Scanner teclado;
		boolean valido = false;
		boolean datosValido = false;
		long idEquipo = 0;
		int anioins = 0;
		Manager m = null;
		Atleta[] nuevoAtletas;
		do {

			do {
				System.out.println("Ingrese el id del equipo: ");
				teclado = new Scanner(System.in);
				idEquipo = teclado.nextLong();
				if (idEquipo > 0)
					valido = true;
				else
					System.out.println("Valor incorrecto para el identificador");
			} while (!valido);

			valido = false;

			do {
				System.out.println("Introduce el año de inscripcion: ");
				anioins = teclado.nextInt();
				if (anioins > 1890 && anioins < 2022)
					valido = true;
				else
					System.out.println("Año de inscripción mal introducido");
			} while (!valido);

			System.out.println("Ahora introduca los datos del manager del nuevo equipo");
			m = Manager.nuevoManager();

			valido = false;
			int numero = 0;
			System.out.println("Para finalizar, introduce los datos de los atletas");
			do {
				System.out.println(
						"¿Cuantos atletas va a introducir? (Para crear un equipo se requieren al menos 3 equipos y un maximo de 5");
				numero = teclado.nextInt();
				if (numero >= 3 && numero <= 5)
					valido = true;
				else
					System.out.println(
							"ERROR. Se recuerda que el numero de los atletas de un equipo debe de ser de al menos 3 atletas y un maximo de 5");
			} while (!valido);

			System.out.println("Perfecto, introduce los datos de los " + numero + " atletas");
			nuevoAtletas = new Atleta[numero];
			for (int i = 0; i < numero; i++) {
				nuevoAtletas[i] = Atleta.nuevoAtleta();
			}

			String correcto = "";
			boolean valido2 = false;

			do {
				System.out.println("¿Han sido los datos introducidos correctamente? (s -> para si y n-> para no)");
				correcto = teclado.nextLine();

				if (correcto.equalsIgnoreCase("s")) {
					valido2 = true;
					datosValido = true;
				}
				if (correcto.equalsIgnoreCase("n")) {
					System.out.println("Datos mal introducidos. Ingrese los datos de nuevo.");
					valido2 = true;
				}
				System.out.println("ERROR. Ingrese s o n");

			} while (!valido2);
		} while (!datosValido);

		System.out.println("Nuevo equipo creado correctamente!");

		ret = new Equipo(idEquipo, anioins, m, nuevoAtletas);
		return ret;

	}
}
