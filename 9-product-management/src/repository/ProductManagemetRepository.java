package repository;

import model.Product;

public interface ProductManagemetRepository {
    void saveProduct(Product product);
    Product findProductById(Integer id);
    void updatePrice(Integer id, double price, Product product);
}
