package db;

import domain.Product;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductJpaDatabase implements dbInterface {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tourismPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Product getProduct(int productId) {

        return entityManager.getReference(Product.class, productId);
    }

    @Override
    public List<Product> getProducts() {
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public void addProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteProduct(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.getReference(Product.class, id));
        entityManager.getTransaction().commit();
    }
}
