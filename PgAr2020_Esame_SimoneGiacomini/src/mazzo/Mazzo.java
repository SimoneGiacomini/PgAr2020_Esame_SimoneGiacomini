package mazzo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Mazzo {
	
	private HashMap<String,Carta> carte;
	
	public Mazzo(Collection<Carta>carte) {

		for (Iterator iterator = carte.iterator(); iterator.hasNext();) {
			Carta carta = (Carta) iterator.next();
		
			this.carte.putIfAbsent(carta.getId(), carta);
		}
	}
	
	public String toString() {
		return carte.
	}

}
