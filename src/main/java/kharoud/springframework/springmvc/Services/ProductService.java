package kharoud.springframework.springmvc.Services;

import kharoud.springframework.springmvc.Model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);

}
