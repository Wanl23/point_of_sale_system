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
    Product product;

    @Before
    public void setUp() {
        product = new Product(1, "Bread","loaf", 5);
        products = new ArrayList<>();
        productService = new ProductService(products);
    }

    @Test
    public void WhenAddProductItAppearedInProductList() {
        productService.add(product);
        Assert.assertEquals(products.get(0), product);
    }

    @Test
    public void WhenRemoveProductItDisappearFromProductList() {
        products.add(product);
        productService.remove(product);
        Assert.assertTrue(products.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenTryToRemoveProductFromProductListWhereAreNotSuchProductItThrowAnException() {
        productService.remove(product);
    }
}