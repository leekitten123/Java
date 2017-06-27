package product;

public class ProductBuy extends ProductList{
	
	public ProductBuy() {}
	
	public void show() {
		
		for (int i = 0 ; i < list.size() ; i++) {
			
			System.out.println((i+1) + ". " + list.get(i).getName() + " " + list.get(i).getPrice());
		}
	}
	
	public int productSum() {

		int sum = 0;
		
		for (int i = 0 ; i < list.size() ; i++) {
			
			sum += list.get(i).getPrice();
		}
		
		return sum;
	}
}