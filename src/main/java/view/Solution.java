package view;

import model.Product;
import model.ProductManager;

public class Solution {

	private static ProductManager manager;

	public static void main(String[] args) {

		manager = new ProductManager();
		printProducts();

		System.out.println("---------------------");

		//manager.addProduct("ЗЛАТА (медовый) 1/900 торт");
		Product up = manager.getAllProducts().get(1);
		up.setDescr("МАРКИЗА вишня 1/750 торт");
		manager.updateProduct(up);

		printProducts();

	}

	public static void printProducts() {

		for (Integer key : manager.getAllProducts().keySet()) {
			System.out.println(manager.getAllProducts().get(key));
		}

	}

}
