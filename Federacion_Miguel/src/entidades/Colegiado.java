package entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import utils.Datos;

public class Colegiado {
	private long id;
	private Categoria categoria; // Examen 3 Ejercicio 3
	private DatosPersona persona;

	public Colegiado(long id, Categoria categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Colegiado(long id, Categoria categoria, DatosPersona dp) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.persona = dp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getPersona() {
		return this.persona.toString();
	}
	
	public DatosPersona getDatosPersona() {
		return this.persona;
	}
	
	// Examen 3 Ejercicio 3
	public static Colegiado nuevoColegiado() {
		Colegiado ret = null;
		long id = -1;
		Categoria cat;
		int elecc = -1;
		DatosPersona dp = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo colegiado:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca la categoria del nuevo colegiado:");
			System.out.println("Seleccione el id de entre las siguientes categorias:");
			Categoria.mostrarTodos();
			in = new Scanner(System.in);
			elecc = in.nextInt();
			if (elecc >= 1 && elecc <= Categoria.values().length)
				valido = true;
		} while (!valido);
		cat = Categoria.values()[elecc - 1];

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();

		ret = new Colegiado(id, cat, dp);
		return ret;
	}

	// Metodo toString
	public String toString() {
		String ret = "";
		for (Colegiado c : Datos.COLEGIADOS) {
			ret += c.getId() + ". " + c.getDatosPersona().getNombre() + " (" + ") nacido el " + c.getDatosPersona().getFechaNac()
					+ ", tfno: " + c.getDatosPersona().getTelefono() + " CAT: " + getCategoria();

		}
		return ret;
	}

	//EJER.2 EXAM 7 Metodo para exportar datos del array COLEGIADOS a fichero binario.
	private static void exportarColegiados() {
		try {
			
			for (Colegiado c: Datos.COLEGIADOS) {
				if (c.getCategoria() == Categoria.JUNIOR) {
					File f = new File("colegiadosjunior.dat");
					FileOutputStream fos = new FileOutputStream(f);
					ObjectOutputStream oos = new ObjectOutputStream(fos);	
					
					oos.writeObject((Colegiado) c);
					oos.flush();
					oos.close();	
				}
				
				else if (c.getCategoria() == Categoria.SENIOR) {
					File f = new File("colegiadossenior.dat");
					FileOutputStream fos = new FileOutputStream(f);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					
					oos.writeObject((Colegiado) c);
					oos.flush();
					oos.close();
				}
				
				else if (c.getCategoria() == Categoria.ESPECIAL) {
					File f = new File("colegiadosespecial.dat");
					FileOutputStream fos = new FileOutputStream(f);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					
					oos.writeObject((Colegiado) c);
					oos.flush();
					oos.close();
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Excepcion FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Excepcion IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}
}
