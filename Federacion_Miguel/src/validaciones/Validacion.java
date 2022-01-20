package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validacion {
	public static boolean validarTelefono(String tfn) {
		return tfn.trim().chars().allMatch(Character::isDigit);
	}

	/**
	 * Valida que una cadena de caracteres contiene letras o espacios Ãºnicamente,
	 * longitud entre 3 y 50 caractreres
	 * 
	 * @param nombre cadena con el nombre a validar
	 * @return true si es un nombre vÃ¡lido o false en caso contrario
	 */
	public static boolean validarNombre(String nombre) {
		// regEx general para cadena de caracteres con longitud entre 1 y 50 caracteres,
		// aceptando dÃ­gitos, letras MAYUS y minÃºsculas, con tildes, dirÃ©resis y
		// diferentes sÃ­mbolos especiales
		// Pattern patron = Pattern.compile("[
		// 0-9A-Za-zÃ±Ã‘Ã¡Ã©Ã­Ã³ÃºÃ�Ã‰Ã�Ã“ÃšÃ¤Ã«Ã¯Ã¶Ã¼Ã„Ã‹Ã�Ã–ÃœÂ¡!Â¿?@#$%()=+-â‚¬/.,]{1,50}");
		Pattern patron = Pattern.compile("[ A-Za-zÃ±Ã‘Ã¡Ã©Ã­Ã³ÃºÃ�Ã‰Ã�Ã“ÃšÃ¤Ã«Ã¯Ã¶Ã¼Ã„Ã‹Ã�Ã–Ãœ-]{3,50}");
		Matcher comprobacion = patron.matcher(nombre);
		return comprobacion.matches();//
	}
	

}
