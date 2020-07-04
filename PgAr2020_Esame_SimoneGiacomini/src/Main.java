import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import classifica.Player;
import gioco.Game;
import mazzo.Mazzo;
import raccoltaMazzi.ArchivioMazzi;
import util.mylib.InputDati;




public class Main {

	static final String[] file= {"nucleoBaseUnoGiOh","Uno_Gi_OhConPescaDue"};
	public static void main(String args[]) throws FileNotFoundException, XMLStreamException {
for (int i = 0; i < file.length; i++) {

		ArchivioMazzi.aggiungiMazzo( (new Mazzo(file[i],XMLManager.leggiCarte(String.format("./input/%s.xml", file[i])))));
}		
		
	Mazzo scelto= ArchivioMazzi.scegliUnMazzo();	
		Player pl1= new Player(InputDati.leggiStringaNonVuota("Inserire nome pl1 "));
		Player pl2 =new Player(InputDati.leggiStringaNonVuota("Inserire nome pl2 "));
		Game g= new Game(pl1,pl2,scelto);
		g.game();
	}
}
