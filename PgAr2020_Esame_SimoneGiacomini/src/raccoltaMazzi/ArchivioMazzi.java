package raccoltaMazzi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import mazzo.Mazzo;
import util.mylib.MyMenu;

public class ArchivioMazzi {

	
	private static Map<String,Mazzo> mazzi= new TreeMap();
	
		
	
	private ArchivioMazzi() {}
	
	/**aggiunge un mazzo all archivio*/
	public static boolean aggiungiMazzo(Mazzo m) {
	return  mazzi.putIfAbsent(m.getNome(),m)!= null;
	}
	/**@return un mazzo cercato per nome*/
	public static Mazzo getMazzo(String nomeMazzo) {
		return mazzi.get(nomeMazzo);
	}
	/**@return una string dove spiega i mazzi contenuti nell' archivio*/
	public static String toStringa() {
		MyMenu<Object> menu= new MyMenu<>("Mazzi disponibili", mazzi.keySet().toArray());
		return menu.toString();
	}
	/**metodo per interfacciarsi con l'utente, fa scegliere uno dei mazzi disponibili*/
	public static Mazzo scegliUnMazzo() {
		MyMenu<Object> menu= new MyMenu<>("Mazzi disponibili", mazzi.keySet().toArray());
		return mazzi.get((String)menu.scegliSenzaEsciEritornaOpzione());
	}
}
