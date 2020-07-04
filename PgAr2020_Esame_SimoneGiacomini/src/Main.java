import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import classifica.Player;
import gioco.Game;
import gioco.Mazzo;




public class Main {

	public static void main(String args[]) throws FileNotFoundException, XMLStreamException {

		Mazzo mazzo= (new Mazzo(XMLManager.readCities("./input/nucleoBaseUnoGiOh.xml")));
		System.out.println(mazzo);
		mazzo.mischia();
		System.out.println(mazzo);
		Player pl1= new Player("Ciao1");
		Player pl2 =new Player("SCIAAPP");
		Game g= new Game(pl1,pl2,mazzo);
		g.game();
	}
}
