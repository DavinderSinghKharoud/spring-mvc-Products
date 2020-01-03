package kharoud.springframework.springmvc;

import kharoud.springframework.springmvc.Controllers.ProductController;
import kharoud.springframework.springmvc.Model.Product;
import kharoud.springframework.springmvc.Services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        //Initialize controllers and mocks
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testList() throws Exception{

        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        //specific Mockito interaction, tell stub to return list of products
        when(productService.listAllProducts()).thenReturn((List) products); //need to strip generics to keep Mockito happy.

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attribute("products", hasSize(2)));

    }

    @Test
    public void testShow() throws Exception{
        Integer id =1;

        when(productService.getProductById(1)).thenReturn(new Product());

        mockMvc.perform(get("/product/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }
}
