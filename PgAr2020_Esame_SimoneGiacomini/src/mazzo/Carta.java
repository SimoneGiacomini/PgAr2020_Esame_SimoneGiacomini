package mazzo;

public class Carta implements Comparable<Carta>  {

	private Colore colore;
	
	private String valore;
	
	private String id;

	private Tipo tipo;
	
	/** Costruttore */
//	public Carta(Colore colore, int valore) {
//
//		this.colore = colore;
//		this.valore = valore;
//	}
//	
	public Carta(String id, Colore colore, Tipo tipo, String valore) {
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
	private void setId(String id) {
	this.id=id;
	}

	public String getId() {
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

		return this.colore.equals(c.colore) || this.valore == c.valore;
	}

	public int hashCode() {
		return id.hashCode();
	}
	
	public String toString() {
		
		StringBuilder fine= new StringBuilder(id+" ");
		fine.append(colore.toString());
		fine.append(' ');
		fine.append(tipo.toString()+" ");
		fine.append(valore);
		return fine.toString();
	}

	@Override
	public int compareTo(Carta o) {
		return colore.compareTo(o.colore);
	}
}
