package entidades;

import java.util.Collections;
import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

import utils.Datos;

public class ComparadorMedallas implements Comparator<Metal> {
	
	public int comparar(Metal o1, Metal o2) {
		return (int) (o1.maximaPurezaAlcanzada()-o2.maximaPurezaAlcanzada());
	}
	
	public static void mostrarmedalla() {
		LinkedList<Metal> list = new LinkedList<Metal> ();
		
		for (Oro o: Datos.OROS) {
			list.add(o);
		}
		for (Plata p: Datos.PLATAS) {
			list.add(p);
		}
		for (Bronce b: Datos.BRONCES) {
			list.add(b);
		}
		
		Collections.sort(list new ComparadorMedallas());
		Iterator<Metal> it = list.iterator();
		while(it.hasNext()) {
			System.out.println("Pureza: " + it.next());
		}
	}
}
