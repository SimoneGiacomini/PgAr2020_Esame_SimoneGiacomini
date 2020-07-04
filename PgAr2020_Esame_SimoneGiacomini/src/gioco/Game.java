package gioco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import classifica.Player;
import mazzo.Carta;
import util.mylib.MyMenu;

public class Game {

	private Mazzo mazzo;

	private Player pl1;

	private Player pl2;

	private Mazzo scarti;

	private static final String PESCA = "Pesca dal Mazzo";

	public Game(Player pl1, Player pl2, Mazzo mazzo) {
		this.pl1 = pl1;
		this.pl2 = pl2;
		this.mazzo = mazzo;
	}

	public void game() {

		System.out.println(pl1.getNome() + " VS " + pl2.getNome());
		mazzo.mischia();
		int first = chiIniziaPerPrimo();

		scarti = new Mazzo(mazzo.pesca());

		if (first == 1) {
			gioco(pl1, pl2);
		} else
			gioco(pl2, pl1);

	}

	public static int lanciaDado() {
		int pl1 = (util.mylib.EstrazioniCasuali.estraiIntero(0, 6));
		System.out.println("Player 1 " + pl1);
		int pl2 = (util.mylib.EstrazioniCasuali.estraiIntero(0, 6));
		System.out.println("Player 2 " + pl2);
		if (pl1 > pl2)
			return 1;
		if (pl1 < pl2)
			return -1;
		return 0;
	}

	public int chiIniziaPerPrimo() {

		int risultDado = lanciaDado();

		System.out.println("LANCIO DADI");

		while (risultDado == 0) {
			System.out.println("PAREGGIO NEL LANCIO DEI DADI");
			risultDado = lanciaDado();
		}
		if (risultDado == 1) {

			System.out.println(pl1.getNome() + " parte per primo");

			settaCarteIniziali(pl1);
			settaCarteIniziali(pl2);
		} else {

			System.out.println(pl2.getNome() + " parte per primo");

			settaCarteIniziali(pl2);
			settaCarteIniziali(pl1);
		}
		return risultDado;
	}

	public void settaCarteIniziali(Player pl) {
		List<Carta> carteIniz = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			carteIniz.add(mazzo.pesca());
		}
		pl.setMano(carteIniz);
	}

	public void gioco(Player primo, Player secondo) {

		while (!(primo.vince() || secondo.vince())) {
			scartaCarta(primo);
			if(primo.vince())
				break;
			scartaCarta(secondo);
		}
		System.out.print("Vince");
		if (primo.vince())
			System.out.println(primo.getNome());
		else
			System.out.println(secondo.getNome());
	}

	public void scartaCarta(Player pl) {
		
		if(mazzo.vuoto())
			giraMazzo();
			
		System.out.println("Turno di " + pl.getNome());
		System.out.println("Carta sul banco " + scarti.getCartaInCima());
		if (!somethingMatch(pl)) {
			System.out.println("Devi pescare una carta");
			System.out.println("Hai pescato "+pl.aggiungiCarta(mazzo.pesca()));
			
		}

		if (somethingMatch(pl)) {
			MyMenu<Object> scegliCarta = new MyMenu<Object>("QUALE CARTA VUOI SCARTARE?", pl.getMano().toArray());

			Carta daScartare = (Carta) scegliCarta.scegliSenzaEsciEritornaOpzione();

			while (!daScartare.isMatch(scarti.getCartaInCima())) {
				System.out.println("Carta scelta non compatibile, riprova");
				System.out.println("Carta sul banco " + scarti.getCartaInCima());
				daScartare = (Carta) scegliCarta.scegliSenzaEsciEritornaOpzione();

			}
			scarti.inserisciInCima(daScartare);
			pl.rimuoviCarta(daScartare);
			System.out.println("Hai scartato la carta " + daScartare.toString());
		} else
			System.out.println("Non hai carte che possono essere scartate, termini il turno");
	}

	public boolean somethingMatch(Player pl) {

		for (Iterator iterator = pl.getMano().iterator(); iterator.hasNext();) {
			Carta type = (Carta) iterator.next();
			if (scarti.getCartaInCima().isMatch(type))
				return true;
		}
		return false;
	}
	
	public void giraMazzo() {
		Carta primoScarto=scarti.pesca();
		List<Carta> gliScarti= scarti.mischia();
		this.mazzo=new Mazzo(gliScarti);
		this.scarti= new Mazzo(primoScarto);
		
	}

	// public static List<String> insersciPescaAllaFine(Player pl){
	// List<String> fine = new ArrayList<String>();
	// for (Iterator iterator = pl.getMano().iterator(); iterator.hasNext();) {
	// Carta carta = (Carta) iterator.next();
	// fine.add(carta.toString());
	// }
	// fine.add(PESCA);
	// return fine;
	// }
}
