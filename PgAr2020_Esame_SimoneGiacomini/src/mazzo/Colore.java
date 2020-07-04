package mazzo;

public enum Colore {
	blu(0), rosso(1), giallo(2), verde(3);
	private int id;

	Colore(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
