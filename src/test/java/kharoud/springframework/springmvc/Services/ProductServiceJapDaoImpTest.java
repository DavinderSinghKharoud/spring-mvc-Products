package kharoud.springframework.springmvc.Services;

import kharoud.springframework.springmvc.Model.Product;
import kharoud.springframework.springmvc.SpringmvcApplication;
import kharoud.springframework.springmvc.config.JpaIntegrationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringmvcApplication.class)
public class ProductServiceJapDaoImpTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void testListMethod() throws Exception{
        List<Product> products = productService.listAllProducts();

        assert products.size() == 1;
    }
}
