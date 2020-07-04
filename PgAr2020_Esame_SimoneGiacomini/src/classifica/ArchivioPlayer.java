package classifica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArchivioPlayer {

	private static Set<Player>players= new TreeSet<>();
	
	
	
	public boolean aggiungiPlayer(Player toAdd) {
	return	players.add(toAdd);
	}
	
	public boolean aggiungiPlayers(List<Player> toAdd) {
		return	players.addAll(toAdd);
		}
	public String mostraClassifica() {
		
		StringBuilder classifica= new StringBuilder();
		for (Iterator iterator = players.iterator(); iterator.hasNext();) {
			Player player = (Player) iterator.next();
			classifica.append(String.format(player.toString()+"%n"));
		}
		return classifica.toString();
	}
}
