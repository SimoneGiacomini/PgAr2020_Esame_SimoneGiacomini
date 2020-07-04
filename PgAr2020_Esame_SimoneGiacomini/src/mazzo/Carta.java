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
	
	/**Costruttore*/
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
	 * @param tipo the tipo to set
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

	public void setValore(String valore) {
//	TODO	if (Integer > 9 || valore < 0)
//			throw new IllegalArgumentException("Il valore di una carta puo' essere soltanto tra 0 e 9");
		this.valore = valore;
	}

	/**
	 * @return the colore name
	 */
	public String getColore() {
		return colore.name();
	}

	public boolean equals(Object o) {

		if (o instanceof Carta) {

			Carta carta = (Carta) o;
			return this.id == carta.id;
		}
		return false;
	}

	public boolean isMatch(Carta c) {

		return this.colore.equals(c.colore) || this.valore.equals(c.valore);
	}

	public int hashCode() {
		return id;
	}
	
	public String toString() {
		
		StringBuilder fine= new StringBuilder();
		fine.append(colore.toString()+" ");
		fine.append(tipo.toString()+" ");
		fine.append(valore);
		return fine.toString();
	}

	@Override
	public int compareTo(Carta o) {
		return o.getId()-id;
	}
}
