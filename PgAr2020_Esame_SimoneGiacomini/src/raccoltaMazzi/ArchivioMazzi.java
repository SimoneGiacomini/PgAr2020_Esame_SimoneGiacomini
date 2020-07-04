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
	
	private static MyMenu<Object> menu= new MyMenu<>("Mazzi disponibili", mazzi.keySet().toArray());
			
	
	private ArchivioMazzi() {}
	
	public static boolean aggiungiMazzo(Mazzo m) {
	return  mazzi.putIfAbsent(m.getNome(),m)!= null;
	}
	
	public static Mazzo getMazzo(String nomeMazzo) {
		return mazzi.get(nomeMazzo);
	}
	
	public String toString() {
		return menu.toString();
	}
	
	public static Mazzo scegliUnMazzo() {
		return mazzi.get((String)menu.scegliSenzaEsciEritornaOpzione());
	}
}
