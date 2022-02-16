package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.Datos;

public class Manager {
	private long id;
	private String telefono;
	private String direccion;

	private DatosPersona persona;

	public Manager(long id, String telefono, String direccion) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Manager(long id, String telefono, String direccion, DatosPersona dp) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = dp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}

	public static Manager nuevoManager() {
		Manager ret = null;
		long id = -1;
		String telefono = "";
		String direccion = "";
		DatosPersona dp = null;
		Scanner in;
		boolean valido = false;

		do {
			System.out.println("Introduzca el id del nuevo manager:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);
		valido = false;

		do {
			System.out.println("Introduzca el telefono del nuevo manager: ");
			in = new Scanner(System.in);
			telefono = in.nextLine();
			char caracterinicial = telefono.charAt(0);
			int enteroinicial = Character.getNumericValue(caracterinicial);
			if (telefono.length() == 8
					&& (enteroinicial == 9 || enteroinicial == 8 || enteroinicial == 6 || enteroinicial == 7)) {
				valido = true;
			} else {
				System.out.println("Telefono mal introducido");
			}
		} while (!valido);

		do {
			System.out.println("Ingrese la direccion del nuevo manager: ");
			in = new Scanner(System.in);
			direccion = in.nextLine();
			if (direccion.length() > 5) {
				valido = true;
			} else {
				System.out.println("Mal introducida la direccion");
			}

		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();

		ret = new Manager(id, telefono, direccion, dp);
		return ret;

	}

	@Override
	public String toString() {
		String ret = "";
		for (Manager m : Datos.MANAGERS) {
			ret += m.getId() + " " + m.getPersona().getNombre() + " (" + ")  del año" + m.getPersona().getFechaNac
					+ ", tfno1: " + m.getPersona().getTelefono() + " tfno1:" + m.getPersona().getTelefono();

		}
		return ret;
	}

	// EXAM 6 Ejer 3  

	public String data() {
		return "" + persona.getId() + "|" + persona.getNombre() + "|" + persona.getNifnie().mostrar() + "|"
				+ persona.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "|" + persona.getTelefono()
				+ "|" + this.id + "|" + this.telefono + "|" + this.direccion;
	}

	// EJER.3 EXAM 7
	public static String DataManagerEquipo() {
		String ret = "";
		File fichero = new File("manager.txt");
		FileReader lector = null;
		BufferedReader buffer = null;
		try {
			try {
				lector = new FileReader(fichero);
				buffer = new BufferedReader(lector);
				String linea;
				while ((linea = buffer.readLine()) != null) {
					String[] datos = linea.split("\\|");
					String idPersona = datos[0];
					String nombreManager = datos[1];
					String documentacionManager = datos[2];
					String fechaNacManager = datos[3];
					String telefonoPersona = datos[4];
					String idManager = datos[5];
					String telefonoManager = datos[6];
					String direccionManager = datos[7];

					for (Equipo equi : Datos.EQUIPOS) {
						if (Long.valueOf(idManager) == equi.getManager().getId()) {
							equi.getAtletas();
							ret = ("D./Dña. " + nombreManager + " con NIF:NIE " + documentacionManager + " nacido el "
									+ fechaNacManager + " representa al equipo " + equi.get() + " de id" + equi.getId()
									+ " durante el año " + equi.getAnioinscripcion()
									+ ", el cual está formado por los siguientes atletas: \t"
									+ equi.getAtletas().toString() + "\n");
						}
					}
				}
			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (lector != null) {
					lector.close();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}

		return ret;
	}

}
