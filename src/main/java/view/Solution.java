package view;

import model.Product;
import model.ProductManager;

public class Solution {

	private static ProductManager manager;

	public static void main(String[] args) {

		manager = new ProductManager();
		printProducts();

		System.out.println("---------------------");

		//manager.addProduct("����� (�������) 1/900 ����");
		Product up = manager.getAllProducts().get(1);
		up.setDescr("������� ����� 1/750 ����");
		manager.updateProduct(up);

		printProducts();

	}

	public static void printProducts() {

		for (Integer key : manager.getAllProducts().keySet()) {
			System.out.println(manager.getAllProducts().get(key));
		}

	}

}
