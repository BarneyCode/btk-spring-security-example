package zw.co.barneykatakwa.btkspringsecurityexample.product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void delete(Long id);
}
