package product;

import java.util.ArrayList;

public abstract class ProductList {

	protected ArrayList<Product> list = new ArrayList<Product>();
	
	public ProductList() {}
	
	public boolean add(Product product) { return list.add(product); }
	
	public boolean delete(Product product) {
		
		for (int i = 0 ; i < list.size() ; i++) {
			
			if (list.get(i).getName() == product.getName()) {
				
				return list.remove(list.get(i));
			}
		}
	
		return false;
	}
	
	public abstract void show();
	
	public boolean find(String name) {
		
		for (int i = 0 ; i < list.size() ; i++) {
			
			if (list.get(i).getName().equals(name)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	public Product getProduct(String name) {
		
		for (int i = 0 ; i < list.size() ; i++) {
			
			if (list.get(i).getName().equals(name)) {
				
				return list.get(i);
			}
		}
		
		return null;
	}
}