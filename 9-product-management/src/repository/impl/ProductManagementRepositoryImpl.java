package repository.impl;

import model.Product;
import repository.ProductManagemetRepository;

import java.util.HashMap;
import java.util.Map;

public class ProductManagementRepositoryImpl implements ProductManagemetRepository {
    private final Map<Integer, Product> storage = new HashMap<>();

    @Override
    public void saveProduct(Product product) {
        storage.put(product.getId(), product);
    }

    @Override
    public Product findProductById(Integer id) {
        return storage.get(id);
    }

    @Override
    public void updatePrice(Integer id, double price, Product product) {
        product.setPrice(price);
        storage.remove(id);
        storage.put(id, product);
    }
}
