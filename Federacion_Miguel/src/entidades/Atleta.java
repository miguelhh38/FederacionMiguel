package entidades;

import java.util.Scanner;

import utils.Datos;

public class Atleta extends Participante {
	private long idAtleta;
	private float altura;
	private float peso;

	private DatosPersona persona;

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso) {
		super(id, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso, DatosPersona dp) {
		super(idAtleta, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idAtleta, float altura, float peso, DatosPersona dp) {
		super();
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idParticipante, Atleta a, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idAtleta = a.idAtleta;
		this.altura = a.altura;
		this.peso = a.peso;
		this.persona = Datos.buscarPersonaPorId(a.idAtleta);
	}

	@Override
	public long getId() {
		return idAtleta;
	}

	@Override
	public void setId(long id) {
		this.idAtleta = id;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}

	public static Atleta nuevoAtleta() {
		Atleta ret = null;
		long id = -1;
		float altura = 0.0f;
		float peso = 0.0f;
		DatosPersona dp = null;
		Scanner in;
		boolean valido = false;

		do {
			System.out.println("Introduzca el id del nuevo atleta:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);
		valido = false;

		do {
			System.out.println("Introduzca la altura del nuevo atleta: ");
			in = new Scanner(System.in);
			altura = in.nextFloat();
			if (altura > 0.5f) {
				valido = true;
			} else {
				System.out.println("Altura mal introducida");
			}
		} while (!valido);

		do {
			System.out.println("Ingrese el peso del nuevo atleta: ");
			in = new Scanner(System.in);
			peso = in.nextFloat();
			if (peso > 0.5f) {
				valido = true;
			} else {
				System.out.println("Mal introducido el peso");
			}

		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();

		ret = new Atleta(id, altura, peso, dp);
		return ret;

	}

}
