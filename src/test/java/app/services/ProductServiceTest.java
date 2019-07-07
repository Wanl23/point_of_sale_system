package app.services;

import app.Entityes.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    ProductService productService;
    List<Product> products;

    @Before
    public void setUp() {
        products = new ArrayList<>();
        productService = new ProductService(products);

    }

    @Test
    public void WhenAddProductItAppearedInProductList() {
        Product product = new Product(1, "Bread","loaf", 5);
        productService.add(product);
        Assert.assertEquals(products.get(0), product);

    }
}