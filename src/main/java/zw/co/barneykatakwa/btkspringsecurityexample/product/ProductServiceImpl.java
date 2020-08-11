package zw.co.barneykatakwa.btkspringsecurityexample.product;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project Name btk-spring-security-example
 * Developed by bkatakwa
 * Date         11/8/2020
 */

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Product product = this.productRepository.findById(id).get();
        return product;
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
