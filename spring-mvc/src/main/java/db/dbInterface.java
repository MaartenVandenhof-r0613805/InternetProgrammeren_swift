package db;

import domain.Product;

import java.util.List;

public interface dbInterface {
     Product getProduct(int productId);

     List<Product> getProducts();
     void addProduct(Product product) ;

     void updateProduct(Product product);


     void deleteProduct(int id) ;
}
