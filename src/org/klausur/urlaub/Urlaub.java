package org.klausur.urlaub;

public class Urlaub {
	
	private int id;
	private String mitarbeiter;
	private String von;
	private String bis;
	
	public Urlaub(int id, String mitarbeiter, String von, String bis) {
		super();
		this.id = id;
		this.mitarbeiter = mitarbeiter;
		this.von = von;
		this.bis = bis;
	}

	@Override
	public String toString() {
		return "Urlaub [id=" + id + ", mitarbeiter=" + mitarbeiter + ", von=" + von + ", bis=" + bis + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(String mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public String getVon() {
		return von;
	}

	public void setVon(String von) {
		this.von = von;
	}

	public String getBis() {
		return bis;
	}

	public void setBis(String bis) {
		this.bis = bis;
	}

}
