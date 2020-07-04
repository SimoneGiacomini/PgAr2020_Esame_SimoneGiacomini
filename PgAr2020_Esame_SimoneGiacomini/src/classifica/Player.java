package classifica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mazzo.Carta;

public class Player implements Comparable<Player>{
	
	private List<Carta> mano= new ArrayList<Carta>();
	
	private String nome;
	
	private int vittorie=0;
	
	private int sconfitte=0;
	
	private static final int NUMERO_CARTE_INIZIALI=7;

	/**
	 * @return the mano
	 */
	public List<Carta> getMano() {
		return mano;
	}

	/**
	 * @param mano the mano to set
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
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Player(String nome) {
		setNome(nome);
	}
	
	@Override
	public boolean equals(Object obj) {
	
	if( obj instanceof Player) {
		Player pl= (Player)obj;
		return this.nome.equalsIgnoreCase(pl.nome);
	}
	return false;
	}
	
	
	@Override
	public int compareTo(Player o) {
		return vittorie;
	}
	
	public String toString() {
		return this.nome;
	}
	
	public boolean vince() {
		return mano.isEmpty();
	}
	
	public Carta aggiungiCarta(Carta c) {
		mano.add(c);
		return c;
	}
	
	public boolean rimuoviCarta(Carta c) {
		return mano.remove(c);
	}
}
