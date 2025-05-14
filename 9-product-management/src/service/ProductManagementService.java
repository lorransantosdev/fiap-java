package service;

import model.Product;
import repository.ProductManagemetRepository;

public class ProductManagementService {
    private final ProductManagemetRepository repository;

    public ProductManagementService(ProductManagemetRepository repository) {
        this.repository = repository;
    }

    public void registerNewProduct(Integer id, String name, double price) {
        repository.saveProduct(new Product(id, name, price));
    }

    public void updatePriceOfProduct(Integer id, double price) {
        repository.updatePrice(id, price, findProduct(id));
    }

    public Product findProduct(Integer id) {
        return repository.findProductById(id);
    }
}
