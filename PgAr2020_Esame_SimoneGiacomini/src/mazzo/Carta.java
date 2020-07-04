package mazzo;
/**Rappresenta una singola carta*/
public class Carta implements Comparable<Carta>  {
/**attributo che identifica il colore della carta*/
	private Colore colore;
	/**Attributo che identifica il valore della carta*/
	private String valore;
	/**Attributo che identifica l'id della carta*/
	private int id;
/**Attributo che identifica il tipo della carta*/
	private Tipo tipo;
	
	/**Costruttore */
	public Carta(int id, Colore colore, Tipo tipo, String valore) {
		setId(id);
		this.colore=colore;
		setTipo(tipo);
		this.setValore(valore);
	}

	/**
	 * @return the tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo da settare
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/** setta l'id della carta */
	private void setId(int id) {
	this.id=id;
	}

	public int getId() {
		return id;
	}

	public String getValore() {
		return valore;
	}
/**@param valore da settare come valore di questa carta*/
	public void setValore(String valore) {

		this.valore = valore;
	}

	/**
	 * @return the colore name
	 */
	public String getColore() {
		return colore.name();
	}
/**@return true se il loro id e' uguale*/
	public boolean equals(Object o) {

		if (o instanceof Carta) {

			Carta carta = (Carta) o;
			return this.id == carta.id;
		}
		return false;
	}
/**@return true se o il colore o il valore tra le due carte e' uguale*/
	public boolean isMatch(Carta c) {

		return this.colore.equals(c.colore) || this.valore.equals(c.valore);
	}
/**@return id*/
	public int hashCode() {
		return id;
	}
	/**@return una String che descrive la carta <br>
	 * @code valore+colore+tipo*/
	public String toString() {
		
		StringBuilder fine= new StringBuilder();
		fine.append(valore+" ");
		fine.append(colore.toString()+" ");
		fine.append(tipo.toString());
		
		return fine.toString();
	}
	/**@return true se il tipo e' {@linkplain Tipo#speciale}*/
	public boolean isSpeciale() {
		return tipo.equals(Tipo.speciale);
	}

	/**@return il compareTo sulle carte<br>
	 * si basa sull'id*/
	@Override
	public int compareTo(Carta o) {
		return o.getId()-id;
	}
}
