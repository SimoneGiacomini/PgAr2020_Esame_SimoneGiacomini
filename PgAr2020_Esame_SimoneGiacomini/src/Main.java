import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import classifica.Player;
import gioco.Game;
import mazzo.Mazzo;




public class Main {

	public static void main(String args[]) throws FileNotFoundException, XMLStreamException {

		Mazzo mazzo= (new Mazzo("UNI",XMLManager.readCities("./input/Uno_Gi_OhConPescaDue.xml")));
		
		
		System.out.println(mazzo);
		mazzo.mischia();
		System.out.println(mazzo);
		Player pl1= new Player("Ciao1");
		Player pl2 =new Player("SCIAAPP");
		Game g= new Game(pl1,pl2,mazzo);
		g.game();
	}
}
