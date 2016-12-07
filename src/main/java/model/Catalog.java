package model;

public abstract class Catalog {
	private int id;
	private String descr;
	
	public Catalog(int id, String descr) {
		super();
		this.id = id;
		this.descr = descr;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
}
