package gioco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import classifica.Player;
import mazzo.Carta;
import mazzo.CarteSpeciali;
import mazzo.Mazzo;
import mazzo.Tipo;
import util.mylib.BelleStringhe;
import util.mylib.InputDati;
import util.mylib.MyMenu;

public class Game {
/**attributo che identifica il mazzo usato in questo game*/
	private Mazzo mazzo;
/**attributo che identifica il primo player*/
	private Player pl1;
/**attributo che identifica i secondo player*/
	private Player pl2;
/**attributo che identifica il mazzo degli scarti*/
	private Mazzo scarti;
/**{@linkplain String} che spiega quando in mano non si puo' scartare niente*/
	private final static String NIENTE_DA_SCARTARE = BelleStringhe
			.stampaStringCentrato("Non hai carte che possono essere scartate, termini il turno");

	/**costruttore che crea un nuovo game*/
	public Game(Player pl1, Player pl2, Mazzo mazzo) {
		this.pl1 = pl1;
		this.pl2 = pl2;
		this.mazzo = new Mazzo(mazzo.getNome(),mazzo.mischia());
	}

	/**metodo principale che setta tutto a dovere e fa partire il game tra i due player*/
	public void game() {

		System.out.println(pl1.getNome() + " VS " + pl2.getNome());
		mazzo.mischia();
		int first = chiIniziaPerPrimo();

		scarti = new Mazzo("Scarti", mazzo.pesca());

		if (first == 1) {
			gioco(pl1, pl2);
		} else
			gioco(pl2, pl1);

	}
/**	Metodo che simula il lancio dei dadui
 * @return 1 se vince pl1
 * @return 0 se pareggiano
 * @return -1 se vince pl2*/
	private static int lanciaDado() {
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
/**metodo che identifica chi inizia per primo a giocare <br>
 * setta le due mani dei due player in ordine*/
	private int chiIniziaPerPrimo() {

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
/**metodo che setta la mano di un player estrando le carte dal {@linkplain #mazzo}*/
	private void settaCarteIniziali(Player pl) {
		List<Carta> carteIniz = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			carteIniz.add(mazzo.pesca());
		}
		pl.setMano(carteIniz);
	}
/**metodo che fa scontare i due player, riesce ad identificare anche il vincitore*/
	private void gioco(Player primo, Player secondo) {

		while (!(primo.isVincitore() || secondo.isVincitore())) {
			turno(primo, secondo);
			if (primo.isVincitore())
				break;
			turno(secondo, primo);
		}
		System.out.print("Vince");
		if (primo.isVincitore()) {
			System.out.println(primo.getNome());
			primo.vince();
			secondo.perde();
			
		} else {
			System.out.println(secondo.getNome());
			secondo.vince();
			primo.perde();
			
		}
	}
/**metodo che simula un normale turno di Uno, <br>
 * prende in causa tutte le possibili combinazioni(ad esempio se un pl non puo' scartare niente...)*/
	private void turno(Player giocante, Player successivo) {

		if (mazzo.vuoto())
			giraMazzo();

		String inizio = String.format("Turno di %s%nCarta sul banco %s%n", giocante.getNome(), scarti.getCartaInCima());
		InputDati.isInvioPremuto(BelleStringhe.stampaStringaCorniceCentrato(inizio));
		if (!somethingMatch(giocante)) {
			String deviPescare= String.format("Devi pescare una carta%nHai pescato %s", giocante.aggiungiCarta(mazzo.pesca()));
InputDati.isInvioPremuto(BelleStringhe.stampaStringaCorniceCentrato(deviPescare));
		}

		if (somethingMatch(giocante)) {
			MyMenu<Object> scegliCarta = new MyMenu<Object>("QUALE CARTA VUOI SCARTARE?", giocante.getMano().toArray());

			Carta daScartare = (Carta) scegliCarta.scegliSenzaEsciEritornaOpzione();

			while (!daScartare.isMatch(scarti.getCartaInCima())) {
				String noMatch = String.format("Carta scelta non compatibile, riprova%nCarta sul banco %s",
						scarti.getCartaInCima());

				InputDati.isInvioPremuto(BelleStringhe.stampaStringaCorniceCentrato(noMatch));

				daScartare = (Carta) scegliCarta.scegliSenzaEsciEritornaOpzione();

			}
			scarti.inserisciInCima(daScartare);

			if (daScartare.isSpeciale()) {
				cartaSpeciale(successivo, daScartare);
			}

			giocante.rimuoviCarta(daScartare);
			InputDati.isInvioPremuto(
					BelleStringhe.stampaStringaCorniceCentrato("Hai scartato la carta " + daScartare.toString()));
		} else
			InputDati.isInvioPremuto(NIENTE_DA_SCARTARE);
	}
/**Metodo che ciclando sulla mano del player riesce a capire se puo' scartare qualcosa*/
	private boolean somethingMatch(Player pl) {

		for (Iterator iterator = pl.getMano().iterator(); iterator.hasNext();) {
			Carta type = (Carta) iterator.next();
			if (scarti.getCartaInCima().isMatch(type))
				return true;
		}
		return false;
	}
/**In caso il {@link #mazzo} finisse le carte, questo metodo, prendendo le carte dagli scarti, ricostruisce il mazzo*/
	private void giraMazzo() {
		Carta primoScarto = scarti.pesca();
		List<Carta> gliScarti = scarti.mischia();
		this.mazzo = new Mazzo("Mazzo", gliScarti);
		this.scarti = new Mazzo("Scarti", primoScarto);

	}
/**metodo che capisce se la carta passata e' una carta di {@linkplain Tipo} speciale*/
	private void cartaSpeciale(Player ricevente, Carta cartaSpeciale) {
		CarteSpeciali spC = CarteSpeciali.valueOf(cartaSpeciale.getValore());
		switch (spC) {
		case PescaDue:
			ricevente.aggiungiCarta(mazzo.pesca());
			ricevente.aggiungiCarta(mazzo.pesca());
			InputDati.isInvioPremuto(BelleStringhe.stampaStringaCorniceCentrato(ricevente.getNome() + " pesca 2 Carte"));
			break;
		}
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
