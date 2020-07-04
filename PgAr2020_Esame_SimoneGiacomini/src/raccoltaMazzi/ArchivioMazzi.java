package raccoltaMazzi;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import gioco.Mazzo;

public class ArchivioMazzi {

	private static Set<Mazzo> mazzi= new TreeSet<>();
	
	private ArchivioMazzi() {}
	
	public static boolean aggiungiMazzo(Mazzo m) {
		return mazzi.add(m);
	}
	
}
