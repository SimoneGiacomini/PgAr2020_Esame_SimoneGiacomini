package gioco;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mazzo.Carta;

public class Mazzo {
		
		private Deque<Carta> carte= new ArrayDeque<>();
		
		public Mazzo(List<Carta> carte) {

			this.carte.addAll(carte);
		}
		
		public String toString() {
			return carte.toString();
		}
		
		public void mischia() {
			List<Carta> carte= new ArrayList<>();
			for (Iterator iterator = this.carte.iterator(); iterator.hasNext();) {
				Carta carta = (Carta) iterator.next();
				carte.add(carta);
			}
			
			Collections.shuffle(carte);
			
			this.carte.clear();
			
			this.carte.addAll(carte);
		}		
		
		public Carta pesca() {
	
		return this.carte.getFirst();
			
		}
}
