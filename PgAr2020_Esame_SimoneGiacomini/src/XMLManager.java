import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import mazzo.Carta;
import mazzo.Colore;
import mazzo.Tipo;


public class XMLManager {

	public static Collection<Carta> readCities(String filePath) throws XMLStreamException, FileNotFoundException {
		Collection<Carta> mazzo = new ArrayList<Carta>();

		XMLInputFactory xmlif = XMLInputFactory.newInstance();
		XMLStreamReader xmlr = null;

		try {
			xmlr = xmlif.createXMLStreamReader(filePath, new FileInputStream(filePath));

			while (xmlr.hasNext()) {
				
				
				if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("sottomazzo")) {
					 String idColore= xmlr.getAttributeValue(0);
					Colore colore = Colore.valueOf(xmlr.getAttributeValue(1));
					int numeroCarte = Integer.parseInt(xmlr.getAttributeValue(2));
					

					xmlr.nextTag();

					while ((xmlr.getEventType() == XMLStreamConstants.START_ELEMENT)) {
						
						String idCarta= xmlr.getAttributeValue(0);
						
						Tipo tipo= Tipo.valueOf(xmlr.getAttributeValue(1));
						
						int valore= Integer.valueOf(xmlr.getAttributeValue(2));
						
						mazzo.add(new Carta(idColore+idCarta,colore,tipo,valore));
						
						xmlr.nextTag();
						xmlr.nextTag();
					}

					
				}

				xmlr.next();
			}

			xmlr.close();

		} catch (FileNotFoundException | XMLStreamException e) {
			throw e;
		}

		return mazzo;
	}
}
