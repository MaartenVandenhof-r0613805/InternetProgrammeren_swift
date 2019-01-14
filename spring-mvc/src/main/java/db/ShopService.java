package db;

import java.util.List;

import db.PersonDbInMemory;
import db.ProductDbInMemory;
import db.dbInterface;
import domain.Person;
import domain.Product;

public class ShopService implements  dbInterface{
	private ProductDbInMemory productDb = new ProductDbInMemory();

	public ShopService() {
	}
	@Override
	public Product getProduct(int productId) {
		return productDb.get(productId);
	}

	@Override
	public List<Product> getProducts() {
		return productDb.getAll();
	}

	@Override
	public void addProduct(Product product) {
		productDb.add(product);
	}

	@Override
	public void updateProduct(Product product) {
		productDb.update(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDb.delete(id);
	}

	/////////////////////////////////////////////////////////////////////////////////////

}
