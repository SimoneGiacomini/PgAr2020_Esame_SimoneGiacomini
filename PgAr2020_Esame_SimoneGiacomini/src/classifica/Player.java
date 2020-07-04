package classifica;

import java.util.Collection;

import mazzo.Carta;

public class Player implements Comparable<Player>{
	
	private Collection<Carta> mano;
	
	private String nome;
	
	private int vittorie=0;
	
	private int sconfitte=0;
	
	private static final int NUMERO_CARTE_INIZIALI=7;

	/**
	 * @return the mano
	 */
	public Collection<Carta> getMano() {
		return mano;
	}

	/**
	 * @param mano the mano to set
	 */
	public void setMano(Collection<Carta> mano) {
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
	
	
}
