package zw.co.barneykatakwa.btkspringsecurityexample.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Project Name btk-spring-security-example
 * Developed by bkatakwa
 * Date         11/8/2020
 */
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("products",this.productService.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String createNewProduct(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product){
        this.productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id,Model model){
        model.addAttribute("product",this.productService.findById(id));
        return "edit_product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        this.productService.delete(id);
        return "redirect:/";
    }
}
