package mazzo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**classe che identifica un mazzo*/
public class Mazzo implements Comparable<Mazzo> {
/**attributo che simula il mazzo vero e proprio*/
	private ArrayDeque<Carta> carte = new ArrayDeque<>();
/**attributo che identifica il nome del mazzo*/
	private String nome;
/**costruttore del mazzo*/
	public Mazzo(String nome, List<Carta> carte) {
		this.nome = nome;
		this.carte.clear();
		this.carte.addAll(carte);
	}
/**Costruisce un mazzo con una sola carta iniziale*/
	public Mazzo(String nome,Carta iniziale) {
		this.nome = nome;
		this.carte.clear();
		carte.addFirst(iniziale);
	}

/**@return una String tipo {carta.toString, carta2.toString... }*/
	public String toString() {
		return carte.toString();
	}

	/**@return true se riesce ad inserire in cima la carta passata*/
	public boolean inserisciInCima(Carta c) {
		return carte.offerFirst(c);
	}
/**@return la carta in cima a questo mazzo
 * */
	public Carta getCartaInCima() {
		return carte.getFirst();
	}
/**@return una lista di carte prese da questo mazzo e mischiate, e salvate nell'attributo*/
	public List<Carta> mischia() {
		List<Carta> carte = new ArrayList<>();
		for (Iterator iterator = this.carte.iterator(); iterator.hasNext();) {
			Carta carta = (Carta) iterator.next();
			carte.add(carta);
		}

		Collections.shuffle(carte);

		this.carte.clear();

		this.carte.addAll(carte);
		return carte;
	}
/**@return una carta presa dalla cima di questo mazzo*/
	public Carta pesca() {

		return this.carte.pop();

	}
/**@return una lista di Carte ordinate, vengono salvate  anche nell'attributo*/
	public List<Carta> ordinaCarte() {
		List<Carta> carte = new ArrayList<>();
		for (Iterator iterator = this.carte.iterator(); iterator.hasNext();) {
			Carta carta = (Carta) iterator.next();
			carte.add(carta);
		}

		Collections.sort(carte);

		this.carte.clear();

		this.carte.addAll(carte);
		return carte;

	}
/**@return una lista di carte di questo mazzo*/
	public List<Carta> daiMazzo() {
		List<Carta> carte = new ArrayList<>();
		for (Iterator iterator = this.carte.iterator(); iterator.hasNext();) {
			Carta carta = (Carta) iterator.next();
			carte.add(carta);
		}
		return carte;
	}
/**@return true se il mazzo e' vuoto*/
	public boolean vuoto() {
		return carte.isEmpty();
	}
/**@return la quantita' di carte presenti nel mazzo*/
	public int quanteCartePresenti() {
		return carte.size();
	}
/**@return true se i due mazzi sono uguali*/
	public boolean equals(Object o) {

		if (o instanceof Mazzo) {
			Mazzo m = (Mazzo) o;
			return carte.containsAll(m.daiMazzo()) && carte.size() == m.quanteCartePresenti();
		}
		return false;
	}
/***/
	public int hashCode() {
		int hash = 0;
		for (Iterator iterator = this.ordinaCarte().iterator(); iterator.hasNext();) {
			Carta carta = (Carta) iterator.next();
			hash += carta.getId();
		}
		return hash;
	}
/**@return il nome del mazzo*/
	public String getNome() {
		return nome;
	}
	@Override
	public int compareTo(Mazzo o) {
		return o.hashCode() - hashCode();
	}
}
