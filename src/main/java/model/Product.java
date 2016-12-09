package model;

public class Product extends Catalog {
	
	public Product(int id, String descr) {
		super(id, descr);
	}

	@Override
	public String toString() {
		return "Product [Id = " + getId() + ", Descr = " + getDescr() + "]";
	}
	
	
	

}
