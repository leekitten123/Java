package product;

public class ProductDB extends ProductList{
	
	public ProductDB() {
		
		list.add(new Product("Chocolate", 1000));
		list.add(new Product("Water", 800));
		list.add(new Product("Candy", 500));
		list.add(new Product("Pen", 300));
		list.add(new Product("Noodle", 3000));
	}

	public void show() {
		
		for (int i = 0 ; i < list.size() ; i++) {
			
			System.out.println(list.get(i).getName() + " " + list.get(i).getPrice());
		}
	}
}