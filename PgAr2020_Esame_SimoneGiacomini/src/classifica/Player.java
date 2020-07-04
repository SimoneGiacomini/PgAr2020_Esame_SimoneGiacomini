package classifica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mazzo.Carta;

public class Player implements Comparable<Player> {

	/**attributo che identifica la mano di carte del giocatore*/
	private List<Carta> mano = new ArrayList<Carta>();
	/**attributo che identifica il nome del giocatore*/
	private String nome;
	/**attributo che identifica le vittorie del giocatore*/
	private int vittorie = 0;
	/**attributo che identifica le sconfitte del giocatore*/
	private int sconfitte = 0;
	/**attributo che identifica il numero totale della carte finali alla sconfitta del giocatore*/
	private int cartefinali = 0;

	/**
	 * @return la mano di carte
	 */
	public List<Carta> getMano() {
		return mano;
	}

	/**
	 * @param mano
	 *            the mano to set
	 */
	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**costruttore*/
	public Player(String nome) {
		setNome(nome);
	}
	/**@return true se il nome dei due player e' uguale, ignorando le lettere maiuscole*/
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Player) {
			Player pl = (Player) obj;
			return this.nome.equalsIgnoreCase(pl.nome);
		}
		return false;
	}

	/**@return il comparatore basato sulle vittorie*/
	@Override
	public int compareTo(Player o) {
		return vittorie;
	}
/**@return una string tipo {@linkplain #nome} + {@linkplain #vittorie} + {@linkplain #sconfitte} + {@linkplain #cartefinali}*/
	public String toString() {
		StringBuilder fine = new StringBuilder(getNome() + ": vittorie:" + vittorie);
		fine.append(" |sconfitte:" + sconfitte + " |media carte in mano a sconfitta:" + getMediaCarteFinali());
		return fine.toString();
	}
/**@return true se il giocatore ha vinto(non ha piu' carte in mano*/
	public boolean isVincitore() {
		return mano.isEmpty();
	}
/**aumenta di uno le vittorie*/
	public void vince() {
		++vittorie;
	}
/**aumenta di uno le sconfitte e aumenta le {@linkplain #cartefinali}*/
	public void perde() {
		++sconfitte;
		aggiungiCarteFinali(this.mano.size());
	}
/**aggiunge una carta alla mano*/
	public Carta aggiungiCarta(Carta c) {
		mano.add(c);
		return c;
	}
/**rimuove una carta dalla mano*/
	public boolean rimuoviCarta(Carta c) {
		return mano.remove(c);
	}
/**aggiunge le carte a {@linkplain #cartefinali} quando perde*/
	public void aggiungiCarteFinali(int n) {
		cartefinali += n;
	}
/**@return la media delle carte finali a sconfitta */
	public int getMediaCarteFinali() {
		return cartefinali / (vittorie + sconfitte);
	}
}
