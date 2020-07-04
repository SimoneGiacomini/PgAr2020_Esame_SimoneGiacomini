import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import gioco.Mazzo;




public class Main {

	public static void main(String args[]) throws FileNotFoundException, XMLStreamException {

		Mazzo mazzo= (new Mazzo(XMLManager.readCities("./input/nucleoBaseUnoGiOh.xml")));
		System.out.println(mazzo);
		mazzo.mischia();
		System.out.println(mazzo);
		
	}
}
